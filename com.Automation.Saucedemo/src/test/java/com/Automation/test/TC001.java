package com.Automation.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import com.Automation.Generic.BaseTest;
import com.Automation.Generic.FileUtility;
import com.Automation.Generic.WebDriverUtility;
import com.Automation.Pom.A_to_Z_Products;
import com.Automation.Pom.Address_Page;
import com.Automation.Pom.Cart_page;
import com.Automation.Pom.CheckOutPage;
import com.Automation.Pom.OrderPlacedPage;

public class TC001 extends BaseTest {
	@Test
	public void execution() throws EncryptedDocumentException, IOException, InterruptedException {
		A_to_Z_Products products_page = new A_to_Z_Products(driver);
		WebDriverUtility shortcut = new WebDriverUtility();
		Cart_page cart = new Cart_page(driver);
		Address_Page add = new Address_Page(driver);
		CheckOutPage check = new CheckOutPage(driver);
		OrderPlacedPage order = new OrderPlacedPage(driver);
		FileUtility file = new FileUtility();

		
		for (int i = 1; i < products_page.products().size(); i++) {
			shortcut.selectByVisibleText(products_page.getDropdown_Container(), "Name (A to Z)");
			products_page.products().get(i).click();
			Thread.sleep(1000);
			shortcut.javaScriptClick(driver, products_page.getCartIcon());
			Thread.sleep(1000);
			cart.getRemove().click();
			cart.getContinue_shopping().click();
		}
		for (int i = 1; i < products_page.products().size(); i++) {
			products_page.products().get(i).click();
			Thread.sleep(1000);
		}
		shortcut.javaScriptClick(driver, products_page.getCartIcon());
		cart.getCheckout().click();

		add.getFname().sendKeys(file.readDataFromExcelFile("Sheet1", 1, 0));
		add.getLname().sendKeys(file.readDataFromExcelFile("Sheet1", 1, 1));
		add.getPincode().sendKeys(file.readDataFromExcelFile("Sheet1", 1, 2));
		add.getCountinue().click();

		check.getFinish().click();

		shortcut.webPageScreenShot(driver);
		

		order.getHome().click();
		

	}

}
