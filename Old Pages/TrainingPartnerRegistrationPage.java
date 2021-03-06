package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TrainingPartnerRegistrationPage
{
    WebDriver driver;
    
    @FindBy(xpath="//input[@name='organization-name']")
    private WebElement nameOfOrganizationTextBox;
    @FindBy(xpath="(//select[@id='exampleSelect1'])[1]")
    private WebElement typeOfTheOrganizationDropDownList;
    @FindBy(xpath="(//select[@id='exampleSelect1'])[2]")
    private WebElement yearOfEstablishmentDropDownList;
    @FindBy(id="customFile")
    private WebElement browseFileButton;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
    private WebElement uploadFileButton;
    @FindBy(xpath="//input[@name='landline-number']")
    private WebElement landlineNumberTextBox;
    @FindBy(xpath="//input[@name='website']")
    private WebElement websiteTextBox;
    @FindBy(xpath="//input[@name='CEO-name']")
    private WebElement nameOfCeoTextBox;
    @FindBy(xpath="//input[@ng-reflect-name='emailOfHead']")
    private WebElement emailOfCeoTextBox;
    @FindBy(xpath="//input[@ng-reflect-name='mobileOfHead']")
    private WebElement mobileNumberOfCeoTextBox;   
    @FindBy(xpath="//label[@class='m-checkbox m-checkbox--default']")
    private WebElement authorizedSignatoryCheckBox;
    
    @FindBy(xpath="//button[text()='Add Another Authorized Signatory']")
    private WebElement addAnotherSignatoryDetailsButton;
    @FindBy(xpath="//input[@name='auth-signatory-email']")
    private WebElement authorizedSignatoryNameTextbox;
    @FindBy(xpath="(//input[@name='CEO-email'])[2]")
    private WebElement authorizedSignatoryEmailTextbox;
    @FindBy(xpath="//input[@name='auth-sigatory-mobile']")
    private WebElement authorizedSignatoryMobileTextbox;
    
    @FindBy(xpath="(//button[text()='Add Another Authorized Signatory'])[2]")
    private WebElement addAnotherSignatoryDetailsButton2;
    @FindBy(xpath="(//input[@name='auth-signatory-email'])[3]")
    private WebElement authorizedSignatoryNameTextbox2;
    @FindBy(xpath="(//input[@name='CEO-email'])[4]")
    private WebElement authorizedSignatoryEmailTextbox2;
    @FindBy(xpath="(//input[@name='auth-sigatory-mobile'])[3]")
    private WebElement authorizedSignatoryMobileTextbox2;
    
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[1]")
    private WebElement delete_First_AuthorizedSignatoryButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[2]")
    private WebElement delete_Second_AuthorizedSignatoryButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[3]")
    private WebElement delete_Third_AuthorizedSignatoryButton;
    
    @FindBy(xpath="//button[contains(text(),'Save & Next')]")
    private WebElement saveAndNextButton;
    @FindBy(xpath="(//button[@class='btn btn-outline-info'])")
    private WebElement saveAsDraftButton1;
    @FindBy(xpath="(//textarea[@id='m_autosize_1'])[1]")
    private WebElement addressOfTheOrganizationTextBox;
    @FindBy(xpath="(//input[@ng-reflect-name='landmark'])[1]")
    private WebElement nearByLandmarkTextBox;
    @FindBy(xpath="(//input[@name='pincode'])[1]")
    private WebElement pinCodeTextBox;
    @FindBy(xpath="(//select[@name='state'])[1]")
    private WebElement stateDropDownList;
    @FindBy(xpath="(//select[@name='dist'])[1]")
    private WebElement districtDropDownList;
    @FindBy(xpath="(//select[@name='tehsil'])[1]")
    private WebElement tehsilDropDownList;
    @FindBy(xpath="(//select[@name='villlage'])[1]")
    private WebElement cityDropDownList;
    @FindBy(xpath="//input[@id='search_places']")
    private WebElement geoLocationTextBoxTextBox;
    @FindBy(xpath="(//select[@ng-reflect-name='parliamentaryConstituency'])[1]")
    private WebElement parliamentaryConstituencyDropdownList;
    @FindBy(xpath="(//select[@ng-reflect-name='addressProof'])[1]")
    private WebElement addressProofDropDownList;
    @FindBy(xpath="//div[label[contains(text(),'Communication Address Same as Permanent Address:')]]//span")
    private WebElement communicationAddSameAsPermanentAddressCheckbox;
    @FindBy(xpath="(//input[@id='customFile'])[2]")
    private WebElement second_BrowseFileButton;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
    private WebElement second_UploadFileButton;
    
    @FindBy(xpath="//input[@name='account-number']")
    private WebElement panTextbox;
    @FindBy(xpath="//button[contains(text(),'Verify')]")
    private WebElement panVerifyButton;
    @FindBy(xpath="(//input[@id='customFile'])[1]")
    private WebElement browseButton1;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[1]")
    private WebElement uploadButton1;
    @FindBy(xpath="//input[@placeholder='Enter GST Account Number']")
    private WebElement gstTextbox;
    @FindBy(xpath="(//button[contains(text(),'Verify')])[2]")
    private WebElement gst_VerifyButton;
    @FindBy(xpath="(//input[@id='customFile'])[2]")
    private WebElement browseButton2;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
    private WebElement uploadButton2;
    
    @FindBy(xpath="//input[@placeholder='Enter Aadhaar number']")
    private WebElement aadharNumberTextbox;
    @FindBy(xpath="//button[contains(text(),'Verify')]")
    private WebElement verifyAadharNumberButton;
    
    @FindBy(xpath="(//input[@placeholder='Enter Annual Turnover'])[1]")
    private WebElement annualTurnOverTextbox1;
    @FindBy(xpath="(//input[@id='customFile'])[3]")
    private WebElement browseButton3;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[3]")
    private WebElement uploadButton3;
    
    @FindBy(xpath="(//input[@placeholder='Enter Annual Turnover'])[2]")
    private WebElement annualTurnOverTextbox2;
    @FindBy(xpath="(//input[@id='customFile'])[4]")
    private WebElement browseButton4;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[4]")
    private WebElement uploadButton4;
    
    @FindBy(xpath="(//input[@placeholder='Enter Annual Turnover'])[3]")
    private WebElement annualTurnOverTextbox3;
    @FindBy(xpath="(//input[@id='customFile'])[5]")
    private WebElement browseButton5;
    @FindBy(xpath="(//button[contains(text(),'Upload')])[5]")
    private WebElement uploadButton5;   
    
    @FindBy(xpath="//label[@class='m-checkbox m-checkbox--default']")
    private WebElement iAgreeCheckBox;
    @FindBy(xpath="//button[text()='Save & Continue']")
    private WebElement saveAndContinueToPaymentButton;
    @FindBy(xpath="//button[contains(text(),'Save & Continue')]")
    private WebElement saveAndContinueButton;
    @FindBy(xpath="//button[text()='OK']")
    private WebElement okButton;
    @FindBy(xpath="//button[contains(text(),'Logout')]")
    private WebElement logOutButton;
    @FindBy(xpath="//button[(text()='Download Submitted Form')]")
    private WebElement downloadButton;
    @FindBy(xpath="//button[text()='Go to Dashboard']")
    private WebElement goToDashboardPageButton;
    @FindBy(xpath="//button[(text()='Download Receipt')]")
    private WebElement downloadReceiptButton;
    @FindBy(xpath="//button[text()='Continue']")
    private WebElement continueButton;
    
    @FindBy(xpath="(//label[input[@formcontrolname='approvalstatus']]/span)[1]")
    private WebElement aa_ApprovalProcessRadioButton;
    @FindBy(xpath="(//label[input[@formcontrolname='approvalstatus']]/span)[2]")
    private WebElement nonaa_ApprovalProcessRadioButton;
    @FindBy(xpath="//select[@formcontrolname='scheme']")
    private WebElement schemeDropDownList;
    @FindBy(xpath="//input[@formcontrolname='projectID']")
    private WebElement proposalIDTextbox;
    @FindBy(xpath="//button[contains(text(),'Submit')]")
    private WebElement submit_Button;
    @FindBy(xpath="//button[contains(text(),'Save As Draft')]")
    private WebElement saveAsDraftButton;
    
    public TrainingPartnerRegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterNameOfOrganizationTextBox(String name_Of_Organization)
    {
        nameOfOrganizationTextBox.clear();
        nameOfOrganizationTextBox.sendKeys(name_Of_Organization);
    }
    public void selectTypeOfTheOrganization(String type_Of_The_Organization)
    {
        SelectDropDownList.selectDropDownListByVisibleText(typeOfTheOrganizationDropDownList, type_Of_The_Organization);
    }
    
    public void selectYearOfEstablishment(String year_Of_Establishment)
    {
        SelectDropDownList.selectDropDownListByVisibleText(yearOfEstablishmentDropDownList, year_Of_Establishment);
    }
    
    public void clickBrowseFile()
    {
        browseFileButton.click();
    }
    
    public void clickUploadFile()
    {
        uploadFileButton.click();
    }
    
    public void enterLandline(String landLine)
    {
        landlineNumberTextBox.clear();
        landlineNumberTextBox.sendKeys(landLine);
    }
    public void enterWebsite(String website)
    {
        websiteTextBox.clear();
        websiteTextBox.sendKeys(website);
    }
    
    public void enterNameOfCeo(String name_Of_Ceo)
    {
        nameOfCeoTextBox.clear();
        nameOfCeoTextBox.sendKeys(name_Of_Ceo);
    }
    
    public void enterEmailOfCeo(String email_Of_Ceo)
    {
        emailOfCeoTextBox.clear();
        emailOfCeoTextBox.sendKeys(email_Of_Ceo);
    }
    
    public void enterMobileNumberOfCeo(String mobile_Number_Of_Ceo)
    {
        mobileNumberOfCeoTextBox.clear();
        mobileNumberOfCeoTextBox.sendKeys(mobile_Number_Of_Ceo);
    }
    
    public void clickAuthorizedSignatoryCheckBox()
    {
        authorizedSignatoryCheckBox.click();
    }
    
    public void clickAddAnotherSignatoryDetails()
    {
    	addAnotherSignatoryDetailsButton.click();
    }
    
    public void enterAuthorizedSignatoryName(String authorized_Signatory_Name)
    {
    	authorizedSignatoryNameTextbox.clear();
        authorizedSignatoryNameTextbox.sendKeys(authorized_Signatory_Name);
    }
    
    public void enterAuthorizedSignatoryEmail(String authorized_Signatory_Email)
    {
    	authorizedSignatoryEmailTextbox.clear();
        authorizedSignatoryEmailTextbox.sendKeys(authorized_Signatory_Email);
    }
    
    public void enterAuthorizedSignatoryMobile(String authorized_Signatory_Mobile)
    {
    	authorizedSignatoryMobileTextbox.clear();
        authorizedSignatoryMobileTextbox.sendKeys(authorized_Signatory_Mobile);
    }
    
    public void clickAddAnotherSignatoryDetails2()
    {
        addAnotherSignatoryDetailsButton2.click();
    }
    
    public void enterAuthorizedSignatoryName2(String authorized_Signatory_Name)
    {
    	authorizedSignatoryNameTextbox2.clear();
        authorizedSignatoryNameTextbox2.sendKeys(authorized_Signatory_Name);
    }
    
    public void enterAuthorizedSignatoryEmail2(String authorized_Signatory_Email)
    {
    	authorizedSignatoryEmailTextbox2.clear();
        authorizedSignatoryEmailTextbox2.sendKeys(authorized_Signatory_Email);
    }
    
    public void enterAuthorizedSignatoryMobile2(String authorized_Signatory_Mobile)
    {
    	authorizedSignatoryMobileTextbox2.clear();
        authorizedSignatoryMobileTextbox2.sendKeys(authorized_Signatory_Mobile);
    }
    
    public void clickOn_Delete_First_AuthorizedSignatory()
    {
    	delete_First_AuthorizedSignatoryButton.click();
    }
    
    public void clickOn_Delete_Second_AuthorizedSignatory()
    {
    	delete_Second_AuthorizedSignatoryButton.click();
    }
    
    public void clickOn_Delete_Third_AuthorizedSignatory()
    {
    	delete_Third_AuthorizedSignatoryButton.click();
    }
    
    public void clickSaveAndNextButton()
    {
    	saveAndNextButton.click();
    }
    
    public void clickSaveAsDraftButton1()
    {
        saveAsDraftButton1.click();
    }
    
    public void enterAddressOfOrganizationTextBox(String addresss_Of_Organization)
    {
        addressOfTheOrganizationTextBox.clear();
        addressOfTheOrganizationTextBox.sendKeys(addresss_Of_Organization);
    }
    
    public void enterNearByLandmark(String near_By_Landmark)
    {
        nearByLandmarkTextBox.clear();
        nearByLandmarkTextBox.sendKeys(near_By_Landmark);
    }
    
    public void enterPinCode(String pin_Code)
    {
        pinCodeTextBox.clear();
        pinCodeTextBox.sendKeys(pin_Code);
    }
    
    public void selectState(String state)
    {
        SelectDropDownList.selectDropDownListByVisibleText(stateDropDownList, state);
    }
    
    public void selectDistrict(String district)
    {
        SelectDropDownList.selectDropDownListByVisibleText(districtDropDownList, district);
    }
    
    public void selectTehsil(String tehsil)
    {
        SelectDropDownList.selectDropDownListByVisibleText(tehsilDropDownList, tehsil);
    }
    
    public void selectCity(String city)
    {
        SelectDropDownList.selectDropDownListByVisibleText(cityDropDownList, city);
    }    
    
    public void enterGeoLocation(String geo_Location) throws Exception
    {
        geoLocationTextBoxTextBox.clear();
        geoLocationTextBoxTextBox.sendKeys(geo_Location);
        Thread.sleep(2000);
        geoLocationTextBoxTextBox.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    }
    
    public void selectParliamentaryConstituency(String parliamentary_constituency) throws Exception
    {
        SelectDropDownList.selectDropDownListByVisibleText(parliamentaryConstituencyDropdownList, parliamentary_constituency);
    }
    
    public void selectAddressProof(String address_proof)
    {
        SelectDropDownList.selectDropDownListByVisibleText(addressProofDropDownList, address_proof);
    }
    
    public void clickOnCommunicationAddressSameAsPermanentAddress()
    {
    	communicationAddSameAsPermanentAddressCheckbox.click();
    }
    
    public void clickOn_Second_BrowseFile()
    {
    	second_BrowseFileButton.click();
    }
    
    public void clickOn_Second_UploadFile()
    {
    	second_UploadFileButton.click();
    }
    
    public void enterPANNumber(String pan_Number)
    {
    	panTextbox.clear();
    	panTextbox.sendKeys(pan_Number);
    }
    
    public void clickOnPANVerify()
    {
    	panVerifyButton.click();
    }
    
    public void clickBrowseButton1()
    {
    	browseButton1.click();
    }
    
    public void clickUploadButton1()
    {
    	uploadButton1.click();
    }
    
    public void enterGSTAccountNumber(String gst_Number)
    {
    	gstTextbox.clear();
    	gstTextbox.sendKeys(gst_Number);
    }
    
    public void clickOnGST_Verify()
    {
    	gst_VerifyButton.click();
    }
    
    public void clickBrowseButton2()
    {
    	browseButton2.click();
    }
    
    public void clickUploadButton2()
    {
    	uploadButton2.click();
    }
    
    public void clickBrowseButton3()
    {
    	browseButton3.click();
    }
    
    public void clickUploadButton3()
    {
    	uploadButton3.click();
    }
    
    public void clickBrowseButton4()
    {
    	browseButton4.click();
    }
    
    public void clickUploadButton4()
    {
    	uploadButton4.click();
    }
    
    public void clickBrowseButton5()
    {
    	browseButton5.click();
    }
    
    public void clickUploadButton5()
    {
    	uploadButton5.click();
    }
    
    public void enterAadharNumber(String aadhar_Number)
    {
    	aadharNumberTextbox.clear();
    	aadharNumberTextbox.sendKeys(aadhar_Number);
    }
    
    public void clickToVerifyAadharNumber()
    {
    	verifyAadharNumberButton.click();
    }
    
    public void enterAnnualTurnOver1(String turnover1)
    {
    	annualTurnOverTextbox1.clear();
    	annualTurnOverTextbox1.sendKeys(turnover1);
    }
    
    public void enterAnnualTurnOver2(String turnover2)
    {
    	annualTurnOverTextbox2.clear();
    	annualTurnOverTextbox2.sendKeys(turnover2);
    }
    
    public void enterAnnualTurnOver3(String turnover3)
    {
    	annualTurnOverTextbox3.clear();
    	annualTurnOverTextbox3.sendKeys(turnover3);
    }
    
    public void clickIAgreeCheckBox()
    {
        iAgreeCheckBox.click();
    }
    
    public void clickSaveAndContinueToPaymentButton()
    {
    	saveAndContinueToPaymentButton.click();
    }
    
    public void clickOnOkButton()
    {
    	okButton.click();
    }
    
    public void clickSaveAndContinueButton()
    {
        saveAndContinueButton.click();
    }
    
    public void clickLogOutButton()
    {
    	
        logOutButton.click();
    }
    
    public void clickDownloadButton()
    {
        downloadButton.click();
    }
    
    public void clcikOnGoToDashboard()
    {
    	goToDashboardPageButton.click();
    }
    
    public void clickOnDownloadReciept()
    {
    	downloadReceiptButton.click();
    }
    
    public void clickOnContinue()
    {
    	continueButton.click();
    }
    
    public void clickOnAA_ApprovalProcess()
    {
    	aa_ApprovalProcessRadioButton.click();
    }
    
    public void clickOnNonAA_ApprovalProcess()
    {
    	nonaa_ApprovalProcessRadioButton.click();
    }
    
    public void selectScheme(String scheme)
    {
    	SelectDropDownList.selectDropDownListByVisibleText(schemeDropDownList, scheme);
    }
    
    public void enterProposalID(String proposaID)
    {
    	proposalIDTextbox.clear();
    	proposalIDTextbox.sendKeys(proposaID);
    }
    
    public void clickOnSubmit()
    {
    	submit_Button.click();
    }
    
    public void clickOnSaveAsDraft()
    {
    	saveAsDraftButton.click();
    }
}

