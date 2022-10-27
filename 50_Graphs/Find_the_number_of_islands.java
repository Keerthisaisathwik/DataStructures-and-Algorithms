//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
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

class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    bfs(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void bfs(int v1, int v2, boolean visited[][], char[][] grid){
        int row = grid.length;
        int column = grid[0].length;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(v1, v2));
        visited[v1][v2] = true;
        while(q.isEmpty()==false){
            int n = q.peek().first;
            int m = q.peek().second;
            q.poll();
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int r = n+i;
                    int c = m+j;
                    if(r>=0 && c>=0 && r<row && c<column &&
                    grid[r][c]=='1' && visited[r][c]==false){
                        q.add(new Pair(r, c));
                        visited[r][c] = true;
                    }
                }
            }
        }
    }
}
