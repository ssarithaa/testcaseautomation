package com.seleniumtraining.testcaseautomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BrowserInteraction {
	private WebDriver driver;

	void setDriver(String browser) {
		switch (browser.toLowerCase()) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:/Users/saritha.pattathil/geckodriver.exe");
			this.driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:/Users/saritha.pattathil/chromedriver.exe");
			this.driver = new ChromeDriver();
			break;
		default:
			System.out.println("Unsupported browser");

		}

	}

	WebDriver getDriver() {
		if (this.driver == null) {
			this.setDriver(null);
		}

		return this.driver;

	}

	void selectDropDown(String ddxpath, String valuetoselect) {
		WebElement selectdd = this.driver.findElement(By.xpath(ddxpath));
		Select s = new Select(selectdd);
		List<WebElement> listofelements = s.getOptions();
		boolean available = false;
		for (WebElement we : listofelements) {

			if (we.getText().equalsIgnoreCase(valuetoselect)) {
				available = true;
				s.selectByVisibleText(we.getText());
				System.out.println("Value " + valuetoselect + " exists in dropdown and selected");
				break;
			}

		}
		if (!available) {
			System.out.println(valuetoselect + " does not exist in dropdown");
		}
	}

}
