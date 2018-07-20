import java.util.HashMap;

class DNode{
	int key;
	int value;
	DNode prev;
	DNode next;
	DNode(int k, int v){
		key = k;
		value = v;
	}
}
public class LRU {
	int capacity;
	HashMap<Integer, DNode> pair;
	DoublyLinkedList cache;
	
	
	LRU(int capacity){
		this.capacity = capacity;
		pair = new HashMap<>();
		cache = new DoublyLinkedList();
	}
	public void put(int key, int value) {
		if(pair.size()>=capacity) {
			//evict from cache and map
			DNode node = cache.findCandidate();
			pair.remove(node.key);
			//cache.remove(node);
			node = new DNode(key, value);
			pair.put(key, node);
			cache.add(node);
		} else {
			if(pair.containsKey(key)) {
				DNode node = pair.get(key);
				cache.remove(node);
				node.value = value;
				cache.add(node);
				pair.remove(key);
			    pair.put(key, node);
			} else {
				//put to both hashmap and list
				DNode node = new DNode(key,value);
				cache.add(node);
				pair.put(key, node);
			}
		}
	}
	public int get(int key) {
		 if(pair.size() ==0 || !pair.containsKey(key) ) return -1;
	        DNode node = pair.get(key);
	        cache.moveToFront(node);
	        return node.value;   
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRU cache = new LRU(2);
		cache.put(1, 1);
		cache.put(2, 2);
	System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
		
	}

}
