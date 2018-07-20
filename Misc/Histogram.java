import java.util.Stack;

public class Histogram {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,1,5,6,2,3};
		
		int getMaxArea = calcAreaHistogram(arr);
		System.out.println(getMaxArea);

	}

	private static int calcAreaHistogram(int[] arr) {
		// TODO Auto-generated method stub
		
		int i = 0;
		int max = 0;
		int curMax = 0;
		int area =0;
		Stack<Integer> s = new Stack<>();
		
		while(i < arr.length) {
			if(s.isEmpty() || arr[s.peek()] <=arr[i]) {
				s.push(i);
				i++;
			} else {
				 curMax = s.pop();
				area = arr[curMax] * ( s.isEmpty()? i -1:i-1-s.peek());
				if(area > max )
					max = area;
			}
		}
		
		while(!s.isEmpty()) {
			curMax = s.pop();
			area = arr[curMax] *(s.isEmpty()? i-1:i-1-s.peek());
			if(area > max)
				max = area;
			
		}
		return max;
	}

}
