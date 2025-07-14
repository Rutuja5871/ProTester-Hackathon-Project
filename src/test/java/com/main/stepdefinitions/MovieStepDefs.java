package com.main.stepdefinitions;


import com.main.testCases.DistrictMoviePage;
import io.cucumber.java.en.*;

import static org.testng.Assert.assertEquals;

public class MovieStepDefs {
    private DistrictMoviePage moviePage;
    private final CommonStepDefs common;

    public MovieStepDefs(CommonStepDefs common) {
        this.common = common;
    }

    @When("I choose {int} seats for movie {string} on date {string} at time {string}")
    public void chooseSeats(int n, String movie, String date, String time) throws InterruptedException {
        System.out.println("→ ENTERING chooseSeats: " + n + ", " + movie + ", " + date + ", " + time);
        moviePage = new DistrictMoviePage(Hooks.driver);
        moviePage.selectSeats(n, movie, date, time);
        System.out.println("→ EXITING chooseSeats");
    }

    @Then("I should see exactly {int} seats selected")
    public void verifySeatCount(int expected) {
        String raw = moviePage.getSeatsCountText(); 
        System.out.println("Seats‐header raw text: \"" + raw + "\"");
        int actual = moviePage.getSelectedSeatsCount(); 
        System.out.println("Parsed actual seat count = " + actual);
        assertEquals(expected, actual,
            "Expected " + expected + " seats but saw " + actual);
    }


	public CommonStepDefs getCommon() {
		return common;
	}
}
