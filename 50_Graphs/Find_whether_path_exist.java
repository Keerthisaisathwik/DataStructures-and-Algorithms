//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int f, int s){
        first = f;
        second = s;
    }
}

class Solution
{
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int n = grid.length;
        boolean visited[][] = new boolean[n][n];
        Pair source = new Pair(0,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    source = new Pair(i, j);
                    break;
                }
            }
        }
        //System.out.println(source.first+" "+source.second);
        return bfs(source, grid, visited);
    }
    
    public static boolean bfs(Pair source, int[][] grid, boolean[][] visited){
        int n = grid.length;
        Queue<Pair> q = new LinkedList<Pair>();
        visited[source.first][source.second] = true;
        q.add(source);
        while(q.isEmpty()==false){
            int a = q.peek().first;
            int b = q.peek().second;
            q.poll();
            if(a-1>=0 && visited[a-1][b]==false){
                visited[a-1][b] = true;
                if(grid[a-1][b]==3)
                    q.add(new Pair(a-1, b));
                else if(grid[a-1][b]==2)
                    return true;
            }
            if(a+1<n && visited[a+1][b] ==false){
                visited[a+1][b] = true;
                if(grid[a+1][b]==3)
                    q.add(new Pair(a+1, b));
                else if(grid[a+1][b]==2)
                    return true;
            }
            if(b+1<n && visited[a][b+1]==false){
                visited[a][b+1] = true;
                if(grid[a][b+1]==3)
                    q.add(new Pair(a, b+1));
                else if(grid[a][b+1]==2)
                    return true;
            }
            if(b-1>=0 && visited[a][b-1]==false){
                visited[a][b-1] = true;
                if(grid[a][b-1]==3)
                    q.add(new Pair(a, b-1));
                else if(grid[a][b-1]==2)
                    return true;
            }
        }
        return false;
    }
}
