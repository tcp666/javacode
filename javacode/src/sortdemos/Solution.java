package sortdemos;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("ab", "ssrbfsfgsdfasadfsdfsfa"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int l1=s1.length();
        int l2=s2.length();
        char[] ss1=s1.toCharArray();
        char[]  ss2=s2.toCharArray();
        if (l1>l2)
            return false;
        int[] arr=new int[26];
        for (int i=0;i<s1.length();i++){
            arr[ss1[i]-'a']++;
        }
        for (int i=0;i<=l2-l1;i++){
            int temp[]=arr.clone();
            for (int j=0;j<l1;j++){
                temp[ss2[j+i]-'a']--;
            }
            boolean flag=true;
            for (int k=0;k<26;k++){
                if (temp[k]!=0){
                    flag=false;
                    break;
                }
            }
            if (flag)
            {
                return true;
            }

        }
      return false;
    }
}