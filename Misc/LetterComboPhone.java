import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LetterComboPhone {
	static String dict[][] = {{},{},{"a","b","c"}, {"d","e", "f"}, {"g", "h", "i"},
			{"j", "k", "i"},{"l","m","n"},{"o","p","q", "r"}, {"s", "t", "u", "v"}, {"w", "x", "y","z"}};
	
			 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LetterComboPhone obj = new LetterComboPhone();
		String digits = "23";
		int flag = 1;
		System.out.println(obj.getList("23"));
		LinkedList<String> st = new LinkedList<>();
		String finalDigit[] = dict[Integer.parseInt(digits.charAt(0)+"")];
		String []nextDigit;
		String result[];
		for(int k = 1; k < digits.length(); k++) {
			
			nextDigit= dict[Integer.parseInt(digits.charAt(k)+"")];
			result  = new String[finalDigit.length*nextDigit.length];
			int idx = 0;
			for(int i = 0; i < finalDigit.length; i++) {
				
				for(int j = 0; j< nextDigit.length; j++) {
					result[idx++] = finalDigit[i] + nextDigit[j];
					System.out.println("debug");
					
				}
				
			    
			}
			finalDigit =  result;
		}
		System.out.println(Arrays.toString(finalDigit));

	}


	private List<String> getList(String digits) {
		// TODO Auto-generated method stub
		if(digits.length() == 0) 
			return new LinkedList<String>();
		
	
		return Arrays.asList(getCrossProduct(digits));

		
	}


	private String[] getCrossProduct(String digits) {
		// TODO Auto-generated method stub
		String finalDigit[] = dict[Integer.parseInt(digits.charAt(0)+"")];
		String nextDigit[];
		String[] str ;
		int idx;
		
		for(int k = 1; k < digits.length(); k++) {
			nextDigit= dict[Integer.parseInt(digits.charAt(k)+"")];
			idx = 0;
			str = new String[finalDigit.length* nextDigit.length];
			for(int i = 0; i < finalDigit.length; i++) {
				for(int j = 0; j < nextDigit.length; j++){
					str[idx++] = finalDigit[i] + nextDigit[j];
				}
			}
			finalDigit = str;
			
		}
		return finalDigit;
	}

}
