//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.maxSubstring(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int maxSubstring(String S) {
        // code here
        int count = 0;
        int result = 0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='1')
                count--;
            else
                count++;
            if(count<0)
                count=0;
            result = Math.max(count, result);
        }
        if(result == 0)
            return -1;
        return result;
    }
}
