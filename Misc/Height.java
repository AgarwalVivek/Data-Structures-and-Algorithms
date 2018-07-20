
public class Height {
	class Node{
		int data;
		Node left, right;
		int size;
		Node(int d){
			data = d;
			left = right = null;
			size = 1;
		}
	}
	
	public static void main(String args[]) {
		Height obj = new Height();
		Node root = null;
		int flag = 0;
		for(int i = 10, j = 10; i >0 && j< 20 ; i--, j++) {
			int elt = flag ==0 ?i:j;
			System.out.println("Elt\t"+elt);
			root = obj.insert(root, elt);
			if (flag == 0) {
				flag = 1;
			} else {
				flag = 0;
			}
		}
		
		
		obj.inOrderTraversal(root);
		System.out.println("here");
		
		int height = obj.getHeight(root, 0);
		System.out.println(height);
		System.out.println("/t---------");
		
		for(int i =0; i < height+1; i++) {
			System.out.println("-----\tFor Level\t:"+i+"\t------");
			obj.LevelByLevel(root, i);
			
		}
	}
	private int getHeight(Node root, int level) {
		// TODO Auto-generated method stub
		int leftHeight = 0;
		int rightHeight = 0;
		if(root == null)
		return level;
		else {
			 leftHeight = getHeight(root.left, level+1);
			 rightHeight = getHeight(root.right, level+1);
		}
		
		if (leftHeight > rightHeight) {
			return leftHeight;
		} else {
			return rightHeight;
		}
	}
	private void LevelByLevel(Node root, int level) {
		if(root == null) return;
		if (level == 0)
			System.out.println(root.data);
		else {
			LevelByLevel(root.left, level - 1);
			LevelByLevel(root.right, level -1);
		}
		
	}
	private  void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.data + "\t" + root.size);
			inOrderTraversal(root.right);
		}
	}
	private Node insert(Node root, int item) {
		// TODO Auto-generated method stub
		
		if (root == null) {
			root = new Node(item);
		} else {
			if (item > root.data) {
				root.right = insert(root.right, item);
				
			} else if(item <= root.data) {
				root.left = insert(root.left, item);
			}
		}
		root.size++;
		return root;
	}

}
