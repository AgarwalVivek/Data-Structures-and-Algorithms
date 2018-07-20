//Om Sai ram
public class LongestCommonSuSequence {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcdefghi";
		String b ="ancdeai";
	
		int max = getLCS(a, b);
		System.out.println(max);
		

	}
	

	private static int getLCS(String a, String b) {
		// TODO Auto-generated method stub
		int result[][] = new int[a.length()+1][b.length()+1];
		
		char []str1 = a.toCharArray();
		char []str2 = b.toCharArray();
		
		for(int i = 1; i<=a.length(); i++) {
			for(int j = 1; j <= b.length();j++) {
				if(str1[i-1]== str2[j-1]) {
					result[i][j] = 1+result[i-1][j-1];
				} else {
					result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
				}
			}
		}
		int i = a.length();
		int j = b.length();
		
		while(i > 0 && j >0 ) {
			if(str1[i-1] == str2[j-1]) {
				System.out.println(str1[i-1]);
				i--;
				j--;
			} else if(result[i-1][j] == result[i][j]) {
				i--;
				
			} else if(result[i][j-1] == result[i][j])
				j--;
		}
		
		return result[a.length()][b.length()];
	}

	
}
