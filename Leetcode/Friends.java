import java.util.ArrayList;
import java.util.HashSet;

public class Friends {

	public Friends() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		arr1.add(1);
		arr1.add(2);
		arr1.add(3);
		arr1.add(4);
		arr2.add(2);
		arr2.add(3);
		ArrayList<Integer> result = getMutual(arr1, arr2);
		for(int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}

	private static ArrayList<Integer> getMutual(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		// TODO Auto-generated method stub
		
		HashSet<Integer> hs = new HashSet<>();
		ArrayList<Integer> result = new ArrayList<>(); 
		addToHashSet(arr1, hs, result,  1);
		addToHashSet(arr2, hs, result, 2);
		
		
		return result;
	}

	private static void addToHashSet(ArrayList<Integer> arr, HashSet<Integer> hs, ArrayList<Integer> result, int j) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i< arr.size(); i++) {
			if (j ==1) {
				hs.add(arr.get(i));
			} else {
				//second list duplicates are mutual friends
				if (hs.contains(arr.get(i)) == false) {
					hs.add(arr.get(i));
				} else {
					result.add(arr.get(i));
				}
			}
		}
		
	}

}
