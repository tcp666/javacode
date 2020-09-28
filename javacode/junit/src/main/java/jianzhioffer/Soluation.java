package jianzhioffer;

import sun.awt.image.ImageWatched;

import java.util.*;

public class Soluation {
    public static void main(String[] args) {

    }

    public static boolean isHuiWen(String s) {
        if (s.length() == 0)
            return false;
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {
            if (chars[i] != chars[j])
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    /**
     * 找重复数字，
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int x : nums) {
            if (!set.add(x))
                return x;
        }
        return -1;
    }

    /**
     *
     */
    public int findRepeatNumber2(int[] nums) {
        int length = nums.length;
        for (int num : nums) {
            if (num < 0 || num >= length)
                return -1;
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] != i && nums[nums[i]] != nums[i]) {
                int temp = nums[i];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }

            if (nums[i] != i && nums[nums[i]] == nums[i])
                return nums[i];
        }
        return -1;


    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null)
            return false;
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0 || m == 0)
            return false;

        for (int i = 0; i < n; i++) {
            int l = 0, r = m - 1;
            int p = (r + l) / 2;
            if (matrix[i][m - 1] < target)
                continue;
            while (l <= r) {
                if (target == matrix[i][p]) {
                    return true;
                } else if (target > matrix[i][p]) {
                    l = p + 1;
                    p = (r + l) / 2;
                } else {
                    r = p - 1;
                    p = (r + l) / 2;
                }
            }

        }
        return false;
    }

    public String replaceSpace(String s) {
        if (s == null)
            return null;
        int l = s.length();
        int curr = 0;
        char[] arr = new char[l * 3];
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == ' ') {
                arr[curr++] = '%';
                arr[curr++] = '2';
                arr[curr++] = '0';
            } else {
                arr[curr++] = s.charAt(i);
            }
        }
        arr[curr] = '\0';
        return new String(arr, 0, curr);
    }

    public String reverseWords(String s) {
        if (s == null)
            return null;
        /**
         * 消除两边空格
         */
        s = s.trim();

        int i;
        int count = 0;
        char[] chars = new char[s.length()];
        /**
         * 消除中间多余空格
         */
        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ' || s.charAt(i + 1) != ' ')
                chars[count++] = ch;
        }

        int spac = 0;
        int start = 0;

        for (i = 0; i < count; i++) {
            if (chars[i] == ' ') {
                spac = i - 1;
                while (start <= spac) {
                    char t = chars[start];
                    chars[start] = chars[spac];
                    chars[spac] = t;
                    start++;
                    spac--;
                }
                i++;
                start = i;
            }

        }

        i--;

        while (start <= i) {
            char t = chars[start];
            chars[start] = chars[i];
            chars[i] = t;
            start++;
            i--;
        }

        int end = count - 1;
        start = 0;
        while (start <= end) {
            char t = chars[start];
            chars[start] = chars[end];
            chars[end] = t;
            start++;
            end--;
        }
        return String.valueOf(chars, 0, count);


    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int l = 0;
        int z = 0;
        int f = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                z++;
            if (nums[i] < 0)
                f++;
            if (nums[i] == 0)
                l++;
        }
        int result = 1;
        if (l == 0 && f % 2 == 0) {
            for (int i = 0; i < nums.length; i++) {
                result *= nums[i];
            }
            return result;
        }
        int[] resArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int[] temp = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
//                System.out.println("count1:" + count + "i:" + i);
                temp[j] = nums[count + j];
            }
            int teRe = getRes(temp);
            count++;
//            System.out.println("count:"+count);
            while (count < nums.length - i) {

                for (int j = 0; j < i + 1 && count < nums.length; j++) {
//                    System.out.println("count2:" + count + "i:" + i);
                    temp[j] = nums[count + j];
                }
                count++;
                if (getRes(temp) > teRe)
                    teRe = getRes(temp);

            }
            resArr[i] = teRe;

        }

        Arrays.sort(resArr);
        return resArr[nums.length - 1];

    }

    public int getRes(int[] nums) {
        int r = 1;
        for (int i = 0; i < nums.length; i++) {
            r *= nums[i];
        }
        return r;
    }

    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1)
            return 0;
        if (nums[0] > nums[nums.length - 1])
            return nums.length;
        // int[] nums = {[2,1,3,4,5]};
        int rindex = nums.length - 1;
        int lindex = 0;
        int rtemp = rindex;
        int ltemp = 0;
        while (rindex >= 0) {
            rtemp = rindex;
            while (nums[rindex] >= nums[rtemp]) {

                if (rtemp == 0)
                    break;
                rtemp--;
            }
            if (rtemp == 0 && nums[rindex] >= nums[rtemp])
                rindex--;
            else
                break;
            if (rindex == 0)
                return 0;
        }
//        System.out.println(rindex);

        while (lindex < nums.length) {
            ltemp = lindex;
            while (nums[lindex] <= nums[ltemp]) {

                if (ltemp == nums.length - 1)
                    break;
                ltemp++;
            }
            if (ltemp == nums.length - 1 && nums[lindex] <= nums[ltemp])
                lindex++;
            else break;
            if (lindex == nums.length - 1)
                return 0;
        }
//        System.out.println(lindex);
        return rindex - lindex + 1;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (temp[start] + temp[end] < target)
                start++;
            else if (temp[start] + temp[end] > target)
                end--;
            else break;
        }
        if (start < end) {
            int[] result = new int[2];
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == temp[start] || nums[i] == temp[end]) {
                    result[count++] = i;
                    if (count == 2)
                        return result;
                }
            }
        }
        return null;
    }

    //    public int[] intersect(int[] nums1, int[] nums2) {
//        if (nums1.length == 0)
//            return nums1;
//        if (nums2.length == 0)
//            return nums2;
//
//
//
//
//
//
//        List list = new LinkedList();
//        for (int i = 0; i < nums1.length; i++) {
//            list.add(nums1[i]);
//        }
//        int[] result = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
//        int count = 0;
//        for (Integer o : nums2) {
//            if (list.remove(o)) {
//                result[count++] = o;
//            }
//        }
//        int[] f = new int[count];
//        for (int i = 0; i < count; i++)
//            f[i] = result[i];
//      return f;
//    }
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return nums1;
        if (nums2.length == 0)
            return nums2;

        Map<Integer, Integer> map1 = new HashMap();
        int[] t1 = nums1.length > nums2.length ? nums2 : nums1;
        int[] t2 = nums1.length <= nums2.length ? nums2 : nums1;
        for (int x : t1) {
            if (map1.get(x) == null)
                map1.put(x, 1);
            else map1.put(x, map1.get(x) + 1);
        }
        int count = 0;
        for (int X : t2) {
            if (map1.get(X) != null) {
                map1.put(X, map1.get(X) - 1);
                if (map1.get(X) > -1)
                    t1[count++] = X;
            }
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++)
            result[i] = t1[i];

        return result;

    }

    public List<List<Integer>> palindromePairs(String[] words) {
        if (words.length == 0 || words == null)
            return null;

        int num = words.length;
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < num - 1; i++) {
            for (int j = i + 1; j < num; j++) {
                if (isHuiWen(words[i] + words[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }
                if (isHuiWen(words[j] + words[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    list.add(i);
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {

            res[i] = getInt(i);
        }
        return res;
    }

    public int getInt(int x) {
        int count = 0;
        while (x != 0) {
            if ((x & 1) == 1)
                count++;
            x = x >> 1;
        }
        return count;
    }


    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int temp = (right - left) * Math.min(height[left], height[right]);
            if (temp > max)
                max = temp;
            if (height[left] >= height[right]) {
                right--;
            } else
                left++;
        }
        return max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int l = 0;
        int r = nums.length - 1;
        Arrays.sort(nums);


        while (l < r) {
            if (nums[l] == nums[l + 1]) {
                l++;
                continue;
            }
            if (nums[r] == nums[r - 1]) {
                r--;
                continue;
            }
            int target = 0 - nums[l] - nums[r];
            int result = binf(nums, target, l + 1, r - 1);
            if (result != -1) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[l]);
                list.add(nums[r]);
                list.add(nums[result]);
            }
            if (nums[l] + nums[r] > 0)
                r--;
            if (nums[l] + nums[r] < 0) {
                l++;
            }

        }
        return lists;
    }


    public int binf(int[] nums, int taeget, int l, int r) {
        int reslut = -1;
        int m = (l + r) / 2;
        while (l < r) {
            m = (l + r) / 2;
            if (nums[m] < taeget) {
                l = m + 1;
            } else if (nums[m] > taeget) {
                r = m - 1;
            } else return m;
        }

        return reslut;
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);


        return res;
    }


    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            List<Integer> tempRes = new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tempRes.add(node.val);
                temp.add(node);
            }
            res.add(0,tempRes);

            for (int i = 0; i < temp.size(); i++) {
                TreeNode node = temp.get(i);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return res;
    }


    public int multiply(int A, int B) {
        int a = Math.min(A, B);
        int b = Math.max(A, B);
        return getRes(a, b);

    }

    private int getRes(int a, int b) {
        if (a == 0) {
            return 0;
        } else return b + getRes(a - 1, b);
    }


    public int reverse(int x) {
        int result = 0;
        int i = 0;
        while (x != 0) {
            result += x % 10 * Math.pow(10, i - 1);
            i++;
            x = x / 10;
        }
        return result;
    }

    /**
     * public int[] levelOrder(TreeNode root) {
     * if (root == null){
     * return new int[0];
     * }
     * List list = new ArrayList<Integer>();
     * Queue queue = new LinkedList<TreeNode>();
     * queue.add(root);
     * while (!queue.isEmpty()){
     * int size = queue.size();
     * for (int i = 0; i < size; i++) {
     * TreeNode node = (TreeNode) queue.poll();
     * list.add(node.val);
     * if (node.left != null){
     * queue.add(node.left);
     * }
     * if (node.right != null){
     * queue.add(node.right);
     * }
     * }
     * }
     * int[] arr = new int[list.size()];
     * for (int i = 0; i < list.size(); i++) {
     * arr[i] = (Integer) list.get(i);
     * }
     * return arr;
     * <p>
     * }
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList();
        int count = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (count % 2 == 0)
                    temp.addLast(node.val);
                else temp.addFirst(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            lists.add(temp);
            count++;
        }
        return lists;
    }





    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        int result=0;
        return getDep(root,result);
    }
   int  getDep(TreeNode node,int result){
        if (node==null)
            return result;
        result+=1;
        return Math.max(getDep(node.left,result),getDep(node.right,result));
   }



}
