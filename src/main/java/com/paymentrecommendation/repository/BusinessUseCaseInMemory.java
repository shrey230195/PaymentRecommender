package com.paymentrecommendation.repository;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.models.BusinessUseCase;
import com.paymentrecommendation.models.PaymentInstrument;
import com.paymentrecommendation.storage.Storage;

public class BusinessUseCaseInMemory<K, V> implements IBusinessUseCase {

  private final Storage<K, V> storage;

  public BusinessUseCaseInMemory(Storage<K, V> storage) {
    this.storage = storage;
  }

  public void createBusinessUseCase(BusinessUseCase useCase) {
    String key = useCase.getLineOfBusiness() + useCase.getPaymentInstrument().getName();
    this.storage.add((K) key, (V) useCase);
    System.out.println(this.storage.get((K) key));
  }

  public BusinessUseCase getBusinessUseCase(LineOfBusiness lineOfBusiness, PaymentInstrument instrument) {
    String key = lineOfBusiness + instrument.getName();
    try {
      return (BusinessUseCase) this.storage.get((K) key);
    } catch (Exception e) {
        return null;
    }
  }
}