package com.pratik;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests for Search Utility.
 * This utility Tests Boundary conditions and Legit use cases for the Search Utility.
 * Assumptions (not tested)
 * The arrays are always sorted in Ascending/Descending order
 * There are no duplicates in the input.
 * The array is not of size 0.
 */
public class SearchUtilityTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SearchUtilityTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SearchUtilityTest.class);
    }

    //Test cases for Boundary Conditions

    @org.junit.Test
    public void testAscendingOutOfRangeMiniumWithSearchTypeEquals() {
        int a[] = { 0, 2, 4, 6, 8 };
        int key = -5;
        SearchIndexAndType sit = SearchUtility.search(a, true, key, SearchType.Equals);
        assertEquals(-9999, sit.getIndex());
        assertEquals(SearchResult.NotFound, sit.getResult());
    }

    @org.junit.Test
    public void testAscendingOutOfRangeMore() {
        int a[] = { 0, 2, 4, 6, 8 };
        int key = 25;
        SearchIndexAndType sit = SearchUtility.search(a, true, key, SearchType.Equals);
        assertEquals(-9999, sit.getIndex());
        assertEquals(SearchResult.NotFound, sit.getResult());

    }

    @org.junit.Test
    public void testDescendingOutOfRangeLess() {
        int a[] = { 8, 6, 4, 2, 0 };
        int key = 10;
        SearchIndexAndType sit = SearchUtility.search(a, true, key, SearchType.Equals);
        assertEquals(-9999, sit.getIndex());
        assertEquals(SearchResult.NotFound, sit.getResult());

    }

    @org.junit.Test
    public void testDescendingOutOfRangeMore() {
        int a[] = { 8, 6, 4, 2, 0 };
        int key = -1;
        SearchIndexAndType sit = SearchUtility.search(a, true, key, SearchType.Equals);
        assertEquals(-9999, sit.getIndex());
        assertEquals(SearchResult.NotFound, sit.getResult());

    }

    //Test Cases for legitimate inputs in Ascending order.

    /*  
     Given input array [0, 2, 4, 6, 8] (ascending order)
      | Key | Type              | Returns      | Index |
      | -1  | LessThanEquals    | NotFound     | X     |
      |  0  | LessThan          | NotFound     | X     |
      |  0  | Equals            | FoundExact   | 0     |
      |  1  | Equals            | NotFound     | X     |
      |  2  | GreaterThanEquals | FoundExact   | 1     |
      |  2  | GreaterThan       | FoundGreater | 2     |
    */

    @org.junit.Test
    public void testLessThanEqualsAscending() {
        int a[] = { 0, 2, 4, 6, 8 };
        int key = -1;
        SearchIndexAndType sit = SearchUtility.search(a, true, key, SearchType.LessThanEquals);
        assertEquals(-9999, sit.getIndex());
        assertEquals(SearchResult.NotFound, sit.getResult());
    }

    @org.junit.Test
    public void testLessThanAscending() {
        int a[] = { 0, 2, 4, 6, 8 };
        int key = 0;
        SearchIndexAndType sit = SearchUtility.search(a, true, key, SearchType.LessThan);
        assertEquals(-9999, sit.getIndex());
        assertEquals(SearchResult.NotFound, sit.getResult());
    }

    @org.junit.Test
    public void testEqualsAscendingWhereKeyIsFound() {
        int a[] = { 0, 2, 4, 6, 8 };
        int key = 0;
        SearchIndexAndType sit = SearchUtility.search(a, true, key, SearchType.Equals);
        assertEquals(0, sit.getIndex());
        assertEquals(SearchResult.FoundExact, sit.getResult());
    }

    @org.junit.Test
    public void testEqualsAscendingWhereKeyIsNotFound() {
        int a[] = { 0, 2, 4, 6, 8 };
        int key = 1;
        SearchIndexAndType sit = SearchUtility.search(a, true, key, SearchType.Equals);
        assertEquals(-9999, sit.getIndex());
        assertEquals(SearchResult.NotFound, sit.getResult());
    }

    @org.junit.Test
    public void testGreaterThanEqualsAscending() {
        int a[] = { 0, 2, 4, 6, 8 };
        int key = 2;
        SearchIndexAndType sit = SearchUtility.search(a, true, key, SearchType.GreaterThanEquals);
        assertEquals(1, sit.getIndex());
        assertEquals(SearchResult.FoundExact, sit.getResult());
    }

    @org.junit.Test
    public void testGreaterThanAscending() {
        int a[] = { 0, 2, 4, 6, 8 };
        int key = 2;
        SearchIndexAndType sit = SearchUtility.search(a, true, key, SearchType.GreaterThan);
        assertEquals(2, sit.getIndex());
        assertEquals(SearchResult.FoundGreater, sit.getResult());
    }

    //TestCases for Legitimate Inputs when the array is in Descending Order

    /*  Given the input array [8, 6, 4, 2, 0] (descending order)
    *  | Key | Type              | Returns      | Index |
    *  | -1  | LessThan          | NotFound     | X     |
    *  |  4  | LessThanEquals    | FoundExact   | 2     |
    *  |  8  | Equals            | FoundExact   | 0     |
    *  |  5  | GreaterThanEquals | FoundGreater | 1     |
    *  |  2  | GreaterThanEquals | FoundExact   | 3     |
    *  |  9  | GreaterThan       | NotFound     | X     |
    */

    @org.junit.Test
    public void testLessThanDescending() {
        int a[] = { 8, 6, 4, 2, 0 };
        int key = -1;
        SearchIndexAndType sit = SearchUtility.search(a, false, key, SearchType.LessThan);
        assertEquals(-9999, sit.getIndex());
        assertEquals(SearchResult.NotFound, sit.getResult());
    }

    @org.junit.Test
    public void testLessThanEqualsDescending() {
        int a[] = { 8, 6, 4, 2, 0 };
        int key = 4;
        SearchIndexAndType sit = SearchUtility.search(a, false, key, SearchType.LessThanEquals);
        assertEquals(2, sit.getIndex());
        assertEquals(SearchResult.FoundExact, sit.getResult());
    }

    @org.junit.Test
    public void testEqualsDescending() {
        int a[] = { 8, 6, 4, 2, 0 };
        int key = 8;
        SearchIndexAndType sit = SearchUtility.search(a, false, key, SearchType.Equals);
        assertEquals(0, sit.getIndex());
        assertEquals(SearchResult.FoundExact, sit.getResult());
    }

    @org.junit.Test
    public void testGreaterThanEqualsDescendingWhereFoundGreater() {
        int a[] = { 8, 6, 4, 2, 0 };
        int key = 5;
        SearchIndexAndType sit = SearchUtility.search(a, false, key, SearchType.GreaterThanEquals);
        assertEquals(1, sit.getIndex());
        assertEquals(SearchResult.FoundGreater, sit.getResult());
    }

    @org.junit.Test
    public void testGreaterThanEqualsDescendingWhereFoundExact() {
        int a[] = { 8, 6, 4, 2, 0 };
        int key = 2;
        SearchIndexAndType sit = SearchUtility.search(a, false, key, SearchType.GreaterThanEquals);
        assertEquals(3, sit.getIndex());
        assertEquals(SearchResult.FoundExact, sit.getResult());
    }

    @org.junit.Test
    public void testGreaterThanDescendingWhereNotFound() {
        int a[] = { 0, 2, 4, 6, 8 };
        int key = 9;
        SearchIndexAndType sit = SearchUtility.search(a, false, key, SearchType.GreaterThan);
        assertEquals(-9999, sit.getIndex());
        assertEquals(SearchResult.NotFound, sit.getResult());
    }

}
