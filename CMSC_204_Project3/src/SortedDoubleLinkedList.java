import java.util.Comparator;

/**
 * Implements a generic sorted double list using a provided Comparator. It extends BasicDoubleLinkedList class.
 * 
 * @author Derek Luong
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	private Comparator<T> comparator;
	
	/**
	 * constructor requires comparator
	 * 
	 * @param comparator is used to compare data
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}
	
	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * 
	 * @param data the data to be added to the list 
	 * @return a reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		Node<T> foundNode = null;
		Node<T> curNode = head.next;
		while (curNode != null) {
			// if having a node greater than given data, break
			if (comparator.compare(data, curNode.data) < 0) {
				foundNode = curNode;
				break;
			}
			curNode = curNode.next;
		}
		
		// if found node is not null, insert new data preceding to foundNode
		if (foundNode != null) {
			Node<T> newNode = new Node<T>(foundNode.prev, data, foundNode);
			Node<T> prev = foundNode.prev;
			if (prev != null) {
				prev.next = newNode;
			} else {
				head.next = newNode;
			}
			foundNode.prev = newNode;
			size++;
		} else {
			super.addToEnd(data);
		}
		return this;
	}
	
	@Override
	public SortedDoubleLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	@Override
	public SortedDoubleLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
}
