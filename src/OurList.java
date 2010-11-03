import java.util.Iterator;

/**
 * Our version of the List interface
 * Refer to the List interface in the Java API
 * for details on each of these methods
 *
 * @author (Rodrigo A. Obando)
 * @version (1.0)
 */
public interface OurList<E> extends Iterable<E> {
	boolean add(E data);
	void add(int index, E data);
	boolean addAll(OurList<E> c);
	boolean addAll(int index, OurList<E> c);
	void clear();
	boolean contains(E data);
	E get(int index);
	int indexOf(E data);
	boolean isEmpty();
	int lastIndexOf(E data);
	E remove(int index);
	boolean remove(E data);
	boolean removeAll(OurList<E> c);
	E set(int index, E data);
	int size();
	OurList<E> subList(int fromIndex, int toIndex);
	E[] toArray();
	Iterator<E> iterator();
}