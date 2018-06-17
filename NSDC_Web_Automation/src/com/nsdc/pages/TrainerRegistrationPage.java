package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class TrainerRegistrationPage
{
    WebDriver driver;
    
    @FindBy(xpath="//input[@placeholder='Enter full name']")
    private WebElement nameTextbox;
    @FindBy(xpath="//select[@formcontrolname='gender']")
    private WebElement genderDropDownList;
    @FindBy(id="dob")
    private WebElement dobTextBox;
    @FindBy(className="input-group-text")
    private WebElement calendarButton;
    @FindBy(xpath="//select[@formcontrolname='languagesKnown']")
    private WebElement multiSelectDropDownList_Language;
    @FindBy(xpath="//select[@formcontrolname='religion']")
    private WebElement religionDropDownList;
    @FindBy(xpath="//select[@formcontrolname='category']")
    private WebElement categoryDropDownList;
    @FindBy(xpath="//select[@formcontrolname='type']")
    private WebElement disabilityDropDownList;
    @FindBy(xpath="//div[div/label[contains(text(),'Disability')]]/div/div/div/app-upload-file/div/div/div/div/input[@id='customFile']")
    private WebElement disability_BrowseFileButton;
    @FindBy(xpath="//div[div/label[contains(text(),'Disability')]]/div/div/div/app-upload-file/div/div/div/div/button[contains(text(),'Upload')]")
    private WebElement disability_UploadButton;
    @FindBy(xpath="(//label[@class='m-radio'])[1]")
    private WebElement aadhaarNumberRadioButton;
    @FindBy(xpath="//input[@placeholder='Enter Aadhaar Number']")
    private WebElement aadhaarNumberTextBox;
    @FindBy(xpath="//button[contains(text(),'Validate')]")
    private WebElement validateButton;
    @FindBy(xpath="(//label[@class='m-radio'])[2]")
    private WebElement panNumberRadioButton;
    @FindBy(xpath="//input[@placeholder='Enter PAN Number']")
    private WebElement panNumberTextBox;
    @FindBy(xpath="//div[label[contains(text(),'Upload PAN Document')]]/div/app-upload-file/div/div/div/div/input[@id='customFile']")
    private WebElement panDocument_BrowseFileButton;
    @FindBy(xpath="//div[label[contains(text(),'Upload PAN Document')]]/div/app-upload-file/div/div/div/div/button[contains(text(),'Upload')]")
    private WebElement panDocument_uploadButton;
    @FindBy(xpath="//div[label[contains(text(),'Upload Your Photo')]]/div/app-upload-file/div/div/div/div/input[@id='customFile']")
    private WebElement uploadYourPhoto_browseFileButton;
    @FindBy(xpath="//div[label[contains(text(),'Upload Your Photo')]]/div/app-upload-file/div/div/div/div/button[contains(text(),'Upload')]")
    private WebElement uploadYourPhoto_uploadButton;
    @FindBy(xpath="//select[@formcontrolname='applicantCategory']")
    private WebElement multiSelectDropDownList_ApplicantCategory;
    @FindBy(xpath="//span[contains(text(),'Save & Continue')]")
    private WebElement saveAndContinueButton;
    
    @FindBy(xpath="//textarea[@formcontrolname='addressLine1']")
    private WebElement applicantAddressTextBox;
    @FindBy(xpath="//input[@formcontrolname='landmark']")
    private WebElement nearbyLandmarkTextBox;
    @FindBy(xpath="//input[@formcontrolname='pincode']")
    private WebElement pincodeTextBox;
    @FindBy(xpath="(//select[@formcontrolname='state'])[1]")
    private WebElement stateOrUnionTerritoryDropDownList;
    @FindBy(xpath="(//select[@formcontrolname='district'])[1]")
    private WebElement districtOrCityDropDownList;
    @FindBy(xpath="//select[@formcontrolname='mandal']")
    private WebElement tehsilOrMandalDropDownList;
    @FindBy(xpath="//select[@formcontrolname='parliamentConstituency']")
    private WebElement parliamentaryConstituencyDropDownList;
    @FindBy(css=".btn.btn-secondary.m-btn.m-btn--custom.m-btn--icon")
    private WebElement backButton;
    
    @FindBy(xpath="//select[@formcontrolname='education']")
    private WebElement educationAttainedDropDownList;
    @FindBy(xpath="//input[@placeholder='Enter the details of the above selected education type']")
    private WebElement detailsOfEducationTextBox;
    @FindBy(xpath="//div[div/h3[contains(text(),'Education')]]/div/div/app-upload-file/div/div/div/div/input[@id='customFile']")
    private WebElement educationProofDocument_browseButton;
    @FindBy(xpath="//div[div/h3[contains(text(),'Education')]]/div/div/app-upload-file/div/div/div/div/button[contains(text(),'Upload')]")
    private WebElement educationProofDocument_uploadButton;
    @FindBy(xpath="//button[text()='Click to add Education details']")
    private WebElement clickToAddEducationDetailsButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[3]")
    private WebElement deleteThirdEducationDetailsButton;
    
    @FindBy(xpath="(//select[@title='Select the Relevant Sector'])[1]")
    private WebElement industrialExperience_relevantSectorDropDownList;
    @FindBy(xpath="(//select[@formcontrolname='years'])[1]")
    private WebElement industrialExperience_TotalYearsOfExperienceDropDownList;
    @FindBy(xpath="(//select[@formcontrolname='months'])[1]")
    private WebElement industrialExperience_TotalMonthsOfExperienceDropDownList;
    @FindBy(xpath="(//input[@placeholder='Enter Details of the experience in the relevant Sector'])[1]")
    private WebElement industrialExperience_detailsOfExperienceTextBox;
    @FindBy(xpath="//input[@formcontrolname='detailsOfIndustries']")
    private WebElement industrialExperience_detailsOfIndustriesTextBox;
    @FindBy(xpath="//div[div/h3[contains(text(),'Industrial Experience')]]/div/div/app-upload-file/div/div/div/div/input[@id='customFile']")
    private WebElement industrialExperienceProofDocument_browseButton;
    @FindBy(xpath="//div[div/h3[contains(text(),'Industrial Experience')]]/div/div/app-upload-file/div/div/div/div/button[contains(text(),'Upload')]")
    private WebElement industrialExperienceProofDocument_uploadButton;
    @FindBy(xpath="//button[text()='Add Industrial Experience Details']")
    private WebElement clickToAddIndustrialExperienceDetailsButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[3]")
    private WebElement deleteThirdIndustrialExperienceDetailsWithoutEducationDetailButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[5]")
    private WebElement deleteThirdIndustrialExperienceDetailsButton;
    
    @FindBy(xpath="(//select[@title='Select the Relevant Sector'])[2]")
    private WebElement trainingExperience_relevantSectorDropDownList;
    @FindBy(xpath="(//select[@formcontrolname='years'])[2]")
    private WebElement trainingExperience_TotalYearsOfExperienceDropDownList;
    @FindBy(xpath="(//select[@formcontrolname='months'])[2]")
    private WebElement trainingExperience_TotalMonthsOfExperienceDropDownList;
    @FindBy(xpath="(//input[@placeholder='Enter Details of the experience in the relevant Sector'])[2]")
    private WebElement trainingExperience_detailsOfExperienceTextBox;
    @FindBy(xpath="//div[div/h3[contains(text(),'Training Experience')]]/div/div/div/app-upload-file/div/div/div/div/input[@id='customFile']")
    private WebElement trainingExperienceProofDocument_browseButton;
    @FindBy(xpath="//div[div/h3[contains(text(),'Training Experience')]]/div/div/div/app-upload-file/div/div/div/div/button[contains(text(),'Upload')]")
    private WebElement trainingExperienceProofDocument_uploadButton;
    @FindBy(xpath="//button[text()='Add Training Experience Details']")
    private WebElement clickToAddTrainingExperienceDetailsButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[5]")
    private WebElement deleteThirdTrainingExperienceDetailsWithoutEducationDetailButton;
    @FindBy(xpath="(//a[@class='btn btn-outline-metal m-btn m-btn--icon m-btn--icon-only'])[7]")
    private WebElement deleteThirdTrainingExperienceDetailsButton;
    
    @FindBy(xpath="//div[div/h3[contains(text(),'Curriculum Vitae / Resume Details')]]/div/div/app-upload-file/div/div/div/div/input[@id='customFile']")
    private WebElement curriculumVitaeOrResume_browseButton;
    @FindBy(xpath="//div[div/h3[contains(text(),'Curriculum Vitae / Resume Details')]]/div/div/app-upload-file/div/div/div/div/button[contains(text(),'Upload')]")
    private WebElement curriculumVitaeOrResume_uploadButton;
    
    @FindBy(xpath="//button[contains(text(),'Add Preferred Job Role')]")
    private WebElement addPreferredJobRoleButton;
    @FindBy(xpath="//div[div/label[contains(text(),'Select Sector')]]/div/div/select[@formcontrolname='sector']")
    private WebElement jobRoleSectorDropDownList;
    @FindBy(xpath="//div[div/label[contains(text(),'Select Sub-Sector')]]/div/div/select[@formcontrolname='subSector']")
    private WebElement jobRoleSubSectorDropDownList;
    @FindBy(xpath="//div[div/label[contains(text(),'Select Job Role')]]/div/div/select[@formcontrolname='jobRole']")
    private WebElement jobRoleDropDownList;
    @FindBy(xpath="(//div/button[contains(text(),'Add')])[4]")
    private WebElement jobRole_addButton;
    
    @FindBy(xpath="//button[contains(text(),'Add Preferred Location')]")
    private WebElement addPreferredLocationButton;
    @FindBy(xpath="//div[label[contains(text(),'State/ Union Territory:')]]/div/div/select[@ng-reflect-name='state']")
    private WebElement preferredStateOrUnionTerritoryDropDownList;
    @FindBy(xpath="//div[label[contains(text(),'District/ City:')]]/div/div/select[@formcontrolname='district']")
    private WebElement preferredDistrictOrCityDropDownList;
    @FindBy(xpath="//div[label[contains(text(),'Sub-District/ Tehsil:')]]/div/div/select[@formcontrolname='subDistrict']")
    private WebElement preferredSubDistrictOrTehsilDropDownList;
    @FindBy(xpath="(//div/button[contains(text(),'Add')])[3]")
    private WebElement preferredLocation_addButton;
    @FindBy(xpath="(//button[@class='btn'])[1]")
    private WebElement preferredJobRole_DeleteButton;
    @FindBy(xpath="(//button[@class='btn'])[4]")
    private WebElement thirdPreferredLocation_DeleteButton;
    
    @FindBy(xpath="//span[@_ngcontent-c10='']")
    private WebElement iAgreeCheckbox;
    @FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
    private WebElement submitButton;
    @FindBy(xpath="//button[text()='Logout']")
    private WebElement logOutButton;
    		
    public TrainerRegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void selectGender(String gender)
    {
        SelectDropDownList.selectDropDownListByVisibleText(genderDropDownList, gender);
    }
    
    public void selectDateOfBirth(String dob) throws Exception
    {
        dobTextBox.clear();
        dobTextBox.sendKeys(dob);
        Thread.sleep(2000);
        calendarButton.click();
    }
    
    public void selectAnyKnownLanguage(String language)
    {
        SelectDropDownList.selectDropDownListByVisibleText(multiSelectDropDownList_Language, language);
    }
    
    public void selectAllLanguages()
    {
        SelectDropDownList.selectDropDownListByVisibleText(multiSelectDropDownList_Language, "Kannada");
        SelectDropDownList.selectDropDownListByVisibleText(multiSelectDropDownList_Language, "Hindi");
        SelectDropDownList.selectDropDownListByVisibleText(multiSelectDropDownList_Language, "English");
    }
    
    public void selectReligion(String religion)
    {
        SelectDropDownList.selectDropDownListByVisibleText(religionDropDownList, religion);
    }
    
    public void selectCategory(String category)
    {
        SelectDropDownList.selectDropDownListByVisibleText(categoryDropDownList, category);
    }
    
    public void selectDisability(String disability)
    {
        SelectDropDownList.selectDropDownListByVisibleText(disabilityDropDownList, disability);
    }
    
    public void clickOnBrowseForUploadDisabilityDocument()
    {
        disability_BrowseFileButton.click();
    }
    
    public void clickOnUploadButtonForUploadDisabilityDocument()
    {
        disability_UploadButton.click();
    }
    
    public void clickOnAadharNumberRadioButton()
    {
        aadhaarNumberRadioButton.click();
    }
    
    public void enterAadharNumber(String aadhar)
    {
        aadhaarNumberTextBox.clear();
        aadhaarNumberTextBox.sendKeys(aadhar);
    }
    
    public void clickOnValidateAadharNumber()
    {
        validateButton.click();
    }
    
    public void clickOnPanNumberRadioButton()
    {
        panNumberRadioButton.click();
    }
    
    public void enterPanNumber(String PAN_number)
    {
        panNumberTextBox.clear();
        panNumberTextBox.sendKeys(PAN_number);
    }
    
    public void clickOnBrowseFileButtonForUploadPanDocument()
    {
        panDocument_BrowseFileButton.click();
    }
    
    public void clickOnUploadButtonToUploadPan()
    {
        panDocument_uploadButton.click();
    }
    
    public void clickOnBrowseFileButtonToUploadPhoto()
    {
        uploadYourPhoto_browseFileButton.click();
    }
    
    public void clickOnUploadButtonToUploadPhoto()
    {
        uploadYourPhoto_uploadButton.click();
    }
    
    public void selectAnyApplicantCategory(String applicant_Category)
    {
        SelectDropDownList.selectDropDownListByVisibleText(multiSelectDropDownList_ApplicantCategory, applicant_Category);
    }
    
    public void selectAllApplicantCategory()
    {
        SelectDropDownList.selectDropDownListByVisibleText(multiSelectDropDownList_ApplicantCategory, "Master Trainer");
        SelectDropDownList.selectDropDownListByVisibleText(multiSelectDropDownList_ApplicantCategory, "Trainer");
        
    }
    
    public void clickOnSaveAndContinue()
    {
        saveAndContinueButton.click();
    }
    
    public void enterApplicantAddress(String address)
    {
        applicantAddressTextBox.clear();
        applicantAddressTextBox.sendKeys(address);
    }
    
    public void enterNearbyLandmark(String landmark)
    {
        nearbyLandmarkTextBox.clear();
        nearbyLandmarkTextBox.sendKeys(landmark);
    }
    
    public void enterPincode(String pincode)
    {
        pincodeTextBox.clear();
        pincodeTextBox.sendKeys(pincode);
    }
    
    public void selectStateOrUnionTerritory(String state)
    {
        SelectDropDownList.selectDropDownListByVisibleText(stateOrUnionTerritoryDropDownList, state);
    }
    
    public void selectDistrictOrCity(String city)
    {
        SelectDropDownList.selectDropDownListByVisibleText(districtOrCityDropDownList, city);
    }
    
    public void selectTehsilOrMandal(String mandal)
    {
        SelectDropDownList.selectDropDownListByVisibleText(tehsilOrMandalDropDownList, mandal);
    }
    
    public void selectParliamentaryConstituency(String parliamentaryConstituency)
    {
        SelectDropDownList.selectDropDownListByVisibleText(parliamentaryConstituencyDropDownList, parliamentaryConstituency);
    }
    
    public void clickOnBack()
    {
        backButton.click();
    }
    
    public void selectEducationAttained(String education)
    {
        SelectDropDownList.selectDropDownListByVisibleText(educationAttainedDropDownList, education);
    }
    
    public void enterDetailsOfEducation(String edu_details)
    {
        detailsOfEducationTextBox.clear();
        detailsOfEducationTextBox.sendKeys(edu_details);
    }
    
    public void clickOnBrowseForUploadEducationProofDocument()
    {
        educationProofDocument_browseButton.click();
    }
    
    public void clickOnUploadForUploadEducationProofDocument()
    {
        educationProofDocument_uploadButton.click();
    }
    
    public void clickOnAddEducationDetailsButton()
    {
        clickToAddEducationDetailsButton.click();
    }
    
    public void deleteThirdEducationDetails()
    {
    	deleteThirdEducationDetailsButton.click();
    }
    
    public void selectRelevantSectorForIndustrialExperience(String industrial_sector)
    {
        SelectDropDownList.selectDropDownListByVisibleText(industrialExperience_relevantSectorDropDownList, industrial_sector);
    }
    
    public void selectYearsForIndustrialExperience(String industrial_years)
    {
        SelectDropDownList.selectDropDownListByVisibleText(industrialExperience_TotalYearsOfExperienceDropDownList, industrial_years);
    }
    
    public void selectMonthsForIndustrialExperience(String industrial_months)
    {
        SelectDropDownList.selectDropDownListByVisibleText(industrialExperience_TotalMonthsOfExperienceDropDownList, industrial_months);
    }
    
    public void enterDetailsOfIndustrialExperience(String industrialExperienceDetails)
    {
        industrialExperience_detailsOfExperienceTextBox.clear();
        industrialExperience_detailsOfExperienceTextBox.sendKeys(industrialExperienceDetails);
    }
    
    public void enterDetailsOfIndustriesForIndustrialExperienceTextBox(String industriesDetails)
    {
        industrialExperience_detailsOfIndustriesTextBox.clear();
        industrialExperience_detailsOfIndustriesTextBox.sendKeys(industriesDetails);
    }
    
    public void clickOnBrowseForIndustrialExperienceProofDocument()
    {
        industrialExperienceProofDocument_browseButton.click();
    }
    
    public void clickOnUploadForIndustrialExperienceProofDocument()
    {
        industrialExperienceProofDocument_uploadButton.click();
    }
    
    public void clickOnAddIndustrialExperienceDetails()
    {
        clickToAddIndustrialExperienceDetailsButton.click();
    }
    
    public void deleteThirdIndustrialExperienceDetailsWithoutEducationDetail()
    {
    	deleteThirdIndustrialExperienceDetailsWithoutEducationDetailButton.click();
    }
    
    public void deleteThirdIndustrialExperienceDetails()
    {
    	deleteThirdIndustrialExperienceDetailsButton.click();
    }
    
    public void selectRelevantSectorForTrainingExperience(String training_sector)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainingExperience_relevantSectorDropDownList, training_sector);
    }
    
    public void selectyearsForTrainingExperience(String trainingExperienceYears)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainingExperience_TotalYearsOfExperienceDropDownList, trainingExperienceYears);
    }
    
    public void selectMonthsForTrainingExperience(String trainingExperienceMonths)
    {
        SelectDropDownList.selectDropDownListByVisibleText(trainingExperience_TotalMonthsOfExperienceDropDownList, trainingExperienceMonths);
    }
    
    public void enterTrainingExperienceDetails(String trainingExperienceDetails)
    {
        trainingExperience_detailsOfExperienceTextBox.clear();
        trainingExperience_detailsOfExperienceTextBox.sendKeys(trainingExperienceDetails);
    }
    
    public void clickOnBrowseForTrainingExperienceProofDocument()
    {
        trainingExperienceProofDocument_browseButton.click();
    }
    
    public void clickOnUploadForTrainingExperienceProofDocument()
    {
        trainingExperienceProofDocument_uploadButton.click();
    }
    
    public void clickOnAddTrainingExperienceDetails()
    {
        clickToAddTrainingExperienceDetailsButton.click();
    }
    
    public void deleteThirdTrainingExperienceWithoutEducationDetails()
    {
    	deleteThirdTrainingExperienceDetailsWithoutEducationDetailButton.click();
    }
    
    public void deleteThirdTrainingExperienceDetails()
    {
    	deleteThirdTrainingExperienceDetailsButton.click();
    }
    
    public void clickOnBrowseForCurriculumVitaeOrResume()
    {
        curriculumVitaeOrResume_browseButton.click();
    }
    
    public void clickOnUploadForCurriculumVitaeOrResume()
    {
        curriculumVitaeOrResume_uploadButton.click();
    }
    
    public void clickOn_PreferredJobRole()
    {
        addPreferredJobRoleButton.click();
    }
    
    public void selectSectorForJobRole(String jobRole_sector)
    {
        SelectDropDownList.selectDropDownListByVisibleText(jobRoleSectorDropDownList, jobRole_sector);
    }
    
    public void selectSubSectorForJobRole(String jobRole_subSector)
    {
        SelectDropDownList.selectDropDownListByVisibleText(jobRoleSubSectorDropDownList, jobRole_subSector);
    }
    
    public void select_JobRole(String jobRole)
    {
        SelectDropDownList.selectDropDownListByVisibleText(jobRoleDropDownList, jobRole);
    }
    
    public void clickOnAddForPreferredJobRole()
    {
        jobRole_addButton.click();
    }
    
    public void clickOn_AddPreferredLocation()
    {
        addPreferredLocationButton.click();
    }
    
    public void selectPreferredStateOrUnionTerritory(String preferred_state)
    {
        SelectDropDownList.selectDropDownListByVisibleText(preferredStateOrUnionTerritoryDropDownList, preferred_state);
    }
    
    public void selectPreferredDistrictOrCity(String preferred_city)
    {
        SelectDropDownList.selectDropDownListByVisibleText(preferredDistrictOrCityDropDownList, preferred_city);
    }
    
    public void selectPreferredSubDistrictOrTehsil(String preferred_district)
    {
        SelectDropDownList.selectDropDownListByVisibleText(preferredSubDistrictOrTehsilDropDownList, preferred_district);
    }
    
    public void clickOnAddForPreferredLocation()
    {
        preferredLocation_addButton.click();
    }
    
    public void clickOnDeletePreferredJobRole()
    {
        preferredJobRole_DeleteButton.click();
    }
    
    public void clickOnDeleteThirdPreferredLocation()
    {
        thirdPreferredLocation_DeleteButton.click();
    }  
    
    public void clickIAgreeCheckbox()
    {
        iAgreeCheckbox.click();
    }  
    
    public void clickSubmitButton()
    {
        submitButton.click();
    }
    
    public void clickLogOutButton()
    {
        logOutButton.click();
    }
}

