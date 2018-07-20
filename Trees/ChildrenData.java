
public class ChildrenData {
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
	
	private int getChildren(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		else {
			return 1 + getChildren(root.left) + getChildren(root.right);
		}
	}

	public static void main(String[] args) {
		
		ChildrenData obj = new ChildrenData();
		obj.root = obj.insert(obj.root, 2);
		
		obj.root = obj.insert(obj.root, 3);
		
		obj.root = obj.insert(obj.root, 1);
		obj.root = obj.insert(obj.root, -1);
		obj.root = obj.insert(obj.root, -2);
	
		obj.inOrderTraversal(obj.root);
	}

	private void inOrderTraversal(Node root) {
		// TODO Auto-generated method stub
		
		if(root != null) {
			inOrderTraversal(root.left);
			
			root.children = getChildren(root) -1;
			System.out.println(root.data +"has "+root.children+" children");
			inOrderTraversal(root.right);
		}
		
	}
		
	
}
