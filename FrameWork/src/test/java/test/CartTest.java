package test;

import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import page.CartPage;
import page.MainPage;
import page.ProductPage;
import service.SearchResultPageDataReader;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest extends CommonConditions {

    @Test
    public void testAddToCart(){
        String searchQuery = SearchResultPageDataReader.getMaskSearchQuery();
        MainPage mainPage = new MainPage();

        ProductPage productPage = mainPage
                .openPage()
                .sendLineInMainSearchInput(searchQuery)
                .clickOnSearchButton()
                .clickOnFirstProductOnPage();
        String productNameOnProductPage = productPage
                .getProductName();
        String productPriceOnProductPage = productPage
                .getProductPrice();
        CartPage cartPage = productPage
                .clickOnAddToCartButton()
                .clickOnGoToCartButton();
        String productNameOnCartPage = cartPage
                .getProductNameInCart();
        String productPriceOnCartPage = cartPage
                .getProductPriceInCart();

        assertThat(productNameOnCartPage).isEqualTo(productNameOnProductPage);
        assertThat(productPriceOnCartPage).isEqualTo(productPriceOnProductPage);
    }

}
