package page;

import model.PricePair;
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

    @FindBy(xpath = "//div[@class='_2pwX7b9']")
    private WebElement orderDropDownList;

    @FindBy(id = "plp_web_sort_price_high_to_low")
    private WebElement descendingLabel;

    @FindBy(xpath = "//span[@class='_16nzq18']")
    private List<WebElement> priceListOfProducts;

    @FindBy(xpath = "//span[@class='_3VjzNxC']")
    private List<WebElement> priceWithDiscountListOfProducts;

    private static final By byListOfProducts = By.xpath("//div[@class='_3J74XsK']/div/p");
    private static final By byPriceListOfProducts = By.xpath("//span[@class='_16nzq18']");
    private static final By byPriceWithDiscountListOfProducts = By.xpath("//span[@class='_3VjzNxC']");
    private static final By byMainSearchInput = By.id("chrome-search");

    public List<String> getListOfProductNames(){
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byListOfProducts));
        return Utils.parseListOfWebElementsToListOfStrings(listOfProducts);
    }

    public List<PricePair> getListOfPricePairs(){
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byPriceListOfProducts));
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byPriceWithDiscountListOfProducts));
        return Utils.convertTwoListOfPricesToListOfPricePair(
                Utils.parseListOfWebElementsToListOfStrings(priceListOfProducts),
                Utils.parseListOfWebElementsToListOfStrings(priceWithDiscountListOfProducts)
        );
    }



    public List<Integer> getTopTenListOfPrices(){
        driverWait.until(driver -> !driver.findElement(byPriceListOfProducts).getText().equals(""));
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byPriceListOfProducts));
        return Utils
                .convertListOfPricesToListOfInts(Utils
                        .parseListOfWebElementsToListOfStrings(priceListOfProducts.subList(0,10))
                );
    }

    public SearchResultPage clickOnOrderDropDownList(){
        this.orderDropDownList.click();
        return this;
    }

    public SearchResultPage chooseDescendingLabel(){
        this.descendingLabel.click();
        return this;
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
