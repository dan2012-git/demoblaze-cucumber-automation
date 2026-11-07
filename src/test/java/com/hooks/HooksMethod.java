package com.hooks;

import com.base.Base_Class;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HooksMethod extends Base_Class {

    @Before
    public void beforeHooksMethod(Scenario scenario) {
        String name = scenario.getName();
        System.out.println("SCENARIO NAME : " + name);
    }

    @After
    public void afterHooksMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotAs, "image/png", "Is Failed");
        } else {
            String name = scenario.getName();
            System.out.println("SCENARIO NAME : " + name);
            if (scenario.isFailed()) {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshotAs, "image/png", "Is Passed");
            }
        }
    }
}

