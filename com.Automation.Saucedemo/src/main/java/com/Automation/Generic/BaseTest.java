package com.Automation.Generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.Automation.Pom.Login_Page;
import com.Automation.Pom.Logout_Page;

public class BaseTest {

	public WebDriver driver;
	FileUtility fileutility = new FileUtility();

	@BeforeClass
	public void launch() throws IOException {
		String browser = fileutility.readDataFromPropertyFile("browser");
		String url = fileutility.readDataFromPropertyFile("url");
		if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);

	}

	@BeforeMethod
	public void Login() throws IOException {
		Login_Page login = new Login_Page(driver);
		login.getUsername().sendKeys(fileutility.readDataFromPropertyFile("username"));
		login.getPassword().sendKeys(fileutility.readDataFromPropertyFile("password"));
		login.getButton().click();
	}

	@AfterMethod
	public void Logout() {

		Logout_Page logout = new Logout_Page(driver);
		logout.getHamburger().click();
		logout.getLogout_Button().click();

	}

	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
