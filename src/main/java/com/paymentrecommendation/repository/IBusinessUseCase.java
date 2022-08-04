package com.paymentrecommendation.repository;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.models.BusinessUseCase;
import com.paymentrecommendation.models.PaymentInstrument;

public interface IBusinessUseCase {
  void createBusinessUseCase(BusinessUseCase useCase);

  BusinessUseCase getBusinessUseCase(LineOfBusiness lineOfBusiness, PaymentInstrument instrument);
}