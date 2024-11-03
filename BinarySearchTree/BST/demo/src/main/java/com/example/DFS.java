package com.example;

public class DFS {
    public void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOder(Node node){
        if(node == null) return;
        inOder(node.left);
        System.out.print(" " +node.value);
        inOder(node.right);
    }

    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(" " +node.value);
    }
}
