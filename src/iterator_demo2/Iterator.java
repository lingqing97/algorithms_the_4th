package iterator_demo2;

public interface Iterator<Item> {
	boolean hasNext();
	Item next();
	void remove();

}
