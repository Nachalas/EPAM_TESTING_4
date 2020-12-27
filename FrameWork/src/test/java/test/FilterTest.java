package test;

import org.testng.annotations.Test;
import page.MainPage;
import service.SearchResultPageDataReader;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;

public class FilterTest extends CommonConditions {

    @Test
    public void testPriceOrderByDescendingFilter(){
        String searchLine = SearchResultPageDataReader.getSearchQuery();
        List<Integer> expectedPricesOfProducts = new MainPage()
                .openPage()
                .sendLineInMainSearchInput(searchLine)
                .clickOnSearchButton()
                .clickOnOrderDropDownList()
                .chooseDescendingLabel()
                .getTopTenListOfPrices();

        List<Integer> sortedListOfProducts = expectedPricesOfProducts
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        assertThat(expectedPricesOfProducts).isEqualTo(sortedListOfProducts);
    }

}
