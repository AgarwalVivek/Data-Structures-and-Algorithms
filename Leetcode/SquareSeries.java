
public class SquareSeries {
	static int arr[] = {-4, -1, 0, 2, 3};
	public SquareSeries() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//build up the array
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * arr[i];
		}
		
		/*
		 * in one pass we need to fix the position and go ahead
		 * 16, 1, 0, 4, 9
		 * 16 vs 0
		 */

	}

}
