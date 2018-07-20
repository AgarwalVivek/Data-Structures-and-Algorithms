
public class CoinChangeIterative {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 13;
	
		int coins[] = {7, 3, 2, 6};
	
		int getCount = getNumCoins(coins, total);
		System.out.println(getCount);

	}
	/**
	 * 
	 * @param coins
	 * @param total
	 * @return
	 * coins = 7, 3, 2, 6
	 * i = 0
	 * curCoin = 7
	 * j = 1
	 * totals[7] = 1 + totals[7-7] = 0
	 * totals[8]= 1 + totals[8-7] = 
	 * 
	 */

	private static int getNumCoins(int[] coins, int total) {
		// TODO Auto-generated method stub
		int totals[] = new int[total+1];
		int result[] = new int[total+1];
		initialize(totals, Integer.MAX_VALUE-1);
		initialize(result, -1);
		totals[0] = 0;
		for(int i = 0; i < coins.length; i++) {
			int curCoin = coins[i];
			
			for(int j = 1; j < totals.length; j++) {
				if(curCoin <= j) {
					if(totals[j] > 1+ totals[j-curCoin]) {
						//System.out.println(totals[j]+"sas"+j+"asd"+totals[j-curCoin]);
						totals[j] = 1+totals[j-curCoin];
						result[j] = i;
						
					}
				}
			}
			
		}
		
		int start = result.length-1;
		if(result[start] == -1) System.out.println("nbot possinle");
		
		while(start != 0) {
			int j = coins[result[start]];
			System.out.println(j);
			start = start - j;
		}
		return totals[totals.length-1];
	}

	private static void initialize(int[] result, int constant) {
		// TODO Auto-generated method stub
		for(int i = 0; i < result.length; i++) {
			result[i] = constant;
		}
		
	}

}
