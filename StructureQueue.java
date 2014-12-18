import java.util.LinkedList;

/**
 * A structure that behaves like a queue but implements the Structure interface
 * Feel free to build on existing java implementations, no need to build from
 * scratch. (you can import and use something like LinkedList for example)
 * 
 * @param <T>
 */
public class StructureQueue<T> implements Structure<T> {
	public LinkedList<T> a = new LinkedList<T>();
	@Override
	public boolean isEmpty() {
		return a.isEmpty();
	}

	@Override
	public void clear() {
		a.clear();

	}

	@Override
	public void add(T node) {
		a.addLast(node);

	}

	@Override
	public T remove() {
		if(a.size() == 0)
			return null;
		else
			return a.removeFirst();
	}

}
