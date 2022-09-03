//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int[][] dp = new int[str1.length()+1][str2.length()+1];
	    for(int[] line: dp)
	        Arrays.fill(line, -1);
	    int lcsCount = 0;
	    lcsCount = lcs(str1, str2, str1.length(), str2.length(), dp);
	    return str1.length()+ str2.length() - (2*lcsCount);
	}
	
	public int lcs(String str1, String str2, int m, int n, int dp[][]){
	    if(m==0 || n==0)
	        return 0;
	    if(dp[m][n]!=-1)
	        return dp[m][n];
	    int result = 0;
	    if(str1.charAt(m-1)==str2.charAt(n-1)){
	        result = 1+lcs(str1, str2, m-1, n-1, dp);
	        return result;
	    }
	    else
	        return dp[m][n] = result = Math.max(lcs(str1, str2, m-1, n, dp), lcs(str1, str2, m, n-1, dp));
    }
}
