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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false && dfs(i, -1, visited, adj))
                return true;
        }
        return false;
    }
    
    public boolean dfs(int u, int parent, boolean visited[], ArrayList<ArrayList<Integer>> adj){
        visited[u] = true;
        for(int i: adj.get(u)){
            if(visited[i]==false){
                if(dfs(i, u, visited, adj))
                    return true;
        // HERE: if(visited[i]==false && dfs(i, u, visited, adj))
        //          return true;
        // THIS CODE IS NOT WORKING NOT SURE WHY?
            }else if(i!=parent)
                return true;
        }
        return false;
    }
}
