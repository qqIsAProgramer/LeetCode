package com.qyl.栈;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/3/10 9:34
 * @Description:
 */
public class MyCalculator {

    /**
     * 计算接口
     * @param expr
     * @return
     */
    public static int calculate(String expr) {
        List<String> suffixExpr = getSuffixExpr(expr);
        return calSuffixExpr(suffixExpr);
    }

    /**
     * 获取后缀表达式
     * @param expr
     * @return
     */
    private static List<String> getSuffixExpr(String expr) {
        char[] chs = expr.toCharArray();
        int n = chs.length;
        Deque<Character> stack = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (priority(chs[i]) > 0) {
                while (!stack.isEmpty() && priority(chs[i]) <= priority(stack.peek())) {
                    res.add(String.valueOf(stack.pop()));
                }
                stack.push(chs[i]);
                i++;
            } else if (chs[i] == '(') {
                stack.push(chs[i]);
                i++;
            } else if (chs[i] == ')') {
                while (stack.peek() != '(') {
                    res.add(String.valueOf(stack.pop()));
                }
                stack.pop();
                i++;
            } else {
                int num = 0;
                while (i < n && Character.isDigit(chs[i])) {
                    num = num * 10 + (chs[i] - '0');
                    i++;
                }
                res.add(String.valueOf(num));
            }
        }
        while (!stack.isEmpty()) {
            res.add(String.valueOf(stack.pop()));
        }
        System.out.println(res);
        return res;
    }

    /**
     * 计算后缀表达式
     * @param suffixExpr
     * @return
     */
    private static int calSuffixExpr(List<String> suffixExpr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String str : suffixExpr) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                switch (str) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        int x = stack.pop();
                        int y = stack.pop();
                        stack.push(y / x);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    /**
     * 获取运算优先级
     * @param ch
     * @return
     */
    private static int priority(char ch) {
        switch (ch) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String expr = "18-(6+2)/2+4*30";
        System.out.println(MyCalculator.calculate(expr));
    }
}
