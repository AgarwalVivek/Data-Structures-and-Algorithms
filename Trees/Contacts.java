
public class Contacts {

	Node root;
	public static class Node{
		private static int NUMBER_OF_CHARACTERS = 26;
		Node[] children = new Node[NUMBER_OF_CHARACTERS];
		
		int size = 0;
		
		private static int getCharIndex(char c) {
			return  c - 'a';
		}
		
		private  Node getNode(char c) {
		   
			return children[getCharIndex(c)];
		}
		
		private void setNode(char c, Node node) {
			children[getCharIndex(c)] = node;
		}
		
		public void add(Node root, String s) {
			add(root, s, 0);
		
		}

		public void add(Node root, String s, int index) {
			// TODO Auto-generated method stub
			Node cur = root;
			cur.size++;
		
			if(index == s.length()) return;
				char current = s.charAt(index);
			
				Node node = getNode(current);
			
				if(node == null) {
					node = new Node();
					setNode(current, node);
				}
		
			add(node, s,index+1);
		}
	
	
	public int findCount(Node root, String s, int index) {
		Node cur = root;
		if(index == s.length())
			return cur.size;
		Node node = getNode(s.charAt(index));
		if(node == null) {
			return 0;
		}
		return findCount(node, s, index+1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contacts obj = new Contacts();
		obj.root = new Node();
		System.out.println("FSF");
		obj.root.add(obj.root,"hello",0);
		obj.root.add(obj.root, "hey", 0);
		obj.root.add(obj.root,"hemo",0);
		obj.root.add(obj.root,"helo",0);
		obj.root.add(obj.root,"helsslo",0);
		System.out.println(obj.root.findCount(obj.root, "he", 0));

	}

}
