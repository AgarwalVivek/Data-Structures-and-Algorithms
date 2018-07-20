

public class LCAParent {
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
	
	public Boolean checkPresent(Node root,int item) {
		
		if (root == null) {
			return false;
		} else {
			if (root.data == item) {
				return true;
			} else if (root.data > item) {
				return checkPresent(root.left,item);
			} else {
				return checkPresent(root.right, item);
			}
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCAParent obj = new LCAParent();
		obj.root =obj.insert(obj.root, 1);
	obj.root = obj.insert(obj.root, -1);
	obj.root = obj.insert(obj.root, 2);
	obj.root =obj.insert(obj.root, 5);
	obj.root =obj.insert(obj.root, 3);
	obj.root =obj.insert(obj.root, 7);

	obj.root =obj.insert(obj.root, 4);
	obj.root =obj.insert(obj.root, 6);
	obj.root =obj.insert(obj.root, 8);
	Node n1, n2;
	n1 = obj.root.right.right.left.right;
	n2 = obj.root.right.right.right.left;
	obj.inOrderTraversal(obj.root,0);
	Node bigger = null;
	Node smaller = null;
	if (obj.checkPresent(obj.root, 8) && obj.checkPresent(obj.root, 6)) {
		
	
		if ((obj.depth(n1, obj.root, 0 )) > (obj.depth(n2, obj.root, 0))) {
			System.out.println(obj.depth(n1,obj.root, 0));
			System.out.println(obj.depth(n2,obj.root, 0 ));
			bigger  = n1;
			smaller = n2;
		} else {
			System.out.println(obj.depth(n1,obj.root, 0 ));
			System.out.println(obj.depth(n2,obj.root, 0 ));
			bigger = n2;
			smaller = n1;
			
		}
		
		Node ancestor = obj.getLCA(bigger, smaller);
		System.out.println(ancestor != null ? ancestor.data: null);
	}
	


	
	
	}
	private Node parent(Node x) {
		return x !=  null? x.parent:null;
	}
	private  Node getLCA(Node bigger, Node smaller) {
		// TODO Auto-generated method stub
		System.out.println("bigger " + bigger.data+"smaller\t"+ smaller.data);
		while(parent(bigger) != smaller) {
			int h1 = depth(bigger, root, 0);
			int h2 = depth(smaller, root, 0);
			System.out.println(h1+"\t"+h2);
			if (h1 == h2) break;	
		
			bigger = parent(bigger);
		
		}
		System.out.println("depth "+depth(bigger, root, 0 )+"depth "+depth(smaller, root, 0 ));
		if(parent(bigger) == parent(smaller)) {
			return parent(smaller);
		}
		if (parent(bigger) == smaller) return smaller;
		
		while(smaller.data != bigger.data && (smaller != root || bigger != root)) {
			System.out.println("smaller and bigger"+ smaller.data +"\t"+bigger.data);
			smaller = parent(smaller);
			bigger = parent(bigger);
		}
		System.out.println("bigger " + bigger.data+"smaller\t"+ smaller.data);
		if (smaller == bigger) return smaller;
		
		return root;
	}
	private int depth(Node n1, Node root, int level) {
		// TODO Auto-generated method stub
		

		if (root == null) {
			return 0;
		} else if (root.equals(n1)) {
			return level;
		} else if (n1.data > root.data) {
	
			  level = depth(n1, root.right, level + 1);
		} else {
			
			level = depth(n1,root.left, level + 1); 
		}
		return level;
	}

}
