package jianzhioffer.linked;

import com.tcp.datafind.id3.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author TangCaiping
 * @Date 2020/9/12 19:38
 * @Version 1.0
 */
public class Main {
    HashMap<Character, Integer> hsmap = new HashMap<>();
    char[] post = null;

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String str1=sc.nextLine();
//        String str2=sc.nextLine();
//        System.out.println(new Main().buildTree(str1.toCharArray(),str2.toCharArray()));


        Solution solution=new Solution();
        int[] arr=new int[]{100,10,117};
        System.out.println(solution.minNumber(arr)  );
    }

    public String buildTree(char[] inorder, char[] posteroder) {
        for (int i = 0; i < inorder.length; i++) {
            hsmap.put(inorder[i], i);
        }
        post = posteroder;
        String str = "";
        str += buildTree(0, inorder.length - 1, 0, posteroder.length - 1);
        return str;
    }

    public String buildTree(int is, int ie, int ps, int pe) {
        if (ie < is || pe < ps)
            return null;
        char root = post[pe];
        int ri = hsmap.get(root);

        String node = root + "";
        node = buildTree(is, ri - 1, ps, ps + ri - is - 1) + node;
        node = node + buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }




}

class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; ++i)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs,(o1, o2) -> {
            return (o1+o2).compareTo(o2+o1);
        });
        StringBuilder sb = new StringBuilder();
        for(String s: strs)
            sb.append(s);
        return sb.toString();
    }
}
