package com.v1.sm.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.v1.sm.utilities.DriverManager;
import com.v1.sm.PageObjects.BasePage;

public class WebsitePage extends BasePage{
	@FindBy(xpath="//a[contains(@href, '/about_us')]")
	public WebElement Aboutus;
	
	@FindBy(xpath="//a[@class='text-white font-weight-600 sma-info'][contains(text(),'Contact us')]")
	public WebElement Contactus;
	
	@FindBy(xpath="//a[@id='button-sign-in']")
	public WebElement SignIn;
	
	public WebsitePage open(String url) {
		DriverManager.getDriver().navigate().to(url);
		return (WebsitePage) openPage(WebsitePage.class);
	}

	public LoginPage gotoLogin() {
		click(SignIn, "LoginLink");
		return (LoginPage) openPage(LoginPage.class);
	}
	
	public AboutusPage gotoAboutus() {
		click(Aboutus, "AboutusLink");
		return (AboutusPage) openPage(AboutusPage.class);
	}
	
	public ContactusPage gotoContactus() {
		click(Contactus, "ContactusLink");
		return (ContactusPage) openPage(ContactusPage.class);
	}
	
	@Override
	protected ExpectedCondition getPageLoadConditions() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(SignIn);
	}
}
