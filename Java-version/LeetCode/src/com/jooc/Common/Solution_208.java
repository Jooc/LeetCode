package com.jooc.Common;

import com.jooc.Solution;

public class Solution_208 implements Solution {
    @Override
    public void main() {

    }

    class TrieNode{
        private TrieNode[] links;

        private final int capacity = 26;

        private boolean isEnd;

        public TrieNode(){
            links = new TrieNode[capacity];
            isEnd = false;
        }

        public boolean contaisKey(char ch){
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch){
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node){
            links[ch - 'a'] = node;
        }

        public void setEnd(){
            isEnd = true;
        }

        public boolean isEnd(){
            return isEnd;
        }
    }

    class Trie {

        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(!node.contaisKey(ch)){
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        private TrieNode searchPrefix(TrieNode root, String prefix){
            TrieNode node = root;
            for(int i = 0; i < prefix.length(); i++){
                char ch = prefix.charAt(i);
                if(node.contaisKey(ch)){
                    node = node.get(ch);
                }else{
                    return null;
                }
            }
            return node;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchPrefix(root, word);
            return node != null && node.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return searchPrefix(root, prefix) != null;
        }
    }




}
