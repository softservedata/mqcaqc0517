package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHomePage {

	// Fields
	private WebDriver driver;
	//
	private WebElement loginAccount;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		//
		this.loginAccount = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']"));
	}

	// PageObject

	// get Data

	public WebElement getLoginAccount() {
		return this.loginAccount;
	}

	// Functional

	public String getLoginAccountText() {
		return getLoginAccount().getText();
	}

	// set Data

	public void clickLoginAccount() {
		getLoginAccount().click();
	}

	public void clickLogout() {
		// TODO
		//getLogout().click();
		driver.get("http://regres.herokuapp.com/logout");
	}

    // Business Logic

	public LoginPage logout() {
		clickLogout();
		// Return a new page object representing the destination.
		return new LoginPage(driver);
	}


}
