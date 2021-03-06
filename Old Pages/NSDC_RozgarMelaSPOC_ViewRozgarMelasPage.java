package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nsdc.generic.SelectDropDownList;

public class NSDC_RozgarMelaSPOC_ViewRozgarMelasPage
{
	WebDriver driver;
	@FindBy(id="tierOne")
	private WebElement tierOneMelasButton;
	@FindBy(xpath="//button[contains(text(),'Tier 2 Melas')]")
	private WebElement tierTwoMelasButton;
	@FindBy(xpath="//button[contains(text(),'Tier 3 Melas')]")
	private WebElement tierThreeMelasButton;
	@FindBy(name="state")
	private WebElement stateFilterDropdownList;
	@FindBy(name="district")
	private WebElement districtFilterDropdownList;
	@FindBy(name="status")
	private WebElement statusFilterDropdownList;
	@FindBy(id="fullDate")
	private WebElement startDateFilterTextField;
	@FindBy(id="fullDate1")
	private WebElement endDateFilterTextField;
	@FindBy(id="Search")
	private WebElement searchByRozgarMelaIdTextField;
	@FindBy(xpath="//button[contains(text(),'Apply Filters')]")
	private WebElement applyFiltersButton;
	@FindBy(xpath="//button[contains(text(),'Reset')]")
	private WebElement resetButton;
	@FindBy(xpath="//a[i[@class='la la-ellipsis-h']]")
	private WebElement actionMenuDropdown;
	@FindBy(xpath="//span[contains(text(),'View Details')]")
	private WebElement viewDetailsOption;
	@FindBy(xpath="(//span[contains(text(),'Download Report')])[1]")
	private WebElement downloadReportOption;
	@FindBy(xpath="//span[contains(text(),'Re-Schedule Mela')]")
	private WebElement reScheduleMelaOption;
	@FindBy(xpath="//span[contains(text(),'Cancel Mela')]")
	private WebElement cancelMelaOption;
	@FindBy(xpath="//span[contains(text(),'Close Candidate Enrollment')]")
	private WebElement closeCandidateEnrollmentOption;
	@FindBy(xpath="//button[contains(text(),'Download Report')]")
	private WebElement downloadReportButton;
	@FindBy(xpath="//button[contains(text(),'Create a Rozgar Mela')]")
	private WebElement createRozgarMelaButton;
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	private WebElement dashboardTextLink;
	@FindBy(xpath="//button[contains(text(),'Cancel Rozgar Mela')]")
	private WebElement cancelRozgarMelaButton;
	@FindBy(xpath="//button[contains(text(),'Continue to View All Melas')]")
	private WebElement continueToViewAllMelasButton;
	@FindBy(xpath="//input[@placeholder='Select Start Date']")
	private WebElement rozgarMelaRescheduleStartDateTextField;
	@FindBy(xpath="//input[@placeholder='Select End Date']")
	private WebElement rozgarMelaRescheduleEndDateTextField;
	@FindBy(name="startTime")
	private WebElement rozgarMelaRescheduleStartTimeTextField;
	@FindBy(name="endTime")
	private WebElement rozgarMelaRescheduleEndTimeTextField;
	@FindBy(xpath="//label[contains(text(),'Mela Daily Timing')]")
	private WebElement melaDailyTimingLabelText;
	@FindBy(xpath="//button[contains(text(),'Update & Announce')]")
	private WebElement update_AnnounceButton;
	@FindBy(xpath="//button[contains(text(),'Announce to Stakeholders')]")
	private WebElement announceToStakeHoldersButton;
	@FindBy(xpath="(//button[contains(text(),'Update & Announce')])[2]")
	private WebElement finalUpdate_AnnounceButton;
		
	public NSDC_RozgarMelaSPOC_ViewRozgarMelasPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickTireOne()
	{
		tierOneMelasButton.click();
	}
	public void clickTierTwoMelas()
	{
		tierTwoMelasButton.click();
	}
	public void clickTierThreeMelas()
	{
		tierThreeMelasButton.click();
	}
	public void selectStateFilterOption(String stateFilterOption)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateFilterDropdownList, stateFilterOption);
	}
	public void selectDistrictFilterOption(String districtFilterOption)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtFilterDropdownList, districtFilterOption);
	}
	public void selectStatusFilterOption(String statusFilterOption)
	{
		SelectDropDownList.selectDropDownListByVisibleText(statusFilterDropdownList, statusFilterOption);
	}
	public void enterStartDateFilter(String startDate)
	{
		startDateFilterTextField.clear();
		startDateFilterTextField.sendKeys(startDate);
	}
	public void enterEndDateFilter(String endDate)
	{
		endDateFilterTextField.clear();
		endDateFilterTextField.sendKeys(endDate);
	}
	public void enterRozgarMelaIDToSearch(String rozgarMelaID)
	{
		searchByRozgarMelaIdTextField.clear();
		searchByRozgarMelaIdTextField.sendKeys(rozgarMelaID);
	}
	public void clickToApplyFilters()
	{
		applyFiltersButton.click();
	}
	public void clickToResetFilters()
	{
		resetButton.click();
	}
	public void clickActionMenu()
	{
		actionMenuDropdown.click();
	}
	public void clickToChooseViewDetailsOption()
	{
		viewDetailsOption.click();
	}
	public void clickToChooseDownloadReportOption()
	{
		downloadReportOption.click();
	}
	public void clickToChooseRescheduleMelaOption()
	{
		reScheduleMelaOption.click();
	}
	public void clickToChooseCancelMelaOption()
	{
		cancelMelaOption.click();
	}
	public void clickToChooseCloseCandidateEnrollmentOption()
	{
		closeCandidateEnrollmentOption.click();
	}
	public void clickToDownloadReport()
	{
		downloadReportButton.click();
	}
	public void clickCreateArozgarMela()
	{
		createRozgarMelaButton.click();
	}
	public void clickToFinallyCancelRozgarMela()
	{
		cancelRozgarMelaButton.click();
	}
	public void clickContinueToViewAllMelas()
	{
		continueToViewAllMelasButton.click();
	}
	//Reschedule
	public void chooseRozgarMelaRescheduleStartDate()
	{
		rozgarMelaRescheduleStartDateTextField.sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER);
	}
	public void chooseRozgarMelaRescheduleEndDate()
	{
		rozgarMelaRescheduleEndDateTextField.sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER);
	}
	public void enterRozgarMelaRescheduleStartTime(String startTime) throws InterruptedException
	{
		rozgarMelaRescheduleStartTimeTextField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
		Thread.sleep(2000);
		rozgarMelaRescheduleStartTimeTextField.sendKeys(startTime);
	}
	public void enterRozgarMelaRescheduleEndTime(String endTime) throws InterruptedException
	{
		rozgarMelaRescheduleEndTimeTextField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
		Thread.sleep(2000);
		rozgarMelaRescheduleEndTimeTextField.sendKeys(endTime);
	}
	public void clickMelaDailyTimingLabelToCloseMelaRescheduleDurationPickers()
	{
		melaDailyTimingLabelText.click();
	}
	public void clickToUpdateAndAnnounce()
	{
		update_AnnounceButton.click();
	}
	public void clickToFinallyUpdateAndAnnounceRescheduledMela()
	{
		finalUpdate_AnnounceButton.click();
	}
	public String dateFormat(String date)
	{
		String parts[]=date.split("-");
		String day=parts[0];
		if(day.startsWith("0"))
		{
			day=day.replace("0", "");
		}
		String month=parts[1];
		if(month.startsWith("0"))
		{
			month=month.replaceAll("0", "");
		}
		String year=parts[2];
		String reformedRescheduledDate=day+"-"+month+"-"+year;
		return reformedRescheduledDate;
	}
	public String timeFormat(String time)
	{
		String timea="";
		String parts[]=time.split(":");
		int hh = Integer.parseInt(parts[0]); 
		String meridian="";
		if(hh<12)
		{
			meridian="AM";
		}
		else
		{
			meridian="PM";
		}
		hh %= 12; 
		if (hh == 0)
		{ 
			timea="12:"+parts[1]+" "+meridian; 
		}
		else if(hh == 10)
		{
			timea="10:"+parts[1]+" "+meridian; 
		}
		else
		{ 
			timea="0"+hh+":"+parts[1]+" "+meridian; 
		} 
		return timea;
	}
}