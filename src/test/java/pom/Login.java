package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Login {
	
	WebDriver driver;
	
	@CacheLookup
	@FindBy(id="email")
	WebElement email;

	@CacheLookup
	@FindBy(id="pass")
	WebElement passwd;
	
	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginWithCredentials(String username, String password) {
		Reporter.log("Username = "+ username);
		Reporter.log("password = "+ password);
		email.clear();
		email.sendKeys(username);
		
		passwd.clear();
		passwd.sendKeys(password);
	}
	
}
