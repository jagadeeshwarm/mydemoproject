package com.stepdefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.pageobjects.CartPage;
import com.pageobjects.CheckoutPage;
import com.pageobjects.ConfirmationPage;
import com.pageobjects.ProductCatalogue;

import base.testcomponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EcomTestStepdefinition extends BaseTest{
	
	public ProductCatalogue prodCat;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;
	public ConfirmationPage confirmationPage;
	
	@When("Landed on ecom site")
	public void Landed_on_ecom_site() throws IOException {
		launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String user, String password) {
		prodCat = landingPage.loginApp(user,password);
		
	}

	@When("Product added to the cart")
	public void product_added_to_the_cart() {
		prodCat.addTocart();
	}

	@Then("User navigates to checkout page")
	public void user_navigates_to_checkout_page() {
		cartPage = prodCat.gotoCartPage();
		checkoutPage = cartPage.clickOnCheckout();
		checkoutPage.searchCountry("india");
		checkoutPage.selectCountry();

	}

	@Then("The Order is placed")
	public void the_order_is_placed() {
		confirmationPage = checkoutPage.placeOrder();
	}

	@Then("Verify the message {string}")
	public void verify_the_message(String message) {
		String orderConfirmMsg = confirmationPage.getOrderConfirmationMsg();
		Assert.assertTrue(orderConfirmMsg.equalsIgnoreCase(message));
	  
	}
}
