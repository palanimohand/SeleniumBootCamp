package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class Home extends BeforeExecution {
	
	By appLauncherButton = By.className("slds-icon-waffle");
	By allApps = By.xpath("//button[@class='slds-button']");
	By serviceConsole = By.xpath("//p[text()='Service Console']");
	By sales = By.xpath("//p[text()='Sales']");
	By mpLearnMore = By.xpath("//div[@class='tileNavButton']/button/span[text()='Learn More']");
	By globalActions = By.xpath("//a[starts-with(@class,'globalCreateTrigger')]");
	By newTask = By.xpath("//a[@title='New Task']");
	By tsksuccessMessage = By.xpath("//span[contains(@class,'forceActionsText')]");
	By afterDeleteMessage = By.xpath("//div[starts-with(@class,'toastContent')]/div/span");
	
	public Home(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public Home clickAppLauncherBtn() {
		click(appLauncherButton);
		return this;
	}
	
	public Home clickAllAppsLink() {
		click(allApps);
		return this;
	}
	
	public Home clickGlobalActions() {
		click(globalActions);
		return this;
	}
	
	public NewTaskPage clickNewTask() {
		click(newTask);
		return new NewTaskPage(driver);
	}
	
	public ServiceConsole openServiceConsole() {
		click(serviceConsole);
		return new ServiceConsole(driver);
	}
	
	public Sales openSales() {
		click(sales);
		return new Sales(driver);
	}
	
	public MobilePublisherPage clickMPLearnMore() {
		click(mpLearnMore);
		switchToNextNewWindow();
		return new MobilePublisherPage(driver);
	}
	
	public String readSuccessMessage() {
		return getText(tsksuccessMessage);
	}
	
	public String readDeleteMessage() {
		return getText(afterDeleteMessage);
	}

}
