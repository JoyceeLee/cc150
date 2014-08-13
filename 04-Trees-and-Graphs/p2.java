/*
 * 4.2 Given a directed graph, design an algorithm to find out whether there is 
 * a route between two nodes.
 *
 * Compare DFS & BFS:
 * - DFS is more simple 'cause it can be implement by recursion
 * - BFS may find the shortest way, well DFS one node very deep ever before visit the immediate node
 */



public enum State {
	Visited, Unvisited, Visiting;
}
class Node {
	int label;
	State state;
	ArrayList<Node> adj = new ArrayList<Node>();
	public Node(int label) {
		label = this.label;
		state = Unvisited;
	}
}
class Graph {
	ArrayList<Node> nodes = new ArrayList<Node>();
	public ArrayList<Node> getNodes() {
		return this.nodes;
	}
}

// Solution 1 BFS
public class Solution {
	public boolean search(Graph g, Node start, Node end) {
		LinkedList<Node> que = new LinkedList<Node>();
		for(Node n:g.getNodes()) {
			n.state = State.Unvisited;
		}
		start.state = State.Visiting;
		que.offer(start);
		while(!que.isEmpty()) {
			Node cur = que.poll();
			cur.state = State.Visited;
			for(Node n:cur.adj) {
				if(n==end) return true;
				if(n.state==State.Unvisited) {
					n.state = State.Visiting;
					que.offer(n);
				}
			}
		}
		return false;
	}
}


// Solution 2 DFS
public class Solution {
	public boolean search(Graph g, Node start, Node end) {
		Stack<Node> st = new Stack<Node>();
		for(Node n:g.getNodes()) {
			n.state = State.Unvisited;
		}
		start.state = State.Visiting;
		st.push(start);
		while(!st.isEmpty()) {
			Node cur = st.pop();
			if(cur.state = State.Visited) continue;
			cur.state = State.Visited;
			for(Node n:cur.adj) {
				if(n==end) return true;
				if(n.state!=State.Visited) {
					n.state = State.Visiting;
					st.push(n);
				}
 			}
		}
		return false;
	}
}