package com.Testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src\\test\\java\\com\\feature",
		glue = "com.Stepdefenition",
		strict=true,
		monochrome=true,
		dryRun=false,
		tags= {"@updateissue"}
		
		)
public class Testrunner {

}
