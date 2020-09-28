package jianzhioffer.dp;

public class DpDemo {
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

    public int waysToChange(int n) {
        if(n==0)
            return 0;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        int[] coins=new int[]{1,5,10,25};
        for (int i=2;i<n+1;i++){
            int curr=0;
            for(int x:coins)
                if(i>x){
                    curr=Math.max(dp[x]+dp[i-x],curr);
                }
            dp[i]=curr;

        }

        return dp[n];
    }

}
