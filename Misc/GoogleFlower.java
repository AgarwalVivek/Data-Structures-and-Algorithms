import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class GoogleFlower {

	public static int solution(int A[], int K, int M) {
		
		if(A.length == 0 || K == 0|| K*M > A.length) return -1;
		
		int colsLength = getMax(A);
		
		boolean table[][] = new boolean[A.length][colsLength];
		
		populateTable(table, A);
		
		//now hashmap containes row number and the contiiues true count
		
		HashMap<Integer, LinkedList<Integer>> data = new HashMap<>();
		
		for(int i = 0; i < table.length; i++){
			System.out.println(":DD+ row"+ i);
		
			populateHashMap(data, table, i, K);
		}
		data.forEach((k,v) -> {
			System.out.print("for row: "+k+"\t");
			v.forEach(t -> System.out.print(t+"\t"));
			System.out.println();
		});	
		return 0;
		
	}
	private static void populateHashMap(HashMap<Integer, LinkedList<Integer>> data, boolean[][] table, int i, int K) {
		// TODO Auto-generated method stub
		
		LinkedList<Integer> freq = new LinkedList<>();
		int count = 0;
		int mCount = 0;
		int col = 0;
		System.out.println("ds");
		while(col < table[0].length) {
			System.out.println("Dsd");
			while(table[i][col] == true && count < K) {
				System.out.println("dsds" + i);
				count++;
			}
			if(count == K) { mCount++;
							count = 0;
							}
			col++;
			}
			System.out.println(mCount +"for row"+i);
			

		}
		
	
		
//		if(table[i][col]== true && count <= K) {
//		count++;
//	} else if((count >=K)){
//		System.out.println("debuf");
//		System.out.println("row " + i+"\t"+count);
//		freq.add(count);
//		
//		count = 0;
//	}
//		data.put(i, freq);
//
//	}
	private static void populateTable(boolean[][] table, int[] A) {
		// TODO Auto-generated method stub
		int index = 0;
		int cur = A[index++]-1;
		for(int i = 0; i < table.length;i++) {
			
			populateRow(table, i, cur);
			System.out.println(Arrays.toString(table[i]));
			if(index == A.length) break;
			cur  = A[index] -1;
			index++;
			
		
		
		}
		
	}
	private static void populateRow(boolean[][] table, int i, int curCol) {
		// TODO Auto-generated method stub
		if(i == 0) {
			table[i][curCol] = true;
		} else {
			for(int j = 0; j < table[0].length; j++) {
				if(table[i-1][j] == true) {
					table[i][j] = true;
				}
				table[i][curCol] = true;
			}
		}
		
	}
	private static int getMax(int[] a) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		for(int i: a) {
			max = Math.max(max, i);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2, 7, 6, 4, 3, 5};
		int M  = 2, K = 2;
		solution(a, K, M);
	}

}
