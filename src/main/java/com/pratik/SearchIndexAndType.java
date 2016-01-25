/**
 * Class to encapsulate the SearchResult and Index of the return key.
 */
package com.pratik;

/**
 * @author pratikm
 *
 */
public class SearchIndexAndType {

    private SearchResult result;
    private int index;

    public SearchIndexAndType(SearchResult result, int index) {
        super();
        this.result = result;
        this.index = index;
    }
    
    /**
     * @return the result
     */
    public SearchResult getResult() {
        return result;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SearchIndexAndType [result=");
        builder.append(result);
        builder.append(", index=");
        builder.append(index);
        builder.append("]");
        return builder.toString();
    }

}
