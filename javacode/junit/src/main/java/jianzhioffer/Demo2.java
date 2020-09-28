package jianzhioffer;


import java.util.ArrayList;
import java.util.List;

public class Demo2 {

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        System.out.println(demo2.findNthDigit(3));;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null)
            return q == null;
        if (q == null)
            return p == null;
        return q.val == p.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        return isMinnor(root, root);

    }

    public boolean isMinnor(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && isMinnor(p.right, q.left) && isMinnor(p.left, q.right);
    }


    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        getAll(list, new String(), 0, 0, n);
        return list;
    }

    private void getAll(List<String> list, String path, int left, int right, int max) {
        if (path.length() == max * 2) {
            list.add(path);
            return;
        }
        if (left < max) {

            getAll(list, path + "(", left + 1, right, max);
        }
        if (right < left) {
            getAll(list, path + ")", left, right + 1, max);

        }
    }

    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[count] != nums[j])
                count++;
            nums[count] = nums[j];
        }
        return count + 1;
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[count++] = nums[j];
            } else
                continue;
        }

        return count + 1;
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        int count = 0;
        int a = dividend > 0 ? dividend : -dividend;
        if (dividend == -2147483648)
            a = 2147483647;
        int b = divisor > 0 ? divisor : -divisor;
        while (a > b) {
            count++;
            a -= b;
        }
        if (dividend > 0 && divisor < 0)
            return -count;
        else if (dividend < 0 && divisor > 0) {
            return -count;
        } else return count;
    }

    public int numWays(int n) {
        if (n < 2)
            return 1;
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            arr[i] %= 1000000007;
        }

        return arr[n];
    }

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        if (numbers[left] < numbers[right]) {
            return numbers[left];
        }
        int m = 0;
        while (left < right) {
            m = (right + left) / 2;
            if (numbers[m] < numbers[right])
                right = m;
            else if (numbers[m] > numbers[right])
                left = m + 1;
            else right--;
        }

        return numbers[m];

    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            int curr = 0;
            for (int j = 1; j < i; j++) {
                curr = Math.max(Math.max(j * (i - j), curr), j * dp[i - j]);
            }
            dp[i] = curr;
        }

        return dp[n];
    }

    public void reverseString(char[] s) {
        if (s.length == 0 || s == null || s.length == 1) {
            return;
        }
        int l = 0;
        int r = s.length - 1;

        while (l < r) {
            s[l] ^= s[r] ^= s[l] ^= s[r];
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1==null)
        return t2;
    if (t2==null)
        return t1;
     t1.val+=t2.val;
     t1.left=mergeTrees(t1.left,t2.left);
     t1.right=mergeTrees(t1.right,t2.right);
     return t1;

    }

    public int findNthDigit(int n) {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<n+1;i++){
            sb.append(i);
        }
        System.out.println(sb.toString());
        char res=sb.toString().charAt(n);
        return res-'0';
    }




    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(int x) {
        if (x<0)
            return false;
        int result=0;
        int temp=x;
        while (x!=0){
            result=result*10+x%10;
            x=x/10;

        }
        return result==temp;
    }
}
