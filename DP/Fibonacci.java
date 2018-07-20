
public class Fibonacci {
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		Fibonacci fb = new Fibonacci();
		int cache[]= new int[n];
		cache[0] = 1;
		cache[1] = 1;
		System.out.println(cache[2]);
		int fib1= getFib(n);
		System.out.println(fib1);
		int fib2 = getFibRecursive(n);
		System.out.println(fib1);
		int fib3 = getFibIterativeDP(n);
		System.out.println(fib3);
		int fib4 = fb.getFibRecursiveDP(cache,n-1);
		System.out.println(fib4);
	}

	private  int getFibRecursiveDP(int [] cache, int n) {
		
	    if(cache[n] != 0) {
			return cache[n];
		} 
	    
		cache[n] = getFibRecursiveDP(cache, n-1) + getFibRecursiveDP(cache, n-2);

		return cache[n];
	

	}

	private static int getFibIterativeDP(int n) {
		// TODO Auto-generated method stub
	
		int cache[] = new int[n];
		cache[0] = 1;
		cache[1] = 1;
		int i;
		for ( i = 2; i < n; i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}
		return cache[i-1];
	}

	private static int getFibRecursive(int n) {
		// TODO Auto-generated method stub
		if(n == 0 || n == 1) return 1;
		else return getFib(n-1) + getFib(n -2);
	}
	

	private static int getFib(int n) {
		// TODO Auto-generated method stub
		
		int a = 1;
		int b = 2;
		int i = 4;
		while(i <= n) {
			int  x = b;
			b = a+b;
			a = x;
			i++;
			
		}
		return b;

	}
}
