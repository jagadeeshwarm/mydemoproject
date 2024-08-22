package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resuablecomponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//button[text()='Checkout']")
	WebElement checkoutBtn;
	
	public CheckoutPage clickOnCheckout() {
		
		checkoutBtn.click();
		
		return new CheckoutPage(driver);
		
	}

}
