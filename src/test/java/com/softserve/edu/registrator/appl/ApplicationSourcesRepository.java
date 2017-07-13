package com.softserve.edu.registrator.appl;

public final class ApplicationSourcesRepository {

	private ApplicationSourcesRepository() {
	}

	public static String getGeckoDriverPath() {
		return ApplicationSourcesRepository.class
				.getResource("/lib/geckodriver.exe").getPath().substring(1);
	}

	public static String getChromeDriverPath() {
		return ApplicationSourcesRepository.class
				.getResource("/lib/chromedriver.exe").getPath().substring(1);
	}

	public static ApplicationSources getDefault() {
		return getChromeHeroku();
	}

	public static ApplicationSources getFirefox4701Heroku() {
		return new ApplicationSources("FireFox4x", null, 5L,
				"http://regres.herokuapp.com/login",
				"http://regres.herokuapp.com/logout");
	}

	public static ApplicationSources getFirefox4701Training() {
		return new ApplicationSources("FireFox4x", null, 5L,
				"http://java.training.local:8080/registrator/login",
				"http://java.training.local:8080/registrator/logout");
	}

	public static ApplicationSources getFirefox5xHeroku() {
		// System.out.println("+++++ PATH = "
		// + ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath().substring(1));
		return new ApplicationSources("FireFox5x", getGeckoDriverPath(), 5L,
				"http://regres.herokuapp.com/login",
				"http://regres.herokuapp.com/logout");
	}

	public static ApplicationSources getFirefox5xTraining() {
		// System.out.println("+++++ PATH = "
		// + ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath().substring(1));
		return new ApplicationSources("FireFox5x", getGeckoDriverPath(), 5L,
				"http://java.training.local:8080/registrator/login",
				"http://java.training.local:8080/registrator/logout");
	}

	public static ApplicationSources getChromeHeroku() {
		return new ApplicationSources("Chrome", getChromeDriverPath(), 5L,
				"http://regres.herokuapp.com/login",
				"http://regres.herokuapp.com/logout");
	}

	public static ApplicationSources getChromeTraining() {
		return new ApplicationSources("Chrome", getChromeDriverPath(), 5L,
				"http://java.training.local:8080/registrator/login",
				"http://java.training.local:8080/registrator/logout");
	}

	public static ApplicationSources getHtmlUnitHeroku() {
		return new ApplicationSources("HtmlUnit", null, 5L,
				"http://regres.herokuapp.com/login",
				"http://regres.herokuapp.com/logout");
	}

	public static ApplicationSources getHtmlUnitTraining() {
		return new ApplicationSources("HtmlUnit", null, 5L,
				"http://java.training.local:8080/registrator/login",
				"http://java.training.local:8080/registrator/logout");
	}

}
