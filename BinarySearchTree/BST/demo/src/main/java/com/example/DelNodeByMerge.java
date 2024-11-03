package com.example;

public class DelNodeByMerge {
   
    public Node deleteNodeByMerge(Node root, int key){
        if(root == null) return null;
        if(key < root.value){
            root.left = deleteNodeByMerge(root.left, key);
        }else if(key > root.value){
            root.right = deleteNodeByMerge(root.right, key);
        }else{
            if(root.left != null && root.right != null){
                Node leftSubTree = root.left;
                Node rightSubTree = root.right;

                Node maxNode = findMax(leftSubTree);
                maxNode.right = rightSubTree;

                return leftSubTree;
            }else{
                root = (root.left != null) ? root.left : root.right;
            }
        }
        return root;
    }
    //tim node co value lon nhat trong cay con trai
    public Node findMax(Node node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }
}
