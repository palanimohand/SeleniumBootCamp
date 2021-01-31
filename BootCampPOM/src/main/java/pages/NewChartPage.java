package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class NewChartPage extends BeforeExecution{
	
	By chartName = By.xpath("//span[text()='Chart Name']//parent::label//following-sibling::input");
	By chartType = By.xpath("//span[text()='Chart Type']//parent::span//following-sibling::div/div/div/div/a");
	By verticalBarChartOption = By.xpath("//li[contains(@class,'uiRadioMenuItem')]/a[@title='Vertical Bar Chart']");
	By aggregateType = By.xpath("//span[text()='Aggregate Type']//parent::span//following-sibling::div/div/div/div/a");
	By averageOption = By.xpath("//a[@title='Average']");
	By aggregateField = By.xpath("//span[text()='Aggregate Field']//parent::span//following-sibling::div/div/div/div/a");
	By amountOption = By.xpath("//a[@title='Amount']");
	By groupingField = By.xpath("//span[text()='Grouping Field']//parent::span//following-sibling::div/div/div/div/a");
	By accountOption = By.xpath("//a[@title='Account']");
	By save = By.xpath("//button[@title='Save']");
	
	public NewChartPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public NewChartPage enterChartName(String text) {
		type(chartName, text);
		return this;
	}
	
	public NewChartPage clickChartType() {
		click(chartType);
		return this;
	}
	
	public NewChartPage clickVBOption() {
		click(verticalBarChartOption);
		return this;
	}
	
	public NewChartPage clickAggType() {
		click(aggregateType);
		return this;
	}
	
	public NewChartPage clickAverageOption() {
		click(averageOption);
		return this;
	}
	
	public NewChartPage clickAggField() {
		click(aggregateField);
		return this;
	}
	
	public NewChartPage clickAmountOption() {
		click(amountOption);
		return this;
	}
	
	public NewChartPage clickGroupingField() {
		click(groupingField);
		return this;
	}
	
	public NewChartPage clickAccOption() {
		click(accountOption);
		return this;
	}
	
	public ChartPage clickSave() throws InterruptedException {
		click(save);
		Thread.sleep(2000);
		return new ChartPage(driver);
	}

}
