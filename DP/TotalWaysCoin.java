
public class TotalWaysCoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = 9;
		int S[] = {1,2, 3};
		int getCount = getCoinCount(N, S);
		System.out.println(getCount);
		getCount = getNaive(N, S.length,S);
		System.out.println(getCount);
		
	}

	private static int getNaive(int n, int length, int[] s) {
		// TODO Auto-generated method stub
		if(n == 0) return 1;
		if(n < 0) return 0;
		
		if(length <=0 && n>0) {
			return 0;
		}
		return getNaive(n, length-1, s) + getNaive(n-s[length-1], length, s);
	}

	private static int getCoinCount(int n, int[] s) {
		// TODO Auto-generated method stub
		int total[] = new int[n+1];
		//base case
		total[0] = 1;
		for(int i = 0; i < s.length;i++) {
			for(int j = s[i]; j <=n; j++) {
				total[j] = total[j] + total[j-s[i]];
			}
		}
		return total[n];
	}
	

}
