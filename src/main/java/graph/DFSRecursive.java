package graph;

import java.util.*;

/*
 Algorithm: No container for Recursive way
 
 1. Create an array of linkedList for all the vertices and boolean array to track visited vertices.
 2. Each linkedList will track the adjacent vertices. 
 
 3. Mark the current node as visited and print it.
 4. Retrieve the the adj vertex from the list and check if its visited or not.
 5. If not then recursively call the method on that vertex. 
*/

public class DFSRecursive {
	private int vertices;

	private LinkedList<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public DFSRecursive(int v) {
		vertices = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<>();
	}

	// Adding the adjacent vertices to the linkedList
	void addEdge(int v, int adjv) {
		adj[v].add(adjv);
	}

	void DFS(int v) {
		boolean visited[] = new boolean[vertices];
		DFSUtil(v, visited);
	}

	void DFSUtil(int v, boolean visited[]) {

		visited[v] = true;
		System.out.print(v + " ");

		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();

			if (!visited[n])
				DFSUtil(n, visited);
		}
	}

	public static void main(String args[]) {
		DFSRecursive g = new DFSRecursive(4);

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