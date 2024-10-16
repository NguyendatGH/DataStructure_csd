package main.java.com.example.controller;

import java.util.ArrayList;
import java.util.Scanner;

public class Queue_array {

    private ArrayList<Object> elements;
    private int maxQueue;

    public Queue_array() {
        elements = new ArrayList<>(); 
    }

    public void enqueue(Object e) {
        if (elements.size() < maxQueue) { 
            elements.add(e);
        } else {
            System.out.println("Queue is full. Cannot enqueue.");
        }
    }

    public void dequeue() {
        if (!elements.isEmpty()) { 
            elements.remove(0);
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
        }
    }

    public static int generateRandomValue() {
        return (int) (Math.random() * 10) + 1;
    }

    public void createQueue(int n) {
        this.maxQueue = n;
        System.out.println("Create queue success!");
    }

    public void display() {
        if (elements.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            for (Object element : elements) {
                System.out.print(element + ", ");
            }
            System.out.println();
        }
    }

    public static int formatInput(String contentMessage, Scanner sc, int option) {
        int n = -1;
        if (option == 0) {
            while (true) {
                try {
                    System.out.println(contentMessage);
                    n = Integer.parseInt(sc.nextLine());
                    if (n > 0) {
                        break;
                    } else {
                        System.out.println("Input must be > 0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input must be an integer number");
                }
            }
        }

        if (option == 1) {
            while (true) {
                try {
                    System.out.println(contentMessage);
                    n = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Input must be an integer number");
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Queue_array q = new Queue_array();
        Scanner sc = new Scanner(System.in); 

        int n = formatInput("Enter size of queue: ", sc, 0);
        q.createQueue(n);

        for (int i = 0; i < n; i++) {
            q.enqueue(generateRandomValue());
        }

        System.out.println("Store success!");
        q.display();

        while (true) {
            int options = formatInput("Press 1 -> enqueue, 2 -> dequeue, 3 -> end program: ", sc, 0);

            switch (options) {
                case 1: {
                    int tmp = formatInput("Enter value to enqueue: ", sc, 1);
                    q.enqueue(tmp);
                    System.out.println("Success!");
                    break;
                }
                case 2: {
                    q.dequeue();
                    System.out.println("Dequeued successfully!"); 
                    break;
                }
                default: {
                    System.out.println("Invalid option!");
                }
            }
            q.display();
        }
    }
}
