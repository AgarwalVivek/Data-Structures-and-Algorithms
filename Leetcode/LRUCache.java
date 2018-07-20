import java.util.HashMap;

class myLinkedList{
   static  Node head;
    
    class Node{
        int item;
        Node next;
        Node(){
        	item = -1;
        	
        }
        public Node(int item){
            this.item  = item;
            next = null;
        }
        
        public Node insert(int item, Node head){
            Node temp;
            temp = new Node(item);
            if(head == null){
                return temp;
            } else{
                Node prev = null, cur = head;
                
                while(cur != null){
                    prev = cur;
                    cur = cur.next;
                }
                prev.next = temp;
                return head;
            }
            
        }
        
        public Node removeFirst(Node head){
            Node temp = head;
            if(temp == null) return null;
            head = temp.next;
            return head;
        }
        //returns node before the target node
        public Node find(Node head, int key){
        
            if(head == null) return null;
            Node cur = head;
            Node prev = null;
            while(cur != null && cur.item != key){
                prev = cur;
                cur = cur.next;
            }
            if(cur == null){
                return null;
            }
            return prev;
        }
        public Node evict(Node head, int key){
            Node prev = find(head, key);
            Node cur = prev.next;
            prev.next = cur.next;
            return head;
        }
        public Node moveToFront(Node head, int key){
            Node newHead = head;
            evict(head, key);
            //now add to last;
            insert(item, head);
            return head;
        }
        
    }

	public static void moveToFront(int key) {
		// TODO Auto-generated method stub
		head = head.moveToFront(head, key);
		
	}

	public static void removeFirst() {
		// TODO Auto-generated method stub
		head = head.removeFirst(head);
		
	}

	public static void insert(int key) {
		// TODO Auto-generated method stub
		
		head.insert(key, head);
	}
    
}
class LRUCache {

    int capacity;
    HashMap<Integer, Integer> pair = new HashMap<>();
    myLinkedList keys = new myLinkedList();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(capacity == 0 || !pair.containsKey(key) ) return -1;
        int value = pair.get(key);
        keys.moveToFront(key);
        return value;   
    }
    
    public void put(int key, int value) {
        if(pair.size()>=capacity) {
            keys.removeFirst();
        } else{
            pair.put(key, value);
            keys.insert(key);
            capacity++;
            
        }
    }
    public static void main(String args[]) {
    	 LRUinBuilt lru = new LRUinBuilt(2);
    	 lru.put(1, 2);
    	 System.out.println(lru.get(1));
    	 
    }
}