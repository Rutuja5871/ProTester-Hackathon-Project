package com.main.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.main.stepdefinitions",
    plugin = {
        "pretty",
        "html:target/cucumber.html",
        "json:target/allure-results/cucumber.json",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    }
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
}
