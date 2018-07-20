import java.util.HashMap;

public class EnglishWords {

	HashMap<Integer, String> db = new HashMap<>();
	HashMap<Integer, String> comma = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnglishWords obj = new EnglishWords();
		String res = obj.numberToWords(213433456);

		System.out.println(res);
	}

    public String numberToWords(int num) {
    		createPair();
    	 
    		StringBuilder result = new StringBuilder();
    		
    		String numString = getUSFormat(num);
		
    		int length = numString.length();
    		String metaString = new String();
    		int cur = -1;
    		while(numString.indexOf(",") != -1) {
    			System.out.println("here");
    			metaString = numString.substring((cur+1), numString.indexOf(","));
    			cur = numString.indexOf(",");
    			getString(Integer.parseInt(metaString), result);
    			System.out.println(result);
    			String commaString = getScaleString(length-cur);
    		
    			
    			if(commaString != null)
    				result.append(commaString);
    			else {
    				if(length-cur <4)
    					break;
    			}
    			//length = length - cur;
    			
    			numString = numString.substring(cur+1, numString.length());
    			System.out.println(numString+"\t"+cur+"\t"+result);
    		}
    		
    	getString(Integer.parseInt(numString.substring(cur+1, numString.length())), result);

    		
    	
    		return result.toString();
        
    }

	private void getString(int num, StringBuilder result) {
		// TODO Auto-generated method stub
		if(num >100) {
				result.append(db.get(num/100));
				num %= 100;
				result.append("Hundred");
				
		}
		if(num >=19) {
			result.append(db.get(((num/10)*10)));
			num = num - ((num/10)*10);
			
		}
		if(num >10) {
			result.append(db.get(num%10));
			result.append("teen");
			num = num - ((num/10)*10);
			
		} else
		
		if(num >0) {
			result.append(db.get(num));
		}
		
	}

	

	private String getScaleString(int i) {
		// TODO Auto-generated method stub
		if(comma.containsKey(i)) {
			return comma.get(i);
		} else 
			return null;
	}

	private String getUSFormat(int num) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		int x = num;
		int count = 0;
		while(x > 0) {
			str.append(x%10);
			count++;
			if(count == 3) {
				str.append(",");
				count = 0;
			}
			x /= 10;
		}
		if(str.charAt(str.length()-1) == ',')
			str.setLength(str.length()-1);
		//System.out.println(str.reverse());
		return (str.reverse()).toString();
	}

	private void createPair() {
		// TODO Auto-generated method stub
		db.put(1,  "One");
		db.put(2, "Two");
		db.put(3, "Three");
		db.put(4,  "Four");
		db.put(5, "Five");
		db.put(6,  "Six");
		db.put(7, "Seven");
		db.put(8,  "Eight");
		db.put(9,  "Nine");
		db.put(10,  "Ten");
	
		comma.put(12, "Billion");
		comma.put(8, "Million");
		comma.put(4, "Thousand");
		
		
	}
	
	
    
}