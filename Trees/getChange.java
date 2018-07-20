
public class getChange {
	Change c;
	class Change{
		int coin2;
		int coin5;
		int coin10;
		public Boolean getSumChange(int s) {
			// TODO Auto-generated method stub
			int count10 =0, remains10 = 0;
			int count5 = 0, remains5 = 0;
			int count2 = 0, remains2 = 0;
			int flag = 0;
			if (s < 2) return false;
			
			if (s >= 10) {
				 count10 = getCount(s, 10);
				 remains10 = s - (10 * count10);
			} else  
				remains10 = s;
			
			
			if (remains10 != 0) {
				if (remains10 %2 == 0 && remains10 % 5 != 0) {
					flag = 1;
					count2 = getCount(remains10, 2);
					remains2 = remains10 - (2 * count2);
					if (remains2 == 1) return false;
					//return from here with true
				} else {
					System.out.println("kgh");
					count5 = getCount(remains10, 5);
					remains5 = remains10 - (5 * count5);
					if (remains5 >= 2) {
						System.out.println("Dsd");
						count2 = getCount(remains5, 2);
						remains2 = remains5 - (count2 * 2);
						System.out.println(remains2);
						if (remains2 == 1) return false;
						
					} else if (remains5 != 0) return false;
					
				}
				
				
			} 
			this.coin10 = count10;
			this.coin5 = count5;
			this.coin2 = count2;
			
			return true;
		}
		private int getCount(int s, int d) {
			// TODO Auto-generated method stub
			return(s/d);
		}	
	}
	private Change get() {
		// TODO Auto-generated method stub
		return new Change();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	getChange gc = new getChange();
	gc.c = gc.get();
	
	Boolean isPossible = gc.c.getSumChange(23);  
	System.out.println(gc.c.coin10 + "\t"+ gc.c.coin5+"\t"+gc.c.coin2);
	
	
	System.out.println(isPossible);
		
	}

}
