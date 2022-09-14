//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int arr[], int n)
    {
        // your code here
        int count = 1;
        int curr = arr[0];
        for(int i=1;i<n;i++){
            if(curr==arr[i])
                count ++;
            else
                count--;
            if(count == 0){
                curr=arr[i];
                count=1;
            }
        }
        count=0;
        for(int i=0;i<n;i++){
            if(curr==arr[i]) count ++;
        }
        if(count>n/2) return curr;
        else return -1;
    }
}
