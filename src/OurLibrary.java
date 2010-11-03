
public class OurLibrary {
	private OurStack<Book> cart;
	private OurCircularList<LabeledStack> stacks;
	
	public OurLibrary() {
		cart = new OurArrayStack<Book>();
		OurList<LabeledStack> tempList = new OurArrayList<LabeledStack>();
		String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		for(String letter : alphabet)
			tempList.add(new LabeledStack(letter));
		stacks = new OurCircularList<LabeledStack>(tempList);
	}
	
	public void returnBook(Book book) {
		cart.push(book);
	}
	
	public void distributeBooks() {
		while(!cart.empty()) {
			Book temp = cart.pop();	
			while(!stacks.getCurrent().getLabel().equalsIgnoreCase(temp.getTitle().substring(0, 1))) {
				stacks.advance();
			}
			stacks.getCurrent().getStack().push(temp);
		}
	}
	
	public OurCircularList<LabeledStack> getStacks() {
		return stacks;
	}		
	
	private class LabeledStack {
		String label;
		OurStack<Book> stack;
		
		LabeledStack(String label) {
			this.label = label;
			stack = new OurArrayStack<Book>();
		}

		String getLabel() {
			return label;
		}

		OurStack<Book> getStack() {
			return stack;
		}	
		
		public String toString() {
			return label;
		}
	}
	
	public static void main(String[] args) {
		OurLibrary l = new OurLibrary();
		l.returnBook(new Book("alpha", "Book"));
		l.returnBook(new Book("This", "Book"));
		l.returnBook(new Book("AThis", "Book"));
		l.returnBook(new Book("Iffys Book", "Steven"));
		l.returnBook(new Book("This2", "Book"));
		l.returnBook(new Book("This3", "Book"));
		l.returnBook(new Book("BIffys Book", "Steven"));		
		l.distributeBooks();
		
		for(int i=0; i < 26; i ++) {
			System.out.println(l.getStacks().getCurrent().getLabel());
			while(!l.getStacks().getCurrent().getStack().empty())
				System.out.println(l.getStacks().getCurrent().getStack().pop().getTitle());
			l.getStacks().advance();
		}
	}
}
