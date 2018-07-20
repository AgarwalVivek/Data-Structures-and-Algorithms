import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

class StringFreq {
    public String frequencySort(String s) {
        if(s.length() <=2) return s;
        
        int cache[] = new int[256];
        TreeMap<Integer, StringBuilder> map = new TreeMap<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return -o1.compareTo(o2);
			}
        	
        });
        
        //for invalid entry fill -1 in cache
        Arrays.fill(cache, -1);
        
        for(int i = 0; i< s.length(); i++)
            cache[s.charAt(i)]++;
        
        StringBuilder cur;
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < cache.length; i++){
            //valid cells
            if(cache[i] != -1){
                if(map.containsKey(cache[i])){
                   cur = map.get(cache[i]);
               
                } else{
                    cur = new StringBuilder();
                  
                }
                  cur.append((char)(i)+"");
                  map.put(cache[i], cur);
            }
        }

        System.out.println(map);
        char current;
        for(Entry<Integer, StringBuilder> entry: map.entrySet()){
        	    int i;
        	    StringBuilder str = entry.getValue();
        	    for(int j = 0; j < str.length(); j++) {
        	    	    current = str.charAt(j);
        	    	    	i = entry.getKey();
	        	    while(i-- >= 0) {
	        	    	 	
	        	    	 	
	        	    		result.append(current);
	        	    }
        	    }
        
        	    
       }
        return result.toString();
        
    }
    public static void main(String args[]) {
	    	String s= "tree";
	    	StringFreq obj = new StringFreq();

	    System.out.println(obj.frequencySort(s));
	    	
    }
}