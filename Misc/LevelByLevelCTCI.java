import java.util.ArrayList;
import java.util.LinkedList;

public class LevelByLevelCTCI {
	Node root;
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
		boolean s[] = new boolean[1];
	
		LevelByLevelCTCI obj = new LevelByLevelCTCI();
		obj.root = obj.insert(obj.root, 2);
		obj.root = obj.insert(obj.root, 1);
		obj.root = obj.insert(obj.root, 3);
		obj.root = obj.insert(obj.root, -1);
		obj.root = obj.insert(obj.root, 4);
		obj.root = obj.insert(obj.root, 5);
		ArrayList<LinkedList<Node>> arrL = new ArrayList<LinkedList<Node>>();
		
		obj.getLevelByLevel(obj.root, 0, arrL);
		for(LinkedList a: arrL) {
				while(a.isEmpty() == false) {
				Node x =(Node) a.pop();
				System.out.println(x.data);
				
			}
		}
		
		
	}
	private void getLevelByLevel(Node root, int level, ArrayList<LinkedList<Node>> arrL) {
		// TODO Auto-generated method stub
		if(root == null) {
			return;
		}
		LinkedList<Node> n  = null;
		if(arrL.size() == level) {
			 n  = new LinkedList<>();
			n.add(root);
			arrL.add(n);
		} else {
			n = arrL.get(level);
			n.add(root);
		}
		getLevelByLevel(root.left, level+1, arrL);
		getLevelByLevel(root.right, level+1, arrL);
		
	}
}
