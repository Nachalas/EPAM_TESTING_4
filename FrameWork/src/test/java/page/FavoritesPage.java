package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FavoritesPage extends AbstractPage {

    private static final String BASE_URL = "https://www.asos.com/ru/saved-lists/";

    private static final By byProductNameInFavorites = By.xpath("//div[@class='title_1RKnO']");
    private static final By byProductPriceInFavorites = By.xpath("//span[@class='noWrap_1zIIQ']");

    public String getProductPriceInFavorites() {
        return driverWait.until(ExpectedConditions
                .presenceOfElementLocated(byProductPriceInFavorites)).getText();
    }

    public String getProductNameInFavorites() {
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(byProductNameInFavorites)).getText();
    }

    public FavoritesPage() {
        super();
    }

    @Override
    public FavoritesPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Page opened: " +  BASE_URL);
        return this;
    }


}
