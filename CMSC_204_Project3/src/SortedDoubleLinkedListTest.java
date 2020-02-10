
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedListTest {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator comparator;
	DoubleComparator comparatorD;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	

	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		//STUDENT - use the SortedDoubleLinkedList<Double> for your STUDENT tests
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		sortedLinkedString = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulStringNext() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
	}
	
	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		sortedLinkedDouble.add(new Double(10));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasNext());	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		sortedLinkedDouble.add(new Double(10));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		Double i = iterator.next();
		assertEquals(new Double(2), i);
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		//assertEquals(new Double(10), iterator.previous());
		assertEquals(new Double(8), iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Zebra", iterator.next());
		try{
			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionDouble() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		sortedLinkedDouble.add(new Double(10));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(10), iterator.next());
		try{
			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}	}
	
	@Test
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorUnsupportedOperationExceptionDoubleSTUDENT() {
		sortedLinkedString.add("Student Hello");
		sortedLinkedString.add("Student World");
		sortedLinkedString.add("Student Begin");
		sortedLinkedString.add("Student Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
	
	@Test
	public void testAddString() {
		sortedLinkedString.add("Banana");
		sortedLinkedString.add("Elephant");
		sortedLinkedString.add("Apple");
		assertEquals("Apple", sortedLinkedString.getFirst());
		assertEquals("Elephant", sortedLinkedString.getLast());
		sortedLinkedString.add("Cat");
		sortedLinkedString.add("Dog");
		assertEquals("Apple", sortedLinkedString.getFirst());
		assertEquals("Elephant", sortedLinkedString.getLast());
		//deletes Elephant from linked list
		assertEquals("Elephant",sortedLinkedString.retrieveLastElement());
		assertEquals("Dog", sortedLinkedString.getLast());
	}

	@Test
	public void testAddDoubleSTUDENT() {
		sortedLinkedString.add("Student Banana");
		sortedLinkedString.add("Student Elephant");
		sortedLinkedString.add("Student Apple");
		assertEquals("Student Apple", sortedLinkedString.getFirst());
		assertEquals("Student Elephant", sortedLinkedString.getLast());
		sortedLinkedString.add("Student Cat");
		sortedLinkedString.add("Student Dog");
		assertEquals("Student Apple", sortedLinkedString.getFirst());
		assertEquals("Student Elephant", sortedLinkedString.getLast());
		//deletes Elephant from linked list
		assertEquals("Student Elephant",sortedLinkedString.retrieveLastElement());
		assertEquals("Student Dog", sortedLinkedString.getLast());
	}
	
	@Test
	public void testRemoveFirstString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		assertEquals("Hello", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Begin");
		assertEquals("Begin", sortedLinkedString.getFirst());
		// remove the first
		sortedLinkedString.remove("Begin", comparator);
		assertEquals("Hello", sortedLinkedString.getFirst());
	}
	
	@Test
	public void testRemoveFirstDouble() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		assertEquals(new Double(5), sortedLinkedDouble.getFirst());
		assertEquals(new Double(8), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(new Double(2));
		assertEquals(new Double(2), sortedLinkedDouble.getFirst());
		// remove the first
		sortedLinkedDouble.remove(new Double(2), comparatorD);
		assertEquals(new Double(5), sortedLinkedDouble.getFirst());
	}
	
	@Test
	public void testRemoveEndString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		assertEquals("Hello", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Zebra");
		assertEquals("Zebra", sortedLinkedString.getLast());
		//remove from the end of the list
		sortedLinkedString.remove("Zebra", comparator);
		assertEquals("World", sortedLinkedString.getLast());
	}

	@Test
	public void testRemoveEndDoubleSTUDENT() {
		sortedLinkedString.add("Student Hello");
		sortedLinkedString.add("Student World");
		assertEquals("Student Hello", sortedLinkedString.getFirst());
		assertEquals("Student World", sortedLinkedString.getLast());
		sortedLinkedString.add("Student Zebra");
		assertEquals("Student Zebra", sortedLinkedString.getLast());
		//remove from the end of the list
		sortedLinkedString.remove("Student Zebra", comparator);
		assertEquals("Student World", sortedLinkedString.getLast());
	}
	
	@Test
	public void testRemoveMiddleString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		assertEquals("Hello", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Begin");
		assertEquals("Begin", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		assertEquals(3,sortedLinkedString.getSize());
		//remove from middle of list
		sortedLinkedString.remove("Hello", comparator);
		assertEquals("Begin", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		assertEquals(2,sortedLinkedString.getSize());
	}
	
	@Test
	public void testRemoveMiddleDoubleSTUDENT() {
		sortedLinkedString.add("Student Hello");
		sortedLinkedString.add("Student World");
		assertEquals("Student Hello", sortedLinkedString.getFirst());
		assertEquals("Student World", sortedLinkedString.getLast());
		sortedLinkedString.add("Student Begin");
		assertEquals("Student Begin", sortedLinkedString.getFirst());
		assertEquals("Student World", sortedLinkedString.getLast());
		assertEquals(3,sortedLinkedString.getSize());
		//remove from middle of list
		sortedLinkedString.remove("Student Hello", comparator);
		assertEquals("Student Begin", sortedLinkedString.getFirst());
		assertEquals("Student World", sortedLinkedString.getLast());
		assertEquals(2,sortedLinkedString.getSize());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
}
