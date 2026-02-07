package com.Automation.Generic;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	public void webPageScreenShot(WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameworkConstants.Screenshot_path);
		FileHandler.copy(temp, dest);

	}

	public void webElementScreenShot(WebElement element) throws IOException {

		File temp = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameworkConstants.Screenshot_path);
		FileHandler.copy(temp, dest);

	}

	public void selectByVisibleText(WebElement element, String text) {

		Select sel = new Select(element);
		sel.selectByVisibleText(text);

	}

	public void javaScriptClick(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public void javaScriptScrollToElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
	
	public void childWindowPopup(WebDriver driver,String title)
	{
		Set<String> elements = driver.getWindowHandles();
		for (String ids : elements) {
			@Nullable
			String temp = driver.getTitle();
			if(temp.contentEquals(title))
			{
				
			driver.switchTo().window(ids);
			
			}
			
		}
	}
	
	
	

}
