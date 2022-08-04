package com.paymentrecommendation.factory;

import com.paymentrecommendation.models.BusinessRelevanceOrdering;
import com.paymentrecommendation.repository.BusinessRelevanceOrderingInMemory;
import com.paymentrecommendation.storage.HashMapBasedStorage;

public class BusinessRelevanceOrderingFactory<K,V> {
    public BusinessRelevanceOrderingInMemory<K,V> defaultStorage() {
        return new BusinessRelevanceOrderingInMemory<K,V>(new HashMapBasedStorage<K, V>());
    }
}
