//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
    {
        // your code here
        HashMap<String, Integer> hm = new HashMap<>();
        for(String str: arr){
            hm.put(str, hm.getOrDefault(str, 0)+1);
        }
        int first = 0;
        int second = 0;
        for(Map.Entry<String, Integer> map: hm.entrySet()){
            if(first< map.getValue()){
                second = first;
                first = map.getValue();
            }else if(second< map.getValue() && first> map.getValue())
                second = map.getValue();
        }
        String str = "";
        for(Map.Entry<String, Integer> map: hm.entrySet()){
            if(second==map.getValue()){
                str = map.getKey();
                break;
            }
        }
        return str;
    }
}
