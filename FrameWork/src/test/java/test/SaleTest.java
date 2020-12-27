package test;

import model.PricePair;
import org.testng.annotations.Test;
import page.MainPage;
import page.SearchResultPage;
import service.SearchResultPageDataReader;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class SaleTest extends CommonConditions {

    @Test
    public void saleTest(){
        String sex = SearchResultPageDataReader.getSex();

        List<PricePair> pricePairs = new MainPage()
                .openPage()
                .selectSex(sex)
                .clickOnSaleLabel()
                .getListOfPricePairs();

        assertThat(pricePairs).allMatch(item -> item.getPrice() > item.getPriceWithDiscount());

    }

}
