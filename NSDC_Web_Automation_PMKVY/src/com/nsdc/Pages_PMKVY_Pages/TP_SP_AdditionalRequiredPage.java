package com.nsdc.Pages_PMKVY_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TP_SP_AdditionalRequiredPage {
	WebDriver driver;
    @FindBy(xpath="(//input[@id='customFile'])[1]")
    private WebElement Dual_logoBrowseButton;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
    private WebElement Dual_logoUpLoadButton;
    @FindBy(xpath="(//input[@id='customFile'])[1]")
    private WebElement Other_TermSheetBrowseButton;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
    private WebElement Other_TermSheetUpLoadButton;
    
    @FindBy(xpath="(//input[@id='customFile'])[2]")
    private WebElement TPSigned_TermSheetBrowseButton;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
    private WebElement TPSigned_TermSheetUpLoadButton;
    
    
    
    
    
    @FindBy(xpath="(//input[@id='customFile'])[2]")
    private WebElement    IndemnityBrowseButton;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
    private WebElement IndemnityBrowseUpLoadButton;
    
    
    
    @FindBy(xpath="//select[@formcontrolname='status']")
    private WebElement   ReviewDropDownList;
    @FindBy(xpath="//button[text()='Download Termsheet']")
    private WebElement  DownloadTermsheetButton;
    
    @FindBy(xpath="//button[text()='Save & Submit']")
    private WebElement   SaveAndSubmitButton;
    
    
    public TP_SP_AdditionalRequiredPage(WebDriver driver)
    {
   	 this.driver = driver;
   	 PageFactory.initElements(driver, this);
    }

    public void ClickOnDual_logoBrowse()
    {
    	Dual_logoBrowseButton.click();
    }
    public void ClickOnDual_logoUpLoad()
    {
    	Dual_logoUpLoadButton.click();
    }
    public void ClickOnOther_TermSheetBrowse()
    {
    	Other_TermSheetBrowseButton.click();
    }
    public void clickOnOther_TermSheetUpLoad()
    {
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", Other_TermSheetUpLoadButton);
    	//Other_TermSheetUpLoadButton.click();
    }
    
    
    
    public void ClickOnIndemnityBrowse()
    {
//    	JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", Signed_TermSheetBrowseButton);
    	IndemnityBrowseButton.click();
    }
    public void ClickOnIndemnityBrowseUpLoad()
    {
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", IndemnityBrowseUpLoadButton);
    	//Signed_TermSheetUpLoadButton.click();
    }
    
    public void ClickOnTPSigned_TermSheetBrowse()
    {
    	TPSigned_TermSheetBrowseButton.click();
    }
    public void clickOnTPSigned_TermSheetUpLoad()
    {
    	TPSigned_TermSheetUpLoadButton.click();
    }
    
    
    
    
    
    public void SelectReview(String review)
    
    {
    	SelectDropDownList.selectDropDownListByVisibleText(ReviewDropDownList, review);
    }
 public void SelectComments(String comments)
    
    {
    	SelectDropDownList.selectDropDownListByVisibleText(ReviewDropDownList, comments);
    }
 public void ClickOnDownloadTermsheet()
 {
	 DownloadTermsheetButton.click();
 }
    public void ClickSaveAndSubmit()
    {
    	SaveAndSubmitButton.click();
    }
    
}
