package com.seleniumtraining.testcaseautomation;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testcases {

	static String countryxpath;
	static String country;
	static String country1;
	static WebDriver driver;
	static BrowserInteraction browserClassInstance = new BrowserInteraction();

	@BeforeClass
	static public void setup() {
		String browser = "chrome";
		String url = "https://www.timeanddate.com/calendar/";
		testcases.countryxpath = "//select[@id='sf_country']";
		testcases.country = "irand";
		testcases.country1 = "Ireland";

		testcases.browserClassInstance.setDriver(browser);
		testcases.driver = testcases.browserClassInstance.getDriver();
		testcases.driver.get(url);

	}

	@Test
	public void verifyInvalidCountry() {

		boolean available = testcases.browserClassInstance.selectDropDown(testcases.countryxpath, testcases.country);
		Assert.assertEquals(available, true);

	}

	@Test
	public void verifyValidCountry() {
		boolean available = testcases.browserClassInstance.selectDropDown(testcases.countryxpath, testcases.country1);
		Assert.assertEquals(available, true);

	}
}
