import java.util.Stack;

class MergeTreesIter {

	
	TreeNode root1;
	TreeNode root2;
	 public class TreeNode {
	    int val;
	    TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	  }
	public TreeNode insert(TreeNode root, int item) {
		if (root == null) {
			return new TreeNode(item);
		}
		TreeNode current = root;
		while(current != null) {
			if (current.val < item) {
				if (current.right == null) {
					current.right =  new TreeNode(item);
					break;
				} else
				current = current.right;
			} else {
				if(current.left == null) {
					current.left = new TreeNode(item);
					break;
				} else
				current = current.left;
			}
		}
		
		return root;
	}
	 
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack< TreeNode[] > stack = new Stack < > ();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }
    
    public static void main(String []args) {
    		MergeTreesIter obj = new MergeTreesIter();
    		obj.root1 = obj.insert(obj.root1, 10);
    		obj.root1 = obj.insert(obj.root1, 20);
    		System.out.println(obj.root1.right);;
    		System.out.println("here");
    
    }
}

