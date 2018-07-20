
public class RJT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String subject = "I like cheese only on weekdays";
		String subsequence = "like only";
		//expected = 
		getMissingSubsequene(subject, subsequence);
	}

	private static void getMissingSubsequene(String subject, String subsequence) {
		// TODO Auto-generated method stub
		String s1[] = subject.split(" ");
		String s2[] = subsequence.split(" ");
		
		//storing result in String array
		String result[] = new String[s1.length];
		boolean flag;
		int idx = 0;
		for(String s: s1) {
			flag = false;
			for(String r: s2) {
				if(r.equals(s)) {
					flag = true;
				}
			}
			if(!flag) {
				result[idx++] = s;
			}
		}
		//check if subsequence is in order or not 
		if(!checkSequence(s2, s1)) System.out.println("Not possible");
		else {
			for(String s: result)
				System.out.println(s);
		}
	}

	private static boolean checkSequence(String[] result, String[] s1) {
		// TODO Auto-generated method stub
		int cur = 0;
		for(int j = 0; j< result.length && result[j] != null; j++) {
			
			for(int i = 0; i < s1.length; i++) {
				if(result[j].equals(s1[i]) ) {
					System.out.println(i);
					if(cur > i) {
						return false;
					}
					cur = i;
				}
			}
		}
		return true;
	}
}
		
		

	

	


