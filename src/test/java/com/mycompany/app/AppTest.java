package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    private static ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(5, 1, 8));
    private static ArrayList<Integer> arrayList2 = new ArrayList<Integer>(Arrays.asList(5));
    private static Integer[] array = new Integer[]{9, 4, 1};
    private static Integer[] array2 = new Integer[]{9, 4};
    private static Integer[] array3 = new Integer[]{9};

    public void testWhenDivideIsFalseShouldNotDivideAndSumTheseTwoArrays() {
        assertEquals(new App().method(arrayList, array, false, "sum"), "14,5,9");
    }

    public void testWhenDivideIsFalseShouldNotDivideAndDivisionTheseTwoArrays() {
        assertEquals(new App().method(arrayList, array, false, "divide"), "0,0,8");
    }

    public void testWhenDivideIsFalseShouldNotDivideAndMultiplyTheseTwoArrays() {
        assertEquals(new App().method(arrayList, array, false, "multiply"), "45,4,8");
    }

    public void testWhenDivideIsFalseShouldNotDivideAndSubtractionTheseTwoArrays() {
        assertEquals(new App().method(arrayList, array, false, "subtract"), "-4,-3,7");
    }

    public void testWhenDivideIsTrueShouldNotDivideAndSumTheseTwoArrays() {
        assertEquals(new App().method(arrayList, array, true, "sum"), "14");
    }

    public void testWhenDivideIsTrueShouldNotDivideAndSubtractTheseTwoArrays() {
        assertEquals(new App().method(arrayList, array, true, "subtract"), "-4");
    }

    public void testWhenDivideIsTrueShouldNotDivideAndMultiplyTheseTwoArrays() {
        assertEquals(new App().method(arrayList, array, true, "multiply"), "45");
    }

    public void testWhenDivideIsTrueShouldNotDivideAndDivisionTheseTwoArrays() {
        assertEquals(new App().method(arrayList, array, true, "divide"), "0");
    }

    public void testWhenDivideIsTrueShouldNotDivideAndDivisionTheseTwoArraysToCheckWhichArrayHasLessSize() {
        assertEquals(new App().method(arrayList, array2, false, "divide"), "0,0");
    }

    public void testEmptyArray() {
        ArrayList<Integer> emptyArray = new ArrayList<>();
        assertEquals(new App().method(emptyArray, array, true, "divide"), "Arrays can not be null or empty.");
    }

    public void testNull() {
        assertEquals(new App().method(null, null, true, "sum"), "Arrays can not be null or empty.");
    }

    public void testInvalidOperation() {
        assertEquals(new App().method(arrayList, array, false, "test"), "There is a mistake in operation definition");
    }

    public void test1ElementArraysToDivide() {
        assertEquals(new App().method(arrayList2, array3, true, "sum"), "Arrays can not be null or empty.");

    }

}
