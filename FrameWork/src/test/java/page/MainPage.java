package page;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.reporters.jq.Main;
import util.CustomConditions;
import util.Utils;

import java.util.List;

public class MainPage extends AbstractPage
{

	private static final String BASE_URL = "https://www.asos.com/ru/";

	@FindBy(id="chrome-search")
	private WebElement mainSearchInput;

	@FindBy(xpath = "//button[@class='kH5PAAC _1KRfEms']")
	private WebElement searchButton;

	@FindBy(xpath = "//span[@class='_1iEQyiq']")
	private List<WebElement> listOfSuggestions;


	private static final By byNavBarMenuBookButton = By.xpath("//li[@data-menu-id='519']/a");
	private static final By byListOfSuggestions = By.xpath("//span[@class='_1iEQyiq']");

	public MainPage()
	{
		super();
	}

	public MainPage sendLineInMainSearchInput(String searchLine){
		this.mainSearchInput.sendKeys(searchLine);
		return this;
	}

	public List<String> getListOfSuggestions(){
		driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byListOfSuggestions));
		return Utils.parseListOfWebElementsToListOfStrings(listOfSuggestions);
	}

	public SearchResultPage clickOnSearchButton(){
		this.searchButton.click();
		return new SearchResultPage();
	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Opened page " + BASE_URL);
		return this;
	}

}
