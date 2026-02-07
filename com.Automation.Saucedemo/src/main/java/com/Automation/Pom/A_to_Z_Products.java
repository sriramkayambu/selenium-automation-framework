package com.Automation.Pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A_to_Z_Products {
	public A_to_Z_Products(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "product_sort_container")
	private WebElement Dropdown_Container;

	@FindBy(xpath = "//button[text()='Add to cart']")
	private List<WebElement> products;

	@FindBy(className = "shopping_cart_link")
	private WebElement cartIcon;

	public List<WebElement> products() {
		return products;
	}

	public WebElement getCartIcon() {
		return cartIcon;
	}

	public WebElement getDropdown_Container() {
		return Dropdown_Container;
	}

}
