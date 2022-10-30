//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NoOfChicks(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long NoOfChicks(int N)
    {
        // Code here
         if(N==1){
            return 1;
        }
        long dp[] = new long[N+1];
        int  i;
        dp[1]= 1;
        for( i =2; i<=N; i++){
           if(i<=6){
               dp[i] = dp[i-1]*3;
           }else if (i==7){
               dp[7] = 3*dp[6] - 3*dp[1];
           }else{
                dp[i] = dp[i-1]*3 - 2*dp[i-6];

           }
        }
        return dp[N];
    }
}
