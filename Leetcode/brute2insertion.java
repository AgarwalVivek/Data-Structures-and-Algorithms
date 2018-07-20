
public class brute2insertion {

	public brute2insertion() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[]) {
		int arr[] = {-1, 3, 2, 4};
		
		for(int i =1; i < arr.length; i++)
			arr[i] = arr[i] *arr[i];
		for(int i =1; i < arr.length; i++) {
			
			int j = i -1;
			int n = arr[i];
			while(j >=0 && n < arr[j]) {
				System.out.println("here"+arr[j] +"\t"+arr[i]);
			     
				//shift numbers by one position
				arr[j+1] = arr[j];
	
				System.out.println("here"+arr[j] +"\t"+arr[i]);
				j--;
			}
			arr[j+1] =n;;
			System.out.println("heres"+arr[j+1]+"\t"+arr[j] +"\t"+arr[i]);
		}
		for(int a: arr)
			System.out.println(a);
	}

}
