package com.paymentrecommendation.service;

import com.paymentrecommendation.enums.PaymentInstrumentType;
import com.paymentrecommendation.models.*;

public class PaymentInstrumentValidator {
    public boolean isValid(Cart cart, User user, BusinessUseCase useCase) {
        return useCase != null &&
                isAllowedInstrument(useCase)
                && checkCardLimit(cart, useCase)
                && isUserAllowed(user, useCase);
    }

    private boolean isAllowedInstrument(BusinessUseCase useCase) {
        return useCase.getIsAAllowed();
    }

    private boolean checkCardLimit(Cart cart, BusinessUseCase useCase) {
        CartDetail detail = cart.getCartDetail();
        return detail.getCartAmount() < useCase.getLimit();
    }

    private boolean isUserAllowed(User user, BusinessUseCase useCase) {
        if(useCase.getPaymentInstrument().getPaymentInstrumentType().equals(PaymentInstrumentType.UPI)) {
            UserContext userContext = user.getUserContext();
            return userContext.getDeviceContext().isUpiEnabled();
        }
        return true;
    }
}
