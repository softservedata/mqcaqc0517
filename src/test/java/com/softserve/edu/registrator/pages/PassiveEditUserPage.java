package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PassiveEditUserPage extends AdminHomePage {

	// Fields
	private WebElement emailInput;

	public PassiveEditUserPage(WebDriver driver) {
		super(driver);
		this.emailInput = driver.findElement(By.id("email"));
	}

	// PageObject

	// get Data

	public WebElement getEmailInput() {
		return this.emailInput;
	}

	// Functional

	public String getEmailInputAttributeText(String attribute) {
		return getEmailInput().getAttribute(attribute);
	}

	public String getEmailInputText() {
		return getEmailInputAttributeText(VALUE_ATTRIBUTE);
	}

	// get inner Data

	// set Data

	// set inner Data

	// Business Logic

}
