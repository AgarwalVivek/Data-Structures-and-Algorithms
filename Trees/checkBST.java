

public class checkBST {
	public static int count = 0;
    public static int index = 0;
 
	public static int array[];
	class Node{
		int data;
		Node parent;
		int size;
		Node left, right;
		Node(int d){
			data = d;
			left = right = null;
			size = 0;
		}
		
	}
	checkBST(int size){
		array = new int[size];
	}
	public checkBST() {
		// TODO Auto-generated constructor stub
	}
	private Node root;
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
		root.size++;
		return root;
	}
	
	private Node inOrderTraversal(Node root, int flag) {
		// TODO Auto-generated method stub
		if(root != null) {

		
				
			inOrderTraversal(root.left, 0);
			count++;
			System.out.print(root.data+"has parent ");
			System.out.println(root.parent != null?root.parent.data : null);
			inOrderTraversal(root.right, 1);
			
		}
		return root;
		
	}
	private Node inOrder(Node root, int flag) {
		// TODO Auto-generated method stub
		
		if(root != null) {
			inOrder(root.left, 0);
			System.out.println(root.data+" has size "+ root.size);
			array[index++] = root.data;
			inOrder(root.right, 1);
			
		}
		return root;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkBST obj = new checkBST ();
		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 10);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 35);
//	
		obj.root = obj.insert(obj.root, 5);
//		
//		obj.root = obj.insert(obj.root, 15);
//		obj.root = obj.insert(obj.root, 3);
//		obj.root = obj.insert(obj.root, 7);
//		obj.root = obj.insert(obj.root, 17);
		

		obj.inOrderTraversal(obj.root,0);
		
		System.out.println(count);
		
		int arr[] = new int[count];
		checkBST obj1 = new checkBST(count);
		//obj1.copy(arr);
		obj1.root = obj1.insert(obj1.root, 20);
		obj1.root = obj1.insert(obj1.root, 10);
		obj1.root = obj1.insert(obj1.root, 30);
		obj1.root = obj.insert(obj1.root, 35);
	//	
			obj1.root = obj1.insert(obj1.root, 5);
		
		obj1.inOrder(obj1.root, 0);
		System.out.println("dd");
		System.out.println(obj1.array[0]);
		
		obj.printArr();
		
		

	}
	private void copy(int[] arr) {
		// TODO Auto-generated method stub
		
		
		
	}
	private static void printArr() {
		// TODO Auto-generated method stub
		for(int i: array)
			System.out.println(i);
	}

}
