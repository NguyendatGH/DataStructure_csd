package com.example.controller;

import java.util.EmptyStackException;

import com.example.model.Node;

public class Stack_LinkedList {

    protected Node head;

    public Stack_LinkedList() {
        head = null;
    }

    public boolean isEmptyStack() {
        return (head == null);
    }

    public void push(Object x) {
        head = new Node(x, head);
    }

    Object top() throws EmptyStackException {
        if (isEmptyStack()) {
            throw new EmptyStackException();
        }
        return (head.infor);
    }

    public Object pop() throws EmptyStackException {
        if (isEmptyStack()) {
            throw new EmptyStackException();
        }
        Object x = head.infor;
        head = head.next;
        return x;
    }

    public void displayStack(String text) {
        System.out.println(text);
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.infor + ",");
            currNode = currNode.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.println("Stack - linkedlist implementation");
        Stack_LinkedList st_linkedList = new Stack_LinkedList();

        st_linkedList.push(1);
        st_linkedList.push(2);
        st_linkedList.push(3);
        st_linkedList.push(4);
        st_linkedList.push(5);
        st_linkedList.displayStack("Stack: ");


        System.out.println("delete first: ");
        st_linkedList.pop();
        st_linkedList.displayStack("Stack after using pop(): ");

        System.out.println("add first: ");
        st_linkedList.push(100);
        st_linkedList.displayStack("Stack after add new value (100) : ");

       
    }
}
