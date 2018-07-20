
public class squareBrute {

	public squareBrute() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
		int arr[] = {-3, 0, 1, 2};
		
		for(int i =0; i<arr.length-1; i++) {
			int n = arr[i]*arr[i];
			
			for (int j = i+1; j < arr.length; j++) {
				int x = arr[j] * arr[j];
				if (n > x) {
					System.out.println("debug"+n+"\t"+x);
					swap(arr, i, j);
					//updating with new value of n
					n = arr[i]*arr[i];
					System.out.println("reverse"+arr[i]+"\t"+arr[j]);
				}
			}
			
			
		}
		for(int a:arr)
		System.out.println(a);
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
