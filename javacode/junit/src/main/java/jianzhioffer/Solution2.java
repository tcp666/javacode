package jianzhioffer;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution2 {
    public static int reverse(int x) {
        Stack<Integer> stack = new Stack<>();
        while (x != 0) {
            stack.push(x % 10);
            x = x / 10;
        }
        int size = stack.size();

        int result = 0;
        for (int i = 0; i < size; i++) {
            result += stack.pop() * Math.pow(10, i);
        }
        if (result >= 2147483647)
            return 0;
        if (result == -2147483648)
            return 0;
        if (x < 0)
            return -result;
        return result;
    }

    public static void main(String[] args) {

    }



}