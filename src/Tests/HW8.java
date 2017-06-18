package Tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW8 {

	@Test
	public void testA() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		driver.get("http://regres.herokuapp.com/login");
		
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("work");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		

		String actual = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm")).getText();
		
		Assert.assertTrue(actual.contains("work"));
		driver.quit();
	}

}