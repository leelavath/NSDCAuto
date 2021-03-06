package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QC_DashboardPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//div[p[text()='View All Assessment Requests']]")
	private WebElement viewAllAssessmentRequestsButton;
	
	
	
	public QC_DashboardPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnViewAllAssessmentRequest()
	{
		viewAllAssessmentRequestsButton.click();
	}

}
