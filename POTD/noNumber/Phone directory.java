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
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        ArrayList<ArrayList<String>> list =new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>();
        HashSet<String> set=new HashSet<>();
        for(String temp:contact) set.add(temp); 
        String st = "";
        for(int i=0;i<s.length();i++) {
            st+=s.charAt(i);//st=st+s.charAt(i);
            ArrayList<String> clist=new ArrayList<>();
            for(String t:set) {
                if(t.length()<i) continue;
                else if(t.length()==i&&st.equals(t)) clist.add(t);
                else if(t.length()>i&&st.equals(t.substring(0,i+1))) clist.add(t);
            }
            if(clist.size()==0) clist.add("0");
            Collections.sort(clist);
            stack.push(i);
            list.add(clist);
        }
        return list;
    }
}
