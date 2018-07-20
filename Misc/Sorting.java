import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,9,3,4,5,6};
		
				//insertionSort(arr);
//		
//	   effInsertionSort(arr);
//		printResult(arr );
//		mergeSort(arr, 0 , arr.length-1);
//		printResult(arr);
		
//		printResult(result);
		Sorting obj = new Sorting();
		obj.quickSort(arr, 0 , arr.length-1);
		printResult(arr);
//	
//		
		

	}

	private static void quickSort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if(start<end) {
			int partition = Partition(arr, start, end);
		
			quickSort(arr,start, partition-1);
			quickSort(arr, partition+1, end);
		}
		
	}

	private static int Partition(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		int pivot = arr[end];
		int pindex = end;
		
		int i = start - 1;
		for(int j = start; j <end; j++) {
			if(arr[j] > pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}	
		}
		int temp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end]  = temp;
		return i+1;
	}
	

	private static void mergeSort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if(start < end) {
			int mid = start + (end -start)/2;
			if(start<mid) {
			System.out.println(start+"\t"+mid+"\t"+end);

			}
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start,mid, end);
		}
		
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int arr1[] = new int[mid - start+1];
		int arr2[] = new int[end-mid];
		
		int index =start;
		
		for(int i = 0; i < arr1.length; i++) {
			arr1[i]= arr[index];
			index++;
		}
		
		for(int i =0; i < arr2.length; i++) {
			arr2[i] = arr[index];
			index++;
			
		}
		
		int i = 0, j =0, arrIndex=start;
		while(i < arr1.length && j < arr2.length) {
			if(arr1[i]< arr2[j]) {
				arr[arrIndex] = arr1[i];
				i++;
			} else {
				arr[arrIndex] = arr2[j];
				j++;
			}
			arrIndex++;
		}
		
		if(i == arr1.length) {
			while(j <  arr2.length) {
				arr[arrIndex++] = arr2[j++];
			}
		} else if(j == arr2.length) {
			while(i < arr1.length) {
			arr[arrIndex++] = arr1[i++];
			}
		}
	

	}

	private static void copyRest(int[] arr, int arrIndex, int[] arr2, int j) {
		// TODO Auto-generated method stub
		for(int i = j; i < arr2.length; i++) {
			arr[arrIndex] = arr2[i];
			arrIndex++;
		}
		
	}

	private static int[] effInsertionSort(int[] arr) {
		// TODO Auto-generated method stub
		//5,6,7, 1, 2, 3, 4
		/*
		 * i=1 , j = 0;
		 * 
		 */
		int temp1 = 0;
		for(int i = 1; i < arr.length; i++) {
		    int j = i - 1;
			int temp = arr[i];
			int insertionPoint = getBinarySearch(arr, 0, j, temp);
		    System.out.println("INSER"+insertionPoint);
			while(insertionPoint <j) {
				arr[j+1] = arr[j];
				j--;
			}
			System.out.println(Arrays.toString(arr));
			int temp3 = arr[insertionPoint];
			arr[insertionPoint] = temp;
			arr[j+1] = temp3;
			
			
		}
		return null;
	}

	private static int getBinarySearch(int[] arr, int start, int end, int item) {
		// TODO Auto-generated method stub
		
		if(start > end)
			return item >arr[start]? start+1: start;
		int mid = start + (end - start)/2;
		
		if(arr[mid] == item) {
			while(arr[mid] == item)
				mid++;
			return mid;
		} 
		if(arr[mid] < item) {
			return getBinarySearch(arr, mid+1, end, item);
		} else {
			return getBinarySearch(arr, start, mid - 1, item);
		}
	}

	static int[] insertionSort(int[] arr) {
		// TODO Auto-generated method stub
		
		for(int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int temp = arr[i];
			
			while(j >= 0 && arr[j]>arr[j+1] ) {
				arr[j+1] = arr[j];
				j--;
			}
			int temp1 = arr[j+1];
			arr[j+1] = temp;
			arr[i] = temp1;
		}
		
		System.out.println();
		return arr;
	}
 private static void swap(int[] arr, int j, int i) {
		// TODO Auto-generated method stub
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
		
	}

static void printResult(int[] result) {
		// TODO Auto-generated method stub
	for(int entries: result) {
		System.out.println(entries);
	}
		
	}

}
