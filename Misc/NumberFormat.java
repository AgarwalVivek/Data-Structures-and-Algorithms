import java.util.ArrayList;

public class NumberFormat {
	//123456
	
	/*
	 * 6 
	 * "6" 
	 * 12345
	 * c = 1
	 * l = 5
	 * "56"
	 * c =2 l = 4
	 * "456" c = 3 "654," l = 3
	 * num = 123
	 * 654
	 */
	//123,312
//1,234,234
	public String getFormatted(int number) {
		if(number <= 0) return number+"";
		
		StringBuilder num = new StringBuilder();
		String check = number + "";
		int length = check.length();
		//one by one iterate over
		int count = 0;
		int rest = 0;
		while(length>0) {
			num.append(number %10+"");
			number /= 10;
			count++;
			if(count == 3) {
				count = 0;
				num.append(",");
			}
			length--;
		}
//		StringBuilder ret = new StringBuilder(number+"");
//		num.append(ret.reverse());
		ArrayList<Integer> re = new ArrayList<>();

	
		num.reverse();
		System.out.println(num);
		return num.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberFormat obj  = new NumberFormat();
		obj.getFormatted(12345456);
	}

}
