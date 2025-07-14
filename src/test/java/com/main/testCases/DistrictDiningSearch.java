// File: DistrictDiningSearch.java
package com.main.testCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Encapsulates Dining search: open Dining, search cafe, read details.
 */
public class DistrictDiningSearch {
    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Dining']")
    private WebElement diningMenu;

    @FindBy(xpath = "//*[@id='page-content']/section/div/div[2]/img")
    private WebElement cityImage;

    @FindBy(xpath = "//*[@id=\"page-content\"]/div[4]/div/div/div/div/div[1]/div[1]/div/input")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"page-content\"]/div[4]/div/div/div/div/div[2]/div/div/div/div[1]/a")
    private WebElement firstResult;

    @FindBy(xpath = "//*[@id=\"restaurant-info\"]/div[1]/section[1]/child::*")
    private List<WebElement> restaurantDetails;

    public DistrictDiningSearch(WebDriver driver) {
        this.setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Searches for cafeName and prints its name, rate, price, time, address.
     */
    public void getCafeInfo(String cafeName) throws InterruptedException {
        diningMenu.click();
        System.out.println("clicked Dining");

        cityImage.click();
        searchInput.sendKeys(cafeName);
        Thread.sleep(3000);

        firstResult.click();
        Thread.sleep(3000);

        String name    = restaurantDetails.get(0).getText();
        String raw     = restaurantDetails.get(1).getText();
        String[] parts = raw.split("\\s*\\|\\s*");
        String address = restaurantDetails.get(2).getText();

        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Name    : " + name);
        System.out.println("Rate    : " + parts[0]);
        System.out.println("Price   : " + parts[1]);
        System.out.println("Time    : " + parts[2].replace("\n", "").replace("\r", ""));
        System.out.println("Address : " + address);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
