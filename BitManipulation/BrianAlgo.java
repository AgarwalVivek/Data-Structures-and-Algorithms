
public class BrianAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  n = 254;
		System.out.println(getCount(n));

	}
	private static int getCount(int n) {
		// TODO Auto-generated method stub
		/*
		 * 0000 = 0, 0001= 1, 0010= 1, 0011=2, 0100 =1, 0101 = 2, 0110=2, 0111 = 3, 1000= 8,
		 * 1001 = 2, 1010 = 2, 1011 = 3, 1100=2, 1101= 3, 1110= 3, 1111=4
		 */
		int[] arr = {0, 1, 1, 2, 1,2,2,3,1,2,2,3,2,3,3,4};
		int count = 0;
//		while (n > 0)
//        {
//            n &= (n - 1) ;
//            count++;
//        }
		for(;n>0; n = n &(n-1)) {
			System.out.println(n);
			count++;
		}
		return count;
		
	}

}
