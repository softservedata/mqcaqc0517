package com.softserve.edu.registrator.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.IUser;
import com.softserve.edu.registrator.data.UserRepository;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.LoginPage;
import com.softserve.edu.registrator.pages.ValidatorLoginPage;

public class LoginTest {

//	@DataProvider//(parallel = true)
//	public Object[][] adminUsers() {
//		return new Object[][] {
//			{ "admin", "admin" },
//			{ "work", "qwerty" },
//			{ "registrator", "registrator" }
//		};
//	}

	@DataProvider//(parallel = true)
	public Object[][] adminUsers() {
		return new Object[][] {
			{ UserRepository.get().admin() },
			{ UserRepository.get().adminWork() },
			{ UserRepository.get().registrator() },
		};
	}

	@Test(dataProvider = "adminUsers")
	//public void checkAdminLogon(String login, String password) throws Exception {
	public void checkAdminLogon(IUser admin) throws Exception {
		// Precondition
		System.setProperty("webdriver.chrome.driver",
				LoginTest.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
				//"lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(2000);
		//
		// Steps
		//LoginPage loginPage = new LoginPage(driver);
		//AdminHomePage adminHomePage = loginPage.successAdminLogin(login, password);
		AdminHomePage adminHomePage = new LoginPage(driver)
				//.successAdminLogin(login, password);
				.successAdminLogin(admin);
		Thread.sleep(2000);
		//
		// Check
		//Assert.assertEquals(adminHomePage.getLoginAccountText(), login);
		Assert.assertEquals(adminHomePage.getLoginAccountText(), admin.getLogin());
		//
		// Return to previous state
		LoginPage loginPage = adminHomePage.logout();
		Thread.sleep(2000);
		//
		Assert.assertTrue(loginPage.getLogoAttributeSrcText().toLowerCase().contains(LoginPage.NAME_IMAGE));
		Thread.sleep(2000);
		driver.quit();
	}

	@DataProvider//(parallel = true)
	public Object[][] invalidUsers() {
//		User invalidUser = new User("qwertyui", "qwertyui", "qwertyui", "qwertyui",
//				"qwertyui", "qwertyui","qwertyui");
		return new Object[][] {
			//{ "qwertyui", "qwertyui" }
			{ UserRepository.get().invalid() },
		};
	}

	//@Test(dataProvider = "invalidUsers")
	//public void checkInvalidLogon(String login, String password) throws Exception {
	public void checkInvalidLogon(IUser invalid) throws Exception {
		// Precondition
		System.setProperty("webdriver.chrome.driver",
				LoginTest.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
				//"lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(2000);
		//
		// Steps
		ValidatorLoginPage validatorLoginPage = new LoginPage(driver)
				//.unsuccessfulLogin(login, password);
				.unsuccessfulLogin(invalid);
		Thread.sleep(2000);
		//
		// Check
		Assert.assertEquals(validatorLoginPage.getValidatorLabelText(),
				ValidatorLoginPage.VALIDATOR_MESSAGE);
		Assert.assertTrue(validatorLoginPage.getLogoAttributeSrcText().toLowerCase().contains(LoginPage.NAME_IMAGE));
		Thread.sleep(2000);
		//
		// Return to previous state
		driver.quit();
	}

}
