import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class permute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3};
		
		 ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		getPermute(arr, 0 , arr.length-1, result);
		System.out.println(result);
		String a = "bc";
		getIT(a, "");
		getAllPermute("aabc");

	}
	
	private static void getIT(String s, String prefix) {
		if(s.length() == 0) {
			System.out.println(prefix);
		}
		for(int i = 0; i < s.length(); i++) {
			getIT(s.substring(0, i)+s.substring(i+1),prefix+s.charAt(i));
		}
	}

	//Om Sai Ram
	/*
	 * with repetition allowed
	 */

	private static void getAllPermute(String s) {
		ArrayList<Integer> bucket = new ArrayList<Integer>(); 
	
		TreeMap<Character, Integer> map = new TreeMap<>();
		
		for(char c: s.toCharArray()) {
			map.compute(c, (k, v)->{
				if(v == null)
					return 1;
				else
					return v + 1;
			});
			
			char str[] = new char[map.size()];
			int count[] = new int[map.size()];
			char[] result = new char[s.length()];
			int index = 0;
			for(Entry<Character, Integer> entry: map.entrySet()) {
				str[index] = entry.getKey();
				count[index] = entry.getValue();
				index++;
			}
			
			permuteUtil(str, count, result,  0);
			
		}
	}
	private static void permuteUtil(char[] str, int[] count, char[] result, int level) {
		// TODO Auto-generated method stub
		
		if(level == result.length) {
			System.out.println(result);
			return;
		}
		
		for(int i = 0; i < count.length; i++) {
			if(count[i]==0) continue;
			result[level] = str[i];
			count[i]--;
			permuteUtil(str, count, result, level+1);
			count[i]++;
			
		}
		
	}

	private static void getPermute(int arr[],  int l, int r, ArrayList<ArrayList<Integer>> result) {
		// TODO Auto-generated method stub
		if(l == r) {
			result.add(getArrayList(arr));
		}
		
		for(int i  = l ; i <= r; i++) {
			swap(arr, l , i);
			getPermute(arr, l+1, r, result);
			swap(arr, l, i);
		}
			
		
	}

	private static void swap(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
		
	}

	private static ArrayList<Integer> getArrayList(int[] arr) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<>();
		for(int i : arr) {
			a.add(i);
		}
		return a;
	}

}
