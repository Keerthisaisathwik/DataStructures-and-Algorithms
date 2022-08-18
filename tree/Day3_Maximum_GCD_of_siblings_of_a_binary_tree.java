//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            
            for(int i=0; i<N-1; i++)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                String S[] = read.readLine().split(" ");
                temp.add(Integer.parseInt(S[0]));
                temp.add(Integer.parseInt(S[1]));
                arr.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxBinTreeGCD(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int N) {
        // code here
        int result = 0;
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        for(int i=0;i<arr.size();i++){
            int a = arr.get(i).get(0);
            int b = arr.get(i).get(1);
            if(hm.containsKey(a)){
                hm.get(a).add(b);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(b);
                hm.put(a, list);
            }
        }
        for(Map.Entry<Integer, ArrayList<Integer>> map : hm.entrySet()){
            ArrayList<Integer> temp = map.getValue();
            if(temp.size()==2){
                int a = temp.get(0);
                int b = temp.get(1);
                result = Math.max(result, gcd(a, b));
            }
        }
        return result;
    }
    
    static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
}
