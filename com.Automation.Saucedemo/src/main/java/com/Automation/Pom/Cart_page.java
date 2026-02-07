package com.Automation.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart_page {
	public Cart_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Remove']")
	private WebElement remove;

	@FindBy(name = "checkout")
	private WebElement checkout;

	@FindBy(id = "continue-shopping")
	private WebElement continue_shopping;

	public WebElement getRemove() {
		return remove;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getContinue_shopping() {
		return continue_shopping;
	}

}
