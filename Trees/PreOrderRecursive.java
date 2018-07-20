import java.util.Stack;

public class PreOrderRecursive {
	Node root;

	public void PreOrder(Node root) {
		if(root != null) {
			System.out.println(root.data);
			PreOrder(root.left);
			PreOrder(root.right);
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
	public static void main(String[] args) {
			
			PreOrderRecursive obj = new PreOrderRecursive();
			int flag = 0;
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
	
			
			obj.PreOrder(obj.root);
			System.out.println("IterativePreOrder");
			obj.IterativePreOrder(obj.root);
	}
	private void IterativePreOrder(Node root) {
		// TODO Auto-generated method stub
		Node current = root;
		Stack<Node> s = new Stack<Node>();
		
		while(!s.isEmpty() || current != null) {
			
			while(current != null) {
				System.out.println(current.data);
				s.push(current);
				current = current.left;
			}
			Node n = s.pop();
			if(n != null) {
				current = n.right;
			}
		}
		
				
	}

}
