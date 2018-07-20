

public class chekcBSTBetter3 {
	public static int count = 0;
	class Node{
		int data;
		Node parent;
		Node left, right;
		public Node(int d){
			data = d;
			left = right = null;
		}
		public Node(Node x, int d) {
			x.data = d;
			x.right = null;
			x.left  = null;
		}
	}

	private Node root;
	private Node inOrderTraversal1(Node root, int flag) {
		// TODO Auto-generated method stub
		if(root != null) {

		
				
			inOrderTraversal1(root.left, 0);
			System.out.print(root.data+"has parent ");
			System.out.println(root.parent != null?root.parent.data : null);
			inOrderTraversal1(root.right, 1);
			
		}
		return root;
		
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

		
				
			inOrderTraversal1(root.left, 0);
			System.out.print(root.data+"has parent ");
			System.out.println(root.parent != null?root.parent.data : null);
			inOrderTraversal1(root.right, 1);
			
		}
		return root;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chekcBSTBetter3 obj = new chekcBSTBetter3();

		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 10);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 35);
	
		obj.root = obj.insert(obj.root, 5);
		
		obj.root = obj.insert(obj.root, 15);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, 7);
		obj.root = obj.insert(obj.root, 17);
		
		//System.out.println(obj.checkBST(null, obj.root, null));

		System.out.println(count);
		System.out.println("here own implementation");
		System.out.println(obj.checkBSTUTil(null, obj.root,  null));
		System.out.println(count);
		obj.inOrderTraversal1(obj.root, 0);
		
	
	}
	private Boolean checkBSTUTil(Integer min, Node root, Integer max) {
		// TODO Auto-generated method stub
		count++;
		if (root == null)
		return true;
		
		if ((min != null && min >= root.data)|| (max != null && max < root.data))
			return false;
		
		if ((!checkBSTUTil(root.data, root.right, max)) && (!checkBSTUTil(min, root.left, root.data))){
			return false;
		}
		return true;
	}
	
	
}
