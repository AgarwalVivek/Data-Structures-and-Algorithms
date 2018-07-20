import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BFSQueue {
	Node root;
	public class Node{
		int data;
		Node left;
		Node right;
		Node parent;
		int level;
		public Node(int d){
			data = d;
			left = null;
			right = null;
		
		}
		
	}
	static ArrayList<Node> arr = new ArrayList<Node>();
	
	

	private Node inOrderTraversal(Node root, int flag) {
		// TODO Auto-generated method stub
		if(root != null) {
			
		
				
			inOrderTraversal(root.left, 0);
			
			inOrderTraversal(root.right, 1);
			
		}
		return root;
		
	}

	private void BFS(Node root) {
		Queue<Node> q  = new LinkedList<>();
		ArrayList<Node> arr = new ArrayList<>();
		
		int level = 0;
		if (root != null) {
		
			q.add(root);
			
			while(!q.isEmpty()) {
				
				Node x = q.poll();
				if(x != null) {
					x.level = level;
					arr.add(x);
					if (x.left != null) {
						x.left.level = level + 1;
				
						q.add(x.left);
					} 
					if (x.right != null) {
						x.right.level = level+1;
					
						q.add(x.right);
					}
				}
				
			}
		
	      }
		for(Node a: arr) {
			System.out.println(a != null?a.data : null);
		}
}
	private  Node insert(Node root, int i) {
		// TODO Auto-generated method stub
		if(root == null) {
			root  = new Node(i);
			
				
		} else {
			if (i > root.data) {
				root.right = insert(root.right, i);
			} else if(i < root.data) {
				root.left = insert(root.left, i);
				
				
			}
	
			
			}
		return root;
		}
		
	public static void main(String args[]) {
		BFSQueue obj = new BFSQueue();
		obj.root = null;
		
		obj.root  = obj.insert(obj.root, 10);

		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 1);
		obj.root = obj.insert(obj.root, 2);
		obj.root = obj.insert(obj.root, 100);
		obj.root = obj.insert(obj.root, 20000);
		

		
		
		//obj.inOrderTraversal(obj.root, 0);
		System.out.println("\nhhh\n");
		obj.BFS(obj.root);
		System.out.println("\n\n");
//		for(Node x: arr) {
//			System.out.println(x!=null?x.data:null);
//		}
//		
		
	}

	}
	
	

