package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

    // clear(): normal + edge
    @Test
    void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.clear();
        assertTrue(set.isEmpty()); // normal

        set.clear(); // edge: already empty
        assertTrue(set.isEmpty());
    }

    // length(): normal + edge
    @Test
    void testLength() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length()); // edge

        set.add(1);
        set.add(2);
        assertEquals(2, set.length()); // normal
    }

    // equals(): order + mismatch
    @Test
    void testEquals() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(2);
        set2.add(1);

        assertTrue(set1.equals(set2)); // edge: different order

        set2.add(3);
        assertFalse(set1.equals(set2)); // mismatch
    }

    // contains(): present + absent
    @Test
    void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(5);

        assertTrue(set.contains(5)); // present
        assertFalse(set.contains(10)); // absent
    }

    // largest(): normal + exception
    @Test
    void testLargest() {
        IntegerSet set = new IntegerSet();
        set.add(10);

        assertEquals(10, set.largest()); // normal (single element)

        IntegerSet empty = new IntegerSet();
        assertThrows(RuntimeException.class, empty::largest); // edge
    }

    // smallest(): normal + exception
    @Test
    void testSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(7);

        assertEquals(7, set.smallest()); // normal (single element)

        IntegerSet empty = new IntegerSet();
        assertThrows(RuntimeException.class, empty::smallest); // edge
    }

    // add(): normal + duplicate
    @Test
    void testAdd() {
        IntegerSet set = new IntegerSet();

        set.add(1);
        assertTrue(set.contains(1)); // normal

        set.add(1); // duplicate
        assertEquals(1, set.length()); // edge
    }

    // remove(): normal + missing
    @Test
    void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(1);

        set.remove(1);
        assertFalse(set.contains(1)); // normal

        set.remove(5); // edge: not present
        assertEquals(0, set.length());
    }

    // union(): normal + empty
    @Test
    void testUnion() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set2.add(2);

        set1 = set1.union(set2);
        assertTrue(set1.contains(2)); // normal

        IntegerSet empty = new IntegerSet();
        set1 = set1.union(empty);
        assertTrue(set1.contains(1)); // edge
    }

    // intersect(): normal + no overlap
    @Test
    void testIntersect() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set2.add(2);

        set1 = set1.intersect(set2);
        assertTrue(set1.contains(2)); // normal
        assertFalse(set1.contains(1));

        IntegerSet set3 = new IntegerSet();
        set3.add(10);

        set1 = set1.intersect(set3);
        assertTrue(set1.isEmpty()); // edge: no overlap
    }

    // diff(): normal + identical
    @Test
    void testDiff() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set2.add(2);

        set1 = set1.diff(set2);
        assertTrue(set1.contains(1)); // normal
        assertFalse(set1.contains(2));

        IntegerSet set3 = new IntegerSet();
        set3.add(1);

        set1 = set1.diff(set3);
        assertTrue(set1.isEmpty()); // edge: identical
    }

    // complement(): normal + disjoint
    @Test
    void testComplement() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set2.add(2);

        set1 = set1.complement(set2);
        assertTrue(set1.contains(2)); // normal

        IntegerSet set3 = new IntegerSet();
        set3.add(10);

        set1 = set1.complement(set3);
        assertTrue(set1.contains(10)); // edge: disjoint
    }

    // isEmpty(): empty + non-empty
    @Test
    void testIsEmpty() {
        IntegerSet set = new IntegerSet();

        assertTrue(set.isEmpty()); // empty

        set.add(1);
        assertFalse(set.isEmpty()); // non-empty
    }

    // toString(): normal + empty
    @Test
    void testToString() {
        IntegerSet set = new IntegerSet();

        assertEquals("[]", set.toString()); // edge

        set.add(2);
        set.add(1);

        assertEquals("[1, 2]", set.toString()); // normal 
    }
}