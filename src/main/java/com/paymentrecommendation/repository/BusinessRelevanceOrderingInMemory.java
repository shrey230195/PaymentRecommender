package com.paymentrecommendation.repository;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.models.BusinessRelevanceOrdering;
import com.paymentrecommendation.models.BusinessUseCase;
import com.paymentrecommendation.models.PaymentInstrument;
import com.paymentrecommendation.storage.Storage;

public class BusinessRelevanceOrderingInMemory<K, V> implements IBusinessRelevanceOrdering {

  private final Storage<K, V> storage;

  public BusinessRelevanceOrderingInMemory(Storage<K, V> storage) {
    this.storage = storage;
  }

  public void createBusinessRelevance(BusinessRelevanceOrdering useCase) {
    this.storage.add((K) useCase.getLineOfBusiness(), (V) useCase);
  }

  public BusinessRelevanceOrdering getBusinessRelevance(LineOfBusiness lineOfBusiness) {
    return (BusinessRelevanceOrdering) this.storage.get((K) lineOfBusiness);
  }
}