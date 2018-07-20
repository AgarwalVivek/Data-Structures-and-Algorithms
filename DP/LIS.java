
public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {0, 4, 12, 2, 10, 6, 9 , 13, 3, 11,7, 15};
		int longestIS = getLIS(arr);
		System.out.println(longestIS);
	}

	private static int getLIS(int[] arr) {
		// TODO Auto-generated method stub
		
		int result[] = new int[arr.length];
		int index[] = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			result[i] = 1;
		}
	
		for(int i = 1; i < arr.length; i++) {
			for(int j  = 0; j< i; j++) {
				//for i decide LIS
				int x = 0;
				if(arr[j] < arr[i] && result[j] + 1 >= result[i]) {
					x = j;
					index[i] = j;
					result[i] = result[j]+1;
				}
				
			}

		}
		int maxIndex =  getMax(result);
	
		for(int in = maxIndex;in>0; ) {
			 System.out.println(arr[index[in]]);
			 in = index[in];
		}
		return result[maxIndex];
	}

	private static int getMax(int[] result) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int elt;
		for( elt = 0; elt< result.length; elt++) {
			max = max < result[elt]?result[elt]:max;
		}
		if(max == Integer.MAX_VALUE) return 0;
		return elt-1;
	}

}
