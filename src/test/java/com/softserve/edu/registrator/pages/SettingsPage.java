package com.softserve.edu.registrator.pages;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPage extends AdminHomePage {

	public static enum SettingsPageL10n {
		SETTING_SAVED_MESSAGE("Налаштування успішно збережені!",
				"Настройки успешно сохранены!",
				"Settings was successfully saved!");
		//
		private HashMap<ChangeLanguageFields, String> field;

		private SettingsPageL10n(String... localization) {
			this.field = new HashMap<ChangeLanguageFields, String>();
			int i = 0;
			for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
				this.field.put(language, localization[i]);
				i++;
			}
		}
		
		public String getLocalization(ChangeLanguageFields language) {
			return this.field.get(language).trim();
		}

	}
	
	private static final String SETTING_SAVED_ERROR = "Setting Saved Info not Found";
	private static final String SETTING_SAVED_CSSSELECTOR = "div.alert.alert-success";

	// Fields
	private List<WebElement> settingSaved;
	private WebElement personal;
	private WebElement manual;
	private WebElement confirmChanges;
	
	public SettingsPage(WebDriver driver) {
		super(driver);
		this.personal = driver.findElement(By.xpath("//input[@name='registrationMethod' and @value='PERSONAL']"));
		this.manual = driver.findElement(By.xpath("//input[@name='registrationMethod' and @value='MANUAL']"));
		this.confirmChanges = driver.findElement(By.id("confirmRegistrationMethod"));
	}
	
	// PageObject

	// get Data

	public WebElement getPersonal() {
		return this.personal;
	}

	public WebElement getManual() {
		return this.manual;
	}

	public WebElement getConfirmChanges() {
		return this.confirmChanges;
	}

	public boolean isSettingSaved() {
		settingSaved = driver.findElements(By.cssSelector(SETTING_SAVED_CSSSELECTOR));
		return settingSaved.size() > 0;
	}

	public WebElement getSettingSaved() {
		if (!isSettingSaved()) {
			throw new RuntimeException(SETTING_SAVED_ERROR);
		}
		return settingSaved.get(0);
	}

	// Functional

	public boolean getPersonalSelected() {
		return getPersonal().isSelected();
	}

	public boolean getManualSelected() {
		return getManual().isSelected();
	}

	public String getConfirmChangesText() {
		return getConfirmChanges().getText();
	}

	public String getSettingSavedText() {
		return getSettingSaved().getText();
	}

	// set Data

	public void clickPersonal() {
		getPersonal().click();
	}

	public void clickManual() {
		getManual().click();
	}

	public void clickConfirmChanges() {
		getConfirmChanges().click();
	}

	// Business Logic
	
	public SettingsPage gotoPersonalRegistration() {
		clickPersonal();
		clickConfirmChanges();
		return new SettingsPage(driver); // return this; // if page not refresh
	}

	public SettingsPage gotoManualRegistration() {
		clickManual();
		clickConfirmChanges();
		return new SettingsPage(driver);
	}

}
