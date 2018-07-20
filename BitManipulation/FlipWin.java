import java.util.ArrayList;

public class FlipWin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1775;//100
		//need to find which 0 to convert to 1 so that longest sequence of 1s can be achieved.
		ArrayList<Integer> freq = getSequence(n);
		for(int i : freq) {
			System.out.println(i);
		}

		System.out.println(getPosition(freq));
	}

	
	private static int getPosition(ArrayList<Integer> freq) {
		// TODO Auto-generated method stub
		int onesOnLeft = 0;
		int onesOnRight = 0;
		int zerosCount = 0;
		int currentLength = 0, maxLength = 0;
		for(int i =0; i < freq.size(); i +=2) {
			zerosCount = freq.get(i);
			 onesOnLeft = i+1 > 0 ? freq.get(i+1):0;
			 onesOnRight = i-1>0 ?freq.get(i-1):0;
			 
			 if(zerosCount == 1) {
				 currentLength = 1 + onesOnRight + onesOnLeft;
			 }
			 if(zerosCount >1) {
				 currentLength = 1 + Math.max(onesOnLeft, onesOnRight);
			 }
			 if(zerosCount ==0) {
				 currentLength = Math.max(onesOnRight, onesOnLeft);
				 
			 }
			 
			 if(currentLength > maxLength) {
				 maxLength = currentLength;
			 }
		}
		
		return maxLength;
	}


	private static ArrayList<Integer> getSequence(int n) {
		int count = 0;
		// TODO Auto-generated method stub
		int curDigit = 0;
		ArrayList<Integer> freq = new ArrayList<>();
		for(;n>0;n >>=1) {
			//is 0 for first iteration
			if(curDigit != (n &1)) {
				freq.add(count);
				curDigit = n &1;
				count = 0;
			}
			count++;
			
		}
		freq.add(count);
		return freq;
		
	}

}
