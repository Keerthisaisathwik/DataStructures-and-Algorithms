//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minLength(s, n));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution { 
    public int minLength(String s, int n) { 
    	// this problem is similar to "{[()]}" brackets problem using stack
    	Stack<Integer> st = new Stack<>();
    	//similar to assigning '(' with ')' and '[' with ']' we are using array with index
    	//EXAMPLE 1: "index 1" with "2" and "index 2" with "1"
    	//EXAMPLE 2: "index 0" with "9" and "index 9" with "0"
    	int arr[] = {9, 2, 1, 4, 3, 6, 5, 8, 7, 0};
    	for(int i=0;i<s.length();i++){
    	    int k = s.charAt(i)-'0';
    	    if(st.isEmpty()){
    	        st.push(k);
    	    }else{
    	        if(st.peek()==arr[k])
    	            st.pop();
    	        else
    	            st.push(k);
    	    }
    	}
    	return st.size();
    }
}
