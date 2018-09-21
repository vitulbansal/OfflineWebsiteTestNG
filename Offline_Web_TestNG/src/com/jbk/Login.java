package com.jbk;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertEquals;

public class Login {
	Common_Functions CFunc = new Common_Functions();
	
		//Locators
	    String appURL = "file:///E://Selenium//Software%20by%20Kiran//Offline%20Website%20_%20new//index.html";
		String UserName = ".//*[@id='email']";
		String Password = ".//*[@id='password']";
		String SignButton = ".//*[@id='form']/div[3]/div/button";
		String ErrorMessageEmail = ".//*[@id='email_error']";
		String ErrorMessagePassword = ".//*[@id='password_error']";
		
	
	//To verify the error message when user try to login by putting blank Email
	@Test(priority=1)
	public void Blank_UserID() {
		
	  CFunc.button_click("xpath", SignButton);
	  String ExpectedUserError = "Please enter email.";
	  String GetText = CFunc.Label_Text("xpath", ErrorMessageEmail);
	  String ActualUserError = GetText;
	  assertEquals(ExpectedUserError, ActualUserError);	  
  }
	  
	 //To verify the error message when user try to login by putting blank Password
	  @Test(priority=2)
	  public void Blank_Pwd(){
	  CFunc.button_click("xpath", SignButton);
	  String ExpectedPwdError = "Please enter password.";
	  String GetText = CFunc.Label_Text("xpath", ErrorMessagePassword);
	  String ActualPwdError = GetText;
	  assertEquals(ExpectedPwdError, ActualPwdError);
	  }
	    
	  //To verify by entering the correct Email & Password
	  @Test(priority=3)
	  public void CorrectUserPwd(){
		  CFunc.enter_text("xpath", UserName, "kiran@gmail.com");		  
		  CFunc.enter_text("xpath", Password, "123456");		  
		  CFunc.button_click("xpath", SignButton);		  
		  String GetText = CFunc.Title_Text();
		  String ActualTitle = GetText;
		  System.out.println(ActualTitle);
		  String ExpectedTitle = "AdminLTE 2 | Dashboard";
		  assertEquals(ActualTitle, ExpectedTitle);		  
	  }
	  
	  //To verify by entering Email ID other kiran@gmail.com
	  @Test(priority=4)
	  public void InVaildEmailID(){
		  
	  CFunc.enter_text("xpath", UserName, "vitul@gmail.com");	  
	  CFunc.button_click("xpath", SignButton);
	  String ExpectedUserError = "Please enter email as kiran@gmail.com";	  
	  String ActualUserError = CFunc.Label_Text("xpath", ErrorMessageEmail);
	  assertEquals(ExpectedUserError, ActualUserError);
	  }
	  
	  @Test(priority=5)
	  public void InvalidPwd(){
	
	  CFunc.enter_text("xpath", Password, "1234567890");	  
	  CFunc.button_click("xpath", SignButton);
	  String ExpectedPwdError = "Please enter password 123456";	  
	  String ActualPwdError = CFunc.Label_Text("xpath", ErrorMessagePassword);
	  assertEquals(ExpectedPwdError, ActualPwdError);
	  }
	  
	  	  
  @BeforeMethod
  public void beforeMethod() {
	  CFunc.open_browser("Mozilla");
	  CFunc.get_url(appURL);
  }

  @AfterMethod
  public void afterMethod() {
	  CFunc.close_browser();
  }

}
