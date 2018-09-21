package com.jbk;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class Login_DP_Excel {
	
	//Locators
    String appURL = "file:///E://Selenium//Software%20by%20Kiran//Offline%20Website%20_%20new//index.html";
	String UserName = ".//*[@id='email']";
	String Password = ".//*[@id='password']";
	String SignButton = ".//*[@id='form']/div[3]/div/button";
	String ErrorMessageEmail = ".//*[@id='email_error']";
	String ErrorMessagePassword = ".//*[@id='password_error']";
	
	Common_Functions CFunc = new Common_Functions();
		
	@BeforeMethod
	public void Open_App(){
		CFunc.open_browser("Mozilla");
		CFunc.get_url(appURL);		
	}
	
	@Test(dataProvider="Login")
	public void VerifyInvalidLogin(String TC_ID, String Test_Description,String UserN, String Pwd, String ExpectedErrorMsg) {		
		CFunc.enter_text("xpath", UserName, UserN);
		CFunc.enter_text("xpath", Password, Pwd);
		CFunc.button_click("xpath", SignButton);
		String str = "TC006";
		if (!TC_ID.equals(str)){
			
			String ActualUserError = CFunc.Label_Text("xpath", ErrorMessageEmail);
			String ActualPwdError = CFunc.Label_Text("xpath", ErrorMessagePassword);
			assertEquals(ExpectedErrorMsg, ActualUserError+ActualPwdError);
			System.out.println(TC_ID + Test_Description + UserN + Pwd + ExpectedErrorMsg);
		} else {
			String ActualTitle = CFunc.Title_Text();
			assertEquals(ExpectedErrorMsg, ActualTitle);
		}
				
	}
	
	@DataProvider(name="Login")
	public Object[][] loginData() throws Exception {
		Object[][] arrayObject = getExcelData("C:\\Users\\Bansal\\Documents\\Login_Data.xls","Sheet1");
		return arrayObject;
		
	}
	
	
	public Object[][] getExcelData(String fileName, String sheetName) throws Exception {
		Object[][] arrayExcelData = null;	
	
	FileInputStream fs = new FileInputStream(fileName);
	Workbook wb = Workbook.getWorkbook(fs);
	Sheet sh = wb.getSheet(sheetName);

	int totalNoOfCols = sh.getColumns();
	int totalNoOfRows = sh.getRows();
	
	arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
	
	for (int i= 1 ; i < totalNoOfRows; i++) {

		for (int j=0; j < totalNoOfCols; j++) {
			arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
		}
	}
	return arrayExcelData;
	
	}	
	
	@AfterMethod
	public void Close_App(){
		CFunc.close_browser();
	}

}
