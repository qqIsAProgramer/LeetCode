package com.qyl.哈希表;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author: qyl
 * @Date: 2021/3/14 9:47
 * @Description:
 */
public class MyHashMap {

    private class Entry {

        private int key;

        private int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static final int BASE = 769;  // 769是一个质数

    private LinkedList[] data;

    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList();
        }
    }

    public void put(int key, int value) {
        int index = hash(key);
        Iterator<Entry> iterator = data[index].iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.getKey() == key) {
                entry.value = value;
                return;
            }
        }
        data[index].offerLast(new Entry(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        Iterator<Entry> iterator = data[index].iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.getKey() == key) {
                return entry.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Iterator<Entry> iterator = data[index].iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.getKey() == key) {
                data[index].remove(entry);
                return;
            }
        }
    }

    private static int hash(int key) {
        return key % BASE;
    }
}
