package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CartPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='bag-item-descriptions']/p[@class='bag-item-name']/a")
    private WebElement productNameInCart;

    private static final By byProductPriceInCart = By.xpath("//span[@class='bag-item-price bag-item-price--current']");
    private static final By byProductNameInCart = By.xpath("//div[@class='bag-item-descriptions']/p[@class='bag-item-name']/a");

    public CartPage() {
        super();
        logger.info("Opened search results page " + driver.getCurrentUrl());
    }

    public String getProductPriceInCart(){
        return driverWait.until(ExpectedConditions
                    .presenceOfElementLocated(byProductPriceInCart)).getText();
    }

    public String getProductNameInCart(){
        driverWait.until(driver -> !driver.findElement(byProductNameInCart).getText().equals(""));
        return this.productNameInCart.getText();
    }

    @Override
    public CartPage openPage() {
        logger.error("Cannot open CartPage by itself! Throwing exception");
        throw new RuntimeException("Cannot open CartPage by itself!");
    }


}
