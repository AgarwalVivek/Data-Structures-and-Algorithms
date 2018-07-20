import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DeepestNode {
	Node root;
	class Node{
		int data;
		Node left, right;
		Boolean isVisited;
		int children;
		Node(int d){
		data = d;
		left = right = null;
		isVisited = false;
		
		}
		public Node() {
		isVisited = false;
		left = right = null;
			// TODO Auto-generated constructor stub
		}
	}
	public Node insert(Node root, int item) {
		if (root == null) {
			root = new Node(item);
		} else {
			if(root.data < item) {
				root.right = insert(root.right, item);
			} else {
				root.left = insert(root.left, item);
			}
		}
		return root;
	}
	public DeepestNode() {
		// TODO Auto-generated constructor stub
		
	}
	private void LevelOrder1(Node root) {
		Queue<Node> q = new LinkedList<>();
		if (root == null) return;
		//Om Sai Ram
		int level = 0;
		q.add(root);
		q.add(null);
		Node m = null;
		while(!q.isEmpty()) {
			Node elt = q.remove();
			if(elt != null) {
				m = elt;
			}
			if (elt == null) {
				if (!q.isEmpty()) {
				q.add(null);
				}
				level++;
			} else {
				System.out.print(elt.data+"\t");
				if (elt.left != null) {
					q.add(elt.left);
				}
				if (elt.right != null)
					q.add(elt.right);
				}
			System.out.println();
			}
		System.out.println("Here"+ level+"Deepest\t"+m.data);
}
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeepestNode obj = new DeepestNode();
		obj.root = obj.insert(obj.root, 2);
		obj.root = obj.insert(obj.root, 1);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, -1);
		obj.root = obj.insert(obj.root, 4);
		obj.root = obj.insert(obj.root, 5);
		
		obj.LevelOrder(obj.root);
		System.out.println();
		obj.LevelOrder1(obj.root);
	}
	private void LevelOrder(Node root) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<>();
		LinkedList<Node> ll = new LinkedList<>();
		
		if (root == null) return;
		int level = 0;
		q.add(root);
		
		while (!q.isEmpty()) {
			level++;
			while(!q.isEmpty()){
				
				ll.add(q.remove());
			}
		
			Iterator<Node> it = ll.iterator();
			while(it.hasNext()) {
				Node m = it.next();
				
				System.out.print("\t"+(m == null ? m: m.data));
				
				if (m.left != null) q.add(m.left);
				if (m.right != null) q.add(m.right);
			}
			System.out.println();
			ll.clear();
			
		}
		System.out.println(level);
	}
	
			
		
		
	
		
	
		
		
	}


