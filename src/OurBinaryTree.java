
public class OurBinaryTree<E> {
	private E data;
	private OurBinaryTree<E> TL, TR;
	
	public OurBinaryTree() {
		this(null, null, null);
	}
	
	public OurBinaryTree(E data) {
		this(data, new OurBinaryTree<E>(), new OurBinaryTree<E>());
	}
	
	public OurBinaryTree(E data, OurBinaryTree<E> left, OurBinaryTree<E> right) {
		TL = left;
		TR = right;
		this.data = data;
	}
	
	public boolean isBinary() {		
		return ((TR.isEmpty())? true : TR.isBinary() && (TL.isEmpty())? true : TL.isBinary()); 
	}
	
	public boolean isLeaf() {
		return isEmpty() ? false : TR.isEmpty() && TL.isEmpty();
	}
	
	public boolean isEmpty() {
		return data == null;
	}
	
	public E getData() {
		return data;
	}
	
	public void setData(E data) {
		this.data = data;
	}

	public OurBinaryTree<E> getLeftTree() {
		return TL;
	}

	public void setLeftTree(OurBinaryTree<E> tL) {
		TL = tL;
	}
	
	public OurBinaryTree<E> getRightTree() {
		return TR;
	}

	public void setRightTree(OurBinaryTree<E> tR) {
		TR = tR;
	}
	
	public OurBinaryTree<E> getLeftMost() {
		return (TL.isEmpty()) ? this : TL.getLeftMost();
	}
	
	public OurBinaryTree<E> getRightMost() {
		return (TR.isEmpty()) ? this : TR.getRightMost();
	}
	
	public String preOrderTraverse() {
		if(isEmpty())
			return "";
		else {
			return "" + getData() + " " + TL.preOrderTraverse() + " " + TR.preOrderTraverse();
		}
	}
	
	public String toString() {
		return "" + data;
	}
	
	public static void main(String[] args) {
		OurBinaryTree<Character> h = new OurBinaryTree<Character>('h');
		OurBinaryTree<Character> d = new OurBinaryTree<Character>('d');
		OurBinaryTree<Character> m = new OurBinaryTree<Character>('m');
		OurBinaryTree<Character> r = new OurBinaryTree<Character>('r');
		OurBinaryTree<Character> z = new OurBinaryTree<Character>('z');
		
		h.setLeftTree(d);
		h.setRightTree(m);
		m.setLeftTree(r);
		m.setRightTree(z);
		
		System.out.println(h.preOrderTraverse());
	}
}
