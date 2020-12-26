package service;

import model.User;

public class UserCreator {

    public static final String TESTDATA_USER_MAIL = "testdata.user.mail";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_SURNAME = "testdata.user.surname";
    public static final String WRONG_TESTDATA_USER_NAME = "wrongTestData.user.name";
    private static final String WRONG_TESTDATA_USER_PASSWORD = "wrongTestData.user.password";

    public static User withCredentialsFromProperty(){
        return new User(
                TestDataReader.getTestData(TESTDATA_USER_MAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD),
                TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_SURNAME)
        );
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
