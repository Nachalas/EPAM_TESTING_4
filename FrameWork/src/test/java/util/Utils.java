package util;

import model.PricePair;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> parseListOfWebElementsToListOfStrings(List<WebElement> webElements) {
        List<String> listOfInnerTextsFromWebElements = new ArrayList<>();
        for (WebElement element :
                webElements) {
            listOfInnerTextsFromWebElements.add(element.getText());
        }
        return listOfInnerTextsFromWebElements;
    }

    public static List<Integer> convertListOfPricesToListOfInts(List<String> pricesList) {
        List<Integer> integerPriceList = new ArrayList<>();
        for (String price :
                pricesList) {
            integerPriceList.add(Integer
                    .parseInt(price.replaceAll("[^0-9]", "")));
        }
        return integerPriceList;
    }

    public static List<PricePair> convertTwoListOfPricesToListOfPricePair(List<String> pricesList,
                                                                          List<String> priceListWithDiscount) {
        List<PricePair> pricePairs = new ArrayList<>();
        for (int i = 0; i < priceListWithDiscount.size(); i++) {
            pricePairs.add(new PricePair(Integer
                    .parseInt(pricesList.get(i)
                    .replaceAll("[^0-9]", "")),
                    Integer.parseInt(priceListWithDiscount
                                    .get(i)
                                    .replaceAll("[^0-9]", ""))));
        }
        return pricePairs;
    }


}
