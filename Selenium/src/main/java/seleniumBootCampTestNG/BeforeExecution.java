package seleniumBootCampTestNG;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BeforeExecution {

	public RemoteWebDriver driver;
	public WebDriverWait wait;

	public RemoteWebDriver launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {

			// Create prefs map to store all preferences
			Map<String, Object> prefs = new HashMap<String, Object>();

			// Put this into prefs map to switch off browser notification
			prefs.put("profile.default_content_setting_values.notifications", 2);

			// Create chrome options to set this prefs
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);

			System.setProperty("webdriver.chrome.driver",
					"/Users/palanimohan/Documents/Career/qualityEngineer/Softwares/drivers/chromedriver");

			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"/Users/palanimohan/Documents/Career/qualityEngineer/Softwares/drivers/geckodriver");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("Safari")) {

			System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
			driver = new SafariDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}

}
