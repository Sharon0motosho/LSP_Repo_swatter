package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * IntegerSet models a mathematical set of integers (no duplicates).
 */
public class IntegerSet {
    private ArrayList<Integer> set = new ArrayList<>();

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if two sets are equal (same elements, order doesn't matter).
     */
    public boolean equals(IntegerSet b) {
        if (b == null) return false;
        if (this.length() != b.length()) return false;

        for (int item : set) {
            if (!b.contains(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the set contains the given value.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     * Throws RuntimeException if set is empty.
     */
    public int largest() {
        if (isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest value in the set.
     * Throws RuntimeException if set is empty.
     */
    public int smallest() {
        if (isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set (no duplicates allowed).
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns the union of two sets.
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        result.set.addAll(this.set);

        for (int item : intSetb.set) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Returns the intersection of two sets.
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : this.set) {
            if (intSetb.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Returns the difference (this - b).
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : this.set) {
            if (!intSetb.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Returns the complement (b - this).
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : intSetb.set) {
            if (!this.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Returns true if the set is empty.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}