package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeTestNonParallel {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.out.println("\t\tFirstTest: @BeforeClass");
		System.setProperty("webdriver.chrome.driver",
				SmokeTest.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
				//"lib/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@AfterClass
	public void afterClass() {
		System.out.println("\t\tFirstTest: @AfterClass");
		driver.quit();
	}

	@BeforeMethod
	public void beforeTest() throws Exception {
		System.out.println("\tFirstTest: @BeforeTest");
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(1000);
	}

	@DataProvider//(parallel = true)
	public Object[][] loginI18N() {
		return new Object[][] {
			{"українська", "Логін"},
			{"русский", "Логин"},
			{"english", "Login"},
		};
  }

	@Test(dataProvider = "loginI18N")
	public void testI18N(String language, String loginLabel) throws Exception {
		//
		WebElement webElement = driver.findElement(By.id("changeLanguage"));
		Select languageSelect = new Select(webElement);
		//
		languageSelect.selectByVisibleText(language);
		Thread.sleep(1000);
		//
		Assert.assertEquals(driver.findElement(By.cssSelector("label[for='inputEmail']")).getText(),
				loginLabel);
		Thread.sleep(1000);
	}

}