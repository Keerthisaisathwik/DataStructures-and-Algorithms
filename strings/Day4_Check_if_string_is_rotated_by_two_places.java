//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2)
    {
        // Your code here
        if(str1.length()!=str2.length())
            return false;
        if(str1.length()<3)
            return str1.equals(str2);
        
        int len = str1.length();
        boolean flag = true;
        //case (i) clockwise
        for(int i=0;i<len-2;i++){
            if(str1.charAt(i)!=str2.charAt(i+2))
                flag = false;
        }
        if(str1.charAt(len-1) != str2.charAt(1) || str1.charAt(len-2) != str2.charAt(0))
            flag = false;
        //case (ii) anti-clockwise
        if(flag==false){
            flag = true;
            for(int i=0;i<len-2;i++){
                if(str2.charAt(i)!=str1.charAt(i+2))
                    flag = false;
            }
            if(str2.charAt(len-1) != str1.charAt(1) || str2.charAt(len-2) != str1.charAt(0))
                flag = false;
        }
        return flag;
    }
    
}
