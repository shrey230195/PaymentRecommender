package com.paymentrecommendation.storage;

import com.paymentrecommendation.exceptions.NotFoundException;

import java.util.ArrayList;


public interface Storage<Key, Value> {
    public void add(Key key, Value value);

    void remove(Key key) throws NotFoundException;

    Value get(Key key) throws NotFoundException;
}