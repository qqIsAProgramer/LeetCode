package com.qyl.设计;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qyl
 * @Date: 2021/3/31 9:26
 */
public class LRUCache {

    private int capacity;
    private Map<Integer, DLinkedNode> map;
    private DLinkedList dLinkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        dLinkedList = new DLinkedList();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            dLinkedList.moveToFirst(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedNode node = new DLinkedNode(key, value);
        if (map.containsKey(key)) {
            dLinkedList.remove(map.get(key));
        } else if (capacity == dLinkedList.size()) {
            map.remove(dLinkedList.removeLast().key);
        }
        dLinkedList.addFirst(node);
        map.put(key, node);
    }
}

class DLinkedList {

    DLinkedNode head;
    DLinkedNode tail;

    private int size = 0;

    public DLinkedList() {
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }

    public void addFirst(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        size++;
    }

    public void remove(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        size--;
    }

    public DLinkedNode removeLast() {
        DLinkedNode node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        node.prev = null;
        node.next = null;
        size--;
        return node;
    }

    public void moveToFirst(DLinkedNode node) {
        remove(node);
        addFirst(node);
    }

    public int size() {
        return size;
    }
}

class DLinkedNode {

    int key;
    int value;

    DLinkedNode prev;
    DLinkedNode next;

    public DLinkedNode() {
    }

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
