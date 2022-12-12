package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/resources/Features/"},
        glue = {"stepDefinations"},plugin = { "pretty", "html: target/cucumber-reports"}
        ,monochrome=true)
public class Runner extends AbstractTestNGCucumberTests {

}

