import java.util.HashMap;


public class CountPath {
	Node root;
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
	
	public CountPath() {
		// TODO Auto-generated constructor stub
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
	
	public int getTotalPath(Node root) {
		int targetSum = 5;
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		
		
		return getTotalUtil(root, targetSum, hm, 0);
		
	}

	private int getTotalUtil(Node root, int targetSum, HashMap<Integer, Integer> hm, int currentSum) {
		// TODO Auto-generated method stub
		if (root == null) return 0;
		
		
		currentSum = currentSum + root.data;
		int sum = currentSum-targetSum;
		
		
		int totalPath = hm.getOrDefault(sum, 0);
		System.out.println("here "+totalPath);
		
		
		if(currentSum == targetSum) {
			System.out.println("ds");
			totalPath++;
			
		}
		hm.put(currentSum, hm.getOrDefault(currentSum,0)+1);
		totalPath += getTotalUtil(root.left, targetSum, hm, currentSum);
		totalPath += getTotalUtil(root.right, targetSum, hm, currentSum);
		int getVal = hm.get(currentSum);
		if (getVal == 0) {
			hm.remove(currentSum);
		} else {
			hm.put(currentSum, hm.get(currentSum) - 1);
		}
		
		System.out.println("exiting "+totalPath);
		return totalPath;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountPath obj = new CountPath();
	
		obj.root = obj.insert(obj.root, 1);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, 2);
		obj.root = obj.insert(obj.root, -1);
		
		System.out.println(obj.getTotalPath(obj.root));

	}

}
