package zijietiaodong;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head==null)
            return null;
        ListNode temp=null;
        Stack<ListNode> stack=new Stack();
        while (head!=null){
            temp=head.next;
            head.next=null;
            stack.push(head);
            head=temp;
        }
        ListNode root=stack.pop();
        temp=root;
        while (!stack.isEmpty()){
            temp.next=stack.pop();
            temp=temp.next;
        }
        return root;
    }

    public int findKth(int[] a, int n, int K) {
        // write code here
        Arrays.sort(a);
        return a[n-K];
    }
}

