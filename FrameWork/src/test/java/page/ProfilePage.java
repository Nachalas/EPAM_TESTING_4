package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.CustomConditions;

public class ProfilePage extends AbstractPage {
    private static final String BASE_URL = "https://my.asos.com/my-account";

    private static final By byMyInformationButton = By.xpath("//span[contains(text(), 'Моя информация')]");
    private static final By byCurrentEmailInput = By.xpath("//input[@type='email']");

    @FindBy (xpath = "//div[@class='_2roWJCL3cYLWn-WGjDB73j']")
    private WebElement welcomeTextName;

    public ProfilePage() {
        super();
    }

    @Override
    public ProfilePage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Page opened: " +  BASE_URL);
        return this;
    }

    public ProfilePage openInformationTab() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(byMyInformationButton)).click();
        return this;
    }

    public String getProfileEmail() {
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(byCurrentEmailInput)).getText();
    }

    public String getNameAndSurnameInWelcomeText() {
        return welcomeTextName.getText();
    }
}
