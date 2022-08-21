//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String S = read.readLine();
            Solution obj = new Solution();
            System.out.println(obj.printSequence(S));
            
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String printSequence(String S) 
    { 
        // code here
        int arr[] = {2,20,200,3,30,300,4,40,400,5,50,500,6,60,600,7,70,700,7000,8,80,800,9,90,900,9000};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)==' '){
                sb.append(0);
                continue;
            }
            int count = 1;
            int temp = arr[S.charAt(i)-'A'];
            while(temp>10){
                temp = temp/10;
                count++;
            }
            while(count>0){
                sb.append(temp);
                count--;
            }
        }
        return sb.toString();
    }
}
