package seleniumBootCampAssessment;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import seleniumBootCampTestNG.BeforeExecution;

public class FirstAssessment extends BeforeExecution {

	@Test(groups = "service console", dataProvider = "provideData")
	public void createAndDeleteDashboard(String browser, String userName, String passWord, String url)
			throws InterruptedException {

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
		// switchToNextFrame();
		// driver.switchTo().frame(driver.findElementByXPath("(//iframe[@title='dashboard'])[last()]"));
		waitForFrame(By.xpath("(//iframe[@title='dashboard'])[last()]"));
		WebElement dashboardName = driver.findElementById("dashboardNameInput");
		waitToBeVisible(dashboardName);
		Random rm = new Random();
		int random = rm.nextInt(1000);
		type(dashboardName, "Palanimohan_Workout " + random);
		driver.findElementById("dashboardDescriptionInput").sendKeys("Testing");
		driver.findElementById("submitBtn").click();
		Thread.sleep(2000);
		// switchToNextFrame();
		// waitForFrame(By.xpath("(//iframe[@title='dashboard'])[last()]"));
		driver.switchTo().frame(driver.findElementByXPath("(//iframe[@title='dashboard'])[last()]"));
		System.out.println("frameswitched");
		Thread.sleep(2000);
		waitToBeClickable(By.xpath("//button[@class='slds-button doneEditing']"));
		WebElement done = driver.findElementByXPath("//button[@class='slds-button doneEditing']");
		done.click();
		System.out.println("donefclick");
		waitToBeVisible(By.xpath("//span[starts-with(@class,'slds-page-header__title')]"));
		String dashtitle = driver.findElementByXPath("//span[starts-with(@class,'slds-page-header__title')]").getText();
		String dashDesc = driver.findElementByXPath("//p[@class='slds-page-header__info']").getText();
		if (dashtitle.equals("Palanimohan_Workout " + random) && dashDesc.equals("Testing")) {
			System.out.println("The dashboard has been created");
		} else {
			System.out.println("The dashboard has not been created");
		}
		waitToBeClickable(By.xpath("//button[text()='Subscribe']"));
		driver.findElementByXPath("//button[text()='Subscribe']").click();
		driver.switchTo().defaultContent();
		waitToBeClickable(By.xpath("//span[contains(@class,'button-group-button-label') and text()='Daily']"));
		driver.findElementByXPath("//span[contains(@class,'button-group-button-label') and text()='Daily']").click();

		Select opt = new Select(driver.findElementByTagName("select"));
		opt.selectByVisibleText("10:00 AM");

		driver.findElementByXPath("//span[text()='Save']").click();
		waitToBeVisible(By.xpath("//span[contains(@class,'toastMessage')]"));
		String message = driver.findElementByXPath("//span[contains(@class,'toastMessage')]").getText();
		System.out.println(message);
		if (message.equals("You started a dashboard subscription.")) {
			System.out.println("Message Verified");
		} else {
			System.out.println("Message Incorrect");
		}
		waitToBeClickable(By.xpath("(//div[contains(@class,'close')])[last()]/button"));
		driver.findElementByXPath("(//div[contains(@class,'close')])[last()]/button").click();
		waitToBeClickable(By.xpath("//span[text()='Dashboards' and @class='slds-truncate']"));
		driver.findElementByXPath("//span[text()='Dashboards' and @class='slds-truncate']").click();
		waitToBeClickable(By.xpath("//a[@class='slds-nav-vertical__action' and text()='Private Dashboards']"));
		driver.findElementByXPath("//a[@class='slds-nav-vertical__action' and text()='Private Dashboards']").click();

		waitToBeClickable(By.xpath("//input[contains(@class,'search-text-field')]"));
		driver.findElementByXPath("//input[contains(@class,'search-text-field')]")
				.sendKeys("Palanimohan_Workout " + random);
		Thread.sleep(2000);
		List<WebElement> sresult = driver.findElementsByXPath("//table[starts-with(@class,'slds-table')]/tbody/tr/th");

		if (sresult.size() > 1) {
			System.out.println("Incorrect search result");
		} else if (sresult.size() == 1) {
			String webElement = sresult.get(0).getText();
			while (webElement.equals("Palanimohan_Workout " + random)) {
				System.out.println("Correct result");
				break;
			}
		}

		waitToBeVisible(By.xpath("//table[starts-with(@class,'slds-table')]/tbody/tr/td[last()]//div"));
		WebElement sresfult = driver
				.findElementByXPath("//table[starts-with(@class,'slds-table')]/tbody/tr/td[last()]//div");
		sresfult.click();

		waitToBeVisible(By.xpath("//span[text()='Delete']"));
		driver.findElementByXPath("//span[text()='Delete']").click();

		waitToBeVisible(By.xpath("//span[@class=' label bBody' and text()='Delete']"));
		driver.findElementByXPath("//span[@class=' label bBody' and text()='Delete']").click();

		waitToBeClickable(By.xpath("//input[contains(@class,'search-text-field')]"));
		driver.findElementByXPath("//input[contains(@class,'search-text-field')]").clear();
		driver.findElementByXPath("//input[contains(@class,'search-text-field')]")
				.sendKeys("Palanimohan_Workout " + random);

		Thread.sleep(3000);

		waitToBeVisible(By.xpath("//span[@class='emptyMessageTitle']"));
		String messageend = driver.findElementByXPath("//span[@class='emptyMessageTitle']").getText();

		if (messageend.equals("No results found")) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}

	}

	public void switchToNextFrame() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.tagName("iframe"))));
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (WebElement webElement : frames) {
			while (webElement.isEnabled()) {
				driver.switchTo().frame(webElement);
				break;
			}
		}
	}
}
