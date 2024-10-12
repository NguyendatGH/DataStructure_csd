package com.example.model;

public class Node {
    public Object infor;
    public Node next;


    public Node(Object x, Node p){
        infor = x;
        next = p;
    }

    public Node(Object x){
        this(x, null);
    }
}
