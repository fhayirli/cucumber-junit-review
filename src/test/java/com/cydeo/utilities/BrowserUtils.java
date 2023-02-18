package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {


    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle) {

        //return and store all window handles in a Set
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if(Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));//passed
    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }
    public static void verifyTitle(String driver, String expectedTitle) {

        Assert.assertEquals(driver, expectedTitle);

    }

public static void verifyTitleContains(String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
}

public static void waitForInvisibilityOf(WebElement target){
    WebDriverWait wait  = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
}

    public static void waitForVisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

/**
 * This method accepts a dropdown element and returns a List<String> containing all oprions values as String
 * @param dropdownElement
 * @return actualMonth_as_String
 */
public static List<String> dropdownOptions_as_String(WebElement dropdownElement) {

    Select month  = new Select(dropdownElement);

    List<WebElement> actualMonths_as_WebElement = month.getOptions(); //Storing all the ACTUAL options into a List of WebElementas a String

    List<String> actualMonths_as_String = new ArrayList<>();//Creating an EMPTY List of String to store ACTUAL <option> as String

    for (WebElement each : actualMonths_as_WebElement) {//Looping through the List<WebElement> getting all options text and storing them into List<String>

        actualMonths_as_String.add(each.getText());

    }


return actualMonths_as_String;
}


}
