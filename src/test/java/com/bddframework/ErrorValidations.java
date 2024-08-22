package com.bddframework;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.testcomponents.BaseTest;
import base.testcomponents.Retry;

public class ErrorValidations extends BaseTest {
	@Test(groups = "ErrorHandling", retryAnalyzer = Retry.class)
	public void loginValidation()  {
		
		landingPage.loginApp("test@gmail.com", "123456");
		landingPage.loginErrorValidation();
		Assert.assertEquals("Incorrect email password.", landingPage.loginErrorValidation());
	}

}
