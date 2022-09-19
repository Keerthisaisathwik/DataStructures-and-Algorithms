//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        int dp[] = new int[size];
        dp[0] = a[0];
        int len = 1;
        for(int i=1;i<a.length;i++){
            if(dp[len-1]<a[i]){
                dp[len] = a[i];
                len++;
            }else{
                int c = binarySearch(0, len-1, dp, a[i]);
                dp[c] = a[i];
            }
        }
        return len;
    }
    
    static int binarySearch(int start, int end, int arr[], int n){
        while(start<end){
            int mid = start+((end-start)/2);
            if(arr[mid]<n)
                start = mid+1;
            else if(arr[mid]>n){
                //here don't forget end=mid
                //because we need celing value not floor value
                end = mid;
            }else
                return mid;
        }
        return start;
    }
} 
