import java.util.Stack;



public class IterativeInOrder {
	Node root;
	static int count1 = 0;
	static int count2 = 0;
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
	private Node inOrderTraversal(Node root, int flag) {
		// TODO Auto-generated method stub
		if(root != null) {
			count1++;
		
				
			inOrderTraversal(root.left, 0);
			System.out.println(root.data);
			inOrderTraversal(root.right, 1);
			
		}
		return root;
		
	}
	public static void main(String[] args) {
		
		IterativeInOrder obj = new IterativeInOrder();
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

		
		obj.root =obj.inOrderTraversal(obj.root, 0);
		
		//traversal 
		System.out.println();
		obj.printInOrder(obj.root);
		System.out.println("Niumber of iterations\t"+count1+"\t"+count2);
	}
	private void printInOrder(Node root) {
		// TODO Autgenerated method stub
		Node current = root;
		Stack<Node> s = new Stack<>();

		int iter = 0;
		while(!s.isEmpty() || iter == 0|| current != null) {
			iter = 1;
			
			while(current != null) {
				
				s.push(current);
				current = current.left;
			
			} 
				Node n = s.pop();
				if(n != null){
					count2++;
					System.out.println(n.data);
					current = n.right;
				}
				
			}
		}
		
	}
		


