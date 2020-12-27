package service;

public class SearchResultPageDataReader {

    private static final String TESTDATA_SEARCHQUERY = "testdata.searchQuery";
    private static final String TESTDATA_MASK_SEARCHQUERY = "testdata.mask.searchQuery";
    private static final String TESTDATA_WRONG_SEARCHQUERY = "testdata.wrong.searchQuery";
    private static final String TESTDATA_SEARCHQUERY_PART ="testdata.searchQuery.part";
    private static final String TESTDATA_SEX = "testdata.sex";

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

    public static String getSex(){return TestDataReader.getTestData(TESTDATA_SEX); }


}
