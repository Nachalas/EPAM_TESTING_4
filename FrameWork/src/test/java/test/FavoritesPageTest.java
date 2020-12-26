package test;

import org.testng.annotations.Test;
import page.FavoritesPage;
import page.MainPage;
import page.ProductPage;
import service.SearchResultPageDataReader;

import static org.assertj.core.api.Assertions.*;

public class FavoritesPageTest extends CommonConditions {

    @Test
    public void addToFavoritesTest() {
        String searchQuery = SearchResultPageDataReader.getMaskSearchQuery();
        MainPage mainPage = new MainPage();

        ProductPage productPage = mainPage
                .openPage()
                .sendLineInMainSearchInput(searchQuery)
                .clickOnSearchButton()
                .clickOnFirstProductOnPage()
                .clickOnAddToFavoritesButton();

        String productNameOnProductPage = productPage
                .getProductName();
        String productPriceOnProductPage = productPage
                .getProductPrice();
        FavoritesPage favoritesPage = new FavoritesPage()
                .openPage();
        String productNameInFavorites = favoritesPage
                .getProductNameInFavorites();
        String productPriceInFavorites = favoritesPage
                .getProductPriceInFavorites();

        assertThat(productNameInFavorites).isEqualTo(productNameOnProductPage);
        assertThat(productPriceOnProductPage).isEqualTo(productPriceInFavorites);

    }

}
