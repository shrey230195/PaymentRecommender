package com.paymentrecommendation.models;

import com.paymentrecommendation.enums.LineOfBusiness;

public class BusinessUseCase {

  LineOfBusiness lineOfBusiness;

  PaymentInstrument paymentInstrument;

  double limit;

  boolean isAllowed;

  public BusinessUseCase(LineOfBusiness lineOfBusiness, PaymentInstrument paymentInstrument, double limit, boolean isAllowed) {
    this.lineOfBusiness = lineOfBusiness;
    this.paymentInstrument = paymentInstrument;
    this.limit = limit;
    this.isAllowed = isAllowed;
  }

  public void setLineOfBusiness(LineOfBusiness lineOfBusiness) {
    this.lineOfBusiness = lineOfBusiness;
  }

  public boolean getIsAAllowed() {
    return this.isAllowed;
  }

  public double getLimit() {
    return this.limit;
  }

  public LineOfBusiness getLineOfBusiness() {
    return this.lineOfBusiness;
  }

  public PaymentInstrument getPaymentInstrument() {
    return this.paymentInstrument;
  }
}