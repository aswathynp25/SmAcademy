package com.v1.sm.testcases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.v1.sm.Base.BaseTest;
import com.v1.sm.PageObjects.WebsitePage;
import com.v1.sm.utilities.Constants;
import com.v1.sm.utilities.DataProviders;
import com.v1.sm.utilities.DataUtil;
import com.v1.sm.utilities.ExcelReader;

public class ValidateContactusTest extends BaseTest{

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void ValidateContactusTest(Hashtable<String, String> data){

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "ValidateContactusTest", data.get("Runmode"), excel);

		openBrowser(data.get("browser"));
		logInfo("Launched Browser:" + data.get("browser"));
		WebsitePage wbcp = new WebsitePage().open("http://sm-academy-beta.wepedhd2vx.ap-south-1.elasticbeanstalk.com");
		wbcp.gotoContactus();
		
	}

	@AfterMethod
	public void TearDown() {
		logInfo("AboutUs page Validated");
		quit();
	}
}

	
