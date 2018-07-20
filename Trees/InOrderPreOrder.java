
public class InOrderPreOrder {
	//Om Sai Ram
	static int PreOrderIndex = 0;
	public  Node root;
	public class Node{
		public int data;
		public Node left;
		public Node right;
			public Node(int d){
			data = d;
				left = null;
				right = null;
			}
	}
	
	public int searchIndex(int []inOrder, int item) {
		int i = 0;
		for (i = 0; i < inOrder.length;i++) {
			if (inOrder[i] == item) break;
		}
		if (i == inOrder.length) return -1;
		return i;
	}
	public Node insert(Node root, int []preOrder, int [] inOrder, int inOrderStart, int inOrderEnd) {
		System.out.println("iter");
		if (inOrderStart > inOrderEnd) {
			System.out.println("inOrder "+inOrderStart +"\t"+inOrderEnd);
			return null;
		}
		
		if (PreOrderIndex >= preOrder.length) return null;
		int item = preOrder[PreOrderIndex];
		System.out.println("here is item "+item);
		root = new Node(item);
		
		int mid = searchIndex(inOrder,item );
		System.out.println("mid"+mid);
		PreOrderIndex++;
		
		if (inOrderStart > inOrderEnd) {
			System.out.println("here");
			return root;
		}
		
		root.left = insert(root.left, preOrder, inOrder, inOrderStart, mid -1);
		root.right = insert(root.right, preOrder, inOrder, mid + 1, inOrderEnd);
		System.out.println("iter");
		return root;
		
		
	}

	public InOrderPreOrder() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InOrderPreOrder obj = new InOrderPreOrder();
		int inOrderEnd = 3;
		int inOrderStart = 0;
		int[] inOrder = {1, 2, 3, 4, 5};
		int[] preOrder= {2,1,3, 4,5};
		obj.root = obj.insert(obj.root, preOrder, inOrder, inOrderStart, inOrderEnd);
		System.out.println(obj.root.right.data);
	}

}
