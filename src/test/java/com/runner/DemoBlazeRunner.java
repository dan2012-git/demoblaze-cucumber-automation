package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\features\\DemoBlaze.feature",
glue = {"com.stepdefinition","com.hooks"},
monochrome = true,
publish = true,
        tags="@smoke",
        plugin = {"json:Reports/DemoBlaze.json",
        "html:reports/DemoBlaze.html",
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class DemoBlazeRunner {
}
