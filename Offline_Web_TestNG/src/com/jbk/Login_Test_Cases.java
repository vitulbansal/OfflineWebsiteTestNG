package com.jbk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Login_Test_Cases {
	
	@Test
	public void Blank_User(){
		WebDriver driver = new FirefoxDriver();
		
		driver.get("file:///E:/Selenium/Software%20by%20Kiran/Offline%20Website%20_%20new/index.html");
		String label = driver.findElement(By.xpath("html/body/div[1]/div[2]/p")).getText();
		System.out.println(label);
		
	}
	

}
