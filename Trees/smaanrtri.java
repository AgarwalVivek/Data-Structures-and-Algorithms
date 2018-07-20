
public class smaanrtri {

	public int  insertionPoint(int low, int high, int mid, int a[]) {
		return 0;
		
	}


	private static void mergeSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int mid = 0;
		if(low < high) {
		 mid = low+(high - low)/2;

		 mergeSort(arr, low, mid);
		 mergeSort(arr, mid+1, high);
		 merge(arr, low, mid, high);
		}
		
		
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		// TODO Auto-generated method stub
		
		int arr1[] = new int[mid -low+1];
	
		int arr2[] = new int[high - mid];
		
		int count = 0;;
		for (int i = low; i <= mid; i++) {
			
			arr1[count++] = arr[i];
			
			
		}
		int count1 = 0;
		
		for(int i  = mid+1; i <= high; i++) {
			arr2[count1++] = arr[i];
		}


		int  i = 0; int j = 0;count = low;
		while(i < arr1.length && j < arr2.length ) {
			if (arr1[i] < arr2[j]) {
				arr[count++] = arr1[i++];
			} else
				arr[count++] = arr2[j++];
		
		}
		if (i == arr1.length) {
		
			copyRest(arr, count, arr2, j, arr2.length);
		} else if (j == arr2.length ) {
			
				copyRest(arr, count, arr1, i, arr1.length);
			}

}
		
		
	

	private static void printArray(int[] arr2) {
		// TODO Auto-generated method stub
		for(int x: arr2)
			System.out.print(x+"\t");
		System.out.println();
	}

	private static void copyRest(int[] arr, int count, int[] arr2, int j, int high) {
		// TODO Auto-generated method stub
		
		while(j <high) {
			arr[count] = arr2[j];

			count++;
			j++;
		}
		
	}
	public static void main(String args[]) {
		int arr[] = {1,100,100, 200, 20, 10, 9, 9 , 9};
		mergeSort(arr, 0, arr.length -1);
		int arr3[] = new int[2];
		arr3 = highestDuplicate(arr);
		System.out.println("\n"+arr3[0]+"\t"+ arr3[1]);
	}

	private static int[] highestDuplicate(int[] arr) {
		// TODO Auto-generated method stub
		int count = 0, index = 0, flag = 0;
		for(int i = arr.length-1; i > 0; i--) {
			while(arr[i] == arr[i-1]) {
				flag = 1;
				count++;
				index = i;
				i--;
			} 
			if(flag == 1) break;
			
		
		}
		return (new int [] {arr[index], count+1});
	}
}
