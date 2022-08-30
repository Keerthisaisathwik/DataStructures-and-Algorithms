import java.util.*;
import java.io.*;
import java.lang.*;

public class Knapsack1_0_Dp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int n = sc.nextInt();
		int w[] = new int[n];
		int v[] = new int[n];
		for(int i=0; i<n;i++) {
			w[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			v[i] = sc.nextInt();
		}
		int dp[][] = new int[n+1][W+1];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i],-1);
		}
		for(int i=0;i<n+1;i++) {
			dp[i][0] = 0;
		}
		for(int i=0;i<W+1;i++) {
			dp[0][i] = 0;
		}
		System.out.println(knapsack(w,v,W, n, dp));
		//Here I passed "n-1" in this function it is wrong. pass "n" because "if(n==0)" it automatically returns zero.
	}
	
	public static int knapsack(int w[],int v[], int W, int n, int dp[][]) {
		//if(n==0) return 0, so make sure you pass n. every time you do the same mistake so please check once again.
		if(dp[n][W]!=-1) {
			return dp[n][W];
		}else {
		int result = 0;
		if(W>=w[n-1])
			result += Math.max(v[n-1]+knapsack(w,v,W-w[n-1], n-1, dp), knapsack(w,v,W,n-1,dp));
		else
			result += knapsack(w, v, W, n-1, dp);
		return dp[n][W] = result;
		}
	}
}
/*
TEST CASE 1:
10
4
1 3 4 6
20 30 10 50 

OUTPUT:
100
*/
