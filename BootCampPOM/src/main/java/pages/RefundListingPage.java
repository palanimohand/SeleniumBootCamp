package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.BeforeExecution;

public class RefundListingPage extends BeforeExecution{
	
	By newRefund = By.xpath("//a[@title='New']");
	By listingDD = By.xpath("//div[contains(@class,'triggerLinkTextAndIconWrapper')]//following-sibling::a");
	By allOption = By.xpath("//span[text()='All']");
	By showChartsOption = By.xpath("//button[@title='Show charts']");
	By chartSettings = By.xpath("//a[@title='Settings']/lightning-icon");
	By newChart = By.xpath("//a[@title='New Chart']");
	
	public RefundListingPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public NewRefundPage clickNewRefund() {
		click(newRefund);
		return new NewRefundPage(driver);
	}
	
	public RefundListingPage clickListingDD() {
		click(listingDD);
		return this;
	}
	
	public RefundListingPage clickallOption() {
		click(allOption);
		return this;
	}
	
	public ChartPage clickShowChart() {
		click(showChartsOption);
		return new ChartPage(driver);
	}


}
