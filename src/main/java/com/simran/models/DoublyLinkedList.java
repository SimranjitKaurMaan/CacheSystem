package com.simran.models;

public class DoublyLinkedList<E>
{
    DoublyLinkedListNode<E> head;
    DoublyLinkedListNode<E> tail;

    public DoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> dllNode)
    {
        if(head==null)
        {
            head=dllNode;
            tail=dllNode;
        }
        else
        {
        tail.next = dllNode;
        dllNode.previous = tail;
        tail = dllNode;
        }
    }

    public boolean detachNode(DoublyLinkedListNode<E> dllNode)
    {
        if(dllNode.previous!=null && dllNode.next!=null) {
            dllNode.previous.next = dllNode.next;
            dllNode.next.previous = dllNode.previous;
            return true;
        }

        return false;
    }

    public DoublyLinkedListNode<E>   addElementAtLast(E element)
    {
        DoublyLinkedListNode<E> dllNode = new DoublyLinkedListNode<>(element);
        addNodeAtLast(dllNode);
        return dllNode;
    }

    public DoublyLinkedListNode<E> detachFirstNode()
    {
        DoublyLinkedListNode<E> firstNode = head;
        head=head.next;
        firstNode.next = null;
        head.previous=null;

        return firstNode;
    }
}
