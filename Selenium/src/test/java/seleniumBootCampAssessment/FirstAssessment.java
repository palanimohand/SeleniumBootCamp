package seleniumBootCampAssessment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import seleniumBootCampTestNG.BeforeExecution;

public class FirstAssessment extends BeforeExecution {


	@Test(groups = "service console", dataProvider = "provideData")
	public void createAndDeleteDashboard(String browser, String userName, String passWord, String url) throws InterruptedException {

		launchBrowser(browser);
		driver.get(url);

		driver.findElementById("username").sendKeys(userName);
		driver.findElementById("password").sendKeys(passWord);
		driver.findElementById("Login").click();

		waitToBeClickable(By.className("slds-icon-waffle"));
		driver.findElementByClassName("slds-icon-waffle").click();
		waitToBeClickable(By.xpath("//button[@class='slds-button']"));
		driver.findElementByXPath("//button[@class='slds-button']").click();
		waitToBeClickable(By.xpath("//p[text()='Service Console']"));
		driver.findElementByXPath("//p[text()='Service Console']").click();
		waitToBeClickable(By.xpath("//button[@title='Show Navigation Menu']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement mm = driver.findElementByXPath("//button[@title='Show Navigation Menu']");
		executor.executeScript("arguments[0].click();", mm);
		waitToBeClickable(By.xpath("//span[text()='Home' and starts-with(@class,'menuLabel')]"));
		WebElement dd = driver.findElementByXPath("//span[text()='Home' and starts-with(@class,'menuLabel')]");
		executor.executeScript("arguments[0].click();", dd);
		String openCount = driver
				.findElementByXPath("//span[@class='metricLabel' and text()='Closed']//following-sibling::span")
				.getText();
		String closedCount = driver
				.findElementByXPath("//span[@class='metricLabel' and text()='Open (>70%)']//following-sibling::span")
				.getText();
		String replace = openCount.replace("$", "");
		String replace2 = closedCount.replace("$", "");
		int o = Integer.parseInt(replace);
		int c = Integer.parseInt(replace2);
		int sum = o + c;
		if (sum < 10000) {
			driver.findElementByXPath("//button[@title='Edit Goal']").click();
			waitToBeClickable(By.xpath("//input[contains(@class,'uiInputSmartNumber')]"));
			driver.findElementByXPath("//input[contains(@class,'uiInputSmartNumber')]").clear();
			driver.findElementByXPath("//input[contains(@class,'uiInputSmartNumber')]").sendKeys("10000");
			driver.findElementByXPath("//span[contains(@class,'bBody') and text()='Save']").click();
		} else {
			driver.findElementByXPath("//button[@title='Edit Goal']").click();
			waitToBeClickable(By.xpath("//input[contains(@class,'uiInputSmartNumber')]"));
			driver.findElementByXPath("//input[contains(@class,'uiInputSmartNumber')]").clear();
			driver.findElementByXPath("//input[contains(@class,'uiInputSmartNumber')]").sendKeys(String.valueOf(sum));
			driver.findElementByXPath("//span[contains(@class,'bBody') and text()='Save']").click();
		}
		waitToBeClickable(By.xpath("//button[@title='Show Navigation Menu']"));
		driver.findElementByXPath("//button[@title='Show Navigation Menu']").click();
		waitToBeClickable(By.xpath("//span[text()='Dashboards' and starts-with(@class,'menuLabel')]"));
		WebElement dd2 = driver.findElementByXPath("//span[text()='Dashboards' and starts-with(@class,'menuLabel')]");
		executor.executeScript("arguments[0].click();", dd2);

		waitToBeClickable(By.xpath("//div[@title='New Dashboard']"));
		driver.findElementByXPath("//div[@title='New Dashboard']").click();
		waitForFrame(By.xpath("(//iframe[@title='dashboard'])[last()]"));
		waitToBeVisible(By.id("dashboardNameInput"));
		driver.findElementById("dashboardNameInput").sendKeys("Palanimohan_Workout");
		driver.findElementById("dashboardDescriptionInput").sendKeys("Testing");
		driver.findElementById("submitBtn").click();
		driver.switchTo().defaultContent();
		waitForFrame(By.xpath("(//iframe[@title='dashboard'])[last()]"));
		waitToBeClickable(By.xpath("//button[contains(@class,'doneEditing') and text()='Done']"));
		WebElement done = driver.findElementByXPath("//button[contains(@class,'doneEditing') and text()='Done']");
		done.click();
		waitToBeVisible(By.xpath("//span[starts-with(@class,'slds-page-header__title')]"));
		String dashtitle = driver.findElementByXPath("//span[starts-with(@class,'slds-page-header__title')]").getText();
		String dashDesc = driver.findElementByXPath("//p[@class='slds-page-header__info']").getText();
		if (dashtitle.equals("Palanimohan_Workout") && dashDesc.equals("Testing")) {
			System.out.println("The dashboard has been created");
		} else {
			System.out.println("The dashboard has not been created");
		}
		waitToBeClickable(By.xpath("//button[text()='Subscribe']"));
		driver.findElementByXPath("//button[text()='Subscribe']").click();
		waitToBeClickable(By.xpath("//span[contains(@class,'button-group-button-label') and text()='Daily']"));
		driver.findElementByXPath("//span[contains(@class,'button-group-button-label') and text()='Daily']").click();

		Select opt = new Select(driver.findElementByTagName("select"));
		opt.selectByVisibleText("10:00 AM");

		driver.findElementByXPath("//span[text()='Save']").click();
		waitToBeVisible(By.xpath("//span[contains(@class,'toastMessage')]"));
		String message = driver.findElementByXPath("//span[contains(@class,'toastMessage')]").getText();
		if (message.equals("Your subscription is all set.")) {
			System.out.println("Message Verified");
		} else {
			System.out.println("Message Incorrect");
		}
		waitToBeClickable(By.xpath("//div[contains(@class,'close')]"));
		driver.findElementByXPath("//div[contains(@class,'close')]").click();
		waitToBeClickable(By.xpath("//a[@class='slds-nav-vertical__action' and text()='Private Dashboards']"));
		driver.findElementByXPath("//a[@class='slds-nav-vertical__action' and text()='Private Dashboards']").click();

		waitToBeClickable(By.xpath("//input[contains(@class,'search-text-field')]"));
		driver.findElementByXPath("//input[contains(@class,'search-text-field')]").sendKeys("Palanimohan_Workout");

		//driver.close();

	}

}
