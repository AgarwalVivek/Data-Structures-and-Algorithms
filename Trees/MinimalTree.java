
public class MinimalTree {
	Node root;
	Node root1;
	public Node insert(Node root, double d) {
		if (root == null) {
			root = new Node(d);
		} else {
			if(root.data < d) {
				root.right = insert(root.right, d);
			} else {
				root.left = insert(root.left, d);
			}
		}
		return root;
	}
	public static void main(String args[]) {
		int arr[] = { 1, 5, 6, 7, 9, 10,12};
		MinimalTree obj = new MinimalTree();
		obj.solution(arr);
		inOrderTraversal(obj.root);
		//obj.binAdd(arr, 0, arr.length);
		
	}
	private static void inOrderTraversal(Node root2) {
		// TODO Auto-generated method stub
		if (root2!=null) {
			inOrderTraversal(root2.left);
			System.out.println(root2.data);
			inOrderTraversal(root2.right);
		}
		
	}
	private void solution(int[] arr) {
		// TODO Auto-generated method stub
		
		binSearch(arr, 0, arr.length);
		
	}
	private void binSearch(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		
		if(low < high) {
			int mid = low + (high - low)/2;
			root = insert(root,arr[mid]);
			binSearch(arr, low, mid);
			binSearch(arr, mid+1, high);
		
		}
	
	}
	private Node binAdd(int arr[], int low, int high) {
		if (low > high)
			return null;
	
			int mid = low + (high - low)/2;
			root1 = new Node(arr[mid]);
			
			root1.left = binAdd(arr, low, mid);
			root1.right = binAdd(arr, mid + 1, high);
		
		
		return root1;
		
	}

}
