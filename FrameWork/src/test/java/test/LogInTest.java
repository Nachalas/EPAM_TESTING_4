package test;

import static org.assertj.core.api.Assertions.assertThat;

import model.User;
import org.testng.annotations.Test;
import page.MainPage;
import service.UserDataReader;

public class LogInTest extends CommonConditions {

    @Test
    public void testLogInWithCorrectUser() {
        User user = UserDataReader.withCredentialsFromProperty();
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
        User wrongUser = UserDataReader.withWrongUserData();
        String expectedMessage = UserDataReader.getTestDataWrongUser();

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
