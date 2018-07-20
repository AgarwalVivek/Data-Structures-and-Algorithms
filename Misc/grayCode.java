import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class grayCode {
	public List<Integer> grayCode(int n) {
	      List<Integer> result = new LinkedList<>();
	      for (int i = 0; i < 1<<n; i++)
	          result.add(i ^ i>>1);
	      return result;
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		grayCode obj = new grayCode();
		System.out.println(obj.grayCode(2));
		
		String x = "abc";
		
		int[] map = new int[26];
		for(int i  = 0; i < x.length(); i++) {
			System.out.println(x.charAt(i)-'a');
			map[x.charAt(i)-'a'] = 1;
		}
		ArrayList<Character> arr = new ArrayList<>();
		for(int i = 0; i < map.length; i++) {
			if(map[i] == 1) {
				arr.add((char)(i+'a'));
				System.out.println((char)(i+'a'));
			}
		}
		System.out.println(Arrays.toString(map));
		HashSet<Integer> ss = new HashSet<>();
		ss.add(1);
		ss.add(2);
		ss.add(3);
		
		
	}

}
