import java.awt.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class TrieClass {
    LocalDateTime now;
	TrieNode root;
	
	public TrieClass(String dict[]) {
		root = new TrieNode("");
		
		for(String s: dict) {
			//root.insert(root, s);
			root.recursiveInsert(root, s, 0);
		}
	}
	public class TrieNode{
		int size=0;
		String prefix;
		HashMap<Character, TrieNode> children;
		boolean isWord;
		
		public TrieNode(String s) {
			prefix = s;
			children = new HashMap<>();
			isWord = false;
		}

		public void recursiveInsert(TrieNode root, String s, int index) {
			// TODO Auto-generated method stub
			TrieNode cur = root;
			cur.size++;
		    System.out.println(cur.size);
			if(s.length() == index) {
				cur.isWord = true;
				return;
			}
			
			TrieNode child = cur.children.get(s.charAt(index));
			
			if(child == null) {
				//insert this child
				cur.children.put(s.charAt(index), new TrieNode(s.substring(0, index+1)));
			}	
			child = cur.children.get(s.charAt(index));
			recursiveInsert(child,s,index+1);
		}

		public void insert(TrieNode root, String s) {
			TrieNode cur = root;
			TrieNode child = null;
			for(int i = 0; i < s.length(); i++) {
				//check if this entry is present in next nodes/children set
				child = cur.children.get(s.charAt(i));
				
				if(child == null) {
					cur.children.put(s.charAt(i), new TrieNode(s.substring(0, i+1)));
				} 
					//getting address of next children/node and traversing
					cur = cur.children.get(s.charAt(i));
			}
			cur.isWord = true;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String dict[]  = {"Shraddha", "Shonu", "Sonu", "Swapnil", "Sikha", "Spandan", "Google", "Gmail", "AWS", "Awasti"};
		TrieClass obj = new TrieClass(dict);
		ArrayList<String> result = obj.getAllWithPrefix("S");
		for(String s: result) {
			System.out.println(s);
		}
		

	}
	private ArrayList<String> getAllWithPrefix(String string) {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<>();
		TrieNode cur = root;
		TrieNode next = null;
		for(char ch: string.toCharArray()) {
			next = cur.children.get(ch);
			if(next == null) {
				System.out.println("here");
				return result;
			} else {
				cur = next;
			}	
		}
	    getAllStrings(next, result);
		return result;
	}
	private void getAllStrings(TrieNode root, ArrayList<String> result) {
		// TODO Auto-generated method stub
		System.out.println("here");
		
		if(root.isWord == true) {
			result.add(root.prefix);
		}
		//traverse through the hashmap
		for(char ch : root.children.keySet()) {
			System.out.println(ch);
			getAllStrings(root.children.get(ch), result);
			
		}
		
	}
	

}
