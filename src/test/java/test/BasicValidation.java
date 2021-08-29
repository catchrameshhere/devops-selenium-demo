package test;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class BasicValidation extends Base {
  @Test
  public void urlValidation() {
	  String expectedUrl = "https://en-gb.facebook.com/";
	  String actualUrl = driver.getCurrentUrl();
	  
	  assertTrue(actualUrl.equals(expectedUrl), "Mismatch in url, ");
  }
  
  @Test
  public void pageTitleValidation() {
	  String expectedPageTitle = "Facebook – log in or sign up";
	  String actualPageTitle = driver.getTitle();
	  
	  Reporter.log("Expected Page Title = " + expectedPageTitle);
	  Reporter.log("Actual Page Title = " + actualPageTitle );
	  
	  assertTrue(actualPageTitle.equals(expectedPageTitle), "Mismatch in the page title, ");
  }
}
