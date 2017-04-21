package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Algorithm:

1. Create a Stack and push the first vertex.
2. Create an array of ArrayList for all the vertices and boolean array to track visited vertices.
3. Each ArrayList will track the adjacent vertices. 
4. Mark the current node as visited and print it.
5. Retrieve the the adj vertex from the list and check if its visited or not.
6. If not then push the vertex to the Stack. 
*/

public class DFSIterative {

	int vertices;

	private List<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public DFSIterative(int v) {
		vertices = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new ArrayList<>();
		}
	}

	void addEdge(int v, int adjv) {
		adj[v].add(adjv);
	}

	public void DFS(int v) {
		boolean visited[] = new boolean[vertices];
		DFSUtils(v, visited);
	}

	public void DFSUtils(int v, boolean[] vertices) {
		Stack<Integer> s = new Stack<>();
		s.push(v);

		while (!s.empty()) {
			v = s.pop();

			if (!vertices[v]) {
				vertices[v] = true;
				System.out.print(v + " ");

				for (int i : adj[v]) {

					if (!vertices[i]) {
						s.push(i);
					}

				}
			}
		}
	}

	public static void main(String[] args) {
		DFSIterative g = new DFSIterative(5);

		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 4);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
		g.DFS(2);
	}

}
