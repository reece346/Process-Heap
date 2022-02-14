/*
 * Reece Peters
 */

//define class
public class ProcessHeap {
	//instance variables
	private Process[] heap;
	public static final int DEF_SIZE = 127;
	private int size;
	
	//default constructor
	public ProcessHeap() {
		init(DEF_SIZE);
	}
	
	//parameterized constructor + init
	public ProcessHeap(int aSize) {
		init(aSize);
	}
	private void init(int aSize) {
		if(aSize > 0) {
			heap = new Process[aSize];
			this.size = 0;
		} else {
			init(DEF_SIZE);		
		}
	}
	
	//Add Method
	public void add(Process aProcess) {
		if(size >= heap.length) {
			return;
		}
		heap[size] = aProcess;
		this.bubbleUp();
		size++;
	}
	//bubble up
	private void bubbleUp() {
		int index = this.size;
		while(index > 0 && heap[(index-1)/2].compareTo(heap[index])<0) {
			Process temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
		}
	}
	
	//Peek Method
	public Process peek() {
		return heap[0];
	}
	
	//Remove Method
	public Process remove() {
		if(peek() == null) {
			return null;
		}
		Process ret = peek();
		heap[0] = heap[size-1];
		heap[size-1] = null;
		size--;
		//bubble down
		this.bubbleDown();
		return ret;
	}
	//bubble down
	private void bubbleDown() {
		int index = 0;
		while(index*2+1 < size) {
			int bigIndex = index*2+1;
			if(index*2+2 < size && heap[index*2+2].compareTo(heap[index*2+1])>0) {
				bigIndex = index*2+2;
			}
			if(heap[index].compareTo(heap[bigIndex])<0) {
				Process temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			} else {
				break;
			}
			index = bigIndex;
		}
	}
	
	//Print Method
	public void printHeap() {
		for(Process p : heap) {
			if(p == null) {
				break;
			}
			System.out.println(p);
		}
	}
	
	//Empty Method
	public boolean isEmpty() {
		return heap[0] == null;
	}
}


