import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class PriorityQ implements Comparable<PriorityQ>{

	String prefix;
	String string;
	PriorityQ(String prefix, String string){
		this.prefix = prefix;
		this.string  = string;
	}
	@Override
	public int compareTo(PriorityQ o) {
		// TODO Auto-generated method stub
		
		if(string.toLowerCase().compareTo(o.string.toLowerCase())>=1)
			return 1;
		else if(string.toLowerCase().compareTo(o.string.toLowerCase()) < 1)
			return -1;
		else if(string.toLowerCase().compareTo(o.string.toLowerCase()) == 0) {
				if(prefix.toLowerCase().compareTo(o.prefix.toLowerCase()) >=1) {
					return 1;
				} else
					return -1;
		}
		return 0;
	}

}
public class Lexicographical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int logFileSize = 5;
		List<String> logFile = new ArrayList<>();
		
	logFile.add("a1 9 2 3 1");
	logFile.add("g1 act car");
	logFile.add("zo4 4 7");
	logFile.add("ab1 Off Key dog");
	logFile.add("a8 act zoo");
	// no sort with case sensitive nature
	//only digit value should be in same order and appended to existing
	getSolution(logFileSize, logFile);
		

	}

	
	private static void getSolution(int logFileSize, List<String> logFile) {
		// TODO Auto-generated method stub
		ArrayList<String> numeric = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		PriorityQueue<PriorityQ> pq = new PriorityQueue<>();
		
		for(String cur: logFile) {
			int index = cur.indexOf(" ");
			String id = cur.substring(0, index);
			String val = cur.substring(index+1, cur.length());
			if(val.matches("[0-9 ]+")) {
				numeric.add(cur);
				
			} else {
				System.out.println("hds");
				pq.add(new PriorityQ(id, val));
			}
				
			
		}
		
		while(!pq.isEmpty()) {
			PriorityQ p = pq.poll();
			result.add(p.prefix+" "+p.string);
			
		}
		
		result.addAll(numeric);
		System.out.println(result);
	}

}
