package com.example.controller;

import com.example.model.Node;

public class CycleLinkedList {

    private Node head;
    
    public void displayNode(String text){
        System.out.println(text);

        Node curr = head;
        int count = 0;
        while(curr != null && count < 10){
            System.out.print(curr.value+", ");
            curr = curr.next;
            count++;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        CycleLinkedList list = new CycleLinkedList();
        list.head  = new Node(1, null);
        Node second = new Node(2, null);
        Node third = new Node(3, null);
        Node fourth = new Node(4, null);

        list.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
        list.displayNode("Displaying nodes:");
    }

}
