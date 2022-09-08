//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.math.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //taking number of elements
		    int n=sc.nextInt();
		   
		    //calling findCatalan() method
		    System.out.println(new Solution().findCatalan(n));
		}
	}
}
// } Driver Code Ends



class Solution
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        //Your code here
        BigInteger f = new BigInteger("1");
        if(n == 0)
            return f;
        for(int i=n+2;i<=2*n;i++){
            f  = f.multiply(BigInteger.valueOf(i));
        }
        for(int i=2;i<=n;i++){
            f = f.divide(BigInteger.valueOf(i));
        }
        return f;
    }
}
