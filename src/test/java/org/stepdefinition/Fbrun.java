package org.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources" , glue = "org.stepdefinition" , monochrome = false , dryRun = false)
public class Fbrun {

}
