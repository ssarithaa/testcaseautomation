package com.seleniumtraining.testcaseautomation;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class testcases {

	static String countryxpath;
	static String country;
	static WebDriver driver;

	@BeforeClass
	static public void setup() {
		String browser = "chrome";
		String url = "https://www.timeanddate.com/calendar/";
		testcases.countryxpath = "//select[@id='sf_country']";
		testcases.country = "Ireland";

		BrowserInteraction browserClassInstance = new BrowserInteraction();
		browserClassInstance.setDriver(browser);
		testcases.driver = browserClassInstance.getDriver();
		testcases.driver.get(url);

	}

	@Test
	public void selectDropDown() {
		WebElement selectdd = testcases.driver.findElement(By.xpath(testcases.countryxpath));
		Select s = new Select(selectdd);
		List<WebElement> listofelements = s.getOptions();
		// boolean available = false;
		for (WebElement we : listofelements) {

			// if (we.getText().equalsIgnoreCase(testcases.country)) {
			// available = true;
			Assert.assertEquals(we.getText(), (testcases.country));
			// s.selectByVisibleText(we.getText());

			// break;
		}

	}
	// //if (!available) {
	// System.out.println(this.country + " does not exist in dropdown");
}
