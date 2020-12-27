package page;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.reporters.jq.Main;
import util.CustomConditions;
import util.Utils;

import java.util.List;

public class MainPage extends AbstractPage {

	private static final String BASE_URL = "https://www.asos.com/ru/";

	private static final By byLogInButton = By.xpath("//a[@data-testid='signin-link']");
	private static final By byProfileOptionsButton = By.xpath("//button[@data-testid='accountIcon']");
	private static final By byMyAccountButton = By.xpath("//a[@data-testid='myaccount-link']");
	private static final By bySaleLabel = By.xpath("//a[@href='/ru/men/rasprodazha/cat/?cid=8409&ctaref=hp|mw|promo|banner|1|edit|xmassalelaunch70']/header");
	private static final By byListOfSuggestions = By.xpath("//span[@class='_1iEQyiq']");

	@FindBy(id="chrome-search")
	private WebElement mainSearchInput;

	@FindBy(xpath = "//button[@class='kH5PAAC _1KRfEms']")
	private WebElement searchButton;

	@FindBy(xpath = "//span[@class='_1iEQyiq']")
	private List<WebElement> listOfSuggestions;

	@FindBy(xpath = "")



	public MainPage()
	{
		super();
	}

	public MainPage sendLineInMainSearchInput(String searchLine){
		this.mainSearchInput.sendKeys(searchLine);
		return this;
	}

	public MainPage selectSex(String sex) {
		driver.findElement(By.xpath("//a[contains(text(), '" + sex + "')]")).click();
		return this;
	}

	public SearchResultPage clickOnSaleLabel(){
		driverWait.until(ExpectedConditions.presenceOfElementLocated(bySaleLabel)).click();
		return new SearchResultPage();
	}

	public List<String> getListOfSuggestions(){
		driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byListOfSuggestions));
		return Utils.parseListOfWebElementsToListOfStrings(listOfSuggestions);
	}

	public SearchResultPage clickOnSearchButton() {
		this.searchButton.click();
		return new SearchResultPage();
	}

	public MainPage selectSex (String sex) {
		driver.findElement(By.xpath("//a[contains(text(), '" + sex + "')]")).click();
		return this;
	}

	public MainPage clickOnNavBarOption(String option) {
		WebElement navBarButton = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nav[@class='_3EAPxMS']//span[contains(text(), '" + option + "')]")));
		actions.moveToElement(navBarButton).perform();
		return this;
	}

	public SearchResultPage clickOnNavBarOptionSubcategory(String subcategory) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nav[@class='_3EAPxMS']//a[@class='_1cjL45H _2Y7IAa_ CLdGn9X _1XjY6Zd' and contains(text(), '" + subcategory + "')]"))).click();
		return new SearchResultPage();
	}

	@Override
	public MainPage openPage() {
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
