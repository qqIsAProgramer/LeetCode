package com.qyl.哈希表;

import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author: qyl
 * @Date: 2021/3/13 9:10
 * @Description:
 */
class MyHashSet {

    /**
     * 质数取模：
     * 当元素是个有规律的等差数列时，并且和基数（数组大小）最大公约数不为 1 时，就会造成哈希映射时冲突变高（数组某些位置永远不会有值）
     * 比如数列 0,6,12,18,24...
     * base 为 10，取模放入哈希表中位置将只能在 0,2,4,6,8 这几个数组位置上
     * 但我们如果把 base 取 7（数组大小甚至比 10 小），同样数列可以分布在哈希表中的 0,1,2,3,4,5,6
     * 可以使得哈希表中每个位置都 “有用武之地”
     */
    private static final int BASE = 769;  // 769是一个质数

    private LinkedList[] data;

    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList();
        }
    }

    public void add(int key) {
        int index = hash(key);
        Iterator<Integer> iterator = data[index].iterator();
        while (iterator.hasNext()) {
            Integer elem = iterator.next();
            if (elem == key) {
                return;
            }
        }
        data[index].offerLast(key);
    }

    public void remove(int key) {
        int index = hash(key);
        Iterator<Integer> iterator = data[index].iterator();
        while (iterator.hasNext()) {
            Integer elem = iterator.next();
            if (elem == key) {
                data[index].remove(elem);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        Iterator<Integer> iterator = data[index].iterator();
        while (iterator.hasNext()) {
            Integer elem = iterator.next();
            if (elem == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}
