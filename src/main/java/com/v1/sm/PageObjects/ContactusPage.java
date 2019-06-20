package com.v1.sm.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactusPage extends BasePage {
@FindBy(xpath="//h3[contains(text(),'KOCHI')]")
public WebElement KOCHI;

@Override
protected ExpectedCondition getPageLoadConditions() {
	// TODO Auto-generated method stub
	return ExpectedConditions.visibilityOf(KOCHI);
}
}
