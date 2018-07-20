
import java.util.ArrayList;
import java.util.LinkedList;

class trackeachPAth{
	ArrayList<Integer> arr = new ArrayList<Integer>();
	LinkedList<ArrayList<Integer>> ll = new LinkedList<>();
	
	
		int data;
		trackeachPAth left;
		trackeachPAth right;
		public trackeachPAth(int d) {
			data = d;
			left = null;
			right = null;
		}
	
	
	private static void inOrderTraversal(trackeachPAth root) {
			// TODO Auto-generated method stub
			if (root != null) {
			
				System.out.println(root.data);
				inOrderTraversal(root.left);
				inOrderTraversal(root.right);
			}
			
	}
	public void PassFurther(trackeachPAth root, int sum) {
		if(root != null) {
			allSums(root, 0);
			PassFurther(root.left, 0);
			PassFurther(root.right, 0);
			
		}
	}
	public void allSums(trackeachPAth root, int sum) {
		if(root == null) return;
		arr.add(root.data);
		sum += root.data;
		
		allSums(root.left, sum);
		allSums(root.right, sum);
		//
		if (sum == 5)
			printArr(arr);
		
		if (root.left == null && root.right == null ) {
			System.out.println("\t"+sum);
			printArr(arr);
		}
			ll.add(arr);
			arr.remove(arr.size() - 1);
		
			sum = sum - root.data;	
		//}
		
		
	}


	private void printArr(ArrayList<Integer> arr2) {
		// TODO Auto-generated method stub
		for(int arr:arr2)
			System.out.print(arr+"\t");
		
		System.out.println();
	}


	public static void main(String[] args) {
	
		trackeachPAth root = new trackeachPAth(1);
		root.left = new trackeachPAth(3);
		root.right = new trackeachPAth(-1);
		root.left.left = new trackeachPAth(2);
		root.left.right = new trackeachPAth(1);
		root.left.right.left = new trackeachPAth(1);
		root.right.left = new trackeachPAth(4);
		root.right.left.left = new trackeachPAth(1);
		root.right.left.right = new trackeachPAth(2);
		root.right.right = new trackeachPAth(5);
		root.right.right.right = new trackeachPAth(6);
		//root.PassFurther(root, 0);
		root.allSums(root, 0);
		//inOrderTraversal(root);

		for (ArrayList<Integer> arr: root.ll) {
			for(int a: arr) {
				System.out.println(a + "\t");
			}
			System.out.println();
		}
		
//		for(int a:root.arr) {
//			System.out.println(a);
//		}
		
	}



	






}

	
	

