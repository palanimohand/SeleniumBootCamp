package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utils.BeforeExecution;

public class S20_46_CreateChart extends BeforeExecution {

	@BeforeClass(alwaysRun = true)
	public void setData() {
		sheetName = "Create Chart";
	}
	
	@Test(groups = { "chart" }, dataProvider = "provideData")
	public void createChart(String browser, String username, String password, String url, String name) throws InterruptedException {

		launchBrowser(browser);
		get(url);
		
		new Login(driver).enterUserName(username)
		.enterPassword(password)
		.clickOnLogin()
		.clickAppLauncherBtn()
		.clickAllAppsLink()
		.openServiceConsole()
		.clickNavigationMenu()
		.clickRefund()
		.clickListingDD()
		.clickallOption()
		.clickShowChart()
		.clickChartSettings()
		.clickNewChart()
		.enterChartName(name)
		.clickChartType()
		.clickVBOption()
		.clickAggType()
		.clickAverageOption()
		.clickAggField()
		.clickAmountOption()
		.clickGroupingField()
		.clickAccOption()
		.clickSave()
		.clickChartSettings()
		.clickHorizontalBarChart();
		
		Thread.sleep(5000);

	}

}