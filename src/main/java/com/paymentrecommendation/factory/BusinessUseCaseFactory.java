package com.paymentrecommendation.factory;

import com.paymentrecommendation.repository.BusinessUseCaseInMemory;
import com.paymentrecommendation.storage.HashMapBasedStorage;

public class BusinessUseCaseFactory<Key, Value> {
    public BusinessUseCaseInMemory<Key, Value> defaultStorage() {
        return new BusinessUseCaseInMemory<Key, Value>( new HashMapBasedStorage<Key, Value>());
    }
}
