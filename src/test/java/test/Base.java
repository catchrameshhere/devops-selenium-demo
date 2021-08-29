package test;

import org.testng.annotations.Test;

import utils.Common;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Base {
	
	String url = "https://en-gb.facebook.com";
	String browser = "chrome";
	Common common;
	static WebDriver driver;

  @BeforeTest
  public void beforeTest() {
	  common = new Common();
	  common.setupBrowser(browser, url);
	  driver = common.getDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
