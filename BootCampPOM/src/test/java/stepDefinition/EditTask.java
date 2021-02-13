package stepDefinition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTask extends BaseClass {

	@Given("the user is able to open app launcher")
	public void theUserIsAbleToOpenAppLauncher() throws InterruptedException {
		Thread.sleep(20000);
		driver.findElementByClassName("slds-icon-waffle").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//button[@class='slds-button']").click();
	}

	@Given("the user is able to open Sales")
	public void theUserIsAbleToOpenSales() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElementByXPath("//p[text()='Sales']").click();
	}

	@Given("the user is able to open Tasks")
	public void theUserIsAbleToOpenTasks() throws InterruptedException {
		Thread.sleep(10000);
		WebElement taskdd = driver.findElementByXPath("//a[@title='Tasks']");
		action = new Actions(driver);
		action.click(taskdd).build().perform();
		Thread.sleep(4000);
	}
	
	@Given("the user is able to open Tasks dropdown")
	public void theUserIsAbleToOpenTasksDropdown() throws InterruptedException {
		Thread.sleep(10000);
		WebElement taskdd = driver.findElementByXPath("//a[@title='Tasks']//following::a");
		action = new Actions(driver);
		action.click(taskdd).build().perform();
		Thread.sleep(4000);
	}


	@Given("the user is able to view Recently viewed tasks")
	public void theUserIsAbleToViewRecentlyViewedTasks() throws InterruptedException {
		driver.findElementByXPath("//a[contains(@class,'downIcon')]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//li[contains(@class,'slds-dropdown')]//span[text()='Recently Viewed']").click();
		Thread.sleep(4000);
	}

	@When("the user is able to click on Edit option of BootCamp Task")
	public void theUserIsAbleToClickOnEditOptionOfBootCampTask() throws InterruptedException {
		driver.findElementByXPath("//a[contains(@title,'more actions')]").click();
		Thread.sleep(2000);
		WebElement editdd = driver.findElementByXPath("//div[@title='Edit']");
		Actions action = new Actions(driver);
		action.click(editdd).build().perform();
		Thread.sleep(3000);
	}

	@When("the user is able to select todays date as Due Date")
	public void theUserIsAbleToSelectTodaysDateAsDueDate() {
		driver.findElementByXPath("//span[text()='Due Date']//parent::label//following-sibling::div/input").click();
		driver.findElementByXPath("//button[text()='Today']").click();
	}

	@When("the user is able to select Priority as (.*)")
	public void theUserIsAbleToSelectPriorityAsLow(String priority) throws InterruptedException {
		driver.findElementByXPath("//span[text()='Priority']//parent::span//following::div[@class='uiMenu'][2]")
				.click();
		Thread.sleep(1000);
		driver.findElementByXPath("//a[@title='"+priority+"']").click();
		Thread.sleep(2000);
	}

	@When("Click on Save")
	public void clickOnSave() throws InterruptedException {
		driver.findElementByXPath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']").click();
		Thread.sleep(10000);
	}

	@Then("Verify the subject of the BootCamp Task")
	public void verifyTheSubjectOfTheBootCampTask() {
		String text = driver.findElementByXPath("//span[text()='Subject']//parent::div//following-sibling::div/span")
				.getText();
		if (text.equals("Boot Camp")) {
			System.out.println(text + ": Subject Match");
		} else {
			System.out.println(text + ": Subject Mismatch");
		}
	}

	@Given("the user is able to click on New Task")
	public void the_user_is_able_to_click_on_New_Task() throws InterruptedException {
		WebElement newtask = driver.findElementByXPath("//span[text()='New Task']//ancestor::a");
		action.click(newtask).build().perform();
		Thread.sleep(2000);
	}

	@Given("select name as (.*)")
	public void select_name_as_Sarath_M(String name) throws InterruptedException {
		driver.findElementByXPath("//span[text()='Name']//parent::label//following::input[1]").click();
		driver.findElementByXPath("//span[text()='Name']//parent::label//following::input[1]").sendKeys(name);
		Thread.sleep(1000);
		driver.findElementByXPath("//div[@title='"+name+"']").click();
	}

	@Given("enter comments as (.*)")
	public void enter_comments_as_SALES_FORCE_Automation_Using_Selenium(String comment) {
		driver.findElementByTagName("textarea").sendKeys(comment);
	}

	@Given("click on save")
	public void click_on_save() throws InterruptedException {
		driver.findElementByXPath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']").click();
		Thread.sleep(2000);
	}
}