package util;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> parseListOfWebElementsToListOfStrings(List<WebElement> webElements){
        List<String> listOfInnerTextsFromWebElements = new ArrayList<>();
        for (WebElement element:
             webElements) {
            listOfInnerTextsFromWebElements.add(element.getText());
        }
        return listOfInnerTextsFromWebElements;
    }

}
