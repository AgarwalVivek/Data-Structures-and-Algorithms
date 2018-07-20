import java.util.Random;

public class Random1 {
	int data;
	Random1 left;
	Random1 right;
	int size = 0;
	
	Random1(int d){
		data = d;
		size = 1;
	}
	
	public Random1 getRandomNode() {
		int leftSize = left == null ? 0 : left.size();
		Random random  = new Random();
		int index = random.nextInt(size);
		if (index < leftSize) {
			return this;
		} else {
			return right.getRandomNode();
		}
		
	}
	
	public void insert(int d) {
		if (d <= data) {
			if (left == null) {
				left = new Random1(d);
			} else {
				left.insert(d);
			}
		} else {
			if (right == null)
				right = new Random1(d);
			else 
				right.insert(d);
		}
		size++;
	}
	
	public Random1 find(int d) {
		if(d == data) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d): null;
		} else if (d > data)
		{			return right != null ? right.find(d): null;
		}
		return null;
}
	private int size() {
		// TODO Auto-generated method stub
		return size;
	}
	private static void inOrderTraversal(Random1 root) {
		// TODO Auto-generated method stub
		if (root != null) {
		
			System.out.println(root.data + "has size "+root.size );
			inOrderTraversal(root.left);
			inOrderTraversal(root.right);
		}
		
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random1 root = new Random1(9);
		root.insert(10);
//		root.insert(20);
//		root.insert(30);
		root.insert(3);
//		root.insert(1);
//		root.insert(2);
		inOrderTraversal(root);
		//System.out.println(root.getRandomNode());
		//System.out.println(rand);
		Random1 rand1 = root.getRandomNode();
		System.out.println(rand1);
		

	}

}
