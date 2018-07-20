import java.util.Arrays;
import java.util.PriorityQueue;

public class PriortyQueue {

	int size;
	int heap[];
	int capacity;
	PriortyQueue (int MaxSize){
		this.size = 0;
		capacity = MaxSize;
		heap = new int[MaxSize];
	}
	//1
//2       //3
	
	public void push(int item) {
		
		if(size == heap.length) return;
		
		int pos = size;
         heap[pos] = item;
         size++;
         
         while(pos > 0) {
        	 	int parent = ((pos + 1)/2) - 1;
        	 	if(heap[parent] > heap[pos]) {
        	 		swap(heap, pos, parent);
        	 		pos = parent;
        	 	} else {
        	 		break;
        	 	}
        	 	
         }
        	 
	}
	public int pop() {
		if(size == 0) return -1;
		
		int toReturn = heap[0];
		
		heap[0] = heap[size-1];
		int pos = 0;
		size--;
		while(pos <size/2) {
			
			
			int rightChild = (pos +1) *2;
			int leftChild = rightChild - 1;
			if(rightChild < size && heap[rightChild] < heap[leftChild]) {
				if(heap[pos] >heap [rightChild]) {
					swap(heap, pos, rightChild);
					pos = rightChild;
				} else 
					break;
				
				} else {
					if(heap[pos] > heap[leftChild]) {
						swap(heap, pos, leftChild);
						pos = leftChild;
					} else 
						break;
				}
			
		}
		
		
		return toReturn;		
	}
	
		
		
	
	private void swap(int[] heap, int pos, int parent) {
		// TODO Auto-generated method stub
		int temp = heap[pos];
		heap[pos] = heap[parent];
		heap[parent] = temp;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> p = new PriorityQueue<>();
		p.add(5);
		p.add(1);
		p.add(30);
		p.add(10);
		p.add(15);
		p.add(2);
		p.add(11);
		int m = -p.poll();
		System.out.println(m);
		PriortyQueue pq = new PriortyQueue(10);
		pq.push(5);
		pq.push(1);
		pq.push(30);
		pq.push(10);
		pq.push(15);
		pq.push(2);
		pq.push(11);
		System.out.println(pq.capacity);
		System.out.println("here");

		System.out.println(pq.pop());
		System.out.println(pq.pop());
		System.out.println(pq.pop());
		System.out.println(pq.pop());
		System.out.println(pq.pop());
		System.out.println(pq.pop());
		
		System.out.println(pq.pop());

		
		

	}

}
