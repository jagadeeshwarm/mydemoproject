package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.resuablecomponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='card-body']//h5[b[text()='ZARA COAT 3']]//following-sibling::button[.//i[@class='fa fa-shopping-cart']]")
	WebElement addTocartBtn;

	@FindBy(xpath="//div[@aria-label='Product Added To Cart']")
	WebElement toastMessage;

	public void addTocart() {

		addTocartBtn.click();
		
		waitForElementToDisappear(toastMessage);
	}


	
	
	

}
