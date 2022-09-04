import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinCuts {

	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk1.nextToken());
		int value = Integer.parseInt(stk1.nextToken());
		int arr[] = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i =0;i<n;i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		int dp[] = new int[value+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		System.out.println(minCuts(arr,dp, value));

	}
	
	public static int minCuts(int arr[], int[] dp, int value) {
		if(dp[value] != -1)
			return dp[value];
		else {
			int result = -1;
			for(int i=0;i<arr.length;i++) {
				if(value-arr[i]>=0)
					result = Math.max(result, minCuts(arr, dp, value-arr[i]));
			}
			if(result == -1)
				return dp[value] = -1;
			return dp[value] = result +1;
		}
	}

}
