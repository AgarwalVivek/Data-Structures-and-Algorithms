import java.util.Arrays;

public class DuplicatesWithin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2, 1, 3, 5, 4, 1};
		
		System.out.println(isDuplicate(a));

	}

	private static int isDuplicate(int[] a) {
		// TODO Auto-generated method stub
		int as[] = new int[4];
		int j = 0;
		for(int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a));
			int index = Math.abs(a[i])-1;
			if(a[index] < 0) {
				as[j++] = Math.abs(a[i]);
				System.out.println("hewre");
			} else {
				a[index] *= -1;
				System.out.println("here");
			}
		}
		return as[0];
	}
}
