package com.v1.sm.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.v1.sm.Base.BaseTest;
import com.v1.sm.PageObjects.LoginPage;
import com.v1.sm.PageObjects.WebsitePage;
import com.v1.sm.utilities.Constants;
import com.v1.sm.utilities.DataProviders;
import com.v1.sm.utilities.DataUtil;
import com.v1.sm.utilities.ExcelReader;

public class ValidateAboutusTest  extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void ValidateAboutusTest(Hashtable<String, String> data){

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "ValidateAboutusTest", data.get("Runmode"), excel);

		openBrowser(data.get("browser"));
		logInfo("Launched Browser:" + data.get("browser"));
		WebsitePage wbp = new WebsitePage().open("http://sm-academy-beta.wepedhd2vx.ap-south-1.elasticbeanstalk.com");
		wbp.gotoAboutus();
		 Assert.fail("Failing the aboutus Test");	
	}

	@AfterMethod
	public void TearDown() {
		logInfo("AboutUs page Validated");
		quit();
	}
}
