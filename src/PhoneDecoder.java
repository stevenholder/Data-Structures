import java.util.HashMap;

public class PhoneDecoder {
	HashMap<String, OurCircularList<String>> charMap;
	
	public PhoneDecoder() {
		charMap = new HashMap<String, OurCircularList<String>>();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int i = 0, count = 2;
		while(count < 10) {
			OurList<String> tempArray = new OurArrayList<String>();
			if(count == 7 || count == 9) {
				tempArray.add(alphabet.substring(i, i+1));
				tempArray.add(alphabet.substring(i+1, i+2));
				tempArray.add(alphabet.substring(i+2, i+3));
				tempArray.add(alphabet.substring(i+3, i+4));
				i+=4;
			} else {
				tempArray.add(alphabet.substring(i, i+1));
				tempArray.add(alphabet.substring(i+1, i+2));
				tempArray.add(alphabet.substring(i+2, i+3));
				i+=3;
			}
			
			OurCircularList<String> list =  new OurCircularList<String>(tempArray);
			charMap.put(""+count, list);
			count++;
		}
	}
	
	public String decode(String encodedString) {
		String[] chars = encodedString.split(" ");
		StringBuilder temp = new StringBuilder();
		for(String s : chars) {
			OurCircularList<String> tempList = buildCopyList(getList(s.substring(0,1)));
			for(int i = 0; i < s.length()-1; i++) {
				tempList.advance();
			}
			temp.append(tempList.getCurrent());
		}
		return temp.toString();
	}
	
	private OurCircularList<String> buildCopyList(OurCircularList<String> list) {
		OurArrayList<String> tempArrayList = new OurArrayList<String>();
		tempArrayList.add(list.getCurrent());
		list.advance();
		while(tempArrayList.get(0) != list.getCurrent()) {
			tempArrayList.add(list.getCurrent());
			list.advance();
		}
		return new OurCircularList<String>(tempArrayList);
	}

	public OurCircularList<String> getList(String name) {
		return charMap.get(name);
	}
	
	public static void main(String[] args) {
		PhoneDecoder pd = new PhoneDecoder();
		System.out.println(pd.decode("22 33 3"));
	}
}
