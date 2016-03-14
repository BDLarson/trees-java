package edu.hawaii.ics211.uhCollection;

import org.junit.Test;

public class UhSingleLinkedListTest {

  /**
   * Test AddFirst functionality.
   */
  @Test
  public void testAddFirst() {
    UhSingleLinkedList<String> list = new UhSingleLinkedList<String>();
    list.addFirst("Delta");

    org.junit.Assert.assertEquals("Delta", list.get(0));

    list.addFirst("Charlie");

    org.junit.Assert.assertEquals("Charlie", list.get(0));
    org.junit.Assert.assertEquals("Delta", list.get(1));

    list.addFirst("Bravo");

    org.junit.Assert.assertEquals("Bravo", list.get(0));
    org.junit.Assert.assertEquals("Charlie", list.get(1));
    org.junit.Assert.assertEquals("Delta", list.get(2));

    list.addFirst("Alpha");

    org.junit.Assert.assertEquals("Alpha", list.get(0));
    org.junit.Assert.assertEquals("Bravo", list.get(1));
    org.junit.Assert.assertEquals("Charlie", list.get(2));
    org.junit.Assert.assertEquals("Delta", list.get(3));
  }

  /**
   * Test AddAfter functionality.
   */
  @Test
  public void testAddAfter() {
      UhSingleLinkedList<String> list2 = new UhSingleLinkedList<String>();
	  list2.addFirst("Alpha");
	  
	  org.junit.Assert.assertEquals("Alpha", list2.get(0));
	  
	  list2.addAfter(list2.getNode(0), "Bravo");
	  
	  org.junit.Assert.assertEquals("Alpha", list2.get(0));
	  org.junit.Assert.assertEquals("Bravo", list2.get(1));
	  
	  list2.addAfter(list2.getNode(1), "Charlie");
	  
	  org.junit.Assert.assertEquals("Alpha", list2.get(0));
	  org.junit.Assert.assertEquals("Bravo", list2.get(1));
	  org.junit.Assert.assertEquals("Charlie", list2.get(2));
	  
	  list2.addAfter(list2.getNode(2), "Delta");
	  
	  org.junit.Assert.assertEquals("Alpha", list2.get(0));
	  org.junit.Assert.assertEquals("Bravo", list2.get(1));
	  org.junit.Assert.assertEquals("Charlie", list2.get(2));
	  org.junit.Assert.assertEquals("Delta", list2.get(3));
  }

  /**
   * Test both Remove functionalities.
   */
  @Test (expected = IndexOutOfBoundsException.class)
  public void testRemove() {
	  UhSingleLinkedList<String> list3 = new UhSingleLinkedList<String>();
	  list3.addFirst("Alpha");
	  list3.addAfter(list3.getNode(0), "Bravo");
	  list3.addAfter(list3.getNode(1), "Charlie");
	  list3.addAfter(list3.getNode(2), "Delta");
	  list3.removeAfter(list3.getNode(2));
	  
	  org.junit.Assert.assertEquals("Alpha", list3.get(0));
	  org.junit.Assert.assertEquals("Bravo", list3.get(1));
	  org.junit.Assert.assertEquals("Charlie", list3.get(2));
	  org.junit.Assert.assertEquals(null, list3.get(3));
	  
	  list3.removeAfter(list3.getNode(1));
	  
	  org.junit.Assert.assertEquals("Alpha", list3.get(0));
	  org.junit.Assert.assertEquals("Bravo", list3.get(1));
	  org.junit.Assert.assertEquals(null,  list3.get(2));
	  org.junit.Assert.assertEquals(null,  list3.get(3));

	  list3.removeAfter(list3.getNode(0));
	  
	  org.junit.Assert.assertEquals("Alpha", list3.get(0));
	  org.junit.Assert.assertEquals(null,  list3.get(1));
	  org.junit.Assert.assertEquals(null,  list3.get(2));
	  org.junit.Assert.assertEquals(null,  list3.get(3));
	  
	  list3.removeFirst();
	  org.junit.Assert.assertEquals(null,  list3.get(0));
	  org.junit.Assert.assertEquals(null,  list3.get(1));
	  org.junit.Assert.assertEquals(null,  list3.get(2));
	  org.junit.Assert.assertEquals(null,  list3.get(3));
	  
  }

  /**
   * Test Get functionality.
   */
  @Test (expected = IndexOutOfBoundsException.class)
  public void testGet() {
	  UhSingleLinkedList<String> list4 = new UhSingleLinkedList<String>();
	  list4.addFirst("Alpha");
	  
	  org.junit.Assert.assertEquals("Alpha", list4.get(0));
	  org.junit.Assert.assertEquals(null, list4.get(1));
	  
	  list4.addAfter(list4.getNode(0), "Bravo");
	  
	  org.junit.Assert.assertEquals("Alpha", list4.get(0));
	  org.junit.Assert.assertEquals("Bravo", list4.get(1));
	  org.junit.Assert.assertEquals(null, list4.get(2));
	  
	  list4.addAfter(list4.getNode(1), "Charlie");
	  
	  org.junit.Assert.assertEquals("Alpha", list4.get(0));
	  org.junit.Assert.assertEquals("Bravo", list4.get(1));
	  org.junit.Assert.assertEquals("Charlie", list4.get(2));
	  org.junit.Assert.assertEquals(null, list4.get(3));
	  
	  list4.addAfter(list4.getNode(2), "Delta");
	  
	  org.junit.Assert.assertEquals("Alpha", list4.get(0));
	  org.junit.Assert.assertEquals("Bravo", list4.get(1));
	  org.junit.Assert.assertEquals("Charlie", list4.get(2));
	  org.junit.Assert.assertEquals("Delta", list4.get(3));
	  org.junit.Assert.assertEquals(null, list4.get(4));


  }
}
