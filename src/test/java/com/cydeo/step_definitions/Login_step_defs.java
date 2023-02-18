package com.cydeo.step_definitions;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_step_defs {

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("seamless.url"));
    }
    @When("user enter valid username")
    public void user_enter_valid_username() {

    }
    @When("user enter valid password")
    public void user_enter_valid_password() {

    }
    @When("user clicks the login button")
    public void user_clicks_the_login_button() {

    }
    @Then("user should be able to login")
    public void user_should_be_able_to_login() {

    }


}
