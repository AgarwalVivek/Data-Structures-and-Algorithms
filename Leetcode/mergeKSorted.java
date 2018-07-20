import java.util.ArrayList;
import java.util.PriorityQueue;

public class mergeKSorted {
	int m[][] = {{1, 2, 10}, {5, 6, 7}, {9, 10, 11}};
	ArrayList<Integer> result = new ArrayList<>();
	class QueueNode implements Comparable<QueueNode>{
		int val;
		int rowNo;
		int colNo;
		
		@Override
		public int compareTo(QueueNode o) {
			// TODO Auto-generated method stub
			return val - o.val;
		}
		
		QueueNode(int row, int col, int val){
			this.rowNo = row;
			this.colNo = col;
			this.val  = val;
		}
	}
	public void merge() {
		PriorityQueue<QueueNode> pq = new PriorityQueue<>();
		// TODO Auto-generated constructor stub
		int size = 0;
		for(int i = 0; i < m.length; i++) {
			size += m[i].length;
			QueueNode q = new QueueNode(i, 0, m[i][0]);
			pq.add(q);
			
		}
		
		/*
		 * run through the loop adding each element as you move
		 */
		for(int i = 0; pq.isEmpty() == false; i++) {
			QueueNode x = pq.poll();
			result.add(x.val);
			int rwNo = x.rowNo;
			int clNo = x.colNo+1;
			if (clNo < m[rwNo].length) {
				pq.add(new QueueNode(rwNo, clNo, m[rwNo][clNo]));
			}
			
		}
		
		for(int i: result)
			System.out.print(i+"\t");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mergeKSorted obj = new mergeKSorted ();
		obj.merge();
	}

}
