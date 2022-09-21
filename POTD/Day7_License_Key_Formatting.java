//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.ReFormatString(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static String ReFormatString(String S, int K){
        // code here
        S=S.toUpperCase();
        ArrayList<Character> list = new ArrayList<>();
        int i=0;
        while(i<S.length()){
            if(S.charAt(i)!='-')
                list.add(S.charAt(i));
            i++;
        }
        if(list.size()==0)
            return "";
        StringBuilder sb = new StringBuilder();
        i=0;
        int k = list.size()%K;
        if(k==0)
            k=K;
        while(i<k){
            sb.append(list.get(i));
            i++;
        }
        for(;i<list.size();i=i+K){
            sb.append('-');
            for(int j=0;j<K && j+i<list.size();j++){
                sb.append(list.get(j+i));
            }
        }
        //System.out.println(sb.length());
        return sb.toString();
    }
}
