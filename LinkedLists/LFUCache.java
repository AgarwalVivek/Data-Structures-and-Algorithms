import java.util.HashMap;

//Om Sai Ram


public class LFUCache {
	
	int capacity;
	HashMap<Integer, DDNode> cache;
	DoubleLL linkedList;
	
	
	LFUCache(int capacity){
		this.capacity = capacity;
		this.cache = new HashMap<Integer, DDNode>();
		this.linkedList = new DoubleLL();
	}
	
	
	public class DoubleLL {
		DDNode head;
		DDNode tail;
		int size;
		public DoubleLL(){
			size = 0;
			head = tail = null;
		}
		public void insert(DDNode n) {
			
			size++;
			if(head == null) {
				head = tail = n;
				return;
			}
			
			n.right = head;
			head.left = n;
			head  = n;
			n.left = null;
		}
		
		public DDNode findCandidate() {
			if(head == null) {
				return null;
			}
			if(head == tail)
				return head;
			
			//this will be the best candidate to remove
			DDNode target = null;
			
			DDNode temp = tail;
			
			//now traverse the entire LL from tail finding least frequent entry
			
			int minFrequency = Integer.MAX_VALUE;
			
			while(temp!= null) {
				System.out.println("DddsdSD"+temp.getFrequency());
				if(minFrequency > temp.getFrequency()) {
					minFrequency = temp.getFrequency();
					System.out.println("DdSD"+minFrequency);
					target = temp;
				}
				temp = temp.left;
			}
			System.out.println("DSD"+minFrequency);
			return target;
		
		}
		
		public void remove(DDNode n) {
			
			if(this.size == 0) return;
			//only node
			size--;
			if(head == tail) {
				tail = head = null;
				return;
			}
			//head node 
			if(n.left == null && n.right != null) {
				n.right.left = null;
				head = n.right;
				n = null;
				return;
			}
			
			//intermediate node
			if(n.left != null && n.right != null) {
				n.left.right = n.right;
				n.right.left = n.left;
				return;
			}
			if(n.left!= null && n.right == null) {
				n.left.right = null;
				tail = n.left;
			}
		}
	}
	public void put(int key, int value) {
		
		DDNode temp = new DDNode(key, value);
		if(capacity == 0) return;
		if(cache.size() >= capacity) {
	
			DDNode node = linkedList.findCandidate();
		
			if(node == null) {
			
				return;
			}
		
			//remove from linkedlist and from cache
			linkedList.remove(node);
			cache.remove(node.key); 
			//add new entry now
			linkedList.insert(temp);
			cache.put(key, temp);
		} else {
			if(cache.containsKey(key)) {
				//cache can be updated but linkedlist has to be updated(remove and add)
				DDNode n = cache.get(key);
				
				//update the object and store back in cache and linkedList
				linkedList.remove(n);
				
				//recently used so inc frequency
				n.incrementFrequency();
				//update in cache since key is same overwrite happens
				cache.put(key, n);
				linkedList.insert(n);
				
			} else {
			
				linkedList.insert(temp);
				cache.put(key, temp);
			}
		}
	}
	public int get(int key) {
		if(cache.size() == 0 || !cache.containsKey(key)) return -1;
		
		DDNode n = cache.get(key);
		//remove from LL update frequnecy put back 
		linkedList.remove(n);
		n.incrementFrequency();
		linkedList.insert(n);
		cache.put(key, n);
		return n.value;
  
	}
	public void printLL() {
		DDNode n = linkedList.head;
		while(n!= null) {
			System.out.print("\tLL\t"+n.value);
			n = n.right;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * [[3],[2,2],[1,1],[2],[1],[2],[3,3],[4,4],[3],[2],[1],[4]]
		 */
		LFUCache cache = new LFUCache( 3 /* capacity */ );

		cache.put(2, 2);
		cache.put(1, 1);
	
		System.out.println(cache.get(2));       // returns 1
		System.out.println(cache.get(1));
		System.out.println(cache.get(2)); 
	    System.out.println();
		cache.put(3, 3);    
		cache.put(4, 4);    // evicts key 1.
		System.out.println(cache.get(3));      // returns -1 (not found)
		System.out.println(cache.get(2));       // returns 3
		System.out.println(cache.get(1));
		System.out.println(cache.get(4));       // returns 4

	}

}
