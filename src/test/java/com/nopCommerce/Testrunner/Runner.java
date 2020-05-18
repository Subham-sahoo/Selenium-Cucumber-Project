
package com.nopCommerce.Testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Feature/AddCustomer.Feature", glue = "com.nopCommerce.StepDefination", dryRun =false
, monochrome = true, plugin = {
		"pretty", "html:test-output" })
public class Runner {

}
