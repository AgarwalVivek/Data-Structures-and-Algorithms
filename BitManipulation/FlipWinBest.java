import java.util.ArrayList;

public class FlipWinBest {
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1775;//100
		//need to find which 0 to convert to 1 so that longest sequence of 1s can be achieved.
        
	
	
		System.out.println(getPosition(n));
	}

	private static int getPosition(int n) {
		// TODO Auto-generated method stub 100101011
		int currentLength = 0;
		int previousLength = 0;
		int maxLength = 1;
		while(n>0) {
			if((n &1) == 1) {
				currentLength++;
			} else if((n & 1) == 0) {
				
				if((n&2) == 0) {
					previousLength = 0;
					
				} else {
					previousLength = currentLength;
					
				}
				currentLength = 0;
			}
			maxLength = Math.max(currentLength + 1+  previousLength, maxLength);
			n >>>=1;
		}
		return maxLength;
	}

}
