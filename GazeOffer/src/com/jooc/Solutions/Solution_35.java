package com.jooc.Solutions;

import com.jooc.components.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution_35 {

    public void main(){
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

        a.random = null;
        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;

        copyRandomList(a).printAll();
    }


    // simple Copy
    public Node simpleCopyRandomList(Node head) {
        Node res = new Node(0);
        Node pre = res;

        Node current = head;
        while(current != null){
            Node node = new Node(current.val);
            pre.next = node;
            // what about <code>pre.random</code> ??
            pre = pre.next;
            current = current.next;
        }
        return res.next;
    }

    /**
     * Use HashMap to store [OldNode, NewNode] pair group
     *
     * @param head
     * @return
     */
    public Node copyRandomList_0(Node head){
        if(head == null) return null;
        Node current = head;
        Map<Node, Node> map = new HashMap<>();

        while(current != null){
            Node node = new Node(current.val);
            map.put(current, node);
            current = current.next;
        }

        current = head;
        while(current != null){
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }

    public Node copyRandomList(Node head){
        if(head == null) return null;

        Node current = head;
        while(current != null){
            Node tmp = new Node(current.val);
            tmp.next = current.next;
            current.next = tmp;
            current = tmp.next;
        }

        current = head;
        while(current != null){
            if(current.random != null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        Node pre = head;
        current = pre.next;

        Node res = new Node(0);
        res.next = current;

        while(current.next != null){
            pre.next = current.next;
            pre = current.next;
            current.next = pre.next;
            current = current.next;
        }
        pre.next = null;

        return res.next;
    }
}
