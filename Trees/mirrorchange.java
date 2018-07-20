import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class mirrorchange {
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
	public mirrorchange() {
		// TODO Auto-generated constructor stub
		
	}
	public Node mirror(Node root) {
		if (root != null) {
			Node left = mirror(root.left);
			Node right = mirror(root.right);
			root.right = left;
			root.left = right;
			return root;
		}
		return root;
		
		
	}
	public Boolean isIdentical(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null)
			return false;
		
		if (!isIdentical(root1.left, root2.left))
			return false;
		if (!isIdentical(root1.right, root2.right))
			return false;
		
		return true;
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
		
	private void inOrderTraversal(Node root) {
		// TODO Auto-generated method stub
		
		if(root != null) {
			inOrderTraversal(root.left);
			
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mirrorchange obj = new mirrorchange();
		obj.root = obj.insert(obj.root, 2);
		obj.root = obj.insert(obj.root, 1);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, -1);
		obj.root = obj.insert(obj.root, 4);
		obj.root = obj.insert(obj.root, 5);
		
		obj.LevelOrder(obj.root);
		System.out.println();
		obj.LevelOrder1(obj.root);
		
		mirrorchange obj1 = new mirrorchange();
		obj1.root = obj1.insert(obj1.root, 2);
		obj1.root = obj1.insert(obj1.root, 1);
		obj1.root = obj1.insert(obj1.root, 3);
		obj1.root = obj1.insert(obj1.root, -1);
		obj1.root = obj1.insert(obj1.root, 4);
		obj1.root = obj1.insert(obj1.root, 5);
		System.out.println(obj.isIdentical(obj.root, obj1.root));
		System.out.println("Lets see mirror");
		obj1.mirror(obj1.root);
		obj.LevelOrder(obj1.root);
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


