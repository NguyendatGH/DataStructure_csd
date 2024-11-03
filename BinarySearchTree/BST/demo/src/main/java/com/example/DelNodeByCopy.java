package com.example;

public class DelNodeByCopy {

    public Node deleteNodeByCopying(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.value) {
            root.left = deleteNodeByCopying(root.left, key);
        } else if (key > root.value) {
            root.right = deleteNodeByCopying(root.right, key);
        } else {
            if (root.left != null && root.right != null) {
                Node successor = findMin(root.right);
                root.value = successor.value;
                root.right = deleteNodeByCopying(root.right, successor.value);
            } else {
                root = (root.left != null) ? root.left : root.right;
            }
        }
        return root;
    }

    //tim node nho nhat cua cay con ben phai
    public Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
