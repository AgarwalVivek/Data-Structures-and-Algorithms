import java.util.ArrayList;

//Om Sai Ram
public class Hasher<K,V> {
	K key;
	V value;
	ArrayList<LinkedListNode<K,V>> arr;
	private static  class LinkedListNode<K,V>{
		K key;
		V value;
		LinkedListNode<K, V> next;
		LinkedListNode<K, V>prev;
		
		
		public LinkedListNode(K key, V value) {
			this.key = key;
			this.value = value;
			next = null;
			prev = null;
		}
		
	}
	public Hasher(int capacity) {
		arr = new ArrayList<>(capacity);
		//forming array list of buckets
		for(int i= 0; i < capacity; i++){
			arr.add(null);
		}
			
	}
	
	public void put(K key, V value) {
		LinkedListNode<K, V> toPut = getNodeForKey(key);
		if(toPut != null) {
			//update the value of the already contained key with new value nothing other than that is needed
			
			toPut.value = value;
			return;
		}
		LinkedListNode<K, V> element = new LinkedListNode(key, value);
		//toPut is  null so fresh entry needed.
		int index = getIndexForKey(key);
		if(arr.get(index) == null) {
			//empty in this chain be the first guy (head) of this chain
			arr.set(index,element );
			
		} else {
			//in this chain attach to head
			LinkedListNode<K,V> cur = arr.get(index);
			element.next = cur;
			cur.prev = element;
			cur = element;
			arr.set(index, cur);
		}
	}
	
	public V get(K key) {
		LinkedListNode<K,V> toReturn = getNodeForKey(key);
		return toReturn != null?toReturn.value:null;
		
	}
	public boolean remove(K key) {
		LinkedListNode toRemove = getNodeForKey(key);
		if(toRemove == null) {
			return false;
		}
		int index = getIndexForKey(key);
		//go to that bucket and check the position of desired node and adjust accordingly at the time of deletion
		//make necessary pointer adjustments
		if(toRemove.prev == null) {
			//remove the head
			toRemove = toRemove.next;
			toRemove.prev = null;
			arr.set(index, toRemove);
			
		} else {
			//Intermediate node deletion
			toRemove.prev.next  = toRemove.next;
			
		}
		if(toRemove.next != null) {
			toRemove.next.prev = toRemove.prev;
		}
		return true;
		
	}

	private LinkedListNode<K, V> getNodeForKey(K key) {
		// TODO Auto-generated method stub
		int index = getIndexForKey(key);
		LinkedListNode<K, V> target = arr.get(index);
		while(target != null) {
			if(target.key == key) {
				return target;
			}
			target = target.next;
		}
		return null;
	}

	private int getIndexForKey(K key) {
		// TODO Auto-generated method stub
		int hashCode = getHashCode(key);
		
		return hashCode;
	}

	private int getHashCode(K key) {
		// TODO Auto-generated method stub
		
		return Math.abs(key.hashCode()%arr.size());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
