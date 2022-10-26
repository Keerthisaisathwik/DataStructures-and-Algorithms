//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            
            Solution ob = new Solution();
            System.out.println(ob.minFind(n, a));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minFind(int n, String a[]){
        // code here
        int red = 0;
        int blue = 0;
        int green = 0;
        for(int i=0; i<n; i++){
            if(a[i].equals("R"))
                red++;
            else if(a[i].equals("B"))
                blue++;
            else
                green++;
        }
        if(red == n || blue == n || green == n)
            return n;
        if((green%2==0 && red%2==0 && blue%2==0)||(green%2==1 && red%2==1 && blue%2==1))
            return 2;
        return 1;
    }
}
