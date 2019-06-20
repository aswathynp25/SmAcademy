package com.v1.sm.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.v1.sm.PageObjects.BasePage;


public class LoginPage extends BasePage{
	@FindBy(css="#sm-user-name")
	public WebElement email;
	@FindBy(css="#sm-password")
	public WebElement pass;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement signinbtn;
	
	public LoginPage doLoginAsvaildUser(String username,String password) {
		type(email, username, "Username textbox");
		type(pass, password, "password textbox");
		click(signinbtn, "SignIn Button");
		return this;
	}

	@Override
	protected ExpectedCondition getPageLoadConditions() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(email);
	}}
