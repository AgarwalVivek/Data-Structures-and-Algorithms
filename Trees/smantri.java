
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class smantri implements Comparator<Integer> {

	public static int solution(int a[]) {
		TreeMap<Integer, Integer> hm = new TreeMap<>(Collections.reverseOrder());
		
		for(int x: a) {
			hm.compute(x, (key, val)->{
				if (val == null)
					return 1;
				else 
					return val+1;
			});
			
		
			
		}
		

		int maxKey= 0;
		int maxVal = 0;
		System.out.println(hm.firstKey());
		
		for(Entry<Integer, Integer> entry: hm.entrySet() ) {
			System.out.println(entry.getKey() +"\t"+entry.getValue());
			if(entry.getValue() > 1) {
				maxKey = entry.getKey();
				maxVal = entry.getValue();
				break;
			}
		}

	System.out.println(maxKey+" occured "+maxVal +" times");
	return maxVal;
	}

	public static void main(String args[]) {
		int arr[] = {12,12,45,10,1,10,13, 13, 12};
		solution(arr);
	}
	@Override
	public int compare(Integer x, Integer y) {
		// TODO Auto-generated method stub
		if (x > y) return 1;
		else return -1;
	}
}
