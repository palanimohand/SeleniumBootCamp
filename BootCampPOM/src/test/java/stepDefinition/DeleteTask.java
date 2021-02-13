package stepDefinition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteTask extends BaseClass{
	
	@When("the user is able to click on the delete option of the Boot Camp Task")
	public void the_user_is_able_to_click_on_the_delete_option_of_the_Boot_Camp_Task() throws InterruptedException {
		driver.findElementByXPath("//a[contains(@title,'more actions')]").click();
		Thread.sleep(2000);
		WebElement deletedd = driver.findElementByXPath("//div[@title='Delete']");
		Actions action = new Actions(driver);
		action.click(deletedd).build().perform();
		Thread.sleep(3000);
		driver.findElementByXPath("//span[text()='Delete']").click();
		Thread.sleep(3000);
	}

	@Then("the task must be deleted")
	public void the_task_must_be_deleted() {
		String text = driver.findElementByXPath("//div[starts-with(@class,'toastContent')]/div/span").getText();
		if (text.contains("Task") && text.contains("was deleted")) {
			System.out.println("Match");
		} else {
			System.out.println("MisMatch");
		}
	}

}
