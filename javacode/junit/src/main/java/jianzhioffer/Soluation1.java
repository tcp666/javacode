package jianzhioffer;

import java.util.Map;

public class Soluation1 {


    public static void main(String[] args) {
        int[] fib = new int[50];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < 50; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        for (int x : fib)
            System.out.print(x + "\t" );
        System.out.println("***************************************888" );
        System.out.println(trailingZeroes(30));

    }


    public static int trailingZeroes(int n) {
        int five = 0;
        for (int i = 1; i < n + 1; i += 2) {
            if (i % 5 == 0) {
                five++;
            }
        }
        return five + n / 10;


    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null)
            return l1;
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                temp.next = new ListNode(l1.val, null);
                l1 = l1.next;
                temp = temp.next;
            } else {
                temp.next = new ListNode(l2.val, null);
                l2 = l2.next;
                temp = temp.next;
            }
        }
        if (l1 == null)
            temp.next = l2;
        if (l2 == null)
            temp.next = l1;
        return head.next;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        int x = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                x++;
            }
        }
        if (x == 0)
            return null;
        int index = findMin(lists);
        ListNode head = new ListNode(lists[findMin(lists)].val);
        head.next = null;
        ListNode temp = head;
        lists[index] = lists[index].next;
        boolean flag = false;


        while (!flag) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    flag = true;
                    continue;
                } else {
                    flag = false;
                }

                if (!flag) {
                    index = findMin(lists);
                    temp.next = new ListNode(lists[findMin(lists)].val);
                    lists[index] = lists[index].next;
                    temp = temp.next;
                    flag = false;
                }

            }
        }
        temp.next = null;
        return head;

    }

    public int findMin(ListNode[] listNodes) {
        int index = 0;
        for (int i = 0; i < listNodes.length; i++)
            if (listNodes[i] != null)
                index = i;

        for (int i = 0; i < listNodes.length; i++) {
            if (listNodes[i] == null)
                continue;
            if (listNodes[index].val >= listNodes[i].val) {
                index = i;
            }
        }


        return index;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int[] arr = new int[255];
        for (int i = 0; i < s3.length(); i++) {
            arr[s3.charAt(i)]++;
        }
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i)]--;
        }
        for (int i = 0; i < s2.length(); i++) {
            arr[s2.charAt(i)]--;
        }

        boolean res = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                res = false;
                break;
            }
        }
        return res;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
