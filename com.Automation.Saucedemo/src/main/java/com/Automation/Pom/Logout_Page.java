package com.Automation.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout_Page {
	public Logout_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "react-burger-menu-btn")
	private WebElement hamburger;
	@FindBy(id = "logout_sidebar_link")
	private WebElement logout_Button;

	public WebElement getHamburger() {
		return hamburger;
	}

	public WebElement getLogout_Button() {
		return logout_Button;
	}

}
