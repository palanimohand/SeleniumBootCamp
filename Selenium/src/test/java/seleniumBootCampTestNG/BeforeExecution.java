package seleniumBootCampTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class BeforeExecution {

	public static RemoteWebDriver driver;
	public static WebDriverWait wait ;

	@BeforeSuite(alwaysRun = true)
	public void beforesuite() {
		System.out.println("Before Suite");
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@BeforeMethod(alwaysRun = true)
	public void start() {
		System.out.println("Before Method");
	}

	@AfterMethod(alwaysRun = true)
	public void finish(ITestResult testResult) {
		System.out.println("After Class");
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			System.out.println("The method has passed: " + testResult.getMethod().getMethodName());
		} else if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("The method has failed: " + testResult.getMethod().getMethodName());
		} else if (testResult.getStatus() == ITestResult.SKIP) {
			System.out.println("The method has skipped: " + testResult.getMethod().getMethodName());
		}
		driver.quit();
	}

	@AfterClass(alwaysRun = true)
	public void afterclass() {
		System.out.println("After Class");
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("After Test");
	}

	@AfterSuite(alwaysRun = true)
	public void aftersuite() {
		System.out.println("After Suite");
	}

	public void launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {

			// Create prefs map to store all preferences
			Map<String, Object> prefs = new HashMap<String, Object>();

			// Put this into prefs map to switch off browser notification
			prefs.put("profile.default_content_setting_values.notifications", 2);

			// Create chrome options to set this prefs
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);

			System.setProperty("webdriver.chrome.driver",
					"/Users/palanimohan/Documents/Career/qualityEngineer/Softwares/drivers/chromedriver");

			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"/Users/palanimohan/Documents/Career/qualityEngineer/Softwares/drivers/geckodriver");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("Safari")) {

			System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
			driver = new SafariDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);

	}

	public void type(WebElement ele, String text) {
		waitToBeVisible(ele);
		ele.sendKeys(text);
	}
	
	public void click(WebElement ele) {
		waitToBeClickable(ele);
		ele.click();
	}

	public void waitToBeClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitToBeClickable(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}


	public void waitToBeVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitToBeVisible(WebElement webelement) {
		wait.until(ExpectedConditions.visibilityOf(webelement));
	}


	public void waitToBeInvisible(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitForFrame(By locator) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	@DataProvider
	public Object[][] provideData(Method m) throws IOException {
		String sheetName = null;
		if (m.getName().equals("plannedBoardExam")) {
			sheetName = "Board Exam Schedule";
		} else if (m.getName().equals("createOpportunity")) {
			sheetName = "Create Opportunity";
		} else if (m.getName().equals("createTask")) {
			sheetName = "Create Task";
		} else if (m.getName().equals("editTask")) {
			sheetName = "Edit Task";
		} else if (m.getName().equals("deletetask")) {
			sheetName = "Delete Task";
		} else if (m.getName().equals("createChartWOMandatory")) {
			sheetName = "Create Chart Man";
		} else if (m.getName().equals("createRefund")) {
			sheetName = "Create Refund";
		} else if (m.getName().equals("createChart")) {
			sheetName = "Create Chart";
		} else if (m.getName().equals("createAndDeleteDashboard")) {
			sheetName = "Dashboard";
		}

		XSSFWorkbook xcel = new XSSFWorkbook(new FileInputStream(
				new File("/Users/palanimohan/git/Local Repository/Selenium/Data/Data for BootCamp.xlsx")));
		XSSFSheet sheet = xcel.getSheet(sheetName);
		int rowNum = sheet.getPhysicalNumberOfRows();
		int colNum = (int) sheet.getRow(0).getLastCellNum();
		String[][] arrayData = new String[rowNum - 1][colNum];
		for (int i = 0; i < rowNum - 1; i++) {
			for (int j = 0; j < colNum; j++) {
				XSSFRow row = sheet.getRow(i + 1);
				XSSFCell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				arrayData[i][j] = stringCellValue;
			}
		}
		xcel.close();
		return arrayData;
	}

}
