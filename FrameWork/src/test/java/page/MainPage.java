package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.reporters.jq.Main;
import util.CustomConditions;

public class MainPage extends AbstractPage {

	private static final String BASE_URL = "https://www.asos.com/ru/";

	private static final By byLogInButton = By.xpath("//a[@data-testid='signin-link']");
	private static final By byProfileOptionsButton = By.xpath("//button[@data-testid='accountIcon']");
	private static final By byMyAccountButton = By.xpath("//a[@data-testid='myaccount-link']");

//	@FindBy (xpath = "//button[@data-testid='accountIcon']")
//	WebElement profileOptionsButton;

//	@FindBy (xpath = "//a[@data-testid='signin-link']")
//	WebElement logInButton;

//	@FindBy (xpath = "//a[@data-testid='myaccount-link']")
//	WebElement myAccountButton;

	public MainPage()
	{
		super();
	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Opened page " + BASE_URL);
		return this;
	}

	public MainPage openProfileOptions() {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(byProfileOptionsButton)).click();
		return this;
	}

	public LoginPage openLoginPage() {
		driverWait.until(ExpectedConditions.elementToBeClickable(byLogInButton)).click();
		return new LoginPage();
	}

	public ProfilePage openProfilePage() {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(byMyAccountButton));
		driverWait.until(ExpectedConditions.elementToBeClickable(byMyAccountButton)).click();
		return new ProfilePage();
	}
}
