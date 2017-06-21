package Tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sun.org.apache.bcel.internal.generic.Select;

public class HW8 {

	@Test
	public void testA() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//

		driver.get("http://regres.herokuapp.com/login");

		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("work");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

		// String actual =
		// driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm")).getText();

		// Assert.assertTrue(actual.contains("work"));

		driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[2]/a")).click();

		driver.findElement(By.cssSelector("a[href='/administrator/users/get-all-users']")).click();

		driver.findElement(By.id("inputIndex5")).clear();
		driver.findElement(By.id("inputIndex5")).sendKeys("admin@admin.com");
		driver.findElement(By.id("bth-search")).click();
		
		
		String actual = driver.findElement(By.xpath("//td[contains(text(), 'admin@admin.com')]")).getText();

		Assert.assertTrue(actual.contains("admin@admin.com"));

		driver.quit();
	}

}