
public class DutchFlag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,1,0,0,1,2, 2,1, 2};
		seggregate(arr);
		for(int i: arr) {
			System.out.print("\t"+i);
		}
	}

	private static void seggregate(int[] arr) {
		// TODO Auto-generated method stub
		
		int low = 0, mid = 0, high = arr.length-1;
		
		while(mid <= high) {
			switch(arr[mid]) {
				case 0: swap(arr, low, mid);
						low++;
						mid++;
						break;
				case 1:  mid++;
						 break;
				case 2: swap(arr, high, mid);
						high--;
			}
			
		}
		
	}

	private static void swap(int[] arr, int low, int mid) {
		// TODO Auto-generated method stub
		int temp = arr[low];
		arr[low] = arr[mid];
		arr[mid] = temp;
		
	}

}
