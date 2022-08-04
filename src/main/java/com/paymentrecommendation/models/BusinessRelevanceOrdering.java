package com.paymentrecommendation.models;

import java.util.List;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.enums.PaymentInstrumentType;

public class BusinessRelevanceOrdering {
  LineOfBusiness lineOfBusiness;
  List<PaymentInstrumentType> relevanceOrdering;

  public BusinessRelevanceOrdering(LineOfBusiness lineOfBusiness, List<PaymentInstrumentType> relevanceOrdering) {
    this.lineOfBusiness = lineOfBusiness;
    this.relevanceOrdering = relevanceOrdering;
    
  }

  public LineOfBusiness getLineOfBusiness() {
    return this.lineOfBusiness;
  }
  public List<PaymentInstrumentType> getbusinessOrdering() {
    return this.relevanceOrdering;
  }
}

