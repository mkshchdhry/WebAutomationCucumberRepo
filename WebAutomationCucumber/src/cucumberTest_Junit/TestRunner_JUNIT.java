package cucumberTest_Junit;

import java.io.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import configFileReader.*;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "Feature",
	glue= {"stepDefinition"},
	plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
	monochrome = true
	)
 
 
public class TestRunner_JUNIT {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(new ConfigFileReader().getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.15.0");
	    Reporter.setSystemInfo("Maven", "N/A");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}