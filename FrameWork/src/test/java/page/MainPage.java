package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.reporters.jq.Main;
import util.CustomConditions;

public class MainPage extends AbstractPage
{

	private static final String BASE_URL = "https://by.wildberries.ru/";

	private static final By byNavBarMenuBookButton = By.xpath("//li[@data-menu-id='519']/a");

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

}
