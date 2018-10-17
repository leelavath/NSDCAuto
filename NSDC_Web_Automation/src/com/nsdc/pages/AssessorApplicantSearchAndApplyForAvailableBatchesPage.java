package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.AddingDaysToCurrentDate;
import com.nsdc.generic.SelectDropDownList;

public class AssessorApplicantSearchAndApplyForAvailableBatchesPage
{
	WebDriver driver;
	@FindBy(linkText="View all Batches")
	private WebElement viewAllBatchesLink;
	@FindBy(xpath="//select[@formcontrolname='state']")
	private WebElement stateOrUtDropdownList;
	@FindBy(xpath="//select[@formcontrolname='district']")
	private WebElement districtDropdownList;
	@FindBy(xpath="//select[@formcontrolname='subDistrict']")
	private WebElement subDistrictDropdownList;
	@FindBy(xpath="//select[@formcontrolname='sector']")
	private WebElement sectorDropdownList;
	@FindBy(xpath="//select[@formcontrolname='subSector']")
	private WebElement subSectorDropdownList;
	@FindBy(xpath="//select[@title='Select Job Role']")
	private WebElement jobRoleDropdownList;
	@FindBy(xpath="//select[@title='Select Batch Type']")
	private WebElement batchTypeDropdownList;
	@FindBy(xpath="//select[@title='Select Batch Status']")
	private WebElement batchStatusDropdownList;
	@FindBy(id="totApplicantStartDate")
	private WebElement batchStartDateTextbox;
	@FindBy(id="totApplicantEndDate")
	private WebElement batchEndDateTextbox;
	@FindBy(xpath="(//div[@class='input-group-append'])[1]")
	private WebElement closeBatchStartDateCalender;
	@FindBy(xpath="(//div[@class='input-group-append'])[2]")
	private WebElement closeBatchEndDateCalender;
	@FindBy(xpath="//button[contains(text(),'Search')]")
	private WebElement searchButton;
	@FindBy(linkText="Edit My Search Parameters")
	private WebElement editMySearchParametersLink;
	@FindBy(xpath="//input[@placeholder='Search by keyword']")
	private WebElement searchForBatchTextbox;
	@FindBy(xpath="//div[@class='dropdown dropup']")
	private WebElement actionDropdownMenu;
	@FindBy(linkText="View Details")
	private WebElement viewDetailsOption;
	@FindBy(linkText="Apply to the batch")
	private WebElement applyToTheBatchOption;
	@FindBy(xpath="//button[contains(text(),'Apply for the Batch')]")
	private WebElement applyForBatchButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[1]")
	private WebElement applicantDashboardLink;
	
	public AssessorApplicantSearchAndApplyForAvailableBatchesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickToGoToApplicantDashboard()
	{
		applicantDashboardLink.click();
	}
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateOrUtDropdownList, state);
	}
	public void selectDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropdownList,district);
	}
	public void selectSubDistrict(String subDistrict)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subDistrictDropdownList,subDistrict);
	}
	public void selectSector(String sector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(sectorDropdownList,sector);
	}
	public void selectSubSector(String subSector)
	{
		SelectDropDownList.selectDropDownListByVisibleText(subSectorDropdownList,subSector);
	}
	public void selectjobRole(String jobrole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleDropdownList,jobrole);
	}
	public void selectBatchType(String batchType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchTypeDropdownList,batchType);
	}
	public void selectBatchStatus(String batchStatus)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchStatusDropdownList,batchStatus);
		//batchStatusDropdownList.sendKeys(Keys.TAB);
	}
	public void enterBatchStartDate()
	{
		batchStartDateTextbox.sendKeys(AddingDaysToCurrentDate.addDaysToCurrentDate(16));
	}
	public void enterBatchEndDate()
	{
		batchEndDateTextbox.sendKeys(AddingDaysToCurrentDate.addDaysToCurrentDate(25));
	}
	public void clickToCloseBatchStartDateCalender()
	{
		closeBatchStartDateCalender.click();
	}
	public void clickToCloseBatchEndDateCalender()
	{
		closeBatchEndDateCalender.click();
	}
	public void clickSearch()
	{
		searchButton.click();
	}
	public void enterSearchKeyword(String searchKeyword)
	{
		searchForBatchTextbox.clear();
		searchForBatchTextbox.sendKeys(searchKeyword);
	}
	public void clickAction()
	{
		actionDropdownMenu.click();
	}
	public void selectViewDetails()
	{
		viewDetailsOption.click();
	}
	public void selectApplyToBatch()
	{
		applyToTheBatchOption.click();
	}
	public void clickApplyForBatch()
	{
		applyForBatchButton.click();
	}
	public void clickCancel()
	{
		cancelButton.click();
	}
	public void clickOK()
	{
		okButton.click();
	}
}