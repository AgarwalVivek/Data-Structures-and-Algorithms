

public class effParentAncestor {
	public static int count = 0;
	class Node{
		int data;
		Node parent;
		Node left, right;
		Node(int d){
			data = d;
			left = right = null;
		}
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
		return root;
	}
	
	private Node inOrderTraversal(Node root, int flag) {
		// TODO Auto-generated method stub
		if(root != null) {

		
				
			inOrderTraversal(root.left, 0);
			System.out.print(root.data+"has parent ");
			System.out.println(root.parent != null?root.parent.data : null);
			inOrderTraversal(root.right, 1);
			
		}
		return root;
		
	}
	private static boolean covers(Node root, Node smaller) {
		count++;
		if (root == null) {
			return false;
		} else if (root.data == smaller.data) {
			return true;
		} else if (root.data > smaller.data) {
			return covers(root.left, smaller) ;
		} else {
			return covers(root.right, smaller);
		}
		// TODO Auto-generated method stub

	}
	private static int height(Node root, Node n, int level) {
		count++;
		// TODO Auto-generated method stub
		if (root == null)
			return -1;
		if (root == n)
			return level;
		if (root.data > n.data) {
			return height(root.left, n, level+1);
		} else
			return height(root.right, n, level+1);
	
	}
	public static Node commonAnc(Node root, Node n1, Node n2) {
		int h1 = height(root, n1, 0);
		int h2 = height(root, n2, 0);
		count++;
		Node bigger = null, smaller = null;
		
		if(h1 > h2) {
			System.out.println("here");
			bigger = n1;
			smaller = n2;
		} else {
			bigger = n2;
			smaller = n1;
		}
		if (covers(smaller, bigger)) {
			return smaller;
		} else {
			System.out.println("hd");
			Node parent = bigger.parent;
			Node sibling = toggleGetSibling(parent, bigger);
			System.out.println("parent and sibling of deeper"+ parent.data+""+sibling.data+smaller.data);
			while(sibling != smaller)
			{
				parent = parent.parent;
				
				sibling = toggleGetSibling(parent, sibling.parent);
				System.out.println("parent and sibling of deeper"+ parent.data+""+sibling.data+smaller.data);
			}
			return parent;
			
		}
	}

	private static Node toggleGetSibling(Node parent, Node sibling) {
		// TODO Auto-generated method stub
		count++;
		if (parent == null || sibling  == null)
		return null;
		else 
			return parent.left == sibling ? parent.right: parent.left;
	}
public static void main(String[] args) {
		
		effParentAncestor obj = new effParentAncestor();
		obj.root = obj.insert(obj.root, 50);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 40);
		
		obj.root = obj.insert(obj.root, 70);
//	
		obj.root = obj.insert(obj.root, 60);
		obj.root = obj.insert(obj.root, 80);
		obj.inOrderTraversal(obj.root,0);
		
		Node common = obj.commonAnc(obj.root,obj.root.left.left, obj.root.left);
		System.out.println(common.data);
		System.out.println(":ewf");
		System.out.println(count);
}

	
}
