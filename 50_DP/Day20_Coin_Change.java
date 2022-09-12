

// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long[][] dp = new long[N+1][sum+1];
        for(int i=0;i<N+1;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<sum+1;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<N+1;i++){
            for(int j=1; j<sum+1;j++){
                dp[i][j] = dp[i-1][j];
                if(coins[i-1]<=j)
                    dp[i][j] += dp[i][j-coins[i-1]];
            }
        }
        return dp[N][sum];
        /*
        recursive solution
        if(sum == 0)
            return 1;
        if(N == 0)
            return 0;
        long res = count(coins, N-1, sum);
        if(coins[N-1]<=sum)
            res = res + count(coins, N, sum-coins[N-1]);
        return res;*/
    }
}
