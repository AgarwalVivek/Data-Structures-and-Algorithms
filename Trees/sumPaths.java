

public class sumPaths {
	Node root;
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	
	}
	
	public Node insert(Node root, int d) {
		
		if (root == null) {
			root = new Node(d);
		
		} else {
			if (root.data > d) {
				root.left = insert(root.left, d);
			} else {
				root.right = insert(root.right, d);
			}
		}
		return root;
		
	}
	
	private void inOrderTraversal(Node root) {
		// TODO Auto-generated method stub
		if (root != null) {
			System.out.println(root.data);
			inOrderTraversal(root.left);
			inOrderTraversal(root.right);
		}
	}
	
	private void debug(Node root2, Node subRoot) {
		// TODO Auto-generated method stub
		
		if (root2 != null) {
			System.out.print(root2.data+"\t");
		} else 
			System.out.print(root2+"\t");
		
		if (subRoot != null) {
			System.out.println(subRoot.data);
		} else 
			System.out.println(subRoot);
		
			
}
	
	private int getTotalPath(Node root, int targetSum, int totalPath) {
		// TODO Auto-generated method stub
		debug(root, null);
		if (root != null) {
			totalPath += getTotalUtil(root, targetSum, 0, 0);
			System.out.println("TOT "+totalPath);
			getTotalPath(root.left, targetSum, totalPath);
			getTotalPath(root.right, targetSum, totalPath);
		}
		return totalPath;
	}
	private int getTotalUtil(Node root, int targetSum, int totalPath, int result) {
		// TODO Auto-generated method stub
		
		
		
		
		if (root == null) return 0;
		
		result += root.data;
		
		if (result == targetSum) {
			totalPath = totalPath+1;
		
		
		}
		if (result < targetSum)
		return getTotalUtil(root.left, targetSum, totalPath, result) + getTotalUtil(root.right, targetSum, totalPath, result);
		
		return totalPath;
		
	
	}

	public static void main(String[] args) {
		sumPaths obj = new sumPaths();

		obj.root = obj.insert(obj.root, 1);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, -1);

		obj.inOrderTraversal(obj.root);
		int targetSum = 100;
		int totalPath = obj.getTotalPath(obj.root, targetSum, 0);
		System.out.println(totalPath);
		
	}




	
	
}
