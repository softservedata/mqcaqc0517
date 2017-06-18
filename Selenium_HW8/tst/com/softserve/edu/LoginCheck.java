package com.softserve.edu;
/* Homework:
* Написати код з використанням Selenium WebDriver.
* Зайти на сайт http://regres.herokuapp.com/login
* залогуватися - Login: work  Password: qwerty
* Встановити факт входу в аплікацію.
* Закрити браузер.
*/
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import junit.framework.Assert; // ?

@SuppressWarnings("deprecation")
public class LoginCheck { 
	@Test
	public void testSelIdeRec01() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
	    WebDriver driver = new ChromeDriver();
	   	
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// go to site:
	   	driver.get("http://regres.herokuapp.com");
		// login:
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("work");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		// validate that text related to site is present, else fail:	
		String actual = driver.findElement(By.cssSelector("div[class='col-md-7 col-xs-12'] > h3")).getText(); // find web element. getText()- get a text between tags.
		Assert.assertTrue(actual.contains("Децентралізований майновий реєстр")); // ?
		// sign out:
		driver.findElement(By.xpath("//div[@id='header']/div[2]/div/div/button[2]")).click();
	    driver.findElement(By.linkText("Вихід")).click();
		// close web browser and shutdown Webdriver
		driver.quit();
	}
}
