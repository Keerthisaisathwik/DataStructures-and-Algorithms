//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] leafNodes(int arr[], int n)
    {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        int root=arr[0];
        Stack<Integer> s=new Stack<>();
        s.push(root);
        for(int i=1;i<n;i++){
            if(arr[i]<s.peek()){
                s.push(arr[i]);
            }else{
                int val=s.peek();
                int cnt=0;
                while(!s.isEmpty() && s.peek()<arr[i]){
                    cnt++;
                    s.pop();
                }
                s.push(arr[i]);
                if(cnt>1){
                    list.add(val);
                }
            }
        }
        list.add(s.pop());
        int ans[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}
