import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Level {
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
	public Level() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level obj = new Level();
		obj.root = obj.insert(obj.root, 2);
		obj.root = obj.insert(obj.root, 1);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, -1);
		obj.root = obj.insert(obj.root, 4);
		obj.root = obj.insert(obj.root, 5);
		
		obj.LevelOrder(obj.root);
	}
	private void LevelOrder(Node root) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<>();
		LinkedList<Node> ll = new LinkedList<>();
		
		if (root == null) return;
		
		q.add(root);
		
		while (!q.isEmpty()) {
			
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
	}
	
			
		
		
	
		
	
		
		
	}


