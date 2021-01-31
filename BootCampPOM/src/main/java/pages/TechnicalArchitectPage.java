package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class TechnicalArchitectPage extends BeforeExecution {
	
	By scheduleFullTable = By.xpath("//div[starts-with(@class,'slds-grid')]");
	By statusData = By.xpath("//div[starts-with(@class,'slds-grid')]/div[text()='Status']//following-sibling::div");
	By city = By.xpath("./div[text()='City']//following-sibling::div[1]");
	By datesAvailable = By.xpath("./div[text()='Dates Available']//following-sibling::div[1]");
	
	public TechnicalArchitectPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> getScheduleFullTable() {
		return locateElements(scheduleFullTable); 
	}

	public List<WebElement> getStatusFullTable() {
		return locateElements(statusData); 
	}
	
	public String getCity(WebElement ele) {
		return getText(locateElementWAElement(ele, city));
	}
	
	public String getDatesAvl(WebElement ele) {
		return getText(locateElementWAElement(ele, datesAvailable));
	}
}
