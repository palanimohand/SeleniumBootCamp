package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class ChartPage extends BeforeExecution{

	By chartSettings = By.xpath("//a[@title='Settings']/lightning-icon");
	By newChart = By.xpath("//a[@title='New Chart']");
	By horizontalBarChart = By.xpath("//a[@title='Horizontal Bar Chart']");
	
	public ChartPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public ChartPage clickChartSettings() {
		waitToBeVisible(chartSettings);
		click(chartSettings);
		return this;
	}
	
	public NewChartPage clickNewChart() {
		click(newChart);
		return new NewChartPage(driver);
	}
	
	public ChartPage clickHorizontalBarChart() {
		click(horizontalBarChart);
		return this;
	}
	
}
