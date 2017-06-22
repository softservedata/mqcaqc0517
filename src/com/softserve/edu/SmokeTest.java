package com.softserve.edu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SmokeTest {

	// @Test
	public void AdminLogin() throws Exception {
		// Precondition
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(2000);
		//
		// Test Steps
		// driver.findElement(By.id("login")).clear();
		// driver.findElement(By.id("login")).sendKeys("work");
		WebElement login = driver.findElement(By.id("login"));
		login.clear();
		login.sendKeys("ha-ha-ha");
		Thread.sleep(2000);
		//
		driver.navigate().refresh();
		Thread.sleep(2000);
		//
		login.clear();
		login.sendKeys("work");
		// driver.findElement(By.id("login")).clear();
		// driver.findElement(By.id("login")).sendKeys("work");
		//
		Assert.assertTrue(true);
		Thread.sleep(4000);
		driver.quit();
	}

	// @Test
	public void ExampleLogin() throws Exception {
		// Precondition
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(2000);
		//
		// Test Steps
		// WebElement registerButton =
		// driver.findElement(By.cssSelector(".btn.btn-success"));
		List<WebElement> registerButton = driver.findElements(By.cssSelector(".btn.btn-success"));
		System.out.println("registerButton.size() = " + registerButton.size());
		if (registerButton.size() == 0) {
			System.out.println("registerButton not found");
		} else {
			System.out.println("registerButton present");
		}
		//
		Thread.sleep(1000);
		driver.quit();
	}

	//@Test
	public void testJS() throws Exception {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(1000);
		// WebElement element = driver.findElement(By.name("login"));
		WebElement element = (WebElement) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementsByName('login')[0]");
		element.sendKeys("12345678");
		Thread.sleep(4000);
		// ((JavascriptExecutor)driver).executeScript("alert('Ha-Ha-Ha')");
		// Thread.sleep(2000);
		// driver.switchTo().alert().accept();
		// Thread.sleep(1000);
		// ((JavascriptExecutor)driver).executeScript("$('.all').fadeOut(2000);");
		// Thread.sleep(4000);
		// ((JavascriptExecutor)driver).executeScript("$('.all').fadeIn(2000);");
		// Thread.sleep(2000);
		// ((JavascriptExecutor)driver).executeScript("document.getElementById('content').innerHTML
		// = '<b>Pa-Pa</b>'");
		// Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void testSelect() throws Exception {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(1000);
		//
		WebElement element = driver.findElement(By.id("changeLanguage"));
		Select language = new Select(element);
		language.selectByVisibleText("english");
		Thread.sleep(4000);
		driver.quit();
	}
}
