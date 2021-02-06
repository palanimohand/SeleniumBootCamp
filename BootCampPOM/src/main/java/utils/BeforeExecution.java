package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class BeforeExecution {

	public RemoteWebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor executor;
	public static ArrayList<String> allWindows;
	public static Actions ac;
	public Set<String> windowHandles;
	public String sheetName;

	@BeforeSuite(alwaysRun = true)
	public void beforesuite() {
		System.out.println("Before Suite");
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeClass() {
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
		allWindows = new ArrayList<String>();
		ac = new Actions(driver);
		executor = (JavascriptExecutor) driver;
	}

	public void get(String url) {
		driver.get(url);
	}

	public void type(By ele, String text) {
		waitToBeVisible(ele);
		locateElement(ele).clear();
		locateElement(ele).sendKeys(text);
	}

	public String getText(By ele) {
		waitToBeVisible(ele);
		String text = locateElement(ele).getText();
		return text;
	}

	public String getText(WebElement ele) {
		waitToBeVisible(ele);
		String text = ele.getText();
		return text;
	}

	public void click(By ele) {
		waitToBeClickable(locateElement(ele));
		locateElement(ele).click();
	}

	public void javaScriptClick(By ele) {
		waitToBeClickable(locateElement(ele));
		executor.executeScript("arguments[0].click();", locateElement(ele));
	}

	public void switchToNextNewWindow() {
		windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			while (!allWindows.contains(handle)) {
				allWindows.add(handle);
				driver.switchTo().window(handle);
				break;
			}
		}
	}

	public void switchToNextFrame() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.tagName("iframe"))));
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (WebElement webElement : frames) {
			while (webElement.isEnabled()) {
				driver.switchTo().frame(webElement);
				break;
			}
		}
	}

	public void moveToElement(By ele) {
		ac.moveToElement(locateElement(ele)).build().perform();
	}

	public void actionClick(By ele) {
		waitToBeClickable(locateElement(ele));
		ac.click(locateElement(ele)).build().perform();
	}

	public void selectByVisibleText(By ele, String text) {
		Select sc = new Select(locateElement(ele));
		sc.selectByVisibleText(text);
	}

	public WebElement locateElement(By ele) {
		WebElement element = driver.findElement(ele);
		return element;
	}

	public WebElement locateElementWAElement(WebElement ele, By ele1) {
		WebElement element = ele.findElement(ele1);
		return element;
	}

	public List<WebElement> locateElements(By ele) {
		List<WebElement> element = driver.findElements(ele);
		return element;
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

	public void waitToBeInvisible(By locator, String text) {
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}

	public void waitForFrame(By locator) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	@DataProvider
	public Object[][] provideData() throws IOException {
		XSSFWorkbook xcel = new XSSFWorkbook(new FileInputStream(
				new File("/Users/palanimohan/git/Local Repository/BootCampPOM/Data/Data for BootCamp.xlsx")));
		XSSFSheet sheet = xcel.getSheet(sheetName);
		int rowNum = sheet.getPhysicalNumberOfRows();
		int colNum = (int) sheet.getRow(0).getLastCellNum();
		Object[][] arrayData = new Object[rowNum - 1][colNum];
		for (int i = 0; i < rowNum - 1; i++) {
			for (int j = 0; j < colNum; j++) {
				XSSFRow row = sheet.getRow(i + 1);
				XSSFCell cell = row.getCell(j);
				try {
					arrayData[i][j] = cell.getStringCellValue();
				} catch (IllegalStateException e) {
					arrayData[i][j] = String.valueOf(cell.getNumericCellValue());
				}
				
			}
		}
		xcel.close();
		return arrayData;
	}

}
