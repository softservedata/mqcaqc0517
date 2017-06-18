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
import junit.framework.Assert;

public class LoginCheck { 
	@Test
	public void testSelIdeRec01() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
	    WebDriver driver = new ChromeDriver();
	   	
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	   	driver.get("http://regres.herokuapp.com");
		
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("work");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			
		//String actual = driver.findElement(By.cssSelector("h3")).getText();
		String actual = driver.findElement(By.cssSelector("div[class='col-md999-7 col-xs-12'] > h3")).getText();
		Assert.assertTrue(actual.contains("Децентралізований майновий реєстр"));
		// assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Децентралізований майновий реєстр");
		//String actual = driver.findElement(By.cssSelector("a[name='selenium_ide'] > p")).getText(); // find web element. getText()- get a text between tags.
		driver.findElement(By.xpath("//div[@id='header']/div[2]/div/div/button[2]")).click();
	    driver.findElement(By.linkText("Вихід")).click();
		
		driver.quit(); // close browser and stop web server.
	}

}
