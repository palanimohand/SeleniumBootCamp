package seleniumBootCamp;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class S20_32_CreateChartWOMandatroy {

	public static void main(String[] args) throws InterruptedException {

		// Create prefs map to store all preferences
		Map<String, Object> prefs = new HashMap<String, Object>();

		// Put this into prefs map to switch off browser notification
		prefs.put("profile.default_content_setting_values.notifications", 2);

		// Create chrome options to set this prefs
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver",
				"/Users/palanimohan/Documents/Career/qualityEngineer/Softwares/drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");

		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();

		Thread.sleep(20000);

		driver.findElementByClassName("slds-icon-waffle").click();

		Thread.sleep(4000);

		driver.findElementByXPath("//button[@class='slds-button']").click();

		Thread.sleep(10000);

		driver.findElementByXPath("//p[text()='Sales']").click();

		Thread.sleep(10000);

		WebElement taskdd = driver.findElementByXPath("//a[@title='Tasks']//following::a");

		Actions action = new Actions(driver);

		action.click(taskdd).build().perform();
		
		Thread.sleep(2000);
		
		WebElement newtask = driver.findElementByXPath("//span[text()='New Task']//ancestor::a");

		action.click(newtask).build().perform();
		
		Thread.sleep(2000);

		driver.findElementByXPath("//span[text()='Name']//parent::label//following::input[1]").click();
		
		driver.findElementByXPath("//span[text()='Name']//parent::label//following::input[1]").sendKeys("Sarath M");

		Thread.sleep(1000);

		driver.findElementByXPath("//div[@title='Sarath M']").click();
		
		driver.findElementByTagName("textarea").sendKeys("SALES FORCE Automation Using Selenium");
		
		driver.findElementByXPath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']").click();
		
		Thread.sleep(2000);
		
		String text = driver.findElementByXPath("//ul[@class='errorsList']/li").getText();
		
		if(text.trim().equalsIgnoreCase("These required fields must be completed: Subject")) {
			System.out.println("Match");
		}else {
			System.out.println("No Match");
		}
		
		driver.close();
		
	}

}
