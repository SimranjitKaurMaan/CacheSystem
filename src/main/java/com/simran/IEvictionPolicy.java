package com.simran;

public interface IEvictionPolicy<Key>
{
    void keyAccessed(Key key);

    Key evictKey();
}
