/**
 * Definition for a binary tree node.

 */

class Mirror {
	 public class TreeNode {
		    int val;
		     TreeNode left;
		    TreeNode right;
		   TreeNode(int x) { val = x; }
		public TreeNode() {
			// TODO Auto-generated constructor stub
		}
		 }
	 
	 TreeNode root;
       public boolean isSymmetrical(TreeNode baya, TreeNode daya){
        if(baya == null && daya == null)
            return true;
        if (baya  == null && daya != null)
            return false;
        if(baya != null && daya == null){
            return false;
        }
         if (baya.val == daya.val && isSymmetrical(baya.left, daya.right) && isSymmetrical(baya.right, daya.left))
             return true;
           
           return false;
       
      
        
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetrical(root.left, root.right);
    }
    public static void main(String [] args) {
    		Mirror obj = new Mirror();
    		obj.root = obj.getNode(1);
    		obj.root.left = obj.getNode(2);
    		obj.root.right = obj.getNode(2);
    		obj.root.left.right = obj.getNode(3);
    		obj.root.right.left = obj.getNode(3);
    		System.out.println(obj.isSymmetric(obj.root));
    		
    }
	private TreeNode getNode(int x) {
		// TODO Auto-generated method stub
		TreeNode temp = new TreeNode(x);
		return temp;
	}
   
 
}