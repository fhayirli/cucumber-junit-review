package com.cydeo.step_definitions;

import com.cydeo.pages.SeamlessLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_step_defs {

    SeamlessLoginPage loginPage = new SeamlessLoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("seamless.url"));
    }

    @When("user enter valid username")
    public void user_enter_valid_username() {
        loginPage.username.sendKeys(ConfigurationReader.getProperty("seamless.username"));
    }

    @When("user enter valid password")
    public void user_enter_valid_password() {
        loginPage.password.sendKeys(ConfigurationReader.getProperty("seamless.password"));
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.btn_login.click();
    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }


    @When("user enter username {string}")
    public void user_enter_username_with_params(String username) {
        if (username.equals("null")){
            loginPage.username.sendKeys("");
        }else {
            loginPage.username.sendKeys(username);
        }


    }

    @And("user enter password {string}")
    public void user_enter_password_with_params(String password) {
        if (password.equals("null")){
            loginPage.password.sendKeys("");
        }else {
            loginPage.password.sendKeys(password);
        }
    }

    @Then("user should see be wrong message")
    public void user_should_not_be_able_to_login() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Wrong username or password."));
    }


}