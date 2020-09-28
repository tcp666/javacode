package dp;

/**
 * 确定状态
 * 转移函数
 * 初始条件
 * 计算顺序
 */
public class CoinMinCount {
    public static void main(String[] args) {
//        System.out.println(new CoinMinCount().count1(27));
//        System.out.println(new CoinMinCount().count2(new int[]{2,5,7},24));
        System.out.println(new CoinMinCount().coinChange(new int[]{2, 5, 7}, 24));
    }

    public int count2(int[] A, int M) {
        int[] f = new int[M + 1];
        int n = A.length;
        f[0] = 0;
        for (int i = 1; i <= M; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE)
                    f[i] = Math.min(f[i - A[j]] + 1, f[i]);
            }
        }

        if (f[M] == Integer.MAX_VALUE)
            return -1;
        return f[M];
    }


    int count1(int x) {
        if (x == 0)
            return 0;
        int res = 14;
        if (x >= 2) {
            System.out.print(2 + ",");
            res = Math.min(count1(x - 2) + 1, res);
        }
        if (x >= 5) {
            System.out.println(5 + ",");
            res = Math.min(count1(x - 5) + 1, res);
        }
        if (x >= 7) {
            System.out.println(7 + ",");
            res = Math.min(count1(x - 7) + 1, res);
        }
        return res;
    }


    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }

        }

        if (dp[amount] == Integer.MAX_VALUE)
            return -1;
        return dp[amount];

    }

    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; i++) {
                if (i % 2 == 0) {
                    if (nums[j] > nums[i]) {
                        int temp = nums[j];
                        nums[j] = nums[i + 1];
                        nums[i + 1] = nums[temp];
                        break;
                    }
                }
            }
        }
    }

    public boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;
        if (n == 0) {
            return false;
        }
        boolean flag = true;
        while (n > 1) {
            if (n % 3 == 0) {
                n = n / 3;
            }
            if (n % 3 != 0 && n != 1) {
                flag = false;
                break;
            }
            if (n == 1) {
                return true;

            }
        }
        return flag;

    }


    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i])
                    count++;
            }
        }
        return count;
    }
}
