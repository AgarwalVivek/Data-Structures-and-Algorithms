import java.util.ArrayList;

public class BigNumber {
	int number;
	public BigNumber(int x) {
		number = x;
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigNumber obj = new BigNumber(5);
		ArrayList<Integer> result = new ArrayList();
		obj.convertToArray(obj.number, result);
		//rotuine to call utility function(for multiplication) for each value in factorial 
        	obj.getValue(result);
        	int i= 0;
        	while(result.get(i)==0) {
        		i++;
        	}
        	System.out.println("number of 0s = "+ i );
		

	}


	private void getValue(ArrayList<Integer> result) {
		// TODO Auto-generated method stub
		
		for(int i = 2; i < 5; i++) {
			getNext(result, i);
		}
		
	}


	private void getNext(ArrayList<Integer> result, int x) {
		// TODO Auto-generated method stub
		int carry  = 0;
		for(int i = 0; i < result.size(); i++) {
			int val = result.get(i) * x;
			if (val+carry > 9) {
				int sum = val+ carry;
				
				result.set(i, (sum%10));
				carry = sum/10;
			}
			else {
				result.set(i, val+ carry);
				carry = 0;
			}
		}
		if(carry != 0) result.add(carry);
		//printArray(result);
		
	}


	private void convertToArray(int number, ArrayList<Integer> result) {
		// TODO Auto-generated method stub
		//store in reverse form
		
		int index = 0;
		while(number > 0) {
			result.add(number %10);
			number /= 10;
			
		}
	printArray(result);
		
	}


	private void printArray(ArrayList<Integer> result) {
		// TODO Auto-generated method stub
		for(int i = 0; i < result.size(); i++)
			System.out.print(result.get(i)+"\t");
		
		System.out.println();
		
	}

}
