package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateTask extends BaseClass {

	@Given("the user is able to enter username as (.*)")
	public void the_user_is_able_to_enter_username(String userName) {
		driver.findElementById("username").sendKeys(userName);
	}

	@Given("the user is able to enter password as (.*)")
	public void the_user_is_able_to_enter_password(String passWord) {
		driver.findElementById("password").sendKeys(passWord);
	}

	@Given("the user is able to click login")
	public void the_user_is_able_to_click_login() {
		driver.findElementById("Login").click();
	}

	@Given("click on global actions icon")
	public void click_on_global_actions_icon() throws InterruptedException {
		Thread.sleep(20000);
		driver.findElementByXPath("//a[starts-with(@class,'globalCreateTrigger')]").click();
	}

	@Given("click on New Task icon from GA")
	public void click_on_New_Task_icon_from_GA() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElementByXPath("//a[@title='New Task']").click();
	}

	@When("enter subject as Bootcamp from GA")
	public void enter_subject_as_Bootcamp() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElementByXPath("//label[text()='Subject']//parent::label//following::input[1]")
				.sendKeys("Boot Camp");
	}

	@When("select name from GA as (.*)")
	public void select_contact_as_Sarath_M(String name) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='Name']//parent::label//following::input[1]").sendKeys(name);
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@title='"+name+"']").click();
	}

	@When("select status as (.*)")
	public void select_status_as_waiting_for_someone_else_from_GA(String status) throws InterruptedException {
		driver.findElementByXPath("//span[text()='Status']//parent::span//following::a[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@title='"+status+"']").click();
		Thread.sleep(2000);
	}

	@When("click on save from GA")
	public void click_on_save() throws InterruptedException {
		driver.findElementByXPath("//button[contains(@class,'publisherShareButton')]").click();
		Thread.sleep(3000);
	}

	@Given("enter comments")
	public void enter_comments() {
		driver.findElementByTagName("textarea").sendKeys("SALES FORCE Automation Using Selenium");
	}

	@Then("verify the mandatory message")
	public void verify_the_mandatory_message() {
		String text = driver.findElementByXPath("//ul[@class='errorsList']/li").getText();
		if (text.trim().equalsIgnoreCase("These required fields must be completed: Subject")) {
			System.out.println("Match");
		} else {
			System.out.println("No Match");
		}
	}

	@Then("verify the Task has been created from GA")
	public void verify_the_Task_has_been_created() {
		String txt = driver.findElementByXPath("//span[contains(@class,'forceActionsText')]").getText();
		System.out.println(txt);
		if (txt.contains("Task") && txt.contains("was created")) {
			System.out.println("Match");
		} else {
			System.out.println("MisMatch");
		}
	}

}
