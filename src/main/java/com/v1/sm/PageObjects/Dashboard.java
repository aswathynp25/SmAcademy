package com.v1.sm.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard {
	@FindBy(xpath=".//*[normalize-space(text()) and normalize-space(.)='Upcoming session'])[1]/preceding::i[1]")
	public WebElement upcoming_sessions;
	
}
