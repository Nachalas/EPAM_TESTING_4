package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.CustomConditions;

import java.util.logging.Logger;


public class ProductPage extends AbstractPage {

    private String productPageUrl;

    private static final By byNewRegionSpanInPopUp = By
            .xpath("//li[@data-city-id='1985372']/span");

    @FindBy(xpath = "//button[@data-test-id='add-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='heartSecondary']")
    private WebElement addToFavoritesButton;

    private static final By byAddToCartButton = By.xpath("//button[@data-test-id='add-button']");
    private static final By byGoToCartButton = By.xpath("//span[@class='_1M-cSy1']");
    private static final By byProductPrice = By.xpath("//span[@data-id='current-price']");
    private static final By byProductName = By.xpath("//div[@class='product-hero']/h1");

    public ProductPage clickOnAddToFavoritesButton() {
        addToFavoritesButton.click();
        return this;
    }

    public ProductPage(String pageUrl) {
        super();
        this.productPageUrl = pageUrl;
    }

    public CartPage clickOnGoToCartButton(){
        driverWait.until(ExpectedConditions.elementToBeClickable(byGoToCartButton)).click();
        return new CartPage();
    }

    public String getProductName(){
        return driverWait.until(ExpectedConditions
                .presenceOfElementLocated(byProductName)).getText();
    }

    public String getProductPrice(){
        return  driverWait.until(ExpectedConditions
                    .presenceOfElementLocated(byProductPrice)).getText();
    }

    public ProductPage clickOnAddToCartButton(){
        driverWait.until(ExpectedConditions.elementToBeClickable(byAddToCartButton));
        this.addToCartButton.click();
        return this;
    }

    public ProductPage() {
        super();
    }

    @Override
    public ProductPage openPage() {
        driver.navigate().to(productPageUrl);
        driver.navigate().refresh();
        logger.info("Opened page " +  productPageUrl);
        return this;
    }



}
