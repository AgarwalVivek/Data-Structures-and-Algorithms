import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Diagonal {
	Queue<Node> q = new LinkedList<>();
	public Diagonal() {
		// TODO Auto-generated constructor stub
	}
	class Node{
		int data;
		Node parent;
		Node left, right;
		Node(int d){
			data = d;
			left = right = null;
		}
	}

	private Node root;
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
	
	private Node inOrderTraversal(Node root, int flag) {
		// TODO Auto-generated method stub
		if(root != null) {

		
				
			inOrderTraversal(root.left, 0);
			System.out.print(root.data+"has parent ");
			System.out.println(root.parent != null?root.parent.data : null);
			inOrderTraversal(root.right, 1);
			
		}
		return root;
		
	}
	
	public void DiagonallOrder(Node root) {
		
		
		
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node p = q.remove();
			
			if(p != null) {
				while(p != null) {
				System.out.println(p.data);
				if (p.left !=null)q.add(p.left);
				p = p.right;
				}
			} else {
				if (!q.isEmpty())
					q.add(null);
					
				
			}
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Diagonal obj = new  Diagonal();
		obj.root = obj.insert(obj.root, 50);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 40);
		
		obj.root = obj.insert(obj.root, 70);
//	
		obj.root = obj.insert(obj.root, 60);
		obj.root = obj.insert(obj.root, 80);
		obj.inOrderTraversal(obj.root,0);
		obj.DiagonallOrder(obj.root);
	}

}
