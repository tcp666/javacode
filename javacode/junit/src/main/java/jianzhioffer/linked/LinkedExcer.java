package jianzhioffer.linked;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName LinkedExcer
 * @Description TODO
 * @Author TangCaiping
 * @Date 2020/9/11 0:06
 * @Version 1.0
 */


public class LinkedExcer {
    public static void main(String[] args) {
       int[] stable=new int[]{10,20,5,8,4,3,2};
       int[] drinks=new int[]{8,9,5,1,3,3,4,5,6,7,7};
        System.out.println( breakfastNumber(stable,drinks,15));;
    }

    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        long sum= 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i] >= x)
                break;
            for (int j = 0; j < staple.length; j++) {
                if (drinks[i] + staple[j] <= x)
                    sum++;
                else break;
            }
        }
        return (int)sum % 1000000007;
    }
}
