package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utils.BeforeExecution;

public class S20_29_CreateTask extends BeforeExecution {

	@BeforeClass(alwaysRun = true)
	public void setData() {
		sheetName = "Create Task";
	}
	
	@Test(groups = { "a" }, dataProvider = "provideData")
	public void createTask(String browser, String username, String password, String url, String taskName, String subject) throws InterruptedException {

		launchBrowser(browser);
		get(url);

		String readSuccessMessage = new Login(driver).enterUserName(username)
		.enterPassword(password)
		.clickOnLogin()
		.clickGlobalActions()
		.clickNewTask()
		.selectTaskName(taskName)
		.clickStatus()
		.clickWfseOption()
		.enterSubject(subject)
		.clickSave()
		.readSuccessMessage();
		
		if (readSuccessMessage.contains("Task") && readSuccessMessage.contains("was created")) {
			System.out.println("Match");
		} else {
			System.out.println("MisMatch");
		}

	}

}
