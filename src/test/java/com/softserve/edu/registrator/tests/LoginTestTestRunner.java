package com.softserve.edu.registrator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.IUser;
import com.softserve.edu.registrator.data.UserRepository;
import com.softserve.edu.registrator.pages.ATopPage.ChangeLanguageFields;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.LoginPage;
import com.softserve.edu.registrator.pages.LoginPage.LoginPageL10n;
import com.softserve.edu.registrator.pages.PassiveEditUserPage;
import com.softserve.edu.registrator.pages.TestRunner;
import com.softserve.edu.registrator.pages.ValidatorLoginPage;

public class LoginTestTestRunner extends TestRunner {

	@DataProvider//(parallel = true)
	public Object[][] adminUsers() {
		return new Object[][] {
			{ UserRepository.get().admin() },
			//{ UserRepository.get().adminWork() },
		};
	}

	@Test(dataProvider = "adminUsers")
	public void checkAdminLogon(IUser admin) throws Exception {
		// Steps
		AdminHomePage adminHomePage = Application.get().load()
				.successAdminLogin(admin);
		Thread.sleep(2000);
		//
		// Check
		Assert.assertEquals(adminHomePage.getLoginAccountText(),
				admin.getLogin());
		//
		// Return to previous state
		LoginPage loginPage = adminHomePage.logout();
		Thread.sleep(2000);
		//
		Assert.assertTrue(loginPage.getLogoAttributeSrcText().toLowerCase().contains(LoginPage.NAME_IMAGE));
		Thread.sleep(2000);
	}

	@DataProvider//(parallel = true)
	public Object[][] invalidUsers() {
		return new Object[][] {
			{ UserRepository.get().invalid() },
		};
	}

	//@Test(dataProvider = "invalidUsers")
	public void checkInvalidLogon(IUser invalid) throws Exception {
		// Steps
		ValidatorLoginPage validatorLoginPage = Application.get().load()
				.unsuccessfulLogin(invalid);
		Thread.sleep(2000);
		//
		// Check
		Assert.assertEquals(validatorLoginPage.getValidatorLabelText(),
				ValidatorLoginPage.VALIDATOR_MESSAGE);
		Assert.assertTrue(validatorLoginPage.getLogoAttributeSrcText().toLowerCase().contains(LoginPage.NAME_IMAGE));
		Thread.sleep(2000);
	}

	@DataProvider//(parallel = true)
	public Object[][] checkUsers() {
		return new Object[][] {
			{ UserRepository.get().admin(), UserRepository.get().registrator() },
		};
	}

	//@Test(dataProvider = "checkUsers")
	public void checkAdminLogon(IUser adminUser, IUser checkUser) throws Exception {
		// Steps
        PassiveEditUserPage passiveEditUserPage = Application.get().load()
                .successAdminLogin(adminUser)
                .gotoActiveUsers()
                .gotoPassiveEditUser(checkUser);
        Thread.sleep(2000);
        //
		// Check
        Assert.assertEquals(passiveEditUserPage.getEmailInputText(),
        		checkUser.getEmail());
        Thread.sleep(2000);
		//
		// Return to previous state
		LoginPage loginPage = passiveEditUserPage.logout();
		Thread.sleep(2000);
		//
		Assert.assertTrue(loginPage.getLogoAttributeSrcText().toLowerCase().contains(LoginPage.NAME_IMAGE));
		Thread.sleep(2000);
	}

	@DataProvider//(parallel = true)
	public Object[][] localization() {
		return new Object[][] {
			{ ChangeLanguageFields.UKRAINIAN },
			{ ChangeLanguageFields.RUSSIAN },
			{ ChangeLanguageFields.ENGLISH }
			};
	}

	//@Test(dataProvider = "localization")
	public void checkLocalization(ChangeLanguageFields language) throws Exception {
		// Steps
		LoginPage loginPage = Application.get().load();
		Thread.sleep(2000);
		loginPage = loginPage.changeLanguage(language);
		//
		// Check
		System.out.println("Start Assert LOGIN_LABEL");
		Assert.assertEquals(loginPage.getLoginLabelText(),
				LoginPageL10n.LOGIN_LABEL.getLocalization(language));
		//
		System.out.println("Start Assert PASSWORD_LABEL");
		Assert.assertEquals(loginPage.getPasswordLabelText(),
				LoginPageL10n.PASSWORD_LABEL.getLocalization(language));
				//LoginPageL10n.PASSWORD_LABEL.getLocalization(language)+"1");
		//
		System.out.println("Start Assert SUBMIT_BUTTON");
		Assert.assertEquals(loginPage.getSignintText(),
				LoginPageL10n.SUBMIT_BUTTON.getLocalization(language));
		//
		// TODO MUST BE DELETE
		Thread.sleep(2000);
	}

}
