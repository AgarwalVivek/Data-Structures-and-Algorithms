import java.util.Arrays;

public class Djkistraa {
	public static final int vertices = 9;
	int distance[] = new int[vertices];
	Boolean visited[] = new Boolean[vertices];
	int parent[] = new int[vertices];
	public Djkistraa(int src) {
		Arrays.fill(distance, Integer.MAX_VALUE);;
		Arrays.fill(parent, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		distance[src] = 0;
//		visited[src] = true;
		parent[src] = src;
	}
	
	public int extractMin() {
		int minIndex = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i< vertices; i++) {
			if(!visited[i] && min > distance[i]) {
				minIndex = i;
				min = distance[i];
			}
		}
		System.out.println("returning : "+ minIndex);
		return minIndex;
	}
	
	public void FindPath(int graph[][]) {
		for(int i = 0; i< vertices; i++) {
			int min = extractMin();
			int dist = distance[min];
			System.out.println("dist here :" + dist+"min index "+min );
			visited[min] = true;
			for(int v = 0; v< vertices;v++) {
				if(!visited[v] && dist != Integer.MAX_VALUE && graph[min][v] != 0 && distance[v] > (dist+graph[min][v])) {
					distance[v] = dist + graph[min][v];
					parent[v] = min;
				}
			}
			
		}
		printDistance();
		
	}
	private void printDistance() {
		// TODO Auto-generated method stub
		System.out.println("distance matrix");
		for(int i = 0; i < 9; i++) {
			System.out.print(distance[i]+"\t");
		}
		System.out.println();
		for(int i = 0; i < 9; i++) {
			System.out.print(parent[i]+"\t");
		}
		System.out.println("distance matrix");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
             {4, 0, 8, 0, 0, 0, 0, 11, 0},
             {0, 8, 0, 7, 0, 4, 0, 0, 2},
             {0, 0, 7, 0, 9, 14, 0, 0, 0},
             {0, 0, 0, 9, 0, 10, 0, 0, 0},
             {0, 0, 4, 14, 10, 0, 2, 0, 0},
             {0, 0, 0, 0, 0, 2, 0, 1, 6},
             {8, 11, 0, 0, 0, 0, 1, 0, 7},
             {0, 0, 2, 0, 0, 0, 6, 7, 0}
            };
            Djkistraa obj = new Djkistraa(1);
            obj.FindPath(graph);
            
	}

}
