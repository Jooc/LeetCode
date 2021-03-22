package com.jooc.components;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public Node random;
    public Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    public void printAll(){
        Node current = this;

        List<Integer> res = new ArrayList<>();
        while(current != null){
            res.add(current.val);
            current = current.next;
        }

        System.out.println(res.toString());
    }
}
