/**
 * 
 * @author Steven Holder
 *
 */

public class Node<E> {
	private E data;
	private Node<E> next;

	public Node() {
		this(null);
	}

	public Node(E data) {
		this(data, null);
	}

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public boolean append(E data) {
		boolean returnValue = false;
		if(next == null) {
			next = new Node<E>(data);
			returnValue = true;
		} else {
			returnValue = this.next.append(data);
		}
		return returnValue;
	}
	
	public void add(int index, E data) {
		if(index == 0) {
			insertAfter(data);
		} else {
			next.add(index-1, data);
		}
	}	
	
	public boolean insertAfter(E data) {
		this.next = new Node<E>(data, this.next);
		return true;
	}

	public int size() {
		int size = 0;
		if(next == null)
			size = 1;
		else 
			size = 1 + next.size();
		return size;
	}
	
	public boolean contains(E data) {
		if(this.data.equals(data)) {
			return true;
		} else {
			if(next == null)
				return false;
			else {
				return next.contains(data);
			}
		}
	}	
	
	public int indexOf(int index, E data) {
		if(this.data.equals(data)) {
			return index;
		} else {
			if(next == null)
				return -1;
			else {
				return next.indexOf(index+1, data);
			}
		}
	}	
	
	public int lastIndexOf(int index, int indexFound, E data) {
		int latestIndexFound = indexFound;
		if(this.data.equals(data)) {
			latestIndexFound = index;
		}
		if(next == null)
			return latestIndexFound;
		else
			return next.lastIndexOf(index+1, latestIndexFound, data);
	}
	
	public E get(int index) {
		if(index == 0) {
			return data;
		} else {
			return next.get(index-1);
		}
	}
	
	public E set(int index, E data) {
		if(index == 0) {
			E temp = this.data;
			this.data = data;
			return temp;
		} else {
			return next.set(index-1, data);
		}
	}

	public E remove(int index) {	
		if(index ==1) {
			E temp = next.getData();
			next = next.getNext();
			return temp;
		} else {
			return remove(index -1);
		}
	}

	public Node<E> reverse(Node<E> newNext) {
		Node<E> oldNext = this.next;
		this.next = newNext;
		
		if(oldNext == null)
			return this;
		else {
			return oldNext.reverse(this);
		}
	}
	
	public static void main(String[] args) {
		Node<Integer> n = new Node<Integer>(1);		
		n.append(2);
		n.append(3);
				
		n.reverse(n);
		
		System.out.println(n.get(0));
		System.out.println(n.get(1));
		System.out.println(n.get(2));
	}
}