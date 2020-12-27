package page;

import model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    private static final String BASE_URL = "https://my.asos.com/";

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement logInButton;

    @FindBy(xpath = "//li[@id='loginErrorMessage']")
    private WebElement errorMessage;

    public LoginPage enterUserCredentials(User user) {
        logger.info("Send "+ user.getMail());
        logger.info("Send "+ user.getPassword());
        usernameInput.sendKeys(user.getMail());
        passwordInput.sendKeys(user.getPassword());
        return this;
    }

    public MainPage logInWithCorrectData() {
        logger.info("Clicking on login button");
        logInButton.click();
        return new MainPage();
    }

    public LoginPage logInWithIncorrectData() {
        logger.info("Clicking on login button");
        logInButton.click();
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public LoginPage() {
        super();
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Page opened: " +  BASE_URL);
        return this;
    }
}
