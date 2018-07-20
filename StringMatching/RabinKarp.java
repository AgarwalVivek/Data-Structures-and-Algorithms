public class RabinKarp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcde";
		String b = "bcd";
		RabinKarp obj = new RabinKarp();
		System.out.println(obj.solution(a, b));
		System.out.println((int)'a');
		
		System.out.println((int)a.charAt(0));
		
	}

	private Boolean solution(String a , String b) {
	
		int length = b.length()-1;
		int factor = 2;
		int rollingHash = 0;
		int substringHash = getSubstringHash(b, factor);
		System.out.println("AS"+substringHash);
		String current = null;
		//start parsing the main string
		for(int i = 0; i+b.length()-1 < a.length(); i++) {
			//taking sets of length b
			//for first time we need to calculate the hash in one go
			  
			  current = a.substring(i, i+b.length());
			  System.out.println(current);
			if(i == 0) {
				rollingHash = getSubstringHash(current, factor);
			} else {
				System.out.println("currentFirst and next i and rolling"+ current.charAt(0)+"\t"+(i+b.length()-1)+"\t"+rollingHash);
				rollingHash = getRollingHash(a.charAt(i-1), a, i+b.length()-1, rollingHash, factor, b);
			}
			System.out.println(rollingHash);
			if (rollingHash == substringHash) {
				System.out.println(current);
				if(current.equals(b))
					return true;
			}
			//done parsing 
             if (current == null) return false;
			
			System.out.println(current + "\t"+ rollingHash);
			
			
		}
		return false;
	}								//a			abcde   [d]			//hash(abc)					//bcd
	private int getRollingHash(char charAt, String a, int i, int rollingHash, int factor, String b) {
		// TODO Auto-generated method stub
		System.out.println("vhar: "  + charAt);
		System.out.println("charAt val"+(int)charAt);
		int newHash = 0;
		if (i != a.length()) {
			int news = rollingHash - charAt;
			System.out.println(news);
			newHash = (int) ((news/factor) + a.charAt(i)*Math.pow(factor, b.length()-1));
		}
		return newHash;
	}

	private int getSubstringHash(String b, int factor) {
		// TODO Auto-generated method stub
		int hash = 0;
		for(int i = 0; i < b.length(); i++) {
			hash = (int) (hash + (int)b.charAt(i)*Math.pow(factor, i));
		}
		return hash;
	}

}
