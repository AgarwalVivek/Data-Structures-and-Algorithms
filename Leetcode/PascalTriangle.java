import java.util.ArrayList;
//OM SAI RAM
public class PascalTriangle {

	 public ArrayList<ArrayList<Integer>> generate(int numRows) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		 
		 ArrayList<Integer> curArray = null ;
		 
		 for(int i=1; i<= numRows; i++) {
			 curArray = getCurList(i, curArray);
			// System.out.println(curArray);
			 result.add(curArray);
			 
		 }
		 
		 return result;
	        
	    }

	private ArrayList<Integer> getCurList(int n, ArrayList<Integer> prevArray) {
		// TODO Auto-generated method stub
		ArrayList<Integer> cur = new ArrayList<Integer>();
		if(n == 1) {
			cur.add(1);
		
		} else if(n ==2) {
			cur.add(prevArray.get(0));
			cur.add(1);
		} else {
			cur.add(prevArray.get(0));
			for(int i = 0; i < prevArray.size()-1; i++) {
				
				cur.add(prevArray.get(i) +prevArray.get(i+1));
			}
			cur.add(prevArray.get(prevArray.size()-1));
		}
		return cur;
	}
	public static void main(String[] args) {
		PascalTriangle obj = new PascalTriangle();
		ArrayList<ArrayList<Integer>> result = obj.generate(7);
		System.out.println(result);
	}
}
