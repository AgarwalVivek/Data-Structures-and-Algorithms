import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class verticalOrder{
	Node root;
	public class Node{
		int data;
		Node left;
		Node right;
		Node parent;
		public Node(int d) {
			data = d;
			left = right = null;
			parent = null;
		}
	}
	public Node insert(Node root, int item) {
		if (root == null) {
			root = new Node(item);
	
		} else {
			if(root.data < item) {
				root.right = insert(root.right, item);
				root.right.parent = root;
			} else {
				root.left = insert(root.left, item);
				root.left.parent = root;
			}
		}
		return root;
	}
	public verticalOrder() {
		// TODO Auto-generated constructor stub
	}

	public void vertical(Node root) {
		LinkedList<Node> ll = new LinkedList<>();
		HashMap<Integer,LinkedList<Node>>hm = new HashMap<>();
		getVerticalOrder1(root, hm, 0);
		Map<Integer, LinkedList<Node>> map = new TreeMap<>(hm);
		for(Entry<Integer, LinkedList<Node>> m: map.entrySet()) {
			
			System.out.print("KEY "+m.getKey());
			for(Node n: m.getValue()) {
				System.out.print("\t"+n.data+"\t");
			}
			System.out.println();
		}
		//System.out.println(hm.size());
	}
	
	private void getVerticalOrder1(Node root, HashMap<Integer, LinkedList<Node>> hm, int hd) {
		// TODO Auto-generated method stub
		if(root == null) return;
		getVerticalOrder1(root.left, hm, hd - 1);
		
		if (hm.containsKey(hd)) {
			LinkedList<Node> lm = hm.get(hd);
			lm.add(root);
			//hm.put(hd,  lm);
		}else {
			LinkedList<Node> ll = new LinkedList<>();
			ll.add(root);
			hm.put(hd, ll);
		}
		
		getVerticalOrder1(root.right, hm, hd +1);
		
	}
//	private Node getVerticalOrder(Node root, HashMap<Integer, LinkedList<Node>> hm, int hd) {
//		// TODO Auto-generated method stub
//		
//		if (root == null) return root;
//		
//		root.left = getVerticalOrder1(root.left, hm, hd - 1);
//		hm.put(hd, root);
//		root.right = getVerticalOrder1(root.right, hm, hd +1);
//		return root;
//		
//	}
	public static void main(String [] args) {
		verticalOrder obj = new verticalOrder();
		obj.root = obj.insert(obj.root, 50);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 40);
		//obj.root.data = 90;
	
		obj.root = obj.insert(obj.root, 70);
//	
		obj.root = obj.insert(obj.root, 60);
		obj.root = obj.insert(obj.root, 80);
		obj.vertical(obj.root);
		
	}


}
