//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        int start = 0;
        String str = helper(S);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='.'){
                sb.append(helper(str.substring(start, i)));
                start = i+1;
                sb.append('.');
            }
        }
        sb.append(helper(str.substring(start, str.length())));
        return sb.toString();
    }
    String helper(String str){
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for(int i=0;i<len;i++){
            sb.append(str.charAt(len-i-1));
        }
        return sb.toString();
    }
}
