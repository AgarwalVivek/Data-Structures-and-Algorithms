import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Topo {
	LinkedList<Integer>[] adj;
	int vertices;
	boolean[] visited;
	int[] indegree;
	Stack<Integer> ordered ;
	LinkedList<Integer> sCycle;
	
	public Topo(int vertices) {
		this.vertices = vertices;
		adj= new LinkedList[vertices];
		visited = new boolean[vertices];
		indegree = new int[vertices];
		ordered = new Stack<Integer>();
		for(int i = 0; i < vertices; i++)
			adj[i] = new LinkedList<>();
		sCycle = new LinkedList<>();
	}
	public void add(int src, int dst) {
		adj[src].add(dst);
		indegree[dst]++;
		indegree[src]++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Topo  obj = new Topo(6);
		obj.add(2, 3);
		obj.add(3, 1);
		//obj.addEdge(4, 0);
		obj.add(4, 1);
		obj.add(5, 2);
		//obj.addEdge(5,0);
		System.out.println("here");
		obj.Sort();
		System.out.println(obj.ordered);
		obj.topoBFS(obj.vertices);

	}
	private void Sort() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < vertices; i++) {
			System.out.println(i);
			if(!visited[i]) {
				topoUtil(i, ordered);
			}
		}
		
	}
	private int findSingleCycles() {
		int flag = 0;
		int count = 0;
		for(int i  = 0; i < vertices; i++) {
			if(!visited[i]) {
				sCycle.clear();
				doDFS(i);
				flag = 0;
				for(int c: sCycle) {
					
					if(indegree[c] == 2) {
						flag = 1;
						continue;
					} else {
						flag  = 0;
						break;
					}
				}
				if(flag == 1) {
					count++;
				}
			}
		}
		return count;
	}
	private void doDFS(int v) {
		// TODO Auto-generated method stub
		sCycle.add(v);
		visited[v] = true;
		
		LinkedList<Integer> cur = adj[v];
		for(int i : cur) {
			if(!visited[i]) {
				doDFS(v);
				
			}
		}
		
		
	}
	private void topoUtil(int v, Stack<Integer> ordered) {
		// TODO Auto-generated method stub
		visited[v] = true;
		
		LinkedList<Integer> cur = adj[v];
		
		for(int i: cur) {
			if(!visited[i]) {
				topoUtil(i, ordered);
			}
		}
		ordered.push(v);
	}
	private void topoBFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < v; i++) {
			if(indegree[i] == 0)
				q.add(i);
				
		}
		Stack<Integer> result = new Stack<>();
		int count = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			LinkedList<Integer> list = adj[cur];
			result.add(cur);
			for(int i: list) {
				if(--indegree[i] == 0) {
					q.add(i);
				}
			}
			count++;
		}
		
		if(count != v) System.out.println("sorry");
		for(int i : result) {
			System.out.println(i);
		}
	}

}
