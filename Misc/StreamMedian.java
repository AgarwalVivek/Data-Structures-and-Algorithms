import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedian {


	

	public static double[] getMedian(int arr[]) {
		
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return (-1)*o1.compareTo(o2);
			}
		});
		PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
		int index = 0;
		double[] median = new double[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			addNumbers(lowers, highers, arr[i]);
			reBalance(lowers, highers);
			median[index++]= getMedians(lowers, highers);
		}

		Arrays.toString(median);
		return median;
	}
	private static double getMedians(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		// TODO Auto-generated method stub
		double total = lowers.size() + highers.size();
		if(total%2 == 0) {
	
			return (double)(lowers.peek()+ highers.peek())/2;
		} else {
			if(lowers.size()> highers.size()) {
				return lowers.peek();
			
			} else
				return highers.peek();
		}
	}
	private static void reBalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		// TODO Auto-generated method stub
		if(lowers.size() > highers.size() ) {
			reBalance(highers, lowers);
		}
		if(highers.size() - lowers.size() > 1) {
			lowers.offer(highers.poll());
		}
		
		
	}
	private static void addNumbers(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers, int i) {
		// TODO Auto-generated method stub
		if(lowers.size() == 0 || lowers.peek() > i) {
			lowers.offer(i);
		} else {
			highers.offer(i);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2 ,3,4 ,5, 6, 7,8, 9, 10};
		System.out.println(Arrays.toString(getMedian(arr)));
		
		

	}

}
