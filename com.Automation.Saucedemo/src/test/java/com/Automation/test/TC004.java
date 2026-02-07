package com.Automation.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Automation.Generic.BaseTest;
import com.Automation.Generic.FileUtility;
import com.Automation.Generic.WebDriverUtility;
import com.Automation.Pom.A_to_Z_Products;
import com.Automation.Pom.Address_Page;
import com.Automation.Pom.Cart_page;
import com.Automation.Pom.CheckOutPage;
import com.Automation.Pom.OrderPlacedPage;

public class TC004 extends BaseTest {
	@Test
	public void execution() throws EncryptedDocumentException, IOException, InterruptedException {
		A_to_Z_Products product = new A_to_Z_Products(driver);
		WebDriverUtility shortcut = new WebDriverUtility();
		Cart_page cart = new Cart_page(driver);
		Address_Page address = new Address_Page(driver);
		FileUtility file = new FileUtility();
		CheckOutPage check = new CheckOutPage(driver);
		OrderPlacedPage order = new OrderPlacedPage(driver);
		
		
		for (int i = 1; i < product.products().size(); i++) {
			shortcut.selectByVisibleText(product.getDropdown_Container(), "Price (high to low)");
			Thread.sleep(1000);
			shortcut.javaScriptClick(driver, product.products().get(i));
			shortcut.javaScriptClick(driver, product.getCartIcon());
			Thread.sleep(1000);
			cart.getRemove().click();
			cart.getContinue_shopping().click();
		}
		shortcut.selectByVisibleText(product.getDropdown_Container(), "Price (high to low)");
		for (int i = 1; i < product.products().size(); i++) {
			product.products().get(i).click();
			Thread.sleep(1000);
		}
		product.getCartIcon().click();
		cart.getCheckout().click();
		address.getFname().sendKeys(file.readDataFromExcelFile("Sheet1", 1, 0));
		address.getLname().sendKeys(file.readDataFromExcelFile("Sheet1", 1, 1));
		address.getPincode().sendKeys(file.readDataFromExcelFile("Sheet1", 1, 2));
		address.getCountinue().click();
		check.getFinish().click();
		shortcut.webPageScreenShot(driver);
		order.getHome().click();

	}

}
