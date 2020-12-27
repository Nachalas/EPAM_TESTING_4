package test;

import model.PricePair;
import org.testng.annotations.Test;
import page.MainPage;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class SaleTest extends CommonConditions {

    @Test
    public void saleTest(){
        List<PricePair> pricePairs = new MainPage()
                .openPage()
                .selectSex("МУЖСКОЕ")
                .clickOnSaleLabel()
                .getListOfPricePairs();

        assertThat(pricePairs).allMatch(item -> item.getPrice() > item.getPriceWithDiscount());

    }

}
