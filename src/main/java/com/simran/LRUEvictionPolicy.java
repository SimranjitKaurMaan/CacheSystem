package com.simran;

import com.simran.models.DoublyLinkedList;
import com.simran.models.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements IEvictionPolicy<Key>
{
    DoublyLinkedList<Key> dll;
    Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key)
    {
        if(mapper.containsKey(key))
        {
            DoublyLinkedListNode<Key> dllNode = mapper.get(key);
            boolean detached = dll.detachNode(dllNode);
            if(detached) {
                dll.addNodeAtLast(dllNode);
            }
        }else {
            DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
            mapper.put(key, newNode);
        }
    }

    @Override
    public Key evictKey()
    {
       DoublyLinkedListNode<Key> firstNode= dll.detachFirstNode();
       mapper.remove(firstNode.getElement());

       return firstNode.getElement();
    }
}
