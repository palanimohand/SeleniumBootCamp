package seleniumBootCamp;

import org.openqa.selenium.chrome.ChromeDriver;

public class CreateRefund {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/palanimohan/Documents/Career/qualityEngineer/Softwares/drivers/chromedriver");
		
		ChromeDriver driver = new ChromeDriver();

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
		
		driver.findElementByXPath("//p[text()='Service Console']").click();
		
		Thread.sleep(10000);
		
		driver.findElementByXPath("//button[@title='Show Navigation Menu']").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("//span[text()='Refunds' and starts-with(@class,'menuLabel')]").click();
		
		Thread.sleep(5000);

		driver.findElementByXPath("//a[@title='New']").click();
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//input[@title='Search Accounts']").click();
		
		driver.findElementByXPath("//li[starts-with(@class,'lookup')][1]").click();
		
		driver.findElementByXPath("//span[text()='Status']//parent::span//following-sibling::div[@class='uiMenu']").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("/html/body/div[9]/div/ul/li[4]/a").click();
		
		driver.findElementByXPath("//span[text()='Amount']//parent::label//following-sibling::input").sendKeys("50000");
		
		driver.findElementByXPath("//span[text()='Type']//parent::span//following-sibling::div[@class='uiMenu']").click();
		
		driver.findElementByXPath("/html/body/div[10]/div/ul/li[2]/a").click();
		
		driver.findElementByXPath("//span[text()='Processing Mode']//parent::span//following-sibling::div[@class='uiMenu']").click();
		
		driver.findElementByXPath("/html/body/div[11]/div/ul/li[3]/a").click();
		
		driver.findElementByXPath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']").click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}