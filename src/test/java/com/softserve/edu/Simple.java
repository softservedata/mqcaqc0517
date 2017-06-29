package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Simple {

	// @Test
	public void testA() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				Simple.class.getResource("./lib/chromedriver.exe").getPath().substring(1));
		// "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		driver.get("https://www.google.com.ua");
		Thread.sleep(1000);
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium IDE Download");
		driver.findElement(By.id("_fZl")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Downloads - Selenium")).click();
		Thread.sleep(1000);
		String actual = driver.findElement(By.cssSelector("a[name='selenium_ide'] > p")).getText();
		Thread.sleep(1000);
		Assert.assertTrue(actual.contains("Selenium IDE is a Firefox plugin which records"));
		driver.quit();
	}

	@Test
	public void googleSearch2() throws Exception {
		String path = Simple.class.getResource("/lib/chromedriver.exe").getPath();
		System.out.println("***Simple.class.getResource = "+ path);
		//
		System.setProperty("webdriver.chrome.driver",
				Simple.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
		        //"./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		driver.get("https://www.google.com.ua");
		Thread.sleep(1000);
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib"))
				// .sendKeys("Selenium IDE Download");
				.sendKeys("Selenium IDE Download" + Keys.ENTER);
		driver.findElement(By.id("lst-ib")).submit();
		// driver.findElement(By.id("_fZl")).click();
		//
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("alert('Ha-Ha-Ha')");
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
	}
}
