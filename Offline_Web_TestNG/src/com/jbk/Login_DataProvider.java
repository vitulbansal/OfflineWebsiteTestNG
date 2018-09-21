package com.jbk;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class Login_DataProvider {
	WebDriver driver;
	WebElement UserName;
	WebElement Password;
	WebElement SignButton;
	WebElement ErrorMessage;

	@BeforeSuite
	public void SetEnvnment() {
		driver = new FirefoxDriver();
		driver.get("file:///E://Selenium//Software%20by%20Kiran//Offline%20Website%20_%20new//index.html");
	}

	@BeforeClass
	public void LocateWebElement() {
		UserName = driver.findElement(By.xpath(".//*[@id='email']"));
		Password = driver.findElement(By.xpath(".//*[@id='password']"));
		SignButton = driver.findElement(By.xpath(".//*[@id='form']/div[3]/div/button"));
		ErrorMessage = driver.findElement(By.xpath(".//*[@id='email_error']"));

	}

	@Test(dataProvider = "LoginData")
	public void LoginTestCase(String UName, String Pwd, String ErrorMsg) {
		UserName.sendKeys(UName);
		Password.sendKeys(Pwd);
		SignButton.click();

		String ActualMessage = ErrorMessage.getText();
		System.out.println(ActualMessage);
		assertEquals(ActualMessage, ErrorMsg);

	}

	@DataProvider(name = "LoginData")
	public Object[][] LoginData() {
		return new Object[][] { new Object[] { "", "", "Please enter email." },
				new Object[] { "vitul@gmail.com", "", "Please enter email as kiran@gmail.com" }, };
	}

	@AfterSuite
	public void CloseBrowser() {
		driver.close();
	}
}
