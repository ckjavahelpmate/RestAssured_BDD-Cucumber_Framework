package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
		glue = "com.stepdefinitions",
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		tags = "",
		plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		
		)
public class TestRunner {

	

}
		