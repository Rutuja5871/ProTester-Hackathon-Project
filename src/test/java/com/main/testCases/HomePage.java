// File: HomePage.java
package com.main.testCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Encapsulates district.in home page’s popup, city selection and home-logo actions.
 */
public class HomePage {
    private WebDriver driver;

    @FindBy(css = ".dds-w-8.dds-h-8.dds-flex.dds-items-center.dds-justify-center")
    private WebElement popupCloseBtn;

    @FindBy(xpath = "//*[@id='page-content']/div[3]/div/div/div/div/div[2]/div[1]/div/div/img")
    private List<WebElement> cityOptions;

    @FindBy(xpath = "//*[@id='master-header']/div/div/div[1]/div/a/img")
    private WebElement homeLogo;

    public HomePage(WebDriver driver) {
        this.setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Closes the initial popup.
     */
    public void dismissPopup() {
        popupCloseBtn.click();
    }

    /**
     * Selects a city by its zero-based index in the city grid.
     * @param index zero-based index of city image
     */
    public void selectCityByIndex(int index) {
        cityOptions.get(index).click();
    }

    /**
     * Clicks the top-left home logo to return to the main page.
     */
    public void goToHome() {
        homeLogo.click();
    }

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
