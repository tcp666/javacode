package sehnzhou;
import java.util.*;


public class Solution {
    /**
     * 求连续子数组的最大和
     * @param array string字符串一维数组 数组
     * @return int整型
     */


    public int findGreatestSumOfSubArray (String[] array) {
        // write code here
        if(array==null||array.length==0)
            throw new RuntimeException();
        Integer[]  arr=new Integer[array.length];
        int max=0;
        for(int i=0;i<array.length;i++){
            arr[i]=new Integer(array[i]);
        }
       for(int i=0;i<arr.length-1;i++){
           for(int j=i+1;j<arr.length;j++){
               int temp=sum(arr,i,j);
               if(temp>max)
                   max=temp;
           }
       }
        
        return max;
    }
    public int sum(Integer[] arr,int left,int right){
        int result=0;
        for(int i=left;i<right+1;i++){
            result+=arr[i];
        }
        return result;
    }

}