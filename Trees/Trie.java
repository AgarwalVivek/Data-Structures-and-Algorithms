import java.util.HashMap;

public class Trie {

	Trie(){
		root = new TrieNode();
	}

	TrieNode root;
	
	class TrieNode{
		boolean isWord;

		HashMap<Character, TrieNode> children;
		
		TrieNode(){
			children = new HashMap<>();
			isWord = false;
		}
		
		public void insert(TrieNode root, String s) {
			TrieNode cur  = root;
			TrieNode next = null;
			for(int i = 0; i < s.length(); i++) {
				if(cur.children.get(s.charAt(i)) == null) {
						cur.children.put(s.charAt(i), new TrieNode());
				}
				next = cur.children.get(s.charAt(i));
				cur = next;
			}
			System.out.println(cur.children.size());
			cur.isWord = true;
			}

		public boolean query(TrieNode root, String s, int index) {
			TrieNode cur = root;
			
			if(index == s.length()) {
				if(cur.isWord == true) {
					return true;
				} else {
					return false;
				}
			}
				
			TrieNode next = cur.children.get(s.charAt(index));
				
			if(next == null) {
				return false;
			} 
			
				return query(next, s, index+1);			
	
		}
		public boolean isPresent(TrieNode root, String string) {
			// TODO Auto-generated method stub
			TrieNode cur = root;
			for(int i =  0; i < string.length(); i++) {
				TrieNode node = cur.children.get(string.charAt(i));
			
				if(node == null) return false;
				cur = node;
				
			}
			if(cur.isWord == true) return true;
			return false;
		}

		public boolean delete(TrieNode root, String string, int index) {
		
			if(index == string.length()) {
				System.out.println("here");
				if(root.isWord == true) {
					//found word mark it as not a word.
					root.isWord = false;
				} else {
					return false;
				}
				return root.children.size() == 0;
			}
			char ch = string.charAt(index);
			System.out.println(ch);
			TrieNode node = root.children.get(ch);
		
			if(node == null) {
				//not found any such child node with val = ch
				return false;
			}
			boolean shouldDeleteCurNode = delete(node, string, index+1);
			
			if(shouldDeleteCurNode == true) {
				System.out.println(shouldDeleteCurNode);
				root.children.remove(ch);
				return root.children.size() == 0;
			}
			
			return false;
			
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie obj = new Trie();
	    obj.root.insert(obj.root, "aba");
	    System.out.println("debug");
	    obj.root.insert(obj.root, "abd");
	    System.out.println(obj.root.isPresent(obj.root, "aba"));
	    System.out.println(obj.root.isPresent(obj.root, "abd"));
	    System.out.println(obj.root.delete(obj.root, "aba", 0));
	    System.out.println(obj.root.isPresent(obj.root, "aba"));
	    System.out.println(obj.root.query(obj.root, "abd", 0));
	    
	}

}
