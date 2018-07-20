
public class CTCIBalance {
	Node root;
	public Node insert(Node root, int item) {
		if (root == null) {
			root = new Node(item);
		} else {
			if(root.data < item) {
				root.right = insert(root.right, item);
			} else {
				root.left = insert(root.left, item);
			}
		}
		return root;
	}
	public static void main(String[] args) {
		
		 CTCIBalance obj = new  CTCIBalance();
		obj.root = obj.insert(obj.root, 2);
	
		obj.root = obj.insert(obj.root, 3);
		
		obj.root = obj.insert(obj.root, 1);
	
		
		
		Boolean isBalanced = obj.solution(obj.root);
		System.out.println(isBalanced);
	}
	private  Boolean solution(Node root) {
		// TODO Auto-generated method stub
		
		if(root != null) {
			  
			if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
				System.out.println("hello");
				return false;
			}
			return  solution(root.left) && solution(root.right);
		}

		return true;
	}
	private int getHeight(Node root) {
		// TODO Auto-generated method stub
		if (root == null) 
			return 0;
		int l  = 1 + getHeight(root.left);
		int r = 1 + getHeight(root.right);
		return l>r?l:r;
		//return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
}
