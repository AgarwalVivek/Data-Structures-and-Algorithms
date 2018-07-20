import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MostFrequent {

	
	public static  List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> a){
		ArrayList<String> result = new ArrayList<>();
		TreeMap<String, Integer> map = new TreeMap<>();
		if(literatureText.length() == 0) return  result;
		if(a.size() == 0) {
			//split string into array of strings and return
			return Arrays.asList(literatureText.split("[^\\w]+"));
		}
		int maxFrequency = 0;
		String[] string = literatureText.split("[^\\w]+");
	
		for(int i = 0; i < string.length; i++) {
			String cur = string[i].toLowerCase();
			
			if(!Contains(a, cur)) {
			   
				map.compute(cur, (key, val)->{
					if(val == null)
						return 1;
					else 
						return val + 1;
				});
			
				
				if(maxFrequency < map.get(cur)) {
					maxFrequency = map.get(cur);
					
				}
			} 
		}

		for(Entry<String, Integer> entry: map.entrySet()) {
			if(entry.getValue() == maxFrequency) {
			System.out.println(entry.getKey());
			result.add(entry.getKey());
			}
		}
		return result;
		
	}
	private static boolean Contains(List<String> wordsToExclude, String cur) {
		// TODO Auto-generated method stub

		

		for(String str: wordsToExclude) {
	
			if(str.equalsIgnoreCase(cur)) {
				
				//System.out.println("match");
				return true;
			}
		}
		return false;
	}
	private boolean isSubstringOf(String cur, List<String> wordsToExclude) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String literatureText = "Jack and Jill went to the market to buy bread and cheese.Cheese is jack's and jill's favorite food";
//		
//		String[] wordsToExclude = {"and", "he","the", "to", "is", "Jack", "Jill"};
//		List<String> a =  Arrays.asList(wordsToExclude);
//		System.out.println(a);
//		System.out.println(retrieveMostFrequentlyUsedWords(literatureText, a));
		String literatureText = "Rose is a flower red rose is a flower";
		String[] words = {"are", "is", "a"};
		
		System.out.println(retrieveMostFrequentlyUsedWords(literatureText, Arrays.asList(words)));
			
		
		
		
		

	}

}
