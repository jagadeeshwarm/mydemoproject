package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resuablecomponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countrySearchField;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement selectCountry;

	@FindBy(xpath = "//a[.='Place Order ']")
	WebElement submitBtn;
	
	By results = By.cssSelector(".ta-results");

	public void searchCountry(String countryName) {
		countrySearchField.sendKeys(countryName);
	}

	public void selectCountry() {
		waitForElementToAppear(results);
		selectCountry.click();	
	}

	public ConfirmationPage placeOrder() {
		submitBtn.click();
		return new ConfirmationPage(driver);
	}

}
