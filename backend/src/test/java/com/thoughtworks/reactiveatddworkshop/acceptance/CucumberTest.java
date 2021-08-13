package com.thoughtworks.reactiveatddworkshop.acceptance;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
    format = "pretty",
    plugin = "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:build/reports/cucumber-report.html")
public class CucumberTest {
    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/config/extent-config.xml"));
    }
}
