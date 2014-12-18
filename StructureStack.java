import java.util.LinkedList;

/**
 * A structure that behaves like a stack but implements the Structure interface
 * Feel free to build on existing java implementations, no need to build from
 * scratch. (you can import and use something like LinkedList for example)
 * 
 * @param <T>
 */
public class StructureStack<T> implements Structure<T> {
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
		a.addFirst(node);

	}

	@Override
	public T remove() {
		return a.removeFirst();
	}
	
	public LinkedList<T> getList()
	{
		return a;
	}

}
