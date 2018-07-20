

public class checkBSTBetter2 {
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

	public Boolean checkBSTUTil(Node root, Integer min, Integer max) {
		count++;
		if (root == null) 
			return true;
		if ((min != null && min > root.data) ||( max != null && max < root.data)) {
			return false;
		}
		if (!checkBSTUTil(root.left, min, (Integer)root.data))
			return false;
		if (!checkBSTUTil(root.right, root.data, max)) {
			return false;
		}
		return true;
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
	
	
		
	private Boolean checkBST(Node root, Integer min, Integer max) {
		count++;
		System.out.println("Enter with root data ");
		if (root != null) System.out.println(root.data);
		if (root == null)
			return true;
		System.out.println("EXTERIOR min not null, mX "+min+"\t"+max);
		if ((min != null && min>= root.data) || (max != null && max < root.data)) {
			System.out.println("min not null, mX "+min+"\t"+max);
			return false;
		}
		 if (!checkBST(root.left,min, root.data)&& !checkBST(root.right,root.data ,max)) {
			 System.out.println("recursion");
			 return false;
		 }
	
		 return true;
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
		checkBSTBetter2 obj = new checkBSTBetter2();

		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 10);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 35);
	
		obj.root = obj.insert(obj.root, 5);
		
		obj.root = obj.insert(obj.root, 15);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, 7);
		obj.root = obj.insert(obj.root, 17);
		
		System.out.println(obj.checkBST(obj.root,null, null));

		System.out.println(count);
		System.out.println("here own implementation");
		System.out.println(obj.checkBSTUTil(obj.root, null, null));
		System.out.println(count);

	}


}

