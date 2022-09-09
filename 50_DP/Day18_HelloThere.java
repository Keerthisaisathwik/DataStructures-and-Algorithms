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
                    String s = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minStepToDeleteString(s));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minStepToDeleteString(String s) 
	{ 
	    // Your code goes here
	    if(s.length()==0)
	        return 0;
	    if(s.length()==1)
	        return 1; 
	    if(palindrome(s))
	        return 0;
	    else{
	        int result = Integer.MAX_VALUE;
	        StringBuilder sb1 = new StringBuilder(s);
	        while(sb1.charAt(0)==sb1.charAt(sb1.length()-1)){
	            sb1.deleteCharAt(0);
	            sb1.deleteCharAt(sb1.length()-1);
	        }
	        for(int i=0;i<s.length();i++){
	            StringBuilder sb = new StringBuilder(s);
	            sb.deleteCharAt(i);
	            result = Math.min(result, 1+minStepToDeleteString(sb.toString()));
	        }
	        return result;
	    }
	}
	public boolean palindrome(String str){
	    for(int i=0;i<(str.length()+1)/2;i++){
	        if(str.charAt(i)!=str.charAt(str.length()-i-1))
	            return false;
	    }
	    return true;
	}
}
