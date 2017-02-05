package graph;

import java.util.*;

/* Pseudocode:
 
 	procedure DFS(G,v):
1      label v as discovered
2      for all edges from v to w in G.adjacentEdges(v) do
3          if vertex w is not labeled as discovered then
4              recursively call DFS(G,w)

 */

public class DFSConnectedGraph {
	private int vertices;

	// Array of lists for adjacent vertices
	private LinkedList<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public DFSConnectedGraph(int v) {
		vertices = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<>();
	}

	// Adding edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v's list.
	}

	void DFSUtil(int v, boolean visited[]) {
		// Step 1: Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Step 2: Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();

			// Step 3 and 4
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}

	void DFS(int v) {
		// Mark all the vertices as not visited(false by default)
		boolean visited[] = new boolean[vertices];

		DFSUtil(v, visited);
	}

	public static void main(String args[]) {
		DFSConnectedGraph g = new DFSConnectedGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.DFS(2);
	}
}