package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class Login extends BeforeExecution {
	
	By userNameInput = By.id("username");
	By passwordInput = By.id("password");
	By loginButton = By.id("Login");
	
	public Login(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public Login launchApplication(String browser, String url) {
		launchBrowser(browser);
		get(url);
		return this;
	}
	
	public Login enterUserName(String userName) {
		type(userNameInput,userName);
		return this;
	}
	
	public Login enterPassword(String passWord) {
		type(passwordInput,passWord);
		return this;
	}
	
	public Home clickOnLogin() {
		click(loginButton);
		return new Home(driver);
	}

	
}