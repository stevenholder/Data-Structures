import java.util.Iterator;

public class OurIterator<E> implements Iterator<E> {
	private OurList<E> list;
	private int index;
	
	public OurIterator() {
		this(new OurArrayList<E>());
	}
	
	public OurIterator(OurList<E> list) {
		this.list = list;
		this.index = 0;
	}
	
	@Override
	public boolean hasNext() {
		return index < list.size();
	}

	@Override
	public E next() {
		return list.get(index++);
	}

	@Override
	public void remove() {

	}

}