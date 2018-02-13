package com.seleniumtraining.testcaseautomation;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testcases {

	static String countryxpath;
	static String country;
	static WebDriver driver;
	static BrowserInteraction browserClassInstance = new BrowserInteraction();

	@BeforeClass
	static public void setup() {
		String browser = "chrome";
		String url = "https://www.timeanddate.com/calendar/";
		testcases.countryxpath = "//select[@id='sf_country']";
		testcases.country = "irand";

		testcases.browserClassInstance.setDriver(browser);
		testcases.driver = testcases.browserClassInstance.getDriver();
		testcases.driver.get(url);

	}

	@Test
	public void verifyDropDown() {
		boolean available = testcases.browserClassInstance.selectDropDown(testcases.countryxpath, testcases.country);
		System.out.println("TestCase1");
		if (available) {
			System.out.println(testcases.country + " exist in dropdown");
		} else {
			System.out.println(testcases.country + " does not exist in dropdown");
		}

	}

	@Test
	public void selectDropDown() {
		System.out.println("TestCase2");
		boolean available = testcases.browserClassInstance.selectDropDown(testcases.countryxpath, testcases.country);
		if (available) {
			System.out.println("Value selected");
		} else {
			System.out.println("No value exists");
		}

	}
}
