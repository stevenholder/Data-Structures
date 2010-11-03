
public class OurPaper implements Comparable {
	private int pages;
	private String title;
	
	public OurPaper(int p, String t) {
		pages = p;
		title = t;
	}

	@Override
	public int compareTo(Object o) {
		if(o == null)
			throw new NullPointerException();
		if(getClass() != o.getClass())
			throw new ClassCastException();
		OurPaper paper = (OurPaper) o;
		return pages - paper.pages;
	}
	
	public String toString() {
		return title + " - " + pages;
	}
}
