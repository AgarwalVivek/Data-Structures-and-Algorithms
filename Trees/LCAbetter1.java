
/* in this approach we move from up to down and each time we redo the same
 * thing over and over again. The efficiency would be atleast the depth of less deeper node - 1
 * 
 */
public class LCAbetter1 {
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
	
	private Node LCA(Node root, Node n1,  Node n2) {
		count++;
		if (covers(root, n1) != true || covers(root, n2) != true) {
				return null;
			} else {
				Boolean n1OnLeft = covers(root.left, n1);
				System.out.println(n1OnLeft);
				Boolean n2OnLeft = covers(root.left, n2);
				System.out.println(n2OnLeft);
				if (n1OnLeft != n2OnLeft) {
					System.out.println("here");
					return root;
				} else {
					//both of them lie on the same side of root
					System.out.println("here as well");
					if (n1OnLeft == true) {
						return LCA(root.left, n1, n2);
					} else {
						return LCA(root.right, n1, n2);
					}
				}
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 LCAbetter1 obj = new  LCAbetter1();
		obj.root = obj.insert(obj.root, 50);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 40);
		
		obj.root = obj.insert(obj.root, 70);
//	
		obj.root = obj.insert(obj.root, 60);
		obj.root = obj.insert(obj.root, 80);
		obj.inOrderTraversal(obj.root,0);
		
		Node common = obj.LCA(obj.root,obj.root.left.left, obj.root.left);
		System.out.println(common.data);
		System.out.println(":ewf");
		System.out.println(count);

	}

}
