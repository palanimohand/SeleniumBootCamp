package seleniumBootCampTestNG;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S20_11_BoardExamSchedule extends BeforeExecution {

	String activeWindow;
	ArrayList<String> allWindows = new ArrayList<String>();
	Set<String> windowHandles;

	@Test(groups = "easy",dataProvider = "provideData")
	public void plannedBoardExam(String browser, String username, String password, String url) throws InterruptedException {

		launchBrowser(browser);
		driver.get(url);

		driver.findElementById("username").sendKeys(username);
		driver.findElementById("password").sendKeys(password);
		driver.findElementById("Login").click();

		waitToBeClickable(By.xpath("//div[@class='tileNavButton']/button/span[text()='Learn More']"));
		driver.findElementByXPath("//div[@class='tileNavButton']/button/span[text()='Learn More']").click();

		switchToNextNewWindow();
		waitToBeClickable(By.xpath("//span[text()='Resources']//parent::button"));
		Actions ac = new Actions(driver);
		WebElement resources = driver.findElementByXPath("//span[text()='Resources']//parent::button");
		WebElement certificate = driver.findElementByXPath("//span[text()='Salesforce Certification ']//parent::a");
		ac.moveToElement(resources).build().perform();
		certificate.click();

		switchToNextNewWindow();
		waitToBeClickable(By.xpath("//div[text()='Salesforce Architect']"));
		driver.findElementByXPath("//div[text()='Salesforce Architect']").click();
		waitToBeClickable(By.xpath("//a[text()='Technical Architect']//preceding::a[text()='More Details']"));
		driver.findElementByXPath("//a[text()='Technical Architect']//preceding::a[text()='More Details']").click();

		switchToNextNewWindow();
		waitToBeVisible(By.xpath("//div[starts-with(@class,'slds-grid')]"));
		List<WebElement> scheduleFullTable = driver.findElements(By.xpath("//div[starts-with(@class,'slds-grid')]"));
		List<WebElement> status = driver.findElements(
				By.xpath("//div[starts-with(@class,'slds-grid')]/div[text()='Status']//following-sibling::div"));

		System.out.println("Planned Schedule details: ");
		for (int i = 0; i < status.size(); i++) {
			if (status.get(i).getText().trim().equals("Planning")) {
				System.out.println("City: " + ((scheduleFullTable.get(i + 1))
						.findElement(By.xpath("./div[text()='City']//following-sibling::div[1]"))).getText());
				System.out.println("Date: " + ((scheduleFullTable.get(i + 1))
						.findElement(By.xpath("./div[text()='Dates Available']//following-sibling::div[1]")))
								.getText());
			}
		}
	}

	public void switchToNextNewWindow() {
		windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			while (!allWindows.contains(handle)) {
				allWindows.add(handle);
				driver.switchTo().window(handle);
				break;
			}
		}
	}
}
