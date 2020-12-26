package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Utils;

import java.util.List;

public class SearchResultPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='_3J74XsK']/div/p")
    private List<WebElement> listOfProducts;

    @FindBy(id="chrome-search")
    private WebElement mainSearchInput;

    @FindBy(xpath = "//span[@class='_1iEQyiq']")
    private WebElement lastRecentRequest;

    private static final By byListOfProducts = By.xpath("//div[@class='_3J74XsK']/div/p");
    private static final By byMainSearchInput = By.id("chrome-search");

    public List<String> getListOfProductNames(){
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byListOfProducts));
        return Utils.parseListOfWebElementsToListOfStrings(listOfProducts);
    }

    public ProductPage clickOnFirstProductOnPage(){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(byListOfProducts)).click();
        return new ProductPage();
    }

    public SearchResultPage clickOnMainSearchInput(){
        driverWait.until(ExpectedConditions.elementToBeClickable(byMainSearchInput));
        this.mainSearchInput.click();
        return this;
    }

    public String getLastRecentRequest(){
        return this.lastRecentRequest.getText();
    }

    public SearchResultPage() {
        super();
        logger.info("Opened search results page " + driver.getCurrentUrl());
    }

    @Override
    public SearchResultPage openPage() {
        logger.error("Cannot open SearchResultsPage by itself! Throwing exception");
        throw new RuntimeException("Cannot open SearchResultsPage by itself!");
    }
}
