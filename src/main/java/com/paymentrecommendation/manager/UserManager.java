package com.paymentrecommendation.manager;

import com.paymentrecommendation.enums.Issuer;
import com.paymentrecommendation.enums.PaymentInstrumentType;
import com.paymentrecommendation.models.*;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    public User createUser (){
        DeviceContext deviceContext = new DeviceContext(true);
        UserContext userContext = new UserContext(deviceContext);
        PaymentInstrument hdfcUpi = new PaymentInstrument(PaymentInstrumentType.UPI, "1", Issuer.HDFC, "hdfcupi", 8.6);
        PaymentInstrument credCardIcici = new PaymentInstrument(PaymentInstrumentType.CREDIT_CARD, "2", Issuer.ICICI, "icici_credit_card", 7.6);
        PaymentInstrument credCardHdfc = new PaymentInstrument(PaymentInstrumentType.CREDIT_CARD, "3", Issuer.HDFC, "hdfc_credit_card", 7.9);
        PaymentInstrument debitCardHdfc = new PaymentInstrument(PaymentInstrumentType.DEBIT_CARD, "3", Issuer.HDFC, "hdfc_debit_card", 6.9);
        List<PaymentInstrument> instrumentList = new ArrayList<>();
        instrumentList.add(hdfcUpi);
        instrumentList.add(credCardIcici);
        instrumentList.add(credCardHdfc);
        instrumentList.add(debitCardHdfc);
        UserPaymentInstrument userPaymentInstrument = new UserPaymentInstrument(instrumentList);
        User user = new User("1", userContext, userPaymentInstrument);
        return  user;
    }

}
