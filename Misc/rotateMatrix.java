//Om Sai Ram
public class rotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9 }};
		int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrix(a);
		System.out.println();
		//rotateMatrixBIG(arr);
		rotateMatrix12(a);
		printMatrix(a);

	}

	private static void printMatrix(int[][] a) {
		// TODO Auto-generated method stub
		for(int i = 0; i< a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

	private static void rotateMatrixBIG(int[][] a) {
		// TODO Auto-generated method stub
		
		int last = a.length -1;
		int level = 0;
		int totalLevels = a.length/2;
		
		while(level < totalLevels) {
			
		
		for(int i = level; i < last; i++) {
			int temp = a[level][i];
			swap(a, level , i, last , last-i+level);
			swap(a, last, last-i+level, i, last);
			swap(a, last, last-i, last-i, level);
			a[i][last] = temp;
		}
		last--;
		level++;
		}
		
	}
	private static void rotateMatrix(int[][] a) {
		// TODO Auto-generated method stub
		
		int last = a.length -1;
		int level = 0;
		for(int i = 0; i < last; i++) {
			int temp = a[level][i];
			swap(a, level , i, i , last);
			swap(a, i, last, last, last-i);
			swap(a, last, last-i, last-i, level);
			a[last-i][level] = temp;
		}
		
	}
	private static void rotateMatrix1(int[][] a) {
		// TODO Auto-generated method stub
		
		int last = a.length -1;
		int level = 0;
		
		for(int i = 0; i < last; i++) {
			int temp = a[level][i+level];
			swap(a, level , i+level, last -i , level);
			swap(a, last-i, level, last, last-i);
			swap(a, last, last-i, i+level, last);
			a[i+level][last] = temp;
		}
		
	}
	private static void rotateMatrix12(int[][] a) {
		// TODO Auto-generated method stub
		
		int last = a.length -1;

		int n = a.length;
		for(int level = 0; level <n/2;level++) {
			for(int i = level; i < last; i++) {
				int temp = a[level][i];
				swap(a, level , i, last -i+level , level);
				swap(a, last-i+level, level, last, last-i+level);
				swap(a, last, last-i+level, i, last);
				a[i][last] = temp;
			}
			last--;
		}
		
	}

	private static void swap(int a[][], int i1, int j1, int i2, int j2) {
		// TODO Auto-generated method stub
		int temp = a[i1][j1];
		a[i1][j1] = a[i2][j2];
		a[i2][j2] = temp;
		
		
	}

}
