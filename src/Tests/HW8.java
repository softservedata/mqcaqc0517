package Tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class HW8 {

	// @Test
	public void testA() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

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

		// english
		language.selectByVisibleText("english");
		Thread.sleep(4000);

		String signIn_en = driver.findElement(By.cssSelector("button.btn.btn-primary")).getText();

		Assert.assertTrue(signIn_en.contains("Sign in"));

		driver.navigate().refresh();
		Thread.sleep(4000);
		
		// українська
		language.selectByVisibleText("українська");
		Thread.sleep(4000);

		String signIn_ua = driver.findElement(By.cssSelector("button.btn.btn-primary")).getText();

		Assert.assertTrue(signIn_ua.contains("Увійти"));
		
		driver.navigate().refresh();
		Thread.sleep(4000);

		//русский
		language.selectByVisibleText("русский");
		Thread.sleep(4000);

		String signIn_ua1 = driver.findElement(By.cssSelector("button.btn.btn-primary")).getText();

		Assert.assertTrue(signIn_ua1.contains("Войти"));
		
		
		
		driver.quit();
	}
}
