package com.paymentrecommendation.recommender_strategies;

import java.util.*;

import com.paymentrecommendation.enums.PaymentInstrumentType;
import com.paymentrecommendation.models.*;
import com.paymentrecommendation.repository.IBusinessRelevanceOrdering;
import com.paymentrecommendation.repository.IBusinessUseCase;
import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.service.PaymentInstrumentValidator;
import com.paymentrecommendation.service.PaymentRecommender;

public class RelevanceRecommendation implements PaymentRecommender {

  private final IBusinessUseCase businessUseCaseRepository;
  private final IBusinessRelevanceOrdering businessRelevanceOrdering;
  private final PaymentInstrumentValidator paymentInstrumentValidator;

  public RelevanceRecommendation(IBusinessUseCase businessUseCaseRepository, IBusinessRelevanceOrdering businessRelevanceOrdering) {
    this.businessUseCaseRepository = businessUseCaseRepository;
    this.businessRelevanceOrdering = businessRelevanceOrdering;
    this.paymentInstrumentValidator = new PaymentInstrumentValidator();
  }

  public List<PaymentInstrument> recommendPaymentInstruments(final User user, final Cart cart) {
    List<PaymentInstrument> userInstruments = user.getUserPaymentInstrument().getPaymentInstruments();
    List<PaymentInstrument> instruments = getValidInstruments(userInstruments, cart, user);

    BusinessRelevanceOrdering businessRelevanceOrdering = this.businessRelevanceOrdering.getBusinessRelevance(cart.getLineOfBusiness());
    List<PaymentInstrumentType> businessUseCaseInstruments = businessRelevanceOrdering.getbusinessOrdering();

    return prioritizeInstruments(instruments, businessUseCaseInstruments);
  }

  private List<PaymentInstrument> getValidInstruments(List<PaymentInstrument> userInstruments, Cart cart, User user) {
    List<PaymentInstrument> instruments = new ArrayList<PaymentInstrument>();
    for(PaymentInstrument eligibleInstrument: userInstruments) {
      LineOfBusiness lineOfBusiness = cart.getLineOfBusiness();
      BusinessUseCase useCase = businessUseCaseRepository.getBusinessUseCase(lineOfBusiness, eligibleInstrument);
      if(this.paymentInstrumentValidator.isValid(cart, user, useCase)) {
        instruments.add(eligibleInstrument);
      }
    }
    return instruments;
  }


  private List<PaymentInstrument> prioritizeInstruments(List<PaymentInstrument> instrumentList, List<PaymentInstrumentType> businessInstruments) {
    instrumentList.sort(Comparator.comparingDouble(PaymentInstrument::getRelevanceScore).reversed());
    List<PaymentInstrument> result = new ArrayList<>();
    for(PaymentInstrumentType businessInstrument: businessInstruments) {
      List<PaymentInstrument> userInstrumentBucket = new ArrayList<>();
      for(PaymentInstrument instrument: instrumentList) {
        if(instrument.getPaymentInstrumentType().equals(businessInstrument)) {
          userInstrumentBucket.add(instrument);
        }
      }
      result.addAll(userInstrumentBucket);
    }
    return result;
  }
}