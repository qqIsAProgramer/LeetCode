package com.qyl.设计;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: qyl
 * @Date: 2021/3/5 15:06
 * @Description: id: 232 level: simple
 * 解法：
 * 将一个栈视为“入栈”，执行 push 操作
 * 另一个视为“出栈”，执行 peek 和 pop 操作
 * 当需要 peek pop 时，就将“入栈”中的元素倒入“出栈”中，即可保证正确顺序
 */
public class MyQueue {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
