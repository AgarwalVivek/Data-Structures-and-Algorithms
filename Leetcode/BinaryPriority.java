import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class BinaryPriority {

	public static void main(String[] args) {
		//2,
		int n1 = -20;
		System.out.println(n1>>>2);
		String test = "[watching tv (at, home)]"; 
		test = test.replaceAll("\\p{P}","");
		System.out.println(test);
		int n[] = { 2, 10,5,  4, 4, 8};//{2,4,4,5,8,10}
		int m[] = {3, 1, 7, 4};
		
		int[] arr = getArray(n, m);
	
       for(int i = 0; i < arr.length; i++)
    	   System.out.println(arr[i]);
       System.out.println();
       int bruteForce[] = bruteForce(n,m);
       for(int i: bruteForce) {
    	   System.out.println(i);
       }
       
		
		}

	private static int[] bruteForce(int n[], int m[]) {
		
		int count, index  = 0;
		int result[] = new int[m.length];
		for(int i = 0; i < m.length; i++) {
			int x = m[i];
			count = 0;
			for(int j = 0; j < n.length; j++) {
				if(x >= n[j]) count++;
			}
			result[index++] =  count;
		}
		return result;
	}
	private static int[] getArray(int[] n, int[] m) {
		// TODO Auto-generated method stub
	       int count = 0;
	      
	    int[] result = new int[m.length];
	    PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int i = 0;i< n.length; i++) {
	    		pq.offer(n[i]);
	    }
	    int arr[] = new int[pq.size()];
	    
	    for(int i = 0; i < n.length; i++) {
	    	
	    		arr[i] = pq.remove();
	    		System.out.println(5/2);
	    	}
	    
	    for(int i = 0; i < m.length; i++) {
	    		int pos = getBinarySearch(m[i], arr, 0, arr.length);
	    		result[i] = pos;
	    }
		return result;
	}

	private static int getBinarySearch(int item, int[] arr, int begin, int end) {
		// TODO Auto-generated method stub
		
		if(begin > end) {
			System.out.println("returning "+ begin);
			return item > arr[begin] ? begin+1: begin;
		}
		int mid = begin + (end - begin)/2;
		if(item == arr[mid]) {
			while(item == arr[mid]) {
				System.out.println("DUPLICate processing"+ arr[mid]);
				mid++;
			}
			return mid;
		}
		if(item < arr[mid]) {
			return getBinarySearch(item, arr, begin, mid - 1);
		} else {
			return getBinarySearch(item , arr, mid+1, end);
		}
		
		
	}
	


		
		

}
