package com.softserve.edu.registrator.pages;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.registrator.appl.ApplicationSourcesRepository;

public class TestRunner {
	// protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	// Use, if class Application is not singleton
	// protected Application application;

	@BeforeClass
	public void beforeClass(ITestContext context) {
		System.out.println("@BeforeClass");
		// System.out.println("***@BeforeClass MAVEN"
		// + System.getProperty("surefire.reports.directory"));
		HashMap<String, String> parameters = new HashMap<String, String>(context
                .getCurrentXmlTest().getAllParameters());
		for (String key : parameters.keySet()) {
			System.out.println("testNG.xml:\tkey = "+key+"\tvalue = " + parameters.get(key));
		}
		// Application.get(ApplicationUtils
		// .updateFromTestNgXML(ApplicationSourcesRepository.getChromeTraining(),
		// context));
		// TODO Update ApplicationSources
		Application.get(ApplicationSourcesRepository.getChromeHeroku());
		//Application.get(ApplicationSourcesRepository.getFirefox5xHeroku());
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
		Application.remove();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
		// Application.get().load();
		// Application.get().login();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
		// Application.get().logout();
	}

}