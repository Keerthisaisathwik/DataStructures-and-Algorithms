//{ Driver Code Starts
//Code by Saksham Raj Seth
import java.util.*;
import java.lang.Math;
class Min{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			GfG g=new GfG();
			System.out.println(g.minSum(a,n));
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	public static int minSum(int arr[], int n)
        {
            //add code here.
            if(n==1)
                return arr[0];
            if(n==2)
                return Math.min(arr[0], arr[1]);
            if(n==3)
                return Math.min(arr[0], Math.min(arr[1], arr[2]));
            if(n==4)
                return Math.min(Math.min(arr[0], arr[1]), Math.min(arr[2], arr[3]));
            int dp[] = new int[n];
            dp[0] = arr[0];
            dp[1] = arr[1];
            dp[2] = arr[2];
            dp[3] = arr[3];
            for(int i=4;i<n;i++){
                dp[i] = arr[i];
                dp[i] = dp[i] + Math.min(Math.min(dp[i-1], dp[i-2]), Math.min(dp[i-3], dp[i-4]));
            }
            return Math.min(Math.min(dp[n-1], dp[n-2]), Math.min(dp[n-3], dp[n-4]));
        }
}
