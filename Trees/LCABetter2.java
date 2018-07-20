

/* like we saw in LCABetter1 where we followed a top down approach 
 * the bottle neck was redoing the same task over and over again to locate the 
 * parent which has the nodes on either side. 
 * In this approach we try to do a bottom up aproach to the problem
 * and bubbling up the findings.
 */
public class LCABetter2 {
	public static int count = 0;
	public static int count1 = 0;
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
	public Node gayle(Node root, Node p, Node q) {
		count1++;
		if (root == null) {
			System.out.println("Enter with root data" );
			} else {
				System.out.println("root as "+ root.data);
			}
		if (root == null)
			return null;
		if(root == p || root == q) return root;
		
		Node x = gayle(root.left, p, q);
		if (x == null) {
			System.out.println("xxLeftSide was "+x);
			} else {
				System.out.println("xxleftSide was "+ x.data);
			}
//		if(x != null && x!=p && x!=q) {
//			System.out.println("here");
//			return x;
//		}
		
		Node y = gayle(root.right, p, q);
		if (y == null) {
			System.out.println("yyRightSide was "+y);
			} else {
				System.out.println("yyRightSide "+ y.data);
			}
		if(y != null && y!=p && y!=q) {
			System.out.println("here1");
			return y;
		}
		if( x != null && y != null) {
			System.out.println("final");
			return root;
//		}  else if(root ==p || root == q) {
//			return root;
		} else {
			return x == null ? y: x;
		}
	}
	
	public Node LCA(Node root, Node n1, Node n2) {
		count++;
		if (root == null) {
		System.out.println("enter with root data" );
		} else {
			System.out.println("root as "+ root.data);
		}
		//we will hunt for child and not parent that is suitable
		if (root == null) {
			// we are at bottom
			return null;
		} 
		if (root == n1 || root == n2)
			return root;
		Node leftSide = LCA(root.left, n1, n2);
		if (leftSide == null) {
		System.out.println("leftSide was "+leftSide);
		} else {
			System.out.println("leftSide was "+ leftSide.data);
		}
		Node rightSide = LCA(root.right, n1, n2);
		if (rightSide == null) {
			System.out.println("rightSide was "+rightSide);
			} else {
				System.out.println("rightSide was "+ rightSide.data);
			}
		
		if (leftSide != null && rightSide != null) {
			System.out.println("here");
			return root;
		} 
		return (leftSide != null) ? leftSide : rightSide;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 LCABetter2 obj = new  LCABetter2();
		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 10);
		obj.root = obj.insert(obj.root, 30);
		obj.root = obj.insert(obj.root, 35);
	
		obj.root = obj.insert(obj.root, 5);
		
		obj.root = obj.insert(obj.root, 15);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, 7);
		obj.root = obj.insert(obj.root, 17);
		

		obj.inOrderTraversal(obj.root,0);
		
		Node common = obj.LCA(obj.root,obj.root.left.right, obj.root.left.right.right);
		System.out.println("common"+common.data);
		Node common1 = obj.gayle(obj.root,obj.root.left.right, obj.root.left.right.right);
		System.out.println("common1 "+common.data);
		System.out.println(":ewf");
		System.out.println(count);
		System.out.println(count1);

	}
}
