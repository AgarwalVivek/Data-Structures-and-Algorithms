import java.util.ArrayList;
import java.util.LinkedList;

public class Weavingtree {
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
	private void inOrderTraversal(Node root, int flag) {
		// TODO Auto-generated method stub
		if(root != null) {
		
		
				
			inOrderTraversal(root.left, 0);
			System.out.println(root.data);
			inOrderTraversal(root.right, 1);
		}
			
		}
	public static void main(String[] args) {
		
			Weavingtree obj = new Weavingtree();
			obj.root = obj.insert(obj.root, 2);
	
			obj.root = obj.insert(obj.root, 10);
		
			
			obj.root = obj.insert(obj.root, 1);
			obj.root = obj.insert(obj.root, 3);
			obj.inOrderTraversal(obj.root, 0);
			obj.root = obj.insert(obj.root, -1);
			obj.root = obj.insert(obj.root, -2);
			
			ArrayList<LinkedList<Integer>> arr = obj.allSequences(obj.root);
			for(LinkedList<Integer> a: arr) {
				for(Integer x: a) {
					System.out.print(x +" ");
				}
				System.out.println();
			}
		

	}
	private ArrayList<LinkedList<Integer>> allSequences(Node root) {
		// TODO Auto-generated method stub
		ArrayList<LinkedList<Integer>> results  = new ArrayList<>();
		if(root == null) {
			results.add(new LinkedList<>());
			return results;
		}
		
		LinkedList<Integer> prefix = new LinkedList<>();
		
		prefix.add((int) root.data);
		System.out.println("Debug "+ prefix);
		
		ArrayList<LinkedList<Integer>>  leftSeq = allSequences(root.left);
		ArrayList<LinkedList<Integer>>  rightSeq = allSequences(root.right);
		System.out.println("Debug1 left "+ leftSeq);
		System.out.println("Debug1 right "+ rightSeq);
		
		System.out.println(rightSeq.size());
		
		for(LinkedList left: leftSeq) {
			for(LinkedList right: rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
				weaveLists(left, right, weaved, prefix);
				results.addAll(weaved);
				
			}
		}
		return results;
	}
	private void weaveLists(LinkedList first, LinkedList second, ArrayList<LinkedList<Integer>> result,
			LinkedList<Integer> prefix) {
		// TODO Auto-generated method stub
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> resultPrefix = (LinkedList<Integer>) prefix.clone();
			resultPrefix.addAll(first);
			resultPrefix.addAll(second);
			result.add(resultPrefix);
		}
		Integer headFirst;
		if( first != null) {
			headFirst = null;
			
		} else 
			headFirst = (int) first.removeFirst();
		
		prefix.addLast(headFirst);
		weaveLists(first, second, result, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int headSecond = (int)second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, result, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}
	


}
