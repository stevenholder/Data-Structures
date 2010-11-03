import java.util.ArrayList;

public class Heapsort {
	public static ArrayList<Comparable> heapsort(ArrayList<Comparable> array) {
		for(int i = array.size() / 2; i >= 0; i--) {
			manage(array, i, array.size());
		}
		for(int i = array.size() - 1; i > 0; i--) {
			Comparable temp = array.get(0);
			array.set(0, array.get(i));
			array.set(i, temp); 
			
			manage(array, 0, i);
			
			/*
			for(Comparable a : array ){
				System.out.println(a);
			}
			System.out.println();
			*/
		}
		return array;
	}

	private static void manage(ArrayList<Comparable> a, int i, int n)
	{
		Comparable temp;
		int element;

		for(temp = a.get(i); n > (2 * i + 1); i = element) {
			element = (2 * i + 1);
			if(element != n - 1 && a.get(element).compareTo(a.get(element+1)) < 0){
				element++;
			}
			if(temp.compareTo(a.get(element)) < 0) {
				a.set(i, a.get(element));
			} else {
 				break;
			}
		}
		a.set(i, temp);
	}
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList(), temp = null;
		list.add(3);
		list.add(6);
		list.add(33);
		list.add(26);
		list.add(53);
		list.add(32);
		list.add(932);
		list.add(1);
		
		temp = Heapsort.heapsort(list);
		
		for(Object c : temp) {
			System.out.println(c);
		}
	}
}
