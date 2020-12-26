package test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.testng.annotations.Test;
import page.MainPage;
import service.SearchResultPageDataReader;

public class SearchTest extends CommonConditions {

    @Test
    public void testCorrectSearch() {
        String currentQuery = SearchResultPageDataReader.getSearchQuery();

        List<String> actualProductNames = new MainPage()
                .openPage()
                .sendLineInMainSearchInput(currentQuery)
                .clickOnSearchButton()
                .getListOfProductNames();

        assertThat(actualProductNames).allMatch(item -> item.toLowerCase()
                .contains(currentQuery.toLowerCase()));
    }

    @Test
    public void testWrongSearch() {
        String correctQuery = SearchResultPageDataReader.getSearchQuery();

        String wrongQuery = SearchResultPageDataReader.getWrongSearchQuery();

        List<String> actualProductNames = new MainPage()
                .openPage()
                .sendLineInMainSearchInput(wrongQuery)
                .clickOnSearchButton()
                .getListOfProductNames();

        assertThat(actualProductNames).allMatch(item -> item.toLowerCase()
                .contains(correctQuery.toLowerCase()));
    }

    @Test
    public void recentRequestsTest(){
        String correctQuery = SearchResultPageDataReader.getSearchQuery();

        String lastRecentRequest = new MainPage()
                .openPage()
                .sendLineInMainSearchInput(correctQuery)
                .clickOnSearchButton()
                .clickOnMainSearchInput()
                .getLastRecentRequest();

        assertThat(lastRecentRequest.toLowerCase())
                .isEqualTo(correctQuery.toLowerCase());
    }

    @Test
    public void searchLineTest(){
        String searchQueryPart = SearchResultPageDataReader.getSearchQueryPart();

        List<String> listOfSuggestions = new MainPage()
                .openPage()
                .sendLineInMainSearchInput(searchQueryPart)
                .getListOfSuggestions();

        assertThat(listOfSuggestions)
                .allMatch(item -> item.toLowerCase().contains(searchQueryPart.toLowerCase()));
    }




}
