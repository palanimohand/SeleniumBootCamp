package seleniumBootCampAssessment;

import org.testng.annotations.Test;
import java.util.List;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import seleniumBootCampTestNG.BeforeExecution;

public class FirstAssessment extends BeforeExecution {

	@BeforeMethod
	@Parameters({ "browser" })
	public void start(String browser) {
		driver = new BeforeExecution().launchBrowser(browser);
	}

	@Test
	public void createAndDeleteDashboard() throws InterruptedException {

		driver.get("https://login.salesforce.com");

		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();

		wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(By.className("slds-icon-waffle")));
		driver.findElementByClassName("slds-icon-waffle").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='slds-button']")));
		driver.findElementByXPath("//button[@class='slds-button']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Service Console']")));
		driver.findElementByXPath("//p[text()='Service Console']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Show Navigation Menu']")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement mm = driver.findElementByXPath("//button[@title='Show Navigation Menu']");
		executor.executeScript("arguments[0].click();", mm);
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
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//input[contains(@class,'uiInputSmartNumber')]")));
			driver.findElementByXPath("//input[contains(@class,'uiInputSmartNumber')]").clear();
			driver.findElementByXPath("//input[contains(@class,'uiInputSmartNumber')]").sendKeys("10000");
			driver.findElementByXPath("//span[contains(@class,'bBody') and text()='Save']").click();
		} else {
			driver.findElementByXPath("//button[@title='Edit Goal']").click();
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//input[contains(@class,'uiInputSmartNumber')]")));
			driver.findElementByXPath("//input[contains(@class,'uiInputSmartNumber')]").clear();
			driver.findElementByXPath("//input[contains(@class,'uiInputSmartNumber')]").sendKeys(String.valueOf(sum));
			driver.findElementByXPath("//span[contains(@class,'bBody') and text()='Save']").click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Show Navigation Menu']")));
		driver.findElementByXPath("//button[@title='Show Navigation Menu']").click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[text()='Dashboards' and starts-with(@class,'menuLabel')]")));
		WebElement dd2 = driver.findElementByXPath("//span[text()='Dashboards' and starts-with(@class,'menuLabel')]");
		executor.executeScript("arguments[0].click();", dd2);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='New Dashboard']")));
		driver.findElementByXPath("//div[@title='New Dashboard']").click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboardNameInput")));
		driver.findElementById("dashboardNameInput").sendKeys("Palanimohan_Workout");
		driver.findElementById("dashboardDescriptionInput").sendKeys("Testing");
		driver.findElementById("submitBtn").click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'doneEditing')]")));
		WebElement done = driver.findElementByXPath("//button[contains(@class,'doneEditing')]");
		executor.executeScript("arguments[0].click();", done);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElementByXPath("//span[starts-with(@class,'slds-page-header__title')]")));
		String dashtitle = driver.findElementByXPath("//span[starts-with(@class,'slds-page-header__title')]").getText();
		String dashDesc = driver.findElementByXPath("//p[@class='slds-page-header__info']").getText();
		if (dashtitle.equals("Palanimohan_Workout") && dashDesc.equals("Testing")) {
			System.out.println("The dashboard has been created");
		} else {
			System.out.println("The dashboard has not been created");
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Subscribe']")));
		driver.findElementByXPath("//button[text()='Subscribe']").click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//span[contains(@class,'button-group-button-label') and text()='Daily']")));
		driver.findElementByXPath("//span[contains(@class,'button-group-button-label') and text()='Daily']").click();

		Select opt = new Select(driver.findElementByTagName("select"));
		opt.selectByVisibleText("10:00 AM");

		driver.findElementByXPath("//span[text()='Save']").click();
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[contains(@class,'toastMessage')]")));
		String message = driver.findElementByXPath("//span[contains(@class,'toastMessage')]").getText();
		if (message.equals("Your subscription is all set.")) {
			System.out.println("Message Verified");
		} else {
			System.out.println("Message Incorrect");
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'close')]")));
		driver.findElementByXPath("//div[contains(@class,'close')]").click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[@class='slds-nav-vertical__action' and text()='Private Dashboards']")));
		driver.findElementByXPath("//a[@class='slds-nav-vertical__action' and text()='Private Dashboards']").click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class,'search-text-field')]")));
		driver.findElementByXPath("//input[contains(@class,'search-text-field')]").sendKeys("Palanimohan_Workout");

		// driver.close();

	}

}
