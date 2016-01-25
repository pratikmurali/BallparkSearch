package com.pratik;

/**
 * Class for Range or Exact Search
 *
 */
public class SearchUtility {

    /**
     * Method to search based on different search criteria.
     * @param items
     * @param ascending
     * @param key
     * @param type
     * @return
     */
    public static SearchIndexAndType search(int[] items, boolean ascending, int key, SearchType type) {

        int size = items.length;
        int count = 0;
        boolean found = false;
        SearchIndexAndType searchNotFound = new SearchIndexAndType(SearchResult.NotFound, -9999);

        // Key is not in range when array in ascending order.
        if ((ascending) && (key < items[0] || key > items[size - 1])) {
            return searchNotFound;
        }

        // Key is not in range when array in descending order.
        if ((!ascending) && (key > items[0] || key < items[size - 1])) {
            return searchNotFound;
        }

        // Also not in range (lesser) when array in ascending order.
        if ((ascending) && (key == items[0] && type.equals(SearchType.LessThan))) {
            return searchNotFound;
        }

        // Also not in range (greater) ascending order.
        if ((ascending) && (key == items[size - 1] && type.equals(SearchType.GreaterThan))) {
            return searchNotFound;
        }

        // Also not in range (lesser) when array in descending order.
        if ((!ascending) && (key == items[size - 1] && type.equals(SearchType.LessThan))) {
            return searchNotFound;
        }

        // Also not in range (greater) when array in descending order.
        if ((!ascending) && (key == items[0] && type.equals(SearchType.GreaterThan))) {
            return searchNotFound;
        }

        // Linear Search
        if (ascending) {
            while (count < size && items[count] <= key) {
                if (items[count] == key) {
                    found = true;
                    break;
                }
                count++;
            }
        } else {
            while (count < size && items[count] >= key) {
                if (items[count] == key) {
                    found = true;
                    break;
                }
                count++;
            }
        }

        // Switch on the type and return
        switch (type) {

            case LessThan:
                return (found) ? new SearchIndexAndType(SearchResult.FoundLess, (ascending) ? count - 1 : count + 1)
                    : searchNotFound;
            case LessThanEquals:
                return (found) ? new SearchIndexAndType(SearchResult.FoundExact, count)
                    : new SearchIndexAndType(SearchResult.FoundLess, (ascending) ? count - 1 : count + 1);
            case Equals:
                return (found) ? new SearchIndexAndType(SearchResult.FoundExact, count) : searchNotFound;
            case GreaterThan:
                return (found) ? new SearchIndexAndType(SearchResult.FoundGreater, (ascending) ? count + 1 : count - 1)
                    : searchNotFound;
            case GreaterThanEquals:
                return (found) ? new SearchIndexAndType(SearchResult.FoundExact, count)
                    : new SearchIndexAndType(SearchResult.FoundGreater, (ascending) ? count + 1 : count - 1);
            default:
                return searchNotFound;

        }

    }

    /**
     * Driver program to test supplied inputs.
     */
    public static void main(String[] args) {

        int a1[] = { 0, 2, 4, 6, 8 };
        int a2[] = { 8, 6, 4, 2, 0 };

        //TESTCASE 1
        
        System.out.println("\n-----------------ASCENDING----------------------------\n");
        
        SearchIndexAndType res0 = search(a1, true, -1, SearchType.LessThanEquals);
        System.out.println(res0);

        SearchIndexAndType res1 = search(a1, true, 0, SearchType.LessThan);
        System.out.println(res1);

        SearchIndexAndType res2 = search(a1, true, 0, SearchType.Equals);
        System.out.println(res2);

        SearchIndexAndType res3 = search(a1, true, 1, SearchType.Equals);
        System.out.println(res3);

        SearchIndexAndType res4 = search(a1, true, 2, SearchType.GreaterThanEquals);
        System.out.println(res4);

        SearchIndexAndType res5 = search(a1, true, 2, SearchType.GreaterThan);
        System.out.println(res5);

        System.out.println("\n-----------------DESCENDING----------------------------\n");

        //TESTCASE 2
        SearchIndexAndType res00 = search(a2, false, -1, SearchType.LessThan);
        System.out.println(res00);

        SearchIndexAndType res11 = search(a2, false, 4, SearchType.LessThanEquals);
        System.out.println(res11);

        SearchIndexAndType res22 = search(a2, false, 8, SearchType.Equals);
        System.out.println(res22);

        SearchIndexAndType res33 = search(a2, false, 5, SearchType.GreaterThanEquals);
        System.out.println(res33);

        SearchIndexAndType res44 = search(a2, false, 2, SearchType.GreaterThanEquals);
        System.out.println(res44);

        SearchIndexAndType res55 = search(a2, false, 9, SearchType.GreaterThan);
        System.out.println(res55);

    }
}
