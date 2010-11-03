
public class OurArrayStack<E> implements OurStack<E> {
	private OurArrayList<E> list;
	
	public OurArrayStack() {
		list = new OurArrayList<E>();
	}
	
	@Override
	public boolean empty() {
		return list.isEmpty();
	}

	@Override
	public E peek() {
		return list.get(list.size()-1);
	}

	@Override
	public E pop() {
		return list.remove(list.size()-1);
	}

	@Override
	public E push(E obj) {
		list.add(obj);
		return obj;
	}

	public static void main(String[] args) {
		OurArrayStack<Integer> stack = new OurArrayStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.peek());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(stack.empty());
	}

}
