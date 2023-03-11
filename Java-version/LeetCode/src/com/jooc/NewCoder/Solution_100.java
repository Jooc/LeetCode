package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.HashMap;

public class Solution_100 implements Solution {
    @Override
    public void main() {
        Solution_100 s = new Solution_100(2);
    }

    class Node {
        Node pre;
        Node next;

        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private int size = 0;
    //    private int[] recorder;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> memory;
    //    private HashMap<Integer, Integer> recorder;

    public Solution_100(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, -1);
        this.tail = new Node(-1, 0);
        head.next = tail;
        head.pre = tail;
        tail.next = head;
        tail.pre = head;
        memory = new HashMap<>();
    }

    private void moveNodeToHead(Node node) {
        node.pre.next = node.next;
        if (node.next != null) node.next.pre = node.pre;

        insertNewNode(node);
    }

    private void insertNewNode(Node node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    public int get(int key) {
        // write code here
        if (!memory.containsKey(key)) {
            System.out.println(-1);
            return -1;
        }

        moveNodeToHead(memory.get(key));
        System.out.println(memory.get(key).val);
        return memory.get(key).val;
    }

    private Node removeLastNode() {
        Node node = tail.pre;
        node.pre.next = tail;
        tail.pre = node.pre;

        return node;
    }


    public void set(int key, int value) {
        // write code here

        if (!memory.containsKey(key)) {
            Node node = new Node(key, value);
            insertNewNode(node);
            memory.put(key, node);
            size++;
        } else {
            moveNodeToHead(memory.get(key));
            if(memory.get(key).val != value){
                memory.get(key).val = value;
            }
        }

        if (size > capacity) {
            Node removedNode = removeLastNode();
            memory.remove(removedNode.key);
            size--;
        }
    }
}
