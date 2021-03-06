package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nsdc.generic.SelectDropDownList;

public class NSDC_RozgarMelaSPOC_CreateRozgarMelaPage
{
	WebDriver driver;
	@FindBy(id="name")
	private WebElement rozgarMelaNameTextField;
	@FindBy(id="typeOfMela")
	private WebElement typeOfRozgarMelaDropdownList;
	@FindBy(id="targetAudience")
	private WebElement targetAudienceDropdownList;
	@FindBy(id="chiefGuestTitle")
	private WebElement chiefGuestTitleDropdownList;
	@FindBy(id="chiefGuestSalutation")
	private WebElement chiefGuestSalutationDropdownList;
	@FindBy(id="chiefGuestName")
	private WebElement chiefGuestNameTextField;
	@FindBy(id="eligibilityCriteria")
	private WebElement eligibilityCriteriaDropdownList;
	@FindBy(xpath="//input[@placeholder='Select Start Date']")
	private WebElement rozgarMelaStartDateTextField;
	@FindBy(xpath="//input[@placeholder='Select End Date']")
	private WebElement rozgarMelaEndDateTextField;
	@FindBy(name="startTime")
	private WebElement rozgarMelaStartTimeTextField;
	@FindBy(name="endTime")
	private WebElement rozgarMelaEndTimeTextField;
	@FindBy(xpath="//textarea[@placeholder='Enter Address']")
	private WebElement rozgarMelaAddressTextField;
	@FindBy(id="landmark")
	private WebElement landmarkTextfield;
	@FindBy(id="pincode")
	private WebElement pincodeTextField;
	@FindBy(id="state")
	private WebElement stateDropdownList;
	@FindBy(id="district")
	private WebElement districtDropdownList;
	@FindBy(id="tehsil")
	private WebElement tehsilDropdownList;
	@FindBy(id="city")
	private WebElement cityVillageDropdownList;
	@FindBy(id="parliamentaryConstituency")
	private WebElement parliamentaryConstituencyDropdownList;
	@FindBy(xpath="//input[@placeholder='Enter Area Name']")
	private WebElement geoLocationTextField;
	@FindBy(id="additionalRemarks")
	private WebElement additionalRemarksTextArea;
	@FindBy(xpath="//button[contains(text(),'Next')]")
	private WebElement createMelaAndAlignTrainingCentreButton;
	@FindBy(xpath="//button[contains(text(),'cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	@FindBy(xpath="//label[contains(text(),'Mela Daily Timing')]")
	private WebElement melaDailyTimingLabelText;
	//Align Training Centres
	@FindBy(xpath="//th[label[input[@type='checkbox']]]")
	private WebElement selectAllTrainingCentreCheckbox;
	@FindBy(xpath="//span[contains(text(),'Align Selected Training Centres')]")
	private WebElement alignSelectedTrainingCentresButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath="//button[contains(text(),'Save & Align SSCs')]")
	private WebElement saveAndAlignSSCsButton;
	//Align SSCs
	@FindBy(xpath="//th[label[input[@type='checkbox']]]")
	private WebElement selectAllSSCsCheckbox;
	@FindBy(xpath="//span[contains(text(),'Align Selected SSCs')]")
	private WebElement alignSelectedSSCsButton;
	//Finally creating Rozgar Mela
	@FindBy(xpath="//button[contains(text(),'Save & Create Rozgar Mela')]")
	private WebElement saveAndCreateRozgarMelaButton;
	@FindBy(xpath="//button[contains(text(),'Announce')]")
	private WebElement announceToStakeholdersButton;
	
	public NSDC_RozgarMelaSPOC_CreateRozgarMelaPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterRozgarMelaName(String rozgarMelaName)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(rozgarMelaNameTextField));
		rozgarMelaNameTextField.clear();
		rozgarMelaNameTextField.sendKeys(rozgarMelaName);
	}
	public void selectTypeOfRozgarMela(String typeOfRozgarMela)
	{
		SelectDropDownList.selectDropDownListByVisibleText(typeOfRozgarMelaDropdownList, typeOfRozgarMela);
	}
	public void selectTargetAudience(String targetAudience)
	{
		if(targetAudience.equalsIgnoreCase("PMKVY (Centre)"))
		{
			driver.findElement(By.xpath("(//label[input[@type='checkbox']])[1]")).click();
		}
		else if(targetAudience.equalsIgnoreCase("PMKVY (State)"))
		{
			driver.findElement(By.xpath("(//label[input[@type='checkbox']])[2]")).click();
		}
		else if(targetAudience.equalsIgnoreCase("PMKK")) 
		{
			driver.findElement(By.xpath("(//label[input[@type='checkbox']])[3]")).click();
		}
		else if(targetAudience.equalsIgnoreCase("Fee Based")) 
		{
			driver.findElement(By.xpath("(//label[input[@type='checkbox']])[4]")).click();
		}
		else 
		{
			driver.findElement(By.xpath("(//label[input[@type='checkbox']])[5]")).click();
		}
	}
	public void selectChiefGuestTitle(String chiefGuestTitle)
	{
		SelectDropDownList.selectDropDownListByVisibleText(chiefGuestTitleDropdownList, chiefGuestTitle);
	}
	public void selectChiefGuestSalutation(String chiefGuestSalutation)
	{
		SelectDropDownList.selectDropDownListByVisibleText(chiefGuestSalutationDropdownList, chiefGuestSalutation);
	}
	public void enterChiefGuestName(String chiefGuestName)
	{
		chiefGuestNameTextField.clear();
		chiefGuestNameTextField.sendKeys(chiefGuestName);
	}
	public void selectEligibilityCriteria(String eligibilityCriteria)
	{
		SelectDropDownList.selectDropDownListByVisibleText(eligibilityCriteriaDropdownList, eligibilityCriteria);
	}
	public void chooseRozgarMelaStartDate()
	{
		rozgarMelaStartDateTextField.sendKeys(Keys.ARROW_RIGHT,Keys.ENTER);
	}
	public void chooseRozgarMelaEndDate()
	{
		rozgarMelaEndDateTextField.sendKeys(Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ENTER);
	}
	public void enterRozgarMelaStartTime(String startTime) throws InterruptedException
	{
		rozgarMelaStartTimeTextField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
		Thread.sleep(2000);
		rozgarMelaStartTimeTextField.sendKeys(startTime);
	}
	public void enterRozgarMelaEndTime(String endTime) throws InterruptedException
	{
		rozgarMelaEndTimeTextField.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
		Thread.sleep(2000);
		rozgarMelaEndTimeTextField.sendKeys(endTime);
	}
	public void clickMelaDailyTimingLabelToCloseMelaDurationPickers()
	{
		melaDailyTimingLabelText.click();
	}
	public void enterRozgarMelaAddress(String address)
	{
		rozgarMelaAddressTextField.clear();
		rozgarMelaAddressTextField.sendKeys(address);
	}
	public void enterLandmark(String landmark)
	{
		landmarkTextfield.clear();
		landmarkTextfield.sendKeys(landmark);
	}
	public void enterPincode(String pincode)
	{
		pincodeTextField.clear();
		pincodeTextField.sendKeys(pincode);
	}
	public void selectState(String state)
	{
		SelectDropDownList.selectDropDownListByVisibleText(stateDropdownList, state);
	}
	public void selectDistrict(String district)
	{
		SelectDropDownList.selectDropDownListByVisibleText(districtDropdownList, district);
	}
	public void selectTehsil(String tehsil)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tehsilDropdownList, tehsil);
	}
	public void selectVillage(String village)
	{
		SelectDropDownList.selectDropDownListByVisibleText(cityVillageDropdownList, village);
	}
	public void selectParlimentaryConstituency(String parlimentaryConstituency)
	{
		SelectDropDownList.selectDropDownListByVisibleText(parliamentaryConstituencyDropdownList, parlimentaryConstituency);
	}
	public void enterGeoLocation(String geoLocation)
	{
		geoLocationTextField.clear();
		geoLocationTextField.sendKeys(geoLocation);
	}
	public void clickDisplayedGeoLocationSugestions(String geoLocation)
	{
		driver.findElement(By.xpath("(//span[contains(text(),'"+geoLocation+"')])[1]")).click();
	}
	public void enterAdditionalRemarks(String additionalRemarks)
	{
		additionalRemarksTextArea.clear();
		additionalRemarksTextArea.sendKeys(additionalRemarks);
	}
	public void clickToCreateMelaAndAlignTrainingCentre()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createMelaAndAlignTrainingCentreButton));
		createMelaAndAlignTrainingCentreButton.click();
	}
	public void clickToCancel()
	{
		cancelButton.click();
	}
	public void clickToGoBack()
	{
		goBackButton.click();
	}
	//Align TC
	public void clickToSelectAllTrainingCentres()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(selectAllTrainingCentreCheckbox));
		selectAllTrainingCentreCheckbox.click();
	}
	public void clickToAlignSelectedTrainingCentres()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(alignSelectedTrainingCentresButton));
		alignSelectedTrainingCentresButton.click();
	}
	public void clickOK()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(okButton));
		okButton.click();
	}
	public void clickSaveAndAlignSSCs()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(saveAndAlignSSCsButton));
		saveAndAlignSSCsButton.click();
	}
	//Align SSCs
	public void clickToSelectAllSSCs()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[label[input[@type='checkbox']]]")));
		selectAllSSCsCheckbox.click();
	}
	public void clickToAlignSelectedSSCs()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Align Selected SSCs')]")));
		alignSelectedSSCsButton.click();
	}
	//finally creating rozgar mela
	public void clickToSaveAndCreateRozgarMela()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(saveAndCreateRozgarMelaButton));
		saveAndCreateRozgarMelaButton.click();
	}
	public void clickAnnounceToStakeholders()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",announceToStakeholdersButton);
	}
}