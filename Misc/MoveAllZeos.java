import java.util.Arrays;
import java.util.Hashtable;

public class MoveAllZeos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<Integer, Integer> hm = new Hashtable<>();
		hm.put(1, 2);
		hm.put(1,  3);
		System.out.println(hm.size());
		int a[] = {0, 0, 2, 0, 4, 5};
		moveZeros(a);
		System.out.println(Arrays.toString(a));
		
	}
/*1 0 2 2 4 5
 * i = 0
 * j = -1
 * 
 */
	private static void moveZeros(int[] a) {
		// TODO Auto-generated method stub
		
		int j = -1;
		int i = 0;
		
		for(i = 0; i < a.length;i++) {
			if(a[i] != 0){
				a[++j] = a[i];
			}
		}
	
		j++;
		while(j < a.length) {
			a[j] = 0;
			j++;
		}
		
	}

}
