package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resuablecomponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmailEle;
	
	@FindBy(id="userPassword")
	WebElement userPasswordEle;
	
	@FindBy(id="login")
	WebElement loginSubmitButton;
	
	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement loginErrorAlert;
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatalogue loginApp(String email, String password) {
		userEmailEle.sendKeys(email);
		userPasswordEle.sendKeys(password);
		loginSubmitButton.click();
		//ProductCatalogue prodCat = new ProductCatalogue(driver);
		return new ProductCatalogue(driver);
	}
	
	public String loginErrorValidation() {
		return loginErrorAlert.getText();
		
	}

}
