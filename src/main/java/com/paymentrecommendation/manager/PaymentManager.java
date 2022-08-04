package com.paymentrecommendation.manager;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.factory.BusinessRelevanceOrderingFactory;
import com.paymentrecommendation.factory.BusinessUseCaseFactory;
import com.paymentrecommendation.factory.PaymentRecommenderFactory;
import com.paymentrecommendation.models.Cart;
import com.paymentrecommendation.models.PaymentInstrument;
import com.paymentrecommendation.models.User;
import com.paymentrecommendation.repository.IBusinessRelevanceOrdering;
import com.paymentrecommendation.repository.IBusinessUseCase;
import com.paymentrecommendation.service.BusinessUseCaseService;
import com.paymentrecommendation.service.PaymentRecommender;

import java.util.List;

public class PaymentManager<K,V> {
    private final PaymentRecommender paymentRecommender;
    private final UserManager userManager;
    private final CartManager cartManager;

    public PaymentManager() {
        BusinessUseCaseFactory<K,V> businessUseCaseFactory = new BusinessUseCaseFactory<>();
        IBusinessUseCase businessUseCase = businessUseCaseFactory.defaultStorage();
        BusinessRelevanceOrderingFactory<K,V> businessRelevanceOrderingFactory = new BusinessRelevanceOrderingFactory<>();
        IBusinessRelevanceOrdering businessRelevanceOrdering = businessRelevanceOrderingFactory.defaultStorage();
        PaymentRecommenderFactory paymentRecommenderFactory = new PaymentRecommenderFactory();
        this.paymentRecommender = paymentRecommenderFactory.defaultRecommender(businessUseCase, businessRelevanceOrdering);
        this.cartManager = new CartManager();
        this.userManager = new UserManager();
        this.setUp(businessUseCase, businessRelevanceOrdering);
    }

    public List<PaymentInstrument> recommendPaymentInstruments() {
        User user = this.userManager.createUser();
        Cart cart = this.cartManager.createCartForBusiness(LineOfBusiness.CREDIT_CARD_BILL_PAYMENT);

        List<PaymentInstrument> recommendedInstruments = this.paymentRecommender.recommendPaymentInstruments(user, cart);
        for(PaymentInstrument paymentInstrument: recommendedInstruments) {
            System.out.println(paymentInstrument.toString());
        }
        return recommendedInstruments;
    }

    public void setUp(IBusinessUseCase businessUseCase, IBusinessRelevanceOrdering businessRelevanceOrdering) {
        BusinessUseCaseService businessUseCaseService = new BusinessUseCaseService(businessUseCase, businessRelevanceOrdering);
        businessUseCaseService.buildData();
    }
}
