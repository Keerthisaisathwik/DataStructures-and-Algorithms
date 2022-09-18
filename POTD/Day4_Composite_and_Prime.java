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
            String[] S = br.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int ans = ob.Count(L, R);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int Count(int L, int R)
    {
        // code here
        if(L==1)
            L++;
        int prime = 0;
        int composite = 0;
        for(int i=L;i<=R;i++){
            if(isPrime(i))
                prime++;
            else
                composite++;
        }
        return composite-prime;
    }
    
    boolean isPrime(int n)
    {
        if(n==2||n==3)
            return true;
        if(n%2==0||n%3==0)
            return false;
        for(int i=5;i*i<=n;i=i+6)
        {
            if(n%i==0)
                return false;
            if(n%(i+2)==0)
                return false;
        }
        return true;
    }
}
