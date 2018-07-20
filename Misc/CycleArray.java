
public class CycleArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1, 2, 5, 3, 4, 1};
		
		System.out.println(booleanisCycle(a));

	}

	private static boolean booleanisCycle(int[] a) {
		// TODO Auto-generated method stub
		
		int p = 0, q = 0;
		while(true){
			
			if (p <0 || q < 0 || p >a.length || q > a.length) return false;
			
			p = a[p];
			if(p == q) return true;
			p = a[p];
			if(p == q) return true;
			q = a[q];
			if (p == q) return true;
			
		}
	}

}
