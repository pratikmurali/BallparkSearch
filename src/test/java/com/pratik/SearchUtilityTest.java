package com.pratik;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
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
        int a[] = {8, 6, 4, 2, 0};
        int key = 10;
        SearchIndexAndType sit = SearchUtility.search(a, true, key, SearchType.Equals);
        assertEquals(-9999, sit.getIndex());
        assertEquals(SearchResult.NotFound, sit.getResult());

    }

    @org.junit.Test
    public void testDescendingOutOfRangeMore() {
        int a[] = {8, 6, 4, 2, 0};
        int key = -1;
        SearchIndexAndType sit = SearchUtility.search(a, true, key, SearchType.Equals);
        assertEquals(-9999, sit.getIndex());
        assertEquals(SearchResult.NotFound, sit.getResult());

    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}
