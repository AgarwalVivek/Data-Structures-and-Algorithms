import java.util.ArrayList;



public class SumTree2 {
	int sum = 0;
	Node root;
	public static int sumS = 0;
	static ArrayList<Integer> arr = new ArrayList<>();
	public SumTree2() {
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
	
	private void inOrderTraversal(Node root) {
		// TODO Auto-generated method stub
		if (root != null) {
			System.out.println(root.data);
			inOrderTraversal(root.left);
			inOrderTraversal(root.right);
		}
	}
	
	private boolean isL(Node right) {
		// TODO Auto-generated method stub
		return (right.left == null && right.right == null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SumTree2 obj = new SumTree2();
		obj.root = obj.insert(obj.root, 50);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 60);
		obj.root = obj.insert(obj.root, 40);
		//obj.root.data = 90;
	
		obj.root = obj.insert(obj.root, 70);
////	
//		obj.root = obj.insert(obj.root, 60);
//		obj.root = obj.insert(obj.root, 80);
		
		//obj.inOrderTraversal(obj.root);
		//System.out.println(obj.SumTree1(obj.root));
		obj.DFS1(obj.root);
		System.out.println(arr);
		
		
	}
	private void DFS1(Node root) {
		// TODO Auto-generated method stub
		
		if(root != null) {
			int x[] = new int[1];
			getSubtreeSum(root, x);
			arr.add(x[0]);
			System.out.println(x[0]);
			DFS1(root.left);
			DFS1(root.right);
		}
		
	}
	private void getSubtreeSum(Node root, int[] x) {
		// TODO Auto-generated method stub
		if(root != null) {
			x[0] +=root.data;
			getSubtreeSum(root.left, x);
			getSubtreeSum(root.right, x);
		}
		
	}

}
