import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedListTest {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	StringComparator comparator;
	DoubleComparator comparatorD;

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hello");
		linkedString.addToEnd("World");
		comparator = new StringComparator();
		
		//STUDENT: Use the linkedDouble for the STUDENT tests
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(15.0);
		linkedDouble.addToEnd(100.0);
		comparatorD = new DoubleComparator();
		
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
	}

	@Test
	public void testAddToEndSTUDENT(){
		//test addToEnd for the linkedDouble
		assertEquals("World", linkedString.getLast());
		assertEquals(2,linkedString.getSize());
		linkedString.addToEnd("Student End");
		assertEquals("Student End", linkedString.getLast());
		assertEquals(3,linkedString.getSize());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("Begin");
		assertEquals("Begin", linkedString.getFirst());
	}

	@Test
	public void testAddToFrontSTUDENT(){
		//test addToFront for the linkedDouble
		assertEquals("Hello", linkedString.getFirst());
		assertEquals(2,linkedString.getSize());
		linkedString.addToFront("Student Begin");
		assertEquals("Student Begin", linkedString.getFirst());
		assertEquals(3,linkedString.getSize());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
	}
	
	@Test
	public void testGetFirstSTUDENT(){
		//test getFirst for the linkedDouble
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("Student New");
		assertEquals("Student New", linkedString.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
	}

	@Test
	public void testGetLastSTUDENT(){
		//test getLast for the linkedDouble
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("Student New");
		assertEquals("Student New", linkedString.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<String> list;
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		list = linkedString.toArrayList();
		assertEquals("Begin", list.get(0));
		assertEquals("Hello", list.get(1));
		assertEquals("World", list.get(2));
		assertEquals("End", list.get(3));
	}
	
	@Test
	public void testToArraySTUDENT(){
		//test toArray for the linkedDouble
		ArrayList<String> list;
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		linkedString.addToFront("Student Begin");
		linkedString.addToEnd("Student End");
		list = linkedString.toArrayList();
		assertEquals("Student Begin", list.get(0));
		assertEquals("Begin", list.get(1));
		assertEquals("Hello", list.get(2));
		assertEquals("World", list.get(3));
		assertEquals("End", list.get(4));
		assertEquals("Student End", list.get(5));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	
	@Test
	public void testIteratorSuccessfulSTUDENT(){
		//test the iterator for the linkedDouble
		//be throughal, use the preceeding test method as an example
		linkedString.addToFront("Student Begin");
		linkedString.addToEnd("Student End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Student Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
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
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("End", iterator.next());
		assertEquals(false, iterator.hasNext());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("End", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
		assertEquals("Begin", iterator.previous());
		try{
			//no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionSTUDENT(){
		//test the iterator for the linkedDouble.  Exception raised
		//when next is called after last element.
		//be throughal, use the preceeding test method as an example
		linkedString.addToFront("Student Begin");
		linkedString.addToEnd("Student End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Student Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Student End", iterator.next());
		assertEquals(false, iterator.hasNext());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Student End", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
		assertEquals("Student Begin", iterator.previous());
		try{
			//no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
		
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
	public void testIteratorUnsupportedOperationExceptionSTUDENT(){
		//test the remove method for the iterator for the linkedDouble
		//be throughal, use the preceeding test method as an example
		linkedString.addToFront("Student Begin");
		linkedString.addToEnd("Student End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Student Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Student End", iterator.next());
		
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
	public void testRemove() {
		// remove the first
		assertEquals("Hello", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		linkedString.remove("New", comparator);
		assertEquals("Hello", linkedString.getFirst());
		//remove from the end of the list
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
		linkedString.remove("End", comparator);
		assertEquals("World", linkedString.getLast());
		//remove from middle of list
		linkedString.addToFront("Begin");
		assertEquals("Begin", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		linkedString.remove("Hello", comparator);
		assertEquals("Begin", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		
	}
	
	@Test
	public void testRemoveSTUDENT(){
		//test the remove method for the linkedDouble
		//be throughal, remove from the front of the list, the
		//end of the list and the middle of the list, 
		//use the preceeding test method as an example
		assertEquals("Hello", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		linkedString.addToFront("Student New");
		assertEquals("Student New", linkedString.getFirst());
		linkedString.remove("Student New", comparator);
		assertEquals("Hello", linkedString.getFirst());
		//remove from the end of the list
		linkedString.addToEnd("Student End");
		assertEquals("Student End", linkedString.getLast());
		linkedString.remove("Student End", comparator);
		assertEquals("World", linkedString.getLast());
		//remove from middle of list
		linkedString.addToFront("Student Begin");
		assertEquals("Student Begin", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		linkedString.remove("Hello", comparator);
		assertEquals("Student Begin", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		assertEquals("New", linkedString.retrieveFirstElement());
		assertEquals("Hello",linkedString.getFirst());
		assertEquals("Hello", linkedString.retrieveFirstElement());
		assertEquals("World",linkedString.getFirst());
		
	}
	
	@Test
	public void testRetrieveFirstElementSTUDENT(){
		//test retrieveLastElement for linkedDouble
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("Student New");
		assertEquals("Student New", linkedString.getFirst());
		assertEquals("Student New", linkedString.retrieveFirstElement());
		assertEquals("Hello",linkedString.getFirst());
		assertEquals("Hello", linkedString.retrieveFirstElement());
		assertEquals("World",linkedString.getFirst());
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		assertEquals("New", linkedString.retrieveLastElement());
		assertEquals("World",linkedString.getLast());
	}
	
	@Test
	public void testRetrieveLastElementSTUDENT(){
		//test retrieveLastElement for linkedDouble
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("Student New");
		assertEquals("Student New", linkedString.getLast());
		assertEquals("Student New", linkedString.retrieveLastElement());
		assertEquals("World",linkedString.getLast());
		assertEquals("World", linkedString.retrieveLastElement());
		assertEquals("Hello",linkedString.getLast());
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
