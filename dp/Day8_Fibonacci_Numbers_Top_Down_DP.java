//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) 
	{
	    //taking input using Scanner class
	    Scanner sc=new Scanner(System.in);
	    
	    //taking total count of testcases
	    int testcases=sc.nextInt();
	    
	    //initializing base cases
	    long dp[] = new long[100];
	    dp[0]=0;
	    dp[1]=1;
	    dp[2]=1;
	    while(testcases-->0)
	    {
	        //taking nth number
	        int number=sc.nextInt();
	        
	        //creating an object of class Geeks
	        Solution obj=new Solution();
	        
	        //calling findNthFibonacci() method of class
	        //Geeks
	        System.out.println(obj.findNthFibonacci(number, dp));
	        
	    }
	}
}


// } Driver Code Ends
//User function Template for Java



class Solution
{
    //Function to find the nth fibonacci number using top-down approach.
    public long findNthFibonacci(int number, long dp[])
    {
        // Your Code Here
        if(number == 0)
            return 0;
        else if(dp[number]!=0)
            return dp[number];
        else{
            dp[number] = findNthFibonacci(number-1, dp)+findNthFibonacci(number-2, dp);
        }
        return dp[number];
    }

}


//{ Driver Code Starts.



// } Driver Code Ends
