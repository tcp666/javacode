package bianlifeng;


import java.util.*;

/**
 * @ClassName Main
 * @Description TODO
 * @Author TangCaiping
 * @Date 2020/9/18 16:55
 * @Version 1.0
 */
public class Main {
    public int count = 0;

    public int getSum(int[] product, int money) {
        get(product, money, 0,0);
        return count;
    }

    public void get(int[] product, int money, int path,int curr) {
        if (path > money)
            return;
        if (path == money) {
            count++;
            return;
        }
        if (path < money) {
            for (int i = 0; i < product.length; i++) {
                get(product, money, path + product[i],curr);
            }
            return;
        }
    }

    public static void main(String[] args) {
        int[] product=new int[]{1,2};
        System.out.println(getCnt(product, 4));
    }

    public static int getCnt(int[] product, int money) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < product.length; i++) {
            queue.add(product[i]);
            set.add(product[i]);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == money) {
                cnt++;
                continue;
            }
            for (int i = 0; i < product.length; i++) {
                int next = poll + product[i];
                if (set.contains(next) || next > money) {
                    continue;
                }
                queue.add(next);
            }
        }
        return cnt;
    }

}
