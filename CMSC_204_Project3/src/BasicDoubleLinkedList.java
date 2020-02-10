import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * This generic double-linked list relies on a head (reference to first element of the list) and tail (reference to the last element of the list)
 * 
 * @author Derek Luong
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> {

	// reference to first element of the list
	protected Node<T> head;
	// reference to the last element of the list
	protected Node<T> tail;
	protected int size;
	
	/**
	 * default constructor. It initializes head node, tail node, and size
	 * 
	 */
	public BasicDoubleLinkedList () {
		head = new Node<T>(null, null, null);
		tail = new Node<T>(null, null, null);
		size = 0;
	}
	
	/**
	 * get size of the linked list
	 * 
	 * @return the size of the linked list
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds element to the front of the list.
	 * 
	 * @param data the data for the Node within the linked list 
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		// create a new linked Node, 
		// and add the linked Node object to the front of the linked list
		Node<T> newNode = new Node<T> (null, data, head.next); 
		// update prev link of old first node to new node
		Node<T> firstNode = head.next;
		if (firstNode != null) {
			firstNode.prev = newNode;
		}
		// update head node point to new node
		head.next = newNode;
		
		// if this is first-added node, point tail to new Node
		if (tail.prev == null) {
			tail.prev = newNode;
		}
		size++;
		return this;
	}
	
	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param data the data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		// create a new linked Node,
		// add the linked Node object to the
		// tail of the linked list
		Node<T> newNode = new Node<T>(tail.prev, data, null); 
		// update next link of old last node to new node
		Node<T> lastNode = tail.prev;
		if (lastNode != null) {
			lastNode.next = newNode;
		}
		// update tail node point to new node
		tail.prev = newNode;        
		
		// if this is first-added node, point head to new node
		if (head.next == null) {
			head.next = newNode;
		}
		size++;
		return this;
	}
	
	/**
	 * find Node containing data equal to given data
	 * 
	 * @param data data data need to be looked up
	 * @param comparator comparator is used to compare data
	 * @return Node if found, otherwise null
	 */
	public Node<T> find(T data, Comparator<T> comparator) {
		Node<T> foundNode = null;
		Node<T> curNode = head.next;
		while (curNode != null) {
			if (comparator.compare(data, curNode.data) == 0) {
				foundNode = curNode;
				break;
			}
			curNode = curNode.next;
		}
		return foundNode;
	}
	
	/**
	 * remove node having data equal to given data
	 * 
	 * @param data data need to be removed
	 * @param comparator comparator is used to compare data
	 */
	public void remove(T data, Comparator<T> comparator) {
		Node<T> foundNode = find(data, comparator);
		if (foundNode != null) {
			unlink(foundNode);
		}
	}
	
	private T unlink(Node<T> x) {
        // assert x != null;
        final T data = x.data;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            head.next = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail.prev = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.data = null;
        size--;
        return data;
    }
	
	/**
	 * Returns but does not remove the first element from the list. If there are no elements the method returns null.
	 * 
	 * @return the data element or null
	 */
	public T getFirst() {
		if (head.next == null) {
			return null;
		}
		return head.next.data;
	}
	
	/**
	 * Returns but does not remove the last element from the list. If there are no elements the method returns null.
	 * 
	 * @return the data element or null
	 */
	public T getLast() {
		if (tail.prev == null) {
			return null;
		}
		return tail.prev.data;
	}
	
	/**
	 * Removes and returns the first element from the list. If there are no elements the method returns null.
	 * 
	 * @return data element or null
	 */
	public T retrieveFirstElement() {
		if (head.next == null) {
			return null;
		}
		return unlinkFirst(head.next);
	}
	
	/**
	 * Removes and returns the last element from the list. If there are no elements the method returns null.
	 * 
	 * @return data element or null
	 */
	public T retrieveLastElement() {
		if (tail.prev == null) {
			return null;
		}
		return unlinkLast(tail.prev);
	}
	
	private T unlinkFirst(Node<T> f) {
        final T data = f.data;
        final Node<T> next = f.next;
        f.data = null;
        f.next = null; 
        head.next = next;
        if (next == null)
            tail.prev = null;
        else
            next.prev = null;
        size--;
        return data;
    }
	
	private T unlinkLast(Node<T> l) {
        final T data = l.data;
        final Node<T> prev = l.prev;
        l.data = null;
        l.prev = null; 
        tail.prev = prev;
        if (prev == null)
            head.next = null;
        else
            prev.next = null;
        size--;
        return data;
    }
	
	/**
	 * Returns an arraylist of the items in the list from head of list to tail of list 
	 * 
	 * @return an arraylist of the items in the list
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> returnedList = new ArrayList<T>();
		Node<T> curNode = head.next;
		while (curNode != null) {
			returnedList.add(curNode.data);
			curNode = curNode.next;
		}
		return returnedList;
    }
	
	/**
	 * This method must be implemented using an inner class that implements ListIterator 
	 * and defines the methods of hasNext(), next(), hasPrevious() and previous(). 
	 * Remember that we should be able to call the hasNext() method as many times as 
	 * we want without changing what is considered the next element.
	 * 
	 * @return
	 * @throws java.lang.UnsupportedOperationException - Your next() method should throw NoSuchElementException 
	 * 		if there are no more elements (at the end of the list and calling next() 
 * 			or at the beginning of the list and calling previous()). 
	 * @throws java.util.NoSuchElementException - You don't need to implement the ListIterator's remove(), add(), 
 * 			nextIndex() and previousIndex() and set() methods, throw UnsupportedOperationException if called.
	 */
	public ListIterator<T> iterator()
            throws java.lang.UnsupportedOperationException,
                   java.util.NoSuchElementException {
		return new BasicDoubleLinkedListIterator();
	}
	
	class BasicDoubleLinkedListIterator implements ListIterator<T> {

		Node<T> lastReturned;
		Node<T> next;
		int nextIndex;
		
		BasicDoubleLinkedListIterator() {
			next = head.next;
			nextIndex = 0;
		}
		
		@Override
		public boolean hasNext() {
			return nextIndex < size;
		}

		@Override
		public T next() {
			if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
		}

		@Override
		public boolean hasPrevious() {
			return nextIndex > 0;
		}

		@Override
		public T previous() {
			if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = next = (next == null) ? tail.prev : next.prev;
            nextIndex--;
            return lastReturned.data;
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();
		}
		
	}
	
	class Node<T> {
		T data;
		Node<T> prev;
		Node<T> next;
		
		Node(Node<T> prev, T data, Node<T> next) {
			this.prev = prev;
			this.data = data;
			this.next = next;
		}
	}
}
