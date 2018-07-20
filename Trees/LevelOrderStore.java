import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;



public class LevelOrderStore {
	Node root;
	ArrayList<LinkedList<Node>> arrL = new ArrayList<>();
	public Node insert(Node root, double d) {
		if (root == null) {
			root = new Node(d);
		} else {
			if(root.data < d) {
				root.right = insert(root.right, d);
			} else {
				root.left = insert(root.left, d);
			}
		}
		return root;
	}
	public static int  getHeight(Node root) {
		if (root == null) {
			return 0;
		} else {
			int lHeight = 1 + getHeight(root.left);
			int rHeight = 1 + getHeight(root.right);
			if (lHeight > rHeight) {
				return lHeight;
			} else 
				return rHeight;
		}
		
	}
	public static void main(String args[]) {
		LevelOrderStore obj = new LevelOrderStore();
		obj.root = obj.insert(obj.root, 2);
		obj.root = obj.insert(obj.root, 1);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, -1);
		obj.root = obj.insert(obj.root, 4);
		obj.root = obj.insert(obj.root, 5);
		int height = getHeight(obj.root);
		System.out.println(height);
		for(int i = 0; i < height; i++) {
			System.out.println("Level:\t" + i);
			LinkedList<Node> n = new LinkedList<>();
			obj.OrderbyOrder(obj.root, i, n);
			obj.printLL(n);
			obj.arrL.add(n);
		
		}
		System.out.println();
		obj.printArrayList(obj.arrL);
		
	}
	private void printArrayList(ArrayList<LinkedList<Node>> arrL2) {
		// TODO Auto-generated method stub
		for(LinkedList a: arrL2) {
			while(!a.isEmpty()) {
				Node elt = (Node)a.poll();
				System.out.print("\t"+elt.data);
			}
			System.out.println();
		}
			System.out.println();
		}
		
	
	private void printLL(LinkedList<Node> n) {
		// TODO Auto-generated method stub
		for(Node x: n) {
			System.out.println(x.data);
		}
		
	}
	private void OrderbyOrder(Node root, int level, LinkedList<Node> n) {
		// TODO Auto-generated method stub
		if(root == null) return;
		if(level == 0)
			n.add(root);
		else {
			OrderbyOrder(root.left, level -1, n);
			OrderbyOrder(root.right, level - 1, n);
		}
		
	}
}
