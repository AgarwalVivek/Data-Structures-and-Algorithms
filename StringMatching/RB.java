
public class RB {

	public RB() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String S = "Shraddha";
		String s = "ddha";
		
		//to keep segregated
		int factor  = 3;
		
		//remains fixed
		int sHash = getHash(s, factor);
		System.out.println(sHash);
		
		int SHash = getHash((S.substring(0, s.length())), factor);
		
		for(int i =0; i + s.length() - 1 < S.length(); i++) {
			String current = S.substring(i, i + s.length());
			System.out.println(current);
			
			if (i != 0) {
					//rolling hash
					SHash = getRolling(S.charAt(i-1), i+s.length()-1, S, SHash, factor, s);	
				
					System.out.println("help " + SHash+"\t"+ S.charAt(i - 1) +"\t"+ (i + s.length()));
			}
			if (sHash == SHash) {
				if (current.equals(s))
					System.out.println("FOUND");
			}
		}
		System.out.println("Not found");
		
	}

	private static int getRolling(int i, int j, String S, int SHash, int factor, String s) {
		// TODO Auto-generated method stub
		if(j == S.length()) return -1;
		
		SHash = SHash - i;
		SHash = SHash/factor;
		SHash += S.charAt(j) * Math.pow(factor, s.length() - 1);
		
		return SHash;
	}

	private static int getHash(String s, int factor) {
		// TODO Auto-generated method stub
		int hash = 0;
		
		for(int i = 0; i < s.length(); i++) {
			hash = (int)(hash + s.charAt(i)*Math.pow(factor, i));
		}
		return hash;
	}

}
