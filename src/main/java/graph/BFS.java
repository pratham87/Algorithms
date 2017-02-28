package graph;

/*
  Breadth-First-Search(Graph, root):
    
    create empty set S
    create empty queue Q      

    root.parent = NIL
    Q.enqueue(root)                      

    while Q is not empty:
        current = Q.dequeue()
        if current is the goal
            return current
        for each node n that is adjacent to current:
            if n is not in S:
                add n to S
                n.parent = current
                Q.enqueue(n)
  
 **/

import java.util.*;

class BFS {
	private int vertices;
	private LinkedList<Integer> adj[]; // List of adjacent vertices

	@SuppressWarnings("unchecked")
	BFS(int v) {
		vertices = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public void bfsUtil(int s) {
		// Mark all the vertices as not visited(false by default)
		boolean visited[] = new boolean[vertices];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Step 1: Mark the current node as visited and print it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public void test(int s){
		
	}

	public static void main(String args[]) {
		BFS g = new BFS(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Breadth First Traversal " + "(starting from vertex 2)");

		g.bfsUtil(2);
	}
}