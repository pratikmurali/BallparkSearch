# BallparkSearch

BallParkSearch is a java program which searches for exact matches as well as matches greater than or lesser than equal to a given key 
within a closed range of inputs [1...n]. 

 The method Signature (SearchUtility.java) is 
 SearchIndexAndType search(int[] items, boolean ascending, int key, SearchType type)
 where:

      int[]items: Is the array of integers in some range. Provided in ascending or descending order.
      ascending: Is a flag when true indicates that the input is in ascending order and vice versa.
      key: is the integer key which is being looked for based on a given search criteria.
      SearchType: Is an enum which specifies the search criteria.
    
      SearchIndexAndType: Is a return type which encapsulates the Index and SearchResult.

Assumptions
-----------
  The items are sorted
  Items will be non-NULL
  There are no duplicate items
  number of items will be > 0

A SearchType would be one of the following categories

    LessThan = 0,
    LessThanEquals = 1,
    Equals = 2,
    GreaterThanEquals = 3,
    GreaterThan = 4

A SearchResult would be one of the following categories

    NotFound,
    FoundExact,
    FoundGreater,
    FoundLess

Search Criteria
---------------

 LessThan
 --------
 Finds the largest item which is less than the key.
 It returns FoundLess if a match is found, NotFound
 if no match is found.
 
 LessThanEquals
 --------------
 Finds the item which is equal to the key, or the
 largest item which is less than the key. Returns
 FoundExact if an item that exactly matches the key
 is found, FoundLess if a non-exact match is found
 and NotFound if no match is found.

 Equals
 ------
 Finds an item which is equal to the key. Returns
 FoundExact if an item if found, NotFound otherwise.

 GreaterThanEquals
 -----------------
 Finds the item which is equal to the key, or the
  smallest item which is greater than the key. Returns
  FoundExact if an item that exactly matches the key
  is found, FoundGreater if a non-exact match is found
  and NotFound if no match is found.

 GreaterThan
 -----------
  Finds the smallest item which is greater than the
  key. Returns FoundGreater if a match if found, NotFound
  if no match is found.

Getting and Compiling the Code
-------------------------------
    Click Download Zip to download the source code and extract it to any directory on your computer.
    Run mvn compile and mvn package to build and package the solution.
    This is an eclipse project, so you should be able to import the source code and the tests into eclipse.
    Run mvn eclipse:eclipse and try importing the eclipse project again (in case you have any trouble importing into eclipse).

