package com.paymentrecommendation.service;

import com.paymentrecommendation.enums.Issuer;
import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.enums.PaymentInstrumentType;
import com.paymentrecommendation.models.BusinessRelevanceOrdering;
import com.paymentrecommendation.models.BusinessUseCase;
import com.paymentrecommendation.models.PaymentInstrument;
import com.paymentrecommendation.repository.IBusinessRelevanceOrdering;
import com.paymentrecommendation.repository.IBusinessUseCase;

import java.util.ArrayList;
import java.util.List;

public class BusinessUseCaseService {

    private final IBusinessUseCase businessUseCase;
    private final IBusinessRelevanceOrdering businessRelevanceOrdering;

    public BusinessUseCaseService(IBusinessUseCase businessUseCase, IBusinessRelevanceOrdering businessRelevanceOrdering) {
        this.businessUseCase = businessUseCase;
        this.businessRelevanceOrdering = businessRelevanceOrdering;
    }

    // Test data
    public void buildData() {
        buildBusinessUseCases();
        buildbusinessOrdering();
    }

    public void buildBusinessUseCases() {
        PaymentInstrument upi = new PaymentInstrument(PaymentInstrumentType.UPI, "1", Issuer.HDFC, "hdfcupi", 8.6);
        BusinessUseCase hdfcUpi = new BusinessUseCase(LineOfBusiness.CREDIT_CARD_BILL_PAYMENT, upi, 2000.0, true);

        PaymentInstrument credCardIcici = new PaymentInstrument(PaymentInstrumentType.CREDIT_CARD, "2", Issuer.ICICI, "icici_credit_card", 7.6);
        BusinessUseCase credCardIciciUseCase = new BusinessUseCase(LineOfBusiness.CREDIT_CARD_BILL_PAYMENT, credCardIcici, 1000.0, true);

        PaymentInstrument credCardHdfc = new PaymentInstrument(PaymentInstrumentType.CREDIT_CARD, "3", Issuer.HDFC, "hdfc_credit_card", 7.9);
        BusinessUseCase credCardHdfcUseCase = new BusinessUseCase(LineOfBusiness.CREDIT_CARD_BILL_PAYMENT, credCardHdfc, 1200.0, true);

        this.businessUseCase.createBusinessUseCase(hdfcUpi);
        this.businessUseCase.createBusinessUseCase(credCardIciciUseCase);
        this.businessUseCase.createBusinessUseCase(credCardHdfcUseCase);
    }

    public void buildbusinessOrdering() {
        List<PaymentInstrumentType> creditCardOrdering = new ArrayList<>();
        creditCardOrdering.add(PaymentInstrumentType.CREDIT_CARD);
        creditCardOrdering.add(PaymentInstrumentType.UPI);
        creditCardOrdering.add(PaymentInstrumentType.DEBIT_CARD);
        BusinessRelevanceOrdering creditCard = new BusinessRelevanceOrdering(LineOfBusiness.CREDIT_CARD_BILL_PAYMENT, creditCardOrdering);
        this.businessRelevanceOrdering.createBusinessRelevance(creditCard);
    }


}
