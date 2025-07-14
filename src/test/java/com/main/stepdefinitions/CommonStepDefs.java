package com.main.stepdefinitions;

import com.main.testCases.HomePage;
import io.cucumber.java.en.*;

// This class holds steps used by multiple feature files
public class CommonStepDefs {
    private HomePage home;

    @Given("I am on District.in home page")
    public void onHomePage() {
        home = new HomePage(Hooks.driver);
    }

    @And("I dismiss the popup")
    public void dismissPopup() {
        home.dismissPopup();
    }

    @And("I select city index {int}")
    public void selectCityIndex(int idx) {
        home.selectCityByIndex(idx);
    }

    // Expose HomePage if other steps need it
    public HomePage getHomePage() {
        return home;
    }
}
