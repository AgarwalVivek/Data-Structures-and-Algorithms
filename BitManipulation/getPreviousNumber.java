
public class getPreviousNumber {

	public static void main(String[] args) {
		int n =11;
		int n1 = getPrevious(n);
		System.out.println(n1);
		int n2 = getPreviousNumber(n);
		System.out.println(n2);
	}

	private static int getPrevious(int n) {
		// TODO Auto-generated method stub
		
		int c0 = 0, c1 = 0;
		int temp = n;
		while((n &1) == 1) {
			c1++;
			n >>=1;
		}
		if(temp == 0) return -1;
		while((n& 1) == 0 &&  n!= 0) {
			c0++;
			n >>= 1;
		}
		int p = c0+c1;
		temp &= (~0)<<(p+1);
		temp += (1<<(c1+1))-1;
		
		return temp;
	}

	private static int getPreviousNumber(int n) {
		// TODO Auto-generated method stub
		int c0 = 0;
		int c1= 0;
		int temp = n;
		while((n & 1) == 1) {
			c1++;
			n >>=1;
		}
		if(n == 0) return -1;
		
		while((n & 1) == 0 && n !=0) {
			c0++;
			n >>=1;
		}
		
		int p = c0 + c1;
		temp = (~0) <<(1<<(p -+1));
		int mask = (1 <<c1)-1;
		temp |= mask << (1<<(c0-1));
		return 0;
	}
}
