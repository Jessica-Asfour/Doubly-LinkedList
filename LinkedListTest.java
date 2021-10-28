import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void testToString() {
        LinkedList list = new LinkedList();

        // Test 0
        assertEquals(list.toString(), "{}");

        // Test 1
        list.addLast(0);
        assertEquals(list.toString(), "{0}");

        // Test 2
        list.addLast(1);
        assertEquals(list.toString(), "{0, 1}");

        // Test 3
        list.addLast(2);
        assertEquals(list.toString(), "{0, 1, 2}");
    }

    @Test
    void addLast() {

        LinkedList list = new LinkedList();
        // Test 0
        assertEquals(list.head, null);
        assertEquals(list.tail, null);

        // Test 1
        list.addLast(0);

        assertEquals(list.head.data, 0);
        assertEquals(list.head.next, null);
        assertEquals(list.head.previous, null);
        assertEquals(list.tail.data, 0);
        assertEquals(list.tail.next, null);
        assertEquals(list.tail.previous, null);


        // Test 2
        list.addLast(1);
        assertEquals(list.head.data, 0);
        assertEquals(list.head.next, list.tail);
        assertEquals(list.head.previous, null);
        assertEquals(list.tail.data, 1);
        assertEquals(list.tail.next, null);
        assertEquals(list.tail.previous, list.head);

        // Test 3
        list.addLast(2);
        LinkedList.Node middleNode = list.head.next;
        assertEquals(list.head.data, 0);
        assertEquals(list.head.next, middleNode);
        assertEquals(list.head.previous, null);
        assertEquals(middleNode.data, 1);
        assertEquals(middleNode.previous, list.head);
        assertEquals(middleNode.next, list.tail);
        assertEquals(list.tail.data, 2);
        assertEquals(list.tail.next, null);
        assertEquals(list.tail.previous, middleNode);

    }

    @Test
    void removeLast(){
        LinkedList list = new LinkedList();

        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        // Test 0
        list.removeLast();
        LinkedList.Node middleNode = list.head.next;
        assertEquals(list.head.data, 0);
        assertEquals(list.head.next, middleNode);
        assertEquals(list.head.previous, null);
        assertEquals(middleNode.data, 1);
        assertEquals(middleNode.previous, list.head);
        assertEquals(middleNode.next, list.tail);
        assertEquals(list.tail.data, 2);
        assertEquals(list.tail.next, null);
        assertEquals(list.tail.previous, middleNode);

        // Test 1
        list.removeLast();
        assertEquals(list.head.data, 0);
        assertEquals(list.head.next, list.tail);
        assertEquals(list.head.previous, null);
        assertEquals(list.tail.data, 1);
        assertEquals(list.tail.next, null);
        assertEquals(list.tail.previous, list.head);

        // Test 2
        list.removeLast();
        assertEquals(list.head.data, 0);
        assertEquals(list.head.previous, null);
        assertEquals(list.head.next, null);
        assertEquals(list.tail.data, 0);
        assertEquals(list.tail.previous, null);
        assertEquals(list.tail.next, null);

        // Test 3
        list.removeLast();
        assertEquals(list.head, null);
        assertEquals(list.tail, null);

    }
    @Test
    void addFirst(){
        LinkedList list = new LinkedList();

        // Test 0
        assertEquals(list.head, null);
        assertEquals(list.tail, null);

        // Test 1
        list.addFirst(2);
        assertEquals(list.head.data, 2);
        assertEquals(list.head.next, null);
        assertEquals(list.head.previous, null);
        assertEquals(list.tail.data, 2);
        assertEquals(list.tail.next, null);
        assertEquals(list.tail.previous, null);

        // Test 2
        list.addFirst(1);
        assertEquals(list.head.data, 1);
        assertEquals(list.head.next, list.tail);
        assertEquals(list.head.previous, null);
        assertEquals(list.tail.data, 2);
        assertEquals(list.tail.next, null);
        assertEquals(list.tail.previous, list.head);

        list.addFirst(0);
        LinkedList.Node middleNode = list.head.next;
        assertEquals(list.head.data, 0);
        assertEquals(list.head.next, middleNode);
        assertEquals(list.head.previous, null);
        assertEquals(middleNode.data, 1);
        assertEquals(middleNode.previous, list.head);
        assertEquals(middleNode.next, list.tail);
        assertEquals(list.tail.data, 2);
        assertEquals(list.tail.next, null);
        assertEquals(list.tail.previous, middleNode);
    }

    @Test
    void removeFirst(){
        LinkedList list = new LinkedList();

        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.removeFirst();
        LinkedList.Node middleNode = list.head.next;
        assertEquals(list.head.data, 1);
        assertEquals(list.head.next, middleNode);
        assertEquals(list.head.previous, null);
        assertEquals(middleNode.data, 2);
        assertEquals(middleNode.previous, list.head);
        assertEquals(middleNode.next, list.tail);
        assertEquals(list.tail.data, 3);
        assertEquals(list.tail.next, null);
        assertEquals(list.tail.previous, middleNode);

        // Test 1
        list.removeFirst();
        assertEquals(list.head.data, 2);
        assertEquals(list.head.next, list.tail);
        assertEquals(list.head.previous, null);
        assertEquals(list.tail.data, 3);
        assertEquals(list.tail.next, null);
        assertEquals(list.tail.previous, list.head);

        // Test 2
        list.removeFirst();
        assertEquals(list.head.data, 3);
        assertEquals(list.head.previous, null);
        assertEquals(list.head.next, null);
        assertEquals(list.tail.data, 3);
        assertEquals(list.tail.previous, null);
        assertEquals(list.tail.next, null);

        // Test 3
        list.removeFirst();
        assertEquals(list.head, null);
        assertEquals(list.tail, null);
    }

    @Test
    void size(){
        LinkedList list = new LinkedList();

        // Test 0
        assertEquals(list.size(), 0);

        // Test 1
        list.addLast(0);
        assertEquals(list.size(), 1);

        // Test 2
        list.addLast(1);
        assertEquals(list.size(), 2);

        // Test 3
        list.addLast(2);
        assertEquals(list.size(), 3);
    }

    @Test
    void getAt() {
        LinkedList list = new LinkedList();

        // Test 0
        assertThrows(IndexOutOfBoundsException.class, () -> { list.getAt(10); });


        // Test 1
        list.addLast(10);
        assertEquals(list.getAt(0), 10);

        // Test 2
        list.addLast(20);
        assertEquals(list.getAt(0), 10);
        assertEquals(list.getAt(1), 20);


        // Test 3
       assertThrows(IndexOutOfBoundsException.class, () -> { list.getAt(3); });

        // Test 4
        assertThrows(IndexOutOfBoundsException.class, () -> { list.getAt(-1); });
    }

    @Test
    void updateAt(){
        LinkedList list = new LinkedList();

        // Test 0
        assertThrows(IndexOutOfBoundsException.class, () -> { list.updateAt(0, 0); });

        // Test 1
        list.addLast(10);
        list.updateAt(0, 11);
        assertEquals(list.head.data, 11);
        assertEquals(list.tail.data, 11);
    }

    @Test
    void insertAt(){
        LinkedList list = new LinkedList();

        // Test 0 to check when the list is empty
        assertThrows(IndexOutOfBoundsException.class, () -> { list.insertAt(2, 0); });

        // Test 1 inserting at index 0
        list.insertAt(0, 10);
        assertEquals(list.head.data, 10);
        assertEquals(list.tail.data, 10);

        // Test 2
        list.insertAt(1, 12);
        assertEquals(list.head.data, 10);
        assertEquals(list.tail.data, 12);


    }

    @Test
    void removeAt(){
        LinkedList list = new LinkedList();

        // Test 0 to check when the list is empty
        assertThrows(IndexOutOfBoundsException.class, () -> { list.removeAt(2); });

        // Test 1 with 0 element
        list.addLast(4);
        list.removeAt(0);
        assertEquals(list.head, null);
        assertEquals(list.tail, null);

        // Test 2 with 1 element
        list.addLast(5);
        list.addLast(6);
        list.removeAt(0);
        assertEquals(list.head.data, 6);
        assertEquals(list.tail.data, 6);
        assertEquals(list.head.next, null);
        assertEquals(list.head.previous, null);
        assertEquals(list.tail.next, null);
        assertEquals(list.tail.previous, null);
        assertEquals(list.tail, list.head);

        // Test 3 with 2 elements remove at head
        list.addLast(7);
        list.addLast(8);
        list.removeAt(0);
        assertEquals(list.head.data, 7);
        assertEquals(list.tail.data, 8);
        assertEquals(list.head.previous, null);
        assertEquals(list.head.next, list.tail);
        assertEquals(list.tail.previous, list.head);
        assertEquals(list.tail.next, null);


        // Test 4 with 2 elements remove at 1
        list.addLast(9);
        list.removeAt(1);
        assertEquals(list.head.data, 7);
        assertEquals(list.tail.data, 9);
        assertEquals(list.head.previous, null);
        assertEquals(list.head.next, list.tail);
        assertEquals(list.tail.previous, list.head);
        assertEquals(list.tail.next, null);

        // Test 5 with 2 elements remove at tail
        list.addLast(10);
        list.removeAt(2);
        assertEquals(list.head.data, 7);
        assertEquals(list.tail.data, 9);
        assertEquals(list.head.previous, null);
        assertEquals(list.head.next, list.tail);
        assertEquals(list.tail.previous, list.head);
        assertEquals(list.tail.next, null);

    }

}