package com.softserve.edu.registrator.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.softserve.edu.registrator.appl.ApplicationSources;
import com.softserve.edu.registrator.appl.ApplicationSourcesRepository;

public class Application {

	private interface IBrowser {
		WebDriver getDriver(ApplicationSources applicationSources);
	}

	private static class Firefox4xTemporary implements IBrowser {
		public WebDriver getDriver(ApplicationSources applicationSources) {
			return new FirefoxDriver();
		}
	}

	private static class Firefox5xTemporary implements IBrowser {
		public WebDriver getDriver(ApplicationSources applicationSources) {
			System.setProperty("webdriver.gecko.driver",
					applicationSources.getDriverPath());
			return new FirefoxDriver();
		}
	}

	private static class ChromeTemporary implements IBrowser {
		public WebDriver getDriver(ApplicationSources applicationSources) {
			System.setProperty("webdriver.chrome.driver",
					applicationSources.getDriverPath());
			// ApplicationSourcesRepository.getChromeDriverPath());
			return new ChromeDriver();
		}
	}

	private static class HtmlUnitTemporary implements IBrowser {
		public WebDriver getDriver(ApplicationSources applicationSources) {
			// WebDriver driver = null;
			WebDriver driver = new HtmlUnitDriver(true);
			((HtmlUnitDriver) driver).setJavascriptEnabled(true);
			return driver;
		}
	}

	public static enum Browsers {
		DEFAULT_TEMPORARY("ChromeTemporary",
				ApplicationSourcesRepository.getChromeDriverPath(),
				new ChromeTemporary()),
		FIREFOX4X_TEMPORARY("FireFox4xTemporary",
				new String(),
				new Firefox4xTemporary()),
		FIREFOX5X_TEMPORARY("FireFox5xTemporary",
				ApplicationSourcesRepository.getGeckoDriverPath(),
				new Firefox5xTemporary()),
		CHROME_TEMPORARY("ChromeTemporary",
				ApplicationSourcesRepository.getChromeDriverPath(),
				new ChromeTemporary()),
		HTMLUNIT_TEMPORARY("HtmlUnitTemporary",
				new String(),
				new HtmlUnitTemporary());
		//
		private String browserName;
		private String defaultDriverPath;
		private IBrowser browser;

		private Browsers(String browserName, String defaultDriverPath, IBrowser browser) {
			this.browserName = browserName;
			this.defaultDriverPath = defaultDriverPath;
			this.browser = browser;
		}

		public WebDriver runBrowser(ApplicationSources applicationSources) {
			return browser.getDriver(applicationSources);
		}

		@Override
		public String toString() {
			return browserName;
		}

		public String getDefaultDriverPath() {
			return defaultDriverPath;
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Use Singleton, Repository
	private static volatile Application instance;
	//
	// Fields
	//
	// TODO Change for parallel work
	private WebDriver driver;
	private ApplicationSources applicationSources;
	// etc.

	private Application(ApplicationSources applicationSources) {
		this.applicationSources = applicationSources;
	}

	public static Application get() {
		return get(null);
	}

	public static Application get(ApplicationSources applicationSources) {
		if (instance == null) {
			synchronized (Application.class) {
				if (instance == null) {
					if (applicationSources == null) {
						applicationSources = ApplicationSourcesRepository.getDefault();
					}
					instance = new Application(applicationSources);
					instance.init();
				}
			}
		}
		return instance;
	}

	public static void remove() {
		if (instance != null) {
			instance.quit();
		}
		instance = null;
	}

	public void init() {
		initWebDriver();
		initWaits();
		// TODO
		// Init Strategy from applicationSources
		// Init DB access, etc.
	}

	public LoginPage load() {
		logout();
		getBrowser().get(getApplicationSources().getLoginUrl());
		return new LoginPage(driver);
	}

	public LoginPage login() {
		logout();
		getBrowser().get(getApplicationSources().getLoginUrl());
		return new LoginPage(driver);
	}

	public LoginPage logout() {
		getBrowser().get(getApplicationSources().getLogoutUrl());
		return new LoginPage(driver);
	}

	public void quit() {
		if (getBrowser() != null) {
			getBrowser().quit();
		}
	}

	// TODO Change for parallel work
	public WebDriver getBrowser() {
		// TODO For parallel work
		return driver;
	}

	// TODO Change for parallel work
	public ApplicationSources getApplicationSources() {
		return applicationSources;
	}

	private void initWebDriver() {
		Browsers currentBrowser = Browsers.DEFAULT_TEMPORARY;
		for (Browsers browser : Browsers.values()) {
			if (browser.toString().toLowerCase()
					.contains(getApplicationSources().getBrowserName().toLowerCase())) {
				currentBrowser = browser;
				break;
			}
		}
		this.driver = currentBrowser.runBrowser(this.getApplicationSources());
	}

	private void initWaits() {
		getBrowser().manage().timeouts()
			.implicitlyWait(getApplicationSources().getImplicitTimeOut(), TimeUnit.SECONDS);
	}
}
