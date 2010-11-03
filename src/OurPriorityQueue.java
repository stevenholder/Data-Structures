import java.util.NoSuchElementException;


public class OurPriorityQueue {
	private OurHeap heap;
	
	public OurPriorityQueue() {
		heap = new OurHeap();
	}
	
	public boolean offer(Comparable item) {
		heap.add(item);
		return true;
	}
	
	public Comparable remove() {
		if(heap.getStorage().isEmpty())
			throw new NoSuchElementException();
		return heap.remove();		
	}
	
	public Comparable poll() {
		Comparable temp = heap.getStorage().get(0);
		heap.remove();
		return temp;
	}

	public Comparable peek() {
		return heap.getStorage().get(0);
	}
	
	public Comparable element() {
		if(heap.getStorage().isEmpty())
			throw new NoSuchElementException();
		return heap.getStorage().get(0);
	}
	
	public static void main(String[] args) {
		OurPriorityQueue pq = new OurPriorityQueue();
		OurPaper p1 = new OurPaper(1, "1a");
		OurPaper p2 = new OurPaper(4, "4");
		OurPaper p3 = new OurPaper(3, "3");
		OurPaper p4 = new OurPaper(1, "1b");
		pq.offer(p1);
		pq.offer(p2);
		pq.offer(p3);
		pq.offer(p4);

		System.out.println(pq.poll());
		System.out.println("");
		
		for(Object o : pq.heap.getStorage())
			System.out.println(o);
	}
}
