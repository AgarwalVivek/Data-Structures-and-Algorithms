import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class diameter {
	Node root;
	class Height{
		int h;
	}
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
	public diameter() {
		// TODO Auto-generated constructor stub
		
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
	public int BetterDiameter(Node root, Integer ans) {
		if (root == null)
			return 0;
		int lHeight = BetterDiameter(root.left, ans);
		int rHeight = BetterDiameter(root.right, ans);
		
		ans = Math.max(ans, 1+ lHeight+rHeight);
		System.out.println(ans);
		return 1 + Math.max(lHeight, rHeight);
		
	}
	public int Better2Diameter(Node root, Height height) {
		if (root == null) {
			height.h = 0;
			return 0;
		}
		Height lh = new Height();
		Height rh = new Height();
		
		lh.h++;
		rh.h++;
		int lDiameter = Better2Diameter(root.left,lh );
		int rDiameter = Better2Diameter(root.right, rh);
		System.out.println(lh.h+"\t"+rh.h);
		height.h = Math.max(lh.h, rh.h)+1;
		System.out.println(lh.h+"\t"+rh.h+"\t"+height.h+"\tLDIA\t"+lDiameter+"\trDIA\t"+rDiameter);
		
		return Math.max(Math.max(lDiameter, rDiameter), 1 + lh.h+rh.h);
		
		
	}
	public int BFDiameter(Node root) {
		if (root == null) 
			return 0;
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		int ldiameter = BFDiameter(root.left);
		int rdiameter = BFDiameter(root.right);
		
		return Math.max(Math.max(ldiameter,  rdiameter), 1+ lHeight+rHeight);
		
			
	}
	
	
	private int height(Node n) {
		
		if (n == null) return 0;
		else 
			return 1 + Math.max(height(n.left), height(n.right));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		diameter obj = new diameter();
		obj.root = obj.insert(obj.root, 2);
		obj.root = obj.insert(obj.root, 1);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, -1);
		obj.root = obj.insert(obj.root, 4);
		obj.root = obj.insert(obj.root, 5);
		
		//obj.LevelOrder(obj.root);
//		System.out.println();
//		obj.LevelOrder1(obj.root);
//		
//		diameter obj1 = new diameter();
//		obj1.root = obj1.insert(obj1.root, 2);
//		obj1.root = obj1.insert(obj1.root, 1);
//		obj1.root = obj1.insert(obj1.root, 3);
//		obj1.root = obj1.insert(obj1.root, -1);
//		obj1.root = obj1.insert(obj1.root, 4);
//		obj1.root = obj1.insert(obj1.root, 5);
//		System.out.println(obj.isIdentical(obj.root, obj1.root));
		
//		System.out.println(obj.BFDiameter(obj.root));
//		Integer ans = Integer.MIN_VALUE;
//		obj.BetterDiameter(obj.root, ans );
		System.out.println("lh.h\t"+"rh.h"+"\t"+"height.h"+"\tLDIA\t"+"lDiameter"+"\trDiameter");
		System.out.println(obj.Better2Diameter(obj.root, obj.new Height()));
		
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


