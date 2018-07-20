
public class CoinChanged {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int 	den[] = {25, 10, 5, 1};
		int amount = 37;
		
		int numOfCoins = makeChange(den, amount);
		System.out.println(numOfCoins);

	}
	/* amount = 27
	 * min = 27
	 * x = 2
	 * c = ==> 2
	 * min = 2
	 * return 2+1
	 * 			amount = 2
	 * 			min = 2
	 * 			x = 1
	 * 			c = ==> 1
	 * 			min = 2
	 * 					amount = 1
	 * 					min = 1
	 * 					x = 0
	 * 					c = 0
	 * 					return min + 1
	 * 
	 */

	private static int makeChange(int[] coins, int amount) {
		// TODO Auto-generated method stub
		if(amount == 0) return 0;
		int min = amount;
		for(int coin:coins) {
			int x = amount - coin;
		
			if(x >=0) {
				int c = makeChange(coins, x);
				if(c < min) {
					min = c;
				}
			}
		}
		return min+1;
	}

}
