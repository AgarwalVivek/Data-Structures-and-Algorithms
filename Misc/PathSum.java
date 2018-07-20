import java.util.ArrayList;
import java.util.List;

class TreeNode {
	      int val;
	     TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	public class PathSum {
	    List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    List<Integer> pathList = new ArrayList<Integer>();
	    public List<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	        
	        path(root, sum, 0, pathList);
	        return result;
	    }
	    
	    public void path(TreeNode root, int target, int cur, List<Integer> pathList2){
	        if(root == null) return;
	        
	        pathList2.add(root.val);
	        cur = cur + root.val;
	        if(cur == target) {
	        	System.out.println(pathList2);
	            result.add(new ArrayList<>(pathList2));
	            cur = 0;
	        } 
	        path(root.left, target, cur, pathList2);
	        path(root.right, target, cur, pathList2);
	        pathList2.remove(pathList2.size()-1);
	   

	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		root.right.right.left = new TreeNode(5);
		PathSum obj = new PathSum();
		obj.pathSum(root, 22);
		

	}

}
