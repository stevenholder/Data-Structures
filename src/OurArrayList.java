import java.util.Arrays;
import java.util.Iterator;

/**
 * 
 * @author Steven Holder
 *
 */

public class OurArrayList<E> implements OurList<E> {
	private E[] storage;
	
	public OurArrayList() {
		storage = (E[]) new Object[10];
	}
	
	@Override
	public int size() {
		int total = 0;
		for(int i=0; i<storage.length; i++) {
			if(storage[i] != null)
				total++;
		}
		return total;
	}
	
	@Override
	public boolean add(E o) {	
		if(this.size() >= storage.length)
			this.realocate();
		
		int endOfList = this.size();
		storage[endOfList] = o;
		return true;
	}
	
	@Override
	public void add(int index, E o) {
		if(index < 0 || index > this.size()) {
			return;
		}
		
		if(storage[index] != null) {
			if(index == (this.size()-1))
				this.realocate();
			this.add(index+1, storage[index]);
		}
		
		storage[index] = o;
	}
	
	@Override
	public void clear() {
		storage = (E[]) new Object[10];
	}
	
	@Override
	public E get(int index) {
		return storage[index];
	}
	
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	private void realocate() {
		storage = Arrays.copyOf(storage, storage.length*2);
	}
	
	@Override
	public E remove(int index) {
		if(index == this.size()) {
			return null;
		}
		E temp = storage[index];
		storage[index] = remove(index+1);
		return temp;
	}
	
	@Override
	public boolean addAll(OurList<E> c) {
		for(E element : c)
			this.add(element);
		
		return true;
	}

	@Override
	public boolean addAll(int index, OurList<E> c) {
		for(int i = 0; i<c.size(); i++) {
			this.add(index+i, c.get(i));
		}
		return true;
	}

	@Override
	public boolean contains(E data) {
		boolean var = false;
		for(int i = 0; i < size(); i++) {
			if(this.storage[i].equals(data))
				var = true;
		}
		return var;
	}

	@Override
	public int indexOf(E data) {
		/*
		int var = -1;
		for(int i = 0; i < size(); i++) {
			if(this.storage[i].equals(data)) {
				var = i;
				return var;
			}
		}
		return var;
		*/
		
		return internalIndexOf(data, 0);
	}
	
	private int internalIndexOf(E data, int posFirst) {
		if(posFirst == this.size())
			return -1;
		else {
			if(this.storage[posFirst].equals(data))
				return posFirst;
			else
				return internalIndexOf(data, posFirst++);
		}
	}

	@Override
	public int lastIndexOf(E data) {
		int var = -1;
		for(int i = 0; i < size(); i++) {
			if(this.storage[i].equals(data))
				var = i;
		}
		return var;
	}

	@Override
	public boolean remove(E data) {
		if(this.contains(data)) {
			this.remove(indexOf(data));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeAll(OurList<E> c) {
		for(int i = 0; i<c.size(); i++) {
			if(this.contains(c.get(i)))
				this.remove(c.get(i));
		}
		return true;
	}

	@Override
	public E set(int index, E data) {
		E temp = storage[index];
		storage[index] = data;
		return temp;
	}

	@Override
	public OurList<E> subList(int fromIndex, int toIndex) {
		OurList<E> temp = new OurArrayList<E>();
		
		//Iterator it = this.iterator();
		//while(it.hasNext())
		//	temp.add(it.next());
		
		for(int i = fromIndex; i < toIndex; i++) 
			temp.add(storage[i]);
		
		return temp;
	}
	
	@Override
	public Iterator<E> iterator() {
		return (Iterator<E>) new OurIterator(this);
	}
	
	@Override
	public E[] toArray() {
		E[] temp = (E[]) new Object[size()];
		for(int i = 0; i < size(); i++) {
			temp[i] = storage[i];
		}
		return temp;
	}
}
