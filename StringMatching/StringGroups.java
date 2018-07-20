
public class StringGroups {

	public static String solution(String s, int K) {
		
		if(s.length() == 0) return "";
		String intermediate = s.toUpperCase().replaceAll("-","" );
		StringBuilder result = new StringBuilder();
		//"2-4A0r7-4k"
		int count = 0;
		for(int i = intermediate.length()-1; i >=0; i--) {
			
			if(count%K == 0 && count >0) {
				 result.append("-");
				 count  = 0;
			 }
			 count++;
			 result.append(intermediate.charAt(i));
			
			 
		}
		
		 return result.reverse().toString();
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "2-4A0r7-4k";
		System.out.println(solution(a, 4));
	}

}
