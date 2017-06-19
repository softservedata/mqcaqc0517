package HW08Selenium;
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
public class HW8WebSiteTest02 { 
	@Test
	public void testSelIdeRec01() throws Exception {
		// System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
	   	
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// go to site:
	   	driver.get("http://regres.herokuapp.com");
		// login:
		driver.findElement(By.id("login")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("login")).sendKeys("work");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("qwerty");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		// validate that text related to site is present, else fail:	
		Thread.sleep(1000);
		String actual = driver.findElement(By.cssSelector("div[class='col-md-7 col-xs-12'] > h3")).getText(); // find web element. getText()- get a text between tags.
		Thread.sleep(1000);
		Assert.assertTrue(actual.contains("Децентралізований майновий реєстр")); // ?
		Thread.sleep(1000);
		// sign out:
		driver.findElement(By.xpath("//div[@id='header']/div[2]/div/div/button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Вихід")).click();
		// close web browser and shutdown Webdriver
		Thread.sleep(1000);
		driver.quit();
	}
}
