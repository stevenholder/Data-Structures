
public class OurLinkedCapacityQueue<E> extends OurLinkedQueue<E> {
	private int capacity;
	
	public OurLinkedCapacityQueue() {
		this(10);
	}
	
	public OurLinkedCapacityQueue(int capacity) {
		super();
		this.capacity = capacity;
	}
	
	public boolean add(E obj) {
		if(list.size() < capacity) 
			return list.add(obj);
		else
			throw new IllegalStateException();
	}
	
	public boolean offer(E obj) {
		if(list.size() < capacity) 
			return list.add(obj);
		else
			return false;
	}	

	public static void main(String[] args) {
		OurLinkedCapacityQueue<Integer> q = new OurLinkedCapacityQueue<Integer>(5);
		q.add(1);
		q.offer(2);
		q.offer(3);
		q.add(4);
		q.offer(5);
		
		System.out.println(q.remove());
		System.out.println(q.poll());
		System.out.println(q.remove());
		System.out.println(q.poll());
		System.out.println(q.poll());
	}

}
