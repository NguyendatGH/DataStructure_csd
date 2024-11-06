package com.example;

import java.util.ArrayList;

public class BuildBalanceTree {

    public void balanceTree(Node root){
        ArrayList<Integer> nodes = new ArrayList<>();
        storeInOrder(root, nodes);
        root = buildBalanceTree(nodes, 0, nodes.size() - 1);
    }

    public void storeInOrder(Node node, ArrayList<Integer> nodes){
        if(node == null) return;
        storeInOrder(node.left, nodes);
        nodes.add(node.value);
        storeInOrder(node.right, nodes);
    }

    public Node buildBalanceTree(ArrayList<Integer> nodes, int start, int end){
        if(start >  end) return null;
        int mid = (start + end)/ 2;
        Node node = new Node(nodes.get(mid));
        node.left = buildBalanceTree(nodes, start, mid - 1);
        node.right = buildBalanceTree(nodes, mid+1, end);
        return node;
    }
}
