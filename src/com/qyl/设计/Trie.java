package com.qyl.设计;

/**
 * @Author: qyl
 * @Date: 2021/4/1 16:34
 * 前缀树（重点掌握）
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        char[] letters = word.toCharArray();
        for (char letter : letters) {
            if (!node.containsKey(letter)) {
                node.put(letter, new TrieNode());
            }
            node = node.get(letter);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        char[] letters = word.toCharArray();
        for (char letter : letters) {
            if (node.containsKey(letter)) {
                node = node.get(letter);
            } else {
                return null;
            }
        }
        return node;
    }
}

class TrieNode {

    private TrieNode[] links;
    private boolean end;

    public TrieNode() {
        links = new TrieNode[26];
    }

    public boolean containsKey(char letter) {
        return links[letter - 'a'] != null;
    }

    public void put(char letter, TrieNode node) {
        links[letter - 'a'] = node;
    }

    public TrieNode get(char letter) {
        return links[letter - 'a'];
    }

    public void setEnd() {
        end = true;
    }

    public boolean isEnd() {
        return end;
    }
}
