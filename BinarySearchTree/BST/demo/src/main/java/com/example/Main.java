package com.example;

import java.util.Scanner;

public class Main {

    Node root;

    public void insertNode(int key) {
        root = insertRescurNode(root, key);
    }

    private Node insertRescurNode(Node currentNode, int key) {
        if (currentNode == null) {
            currentNode = new Node(key);
        } else {
            if (currentNode.value > key) {
                currentNode.left = insertRescurNode(currentNode.left, key);
            } else {
                currentNode.right = insertRescurNode(currentNode.right, key);
            }
        }
        return currentNode;
    }

    public void TreeTraversal(Node root) { //using inorder traversal
        inorderTraversalRecursive(root);
    }

    public void inorderTraversalRecursive(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursive(root.left);
        System.out.println(root.value);
        inorderTraversalRecursive(root.right);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Main bst = new Main();
        DelNodeByCopy c = new DelNodeByCopy();
        DelNodeByMerge m = new DelNodeByMerge();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert value into BST: ");
            System.out.println("2. Delete by copying");
            System.out.println("3. Delete by merge");
            System.out.println("4. Display tree");
            System.out.println("5. Exit");
            System.out.print("enter option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    int fixedSize = 0;
                    boolean isContinue = true;
                    while (isContinue) {
                        System.out.print("value ");
                        int value = scanner.nextInt();
                        bst.insertNode(value);
                        System.out.println("added " + value + " to BST.");
                        if (fixedSize == 10) {
                            isContinue = false;
                        }else{
                            fixedSize++;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Delete by copying");
                    System.out.println("enter value to delete: ");
                    int val1 = scanner.nextInt();
                    bst.root = c.deleteNodeByCopying(bst.root, val1);
                    break;
                }
                case 3: {
                    System.out.println("Delete by merge: ");
                    System.out.println("enter value to delete: ");
                    int val2 = scanner.nextInt();
                    bst.root = m.deleteNodeByMerge(bst.root, val2);
                    break;
                }

                case 4: {
                    System.out.println("tree: ");
                    bst.TreeTraversal(bst.root);
                    break;
                }
                case 5: {
                    System.out.println("End!.");
                    scanner.close();
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("invalid option! try again!");
            }
        }
    }
}
