import java.lang.reflect.Array;
import java.util.Arrays;

class MyHashSet {

	    private int buckets = 1000;
	    private int itemsPerBucket = 1001;
	    private boolean[][] table;
	    
	    /** Initialize your data structure here. */
	    public MyHashSet() {
	        table = new boolean[buckets][];
	    }

	    public int hash(int key) {
	        return key % buckets;
	    }

	    public int pos(int key) {
	    		int k =  key / buckets;
	        System.out.println(k);
	        return k;
	    }
	    
	    public void add(int key) {
	        int hashkey = hash(key);
	        
	        if (table[hashkey] == null) {
	            table[hashkey] = new boolean[itemsPerBucket];
	        }
	        table[hashkey][pos(key)] = true;
	    }
	    
	    public void remove(int key) {
	        int hashkey = hash(key);

	        if (table[hashkey] != null)
	            table[hashkey][pos(key)] = false;
	    }
	    
	    /** Returns true if this set did not already contain the specified element */
	    public boolean contains(int key) {
	        int hashkey = hash(key);
	        for(int i  = 0; i< 15; i++)
		        System.out.println(Arrays.toString(table[i]));
	        return table[hashkey] != null && table[hashkey][pos(key)];
	      
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashSet hm = new MyHashSet();
		hm.add(12);
		hm.add(13);
		hm.add(14);
		hm.remove(14);
		System.out.println(hm.contains(12));
		System.out.println();
		
		

	}

}
