package service;

import model.User;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final String WRONG_TESTDATA_USER_NAME = "wrongTestdata.user.name";
    private static final String WRONG_TESTDATA_USER_PASSWORD = "wrongTestdata.user.password";

    public static User withCredentialsFromProperty(){
        return new User(
                TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD)
        );
    }

    public static User withWrongUserData(){
        return new User(
                TestDataReader.getTestData(WRONG_TESTDATA_USER_NAME),
                TestDataReader.getTestData(WRONG_TESTDATA_USER_PASSWORD)
        );
    }
}
