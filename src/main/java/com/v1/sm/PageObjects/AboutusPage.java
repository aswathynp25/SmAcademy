package com.v1.sm.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AboutusPage extends BasePage {
@FindBy(xpath="//h4[contains(text(),'Start your coaching')]")
public WebElement Start_your_Coaching;

@Override
protected ExpectedCondition getPageLoadConditions() {
	// TODO Auto-generated method stub
	return ExpectedConditions.visibilityOf(Start_your_Coaching);
}	

}
