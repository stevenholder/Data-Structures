import java.util.ArrayList;


public class OurHeap {
	private ArrayList<Comparable> storage;

	public OurHeap() {
		storage = new ArrayList<Comparable>();
	}

	public ArrayList<Comparable> getStorage() {
		return storage;
	}
	
	public void add(Comparable element) {
		int insertionPoint = storage.size();
		storage.add(insertionPoint, element);
		int parent = (insertionPoint - 1)/2;
		while(storage.get(parent).compareTo(storage.get(insertionPoint)) > 0) {
			Comparable temp = storage.get(parent);
			storage.set(parent, storage.get(insertionPoint));
			storage.set(insertionPoint, temp);
			
			insertionPoint = parent;
			parent = (insertionPoint - 1)/2;
		}
	}
	
	public Comparable remove() {
		Comparable temp = storage.get(0);
		storage.set(0, storage.remove(storage.size()-1));
		int currentParent, lc, rc;
		int child = 0;
		
		do {
			currentParent = child;
			lc = (currentParent * 2 + 1);
			rc = (currentParent * 2 + 2);
			if(lc >= storage.size()){
				break;
			}else if(rc >= storage.size())
				child = lc;
			else
				child = storage.get(lc).compareTo(storage.get(rc)) < 0 ? lc : rc;
			
			Comparable temp2 = storage.get(currentParent);
			storage.set(currentParent, storage.get(child));
			storage.set(child, temp2);
			
		} while(storage.get(currentParent).compareTo(storage.get(child)) > 0);
		
		return temp;
	}
}
