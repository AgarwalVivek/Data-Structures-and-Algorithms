import java.util.TreeMap;

public class FlowersGoogle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 2, 7, 6, 4, 3, 5};
		int k = 2;
		int m = 2;
		FlowersGoogle obj = new FlowersGoogle();
		int out = obj.solution(A, k, m);
		System.out.println(out);
		TreeMap<Integer, Integer> tm = new TreeMap<>();
	
	}

	public int solution(int[] A, int k, int M) {
        // write your code in Java SE 8
        
        boolean []  f = new boolean[A.length];
        int days = -1;
        int count = 0;
        int h =0;
        for(int i =0;i < A.length;i++){
            h =0;
            f[A[i]-1] = true;
            count = 0;
            for(int j=0; j < A.length;j++){
                if(f[j]){
                    count++;
                    }else 
                    { if(count == k )
                    {
                    h++; 
                    
                    }
                    count = 0;
                }
                
                
                }
                if (count == k){
                    h++;
                }
            if ( h == M){
                days = i + 2;
            }    
                
                
                
            }
            return days;
}
}
