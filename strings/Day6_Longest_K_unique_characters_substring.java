//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character, Integer> hm = new HashMap<>();
        int result = -1;
        int count = 0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
               hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
               count++;
            }else{
                hm.put(s.charAt(i), 1);
                count++;
            }
            while(hm.size()>k){
                int n = hm.get(s.charAt(start));
                count--;
                if(n==1)
                    hm.remove(s.charAt(start));
                else
                    hm.put(s.charAt(start), hm.get(s.charAt(start))-1);
                start++;
            }
            if(hm.size()==k)
                result = Math.max(result, count);
        }
        return result;
    }
}
