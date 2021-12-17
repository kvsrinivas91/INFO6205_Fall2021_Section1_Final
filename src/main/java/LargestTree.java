import java.util.*;
class LargestTree {
    static void addEdge(LinkedList<Integer> adj[], int u, int v) {
        //TO-DO:
        adj[u].add(v);
        adj[v].add(u);
    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited) {
        visited.add(u, true);
        int sizeNum = 1;

        // Iterate through all the nodes and perform DFS if the node is not yet visited
        //TO-DO:
        for (int i = 0; i < adj[u].size(); i++)
            if (!visited.get(adj[u].get(i))) {
                sizeNum = sizeNum + DFS(adj[u].get(i), adj, visited);
            }

        return sizeNum;
    }

    public int largestTree(LinkedList<Integer> adj[], int V) {
        //TO-DO:
        int res = 0;
        Vector<Boolean> visitedVector = new Vector<>();
        for (int j = 0; j < V; j++){
            visitedVector.add(false);
        }

        for (int j = 0; j < V; j++) {
            if (!visitedVector.get(j)) {
                res = Math.max(res, DFS(j, adj, visitedVector));
            }
        }
        return res;
    }
}