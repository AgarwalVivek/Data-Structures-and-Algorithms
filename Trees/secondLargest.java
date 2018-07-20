
public class secondLargest {
	Node root;
	static int count = 0;
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
	public secondLargest() {
		// TODO Auto-generated constructor stub
	}
	
	public void solution(Node root, int c) {
		
		if (root == null || c>= 2) return;
		
		solution(root.right, c);
		
		c++;
		
		if (c == 2) {
			System.out.println(root.data);
			return;
		}
		
		solution(root.left, c);
		
		
		
		
	}
public static void main(String[] args) {
		
	secondLargest obj = new secondLargest();
		obj.root = obj.insert(obj.root, 2);
	
		obj.root = obj.insert(obj.root, 3);
		
		obj.root = obj.insert(obj.root, 1);
		obj.root = obj.insert(obj.root, -1);
		obj.root = obj.insert(obj.root, -2);
		
		
		obj.solution(obj.root, 0);

	}

}
