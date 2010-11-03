public interface OurQueue<E> {
	E element();
	boolean add(E obj);
	boolean offer(E obj);
	E peek();
	E poll();
	E remove();
	
}
