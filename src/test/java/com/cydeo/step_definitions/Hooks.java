package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.swing.*;

public class Hooks {


    @Before //it should be come from io.cucumber java, not junit
    public void setUp(){
        System.out.println("SET UP BEFORE EACH SCENARIO");

    }

    @After //it should be come from io.cucumber java, not junit
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data,"imp/png",scenario.getName());//sceneries.getName--> Scenario: Login with valid
                                                                        // credential in the feature directory--> LoginSeamlessly.feature
        }

        BrowserUtils.sleep(3);
        Driver.closeDriver();

    }
}
