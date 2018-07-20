
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class KsumEff{
	ArrayList<Integer> arr = new ArrayList<Integer>();
	LinkedList<ArrayList<Integer>> ll = new LinkedList<>();
	
	
		int data;
		KsumEff left;
		KsumEff right;
		public KsumEff(int d) {
			data = d;
			left = null;
			right = null;
		}
	
	
	private static void inOrderTraversal(KsumEff root) {
			// TODO Auto-generated method stub
			if (root != null) {
			
				System.out.println(root.data);
				inOrderTraversal(root.left);
				inOrderTraversal(root.right);
			}
			
	}


	private void printArr(ArrayList<Integer> arr2) {
		// TODO Auto-generated method stub
		for(int arr:arr2)
			System.out.print(arr+"\t");
		
		System.out.println();
	}


	public static void main(String[] args) {
	
		KsumEff root = new KsumEff(1);
		root.left = new KsumEff(3);
		root.right = new KsumEff(-1);
		root.left.left = new KsumEff(2);
		root.left.right = new KsumEff(1);
		root.left.right.left = new KsumEff(1);
		root.right.left = new KsumEff(4);
		root.right.left.left = new KsumEff(1);
		root.right.left.right = new KsumEff(2);
		root.right.right = new KsumEff(5);
		root.right.right.right = new KsumEff(6);
		
		System.out.println(root.getSum(root, 5));
		
		
	}


	private int  getSum(KsumEff root, int targetSum) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int runningSum = 0;
		return getTotalSum(root, targetSum, hm, runningSum);
	}


	private int getTotalSum(KsumEff root, int targetSum, HashMap<Integer, Integer> hm, int runningSum) {
		// TODO Auto-generated method stub
		if (root == null ) return 0;
		runningSum += root.data;
		int totalPath =hm.getOrDefault(runningSum - targetSum,0);
		
		if (runningSum == targetSum)
			totalPath++;
		int x = hm.getOrDefault(runningSum, 0);
		hm.put(runningSum, x + 1);
		totalPath += getTotalSum(root.left, targetSum, hm, runningSum);
		totalPath += getTotalSum(root.right, targetSum, hm, runningSum);
		int delta = hm.getOrDefault(runningSum, 0);
		if( delta == 0) hm.remove(runningSum); 
		else 
			hm.put(runningSum, delta - 1);
		
		return totalPath;
	}
	



	






}

	
	

