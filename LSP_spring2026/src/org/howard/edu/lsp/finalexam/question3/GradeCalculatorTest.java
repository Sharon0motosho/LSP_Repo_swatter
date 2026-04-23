package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {

    GradeCalculator gc = new GradeCalculator();

    // 1. Test average()
    @Test
    void testAverage() {
        assertEquals(80.0, gc.average(70, 80, 90));
    }

    // 2. Test letterGrade()
    @Test
    void testLetterGrade() {
        assertEquals("A", gc.letterGrade(95));
    }

    // 3. Test isPassing()
    @Test
    void testIsPassing() {
        assertTrue(gc.isPassing(65));
    }

    // 4. Boundary tests
    @Test
    void testBoundaryA() {
        assertEquals("A", gc.letterGrade(90));
    }

    @Test
    void testBoundaryFail() {
        assertFalse(gc.isPassing(59.9));
    }

    // 5. Exception tests
    @Test
    void testInvalidLowScore() {
        assertThrows(IllegalArgumentException.class, () -> {
            gc.average(-1, 50, 60);
        });
    }

    @Test
    void testInvalidHighScore() {
        assertThrows(IllegalArgumentException.class, () -> {
            gc.average(50, 101, 60);
        });
    }
}