package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import page.MainPage;

import java.util.List;

public class SearchForProductTest extends CommonConditions {

//    @Test
//    public void testSearchForProduct() {
//        String currentQuery = SearchPageDataReader.getSearchQuery();
//
//        List<String> actualProductNames = new MainPage()
//                .openPage()
//                .enterSearchQuery(currentQuery)
//                .clickSearchButton()
//                .getListOfProductNames();
//
//        assertThat(actualProductNames).allMatch(item -> item.contains(currentQuery));
//    }
//
//    @Test
//    public void testSearchForProductWrong() {
//        String correctQuery = SearchPageDataReader.getSearchQuery();
//
//        String wrongLayoutQuery = SearchPageDataReader.getWrongKeyboardLayoutSearchQuery();
//
//        List<String> actualProductNames = new MainPage()
//                .openPage()
//                .enterSearchQuery(wrongLayoutQuery)
//                .clickSearchButton()
//                .getListOfProductNames();
//
//        assertThat(actualProductNames).allMatch(item -> item.contains(correctQuery));
//    }

}
