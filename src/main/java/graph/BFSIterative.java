package graph;

import java.util.*;

/*
Algorithm:

1. Create a Queue and push the first vertex.
2. Create an array of LinkedList for all the vertices and boolean array to track visited vertices.
3. Each LinkedList will track the adjacent vertices. 

4. Mark the current node as visited and THEN enqueue it.
5. Dequeue the vertex and get the neighbors.
6. Check if every neighbor is visited or not. 
7. If not then enqueue the neighbor. 
*/

class BFSIterative {
	private int vertices;
	private List<Integer> adj[];

	@SuppressWarnings("unchecked")
	BFSIterative(int v) {
		vertices = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public void bfs(int s) {
		boolean visited[] = new boolean[vertices];

		Queue<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");

			for (int i : adj[s]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}

		}
	}

	public static void main(String args[]) {
		BFSIterative g = new BFSIterative(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Breadth First Traversal " + "(starting from vertex 2)");

		g.bfs(2);
	}
}