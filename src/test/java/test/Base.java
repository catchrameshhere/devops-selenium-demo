package test;

import org.testng.annotations.Test;

import utils.Common;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Base {

	String url = "https://en-gb.facebook.com";
	//	String browser = "chrome";
	Common common;
	static WebDriver driver;

	@Parameters({"browser", "grid"})
	@BeforeTest
	public void beforeTest(String browser, boolean grid) {
		common = new Common();
		common.setup(browser, url, grid);
		driver = common.getDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
