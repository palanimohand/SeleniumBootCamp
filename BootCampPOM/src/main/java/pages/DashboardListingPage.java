package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.BeforeExecution;

public class DashboardListingPage extends BeforeExecution{
	
	By newDashboard = By.xpath("//div[@title='New Dashboard']");
	By privateDashboards = By.xpath("//a[@class='slds-nav-vertical__action' and text()='Private Dashboards']");
	By search = By.xpath("//input[contains(@class,'search-text-field')]");
	By itemDropDown = By.xpath("//table[starts-with(@class,'slds-table')]/tbody/tr/td[last()]//div");
	By deleteOption = By.xpath("//span[text()='Delete']");
	By deleteConfirm = By.xpath("//span[@class=' label bBody' and text()='Delete']");
	By noresFoundmessLoc = By.xpath("//span[@class='emptyMessageTitle']");
	By searchResult = By.xpath("//table[starts-with(@class,'slds-table')]/tbody/tr/th");
	By frame = By.xpath("(//iframe[@title='dashboard'])[last()]");
	
	public DashboardListingPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public NewDashboardPage clickNewDash() throws InterruptedException {
		click(newDashboard);
		Thread.sleep(2000);
		waitForFrame(frame);
		return new NewDashboardPage(driver);
	}
	
	public DashboardListingPage clickPrivateDash() {
		click(privateDashboards);
		return this;
	}
	
	public DashboardListingPage enterSearch(String text) {
		type(search, text);
		return this;
	}
	
	public List<WebElement> getSearchResult() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResult));
		return locateElements(searchResult);
	}
	
	public DashboardListingPage clickItemDropDown() {
		click(itemDropDown);
		return this;
	}
	
	public DashboardListingPage clickDelete() {
		click(deleteOption);
		return this;
	}
	
	public DashboardListingPage clickDeleteConfirm() {
		click(deleteConfirm);
		return this;
	}
	
	public String getNoResMessage() {
		return getText(noresFoundmessLoc);
	}
	
}
