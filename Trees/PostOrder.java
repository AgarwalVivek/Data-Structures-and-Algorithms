import java.util.Stack;

public class PostOrder {
	Node root;
	
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
	
	public void PostOrder(Node root) {
		if(root != null) {
			PostOrder(root.left);
			PostOrder(root.right);
			System.out.println(root.data);
		}
	}
	public static void main(String[] args) {
		
		PostOrder obj = new PostOrder();
		int flag = 0;
////		obj.root =obj.insert(obj.root, 1);
////		obj.root = obj.insert(obj.root, -1);
////		obj.root = obj.insert(obj.root, 2);
////		obj.root = obj.insert(obj.root, 5);
//		obj.root =obj.insert(obj.root, 5);
//		obj.root =obj.insert(obj.root, 3);
//		obj.root =obj.insert(obj.root, 7);
//		obj.root =obj.insert(obj.root, 2);
//		obj.root =obj.insert(obj.root, 4);
//		obj.root =obj.insert(obj.root, 6);
//		obj.root =obj.insert(obj.root, 8);
//		obj.root =obj.insert(obj.root, -1);

		
		
		for(int i = 100, j = 0; i >0 && j< 20 ; i--, j++) {
		
			int elt = flag ==0 ?i:j;
			System.out.println("Elt\t"+elt);
			obj.root = obj.insert(obj.root, elt);
			if (flag == 0) {
				flag = 1;
			} else {
				flag = 0;
			}
		}
		obj.PostOrder(obj.root);
		System.out.println("Iterative");
		
		obj.IterativePostOrder(obj.root);
		
	}

	private void IterativePostOrder(Node root) {
		// TODO Auto-generated method stub
		Stack<Node> s = new Stack<>();
	
		if(root != null) {
			Node cur = root;
		
			while(!s.isEmpty() || cur != null) {
				while(cur != null && cur.isVisited != true ) {
//					System.out.println("pushing "+cur.data);
				
					s.push(cur);
					
					cur = cur.left;
				}
				Node n = s != null?s.peek():null;
				if(n.isVisited == true) {
					System.out.println(n.data);
					s.pop();
					cur = (!s.isEmpty()) ?s.peek():null;
				} else {
					n.isVisited = true;
					cur = n.right;
					
					if(cur == null) {
						
						cur = s.pop();
						System.out.println(cur.data);
						
						
					}
				}
			
			
			}
		}

		
	}
}
