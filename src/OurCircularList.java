
public class OurCircularList<E> {
	private OurList<E> list;
	
	public OurCircularList() {
		this(new OurLinkedList<E>());
	}
	
	public OurCircularList(OurList<E> inputList) {
		list = new OurLinkedList<E>();
		list.addAll(inputList);
	}
	
	public E getCurrent() {
		return list.get(0);
	}
	
	public void advance() {
		list.add(list.remove(0));
	}	
}
