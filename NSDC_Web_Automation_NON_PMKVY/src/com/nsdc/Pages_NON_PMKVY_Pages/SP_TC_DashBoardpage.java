package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SP_TC_DashBoardpage 
{
WebDriver driver;

	@FindBy(xpath="(//span[@class='m-menu__link-text'])[3]")
	private WebElement MySchemeIcon;
	
	
	
	public SP_TC_DashBoardpage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnMyScheme()
	{
		MySchemeIcon.click();
	}
	

}


