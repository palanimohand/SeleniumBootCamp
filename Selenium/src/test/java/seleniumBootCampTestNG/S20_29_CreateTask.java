package seleniumBootCampTestNG;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class S20_29_CreateTask extends BeforeExecution {

	@Test(groups = { "a" }, dataProvider = "provideData")
	public void createTask(String browser, String username, String password, String url) throws InterruptedException {

		launchBrowser(browser);
		driver.get(url);

		driver.findElementById("username").sendKeys(username);
		driver.findElementById("password").sendKeys(password);
		driver.findElementById("Login").click();

		waitToBeClickable(By.xpath("//a[starts-with(@class,'globalCreateTrigger')]"));

		driver.findElementByXPath("//a[starts-with(@class,'globalCreateTrigger')]").click();

		waitToBeClickable(By.xpath("//a[@title='New Task']"));

		driver.findElementByXPath("//a[@title='New Task']").click();

		waitToBeClickable(By.xpath("//span[text()='Name']//parent::label//following::input[1]"));

		driver.findElementByXPath("//span[text()='Name']//parent::label//following::input[1]").sendKeys("Sarath M");

		waitToBeClickable(By.xpath("//div[@title='Sarath M']"));

		driver.findElementByXPath("//div[@title='Sarath M']").click();

		driver.findElementByXPath("//span[text()='Status']//parent::span//following::a[1]").click();

		driver.findElementByXPath("//a[@title='Waiting on someone else']").click();

		driver.findElementByXPath("//label[text()='Subject']//parent::label//following::input[1]")
				.sendKeys("Boot Camp");

		driver.findElementByXPath("//button[contains(@class,'publisherShareButton')]").click();

		waitToBeClickable(By.xpath("//span[contains(@class,'forceActionsText')]"));

		String txt = driver.findElementByXPath("//span[contains(@class,'forceActionsText')]").getText();

		System.out.println(txt);

		if (txt.contains("Task") && txt.contains("was created")) {
			System.out.println("Match");
		} else {
			System.out.println("MisMatch");
		}

		assertTrue(false);

	}

}
