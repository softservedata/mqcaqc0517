package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTest {

	@Test
	public void AdminLogin() throws Exception {
		// Precondition
		System.setProperty("webdriver.chrome.driver",
				"lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(2000);
		//
		// Test Steps
		//driver.findElement(By.id("login")).clear();
		//driver.findElement(By.id("login")).sendKeys("work");
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
		//driver.findElement(By.id("login")).clear();
		//driver.findElement(By.id("login")).sendKeys("work");
		//
		Assert.assertTrue(true);
		Thread.sleep(4000);
		driver.quit();
	}
}
