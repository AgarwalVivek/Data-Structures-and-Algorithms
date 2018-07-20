
public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6,7};
		int d = 4;
		rotateArray(arr, d);

		for(int i: arr) {
			System.out.print("\t"+i);
		}
	}

	private static void rotateArray(int[] arr, int d) {
		// TODO Auto-generated method stub
		
		if(arr.length < d) return;
		
		int gcd = getGCD(arr.length, d);
		System.out.println("SAS"+gcd);
		
		int j = 0, k =0,temp = 0, n = arr.length;
		for(int i = 0; i<gcd; i++) {
			j = i;
			temp = arr[j];
			while(true) {
				System.out.println(k);
				k = (j + d) % n;
				if(k == i) break;
				arr[j] = arr[k];
				j = k;
				
			}
			arr[j] = temp;
		}
	}

	private static int getGCD(int a, int b) {
		// TODO Auto-generated method stub
		if(a == 0) return b;
		else
		return getGCD(b%a, a);
	}

}
