package com.simran.models;

public class DoublyLinkedListNode<E>
{
    E element;
    DoublyLinkedListNode<E> previous;
    DoublyLinkedListNode<E> next;

    public DoublyLinkedListNode(E element)
    {
        this.element = element;
        this.previous = null;
        this.next = null;
    }

    public E getElement()
    {
        return element;
    }

}
