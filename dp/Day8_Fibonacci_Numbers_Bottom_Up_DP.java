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
	    while(testcases-->0)
	    {
	        //taking total number of elements
	        int number=sc.nextInt();
	        
	        //creating an object of class Geeks
	        Solution obj=new Solution();
	        
	        //calling findNthFibonacci() method
	        //of class Geeks
	        System.out.println(obj.findNthFibonacci(number));
	        
	    }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the nth fibonacci number using bottom-up approach.
    public long findNthFibonacci(int number)
    {
        // Your Code Here
        long f[] = new long[number+1];
        f[0] = 0;
        f[1] = 1;
        for(int i=2;i<=number;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f[number];
    }

}

