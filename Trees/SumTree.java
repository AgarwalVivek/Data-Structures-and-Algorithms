

public class SumTree {
	int sum = 0;
	Node root;
	public SumTree() {
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
	public Boolean SumTree(Node root) {
		if (root == null) return true;
        sum = 0;
		if (root.left == null && root.right == null)
			return true;
		if (root.left != null) sum  += root.left.data;
		if (root.right != null) sum += root.right.data;
		if (sum == root.data) {
			System.out.println("here");
			return(SumTree(root.left) && SumTree(root.right));
		}
		else
			return false;
		
		
	}
	public Boolean SumTree1(Node root) {
		if (root == null) return true;
        int lsum = 0, rsum = 0; 
		if (root.left == null && root.right == null) {
			
			return true;
		}
		if (root.left == null) { lsum = 0;}
		else if (isL(root.left) == true) {
			System.out.println("h");
			lsum += root.left.data;
		} else {
			lsum  = 2* root.left.data;
		}
		if (root.right == null) { rsum = 0;}
		else if (isL(root.right) == true) {
			rsum += root.right.data;
		} else {
			rsum  = 2* root.right.data;
		}
		if (lsum+rsum == root.data) {
			System.out.println("here");
			return(SumTree1(root.left) && SumTree1(root.right));
		}
		else
			return false;
		
		
	}
	
	
	private boolean isL(Node right) {
		// TODO Auto-generated method stub
		return (right.left == null && right.right == null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SumTree obj = new SumTree();
		obj.root = obj.insert(obj.root, 50);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 60);
//		obj.root = obj.insert(obj.root, 40);
		obj.root.data = 90;
	
//		obj.root = obj.insert(obj.root, 70);
////	
//		obj.root = obj.insert(obj.root, 60);
//		obj.root = obj.insert(obj.root, 80);
		
		//obj.inOrderTraversal(obj.root,0);
		System.out.println(obj.SumTree1(obj.root));
	}

}
