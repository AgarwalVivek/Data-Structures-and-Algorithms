import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 8, 9, 5, 7, 6, 2, 3,1};
		long x = getIt(arr);
		System.out.println(x);
	}

	private static long getIt(int[] arr) {

		int j = arr.length-1;
		int m = 0;
		int count = 0;
		for(int i = 0; i< j; i++) {
			if(arr[i] < arr[j]) {
				System.out.println(count);
				count++;
			} else {
			j--;
			}
		}
	
		
		Boolean isAscending = false;
		if( count >= arr.length/2) {
			 isAscending = true;
			
		}

		System.out.println(isAscending);
		for(int i = 1; i < arr.length; i++) {
			if(arr[i-1] == arr[i] ) continue;
			if(arr[i-1] < arr[i]) {
				count++;
			}
			
		}
		return count;
		// TODO Auto-generated method stub
		
		
	}
	
}
