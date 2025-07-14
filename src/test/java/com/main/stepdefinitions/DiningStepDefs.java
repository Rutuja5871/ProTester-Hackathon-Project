package com.main.stepdefinitions;


import com.main.testCases.DistrictDiningSearch;
import io.cucumber.java.en.*;

public class DiningStepDefs {
    private DistrictDiningSearch diningPage;
    private final CommonStepDefs common;

    public DiningStepDefs(CommonStepDefs common) {
        this.common = common;
    }

    @When("I search for café {string}")
    public void searchCafe(String cafeName) throws InterruptedException {
        diningPage = new DistrictDiningSearch(Hooks.driver);
        diningPage.getCafeInfo(cafeName);
    }

    @Then("I print the café’s name, rate, price, time, and address to console")
    public void printCafeInfo() {
        // All printing is already inside getCafeInfo()
    }

	public CommonStepDefs getCommon() {
		return common;
	}
}
