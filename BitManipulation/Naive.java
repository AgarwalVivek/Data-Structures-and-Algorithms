
public class Naive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n  = 9;
		System.out.println(getCount(n));


	}
	private static int getCount(int n) {
		// TODO Auto-generated method stub
		

		int count = 0;
		for(;n>0; n = n>>1) {
			//System.out.println(n);
			count = count+ n&1;
		}
		return count;
		
	}

}
