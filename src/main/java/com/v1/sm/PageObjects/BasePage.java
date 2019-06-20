package com.v1.sm.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.v1.sm.ExtentListeners.ExtentListeners;
import com.v1.sm.utilities.DriverManager;

public abstract class BasePage <T>{
	protected WebDriver driver;
	
	public BasePage() {
		this.driver=DriverManager.getDriver();
	}
	public T openPage(Class<T> clazz) {
		T page=null;
		driver=DriverManager.getDriver();
		AjaxElementLocatorFactory ajaxElemFactory=new AjaxElementLocatorFactory(driver,10);
		page=PageFactory.initElements(driver,clazz);
		PageFactory.initElements( ajaxElemFactory,page);
		ExpectedCondition pageLoadCondition=((BasePage) page).getPageLoadConditions();
		waitForPageToLoad(pageLoadCondition);
		return page;
		/*
		 * 1st InitPage FActory elements
		 * 2nd Page Load Condition
		 * 
		 * 
		 */
		
		
	}
	private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(pageLoadCondition);
	}
	
	
	
	protected abstract ExpectedCondition getPageLoadConditions();

	public  void click(WebElement element,String elementName) {
		element.click();
		ExtentListeners.testReport.get().info("clicking on:" +elementName);
		
	}
	
	public void type(WebElement element,String value,String elementName) {
		element.sendKeys(value);
		ExtentListeners.testReport.get().info("Typing in: " +elementName +" entered the value as:" +value);
		
	}
}

