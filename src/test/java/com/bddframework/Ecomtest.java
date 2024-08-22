package com.bddframework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageobjects.CartPage;
import com.pageobjects.CheckoutPage;
import com.pageobjects.ConfirmationPage;
import com.pageobjects.OrderPage;
import com.pageobjects.ProductCatalogue;

import base.testcomponents.BaseTest;

public class Ecomtest extends BaseTest {
	

	public String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "pusrchaseOrder" })
	public void submitOrdertest(HashMap<String, String> input) throws IOException {
		//extent.createTest("Order Creation");

		ProductCatalogue prodCat = landingPage.loginApp(input.get("email"), input.get("password"));
		prodCat.addTocart();

		CartPage cartPage = prodCat.gotoCartPage();

		CheckoutPage checkoutPage = cartPage.clickOnCheckout();
		checkoutPage.searchCountry("india");
		checkoutPage.selectCountry();

		ConfirmationPage confirmationPage = checkoutPage.placeOrder();
		String orderConfirmMsg = confirmationPage.getOrderConfirmationMsg();
		Assert.assertTrue(orderConfirmMsg.equalsIgnoreCase("Thankyou for the order."));
		//extent.flush();
		//takeScreenShot(orderConfirmMsg);

	}

	@Test(dependsOnMethods = { "submitOrdertest" }, groups = {"pusrchaseOrder"})
	public void OrderHistoryTest() {

		ProductCatalogue prodCat = landingPage.loginApp("malagamjagdesh@gmail.com", "Jagan@102419");
		OrderPage orderPage = prodCat.gotoOrders();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));

	}

	@DataProvider
	public Object[][] getData() throws IOException {

//		HashMap<String, String> map = new HashMap<String, String>();
//
//		map.put("email", "malagamjagdesh@gmail.com");
//		map.put("password", "Jagan@102419");
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//
//		map1.put("email", "jagdesh@gmail.com");
//		map1.put("password", "Jagan@102419");
//System.getProperty("user.dir")+"/src/test/java/com/ecomdata/purchaseOrder.json"
//
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"/src/test/java/com/ecomdata/purchaseOrder.json");
		
		return new Object[][] { {data.get(0)},{data.get(1)} };
	}

	/*
	 * @DataProvider public Object[][] getData() {
	 * 
	 * return new Object[][] { { "malagamjagdesh@gmail.com", "Jagan@102419",
	 * "ZARA COAT 3" }, { "jagdesh@gmail.com", "Jagan@102419", "ADIDAS ORIGINAL" }
	 * }; }
	 */

	
}
