package com.v1.sm.testcases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.v1.sm.Base.BaseTest;
import com.v1.sm.PageObjects.LoginPage;
import com.v1.sm.PageObjects.WebsitePage;

import com.v1.sm.utilities.Constants;
import com.v1.sm.utilities.DataProviders;
import com.v1.sm.utilities.DataUtil;
import com.v1.sm.utilities.DriverManager;
import com.v1.sm.utilities.ExcelReader;

public class LoginTest extends BaseTest {
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void loginTest(Hashtable<String,String> data) {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		
		openBrowser(data.get("browser"));	
		logInfo("Launched Browser:"+data.get("browser"));
		WebsitePage home =new WebsitePage().open("http://sm-academy-beta.wepedhd2vx.ap-south-1.elasticbeanstalk.com");
		LoginPage login=home.gotoLogin();
		login.doLoginAsvaildUser(data.get("username"), data.get("password"));
		logInfo("Username entered as " +data.get("username") + " and password Entered as "+data.get("password"));

	}
	
	@AfterMethod
	public void TearDown() {
	logInfo("LoginTest Completed");
	quit();
	}


}
