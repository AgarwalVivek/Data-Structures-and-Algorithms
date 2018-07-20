import java.util.ArrayList;

public class TrieS {
	Node head;
	TrieS(){
		head = new Node(null);
	}
	
	class Node {
		Node list[];
		String s;
		boolean isWord;
		public Node(String s) {
			this.s = s;
			this.list = new Node[26];
			this.isWord = false;
		}
		public void insert(String s) {
//			if(head == null) {
//				head = new Node("");
//			}
			Node cur = head;
			for(int i = 0; i < s.length();i++) {
			
				char c = s.charAt(i);
				if(cur.getNode(c) == null) {
					Node n = new Node(c+"");
					cur.setNode(n,c );
				}
				cur = cur.list[c-'a'];
			}
			cur.isWord = true;
			
			
		}
		private boolean delete(String s, int index, Node head) {
			if(s.length()-1 == index) {
				if(head.isWord == false) {
					return false;
				}
				head.isWord = false;
				return head.list.length == 0;
			}
			char c = s.charAt(index);
			Node x = head.getNode(c);
			if(x == null) {
				return false;
			}
			boolean shouldDelete = delete(s, index+1, x);
			return shouldDelete;
			
//			if(shouldDelete) {
//				if(x.list.)
//			}
			
		}
		public boolean print(Node head, String s) {
			Node cur = head;
			for(int i  = 0; i < s.length(); i++) {
				if(cur.getNode(s.charAt(i)) == null){
					return false;
				} else {
					System.out.println(cur.getNode(s.charAt(i)).s);
					cur = cur.getNode(s.charAt(i));
				}
			}
		return cur.isWord == true;
			
		}
		
		public int getIndex(char c) {
			return (int)(c-'a');
		}
		public Node getNode(char c) {
			return list[c-'a'];
		}
		public void setNode(Node b, char c) {
			list[c-'a'] = b;
		}
		
	}
	
	
	public void insert(Node head, String s) {

		head.insert(s);
	}
	public boolean print(Node head, String s) {
		return head.print(head, s);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		TrieS obj = new TrieS();
		Node root = obj.head;
		
		
		obj.insert(obj.head, s);
		obj.insert(obj.head, "bac");
		System.out.println(obj.print(obj.head, s));
		System.out.println(obj.print(obj.head, "bac"));

		ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
		ar.
	}

}
