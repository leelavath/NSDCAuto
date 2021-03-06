package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PMKVY_SPPMUpage {
	WebDriver driver;
	@FindBy(xpath="//div[div[p[text()='View All Scheme Add Requests']]]")
	private WebElement ViewAllSchemeAddRequestsIcon;
	//
	public  PMKVY_SPPMUpage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//
	public void ClickOnViewAllSchemeAddRequests()
	{
		ViewAllSchemeAddRequestsIcon.click();
	}
}
