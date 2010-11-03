import java.util.NoSuchElementException;


public class OurLinkedQueue<E> implements OurQueue<E> {
	protected OurLinkedList<E> list;
	
	public OurLinkedQueue() {
		list = new OurLinkedList<E>();
	}
	
	@Override
	public boolean add(E obj) {
		return list.add(obj);
	}
	
	@Override
	public E element() {
		if(list.isEmpty()) 
			throw new NoSuchElementException();
		
		return list.get(0);
	}

	@Override
	public boolean offer(E obj) {
		return list.add(obj);
	}

	@Override
	public E peek() {
		return list.isEmpty()? null : list.get(0);
	}

	@Override
	public E poll() {
		return list.isEmpty()? null : list.remove(0);
	}

	@Override
	public E remove() {
		if(list.isEmpty()) 
			throw new NoSuchElementException(); 
		
		return list.remove(0);
	}
	
	public static void main(String[] args) {
		OurLinkedQueue<Integer> q = new OurLinkedQueue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		
		System.out.println(q.remove());
		System.out.println(q.poll());
		System.out.println(q.remove());
		System.out.println(q.poll());
	}

}
