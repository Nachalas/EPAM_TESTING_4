package test;

import org.testng.annotations.Test;
import page.MainPage;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationBarTest extends CommonConditions {

    @Test
    public void navigationBarTest() {
        List<String> itemsNames = new MainPage()
                .openPage()
                .selectSex("МУЖСКОЕ")
                .clickOnNavBarOption("Одежда")
                .clickOnNavBarOptionSubcategory("Носки")
                .getListOfProductNames();
        assertThat(itemsNames).allMatch(item -> item.toLowerCase().contains("носк"));
    }
}
