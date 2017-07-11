package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ACommonPage extends ATopPage {

	private class UserAccount {

		// Fields

		// private WebDriver driver;
		//
		private WebElement changePassword;
		private WebElement resetPassword;
		private WebElement logout;
		// public final WebElement logout;

		// public UserAccount(WebDriver driver) {
		public UserAccount() {
			// this.driver = driver;
			this.changePassword = driver.findElement(By.cssSelector("a.change-password"));
			this.resetPassword = driver.findElement(By.cssSelector("a.reset-my-password"));
			this.logout = driver.findElement(By.xpath("//a[contains(@href,'/logout')]"));
		}

		// PageObject

		// get Data

		public WebElement getChangePasswordElement() {
			return this.changePassword;
		}

		public WebElement getResetPasswordElement() {
			return this.resetPassword;
		}

		public WebElement getLogoutElement() {
			return this.logout;
		}

	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Fields

	private WebElement loginAccount;
	private WebElement menuAccount;
	private UserAccount userAccount;

	public ACommonPage(WebDriver driver) {
		super(driver);
		// TODO use cssSelector with not
		this.loginAccount = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']"));
		this.menuAccount = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle"));
	}

	// PageObject

	// get Data

	public WebElement getLoginAccount() {
		return this.loginAccount;
	}

	public WebElement getMenuAccount() {
		return this.menuAccount;
	}

	// get inner Data

	public WebElement getChangePassword() {
		clickMenuAccount();
		return this.userAccount.getChangePasswordElement();
	}

	public WebElement getResetPassword() {
		clickMenuAccount();
		return this.userAccount.getResetPasswordElement();
	}

	public WebElement getLogout() {
		clickMenuAccount();
		return this.userAccount.getLogoutElement();
	}

	// Functional

	public String getLoginAccountText() {
		return getLoginAccount().getText();
	}

	public String getChangePasswordText() {
		return getChangePassword().getText();
	}

	public String getResetPasswordText() {
		return getResetPassword().getText();
	}

	public String getLogoutText() {
		return getLogout().getText();
	}

	// set Data

	public void clickLoginAccount() {
		getLoginAccount().click();
	}

	public void clickMenuAccount() {
		clickLoginAccount();
		getMenuAccount().click();
		this.userAccount = new UserAccount();
	}

	public void clickChangePassword() {
		getChangePassword().click();
	}

	public void clickResetPassword() {
		getResetPassword().click();
	}

	public void clickLogout() {
		getLogout().click();
	}

	// Business Logic

    public LoginPage logout() {
        clickLogout();
        // Return a new page object representing the destination.
        return new LoginPage(driver);
    }

}
