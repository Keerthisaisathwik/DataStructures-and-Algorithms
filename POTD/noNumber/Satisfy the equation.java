//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            int[] ptr = ob.satisfyEqn(A,N);
            
            System.out.println(ptr[0] + " " + ptr[1] + " " + ptr[2] + " " + ptr[3]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] satisfyEqn(int[] A, int N) {
        // code here
        int arr[]=new int[N*N];
        int k=0;
        for(int i=0;i<N*N;i++)
            arr[i]=0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++) {
                arr[i*N+j]=A[i]+A[j];
            }
        }
        int c=0;
        HashMap <Integer,Integer> map=new HashMap<>();
        HashMap <Integer,Integer> map2=new HashMap<>();
        int ans[]={-1,-1,-1,-1};
        double min=100000000000000001.0;
        for(int i=0;i<N*N;i++){
            if(map.containsKey(arr[i]) && arr[i]!=0){
                int p1=map.get(arr[i]);
                int p2=i;
                int n1=p1%N,n2=p1/N,n3=p2/N,n4=p2%N;
                if(n1==n3 || n1==n4 || n2==n3 || n2==n4)
                    continue;
                double temp1=(double)p1/N*1000000000.0+(double)p1%N*1000000.0+(double)p2/N*1000.0+(double)p2%N;
                if(min>temp1){
                    ans[0]=p1/N;
                    ans[1]=p1%N;
                    ans[2]=p2/N;
                    ans[3]=p2%N;
                    min=temp1;
                }
            }else{
                map.put(arr[i],i);
            }
        }
        return ans;
    }
};
