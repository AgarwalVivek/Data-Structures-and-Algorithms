
public class efficient {

	public efficient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
		int arr[] = {-3, -2, 1, 4};
		int arr1[] = new int[arr.length];
		int l =0;
		for(int i =0; i< arr.length;i++) {
			arr[i] = arr[i] * arr[i];
			System.out.println(arr[i]);
		}
		
		int left = 0;
		int winner = 0, looser = 0;
		int looserIndex = 0;
	     int winnerIndex = arr.length - 1;
		int right = arr.length-1;
		while(left <= right) {
		
			if (arr[left] > arr[right]) {
				System.out.println(arr[left] +"\t"+arr[right]);
			winner = arr[left];
			left++;
				
			} else {
			 winner = arr[right];
			 right--;
	
		
			}
			arr1[winnerIndex--] = winner;
		}
		

		for(int x: arr1)
			System.out.println("\t"+x);
	
	}
}
