package jianzhioffer.treeDemo;

import javax.swing.*;
import java.util.*;

public class TreeDemo {
    public static void main(String[] args) {
        TreeDemo demo = new TreeDemo();
       demo.combine(4,2);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode r = root;
        while (r != null || !stack.isEmpty()) {
            if (r != null) {
                stack.push(r);
                r = r.left;
            } else {
                r = stack.pop();
                list.add(r.val);
                r = r.right;
            }
        }
        return list;

    }

    public int sumNumbers(TreeNode root) {
        Tool tool = new Tool();
        getSum(root, tool);
        return tool.maxsum;
    }

    public void getSum(TreeNode root, Tool tool) {
        if (root == null) {
            tool.maxsum += tool.minsum;
        }
        if (root.left != null) {
            tool.minsum = tool.minsum * 10 + root.val;
            getSum(root.left, tool);
        }
        if (root.right != null) {
            tool.minsum = tool.minsum * 10 + root.val;
            getSum(root.right, tool);
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        TreeNode node = root;
        getMirro(node);
        return root;
    }

    private void getMirro(TreeNode node) {
        if (node == null)
            return;
        else {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        getMirro(node.left);
        getMirro(node.right);
    }

    public boolean isSymmetric(TreeNode root) {
        return Symmetric(root, root);
    }

    public boolean Symmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && Symmetric(p.left, q.left) && Symmetric(p.right, q.right);
    }

    public String[] permutation(String s) {
        Set<String> set = new HashSet<>();
        int l = s.length();
        char[] chars = s.toCharArray();
        boolean[] used = new boolean[l];
        dfs(chars, "", 0, l, used, set);

        String[] result = new String[set.size()];
        int count = 0;
        for (String x : set)
            result[count++] = x;
        return result;
    }

    private void dfs(char[] chars, String path, int dep, int max, boolean[] used, Set<String> result) {
        if (dep == max) {
            result.add(path);
            return;
        }
        for (int i = 0; i < max; i++) {
            if (used[i])
                continue;
            else {
                used[i] = true;
                dfs(chars, path + chars[i], dep + 1, max, used, result);
                for (int j = 0; j < max; j++) {
                    used[i] = false;
                }
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        int[] creat = new int[n];
        for (int i = 0; i < n; i++) {
            creat[i] = i + 1;
        }
        boolean[] used = new boolean[n];
        List<List<Integer>> lists = new ArrayList<>();
        dfs1(lists, creat, new Integer[k], k, used, 0);
        return lists;
    }


//
//    public  String[] permutation(String s) {
//        List<String> set=new ArrayList<>();
//        int l=s.length();
//        char[] chars=s.toCharArray();
//        boolean[] used=new boolean[l];
//        dfs(chars,"",0,l,used,set);
//
//        String[]result=new String[set.size()];
//        int count=0;
//        for (String x:set)
//            result[count++]=x;
//        return result;
//    }
//
//    private void dfs(char[] chars, String path, int dep, int max, boolean[] used,List<String> result) {
//        if (dep==max){
//            result.add(path);
//            return;
//        }
//        for (int i=0;i<max;i++){
//            if (used[i])
//                continue;
//            else {
//                used[i]=true;
//                dfs(chars,path+chars[i],dep+1,max,used,result);
//                for (int j=0;j<max;j++){
//                    used[i]=false;
//                }
//            }
//        }
//    }

    public void dfs1(List<List<Integer>> result, int[] creat, Integer[] path, int max, boolean[] used, int dep) {
        if (dep == max) {
            List<Integer> temp = new ArrayList<Integer>();
            for (Integer x : path)
                temp.add(x);
            result.add(temp);
            return;
        }
        for (int i = 0; i < creat.length; i++) {
            if (used[i])
                continue;
            else {
                used[i] = true;
                path[dep] = creat[i];
                dfs1(result, creat, path, max, used, dep + 1);
                used[i] = false;
            }

        }
    }

    class Tool {
        int minsum = 0;
        int maxsum = 0;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
