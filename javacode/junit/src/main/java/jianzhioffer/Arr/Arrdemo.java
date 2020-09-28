package jianzhioffer.Arr;



//import java.util.*;
//
//public class Arrdemo {
//
//    public static void main(String[] args) {
//        Arrdemo arrdemo=new Arrdemo();
//        int[] arr=new int[]{2,1,1};
//        int[] arr2=new int[]{8,9,5,1};
//        arrdemo.breakfastNumber(arr,arr2,9);
//    }
//    public int maxPoints(int[][] points) {
//        if (points.length < 2) {
//            return points.length;
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int[] x : points) {
//            map.put(x[0] + x[1], 0);
//        }
//        for (int[] x : points) {
//            map.put(x[0] + x[1], map.get((x[0] + x[1])) + 1);
//        }
//
//        ;
//        int[] arr = new int[map.values().size()];
//        int count = 0;
//        for (Integer x : map.values()) {
//            arr[count++] = x;
//        }
//        return arr[arr.length - 1];
//    }
//
//    public int[] exchange(int[] nums) {
//        int left = 0;
//        int right = nums.length - 1;
//
//        while (left < right) {
//            while (nums[left] % 2 == 0 && left < right) left++;
//            while (nums[right] % 2 == 1 && left < right) right++;
//            if (left < right) {
//                int x = nums[left];
//                nums[left] = nums[right];
//                nums[right] = x;
//            } else break;
//            ;
//        }
//
//        return nums;
//    }
//
//    public int majorityElement(int[] nums) {
//
//
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }
//
//
//    public int smallestDifference(int[] a, int[] b) {
//        int res = 0;
//        res = Integer.MAX_VALUE;
//        for (int i = 0; i < a.length; i++) {
//            int temp = 0;
//            for (int j = 0; j < b.length; j++) {
//                if (a[i] > 0 && b[j] < 0 || a[i] < 0 && b[j] > 0)
//                    temp = a[i] + b[j];
//                else
//                    temp = Math.max(a[i], b[j]) - Math.min(a[i], b[j]);
//                res = Math.min(res, temp);
//            }
//        }
//
//        return res;
//    }
//
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        Set<Integer> set = new HashSet<Integer>();
//        for (int x : nums)
//            set.add(x);
//
//        Integer[] result = new Integer[set.size()];
//        set.toArray(result);
//        return result[set.size() - k];
//
//
//    }
//
//    public boolean isUgly(int num) {
//
//        if (num == 2 || num == 3 || num == 5)
//            return true;
//        if (num % 2 == 0)
//            return isUgly(num / 2);
//        else if (num % 5 == 0)
//            return isUgly(num / 5);
//        else if (num % 3 == 0)
//            return isUgly(num / 3);
//        else
//            return false;
//    }
//
//
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<>();
//        boolean[] used = new boolean[nums.length];
//        dfs(lists, nums, new int[nums.length], 0, used);
//        return lists;
//    }
//
//    void dfs(List<List<Integer>> result, int[] nums, int[] path, int dep, boolean[] used) {
//        if (dep == nums.length) {
//            List<Integer> list = new ArrayList<>();
//            for (int x : path)
//                list.add(x);
//            if (result.contains(list))
//                return;
//            result.add(list);
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (used[i])
//                continue;
//            used[i] = true;
//            path[dep] = nums[i];
//            dfs(result, nums, path, dep + 1, used);
//            used[i] = false;
//        }
//    }
//
//
//    public boolean isStr(String s) {
//        if (s.length() <= 1)
//            return false;
//        if (s.charAt(0) != s.charAt(s.length() - 1) && s.charAt(0) != '"')
//            return false;
//        else {
//            for (int i = 1; i < s.length() - 1; i++) {
//                if (s.charAt(i) == '"')
//                    return false;
//            }
//        }
//        return true;
//    }
//
//
//    public boolean isValid(String s) {
//
//        double d=0.0;
//        char[] chars = s.toCharArray();
//        if (chars[0] == ')' || chars[0] == ']' || chars[0] == '}' || chars.length % 2 == 1)
//            return false;
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (stack.isEmpty())
//                stack.push(chars[i]);
//            else {
//                char t = stack.pop();
//                if (t == '(' && chars[i] == ')' || t == '[' && chars[i] == ']' || t == '{' && chars[i] == '}')
//                    continue;
//                else {
//                    stack.push(t);
//                    stack.push(chars[i]);
//                }
//
//            }
//        }
//        return stack.isEmpty();
//    }
//
//    public int breakfastNumber(int[] staple, int[] drinks, int x) {
//        if (staple == null || drinks == null)
//            return 0;
//        Arrays.sort(staple);
//        Arrays.sort(drinks);
//        int count = 0;
//        for (int i = 0; i < staple.length; i++) {
//            if (staple[i] >= x)
//                break;
//            for (int j = 0; j < drinks.length; j++) {
//                if (drinks[j]+staple[i]<= x)
//                    count++;
//                else
//                    break;
//            }
//
//        }
//        return count % 1000000007;;
//    }
//}

