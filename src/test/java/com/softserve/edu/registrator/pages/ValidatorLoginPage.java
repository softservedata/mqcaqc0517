package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidatorLoginPage extends LoginPage {
	//
	// TODO Add enum for Language
	public static final String VALIDATOR_MESSAGE = "Неправильний логін або пароль";
	
	// Fields
	//private WebDriver driver;
	//
	private WebElement validatorLabel;

	public ValidatorLoginPage(WebDriver driver) {
		super(driver);
		//this.driver = driver;
		//
		this.validatorLabel = driver.findElement(By.cssSelector("div[style='color: red;']"));
	}

	// PageObject

	// get Data

	public WebElement getValidatorLabel() {
		return this.validatorLabel;
	}

	// Functional

	public String getValidatorLabelText() {
		return getValidatorLabel().getText().trim();
	}

	// set Data

    // Business Logic

}
