//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of steps in stair
            int n = sc.nextInt();
            
            //calling method countWays() of class Hops
            System.out.println(new Solution().countWays(n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        // add your code here
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 4;
        int a = 1;
        int b = 2;
        int c = 4;
        for(int i=4;i<=n;i++){
            int temp = (c+a)%1000000007+b%1000000007;
            a= b;
            b = c;
            c=temp%1000000007;
        }
        return c;
    }
    
}

