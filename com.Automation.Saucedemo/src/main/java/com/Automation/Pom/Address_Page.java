package com.Automation.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Address_Page {

	public Address_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first-name")
	private WebElement fname;

	@FindBy(id = "last-name")
	private WebElement lname;

	@FindBy(name = "postalCode")
	private WebElement pincode;

	@FindBy(id = "continue")
	private WebElement Countinue;

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getPincode() {
		return pincode;
	}

	public WebElement getCountinue() {
		return Countinue;
	}

}
