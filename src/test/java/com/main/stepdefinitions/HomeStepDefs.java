package com.main.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import com.main.testCases.DistrictHomePage;

public class HomeStepDefs {
    private WebDriver driver = Hooks.driver;
    private DistrictHomePage districtHomePage;

    
    private final CommonStepDefs common;
 
    public HomeStepDefs(CommonStepDefs common) {
        this.common = common;
    }
    
    @When("I scroll to the footer")
    public void i_scroll_to_the_footer() {
        if (districtHomePage == null) {
            districtHomePage = new DistrictHomePage(driver);
        }
        districtHomePage.scrollToFooter();
    }

    @When("I click the {string} icon and verify title {string}")
    public void i_click_and_verify_social_icon(String icon, String expectedTitle) {
        if (districtHomePage == null) {
            districtHomePage = new DistrictHomePage(driver);
        }
        districtHomePage.clickAndVerifySocialIcon(icon, expectedTitle);
    }

    @Then("I close the social media window")
    public void i_close_the_social_media_window() {
        // Handled by clickAndVerifySocialIcon()
    }

	public CommonStepDefs getCommon() {
		return common;
	}
}
