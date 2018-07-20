import java.util.HashMap;

public class ZeroSumSubarray {
	int arr[] = {1,2, 4, -4, -2, -1};
	
	public ZeroSumSubarray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZeroSumSubarray obj = new ZeroSumSubarray();
		int index[] = new int[2];
		index = obj.getIndexes(obj.arr, index);
		if(index != null)
			System.out.println(index[0]+"\t"+ index[1]);
	}

	private int[] getIndexes(int[] arr, int[] index) {
		// TODO Auto-generated method stub
		//hashmap to store key = sum, val = index
		HashMap<Integer, Integer> hm = new HashMap<>();
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int range = 0;
		int startIndex = 0, endIndex = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			//storing length difference
			range = endIndex - startIndex;
			sum += arr[i];
			System.out.println(sum);
			
			if(sum == 0 && range > max) {
				startIndex = -1;
				endIndex = i;
				max = range;
			}
			if(hm.containsKey(sum) && range>max) {
				startIndex = hm.get(sum);
				endIndex = i;
				max = range;
				
				
			} else {
				hm.put(sum, i);
			}
		}
		if(range != 0)
			return getArray(startIndex+1, endIndex);
		else
			return null;
		
		
	}

	private int[] getArray(int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		return new int[] {startIndex, endIndex};
	}


}
