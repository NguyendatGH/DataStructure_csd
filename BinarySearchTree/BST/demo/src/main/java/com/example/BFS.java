package com.example;
import java.util.LinkedList;
import java.util.Queue;
public class BFS {
    public void bfs(Node node){
        if(node == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node curr = queue.poll(); //get the node out
            System.out.print(" " +curr.value);
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }
    }
}
