package jianzhioffer;

import java.util.*;

public class Demo1 {
    public static void main(String[] args) {
      int[] nums1=new int[]{1,2,3,4};
      int[] nums2=new int[]{2,4,5,6,7,8};
        System.out.println(new Demo1().findMedianSortedArrays(nums1,nums2));;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x) && map.get(x) != i)
                return new int[]{i, map.get(x)};
        }
        return new int[0];
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i1 = 0;
        int i2 = 0;
        int count = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] <= nums2[i2]) {
                nums[count++] = nums1[i1];
                i1++;
            } else {
                nums[count++] = nums2[i2];
                i2++;
            }
        }

        if (i1 < nums1.length) {
            while (i1 < nums1.length) {
                nums[count++] = nums1[i1];
                i1++;
            }
        }

        if (i2 < nums2.length) {
            while (i2 < nums2.length) {
                nums[count++] = nums2[i2];
                i2++;
            }
        }

        System.out.println(Arrays.toString(nums));
        if (nums.length % 2 == 1) {
            return nums[nums.length / 2];
        } else
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
