package utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Common {
	private WebDriver driver;
	private String url = "http://localhost:4444/wd/hub";
	
	public void setup(String browser, String url, boolean grid) {
		if(grid)
			setupGrid(browser);
		else
			setupBrowser(browser);
		
		if(url!="")
			driver.get(url);
		else
			driver.get("about:blank");
	}
	
	public void setupGrid(String browser) {
		DesiredCapabilities capability = null;
		if(browser.equals("chrome"))
			capability = DesiredCapabilities.chrome();
		else if(browser.equals("firefox"))
			capability = DesiredCapabilities.firefox();
		else {
			System.out.println("Proper or valid browser is not specified, hence quitting the automation run");
			System.exit(0);
		}	
		
		try {
			driver = new RemoteWebDriver(new URL(url), capability);
		} catch (MalformedURLException e) {
			System.out.println("something went wrong when working with grid");
			e.printStackTrace();
		}
			
	}
	
	public void setupBrowser(String browser) {
		String currDir = System.getProperty("user.dir");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", currDir + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", currDir + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", currDir + "\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Proper or valid browser is not specified, hence quitting the automation run");
			System.exit(0);
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}


}
