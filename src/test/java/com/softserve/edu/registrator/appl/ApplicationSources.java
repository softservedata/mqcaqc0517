package com.softserve.edu.registrator.appl;

// TODO use builder
public class ApplicationSources {

	// Browser Data
	private String browserName;
	private String driverPath;
	// private String browserPath;
	// private String defaulProfile;
	//
	// Implicit and Explicit Waits
	private long implicitTimeOut;
	// private long explicitTimeOut;
	//
	// Localization Strategy
	// private String language;
	//
	// Search Strategy
	// private String searchStrategy;
	//
	// Logger Strategy
	// private String loggerStrategy;
	//
	// URLs
	private String loginUrl;
	private String logoutUrl;
	// private String serverUrl;
	//
	// Connect to DB
	// Selenium Version
	
	public ApplicationSources(String browserName, String driverPath,
			long implicitTimeOut, String loginUrl, String logoutUrl) {
		this.browserName = browserName;
		this.driverPath = driverPath;
		this.implicitTimeOut = implicitTimeOut;
		this.loginUrl = loginUrl;
		this.logoutUrl = logoutUrl;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public String getBrowserName() {
		return browserName;
	}

	public String getDriverPath() {
		return driverPath;
	}

	public long getImplicitTimeOut() {
		return implicitTimeOut;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public void setDriverPath(String driverPath) {
		this.driverPath = driverPath;
	}

	public void setImplicitTimeOut(long implicitTimeOut) {
		this.implicitTimeOut = implicitTimeOut;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

}
