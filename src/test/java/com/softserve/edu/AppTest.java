package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest 
{
	@Test
    public void testApp1()
    {
		System.out.println("surefire.reports.directory = " 
				+ System.getProperty("surefire.reports.directory"));
		System.out.println("AppTest done");
        Assert.assertTrue(true);
    }
}
