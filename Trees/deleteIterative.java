
public class deleteIterative {
	Node	 root;
	Node root1;
	Node root2;
	MetaData m = new MetaData();
	class MetaData {
		Node prev;
		Node cur;
		int flag;
	}
	class Node{
		double data;
		Node left, right;
		Boolean isVisited;
		int children;
		Node(double d){
			data = d;
			left = right = null;
			isVisited = false;
		
		}
		public Node() {
			// TODO Auto-generated constructor stub
		}
		public boolean hasChild() {
			// TODO Auto-generated method stub
			
			return this.left != null || this.right != null;
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
	
	public Node delete(Node root, int item, int flag) {
	
		Node cur = root;
		if (root != null) {
			if( root.data == item) {
				cur = root;
				flag = 1;
			} else if (root.data > item) {
		
				cur = delete(root.left, item,0);
			} else if(root.data < item){

				cur = delete(root.right, item,0 );
			}
		}
		return cur;

	
	
	}
	public static void main(String[] args) {
		
		deleteIterative obj = new deleteIterative();
		obj.root = obj.insert(obj.root, 50);
//		obj.root = obj.insert(obj.root, 30);
//		obj.root = obj.insert(obj.root, 20);
		obj.root = obj.insert(obj.root, 40);
		
		obj.root = obj.insert(obj.root, 70);
//	
		obj.root = obj.insert(obj.root, 60);
		obj.root = obj.insert(obj.root, 80);

		 /*   tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
		 */
//		obj.root1 = obj.delete(obj.root, 20, 0);
//		obj.root1 = obj.delete(obj.root, 30, 0);
		obj.root1 = obj.delete(obj.root, 50, 0);

		if (obj.root1 == null)
			System.out.println("not found");
		else {
			System.out.println("found");
			obj.root2 = obj.findParent(obj.root1);
			System.out.println(obj.root2 != null?obj.root2.data:null);
			//deleting now
			
			obj.Replace(obj.root1, obj.root2);
			obj.inOrderTraversal(obj.root);
		}
}
	private Node getParentPointer(Node parent, Node child) {
		if (parent.right == child) return parent.right;
		else return parent.left;
		
	}

	private void Replace(Node toDelete, Node parent) {
		// TODO Auto-generated method stub
		Node nextParent = root, suc;
		if (toDelete == null) {
			System.out.println("not possible");
			return;
		}
		if (parent == toDelete) {
			System.out.println("ber");
			Node succ = parent.right;
			
			while(succ.left != null) {
				succ = succ.left;
			}
			succ.left = parent.left;
			root = null;
			root = parent.right;
			//inOrderTraversal(root);
			return;
			
		}
		if (parent == null) {
			System.out.println("root");
			toDelete = null;
			inOrderTraversal(root);
			System.out.println("");
			return;
			
		}
		if (parent.right == toDelete) {
			nextParent = parent.right;
			System.out.println("rjjoot");
		} 
		if (parent.left == toDelete) {
			nextParent  = parent.left;
			System.out.println("roothh");
		}
		if(	 toDelete.hasChild() == false) {
			if (nextParent == parent.left ) {
		   		parent.left = null;;
		   	} else {
		   		parent.right = null;;
		   	}
			return;
		}
	   if (toDelete.right == null){
			suc = toDelete.left;
		  
		   	if (nextParent == parent.left ) {
		   		parent.left = toDelete.left;;
		   	} else {
		   		parent.right = toDelete.left;;
		   	}
			toDelete = null;
			
			inOrderTraversal(root);
			System.out.println("rohhot");
			
		} else if (toDelete.left == null) {
			suc = toDelete.right;
			if (nextParent == parent.left ) {
		   		parent.left = toDelete.right;;
		   	} else {
		   		parent.right =  toDelete.right;
		   	}
			toDelete = null;
			
			nextParent = suc;
			toDelete = null;
		
			inOrderTraversal(root);
			System.out.println("rhhhoot");
		} else {
			// child has both left and right sub childs.
			Node lBranch = toDelete.left;
			Node rBranch = toDelete.right;
			if (nextParent == parent.left ) {
		   		parent.left = toDelete.right;;
		   	} else {
		   		parent.right = toDelete.right;
		   	}
	
			
			//traversing till end of right branch left most child
			while(rBranch.left != null) {
				rBranch = rBranch.left;
			}
			
			rBranch.left = lBranch;
			toDelete = null;
			inOrderTraversal(root);
			System.out.println("hhhhhroot");
			
		}
		
		
	}

	Node findParent(Node child) {
		 Node parent = root;
		 Node prev = root;;

		 while (parent != null) {
		
			 if(parent == child) {
	
				 return prev;
			
			 } else {
				 if (parent.data > child.data) {
					
					 prev = parent;
					 parent = parent.left;
				 } else {
			     System.out.println("her");
				 prev = parent;
				 parent = parent.right;
				 }
			 } 
		 }
		 
		 return parent != null ? prev: parent;
			 
		 		

		// TODO Auto-generated method stub
	
		
	}
	private void inOrderTraversal(Node root) {
		// TODO Auto-generated method stub
		
		if(root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.data);
		
			inOrderTraversal(root.right);
		}
		
	}
	private static boolean Exists(Node right) {
		// TODO Auto-generated method stub
		return right != null;

	}

}


