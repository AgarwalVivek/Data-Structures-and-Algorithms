
public class nextNumber {

	public static void main(String[] args) {
		int n = 13948;
		int n1 = getNext(n);
		System.out.println(n1);
		int n2 = getNextNumber(n);
		System.out.println(n2);
	}

	private static int getNextNumber(int n) {
		int c0 = 0, c1 = 0, p =0;
		int temp = n;
		System.out.println(n+"\t"+temp);
		while((n&1) == 0) {
			c0++;
			n >>=1;
		}
		
		while((n & 1) == 1) {
			c1++;
			n >>= 1;
		}
		
		p = c0+c1;
		
	
		temp += Math.pow(2, c0) -1;
	
		temp += 1;
		
		temp +=Math.pow(2,(c1-1))-1;
		
		return temp;
		
	}
	private static int getNext(int n) {
		// TODO Auto-generated method stub
		//find non trailing rightmost0
		int c0 = 0, c1 = 0;
		int p = 0;
		int temp = n;
		
		while((n&1) == 0) {
			c0++;
			n >>=1;
		}
		
		//count c1
		while((n & 1) == 1) {
			c1++;
			n >>=1;
		}
		
		p = c0 + c1;
		
		temp |= (1<<p);
		temp &= ~((1<<p) -1);
		int x = 1 <<(c1 -1);
		int x1 = x -1;
		temp |= x1;
	return temp;
	}
}
