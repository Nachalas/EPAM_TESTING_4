package test;

import static org.assertj.core.api.Assertions.assertThat;

import model.User;
import org.testng.annotations.Test;
import page.MainPage;
import service.TestDataReader;
import service.UserCreator;

import java.util.List;

public class LogInTest extends CommonConditions {

    @Test
    public void testLogInWithCorrectUser() {
        User user = UserCreator.withCredentialsFromProperty();
        String expectedNameAndSurname = user.getName() + " " + user.getSurname();
        String actualNameAndSurname = new MainPage()
                .openPage()
                .openProfileOptions()
                .openLoginPage()
                .enterUserCredentials(user)
                .logInWithCorrectData()
                .openProfileOptions()
                .openProfilePage()
                .openInformationTab()
                .getNameAndSurnameInWelcomeText();
        assertThat(actualNameAndSurname).isEqualTo(expectedNameAndSurname);
    }

    @Test
    public void testLogInWithIncorrectUser() {
        User wrongUser = UserCreator.withWrongUserData();
        String expectedMessage = TestDataReader.getTestData("testdata.error.wrongUser");
        String actualMessage = new MainPage()
                .openPage()
                .openProfileOptions()
                .openLoginPage()
                .enterUserCredentials(wrongUser)
                .logInWithIncorrectData()
                .getErrorMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

}
