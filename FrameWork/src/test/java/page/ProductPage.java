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

    public ProductPage(String pageUrl) {
        super();
        this.productPageUrl = pageUrl;
    }

    public ProductPage() {
        super();
    }

    @Override
    public ProductPage openPage() {
        driver.navigate().to(productPageUrl);
        logger.info("Opened page " +  productPageUrl);
        return this;
    }



}
