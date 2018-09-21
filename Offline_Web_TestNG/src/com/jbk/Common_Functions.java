package com.jbk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Common_Functions {
	
	WebDriver driver;
	
	void open_browser(String BName) {
		if(BName.equals("Mozilla")){
			
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} 
		else if (BName.equals("Chrome")){
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} 
	}
	
	void close_browser() {
		driver.close();
	}
	
	void get_url(String URL){
		driver.get(URL);
	}
	
	String Label_Text(String LocValue, String LocData){
		
		String GetText=null;		
		
		if(LocValue.equals("id")){
			GetText = driver.findElement(By.id(LocData)).getText();
		}
		
		else if (LocValue.equals("xpath")) {
				
			GetText = driver.findElement(By.xpath(LocData)).getText();
			
		}	
		return GetText;
		
	}
	
	String Title_Text(){
		
		String GetText=null;		
		
		GetText = driver.getTitle();
		return GetText;
		
	}
	
	void enter_text(String LocType, String LocValue, String LocData){
		
		if(LocType.equals("id")){
			driver.findElement(By.id(LocValue)).sendKeys(LocData);
		}
		
		else if (LocType.equals("xpath")) {
			
			driver.findElement(By.xpath(LocValue)).sendKeys(LocData);			
		}
		
	}
	
	void button_click(String LocValue, String LocData){
		
		if(LocValue.equals("id")){
			driver.findElement(By.id(LocData)).click();
		}
		
		else if (LocValue.equals("xpath")) {
				
			driver.findElement(By.xpath(LocData)).click();		
		}	
		
	}
	
	void drop_down (String LocType, String LocValue, String LocData){
		if (LocType.equals("id")){
			WebElement ele = driver.findElement(By.id(LocValue));
			Select ss = new Select(ele);
			ss.selectByVisibleText(LocData);
		}
		else if (LocType.equals("xpath")){
			WebElement ele = driver.findElement(By.xpath(LocValue));
			Select ss = new Select(ele);
			ss.selectByVisibleText(LocData);
		}
	}
	
	void hyper_link(String LocValue, String LocData){
		
		if(LocValue.equals("id")){
			driver.findElement(By.id(LocData)).click();
		}
		
		else if (LocValue.equals("xpath")) {
			
			driver.findElement(By.xpath(LocData)).click();		
		}	
	}
	
	void radio_button(String LocValue, String LocData){
		
		if(LocValue.equals("id")){
			driver.findElement(By.id(LocData)).click();
		}
		
		else if (LocValue.equals("xpath")) {
			
			driver.findElement(By.xpath(LocData)).click();		
		}	
	}
	
 }
