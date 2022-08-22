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
            String result = ob.removeDups(s);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String removeDups(String S) {
        // code here
        boolean arr[] = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(arr[S.charAt(i)]==false){
                arr[S.charAt(i)] = true;
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
