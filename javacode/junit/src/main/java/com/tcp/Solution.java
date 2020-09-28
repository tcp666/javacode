package com.tcp;

import os.bank.Person;

import javax.sound.midi.Soundbank;
import java.util.*;


class ListNode {
    int val;
    ListNode next = null;

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


public class Solution {
    public static void main(String[] args) {
//        ListNode head = new ListNode();
//        head.val = 1;
//        ListNode temp = head;
//        for (int i = 2; i < 6; i++) {
//            temp.next = new ListNode();
//            temp.next.val = i;
//            temp = temp.next;
//        }
//        temp.next = null;
//        System.out.println(head);
//        new Solution().reversePartLinkedlist(head, 1, 3);


//        System.out.println(head);

        System.out.println( new Solution().nthPersonGetsNthSeat(50));
    }

    /**
     * @param head ListNode类 the head
     * @param l    int整型 left
     * @param r    int整型 right
     * @return ListNode类
     */
    public ListNode reversePartLinkedlist(ListNode head, int l, int r) {
        // write code here

        ListNode listNode = new ListNode();
        listNode.next = head;
        ListNode nehead = listNode;
        for (int i = 0; i < l; i++) {
            nehead = nehead.next;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode node = nehead;


        for (int i = 0; i < r - l; i++) {
            stack.push(nehead.val);
            node = node.next;
        }


        while (!stack.isEmpty()) {
            ListNode temp = new ListNode();
            temp.val = stack.pop();
            node.next = temp;
            node = node.next;
        }
        node.next = nehead;
        return head;
    }


    public int[] arrayMerge(int[] array1, int n, int[] array2, int m) {
        // write code here

        int[] result = new int[n + m];
        int l = 0;
        int r = m - 1;
        int count = 0;
        while (l < n && m >= 0) {
            if (array1[l] < array2[r]) {
                result[count++] = array1[l];
                l++;
            }else if(array1[l]>array2[r]){
                result[count++]=array2[r--];

            }
            else {
                result[count++]=array1[l++];
                result[count++]=array2[r--];
            }
        }

        while ((l<n)){
            result[count++] = array1[l];
            l++;
        }

        while (r>=0)
            result[count++]=array2[r--];

        return result;
    }



    public int combination (int r, int n) {
        if(r>n)
            return 0;
        if(r==n)
            return 1;
        // write code here
        long facN=1;
        for(int i=r+1;i<n+1;i++){
            facN*=i;
        }
        long facC=1;
        for(int i=1;i<=n-r;i++){
            facC*=i;
        }
        return (int)(facN/facC);
    }



    public double nthPersonGetsNthSeat(int n) {
        // f(n) = 1 / n + (n - 2) * (1 / n) *  f(n-1)
        double prev = 1;
        double cur = 0;

        for (int i = 2; i <= n; i++) {
            cur = 1.0 / i + (i - 2) * (1.0 / i) * prev;
            prev = cur;
        }

        return prev;
    }


    Set<Person> personSet=new TreeSet<>();

}