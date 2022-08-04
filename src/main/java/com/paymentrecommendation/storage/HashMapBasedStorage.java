package com.paymentrecommendation.storage;

import com.paymentrecommendation.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> storage;    

    public HashMapBasedStorage() {
        storage = new HashMap<Key, Value>();
    }
    
    public void add(Key key, Value value) {        
        storage.put(key, value);
    }
    
    public void remove(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) throw new NotFoundException(key + "doesn't exist in storage.");
        storage.remove(key);
    }

    public Value get(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) throw new NotFoundException(key + "doesn't exist in storage.");
        return storage.get(key);
    }
}
