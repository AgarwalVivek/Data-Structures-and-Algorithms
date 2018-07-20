import java.util.LinkedList;
import java.util.Queue;

public class ConnectSameLevell {

	public TreeNode root;
	public  class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		
		public TreeNode(int v) {
			val = v;
			left = null;
			right = null;
			next = null;
		}
		

		
	}

	public TreeNode insert(TreeNode root, int item) {
		if (root == null) {
			root = new TreeNode(item);
	
		} else {
			if(root.val < item) {
				root.right = insert(root.right, item);
				
			} else {
				root.left = insert(root.left, item);
			
			}
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConnectSameLevell obj = new ConnectSameLevell();
		
		
		obj.root = obj.insert(obj.root, 50);
		//obj.root = obj.insert(obj.root, 40);
		obj.root = obj.insert(obj.root, 80);
		//obj.root = obj.insert(obj.root, 35);
		//obj.root = obj.insert(obj.root, 45);
		obj.root = obj.insert(obj.root, 75);
		obj.root = obj.insert(obj.root, 85);
//		obj.inOrder(obj.root);
		
		//obj.root = obj.LeafConnectBFS(obj.root);
		//System.out.println(obj.root.left.next.val);
		
//		obj.root = obj.DFSComplete(obj.root);
//		System.out.println(obj.root.left.right.next.val);
//		
//		obj.root = obj.DFSAnyWay(obj.root);
//		System.out.println();
//		System.out.println(obj.root.right.left.next.val);
		System.out.println(obj.serialize(obj.root));
		String s = obj.serialize(obj.root);
		obj.root = obj.deserialize(s);
		System.out.println();
		obj.inOrder(obj.root);
	}
	private TreeNode DFSAnyWay(TreeNode root) {
		// TODO Auto-generated method stub
		
		if(root == null)
			return null;
		
		TreeNode p = root;
		
		while(p != null) {
			TreeNode q = p;
			while(q!= null) {
			if(q.left != null) {
				if(q.right != null) {
					q.left.next = q.right;
				} else {
					q.left.next = getNextRight(q);
				}
			}
			if(q.right!= null) {
				q.right.next = getNextRight(q);
			}
			q = q.next;
			
		}
			if(p.left != null)
				p = p.left;
			else if(p.right != null)
				 p = p.right;
			else p = p.next;
		}
		
		return root;
	}
	private TreeNode getNextRight(TreeNode q) {
		// TODO Auto-generated method stub
		TreeNode temp = q.next;
		while(temp != null) {
			if(temp.left != null)
				return temp.left;
			if(temp.right != null)
				return temp.right;
			temp = temp.next;
		}
		return null;
	}
	private TreeNode DFSComplete(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null) return null;
		if(root.left != null) {
			root.left.next = root.right;
		}
		
		if(root.next!= null) {
			if(root.right != null)
				root.right.next = root.next.left;
		}
		DFSComplete(root.left);
		DFSComplete(root.right);
		return root;
	}
	private TreeNode LeafConnectBFS(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null) return null;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			TreeNode n = q.peek();
			q.remove();
			
			if(n != null) {
				n.next = q.peek();
			
				if(n.left != null)
					q.add(n.left);
				if(n.right != null)
					q.add(n.right);
			} else {
				if(!q.isEmpty()) {
					q.add(null);
				}
			}
		}
		return root;
		
	}
	private TreeNode inOrder(TreeNode rootNode) {
		// TODO Auto-generated method stub
		if( rootNode != null) {
			inOrder(rootNode.left);
			System.out.println(rootNode.val);
			inOrder(rootNode.right);
		}
		return root;
	}

	public TreeNode deserialize(String s) {
		if(s.charAt(0)=='#') {
			return null;
		}
		String[] str = s.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(str[0]));
		Queue<TreeNode> q = new LinkedList<>();
		int index = 1;
		q.offer(root);
	
		while(!q.isEmpty()) {
			TreeNode n = q.peek();
			q.poll();
		
			String s1 = str[index++];
			if(!s1.equals("#")) {
				n.left = new TreeNode(Integer.parseInt(s1));
				q.offer(n.left);
			}
			String s2 = str[index++];
			if(!s2.equals("#")){
					n.right = new TreeNode(Integer.parseInt(s2));
					q.offer(n.right);
			}
		}
		return root;
		
	}
	public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode n = q.peek();
            q.remove();
            if(n == null){
                str.append("#,");
                continue;
            } 
                str.append(String.valueOf(n.val));
                str.append(",");
              
            
              q.offer(n.left);
              q.offer(n.right);
           
        }
        System.out.println(str);
        str.setLength(str.length()-1);
        System.out.println(str);
        return str.toString();
    }
}
