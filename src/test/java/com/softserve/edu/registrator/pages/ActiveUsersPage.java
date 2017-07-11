package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.data.IUser;

public class ActiveUsersPage extends AdminHomePage {

    private static final String PROFILE_BUTTON_XPATH ="//td[contains(@class, 'login') and text()='%s']/following-sibling::td/button";

	// Fields

	// private WebDriver driver;

	public ActiveUsersPage(WebDriver driver) {
		super(driver);
	}

	// PageObject

	// get Data

	public WebElement getProfileButton(String login) {
		return driver.findElement(By.xpath(String.format(PROFILE_BUTTON_XPATH, login)));
	}

	// Functional

	// set Data

	public void clickProfileButton(String login) {
		getProfileButton(login).click();
	}

	// Business Logic

	public PassiveEditUserPage gotoPassiveEditUser(IUser user) {
		clickProfileButton(user.getLogin());
		return new PassiveEditUserPage(driver);
	}
	
}
