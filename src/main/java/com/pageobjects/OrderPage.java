package com.pageobjects;

import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resuablecomponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> cartProducts;
	
	@FindBy(xpath = "//b[normalize-space()='ZARA COAT 3']")
	public WebElement product;
	
	public boolean verifyOrderDisplay(String productName) {
        for (WebElement cartProduct : cartProducts) {
            if (cartProduct.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

}
