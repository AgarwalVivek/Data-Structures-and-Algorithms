
public class Kadane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2};
		int start = 0, end =0;
		int sumEndHere = arr[0];
		int sumTillHere = 0;
		int count = 0;
		int s =0;
		for(int i = 0; i < arr.length; i++) {
			
			sumTillHere += arr[i];
			if(sumEndHere < sumTillHere) {
				start = s;
				end  = i;
				sumEndHere = sumTillHere;
				count++;
				
			}
			if(sumTillHere < 0) {
				 s = i+1;
				sumTillHere  = 0;
			
			}
				
		}
		System.out.println(start+"\t"+end+"\t"+(end-start));
		
	}

}
