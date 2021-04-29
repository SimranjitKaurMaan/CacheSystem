package com.simran;


import com.simran.exceptions.KeyNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Cache<Key,Value>
{
    private final Map<Key,Value> store ;
    private final IEvictionPolicy<Key> evictionPolicy;
    int capacity;

    public Cache(int capacity,IEvictionPolicy<Key> evictionPolicy)
    {
        this.store = new HashMap<>();
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key, Value value)
    {
        if(capacity==store.size())
        {
            Key keyToRemove = this.evictionPolicy.evictKey();
            store.remove(keyToRemove);
        }
        store.put(key,value);
        this.evictionPolicy.keyAccessed(key);
    }

    public Value get(Key key)
    {
        if(!store.containsKey(key))
        {
            throw new KeyNotFoundException();
        }
        this.evictionPolicy.keyAccessed(key);
        return store.get(key);
    }

    @Override
    public String toString() {
        return "Cache{" +
                "store=" + store +
                '}';
    }

}
