
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1, 3, 8, 9 , 15};
		int arr2[] = {7, 11, 19, 21, 18,25};
		
		int length1 = arr1.length;
		int length2 = arr2.length;
		int totalLength = length1+ length2;
		int mid = (totalLength+1)/2;
		
		if(totalLength % 2 != 0) {
			System.out.println(getMedian(arr1, 0, arr2, 0, mid));
		} else {
			int mid1 = getMedian(arr1, 0, arr2, 0, mid);
			int mid2 = getMedian(arr1, 0, arr2, 0, mid+1);
			System.out.println(mid1+mid2/2);
		}

	}

	private static int getMedian(int[] arr1, int start1, int[] arr2, int start2, int mid) {
		// TODO Auto-generated method stub
		
		int remainingSize1 = arr1.length-start1;
		int remainingSize2 = arr2.length-start2;
		
		if(remainingSize1 > remainingSize2) {
			return getMedian(arr2, start2, arr1, start1, mid);
		} 
		
		if(remainingSize1<1) {
			return arr2[start2+mid-1];
		}
		
		if(mid == 1) {
			return Math.min(arr1[start1], arr2[start2]);
		}
		
		int offset = Math.min(arr1[start1], mid/2);
		int i = start1 + offset;
		int j = start2 + mid - offset;
		
		if(arr1[i-1] < arr2[j-1]) {
			return getMedian(arr1, i, arr2, start2, mid-offset);
		} else {
			return getMedian(arr1, start1, arr2, j, offset);
		}
		
	}

}
