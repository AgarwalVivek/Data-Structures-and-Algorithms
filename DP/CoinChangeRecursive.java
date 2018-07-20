
public class CoinChangeRecursive {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int 	den[] = {25, 10, 5, 1};
		int amount = 27;
		int cache[] = new int[27];
		int numOfCoins = makeChange(den, amount, cache);
		System.out.println(numOfCoins);
	}

	/*
	 * min = 27
	 * x = 2
	 * cache[2] = 2
	 * 				min = 2
	 * 				amount = 2
	 * 				x = 1
	 * 				cache[1] = 1
	 * 							amount = 1
	 * 							min = 1
	 * 							x = 0
	 * 							cache[0] = 0;
	 * 							
	 */
	private static int makeChange(int[] coins, int amount, int[] cache) {
		// TODO Auto-generated method stub
		if(amount == 0) return 0;
		int min = amount;
		for(int coin: coins) {
			int x = amount - coin;
			if(x >=0) {
				if(cache[x] == 0) {
					cache[x] = makeChange(coins, x, cache);
					
				}
				if(min > cache[x]) {
					min = cache[x];
				}
				
			}
			
		}
		
		return min+1;
	}

}
