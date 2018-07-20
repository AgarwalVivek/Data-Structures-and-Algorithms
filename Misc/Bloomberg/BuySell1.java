package Bloomberg;

class BuySell1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuy = Integer.MAX_VALUE;
        if(prices.length ==0) return maxProfit;
        
        for(int i: prices){
            minBuy = Math.min(i, minBuy);
            maxProfit = Math.max(maxProfit, i- minBuy);
        }
        return maxProfit;
    }
    public static void main(String args[]) {
    		int arr[] = {7,1,2,4};
    		BuySell1 n = new BuySell1();
    		System.out.println(n.maxProfit(arr));
    		
    }
}
