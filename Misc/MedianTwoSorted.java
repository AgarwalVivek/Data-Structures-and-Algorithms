
public class MedianTwoSorted {

	int arr1[] = {1, 3, 8, 9 , 15};
	int arr2[] = {7, 11, 19, 21, 18,25};
	
	public int getMedian(int arr1[], int start1, int start2, int arr2[], int k) {
		int remainingSize1 = arr1.length - start1;
		int remainingSize2 = arr2.length - start2;
		if(remainingSize1 > remainingSize2) {
			return getMedian(arr2, start2, start1, arr1, k);
		}
	
		if(remainingSize1==0) {
			return (arr2[start2+k-1]);
		}
		if(k == 1) {
			return Math.min(arr1[start1], arr2[start2]);
		}
		
		int offset = Math.min(k/2, remainingSize1);
		int i = start1 + offset;
		int j = start2 + k-offset;
		System.out.println(i +"\t"+j+"\t"+offset);
		if(arr1[i-1] < arr2[j-1]) {
			 System.out.println("here");
			//remove first i section of arr1
			return getMedian(arr1, i, start2, arr2, k-offset);
		} else{
			 System.out.println("in here");
			return getMedian(arr1, start1, j,arr2,  offset);
		}
		
		
		
	}
		public static void main(String[] args) {
			MedianTwoSorted m = new MedianTwoSorted();
			int length1 = m.arr1.length;
			int length2 = m.arr2.length;
			int totalLength = length1 + length2;
			int k = (totalLength+1)/2;
			int median = 0;
			
			if(totalLength%2 != 0) {
				median = m.getMedian(m.arr1, 0, 0, m.arr2, k);
			} else {
				
				median = ((m.getMedian(m.arr1, 0, 0, m.arr2, k)+m.getMedian(m.arr1, 0, 0, m.arr2, k+1))/2);
			}
			System.out.println(median);
	}
		// TODO Auto-generated method stub
		

	

}
