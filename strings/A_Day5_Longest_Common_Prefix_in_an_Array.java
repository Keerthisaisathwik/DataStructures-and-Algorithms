/*
Expected Time Complexity: O(N*max(|arri|)).
Expected Auxiliary Space: O(max(|arri|)) for result.
*/
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
        int len = Integer.MAX_VALUE;
        String string = null;
        int result = -1;
        for(String str : arr){
            len = Math.min(len, str.length());
            if(len == str.length())
                string = str;
        }
        outerloop:
        for(int i=0;i<len;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j].charAt(i)!=string.charAt(i)){
                    break outerloop;
                }
            }
            result++;
        }
        if(result>=0)
            return string.substring(0,result+1);
        else
            return "-1";
    }
}
