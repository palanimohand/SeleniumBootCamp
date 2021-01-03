package seleniumBootCamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S20_11_BoardExamSchedule {

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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com");

		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();

		Thread.sleep(20000);

		String mainWindow = driver.getWindowHandle();

		driver.findElementByXPath("//div[@class='tileNavButton']/button/span[text()='Learn More']").click();

		Set<String> windowHandles = driver.getWindowHandles();

		ArrayList<String> allWindows = new ArrayList<String>();

		for (String string : windowHandles) {
			System.out.println(string);
			allWindows.add(string);
			if (mainWindow.equals(string)) {
				// do nothing
			} else {
				driver.switchTo().window(string);
				Thread.sleep(3000);
				Actions ac = new Actions(driver);
				WebElement resources = driver.findElementByXPath("//span[text()='Resources']//parent::button");
				WebElement certificate = driver
						.findElementByXPath("//span[text()='Salesforce Certification ']//parent::a");
				ac.moveToElement(resources).build().perform();
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(certificate));
				certificate.click();
				System.out.println("break");
				Set<String> windowHandler = driver.getWindowHandles();
				for (String string2 : windowHandler) {
					if (allWindows.contains(string2)) {
						// do nothing
					} else {
						allWindows.add(string2);
						driver.switchTo().window(string2);
						Thread.sleep(3000);
						driver.findElementByXPath("//div[text()='Salesforce Architect']").click();
						Thread.sleep(3000);
						driver.findElementByXPath(
								"//a[text()='Technical Architect']//preceding::a[text()='More Details']").click();
						Set<String> windowHandlers = driver.getWindowHandles();
						for (String string3 : windowHandlers) {
							if (allWindows.contains(string3)) {
								// do nothing
							} else {
								allWindows.add(string3);
								driver.switchTo().window(string3);
								Thread.sleep(3000);
								List<WebElement> scheduleFullTable = driver
										.findElements(By.xpath("//div[starts-with(@class,'slds-grid')]"));
								System.out.println(scheduleFullTable.size());
								ArrayList<Integer> plannedStatusPos = new ArrayList<Integer>();
								List<WebElement> status = driver.findElements(By.xpath(
										"//div[starts-with(@class,'slds-grid')]/div[text()='Status']//following-sibling::div"));
								for (int i = 0; i < status.size(); i++) {
									if (status.get(i).getText().trim().equals("Planning")) {
										plannedStatusPos.add(i);
									}

								}
								scheduleFullTable = driver
										.findElements(By.xpath("//div[starts-with(@class,'slds-grid')]"));

								for (int j = 0; j < plannedStatusPos.size(); j++) {
									System.out.println("City: " + ((scheduleFullTable.get(plannedStatusPos.get(j) + 1))
											.findElement(By.xpath("./div[text()='City']//following-sibling::div[1]")))
													.getText());
									System.out.println("Date: " + ((scheduleFullTable.get(plannedStatusPos.get(j) + 1))
											.findElement(By.xpath(
													"./div[text()='Dates Available']//following-sibling::div[1]")))
															.getText());
								}
							}
						}
					}
				}
			}

		}
		driver.quit();
	}
}
