package com.softserve.edu;

import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.tools.ReporterWrapper;

public class AppTestReport {
    public static final Logger logger = LoggerFactory.getLogger(AppTest.class); // org.slf4j.LoggerFactory
    //public static final Logger logger = Logger.getLogger(AppTest.class);
	public Calendar c;

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("CalcTest @Before setUp()");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("CalcTest @After tearDown()");
        Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>@AfterMethod Non Conditional.</FONT><BR>",true);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 3</FONT><BR>",3,true);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 5</FONT><BR>",5);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 7</FONT><BR>",7,true);
    }

    @Test
	public void testApp() {
		Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>Non Conditional.</FONT><BR>",true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 3</FONT><BR>",3,true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 5</FONT><BR>",5);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 7</FONT><BR>",7,true);
		System.out.println("Running . . .");
//		ReporterWrapper.get().debug("DEBUG - messages");
//		ReporterWrapper.get().info("INFO - messages");
//		ReporterWrapper.get().warning("WARNING - messages");
//		ReporterWrapper.get().error("ERROR - messages");
		ReporterWrapper.get().error("From: ReporterWrapper.get().error");
		Assert.assertTrue(true);
	}
	
    //@Test
    public void testApp2() {
        logger.info("\t+++testApp2() DONE");
        System.out.println("\t+++testApp2() DONE");
        WebDriver driver = new HtmlUnitDriver();
    }
}
