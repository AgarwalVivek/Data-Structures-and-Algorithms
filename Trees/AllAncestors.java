

public class AllAncestors {

	public AllAncestors() {
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
	private int getAllAnc(Node root, Node target) {
		// TODO Auto-generated method stub
		if (root == null) return 0;
		
		if (root.left == target || root.right == target || getAllAnc(root.left, target) == 1 || getAllAnc(root.right, target) == 1) {
			System.out.println(root.data);
			return 1;
		}
		return 0;
			
	}
public static void main(String[] args) {
		
	AllAncestors obj = new AllAncestors();
		obj.root = obj.insert(obj.root, 50);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 40);
		
		obj.root = obj.insert(obj.root, 70);
//	
		obj.root = obj.insert(obj.root, 60);
		obj.root = obj.insert(obj.root, 80);
		obj.inOrderTraversal(obj.root,0);
		
		obj.getAllAnc(obj.root, obj.root.right.right);
}


}
