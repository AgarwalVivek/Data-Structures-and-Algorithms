
import java.util.ArrayList;
import java.util.LinkedList;

class track{
	ArrayList<Integer> arr = new ArrayList<Integer>();
	LinkedList<ArrayList<Integer>> ll = new LinkedList<>();
	
	
		int data;
		track left;
		track right;
		public track(int d) {
			data = d;
			left = null;
			right = null;
		}
	
	
	private static void inOrderTraversal(track root) {
			// TODO Auto-generated method stub
			if (root != null) {
			
				System.out.println(root.data);
				inOrderTraversal(root.left);
				inOrderTraversal(root.right);
			}
			
	}
	public int PassFurther(track root) {
		if(root != null) {
			 int sum  = allSums(root, 0);
			int S = PassFurther(root.left);
			int Y = PassFurther(root.right);
		
			return S+Y+sum;
		}
		return 0;
	}
	public int  allSums(track root, int sum) {
		if (root == null) return 0;
		int totalPath = 0;
		sum += root.data;
		if (sum == 5) {
			totalPath = totalPath + 1;
		}
		totalPath +=allSums(root.left, sum);
		totalPath +=allSums(root.right, sum);
		return totalPath;
		
	}


	private void printArr(ArrayList<Integer> arr2) {
		// TODO Auto-generated method stub
		for(int arr:arr2)
			System.out.print(arr+"\t");
		
		System.out.println();
	}


	public static void main(String[] args) {
	
		track root = new track(1);
		root.left = new track(3);
		root.right = new track(-1);
		root.left.left = new track(2);
		root.left.right = new track(1);
		root.left.right.left = new track(1);
		root.right.left = new track(4);
		root.right.left.left = new track(1);
		root.right.left.right = new track(2);
		root.right.right = new track(5);
		root.right.right.right = new track(6);
		System.out.println(root.PassFurther(root));
		//System.out.println(root.allSums(root, 0));
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

	
	

