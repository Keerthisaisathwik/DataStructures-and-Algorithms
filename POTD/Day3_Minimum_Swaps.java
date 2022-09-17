//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 4);
            int n = a[0],k=a[1],b=a[2],T=a[3];
            
            int[] c = IntArray.input(br, a[0]);
            
            
            int[] v = IntArray.input(br, a[0]);
            
            Solution obj = new Solution();
            int res = obj.minimumSwaps(c, v,n,k,b,T);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumSwaps(int[] c, int[] v,int n,int k,int b,int T) {
        //do it on your own
        int SheepUnableToReach = 0;
        int swap = 0;
        for(int i = n-1; i >=0; i--){
            if(c[i]+T*v[i] >= b){
                //This sheep can reach the barn on or before time T
                //So, we'll swap this sheep with all the slower sheep in front of it
                swap += SheepUnableToReach;
                //Now, we've found 1 sheep out of k sheep
                k--;
            }
            else{
                //This sheep can't reach the barn on or before time T
                SheepUnableToReach++;
            }
            if(k==0){
                return swap;
            }
        }
        return -1;
        
    }
}
        
