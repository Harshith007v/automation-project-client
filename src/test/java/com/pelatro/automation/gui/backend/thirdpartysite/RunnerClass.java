package com.pelatro.automation.gui.backend.thirdpartysite;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/login.feature", plugin = {
		"rerun:target/rerun.txt" }, glue = {
				"com.pelatro.automation.gui.backend.thirdpartysite.testcase.step" }, tags = { "" }, format = { "pretty" })
public class RunnerClass {

}