package com.example.controller;

import com.example.model.Node;

public class SinglyLinkedList {

    private Node head, tail;

    public SinglyLinkedList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    int getListSize() {
        int sizeOfList = 0;
        Node tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            sizeOfList += 1;
        }
        return sizeOfList;
    }

    void clearLinkedList() {
        head = tail = null;
    }

    void addFirst(int value) {
        if (isEmpty()) {
            head = tail = new Node(value, null);
        } else {
            Node newNode = new Node(value, null);
            newNode.next = head;
            head = newNode;
        }
    }

    void addLast(int value) {
        if (isEmpty()) {
            head = tail = new Node(value, null);
        } else {
            Node newNode = new Node(value, null);
            tail.next = newNode;
            tail = newNode;
        }
    }

    void addWithIndex(int index, int value) {
        int size = getListSize();
        if (index < 0 || index > size) {
            return;
        }
        if (isEmpty()) {
            addFirst(value);
            return;
        }

        int pos = 0;
        Node traversNode = head;
        Node newNode = new Node(value, null);

        while (pos < index - 1 && traversNode != null) {
            traversNode = traversNode.next;
            pos += 1;
        }
        if (traversNode != null) {
            newNode.next = traversNode.next;
            traversNode.next = newNode;

            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    void removeFirstNode() {
        if (isEmpty()) {
            System.out.println("list don't have any node, cannot remove!");
        } else if (head.next == null) {
            clearLinkedList();
            System.out.println("list have 1 node ! clear success!");
        } else {
            head = head.next;
            System.out.println("Remove node successfully!");
        }
    }

    void removeLastNode() {
        if (isEmpty()) {
            System.out.println("List don't have any node, cannot remove!");
        } else if (head.next == null) {
            clearLinkedList();
            System.out.println("List have 1 node! remove success!");
        } else {
            Node curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            tail = curr;
            curr.next = null;
        }
    }

    void insertNode(int pos, int val) {
        int size = getListSize();
        if (pos < 0 || pos >= size) {
            throw new Error("out of list");
        }
        if (pos == 0) {
            addFirst(val);
        } else {
            int currIndex = 0;
            Node currNode = head;
            while (currIndex < pos - 1) {
                currNode = currNode.next;
                currIndex++;
            }
            Node newNode = new Node(val, null);
            newNode.next = currNode.next;
            currNode.next = newNode;

        }

    }

    void deleteNode(int pos) {
        int size = getListSize();
        if (pos < 0 || pos >= size) {
            throw new Error("out of list");
        }

        if (pos == 0) {
            removeFirstNode();
        } else {
            int currIndex = 0;
            Node currNode = head;
            while (currIndex < pos - 1) {
                currNode = currNode.next;
                currIndex += 1;
            }
            Node tmp = currNode.next.next;
            currNode.next = tmp;
        }
    }

    void displayNode(String textDisplay) {
        System.out.println("");
        System.out.println(textDisplay);
        Node currNode = head;
        if (isEmpty()) {
            System.out.println("nothing to print out!");
        } else {
            while (currNode != null) {
                System.out.print(currNode.value + ", ");
                currNode = currNode.next;
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        SinglyLinkedList m = new SinglyLinkedList();
        m.addLast(1);
        m.addLast(2);
        m.addLast(3);
        m.addLast(4);
        m.addLast(5);
        m.addLast(6);
        m.addLast(7);
        m.addLast(8);
        m.addLast(9);
        m.addLast(10);
        m.addLast(11);
        m.addLast(12);

        System.out.println("");
        m.displayNode("list before: ");
        m.removeFirstNode();
        m.displayNode("list after remove first node: ");
        m.removeLastNode();
        m.displayNode("list after remove last node: ");

        m.addFirst(10000);
        m.displayNode("Add node at first!");
        m.addWithIndex(3, 10);
        m.displayNode("Add value 10 at index 3: ");

        m.insertNode(3, 99);
        m.displayNode("add value node have value 99 at index 3");

        m.deleteNode(3);
        m.displayNode("remove node have pos = 3 in list: ");
        // System.out.println("clear node: ");
        // m.clearLinkedList();
    }

}
