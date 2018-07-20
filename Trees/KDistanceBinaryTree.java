import java.util.*;
import java.util.Map.Entry;

// Java program to print all nodes at a distance k from given node

	// A binary tree node
	class KNode
	{
		KNode left, right;
		int data;
		KNode(int item) 
		{
			data = item;
			left = right = null;
		}
	}

	public class KDistanceBinaryTree 
	{
		Map<KNode, ArrayList<KNode>> map = new HashMap();
		KNode root;
	
	  private void buildMap(KNode node, KNode parent) {
	        if (node == null) return;
	        if (!map.containsKey(node)) {
	            map.put(node, new ArrayList<KNode>());
	            if (parent != null)  { map.get(node).add(parent); map.get(parent).add(node) ; }
	            buildMap(node.left, node);
	            buildMap(node.right, node);
	        }
	    }
		/* Recursive function to print all the nodes at distance k in
		tree (or subtree) rooted with given root. */

		
		void printkdistanceNodeDown(KNode node, int k) 
		{
			// Base Case
			if (node == null || k < 0)
				return;

			// If we reach a k distant node, print it
			if (k == 0) 
			{
				System.out.print(node.data);
				System.out.println("");
				return;
			}

			// Recur for left and right subtrees
			printkdistanceNodeDown(node.left, k - 1);
			printkdistanceNodeDown(node.right, k - 1);
		}

		// Prints all nodes at distance k from a given target node.
		// The k distant nodes may be upward or downward.This function
		// Returns distance of root from target node, it returns -1
		// if target KNodeis not present in tree rooted with root.
		int printkdistanceNode(KNode node, KNode target, int k) 
		{
			// Base Case 1: If tree is empty, return -1
			if (node == null)
				return -1;

			System.out.println("sas"+ node.data);
			// If target is same as root. Use the downward function
			// to print all nodes at distance k in subtree rooted with
			// target or root
			if (node == target) 
			{
				printkdistanceNodeDown(node, k);
				return 0;
			}

			// Recur for left subtree
			int dl = printkdistanceNode(node.left, target, k);
			System.out.println("sas"+ node.data+"\tm"+dl);
			// Check if target KNodewas found in left subtree
			if (dl != -1) 
			{
				
				// If root is at distance k from target, print root
				// Note that dl is Distance of root's left child from 
				// target
				if (dl + 1 == k) 
				{
					System.out.print(node.data);
					System.out.println("");
				}
				
				// Else go to right subtree and print all k-dl-2 distant nodes
				// Note that the right child is 2 edges away from left child
				else
					printkdistanceNodeDown(node.right, k - dl - 2);

				// Add 1 to the distance and return value for parent calls
				return 1 + dl;
			}

			// MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
			// Note that we reach here only when KNodewas not found in left 
			// subtree
			int dr = printkdistanceNode(node.right, target, k);
			if (dr != -1) 
			{
				if (dr + 1 == k) 
				{
					System.out.print(node.data);
					System.out.println("");
				} 
				else
					printkdistanceNodeDown(node.left, k - dr - 2);
				return 1 + dr;
			}

			// If target was neither present in left nor in right subtree
			return -1;
		}

		// Driver program to test the above functions
		public static void main(String args[]) 
		{
			KDistanceBinaryTree  tree = new KDistanceBinaryTree ();
			System.out.println("dsds");
			/* Let us construct the tree shown in above diagram */
			tree.root = new KNode(20);
			tree.root.left = new KNode(8);
			tree.root.right = new KNode(22);
			tree.root.left.left = new KNode(4);
			tree.root.left.right = new KNode(12);
			tree.root.left.right.left = new KNode(10);
			tree.root.left.right.right = new KNode(14);
			KNode target = tree.root.left.right;
			tree.printkdistanceNode(tree.root, target, 2);
			tree.buildMap(tree.root, null);
	
			System.out.println();
			for(Entry<KNode, ArrayList<KNode>> entry: tree.map.entrySet()) {
				System.out.print(entry.getKey().data);
				for(KNode a: entry.getValue()) {
					System.out.print("\t"+a.data);
				}
				System.out.println();
			}
			
		}
	}

	// This code has been contributed by Mayank Jaiswal


