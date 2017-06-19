package HW08Selenium;

// Comm.import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW8WebSiteTest01 
{

	@Test
	public void testA() throws Exception 
	{
		// create virtual value - webdriver.chrome.driver
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		driver.get("http://regres.herokuapp.com/login");
		
		driver.findElement(By.id("login")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("login")).sendKeys("work");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("qwerty");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		Thread.sleep(1000);
		String actual = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm")).getText();
		Thread.sleep(1000);
		Assert.assertTrue(actual.contains("work"));
		Thread.sleep(1000);
		driver.quit();
	}
}