
public class preInOrder {
	Node root;
	static int preOrderIndex = 0;
	public preInOrder() {
		// TODO Auto-generated constructor stub
	}
	
	public Node buildTree(Node root, int preOrder[], int inOrder[], int inOrderStart, int inOrderEnd ) {
		int item  = 0;
		if (inOrderStart > inOrderEnd)
			return null;
		if (preOrderIndex < preOrder.length) {
			 item = preOrder[preOrderIndex];
			root = new Node(item);
		}
		
		int inOrderIndex = search(inOrder, item, 0);
		if (inOrderStart == inOrderEnd)
			return root;
		root.left = buildTree(root.left, preOrder, inOrder, inOrderStart, inOrderIndex - 1);
		root.right = buildTree(root.right, preOrder, inOrder, inOrderIndex+1, inOrderEnd);
		return root;
		
	
	}

	private int search(int[] inOrder, int item, int index) {
		// TODO Auto-generated method stub
		int flag = -1;
		if(inOrder[index] == item) return index;
		flag = search(inOrder, item, index+1);
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		preInOrder obj = new preInOrder();
		int preOrder[] = {1,2, 3};
		int inOrder[] = {2, 1, 3};
		obj.root = obj.buildTree(obj.root, preOrder, inOrder, 0, 2);
		System.out.println(obj.root.data);

	}

}
