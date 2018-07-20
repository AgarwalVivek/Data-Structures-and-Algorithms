
public class SubTree {
	Node  root;
	public static int count = 0;
	private Object root1;
	
	class Node{
		int data;
		Node left;
		Node right;
		
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
			} else {
				root.left = insert(root.left, item);
			}
		}
		return root;
	}
//	public Node insert(Node root, int item) {
//		if (root == null) {
//			root = new Node(item);
//		} else {
//			if (root.left != null) {
//				root.right = insert(root.right, item);
//			} else {
//				root.left = insert(root.left, item);
//			}
//		}
//		return root;
//	}
	private void preOrder(Node root) {
		// TODO Auto-generated method stub
		
		if (root != null) {
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
		
	}
	private Boolean checkSubtree(Node root2, Node root1) {
		// TODO Auto-generated method stub
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		
		sb2 = getStringForm(root2, sb2);
		System.out.println(sb2);
		System.out.println("DSD"+count);
		sb1 = getStringForm(root1, sb1);
		System.out.println(sb1);
		System.out.println("DS"+count);
		
		return (sb2.indexOf(sb1.toString())) != -1;
		
		
	
	}
	private StringBuilder getStringForm(Node root, StringBuilder sb) {
		// TODO Auto-generated method stub
		count++;
		if (root != null) {
			sb.append(root.data+"");
			getStringForm(root.left, sb);
	
			getStringForm(root.right, sb);	
			
		} else {
			sb.append("X");
		}
		
		return sb;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SubTree obj = new SubTree();
		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 10);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 35);
	
		obj.root = obj.insert(obj.root, 5);
		
		obj.root = obj.insert(obj.root, 15);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, 7);
		obj.root = obj.insert(obj.root, 17);
		
		obj.preOrder(obj.root);
		//Building subtree 
		SubTree obj1 = new SubTree();
		obj1.root = obj1.insert(obj1.root, 10);
		obj1.root = obj1.insert(obj1.root, 15);
		obj1.root = obj1.insert(obj1.root, 5);
		obj1.root = obj1.insert(obj1.root, 3);
		obj1.root = obj1.insert(obj1.root, 7);
		
	
		obj1.root = obj1.insert(obj1.root, 17);
		
		
		
		System.out.println("Now subtree");
		obj.preOrder(obj1.root);
		
		Boolean isSubtree = obj1.checkSubtree(obj.root, obj1.root);
		System.out.println(isSubtree);

	}




}
