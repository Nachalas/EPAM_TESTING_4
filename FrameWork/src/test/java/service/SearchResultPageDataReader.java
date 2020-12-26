package service;

public class SearchResultPageDataReader {

    public static final String TESTDATA_SEARCHQUERY = "testdata.searchQuery";
    public static final String TESTDATA_MASK_SEARCHQUERY = "testdata.mask.searchQuery";
    public static final String TESTDATA_WRONG_SEARCHQUERY = "testdata.wrong.searchQuery";
    public static final String TESTDATA_SEARCHQUERY_PART ="testdata.searchQuery.part";

    public static String getSearchQuery(){
        return TestDataReader.getTestData(TESTDATA_SEARCHQUERY);
    }

    public static String getMaskSearchQuery(){
        return TestDataReader.getTestData(TESTDATA_MASK_SEARCHQUERY);
    }

    public static String getSearchQueryPart(){
        return TestDataReader.getTestData(TESTDATA_SEARCHQUERY_PART);
    }

    public static String getWrongSearchQuery(){
        return TestDataReader.getTestData(TESTDATA_WRONG_SEARCHQUERY);
    }


}
