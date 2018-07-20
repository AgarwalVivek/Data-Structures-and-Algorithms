
public class Factorial {
	static int index = 2;
	static int temp[];
	public static int factorial(int n) {
		int factorial = 1;
		while(n >=1) {
			factorial *= n;
			n--;
		}
		
		return factorial;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 6;
		System.out.println(factorial(n));
		
		System.out.println(factorialRecursive(n));
		System.out.println(factorialMemoization(n));
	 
		temp = new int[n];
		int mem[] = new int[n];
		mem[0] = 1;
		mem[1] = 2;
		
		
		System.out.println("here"+factorialDP(mem, n-1));
		System.out.println(fact(n-1));
	}

	private static int factorialDP(int[] cache, int n) {
		// TODO Auto-generated method stub
		if(n == 0) return 1;
	
		else if(cache[n] != 0) return cache[n];
		int x = factorialDP(cache, n-1) * n;
		cache[n] = x;
			
		return x;
		
	}
	static int fact(int aa) {

		if (aa == 0 || aa == 1) {
			return 1;
		} else {
			if (temp[aa] != 0) {
				return temp[aa];
			}
			else
				return temp[aa] = (aa * fact(aa - 1));
		}
	}

	private static int factorialRecursive(int n) {
		// TODO Auto-generated method stub
		if(n == 1) return 1;
		else {
			return n *factorialRecursive(n-1);
		}
	}
	
	private static int factorialMemoization(int n) {
		int []cache = new int[n];
		cache[0] = 1;
		cache[1] = 2;

		int i = 3;
		while(i <= n) {
			cache[i-1] = i * cache[i-2];
			System.out.println(cache[i-1]);
			i++;
			
		}
		return cache[i-2];
	}
	
}
