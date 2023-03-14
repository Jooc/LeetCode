package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution_101 implements Solution {
    @Override
    public void main() {
        System.out.println(Arrays.toString(LFU(new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 3}, {1, 4, 4}, {2, 4}, {2, 3}, {2, 2}, {2, 1}, {1, 5, 5}, {2, 4}}, 4)));
    }


    class Node {
        int freq = 1;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int size = 0;
    private int leastFreq = -1;

    HashMap<Integer, LinkedList<Node>> freqMap = new HashMap<>();
    HashMap<Integer, Node> nodeMap = new HashMap<>();


    private void update(int key, int val) {
        Node node = nodeMap.get(key);
        node.val = val;

        int freq = node.freq;
        int newFreq = freq + 1;

        freqMap.get(freq).remove(node);
        if (freqMap.get(freq).isEmpty()) {
            freqMap.remove(freq);
            if (leastFreq == freq)
                leastFreq = newFreq;
        }

        node.freq = newFreq;
        if (!freqMap.containsKey(newFreq))
            freqMap.put(newFreq, new LinkedList<>());
        freqMap.get(newFreq).addFirst(node);
    }

    private void set(int key, int val) {
        if (nodeMap.containsKey(key)) {
            update(key, val);
        } else {
            if (size == 0) {
                Node oldNode = freqMap.get(leastFreq).removeLast();
                nodeMap.remove(oldNode.key);
                if (freqMap.get(leastFreq).isEmpty()) {
                    freqMap.remove(leastFreq);
                }
                size++;
            }

            Node node = new Node(key, val);
            nodeMap.put(key, node);

            leastFreq = 1;
            if (!freqMap.containsKey(leastFreq))
                freqMap.put(leastFreq, new LinkedList<>());
            freqMap.get(leastFreq).addFirst(node);

            size--;
        }
    }

    private int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;

        Node node = nodeMap.get(key);
        update(key, node.val);

        return node.val;
    }


    public int[] LFU(int[][] operators, int k) {
        // write code here
        size = k;

        int resLen = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] res = new int[resLen];

        System.out.println(Arrays.toString(res));

        int resIdx = 0;
        for (int[] operator : operators) {
            if (operator[0] == 1)
                set(operator[1], operator[2]);
            else
                res[resIdx++] = get(operator[1]);
        }
        return res;
    }
}
