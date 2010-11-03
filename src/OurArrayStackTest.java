import junit.framework.TestCase;


public class OurArrayStackTest extends TestCase {

	public OurArrayStackTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testEmpty() {
		OurArrayStack<String> s = new OurArrayStack<String>();
		this.assertTrue(s.empty());
	}

}
