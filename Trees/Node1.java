import java.util.ArrayList;

class Node1{
	int totalPAth = 0;
	ArrayList<Integer> arr = new ArrayList<Integer>();
		int data;
		Node1 left;
		Node1 right;
		public Node1(int d) {
			data = d;
			left = null;
			right = null;
		}
	
	
	private static void inOrderTraversal(Node1 root) {
			// TODO Auto-generated method stub
			if (root != null) {
			
				System.out.println(root.data);
				inOrderTraversal(root.left);
				inOrderTraversal(root.right);
			}
			
	}
	private int getTotalPath(Node1 root, int targetSum) {
			// TODO Auto-generated method stub
		
			if (root != null) {
				//DFS
				totalPAth += getSumPath(root, targetSum,0);
				 getTotalPath(root.left,targetSum);
				 getTotalPath(root.right,targetSum);
				  return totalPAth;
			} else 
				return 0;
			
	}
	private int getSumPath(Node1 root, int targetSum, int result) {
		// TODO Auto-generated method stub
		//int result  = 0;
		int totalPath = 0;
		if (root != null) {
			result +=root.data;
			
			if (result == targetSum) {
				totalPath++;
				
			}
			
			totalPath += getSumPath(root.left, targetSum,  result);
			totalPath += getSumPath(root.right, targetSum, result);
			return totalPath;
		}
		else {
			arr.add(result);
			return 0;
		}
	}


	public static void main(String[] args) {
	
		Node1 root = new Node1(1);
		root.left = new Node1(3);
		root.right = new Node1(-1);
		root.left.left = new Node1(2);
		root.left.right = new Node1(1);
		root.left.right.left = new Node1(1);
		root.right.left = new Node1(4);
		root.right.left.left = new Node1(1);
		root.right.left.right = new Node1(2);
		root.right.right = new Node1(5);
		root.right.right.right = new Node1(6);
	
		inOrderTraversal(root);
		int targetSum = 5;
		int totalPath = root.getTotalPath(root, targetSum);
		System.out.println(" "+totalPath);
		
		for(int a:root.arr) {
			System.out.println(a);
		}
		
	}



	






}

	
	

