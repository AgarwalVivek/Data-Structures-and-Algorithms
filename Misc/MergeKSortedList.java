import java.util.Arrays;
import java.util.PriorityQueue;

class QueueNod implements Comparable<QueueNod>{

	int val;
	int rowNo;
	int colNo;
	QueueNod(int v, int r, int c){
		val = v;
		rowNo = r;
		colNo = c;
	}
	
	
	public int compare(QueueNod o1, QueueNod o2) {
		return (-1)*o1.compareTo(o2);
	}
	@Override
	public int compareTo(QueueNod o) {
		return (val-o.val);
	}
	
	public boolean equals(QueueNod a, QueueNod b) {
		if(a.equals(b)) return true;
		if(a.val == b.val) return true;
		return false;
	}
	
}
public class MergeKSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[][] = {{1, 2, 3},
						{4, 5, 6},
						{7, 8, 9}};
		int median[] = getMedian(arr1);
		System.out.println(Arrays.toString(median));

	}

	private static int[] getMedian(int[][] arr1) {
		// TODO Auto-generated method stub
		PriorityQueue<QueueNod> pq = new PriorityQueue<QueueNod>();
		int size  = 0;
 
		for(int i = 0; i < arr1.length; i++) {
			size += arr1[i].length;
			pq.add(new QueueNod(arr1[i][0], i, 0));
		}

		
		int result[] = new int[size];
		
		for(int i = 0; !pq.isEmpty(); i++) {
			QueueNod q = pq.poll();
			result[i] = q.val;
			
			if(arr1[q.rowNo].length-1 > q.colNo) {
				//add to list
				
				pq.add(new QueueNod(arr1[q.rowNo][q.colNo+1], q.rowNo, q.colNo+1));
			}
			//while(!pq.isEmpty())System.out.println(pq.poll().val);
		}
		
		return result;
	}


}
