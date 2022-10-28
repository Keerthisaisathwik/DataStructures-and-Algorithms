//{ Driver Code Starts
// Initial Template for Java
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
                // adj.get(v).add(u);
            }
            String[] S1 = br.readLine().trim().split(" ");
            int source = Integer.parseInt(S1[0]);
            int destination = Integer.parseInt(S1[1]);
            Solution obj = new Solution();
            System.out.println(obj.countPaths(V, adj, source, destination));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to count paths between two vertices in a directed graph.
    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
                   int destination) {
        // Code here
        if(source==destination)
            return 1;
        //if cycle contains we should return 0;
        if(containsCycle(adj, V))
            return 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(source);
        int count = 0;
        while(q.isEmpty()==false){
            int curr = q.poll();
            for(int i: adj.get(curr)){
                if(i==destination){
                    count++;
                }
                else{
                    q.add(i);
                }
            }
        }
        return count;
    }
    
    public boolean containsCycle(ArrayList<ArrayList<Integer>> adj, int V){
        boolean visited[] = new boolean[V];
        boolean rec[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false)
                if(dfs(i, adj, visited, rec))
                    return true;
        }
        return false;
    }
    
    public boolean dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean visited[], boolean rec[]){
        visited[u] = true;
        rec[u] = true;
        for(int i: adj.get(u)){
            if(visited[i]==false){
                if(dfs(i, adj, visited, rec))
                    return true;
            }else if(rec[i]==true)
                return true;
        }
        rec[u]=false;
        return false;
    }
}
