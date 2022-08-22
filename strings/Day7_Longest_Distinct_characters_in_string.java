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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        int arr[] = new int[256];
        int start = -1;
        int maxLength = 0;
        Arrays.fill(arr,-1);
        for(int i=0;i<S.length();i++){
            if(arr[S.charAt(i)] != -1){
                start = Math.max(start, arr[S.charAt(i)]);
            }
            arr[S.charAt(i)] = i;
            maxLength = Math.max(maxLength, (i-start));
        }
        return maxLength;
    }
}
