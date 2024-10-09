package com.example.controller;
//array implementation of a stack dataStructure;

import java.util.EmptyStackException;

public class Stack_ArrayList {

    protected Object[] a;
    int top, max;

    public Stack_ArrayList() {
        this(50); // this stack was create with size = 50;
    }

    public Stack_ArrayList(int max1) {
        max = max1;
        a = new Object[max];
        top -= 1;
    }

    protected boolean grow() {
        int max1 = max + max / 2;
        Object[] a1 = new Object[max1];
        if (a1 == null)  return false;


        for (int i = 0; i <= top; i++) {
            a1[i] = a[i];

        }
        a = a1;
        return true;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == max - 1);
    }

    public void clearStack() {
        top = -1;
    }

    public void push(Object x) {
        if (isFull() && !grow()) {
            return;
        }
        a[++top] = x;
    }

    Object top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (a[top]);
    }

    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object x = a[top];
        top--;
        return x;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("stack is empty!");
        } else {
            System.out.println("Stack element: ");
            for(int i = top; i >= 0; i--){
                System.out.print(a[i] + ",");
            }
        }
    }

    public static void main(String[] args) {
        Stack_ArrayList stack = new Stack_ArrayList(5);

        //add data to stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        //print stack data
        stack.printStack();
        System.out.println("");
        
        //printout the first element value , not delete it
        System.out.println("Top element: " + stack.top());

        //add more 1 value, stack will increase size
        stack.push(6);
        stack.printStack();
        System.out.println("");


        //print value of the top value, this value would be delete after print
        System.out.println("Popped element: " + stack.pop());

        //print top value, after delete the previouos top
        System.out.println("Top element after pop: " + stack.top());

        //clear stack
    
        stack.clearStack();
        System.out.println("Clear stack success!");
        System.out.println("Is stack empty after clearing? " + stack.isEmpty());
    }
}
