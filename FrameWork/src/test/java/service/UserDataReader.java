package service;

import model.User;

public class UserDataReader {

    private static final String TESTDATA_USER_MAIL = "testdata.user.mail";
    private static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    private static final String TESTDATA_USER_NAME = "testdata.user.name";
    private static final String TESTDATA_USER_SURNAME = "testdata.user.surname";
    private static final String WRONG_TESTDATA_USER_NAME = "wrongTestData.user.name";
    private static final String WRONG_TESTDATA_USER_PASSWORD = "wrongTestData.user.password";
    private static final String TESTDATA_ERROR_WRONGUSER = "testdata.error.wrongUser";


    public static User withCredentialsFromProperty(){
        return new User(
                TestDataReader.getTestData(TESTDATA_USER_MAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD),
                TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_SURNAME)
        );
    }

    public static String getTestDataWrongUser(){
        return  TestDataReader.getTestData(TESTDATA_ERROR_WRONGUSER);
    }

    public static User withWrongUserData(){
        return new User(
                TestDataReader.getTestData(WRONG_TESTDATA_USER_NAME),
                TestDataReader.getTestData(WRONG_TESTDATA_USER_PASSWORD),
                "",
                ""
        );
    }
}
