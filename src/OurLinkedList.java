import java.util.Iterator;

/**
 * 
 * @author Steven Holder
 *
 */

public class OurLinkedList<E> implements OurList<E> {
	private Node<E> head = null;
	
	@Override
	public boolean add(E data) {
		boolean value = false;
		if(head == null) {
			head = new Node<E>(data);
			value = true;
		} else {
			value = head.append(data);
		}
		return value;
	}
	
	@Override
	public void add(int index, E data) {
		if(index == 0) 
			head = new Node<E>(data, this.head);
		else {
			head.add(index - 1, data);
		}
	}
	
	@Override
	public void clear() {
		head = null;
	}
	
	@Override
	public boolean isEmpty() {
		return head == null;
	}
	
	@Override
	public boolean contains(E data) {
		if(head == null)
			return false;
		else
			return head.contains(data);
	}
	
	@Override
	public int size() {
		if(head == null)
			return 0;
		else
			return head.size();
	}
	
	@Override
	public E get(int index){
		if(head == null)
			return null;
		else 
			return (E) head.get(index);
	}
	
	@Override
	public E set(int index, E data) {
		if(head == null)
			return null;
		else 
			return head.set(index, data);
	}
	
	@Override
	public int indexOf(E data) {
		return head == null? -1 : head.indexOf(0, data);
	}
	
	@Override
	public int lastIndexOf(E data) {
		return head == null? -1 : head.lastIndexOf(0, -1, data);
	}
	
	public void reverse() {
		if(head != null)
			head = head.reverse(null);
	}
		
	@Override
	public boolean addAll(OurList<E> c) {
		boolean value = false;
		
		if(c.size() == 0) {
			return value;
		}
		
		if(head == null) {
			head = new Node<E>(c.get(0));
			for(int i = 1; i < c.size(); i++) {
				value = head.append(c.get(i));
			}			
			value = true;
		} else {
			for(int i = 0; i < c.size(); i++) {
				value = head.append(c.get(i));
			}
		}
		return value;
	}

	@Override
	public boolean addAll(int index, OurList<E> c) {
		boolean value = false;
		
		if(c.size() == 0 || index < 0 || index > size()) {
			return value;
		}
		
		if(head == null) {
			value = addAll(c);	
		} else {
			for(int i = 0; i < c.size(); i++) {
				head.add(index+i, c.get(i));
				value = true;
			}
		}
		return value;
	}

	@Override
	public E remove(int index) {
		if(head == null)
			return null;
		else {
			if(index == 0) {
				E temp = head.getData();
				head = head.getNext();
				return temp;
			} else {
				return this.head.remove(index);
			}
		}
	}

	@Override
	public boolean remove(E data) {
		if(head == null)
			return false;
		else {
			if(this.contains(data)) {
				this.head.remove(this.indexOf(data));
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public boolean removeAll(OurList<E> c) {
		boolean var = false;
		if(head == null) {
			var = false;
		} else {			
			for(int i = 0; i < c.size(); i++) {
				if(contains(c.get(i))) {
					var = remove(c.get(i));
				}
			}
		}
		return var;
	}

	@Override
	public OurList<E> subList(int fromIndex, int toIndex) {
		if(fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
			return null;
		
		if(head == null)
			return null;
		else {
			OurList<E> temp = new OurLinkedList<E>();
//			int count = 0, range = toIndex - fromIndex;
//			Node current = head;
//			
//			while(count < fromIndex) {
//				current = current.getNext();
//				count++;
//			}
//			
//			count = 0;
//			
//			while(count < range) {
//				temp.add(current.getData());
//				current = current.getNext();
//				count++;
//			}

			for(int i = fromIndex; i < toIndex; i++) {
				temp.add(this.get(i));
			}
			
			return temp;
			

		}
	}

	@Override
	public E[] toArray() {
		int index = 0;
		E[] contents = (E[]) new Object[size()];
		Node<E> current = head;
		while (current.getNext() != null) {
			contents[index] = current.getData();
			index++;
			current = current.getNext();
		}
		
		for(int i = 0; i < this.size(); i++) {
			contents[i] = this.get(i);
		}
		return contents;
	}

	@Override
	public Iterator<E> iterator() {
		return new OurIterator<E>(this);
	}
	
	public static void main(String[] args) {
		OurLinkedList<Integer> l = new OurLinkedList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		
		for(Object o : l) {
			System.out.println(o);
		}
		
		l.reverse();
		System.out.println();
		
		for(Object o : l) {
			System.out.println(o);
		}
		
		l.reverse();
		System.out.println();
		
		for(Object o : l) {
			System.out.println(o);
		}		
	}	
}
