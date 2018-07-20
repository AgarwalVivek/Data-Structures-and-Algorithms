
public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int den[] = { 10, 6, 1};
		int numCoins = getNumCoins(12, den);
		System.out.println(numCoins);
		
	}

	private static int getNumCoins(int c, int[] den) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		if(c == 0) return 0;
		for(int i = 0; i < den.length; i++){
			int curCoins = c - den[i];
			if(curCoins >= 0) {
				int coin = getNumCoins(c - den[i], den);
			     if(min > coin) {
			    	 	System.out.println(i+" i\t"+curCoins+" curCoins\t"+ c+"\t min "+min+"\t "+coin+"\tcoin");
			    	 	min = coin;
			     }
			}
			
		}
		return (min+1);
	}

}
