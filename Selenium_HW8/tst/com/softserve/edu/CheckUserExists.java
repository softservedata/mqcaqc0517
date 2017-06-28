package com.softserve.edu;

/* Homework:
* Продовжити код з попереднього завдання
* Зайти на сайт
* http://regres.herokuapp.com/login
* залогуватися     Login: work     Password: qwerty
* Далі клікнути на меню Coowners (Співвласники), потім Active (Активні).
* Перевірити, чи в отриманій таблиці присутній користувач з поштовим адресом admin@admin.com
* Закрити браузер.
* Перевірити працездатність аплікації на різних браузерах (Chrome, IE, etc.).
*/
	import java.util.concurrent.TimeUnit;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import junit.framework.Assert; // ?

	@SuppressWarnings("deprecation")
	public class CheckUserExists {
		@Test
		public void testSelIdeRec01() throws Exception {
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
		    WebDriver driver = new ChromeDriver();
		   	
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
			
			// go to 'Coworkers' > 'Active'
			driver.findElement(By.cssSelector("a.dropdown-toggle")).click();
			driver.findElement(By.cssSelector("a[href*='/administrator/users/get-all-users']")).click();
		
			// check table present:
			String tablePresence = driver.findElement(By.cssSelector("table.table-striped.table-bordered.table-hover.dataTable.dtr-inline")).getAttribute("id");
			Assert.assertTrue(tablePresence.contains("example"));
		    
			// search for email
			// Doesn't work! -> String emailCheck = driver.findElement(By.xpath("//td[text()='admin']/following-sibling::td[text()='admin@admin.com']")).getText();
			String emailCheck = driver.findElement(By.xpath("//td[text()='admin@admin.com']/preceding-sibling::td[text()='admin']")).getText();
			//System.out.println("emailcheck: " + emailCheck);
			Assert.assertTrue(emailCheck.contains("admin"));			

			// sign out:
			driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();
		    driver.findElement(By.xpath("//ul[contains(@class, 'dropdown-menu')]/li/a[@href='/logout']")).click();
			
		    // close web browser and shutdown Webdriver
		    driver.quit();
		}
	}

