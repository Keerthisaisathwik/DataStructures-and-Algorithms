// THIS QUESTION NAME IS SAME AS FILE BUT IF YOU DON'T FIND IT THEN SEARCH FOR "Longest Valid Substring"

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
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        // code here
        
        //case (ii):-    FORWARD DIRECTION
        int open = 0;
        int close = 0;
        int maxLength = 0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='(')
                open++;
            else
                close++;
            
            //if close> open makes sure Test-Case:-  ")(" to not work 
            if(close==open)
                maxLength = Math.max(maxLength, 2*open);
            else if(close>open){
                close = 0;
                open = 0;
            }
        }
        
        //case (ii):-    REVERSE DIRECTION
        close = 0;
        open = 0;
        for(int i=S.length()-1;i>=0;i--){
            if(S.charAt(i) == '(')
                open++;
            else
                close++;
            
            if(close==open)
                maxLength = Math.max(maxLength, 2*open);
            else if(open>close){
                close = 0;
                open = 0;
            }
        }
        return maxLength;
    }
};
