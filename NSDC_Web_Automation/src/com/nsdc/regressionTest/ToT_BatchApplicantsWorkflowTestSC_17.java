package com.nsdc.regressionTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.AssessmentAgencyDashboardPage;
import com.nsdc.pages.AssessmentAgencyViewBatchesPage;
import com.nsdc.pages.AssessorDashboardPage;
import com.nsdc.pages.AssessorViewBatchesPage;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LocationBasedTC_DashboardPage;
import com.nsdc.pages.LocationBasedTC_ViewBatchesPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.SSCAllBatchesPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage;
import com.nsdc.pages.SSC_ViewBatchDetailsPage;
import com.nsdc.pages.TrainerApplicantDashboardPage;
import com.nsdc.pages.TrainerApplicantSearchAndApplyForAvailableBatchesPage;
import com.nsdc.pages.TrainerApplicantViewBatchesPage;
import com.nsdc.pages.TrainerDashboardPage;
import com.nsdc.pages.TrainerViewBatchesPage;
import com.nsdc.testConfig.TestConfiguration;

public class ToT_BatchApplicantsWorkflowTestSC_17 extends TestConfiguration
{
	String configuredURL=ReadWriteData.getData("./TestData/Configurations.xls", "Config",1,1);
	String batchSector=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 0);
	String batchSubSector=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 1);
	String batchDomainJobRole=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 2);
	String batchDomainJobRoleCode=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 3);
	String sscID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 21);
	String sscPassword=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 22);
	String batchType=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 4);
	String batchFees=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 5);
	String batchPlatformJobRole=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 6);
	String batchPlatformJobRoleCode=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 7);
	String tcID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 8);
	String tcPassword=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 10);
	String tcName=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 9);
	String tcTPName=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 11);
	String tcSPOCMobile=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 12);
	String tcSPOCEmail=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 13);
	String tcAddress=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 14);
	String tcLandmark=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 15);
	String tcPinCode=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 16);
	String tcMandal=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 17);
	String tcDistrict=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 18);
	String tcState=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 19);
	String tcParlimentaryConstituency=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 20);
	String domainMasterTrainerID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 23);
	String domainMasterTrainerName=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 24);
	String domainMasterTrainerPassword=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 25);
	String platformMasterTrainerID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 26);
	String platformMasterTrainerName=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 27);
   	String platformMasterTrainerPassword=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 28);
	String domainAssessmentAgencyID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 29);
	String domainAssessmentAgencyName=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 30);
	String domainAssessmentAgencyPassword=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 31);
	String platformAssessmentAgencyID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 32);
	String platformAssessmentAgencyName=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 33); 
	String platformAssessmentAgencyPassword=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 34);
	String domainMasterAssessorID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 35); 
	String domainMasterAssessorName=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 36); 
	String domainMasterAssessorPassword=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 37);
	String platformMasterAssessorID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 38); 
	String platformMasterAssessorName=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 39); 
	String platformMasterAssessorPassword=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 40);
	String batchDomainJobRoleVersion=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 56);
	String batchPlatformJobRoleVersion=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 57);
	
	@DataProvider()
    public Object[][] totBatchData() throws Exception
    {
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches");
    }
    @Test(dataProvider="totBatchData")
    public void totBatchCreationTC_01(String serialNo,String createdBatchIDs, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcName, String tcPassword, String tcTrainingPartnerName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String tcPincode, String mandal, String district, String state, String parlimentaryConstituency, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmtRemarksDate, String dmtRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmtRemarksDate, String pmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String daaRemarksDate, String daaRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String paaRemarksDate, String paaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaRemarks, String pmaRemarksDate, String pmaRemarksTime, String domainJobRoleAttendance, String platformJobRoleAttendance, String domainJobRoleLevel, String platformJobRoleLevel, String tcSPOCName, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
    {
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
	    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
	    bvp.clickToClose();
	    Thread.sleep(2000);
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(sscUsername, sscPassword);
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA"))));
		SSC_DashboardPage sscDbP=new SSC_DashboardPage(driver);
		sscDbP.click_ToAToMTToMA();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)", "");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Create new Batch for ToT, ToA, ToMT, ToMA')]"))));
		sscDbP.clickCreateBatch();
		Assert.assertEquals(driver.findElement(By.name("sector")).getAttribute("value").trim(), expectedSector);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage sscTbcP=new SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(driver);
		sscTbcP.selectBatchType(batchType);
		sscTbcP.selectBatchCategory(batchCategory);
		SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage.fileSave("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls");
		String configBatchStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 41);
		String configBatchEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 42);
		String configDomainTrainingStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 43);
		String configDomainTrainingEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 44);
		String configDomainAssessmentStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 45);
		String configDomainAssessmentEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 46);
		String configPlatformTrainingStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 47);
		String configPlatformTrainingEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 48);
		String configPlatformAssessemntStartDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 49);
		String configPlatformAssessemntEndDate=ReadWriteData.getToT_ToA_ConfigData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "Configurable-Fields", 1, 50);
		sscTbcP.selectTrainingStartDateForBatch(configBatchStartDate);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW"))
		{
			sscTbcP.selectTrainingEndDateForNewBatch(configBatchEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers"))
		{
			sscTbcP.selectTrainingEndDateForExistingBatch(configBatchEndDate);
		}
		String trainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),9,trainingStartDate);
		String trainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),10,trainingEndDate);
		sscTbcP.selectDomainJobRole(domainJobRole, domainJobRoleCode, domainJobRoleVersion);
		//Sometimes platform job role will not be available
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//angular2-multiselect[@formcontrolname='platformJobRole']/div")));
		driver.findElement(By.xpath("//angular2-multiselect[@formcontrolname='platformJobRole']/div")).click();
		if(driver.findElements(By.xpath("//label[text()='"+platformJobRole+"']")).size()==0)
		{
			js.executeScript("window.scrollBy(0,-1000)", "");
			driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[contains(text(),'Create new Batch for ToT, ToA, ToMT, ToMA')]")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			sscTbcP.selectBatchType(batchType);
			sscTbcP.selectBatchCategory(batchCategory);
			sscTbcP.selectTrainingStartDateForBatch(configBatchStartDate);
			if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW"))
			{
				sscTbcP.selectTrainingEndDateForNewBatch(configBatchEndDate);
			}
			else if(batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers"))
			{
				sscTbcP.selectTrainingEndDateForExistingBatch(configBatchEndDate);
			}
			trainingStartDate=driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).getAttribute("value").replaceAll("/", "-");
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),9,trainingStartDate);
			trainingEndDate=driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).getAttribute("value").replaceAll("/", "-");
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),10,trainingEndDate);
			sscTbcP.selectDomainJobRole(domainJobRole, domainJobRoleCode, domainJobRoleVersion);
			driver.findElement(By.xpath("//angular2-multiselect[@formcontrolname='platformJobRole']/div")).click();
			sscTbcP.selectPlatformJobRole(platformJobRole);
		}
		else
		{
			sscTbcP.selectPlatformJobRole(platformJobRole);
		}
		//Domain QP
		sscTbcP.clickToChooseDomainQP();
		sscTbcP.selectDomainTrainingStartDate(configDomainTrainingStartDate);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW"))
		{
			sscTbcP.selectDomainTrainingEndDateForNewBatch(configDomainTrainingEndDate);
			sscTbcP.selectDomainAssessmentStartDateForNewBatch(configDomainAssessmentStartDate);
			sscTbcP.selectDomainAssessmentEndDateForNewBatch(configDomainAssessmentEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers"))
		{
			sscTbcP.selectDomainTrainingEndDateForExistingBatch(configDomainTrainingEndDate);
			sscTbcP.selectDomainAssessmentStartDateForExistingBatch(configDomainAssessmentStartDate);
			sscTbcP.selectDomainAssessmentEndDateForExistingBatch(configDomainAssessmentEndDate);
		}
		String domainTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		String domainAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[1]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),15,domainTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),16,domainTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),17,domainAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),18,domainAssessmentEndDate);
		//Platform QP
		sscTbcP.clickToChoosePlatformQP();
		sscTbcP.selectPlatformTrainingStartDate(configPlatformTrainingStartDate);
		if(batchType.equalsIgnoreCase("Training of Trainer-New")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - NEW"))
		{
			sscTbcP.selectPlatformTrainingEndDateForNewBatch(configPlatformTrainingEndDate);
			sscTbcP.selectPlatformAssessmentStartDateForNewBatch(configPlatformAssessemntStartDate);
			sscTbcP.selectPlatformAssessmentEndDateForNewBatch(configPlatformAssessemntEndDate);
		}
		else if(batchType.equalsIgnoreCase("Training of Master Trainer")||batchType.equalsIgnoreCase("Training of Trainer-Existing")||batchType.equalsIgnoreCase("Disability Sensitization Training for Trainers - EXISTING")||batchType.equalsIgnoreCase("Disability Sensitization Training for Master Trainers"))
		{
			sscTbcP.selectPlatformTrainingEndDateForExistingBatch(configPlatformTrainingEndDate);
			sscTbcP.selectPlatformAssessmentStartDateForExistingBatch(configPlatformAssessemntStartDate);
			sscTbcP.selectPlatformAssessmentEndDateForExistingBatch(configPlatformAssessemntEndDate);
		}
		String platformTrainingStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformTrainingEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='trainingEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentStartDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentStartDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		String platformAssessmentEndDate=driver.findElement(By.xpath("(//input[@formcontrolname='assessmentEndDate'])[2]")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),19,platformTrainingStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),20,platformTrainingEndDate);
		ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),21,platformAssessmentStartDate);
		ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),22,platformAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='batchFees']")).getAttribute("value"), expectedBatchFees);
		sscTbcP.selectBatchSize(batchSize);
		sscTbcP.clickToCreateBatch();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		String bacthCreationsuccessfulURL=driver.getCurrentUrl();
		String[]parts=bacthCreationsuccessfulURL.split("/");
		String createdBatchID=parts[parts.length-1];
		ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),1,createdBatchID);
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		//STEP 2 OF BATCH CREATION -> Assigning Location Based Training Centre
		SSC_ViewBatchDetailsPage sVbP=new SSC_ViewBatchDetailsPage(driver);
		js.executeScript("window.scrollBy(0,500)", "");
		sVbP.selectStateFilter(state);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sVbP.selectDistrictFilter(district);
		sVbP.enterTrainingCentreIDToSearch(tcID);
		sVbP.clickToGetSearchFilterResult();
		sVbP.clickToChooseResultedTrainingCentreToAssign();
		sVbP.clickToSubmitSelectedTrainingCentre();
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assigning Master Trainer for domain QP
		sVbP.clickDomainMasterTrainerAction(domainJobRole);
		sVbP.selectDomainAssignMasterTrainerOption();
		sVbP.enterDomainMasterTrainerIDToSearch(dmasterTrainerID);
		sVbP.clickToGetDomainMasterSearchFilterResult();
		sVbP.clickToChooseDomainMasterTrainer();
		sVbP.clickToFinallyAssignSelectedDomainMasterTrainer();
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assigning Platform QP Master Trainer
		sVbP.clickPlatformMasterTrainerAction(platformJobRole);
		sVbP.selectPlatformAssignMasterTrainerOption();
		sVbP.enterPlatformMasterTrainerIDToSearch(pmasterTrainerID);
		sVbP.clickToGetPlatformMasterSearchFilterResult();
		sVbP.clickToChoosePlatformMasterTrainer();
		sVbP.clickToFinallyAssignSelectedPlatformMasterTrainer();
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assigning Domain QP Assessment Agency
		sVbP.clickDomainAssessmentAgencyAction(domainJobRole);
		sVbP.selectDomainAssignAssessmentAgencyOption();
		sVbP.enterDomainAssessmentAgencyIDToSearch(dassessmentAgencyID);
		sVbP.clickToGetDomainAssessmentAgencySearchFilterResult();
		sVbP.clickToChooseDomainAssessmentAgency();
		sVbP.clickToFinallyAssignSelectedDomainAssessmentAgency();
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		//Assigning Platform QP Assessment Agency
		sVbP.clickPlatformAssessmentAgencyAction(platformJobRole);
		sVbP.selectPlatformAssignAssessmentAgencyOption();
		sVbP.enterPlatformAssessmentAgencyIDToSearch(passessmentAgencyID);
		sVbP.clickToGetPlatformAssessmentAgencySearchFilterResult();
		sVbP.clickToChoosePlatformAssessmentAgency();
		sVbP.clickToFinallyAssignSelectedPlatformAssessmentAgency();
		sscTbcP.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,500)", "");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		sVbP.clickConfirmation();
		sVbP.clickToSubmitBatch();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches",Integer.parseInt(serialNo),2,formatter.format(date));
		sVbP.clickOkForBatchSubmission();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
    }
    
    @Test(dataProvider="totBatchData", dependsOnMethods="totBatchCreationTC_01")
    public void totBatchApprovalTC_02(String serialNo,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcName, String tcPassword, String tcTrainingPartnerName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String tcPincode, String mandal, String district, String state, String parlimentaryConstituency, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmtRemarksDate, String dmtRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmtRemarksDate, String pmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String daaRemarksDate, String daaRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String paaRemarksDate, String paaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaRemarks, String pmaRemarksDate, String pmaRemarksTime, String domainJobRoleAttendance, String platformJobRoleAttendance, String domainJobRoleLevel, String platformJobRoleLevel, String tcSPOCName, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
    {
    	//Assigned TC Login to Accept Batch
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
	    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
	    bvp.clickToClose();
	    Thread.sleep(2000);
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(tcID, tcPassword);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		lTcDp.clickToViewBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)","");
		LocationBasedTC_ViewBatchesPage lTcVbP=new LocationBasedTC_ViewBatchesPage(driver);
		lTcVbP.enterToSearchForBatchID(batchID);
		lTcVbP.clickToGetSearchResult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		lTcVbP.clikToGetBatchActionMenu();
		lTcVbP.selectAcceptBatchOption();
		lTcVbP.enterRemarksForAcceptingBatch(tcBatchAcceptanceRemarks);
		lTcVbP.clickToAcceptBatch();
		lTcVbP.clickOk();
		PostLoginPage plp=new PostLoginPage(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
		plp.clickOnProfileLogo();
		Thread.sleep(1000);
		plp.clickOnLogout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		//Assigned Master Trainer Login To Accept the Batch
		TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
		TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
		if(!pmasterTrainerID.equalsIgnoreCase(dmasterTrainerID))
		{
			for(int i=1;i<3;i++)
			{
				Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
				lp.clickLogin();
				Thread.sleep(2000);
			    bvp.clickToClose();
			    Thread.sleep(2000);
				if(i==1)
				{
					elp.performlogin(dmasterTrainerID, dmasterTrainerPassword);
				}
				else
				{
					elp.performlogin(pmasterTrainerID, pmasterTrainerPassword);
				}
				tDp.clickToGetTrainerDashboard();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				tDp.clickAllBatches();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				js.executeScript("window.scrollBy(0,200)", "");
				tVp.enterBatchIDToSearch(batchID);
				tVp.clickToGetSearchFilterResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				tVp.clickToGetActionMenuOptions(batchID);
				tVp.clickToSelectAcceptBatchOption(batchID);
				if(i==1)
				{
					tVp.enterRemarksForAcceptingBatch(dmtBatchAcceptanceRemarks);
				}
				else
				{
					tVp.enterRemarksForAcceptingBatch(pmtBatchAcceptanceRemarks);
				}
				tVp.clickToSubmit();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				Date date = new Date();
				DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
				if(i==1)
				{
					ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 44, timeFormat.format(date));
					ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 43, formatter.format(date));
				}
				else
				{
					ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 50, timeFormat.format(date));
					ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 49, formatter.format(date));
				}
				tVp.clickOk();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
			}
		}
		else
		{
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			lp.clickLogin();
			Thread.sleep(2000);
		    bvp.clickToClose();
		    Thread.sleep(2000);
			elp.performlogin(dmasterTrainerID, dmasterTrainerPassword);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
			tDp.clickToGetTrainerDashboard();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tDp.clickAllBatches();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			js.executeScript("window.scrollBy(0,200)", "");
			tVp.enterBatchIDToSearch(batchID);
			tVp.clickToGetSearchFilterResult();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tVp.clickToGetActionMenuOptions(batchID);
			tVp.clickToSelectAcceptBatchOption(batchID);
			tVp.enterRemarksForAcceptingBatch(dmtBatchAcceptanceRemarks);
			tVp.clickToSubmit();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 44, timeFormat.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 43, formatter.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 50, timeFormat.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 49, formatter.format(date));
			tVp.clickOk();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		}
		//Assigned Assessment Agency Login to Accept and assigning master assessors for a batch
		if(!passessmentAgencyID.equalsIgnoreCase(dassessmentAgencyID))
		{
			for(int i=1;i<3;i++)
			{
				lp.clickLogin();
				Thread.sleep(2000);
			    bvp.clickToClose();
			    Thread.sleep(2000);
				if(i==1)
				{
					elp.performlogin(dassessmentAgencyID, dassessmentAgencyPassword);
				}
				else
				{
					elp.performlogin(passessmentAgencyID, passessmentAgencyPassword);
				}
				AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
				aDp.clickBatchAssessmentRequests();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
				aVp.enterBatchIdToSearch(batchID);
				aVp.clickToApplySelectedSearchFilters();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				js.executeScript("window.scrollBy(0,200)", "");
				aVp.clickToGetActionMenuOptions();
				aVp.clickToSelectAcceptBatchOption();
				if(i==1)
				{
					aVp.enterRemarksForAcceptingBatch(daaBatchAcceptanceRemarks);
				}
				else
				{
					aVp.enterRemarksForAcceptingBatch(paaBatchAcceptanceRemarks);
				}
				aVp.clickToSubmitBatchAcceptance();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
				Date date = new Date();
				DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
				if(i==1)
				{
					ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 56, timeFormat.format(date));
					ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 55, formatter.format(date));
				}
				else
				{
					ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 62, timeFormat.format(date));
					ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 61, formatter.format(date));
				}
				aVp.clickOk();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
				//assigning assessors
				aVp.clickToViewAcceptedBatches();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				aVp.enterBatchIdToSearch(batchID);
				aVp.clickToApplySelectedSearchFilters();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				js.executeScript("window.scrollBy(0,200)", "");
				aVp.clickToGetActionMenuOptions();
				aVp.clickToSelectAssignAssessorsOption();
				if(i==1)
				{
					aVp.selectMasterAssessorForDomain1(dmasterAssessorName+"("+dmasterAssessorID+")");
				}
				else
				{
					aVp.selectMasterAssessorForPlatform(pmasterAssessorName+"("+pmasterAssessorID+")");
				}
				aVp.clickToSubmitMasterAssessors();
				aVp.clickOk();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
			}
		}
		else
		{
			lp.clickLogin();
			Thread.sleep(2000);
		    bvp.clickToClose();
		    Thread.sleep(2000);
			elp.performlogin(dassessmentAgencyID, dassessmentAgencyPassword);
			AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
			aDp.clickBatchAssessmentRequests();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
			aVp.enterBatchIdToSearch(batchID);
			aVp.clickToApplySelectedSearchFilters();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockMsg.blockPage")));
			aVp.clickToGetActionMenuOptions();
			aVp.clickToSelectAcceptBatchOption();
			aVp.enterRemarksForAcceptingBatch(daaBatchAcceptanceRemarks);
			aVp.clickToSubmitBatchAcceptance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 56, timeFormat.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 55, formatter.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 62, timeFormat.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 61, formatter.format(date));
			aVp.clickOk();
			//assigning assessors
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			aVp.clickToViewAcceptedBatches();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			aVp.enterBatchIdToSearch(batchID);
			aVp.clickToApplySelectedSearchFilters();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			js.executeScript("window.scrollBy(0,200)", "");
			aVp.clickToGetActionMenuOptions();
			aVp.clickToSelectAssignAssessorsOption();
			aVp.selectMasterAssessorForDomain1(dmasterAssessorName+"("+dmasterAssessorID+")");
			aVp.selectMasterAssessorForDomain2(dmasterAssessorName+"("+dmasterAssessorID+")");
			aVp.clickToSubmitMasterAssessors();
			aVp.clickOk();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		}
		//Master Assessor Login to Accept Batches
		if(!pmasterAssessorID.equalsIgnoreCase(dmasterAssessorID))
		{
			for(int i=1; i<3;i++)
			{
				lp.clickLogin();
				Thread.sleep(2000);
			    bvp.clickToClose();
			    Thread.sleep(2000);
				if(i==1)
				{
					elp.performlogin(dmasterAssessorID, dmasterAssessorPassword);
				}
				else
				{
					elp.performlogin(pmasterAssessorID, pmasterAssessorPassword);
				}
				AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
				maDp.clickToGetAssessorDashboard();
				js.executeScript("window.scrollBy(0,500)", "");
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				maDp.clickBatchAssessmentRequests();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
				maVp.enterBatchIDToSearch(batchID);
				maVp.clickToGetSearchResult();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
				js.executeScript("window.scrollBy(0,200)", "");
				maVp.clickToGetActionMenuOptions(batchID);
				maVp.clickToSelectAcceptBatchOption(batchID);
				if(i==1)
				{
					maVp.enterRemarksForAcceptingBatch(dmaRemarks);
				}
				else
				{
					maVp.enterRemarksForAcceptingBatch(pmaRemarks);
				}
				maVp.clickToSaveAndSubmitBatchAccceptance();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
				Date date = new Date();
				DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
				if(i==1)
				{
					ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 68, timeFormat.format(date));
					ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 67, formatter.format(date));
				}
				else
				{
					ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 74, timeFormat.format(date));
					ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 73, formatter.format(date));
				}
				maVp.clickOk();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
				plp.clickOnProfileLogo();
				Thread.sleep(2000);
				plp.clickOnLogout();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
			}
		}
		else
		{
			lp.clickLogin();
			Thread.sleep(2000);
		    bvp.clickToClose();
		    Thread.sleep(2000);
			elp.performlogin(dmasterAssessorID, dmasterAssessorPassword);
			AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
			maDp.clickToGetAssessorDashboard();
			js.executeScript("window.scrollBy(0,500)", "");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			maDp.clickBatchAssessmentRequests();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
			maVp.enterBatchIDToSearch(batchID);
			maVp.clickToGetSearchResult();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			js.executeScript("window.scrollBy(0,200)", "");
			maVp.clickToGetActionMenuOptions(batchID);
			maVp.clickToSelectAcceptBatchOption(batchID);
			maVp.enterRemarksForAcceptingBatch(dmaRemarks);
			maVp.clickToSaveAndSubmitBatchAccceptance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			Date date = new Date();
			DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 68, timeFormat.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 67, formatter.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 74, timeFormat.format(date));
			ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", Integer.parseInt(serialNo), 73, formatter.format(date));
			maVp.clickOk();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
		}
	}
    
    @DataProvider
    public Object[][] totApplicantsData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants");
    }
    @Test(dataProvider="totApplicantsData", dependsOnMethods="totBatchApprovalTC_02")
 	public void totApplicantsSearchAndApplyForAvailableBatchTC_03(String serialNum, String trainerID, String paymentDate, String userType, String name, String email, String mobile, String applicantPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String paymentMode, String bankName, String paymentReferenceNumber, String paymentRemarks) throws Exception
 	{
 	   LoginPage lp=new LoginPage(driver);
 	   EnterLoginPage elp=new EnterLoginPage(driver);
 	   String batchID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 1);
	   String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 9);
	   String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 10);
	   String domainTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 15);
	   String domainTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 16);
	   String domainAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 17);
	   String domainAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 18);
	   String platformTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 19);
	   String platformTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 20);
	   String platformAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 21);
	   String platformAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 22);
	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
	   lp.clickLogin();
	   Thread.sleep(2000);
	   BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
	   bvp.clickToClose();
	   Thread.sleep(2000);
 	   elp.performlogin(trainerID, applicantPassword);
 	   TrainerApplicantDashboardPage tDp=new TrainerApplicantDashboardPage(driver);
 	   tDp.clickToGetApplicantDashboard();
 	   WebDriverWait wait=new WebDriverWait(driver, 30);
 	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   tDp.clickSearchAndApplyforAvailableBatches();
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   TrainerApplicantSearchAndApplyForAvailableBatchesPage tSp=new TrainerApplicantSearchAndApplyForAvailableBatchesPage(driver);
	   if(serialNum.equals("1"))
 	   {
 		   tSp.clickMyPreferences();
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   tSp.clickToGetMyPreferenceActionMenu(batchSector);
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   tSp.selectSearchAgainstPreference(batchSector);
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! Search Against My Preference is not resulting batch - "+batchID);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchDomainJobRole+" ("+batchDomainJobRoleCode+") - "+batchDomainJobRoleVersion+", "+batchPlatformJobRole+" ("+batchPlatformJobRoleCode+") - "+batchPlatformJobRoleVersion);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), state);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), city);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), batchStartDate.replaceAll("-", "/")+" to "+batchEndDate.replaceAll("-", "/"));
 		   //have to select batch action
 		   tSp.clickToGetBatchActionMenu(batchID);
 		   tSp.selectViewBatchDetails(batchID);
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch ID')]]])[1]/div[1]")).getText().trim(), batchID);
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Name')]]])[1]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Type')]]])[1]/div[1]")).getText().trim(), batchType);
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Date')]]])[1]/div[2]")).getText().trim(), batchStartDate.replaceAll("-", "/")+" to "+batchEndDate.replaceAll("-", "/"));
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[1]")).getText().trim(), batchSector);
// 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[2]")).getText().trim(), batchSubSector);
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Fee')]]])[1]/div[2]")).getText().trim(), batchFees);
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Name of Training Center')]]])/div[1]")).getText().trim(), tcName);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[2]")).getText().trim(), batchDomainJobRole);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[4]")).getText().trim(), domainMasterTrainerName+" ("+domainMasterTrainerID+")");
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[5]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[6]")).getText().trim(), domainAssessmentAgencyName+" ("+domainAssessmentAgencyID+")");
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[2]")).getText().trim(), batchPlatformJobRole);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[4]")).getText().trim(), platformMasterTrainerName+" ("+platformMasterTrainerID+")");
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[5]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[6]")).getText().trim(), platformAssessmentAgencyName+" ("+platformAssessmentAgencyID+")");
 		   tSp.clickGoBack();
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   tSp.clickMyPreferences();
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		   tSp.clickToGetMyPreferenceActionMenu(batchSector);
		   tSp.selectSearchAgainstPreference(batchSector);
		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! Search Against My Preference is not resulting batch - "+batchID);
 		   tSp.clickToGetBatchActionMenu(batchID);
		   tSp.selectApplyToBatch(batchID);
		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
 		   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully");
 		   tSp.clickOK();
 	   }
 	   else if(serialNum.equals("2"))
 	   {
 		   tSp.selectState(state);
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   tSp.selectDistrict(city);
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   if(!mandal.equalsIgnoreCase("N/A"))
 		   {
 			  tSp.selectSubDistrict(mandal);
 			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   }
 		   tSp.selectSector(batchSector);
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
// 		   tSp.selectSubSector(batchSubSector);
// 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Please wait...')]")));
 		   tSp.selectjobRole(batchDomainJobRole, batchDomainJobRoleCode, batchDomainJobRoleVersion);
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   tSp.selectBatchType(batchType);
		   tSp.enterBatchStartDate(batchStartDate);
 		   tSp.clickToCloseBatchStartDateCalender();
 		   tSp.enterBatchEndDate(batchEndDate);
 		   tSp.clickToCloseBatchEndDateCalender();
 		   tSp.enterSearchKeyword(tcName);
 		   tSp.clickSearch();
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" searching by entering all fields! ");
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchDomainJobRole+" ("+batchDomainJobRoleCode+") - "+batchDomainJobRoleVersion+", "+batchPlatformJobRole+" ("+batchPlatformJobRoleCode+") - "+batchPlatformJobRoleVersion);
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), state);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), city);
		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), batchStartDate.replaceAll("-", "/")+" to "+batchEndDate.replaceAll("-", "/"));
 		   tSp.clickToGetBatchActionMenu(batchID);
 		   tSp.selectApplyToBatch(batchID);
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
 		   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully");
 		   tSp.clickOK();
 		}	   
		else
 		{
 			tSp.selectState(state);
 			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 			tSp.selectSector(batchSector);
 			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 			tSp.clickSearch();
 			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! no show of batch - "+batchID+" searching by entering Only Mandatory fields! ");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchDomainJobRole+" ("+batchDomainJobRoleCode+") - "+batchDomainJobRoleVersion+", "+batchPlatformJobRole+" ("+batchPlatformJobRoleCode+") - "+batchPlatformJobRoleVersion);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), tcName+" ("+tcID+")");
	 		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), state);
	 		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), city);
	 		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), batchStartDate.replaceAll("-", "/")+" to "+batchEndDate.replaceAll("-", "/"));
			tSp.clickToGetBatchActionMenu(batchID);
 			tSp.selectApplyToBatch(batchID);
 			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
  		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
 			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applied Successfully");
 			tSp.clickOK();
 		}
	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
	   	JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-1000)", "");
		tSp.clickViewMyBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0,"OMG! No show of applied batch - "+batchID+" in View Batches <-> My Batches Section!!! ");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), state+"/"+city);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), batchDomainJobRole+" ("+batchDomainJobRoleCode+") , "+batchPlatformJobRole+" ("+batchPlatformJobRoleCode+")");  
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), "Applied");
		//Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), formatter.format(date));
		//Accepted Batch - View Details Data Verification
		tSp.clickToGetAcceptedBatchActionMenu(batchID);
		tSp.selectAcceptedBatchViewDetails(batchID);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch ID')]]])[1]/div[1]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Name')]]])[1]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Type')]]])[1]/div[1]")).getText().trim(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Date')]]])[1]/div[2]")).getText().trim().replaceAll("/", "-"), batchStartDate+" to "+batchEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[1]")).getText().trim(), batchSector);
//		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[2]")).getText().trim(), batchSubSector);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Fee')]]])[1]/div[2]")).getText().trim(), batchFees);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of Training Center')]]]/div[1]")).getText().trim(), tcName);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Training Partner')]]]/div[2]")).getText().trim(), tcTPName);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mobile Number')]]]/div[1]")).getText().trim(), tcSPOCMobile);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Email ID')]]]/div[2]")).getText().trim(), tcSPOCEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Center Address')]]]/div[1]")).getText().trim(), tcAddress);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Nearby Landmark')]]]/div[2]")).getText().trim(), tcLandmark);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Pincode')]]]/div[1]")).getText().trim(), tcPinCode);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'District')]]]/div[2]")).getText().trim(), tcDistrict);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'State')]]]/div[1]")).getText().trim(), tcState);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Parliamentary')]]]/div[2]")).getText().trim(), tcParlimentaryConstituency);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mandal')]]]/div[1]")).getText().trim(), tcMandal);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[1]")).getText().trim(), batchDomainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[2]")).getText().trim(), batchDomainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[4]")).getText().trim(), domainMasterTrainerName+" ("+domainMasterTrainerID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[5]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[6]")).getText().trim(), domainAssessmentAgencyName+" ("+domainAssessmentAgencyID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[1]")).getText().trim(), batchPlatformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[2]")).getText().trim(), batchPlatformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[4]")).getText().trim(), platformMasterTrainerName+" ("+platformMasterTrainerID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[5]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[6]")).getText().trim(), platformAssessmentAgencyName+" ("+platformAssessmentAgencyID+")");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
 	}
	//Trainer Applicants Approval Process From Location Based TC and SSC
    @Test(dataProvider="totApplicantsData", dependsOnMethods="totApplicantsSearchAndApplyForAvailableBatchTC_03")
    public void tcApprovingToT_ApplicantsTC_04(String serialNum, String trainerID, String paymentDate, String userType, String name, String email, String mobile, String applicantPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String paymentMode, String bankName, String paymentReferenceNumber, String paymentRemarks) throws Exception
    {
 	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
 	   LoginPage lp=new LoginPage(driver);
 	   lp.clickLogin();
 	   Thread.sleep(2000);
	   BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
	   bvp.clickToClose();
	   Thread.sleep(2000);
 	   EnterLoginPage elp=new EnterLoginPage(driver);
 	   String batchID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 1);
	   String batchSize=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 24);
	   String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 9);
	   String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 10);
 	   elp.performlogin(tcID, tcPassword);
 	   WebDriverWait wait=new WebDriverWait(driver, 60);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
 	   LocationBasedTC_DashboardPage tcDp=new LocationBasedTC_DashboardPage(driver);
 	   JavascriptExecutor js=(JavascriptExecutor)driver;
 	   js.executeScript("window.scrollBy(0,200)","");
 	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   tcDp.clickToViewBatches();
 	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
 	   tcVp.clickToViewAllAcceptedBatches();
 	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   tcVp.enterToSearchForBatchID(batchID);
 	   tcVp.clickToGetSearchResult();
 	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchID);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), batchType);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), batchDomainJobRole+" ("+batchDomainJobRoleCode+"),\n"+batchPlatformJobRole+" ("+batchPlatformJobRoleCode+")");   
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), batchSize);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[6]")).getText().trim(), batchStartDate+" to "+batchEndDate);
	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Published");
 	   tcVp.clikToGetBatchActionMenu();
 	   tcVp.selectEnrollApplicantsOption();
 	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+trainerID+"']]")).size()==1,"OMG!!! No show of Trainer Applicant - "+trainerID+" who has applied for the Batch - "+batchID+" OR Something went wrong! ");
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[2]")).getText().trim(), trainerID);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[3]")).getText().trim(), name);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[4]")).getText().trim(), email);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[5]")).getText().trim(), mobile);
 	   tcVp.clickToGetApplicantActionMenu(trainerID);
 	   tcVp.selectViewDetailsOfApplicantOption(trainerID);
 	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
	   if(language.equalsIgnoreCase("Kannada,English,Hindi"))
	   {
		   String parts[]=language.split(",");
		   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
		   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
		   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[2]));
	   }
	   else if(language.equalsIgnoreCase("Kannada,Hindi"))
	   {
		   String parts[]=language.split(",");
		   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
		   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
	   }
	   else if(language.equalsIgnoreCase("Hindi"))
	   {
		   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(language));
	   }
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
 	   Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
 	   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
 	   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
 	   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
 	   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
 	   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
 	   tcVp.clickGoBack();
 	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   if(serialNum.equals("1"))
 	   {
 		   tcVp.clickToSelectApplicantToBeEnrolled(trainerID);
 		   Assert.assertTrue(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]//input[@name='Checkbox']")).isSelected(),"OMG!!! checkbox not selected for trainer applicant - "+trainerID);
 		   tcVp.clickToEnrollAllSelectedApplicants();
 		   tcVp.clickToFinallyEnrollSelectedApplicants();
 	   }
 	   else
 	   {
 		   tcVp.clickToGetApplicantActionMenu(trainerID);
 		   tcVp.selectEnrollApplicantOption(trainerID);
 		   tcVp.clickOk();
 	   }
 	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   if(serialNum.equals("1")||serialNum.equals("2"))
 	   {
 		   tcVp.clickToGoToAppliedApplicantsSection();
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	 	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+trainerID+"')]]")).size()==0,"OMG!!! Enrolled Trainer Applicant - "+trainerID+" Still present in Applied Applicants Section!!! OR Something went wrong! ");
  	   }
 	   tcVp.clickToGoToEnrolledApplicantsSection();
 	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+trainerID+"')]]")).size()==1,"OMG!!! No show of Enrolled Trainer Applicant - "+trainerID+" in Enrolled Applicants Section!!! OR Something went wrong! ");
 	   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+trainerID+"']")).getText().trim(), trainerID);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[contains(text(),'"+name+"')]")).getText().trim(), name);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[contains(text(),'"+email+"')]")).getText().trim(), email);
 	   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[contains(text(),'"+mobile+"')]")).getText().trim(), mobile);
 	   //Sending Batch To SSC For Approval
 	   if(serialNum.equals("5"))
 	   {
 		   tcVp.clickToSendBatchForApproval();
 		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
 		   Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Submitted for Approval");
 		   Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+") has been submitted for approval to SSC");
 		   tcVp.clickOk();
 	 	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   tcVp.clickToViewAllAcceptedBatches();
 	 	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	 	   tcVp.enterToSearchForBatchID(batchID);
 	 	   tcVp.clickToGetSearchResult();
 	 	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Submitted for Approval");
 	   }
 	   else
 	   {
 		   tcVp.clickToGetApplicantActionMenu(trainerID);
 		   tcVp.selectViewDetailsOfApplicantOption(trainerID);
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
		   if(language.equalsIgnoreCase("Kannada,English,Hindi"))
		   {
			   String parts[]=language.split(",");
			   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
			   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
			   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[2]));
		   }
		   else if(language.equalsIgnoreCase("Kannada,Hindi"))
		   {
			   String parts[]=language.split(",");
			   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
			   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
		   }
		   else if(language.equalsIgnoreCase("Hindi"))
		   {
			   Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(language));
		   }
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
		   Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
 		   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
 		   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
 		   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
 		   Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
 		   Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
 	   }
 	   PostLoginPage plp=new PostLoginPage(driver);
 	   plp.clickOnProfileLogo();
 	   Thread.sleep(2000);
 	   plp.clickOnLogout();
    }
    
    //Applicant Adding Fees Payment Details After TC Approval
    @Test(dataProvider="totApplicantsData", dependsOnMethods="tcApprovingToT_ApplicantsTC_04")
    public void batchFeesPaymentByToT_ApplicantsTC_05(String serialNum, String trainerID, String paymentDate, String userType, String name, String email, String mobile, String applicantPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String paymentMode, String bankName, String paymentReferenceNumber, String paymentRemarks) throws Exception
    {
    	if((!serialNum.endsWith("1")) && (!serialNum.endsWith("3")))
    	{
    		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
    		LoginPage lp=new LoginPage(driver);
    		lp.clickLogin();
    		Thread.sleep(2000);
		    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
		    bvp.clickToClose();
		    Thread.sleep(2000);
    		EnterLoginPage elp=new EnterLoginPage(driver);
    		elp.performlogin(trainerID, applicantPassword);
    		TrainerApplicantDashboardPage tDp=new TrainerApplicantDashboardPage(driver);
    		tDp.clickToGetApplicantDashboard();
    		WebDriverWait wait=new WebDriverWait(driver, 30);
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tDp.clickViewBatches();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		String batchID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 1);
//    		String batchCreatedDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 2);
    		String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 9);
    		String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 10);
    		String domainTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 15);
    		String domainTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 16);
    		String domainAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 17);
    		String domainAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 18);
    		String platformTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 19);
    		String platformTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 20);
    		String platformAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 21);
    		String platformAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 22);
    		TrainerApplicantViewBatchesPage tVp=new TrainerApplicantViewBatchesPage(driver);
    		tVp.enterBatchIDTosearch(batchID);
    		tVp.clickToGetSearchResult();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[1]")).getText().trim(), batchID);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[2]")).getText().trim(), batchType);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[3]")).getText().trim(), state+"/"+city);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[4]")).getText().trim(), batchDomainJobRole+" ("+batchDomainJobRoleCode+") , "+batchPlatformJobRole+" ("+batchPlatformJobRoleCode+")");
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), "Enrolled");
    		tVp.clickToGetEnrolledBatchActionMenu(batchID);
    		tVp.selectAddPaymentDetailsForEnrolledBatchOption(batchID);
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch ID')]]])[1]/div[1]")).getText().trim(), batchID);
    		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Name')]]])[1]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
    		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Applicant ID')]]])[1]/div[1]")).getText().trim(), trainerID);
    		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Applicant Name')]]])[1]/div[2]")).getText().trim(), name);
    		tVp.selectPaymentMode(paymentMode);
    		if(!paymentMode.equalsIgnoreCase("cash"))
    		{
    			tVp.selectBankName(bankName);
    		}
    		tVp.enterPaymentReferenceNumber(paymentReferenceNumber);
    		tVp.selectDateOfPayment();
    		String dateOfPayment=driver.findElement(By.xpath("//input[@formcontrolname='dateOfPayment']")).getAttribute("value");
    		ReadWriteData.setExcelData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", Integer.parseInt(serialNum), 2, dateOfPayment);
    		Assert.assertFalse(driver.findElement(By.xpath("//input[@formcontrolname='amount']")).isEnabled(),"OMG!!! Fees TextField should be disabled OR Something went wrong!");
    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='amount']")).getAttribute("value").trim(), batchFees);
    		tVp.enterPaymentRemarks(paymentRemarks);
    		tVp.clickToSubmitPaymentDetails();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
    		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Payment Details Added Successfully !!");
    		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "Payment details has been added to the "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
    		tVp.clickOK();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("swal2-container.swal2-center.swal2-fade.swal2-shown")));
  	 	   	tVp.enterBatchIDTosearch(batchID);
  	 	   	tVp.clickToGetSearchResult();
  	 	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
  	 	   	tVp.clickToGetEnrolledBatchActionMenu(batchID);
    		tVp.selectViewDetailsForEnrolledBatchOption(batchID);
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch ID')]]])[1]/div[1]")).getText().trim(), batchID);
    		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Name')]]])[1]/div[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
    		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Type')]]])[1]/div[1]")).getText().trim(), batchType);
    		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Date')]]])[1]/div[2]")).getText().trim().replaceAll("/", "-"), batchStartDate+" to "+batchEndDate);
    		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[1]")).getText().trim(), batchSector);
//    		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Sector')]]])[1]/div[2]")).getText().trim(), batchSubSector);
    		Assert.assertEquals(driver.findElement(By.xpath("(//div[label[b[contains(text(),'Batch Fee')]]])[1]/div[2]")).getText().trim(), batchFees);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of Training Center')]]]/div[1]")).getText().trim(), tcName);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Training Partner')]]]/div[2]")).getText().trim(), tcTPName);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mobile Number')]]]/div[1]")).getText().trim(), tcSPOCMobile);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Email ID')]]]/div[2]")).getText().trim(), tcSPOCEmail);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Center Address')]]]/div[1]")).getText().trim(), tcAddress);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Nearby Landmark')]]]/div[2]")).getText().trim(), tcLandmark);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Pincode')]]]/div[1]")).getText().trim(), tcPinCode);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'District')]]]/div[2]")).getText().trim(), tcDistrict);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'State')]]]/div[1]")).getText().trim(), tcState);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Parliamentary')]]]/div[2]")).getText().trim(), tcParlimentaryConstituency);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mandal')]]]/div[1]")).getText().trim(), tcMandal);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[1]")).getText().trim(), batchDomainJobRoleCode);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[2]")).getText().trim(), batchDomainJobRole);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[3]")).getText().trim(), domainTrainingStartDate+" to "+domainTrainingEndDate);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[4]")).getText().trim(), domainMasterTrainerName+" ("+domainMasterTrainerID+")");
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[5]")).getText().trim(), domainAssessmentStartDate+" to "+domainAssessmentEndDate);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[6]")).getText().trim(), domainAssessmentAgencyName+" ("+domainAssessmentAgencyID+")");
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[1]")).getText().trim(), batchPlatformJobRoleCode);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[2]")).getText().trim(), batchPlatformJobRole);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[3]")).getText().trim(), platformTrainingStartDate+" to "+platformTrainingEndDate);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[4]")).getText().trim(), platformMasterTrainerName+" ("+platformMasterTrainerID+")");
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[5]")).getText().trim(), platformAssessmentStartDate+" to "+platformAssessmentEndDate);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[6]")).getText().trim(), platformAssessmentAgencyName+" ("+platformAssessmentAgencyID+")");
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mode of Payment')]]]/div[1]")).getText().trim(), paymentMode);
    		if(!paymentMode.equalsIgnoreCase("cash"))
    		{
    			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of Bank')]]]/div[2]")).getText().trim(), bankName);
    		}
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Date of Payment')]]]/div[1]")).getText().trim(), dateOfPayment.replaceAll("/", "-"));
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Reference No')]]]/div[2]")).getText().trim(), paymentReferenceNumber);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Amount')]]]/div[1]")).getText().trim(), batchFees);
    		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Any Remarks')]]]/div[2]")).getText().trim(), paymentRemarks);
    		PostLoginPage plp=new PostLoginPage(driver);
    		plp.clickOnProfileLogo();
    		Thread.sleep(2000);
    		plp.clickOnLogout();
    	}
    }
  
    @Test(dataProvider="totApplicantsData", dependsOnMethods="batchFeesPaymentByToT_ApplicantsTC_05")
    public void sscApprovingToT_ApplicantsTC_06(String serialNum, String trainerID, String paymentDate, String userType, String name, String email, String mobile, String applicantPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String paymentMode, String bankName, String paymentReferenceNumber, String paymentRemarks) throws Exception
    {
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
   	 	LoginPage lp=new LoginPage(driver);
   	 	lp.clickLogin();
   	 	Thread.sleep(2000);
	    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
	    bvp.clickToClose();
	    Thread.sleep(2000);
   	 	EnterLoginPage elp=new EnterLoginPage(driver);
   	 	elp.performlogin(sscID, sscPassword);
   	 	WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("ToT, ToA, ToMT,ToMA"))));
   	 	SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
   	 	sDp.click_ToAToMTToMA();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 	JavascriptExecutor js=(JavascriptExecutor)driver;
   	 	sDp.clickAllBatches();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 	SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
   	 	sAp.clickToViewAllPublishedBatches();
   	 	String batchID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 1);
   	 	String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 9);
   	 	String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 10);
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 	sAp.enterBatchIDToSearch(batchID);
	   	sAp.clickToGetSearchResult();
	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(), "Submitted for Approval");
   	 	sAp.clickToGetBatchActionMenu(batchID);
   	 	sAp.selectApproveApplicantsOption(batchID);
   	 	SSC_ViewBatchDetailsPage sVp=new SSC_ViewBatchDetailsPage(driver);
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 	sVp.clickToGoToEnrolledApplicantsSection();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+trainerID+"']]")).size()==1,"OMG!!! No show of TC Approved Trainer Applicant - "+trainerID+" in Enrolled Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[2]")).getText().trim(), trainerID);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[3]")).getText().trim(), name);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[4]")).getText().trim(), email);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[5]")).getText().trim(), mobile);
   	 	if(paymentMode.equalsIgnoreCase("N/A"))
   	 	{
   	   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[6]")).getText().trim(), "Unpaid");
   	 	}
   	 	else
   	 	{
   	   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[6]")).getText().trim(), "Paid");
   	 	}
   	 	sVp.clickToGetApplicantActionMenu(trainerID);
   	 	sVp.selectViewDetailsOfApplicantOption(trainerID);
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
   	 	if(language.equalsIgnoreCase("Kannada,English,Hindi"))
   	 	{
   	 		String parts[]=language.split(",");
   	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
   	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
   	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[2]));
   	 	}
   	 	else if(language.equalsIgnoreCase("Kannada,Hindi"))
   	 	{
   	 		String parts[]=language.split(",");
   	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
   	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
   	 	}
   	 	else if(language.equalsIgnoreCase("Hindi"))
   	 	{
   	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(language));
   	 	}
   	  	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
   	 	Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
   	 	Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
   	 	Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
   	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
   	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
   	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
   	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
   	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
   	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
   	 	//Verifying Fees Payment Details
   	 	if(paymentMode.equalsIgnoreCase("N/A"))
   	 	{
   	   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Fee Payment')]]/div[1]")).getText().trim(), "Payment Not Received");
   	 	}
   	 	else
   	 	{
   	   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Fee Payment')]]/div[1]")).getText().trim(), "Payment Received");
   	 	}
   	 	if(!paymentMode.equalsIgnoreCase("N/A"))
   	 	{
   	 	sVp.clickToViewPaymentDetails();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch ID')]]]/div[2]")).getText().trim(), batchID);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mode of Payment')]]]/div[2]")).getText().trim(), paymentMode);
   	 	if(!paymentMode.equalsIgnoreCase("cash"))
   	 	{
   	  	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of the Bank')]]]/div[2]")).getText().trim(), bankName);
   	 	}
 	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Date of Payment')]]]/div[2]")).getText().trim(), paymentDate);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Reference No')]]]/div[2]")).getText().trim(), paymentReferenceNumber);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Amount')]]]/div[2]")).getText().trim(), batchFees);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Any Remarks')]]]/div[2]")).getText().trim(), paymentRemarks);
   	 	sVp.clickOk();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 	}
   	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Total Fee of the program ')]]//div")).getText().trim(), batchFees);
   	 	js.executeScript("window.scrollBy(0,-1000)", "");
   	 	sVp.clickGoBack(); 
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 	sVp.clickToGoToEnrolledApplicantsSection();
   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 	if(serialNum.equals("1")||serialNum.equals("2"))
   	 	{
   	 		sVp.clickToSelectApplicantToBeApproved(trainerID);
   	 		if(paymentMode.equalsIgnoreCase("N/A"))
   	 		{
   	 			sVp.clickToApproveAllSelectedApplicants();
   	 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
   	 			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim(),"Only paid candidates can be approved");
   	 			sVp.clickToApproveAllSelectedUnpaidApplicants();
   	 			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+trainerID+"')]]")).size()==0,"OMG!!! SSSC Approved Applicant - "+trainerID+" should not be displayed in Enrolled Applicnats Section OR Something went wrong!");
   	 		}
   	 		else
   	 		{
   	 			sVp.clickToApproveAllSelectedApplicants();
   	 			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+trainerID+"')]]")).size()==0,"OMG!!! SSC Approved Applicant - "+trainerID+" should not be displayed in Enrolled Applicnats Section OR Something went wrong!");
   	 		}
   	 	}
   	 	else
   	 	{
   	 		sVp.clickToGetApplicantActionMenu(trainerID);
   	 		if(paymentMode.equalsIgnoreCase("N/A"))
   	 		{
   	 			sVp.selectApproveWithoutPaymentOption(trainerID);
   	 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
   	 			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applicant Approved\nApplicant successfully approved for "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
   	 			sVp.clickOk();
   	 			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+trainerID+"')]]")).size()==0,"OMG!!! SSSC Approved Applicant - "+trainerID+" should not be displayed in Enrolled Applicnats Section OR Something went wrong!");
   	 		}
   	 		else
   	 		{
   	 			sVp.selectApproveOfApplicantOption(trainerID);
   	 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
   	 			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applicant Approved\nApplicant successfully approved for "+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
	 			sVp.clickOk();
	 			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+trainerID+"')]]")).size()==0,"OMG!!! SSSC Approved Applicant - "+trainerID+" should not be displayed in Enrolled Applicnats Section OR Something went wrong!");
   	 		}
   	 	}
   	 	js.executeScript("window.scrollBy(0,-1000)", "");
   	 	sVp.clickToGoToApprovedApplicantsSection();
   	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 	//Verifying SSC Approved Applicants
   	 	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+trainerID+"']]")).size()==1,"OMG!!! No show of SSC Approved Assessor Applicant - "+trainerID+" in Approved Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[2]")).getText().trim(), trainerID);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[3]")).getText().trim(), name);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[4]")).getText().trim(), email);
   	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[5]")).getText().trim(), mobile);
   	 	if(serialNum.equals("5"))
	 	{
   	 		sVp.clickToApproveBatch();
   		 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
 	 		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("Batch Approved Successfully\n"+batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")"));
   	 		sVp.clickOk();
   	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 		sAp.clickToViewAllPublishedBatches();
   	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[1][contains(text(),'"+batchID+"')]]/td[8]")).getText().trim(),"Approved");
   	 		sAp.clickToGetBatchActionMenu(batchID);
   	 		sAp.selectViewDetailsOption(batchID);
   	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 		sVp.clickToGoToApprovedApplicantsSection();
   	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 		sVp.clickToApproveBatch();
   	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim(), "Batch is already approved");
	 	}
   	 	else
   	 	{
   	 		sVp.clickToGetApplicantActionMenu(trainerID);
   	 		sVp.selectViewDetailsOfApplicantOption(trainerID);
   	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
   	 		if(language.equalsIgnoreCase("Kannada,English,Hindi"))
   	 		{
   	 			String parts[]=language.split(",");
   	 			Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
   	 			Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
   	 			Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[2]));
   	 		}
   	 		else if(language.equalsIgnoreCase("Kannada,Hindi"))
   	 		{
   	 			String parts[]=language.split(",");
   	 			Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
   	 			Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
   	 		}
   	 		else if(language.equalsIgnoreCase("Hindi"))
   	 		{
   	 			Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(language));
   	 		}   
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
   	 		Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
   	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
   	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
   	 		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
   	 		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
   	 		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
   	 		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
   	 		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
   	 		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
   	 		Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
   	 		Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
   	 		//Verifying Fees Payment Details
   	 		if(paymentMode.equalsIgnoreCase("N/A"))
   	 		{
   	 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Fee Payment')]]/div[1]")).getText().trim(), "Payment Not Received");
   	 		}
   	 		else
   	 		{
   	 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Fee Payment')]]/div[1]")).getText().trim(), "Payment Received");
   	 		}
   	 		if(!paymentMode.equalsIgnoreCase("N/A"))
   	 		{
   	 			sVp.clickToViewPaymentDetails();
   	 			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch ID')]]]/div[2]")).getText().trim(), batchID);
   	 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Mode of Payment')]]]/div[2]")).getText().trim(), paymentMode);
   	 			if(!paymentMode.equalsIgnoreCase("cash"))
   	 			{
   	 				Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Name of the Bank')]]]/div[2]")).getText().trim(), bankName);
   	 			}
 	 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Date of Payment')]]]/div[2]")).getText().trim(), paymentDate);
   	 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Reference No')]]]/div[2]")).getText().trim(), paymentReferenceNumber);
   	 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Amount')]]]/div[2]")).getText().trim(), batchFees);
   	 			Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Any Remarks')]]]/div[2]")).getText().trim(), paymentRemarks);
   	 			sVp.clickOk();
   	 			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 		}
   	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 		js.executeScript("window.scrollBy(0,-1000)", "");
   	 	}
   	 	PostLoginPage plp=new PostLoginPage(driver);
   	 	plp.clickOnProfileLogo();
   	 	Thread.sleep(2000);
   	 	plp.clickOnLogout();
   	 	Thread.sleep(2000);
    } 
    
    //display of SSC approved Batch & Applicants details for TC, Master Trainer, Assessment Agency and Master Assessor
    @Test(dataProvider="totApplicantsData", dependsOnMethods="sscApprovingToT_ApplicantsTC_06")
    public void trainingCentreVerifyingSSCApprovedBatchAndApplicantsTC_07(String serialNum, String trainerID, String paymentDate, String userType, String name, String email, String mobile, String applicantPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String paymentMode, String bankName, String paymentReferenceNumber, String paymentRemarks) throws Exception
    {
    	if(serialNum.equals("1")) {
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
  	   	LoginPage lp=new LoginPage(driver);
  	   	lp.clickLogin();
  	   	Thread.sleep(2000);
	    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
	    bvp.clickToClose();
	    Thread.sleep(2000);
  	   	EnterLoginPage elp=new EnterLoginPage(driver);
  	   	String batchID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 1);
  	   	String batchSize=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 24);
  	   	String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 9);
  	   	String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 10);
  	   	String dTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 15);
  	   	String dTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 16);
  	   	String dAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 17);
  	   	String dAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 18);
  	   	String pTrainingStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 19);
  	   	String pTrainingEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 20);
  	   	String pAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 21);
  	   	String pAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 22);
  	   	elp.performlogin(tcID, tcPassword);
  	   	WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='View Batches']")));
		LocationBasedTC_DashboardPage lTcDp=new LocationBasedTC_DashboardPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		lTcDp.clickToViewBatches();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		js.executeScript("window.scrollBy(0,200)","");
  	   	LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
  	   	tcVp.clickToViewAllAcceptedBatches();
  	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
  	   	tcVp.enterToSearchForBatchID(batchID);
  	   	tcVp.clickToGetSearchResult();
  	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
  	   	Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! SSC Approved Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
  	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[7]")).getText().trim(), "Approved");
  	   	tcVp.clikToGetBatchActionMenu();
  	   	tcVp.selectViewBatchDetailsOption();
  	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
  	   	tcVp.clickToGoToBatchDetailsSection();
  	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
  		//Verifying Batch Details
  		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch ID:')]]]/label[2]")).getText().trim(), batchID);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Name:')]]]/label[2]")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Size:')]]]/label[2]")).getText(), batchSize);
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Date')]]]/label[2]")).getText().trim(), batchStartDate.replaceAll("-", "/")+" to "+batchEndDate.replaceAll("-", "/"));
		Assert.assertEquals(driver.findElement(By.xpath("//div[label[b[contains(text(),'Batch Type:')]]]/label[2]")).getText(), batchType);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[1]")).getText().trim(), batchDomainJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[2]")).getText(), batchDomainJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[3]")).getText(), dTrainingStartDate+" to "+dTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRoleCode+"')]]/td[4]")).getText(), dAssessmentStartDate+" to "+dAssessmentEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[1]")).getText().trim(), batchPlatformJobRoleCode);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[2]")).getText(), batchPlatformJobRole);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[3]")).getText(), pTrainingStartDate+" to "+pTrainingEndDate);
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRoleCode+"')]]/td[4]")).getText(), pAssessmentStartDate+" to "+pAssessmentEndDate);
  		//Verifying Applicants Details
		tcVp.clickToGoToEnrolledApplicantsSection();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
  	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[1]")).getText().trim(), trainerID);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[2]")).getText().trim(), name);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[3]")).getText().trim(), email);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[4]")).getText().trim(), mobile);
  	   	tcVp.clickToGetApplicantActionMenu(trainerID);
  	   	tcVp.selectViewDetailsOfApplicantOption(trainerID);
  	   	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
  	   	if(language.equalsIgnoreCase("Kannada,English,Hindi"))
 	 	{
 	 		String parts[]=language.split(",");
 	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
 	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
 	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[2]));
 	 	}
 	 	else if(language.equalsIgnoreCase("Kannada,Hindi"))
 	 	{
		   	String parts[]=language.split(",");
		   	Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
		   	Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
 	 	}
 	 	else if(language.equalsIgnoreCase("Hindi"))
 	 	{
 	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(language));
 	 	} 
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
  	   	Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
  	   	Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
  	   	Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
  	   	Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
  	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
  	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
  	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
  	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
  	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
  	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
  	   	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
  	   	PostLoginPage plp=new PostLoginPage(driver);
  	   	plp.clickOnProfileLogo();
  	   	Thread.sleep(2000);
  	   	plp.clickOnLogout();
  	}}
    
    @Test(dataProvider="totApplicantsData", dependsOnMethods="sscApprovingToT_ApplicantsTC_06")
    public void masterTrainerVerifyingSSCApprovedBatchAndApplicantsTC_08(String serialNum, String trainerID, String paymentDate, String userType, String name, String email, String mobile, String applicantPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String paymentMode, String bankName, String paymentReferenceNumber, String paymentRemarks) throws Exception
    {
    	if(serialNum.equals("1")) {
    	String batchID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 1);
    	String batchSize=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 24);
    	String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 9);
    	String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 10);
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
	    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
	    bvp.clickToClose();
	    Thread.sleep(2000);
		EnterLoginPage elp=new EnterLoginPage(driver);
    	if(!platformMasterTrainerID.equalsIgnoreCase(domainMasterTrainerID))
    	{
    		for(int i=1;i<3;i++)
        	{
        		if(i==1)
        		{
        			elp.performlogin(domainMasterTrainerID, domainMasterTrainerPassword);
        		}
        		else
        		{
        			lp.clickLogin();
        			Thread.sleep(2000);
        		    bvp.clickToClose();
        		    Thread.sleep(2000);
        			elp.performlogin(platformMasterTrainerID, platformMasterTrainerPassword);
        		}
        		TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
        		tDp.clickToGetTrainerDashboard();
        		WebDriverWait wait=new WebDriverWait(driver, 60);
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		tDp.clickAllBatches();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
        		tVp.clickToGoToAcceptedBatchesSection();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		JavascriptExecutor js=(JavascriptExecutor)driver;
        		js.executeScript("window.scrollBy(0,200)", "");
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockMsg.blockPage")));
        		tVp.enterBatchIDToSearch(batchID);
        		tVp.clickToGetSearchFilterResult();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Approved");
        		tVp.clickToGetActionMenuOptions(batchID);
        		tVp.clickToSelectViewDetailsOption(batchID);
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		tVp.clickToGoToBatchDetailsSection();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector')]]/td[3]")).getText().trim(), batchSector);
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Type')]]/td[3]")).getText().trim(), batchType);
        		if(i==1)
        		{
        			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), batchDomainJobRole);
        			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[2]")).getText().trim(), batchDomainJobRoleCode);
        		}
        		else
        		{
        			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), batchPlatformJobRole);
        			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[2]")).getText().trim(), batchPlatformJobRoleCode);
        		}
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Status')]]/td[3]")).getText().trim(), "Accepted");
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tcTPName);
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), tcState);
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), tcDistrict);
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
        		//Applicant Details Verification
        		tVp.clickToGoToApprovedApplicantsSection();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[1]")).getText().trim(), trainerID);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[2]")).getText().trim(), name);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[3]")).getText().trim(), email);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[4]")).getText().trim(), mobile);
           	 	tVp.clickToGetApplicantActionMenu(trainerID);
           	 	tVp.selectViewDetailsOfApplicantOption(trainerID);
           	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
           	 	if(language.equalsIgnoreCase("Kannada,English,Hindi"))
        	 	{
        	 		String parts[]=language.split(",");
        	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
        	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
        	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[2]));
        	 	}
        	 	else if(language.equalsIgnoreCase("Kannada,Hindi"))
        	 	{
     		   	String parts[]=language.split(",");
     		   	Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
     		   	Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
        	 	}
        	 	else if(language.equalsIgnoreCase("Hindi"))
        	 	{
        	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(language));
        	 	} 
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
           	 	Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
           	 	Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
           	 	Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
           	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
           	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
           	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
           	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
           	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
           	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
           	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
           	 	PostLoginPage plp=new PostLoginPage(driver);
           	 	plp.clickOnProfileLogo();
           	 	Thread.sleep(2000);
           	 	plp.clickOnLogout();
           	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
        	}
    	}
    	else
    	{
            elp.performlogin(domainMasterTrainerID, domainMasterTrainerPassword);
    		TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
    		tDp.clickToGetTrainerDashboard();
    		WebDriverWait wait=new WebDriverWait(driver, 60);
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tDp.clickAllBatches();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
    		tVp.clickToGoToAcceptedBatchesSection();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("window.scrollBy(0,200)", "");
    		tVp.enterBatchIDToSearch(batchID);
    		tVp.clickToGetSearchFilterResult();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Approved");
    		tVp.clickToGetActionMenuOptions(batchID);
    		tVp.clickToSelectViewDetailsOption(batchID);
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tVp.clickToGoToBatchDetailsSection();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Size')]]/td[3]")).getText().trim(), batchSize);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Date')]]/td[3]")).getText().trim(), batchStartDate+" to "+batchEndDate);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Sector')]]/td[3]")).getText().trim(), batchSector);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Batch Type')]]/td[3]")).getText().trim(), batchType);		
            Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[1]")).getText().trim(), batchDomainJobRole);
            Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[2]")).getText().trim(), batchDomainJobRoleCode);
            Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[3]")).getText().trim(), batchPlatformJobRole);
			Assert.assertEquals(driver.findElement(By.xpath("(//tr[td[contains(text(),'Job Role')]]/td[3])[4]")).getText().trim(), batchPlatformJobRoleCode);
            Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'Status')]]/td[3]")).getText().trim(), "Accepted");
            Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
            Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
            Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tcTPName);
            Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), tcState);
            Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), tcDistrict);
            Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
            //Applicant Details Verification
            tVp.clickToGoToApprovedApplicantsSection();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
            Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[1]")).getText().trim(), trainerID);
            Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[2]")).getText().trim(), name);
            Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[3]")).getText().trim(), email);
            Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[4]")).getText().trim(), mobile);
       	 	tVp.clickToGetApplicantActionMenu(trainerID);
       	 	tVp.selectViewDetailsOfApplicantOption(trainerID);
       	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Name of the Applicant')]]/div[1]")).getText().trim(), name);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Date of Birth')]]/div[2]")).getText().trim(), dob);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Gender')]]/div[1]")).getText().trim(), gender);
       	 	if(language.equalsIgnoreCase("Kannada,English,Hindi"))
    	 	{
    	 		String parts[]=language.split(",");
    	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
    	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
    	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[2]));
    	 	}
    	 	else if(language.equalsIgnoreCase("Kannada,Hindi"))
    	 	{
 		   	String parts[]=language.split(",");
 		   	Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[0]));
 		   	Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(parts[1]));
    	 	}
    	 	else if(language.equalsIgnoreCase("Hindi"))
    	 	{
    	 		Assert.assertTrue(driver.findElement(By.xpath("//div[label[contains(text(),'Language Known')]]/div[2]")).getText().contains(language));
    	 	} 
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Religion')]]/div[1]")).getText().trim(), religion);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Category')]]/div[2]")).getText().trim(), category);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Mobile Number of Applicant')]]/div[1]")).getText().trim(), mobile);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Pincode')]]/div[2]")).getText().trim(), pincode);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Email Address of Applicant')]]/div[1]")).getText().trim(), email);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'State')]]/div[2]")).getText().trim(), state);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Address')]]/div[1]")).getText().trim(), address);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'District')]]/div[2]")).getText().trim(), city);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Nearby Landmark')]]/div[1]")).getText().trim(), landmark);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Tehsil')]]/div[2]")).getText().trim(), mandal);
       	 	Assert.assertEquals(driver.findElement(By.xpath("(//label[contains(text(),'"+education1+"')])[1]")).getText().trim(), education1+" :");
       	 	Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details1+"')]")).getText().trim(), edu_details1);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+education2+"')]")).getText().trim(), education2+" :");
       	 	Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+edu_details2+"')]")).getText().trim(), edu_details2);
       	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector1+" :");
       	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails1);
       	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector1+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years1+" years "+industrial_months1+" months");
       	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[1]/label")).getText().trim(), industrial_sector2+" :");
       	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[2]/label")).getText().trim(), industrialExperienceDetails2);
       	 	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'"+industrial_sector2+"')]]])[1]/div[3]/label")).getText().trim(), industrial_years2+" years "+industrial_months2+" months");
       	 	Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'Applicant Type')]]/div/label[contains(text(),'"+userType+"')]")).getText().trim(), userType);
       	 	PostLoginPage plp=new PostLoginPage(driver);
       	 	plp.clickOnProfileLogo();
       	 	Thread.sleep(2000);
       	 	plp.clickOnLogout();
    	}
    }}
      
    @Test(dataProvider="totApplicantsData", dependsOnMethods="sscApprovingToT_ApplicantsTC_06")
    public void assessmentAgencyVerifyingSSCApprovedBatchAndApplicantsTC_09(String serialNum, String trainerID, String paymentDate, String userType, String name, String email, String mobile, String applicantPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String paymentMode, String bankName, String paymentReferenceNumber, String paymentRemarks) throws Exception
    {
    	if(serialNum.equals("1")) {
    	String batchID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 1);
    	String batchSize=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 24);
    	String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 9);
    	String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 10);
    	String dAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 17);
    	String dAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 18);
    	String pAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 21);
    	String pAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 22);
    	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
    	LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
	    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
	    bvp.clickToClose();
	    Thread.sleep(2000);
		EnterLoginPage elp=new EnterLoginPage(driver);
		WebDriverWait wait=new WebDriverWait(driver, 60);
    	if(!platformAssessmentAgencyID.equalsIgnoreCase(domainAssessmentAgencyID))
    	{
    		for(int i=1;i<3;i++)
        	{
            	if(i==1)
        		{
        			elp.performlogin(domainAssessmentAgencyID, domainAssessmentAgencyPassword);
        		}
        		else
        		{
        			lp.clickLogin();
        			Thread.sleep(2000);
        		    bvp.clickToClose();
        		    Thread.sleep(2000);
        			elp.performlogin(platformAssessmentAgencyID, platformAssessmentAgencyPassword);
        		}
        		JavascriptExecutor js=(JavascriptExecutor)driver;
        		js.executeScript("window.scrollBy(0,200)", "");
        		AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
        		aDp.clickBatchAssessmentRequests();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
        		aVp.clickToViewAcceptedBatches();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		aVp.enterBatchIdToSearch(batchID);
        		aVp.clickToApplySelectedSearchFilters();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		aVp.clickToGetActionMenuOptions();
        		aVp.clickToSelectViewBatchDetailsOption();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		aVp.clickToGoToBatchDetailsSection();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]/span")).getText().trim(),batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
    			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch ID')]]]/div[3]/span")).getText().trim(), batchID);
    			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Size')]]]/div[3]/span")).getText().trim(), batchSize);
    			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]/span")).getText().trim(), batchStartDate+" to "+batchEndDate);
    			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
    			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
    			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tcTPName);
    			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), tcState);
    			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), tcDistrict);
    			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
    			if(i==1)
    			{
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[2]")).getText().trim(), batchDomainJobRole+"( "+batchDomainJobRoleCode+" )");
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[3]")).getText().trim(), domainMasterAssessorName+"("+domainMasterAssessorID+")");
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[4]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
    			}
    			else
    			{
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[2]")).getText().trim(), batchPlatformJobRole+"( "+batchPlatformJobRoleCode+" )");
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[3]")).getText().trim(), platformMasterAssessorName+" ("+platformMasterAssessorID+")");
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[4]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
    			}
    			//Applicants Details Verification
        		aVp.clickToGoToApprovedApplicantsSection();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[2]")).getText().trim(), name);
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[3]")).getText().trim(), trainerID);
           	 	PostLoginPage plp=new PostLoginPage(driver);
        		plp.clickOnProfileLogo();
        		Thread.sleep(2000);
        		plp.clickOnLogout();
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
        	}
    	}
    	else
    	{
    		elp.performlogin(domainAssessmentAgencyID, domainAssessmentAgencyPassword);
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("window.scrollBy(0,200)", "");
    		AssessmentAgencyDashboardPage aDp=new AssessmentAgencyDashboardPage(driver);
    		aDp.clickBatchAssessmentRequests();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		AssessmentAgencyViewBatchesPage aVp=new AssessmentAgencyViewBatchesPage(driver);
    		aVp.clickToViewAcceptedBatches();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		aVp.enterBatchIdToSearch(batchID);
    		aVp.clickToApplySelectedSearchFilters();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		aVp.clickToGetActionMenuOptions();
    		aVp.clickToSelectViewBatchDetailsOption();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		aVp.clickToGoToBatchDetailsSection();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Name')]]]/div[3]/span")).getText().trim(),batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch ID')]]]/div[3]/span")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Size')]]]/div[3]/span")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[contains(text(),'Batch Date')]]]/div[3]/span")).getText().trim(), batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tcTPName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), tcState);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), tcDistrict);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[2]")).getText().trim(), batchDomainJobRole+"( "+batchDomainJobRoleCode+" )");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[3]")).getText().trim(), domainMasterAssessorName+"("+domainMasterAssessorID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[4]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[2]")).getText().trim(), batchPlatformJobRole+"( "+batchPlatformJobRoleCode+" )");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[3]")).getText().trim(), platformMasterAssessorName+" ("+platformMasterAssessorID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[4]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
			//Applicants Details Verification
    		aVp.clickToGoToApprovedApplicantsSection();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[2]")).getText().trim(), name);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[3]")).getText().trim(), trainerID);
    		String applicantID_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 2, 1);
       	 	String applicantName_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 2, 4);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_2+"']]/td[2]")).getText().trim(), applicantName_2);
    	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_2+"']]/td[3]")).getText().trim(), applicantID_2);
       	 	String applicantID_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 3, 1);
       	 	String applicantName_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 3, 4);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_3+"']]/td[2]")).getText().trim(), applicantName_3);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_3+"']]/td[3]")).getText().trim(), applicantID_3);
       	 	String applicantID_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 4, 1);
       	 	String applicantName_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 4, 4);
          	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_4+"']]/td[2]")).getText().trim(), applicantName_4);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_4+"']]/td[3]")).getText().trim(), applicantID_4);
       	 	String applicantID_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 5, 1);
       	 	String applicantName_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 5, 4);
          	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_5+"']]/td[2]")).getText().trim(), applicantName_5);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_5+"']]/td[3]")).getText().trim(), applicantID_5);
       	 	PostLoginPage plp=new PostLoginPage(driver);
    		plp.clickOnProfileLogo();
    		Thread.sleep(2000);
    		plp.clickOnLogout();
    	}
      }
    }
    
    @Test(dataProvider="totApplicantsData", dependsOnMethods="sscApprovingToT_ApplicantsTC_06")
    public void masterAssessorVerifyingSSCApprovedBatchAndApplicantsTC_10(String serialNum, String trainerID, String paymentDate, String userType, String name, String email, String mobile, String applicantPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String paymentMode, String bankName, String paymentReferenceNumber, String paymentRemarks) throws Exception
    {
    	if(serialNum.equals("1")) {
    	String batchID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 1);
    	String batchSize=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 24);
    	String batchStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 9);
    	String batchEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 10);
    	String dAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 17);
    	String dAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 18);
    	String pAssessmentStartDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 21);
    	String pAssessmentEndDate=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 1, 22);
    	LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
	    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
	    bvp.clickToClose();
	    Thread.sleep(2000);
		EnterLoginPage elp=new EnterLoginPage(driver);
		WebDriverWait wait=new WebDriverWait(driver, 60);
    	if(!platformMasterAssessorID.equalsIgnoreCase(domainMasterAssessorID))
    	{
    		for(int i=1; i<3;i++)
        	{
        		
        		if(i==1)
        		{
        			elp.performlogin(domainMasterAssessorID, domainMasterAssessorPassword);
        		}
        		else
        		{
        			lp.clickLogin();
        			Thread.sleep(2000);
        		    bvp.clickToClose();
        		    Thread.sleep(2000);
        			elp.performlogin(platformMasterAssessorID, platformMasterAssessorPassword);
        		}
        		AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
        		maDp.clickToGetAssessorDashboard();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		maDp.clickBatchAssessmentRequests();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
        		maVp.clickToGoToAcceptedBatchesSection();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		maVp.enterBatchIDToSearch(batchID);
        		maVp.clickToGetSearchResult();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		maVp.clickToGetActionMenuOptions(batchID);
        		maVp.clickToSelectViewBatchDetailsOption(batchID);
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		maVp.clickToGoToBatchDetailsSection();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Name')]]]]/div[3]/span")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
    			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch ID')]]]]/div[3]/span")).getText().trim(), batchID);
    			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Size')]]]]/div[3]/span")).getText().trim(), batchSize);
    			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Date')]]]]/div[3]/span")).getText().trim(), batchStartDate+" to "+batchEndDate);
    			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
    			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
    			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tcTPName);
    			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), tcState);
    			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), tcDistrict);
    			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
    			if(i==1)
    			{
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[2]")).getText().trim(), batchDomainJobRole+" ("+batchDomainJobRoleCode+")");
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[3]")).getText().trim(), domainAssessmentAgencyName+" ("+domainAssessmentAgencyID+")");
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[4]")).getText().trim(), domainMasterAssessorName+" ("+domainMasterAssessorID+")");
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[5]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
    			}
    			else
    			{
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[2]")).getText().trim(), batchPlatformJobRole+" ("+batchPlatformJobRoleCode+")");
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[3]")).getText().trim(), platformAssessmentAgencyName+" ("+platformAssessmentAgencyID+")");
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[4]")).getText().trim(), platformMasterAssessorName+" ("+platformMasterAssessorID+")");
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[5]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
    				Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
    			}
    			//Applicants Details Verification
        		maVp.clickToGoToApprovedApplicantsSection();
        		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[2]")).getText().trim(), trainerID);
           	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[3]")).getText().trim(), name);
           	 	PostLoginPage plp=new PostLoginPage(driver);
        		plp.clickOnProfileLogo();
        		Thread.sleep(2000);
        		plp.clickOnLogout();
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
        	}
    	}
    	else
    	{
    		elp.performlogin(domainMasterAssessorID, domainMasterAssessorPassword);
        	AssessorDashboardPage maDp=new AssessorDashboardPage(driver);
    		maDp.clickToGetAssessorDashboard();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		maDp.clickBatchAssessmentRequests();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		AssessorViewBatchesPage maVp=new AssessorViewBatchesPage(driver);
    		maVp.clickToGoToAcceptedBatchesSection();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		maVp.enterBatchIDToSearch(batchID);
    		maVp.clickToGetSearchResult();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		maVp.clickToGetActionMenuOptions(batchID);
    		maVp.clickToSelectViewBatchDetailsOption(batchID);
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		maVp.clickToGoToBatchDetailsSection();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Name')]]]]/div[3]/span")).getText().trim(), batchType+"/"+batchStartDate+" to "+batchEndDate+"("+batchID+")");
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch ID')]]]]/div[3]/span")).getText().trim(), batchID);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Size')]]]]/div[3]/span")).getText().trim(), batchSize);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[span[b[contains(text(),'Batch Date')]]]]/div[3]/span")).getText().trim(), batchStartDate+" to "+batchEndDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[1]")).getText().trim(), tcName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[2]")).getText().trim(), tcID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[4]")).getText().trim(), tcTPName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[5]")).getText().trim(), tcState);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[6]")).getText().trim(), tcDistrict);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+tcID+"')]]/td[7]")).getText().trim(), "Accepted");
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[2]")).getText().trim(), batchDomainJobRole+" ("+batchDomainJobRoleCode+")");
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[3]")).getText().trim(), domainAssessmentAgencyName+" ("+domainAssessmentAgencyID+")");
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[4]")).getText().trim(), domainMasterAssessorName+" ("+domainMasterAssessorID+")");
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[5]")).getText().trim(), dAssessmentStartDate+" to "+dAssessmentEndDate);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchDomainJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[2]")).getText().trim(), batchPlatformJobRole+" ("+batchPlatformJobRoleCode+")");
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[3]")).getText().trim(), platformAssessmentAgencyName+" ("+platformAssessmentAgencyID+")");
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[4]")).getText().trim(), platformMasterAssessorName+" ("+platformMasterAssessorID+")");
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[5]")).getText().trim(), pAssessmentStartDate+" to "+pAssessmentEndDate);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+batchPlatformJobRole+"')]]/td[6]")).getText().trim(), "Accepted");
   			//Applicants Details Verification
       		maVp.clickToGoToApprovedApplicantsSection();
       		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
      	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[2]")).getText().trim(), trainerID);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[3]")).getText().trim(), name);
       	 	String applicantID_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 2, 1);
       	 	String applicantName_2=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 2, 4);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_2+"']]/td[2]")).getText().trim(), applicantID_2);
    	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_2+"']]/td[3]")).getText().trim(), applicantName_2);
       	 	String applicantID_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 3, 1);
       	 	String applicantName_3=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 3, 4);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_3+"']]/td[2]")).getText().trim(), applicantID_3);
       	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_3+"']]/td[3]")).getText().trim(), applicantName_3);
       	 	String applicantID_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 4, 1);
       	 	String applicantName_4=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 4, 4);
          	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_4+"']]/td[2]")).getText().trim(), applicantID_4);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_4+"']]/td[3]")).getText().trim(), applicantName_4);
       	 	String applicantID_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 5, 1);
       	 	String applicantName_5=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", 5, 4);
          	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_5+"']]/td[2]")).getText().trim(), applicantID_5);
      	 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantID_5+"']]/td[3]")).getText().trim(), applicantName_5);
       	 	PostLoginPage plp=new PostLoginPage(driver);
    	 	plp.clickOnProfileLogo();
    	 	Thread.sleep(2000);
    	 	plp.clickOnLogout();
    	}
      }
    }
         
    @Test(dataProvider="totApplicantsData", dependsOnMethods="totBatchApprovalTC_02")
    public void tcRejectingToT_ApplicantsTC_11(String serialNum, String trainerID, String paymentDate, String userType, String name, String email, String mobile, String applicantPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String paymentMode, String bankName, String paymentReferenceNumber, String paymentRemarks) throws Exception
    {
    	if(serialNum.equals("1"))
	   	{
	   	 	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			String batchID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 2, 1);
 	   		LoginPage lp=new LoginPage(driver);
 	   		lp.clickLogin();
 	   		Thread.sleep(2000);
 	   		BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
 	   		bvp.clickToClose();
 	   		Thread.sleep(2000);
 	   		EnterLoginPage elp=new EnterLoginPage(driver);
 	   		//Applicant Applying for batch
 	   		elp.performlogin(trainerID, applicantPassword);
 	   		TrainerApplicantDashboardPage tDp=new TrainerApplicantDashboardPage(driver);
 	   		tDp.clickToGetApplicantDashboard();
 	   		WebDriverWait wait=new WebDriverWait(driver, 20);
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		tDp.clickSearchAndApplyforAvailableBatches();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		TrainerApplicantSearchAndApplyForAvailableBatchesPage tSp=new TrainerApplicantSearchAndApplyForAvailableBatchesPage(driver);
 	   		tSp.selectState(state);
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tSp.selectSector(batchSector);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tSp.clickSearch();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! no show of batch - "+batchID+" searching by entering Only Mandatory fields! ");
			Thread.sleep(2000);
			tSp.clickToGetBatchActionMenu(batchID);
			tSp.selectApplyToBatch(batchID);
			tSp.clickOK();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
 	   		//TC Rejecting Applicant
			lp.clickLogin();
			Thread.sleep(2000);
		    bvp.clickToClose();
		    Thread.sleep(2000);
 	   		elp.performlogin(tcID, tcPassword);
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		LocationBasedTC_DashboardPage tcDp=new LocationBasedTC_DashboardPage(driver);
 	   		tcDp.clickToViewBatches();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
 	   		tcVp.clickToViewAllAcceptedBatches();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 			tcVp.enterToSearchForBatchID(batchID);
 			tcVp.clickToGetSearchResult();
 			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
 	   		tcVp.clikToGetBatchActionMenu();
 	   		tcVp.selectEnrollApplicantsOption();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		tcVp.clickToGetApplicantActionMenu(trainerID);
 	   		tcVp.selectRejectApplicantOption(trainerID);
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		tcVp.selectReasonForRejectingApplicant();
 	   		tcVp.enterRemarksForRejectingApplicant();
 	   		tcVp.clickToRejectApplicant();
 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
 	   		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Applicant Rejected");
 	   		tcVp.clickOk();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		tcVp.clickToGoToAppliedApplicantsSection();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+trainerID+"')]]")).size()==0,"OMG!!! Rejected Trainer Applicant - "+trainerID+" Still present in Applied Applicants Section!!! OR Something went wrong! ");
 	   		tcVp.clickToGoToEnrolledApplicantsSection();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+trainerID+"')]]")).size()==0,"OMG!!! Rejected Trainer Applicant - "+trainerID+" Present in Enrolled Applicants Section!!! OR Something went wrong! ");
 	   		plp.clickOnProfileLogo();
 	   		Thread.sleep(2000);
 	   		plp.clickOnLogout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
 	   		//Applicant Verifying Batch Status After TC Rejection
 	   		lp.clickLogin();
 	   		Thread.sleep(2000);
 	   		bvp.clickToClose();
 	   		Thread.sleep(2000);
 	   		elp.performlogin(trainerID, applicantPassword);
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tDp.clickToGetApplicantDashboard();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		JavascriptExecutor js=(JavascriptExecutor)driver;
 	   		js.executeScript("window.scrollBy(0,200)", "");
 	   		Thread.sleep(5000);
 	   		tDp.clickViewBatches();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		TrainerApplicantViewBatchesPage tVp=new TrainerApplicantViewBatchesPage(driver);
 	   		tVp.enterBatchIDTosearch(batchID);
 	   		tVp.clickToGetSearchResult();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		 	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), "Rejected");
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
 	   	}
    }
        
    @Test(dataProvider="totApplicantsData", dependsOnMethods="tcRejectingToT_ApplicantsTC_11")
    public void sscRejectingToT_ApplicantsTC_12(String serialNum, String trainerID, String paymentDate, String userType, String name, String email, String mobile, String applicantPassword, String gender, String dob, String language, String religion, String category, String disability, String disabilityFile, String aadhaarOrPAN, String idNumber, String uploadPanDocument, String photoFile, String applicant_Category, String address, String landmark, String pincode, String state, String city, String mandal, String parliamentaryConstituency, String education1, String edu_details1, String edu_document1, String education2, String edu_details2, String edu_document2, String industrial_sector1, String industrial_years1, String industrial_months1, String industrialExperienceDetails1, String industriesDetails1, String industrialDocument1, String industrial_sector2, String industrial_years2, String industrial_months2, String industrialExperienceDetails2, String industriesDetails2, String industrialDocument2, String training_sector1, String trainingExperienceYears1, String trainingExperienceMonths1, String trainingExperienceDetails1, String trainingDocument1, String training_sector2, String trainingExperienceYears2, String trainingExperienceMonths2, String trainingExperienceDetails2, String trainingDocument2, String resume, String preferredSector1, String preferredSubSector1, String preferredJobRole1, String preferredJobRoleCode1, String preferredState1, String preferredDistrict1, String preferredSubDistrict1, String preferredSector2, String preferredSubSector2, String preferredJobRole2, String preferredJobRoleCode2, String preferredState2, String preferredDistrict2, String preferredSubDistrict2, String paymentMode, String bankName, String paymentReferenceNumber, String paymentRemarks) throws Exception
    {
    	if(serialNum.equals("2"))
	   	{
    		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			String batchID=ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT-Batches", 2, 1);
 	   		LoginPage lp=new LoginPage(driver);
 	   		lp.clickLogin();
 	   		Thread.sleep(2000);
 	   		BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
 	   		bvp.clickToClose();
 	   		Thread.sleep(2000);
 	   		EnterLoginPage elp=new EnterLoginPage(driver);
 	   		//Applicant Applying for batch
			elp.performlogin(trainerID, applicantPassword);
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			TrainerApplicantDashboardPage tDp=new TrainerApplicantDashboardPage(driver);
			tDp.clickToGetApplicantDashboard();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			tDp.clickSearchAndApplyforAvailableBatches();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			TrainerApplicantSearchAndApplyForAvailableBatchesPage tSp=new TrainerApplicantSearchAndApplyForAvailableBatchesPage(driver);
			tSp.selectState(state);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tSp.selectSector(batchSector);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			tSp.clickSearch();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! no show of batch - "+batchID+" searching by entering Only Mandatory fields! ");
			tSp.clickToGetBatchActionMenu(batchID);
			tSp.selectApplyToBatch(batchID);
			tSp.clickOK();  
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			Thread.sleep(2000);
			plp.clickOnLogout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
    		//TC Submitting Batch For SSC
	   	 	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
 	   		lp.clickLogin();
 	   		Thread.sleep(2000);
 	   		bvp.clickToClose();
 	   		Thread.sleep(2000);
 	   		elp.performlogin(tcID, tcPassword);
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		LocationBasedTC_DashboardPage tcDp=new LocationBasedTC_DashboardPage(driver);
 	   		js.executeScript("window.scrollBy(0,200)","");
 	   		tcDp.clickToViewBatches();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		LocationBasedTC_ViewBatchesPage tcVp=new LocationBasedTC_ViewBatchesPage(driver);
 	   		tcVp.clickToViewAllAcceptedBatches();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		tcVp.enterToSearchForBatchID(batchID);
 	   		tcVp.clickToGetSearchResult();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		Assert.assertFalse(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==0, "OMG!!! Batch ID - "+batchID+"  Not Found!!! in Accepted Section of "+tcID+" !!!");
 	   		tcVp.clikToGetBatchActionMenu();
 	   		tcVp.selectEnrollApplicantsOption();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+trainerID+"')]]")).size()==1,"OMG!!! No show of Trainer Applicant - "+trainerID+" in Applied Applicants Section!!! OR Something went wrong! ");
 	   		tcVp.clickToGetApplicantActionMenu(trainerID);
 	   		tcVp.selectEnrollApplicantOption(trainerID);
 	   		tcVp.clickOk();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		tcVp.clickToGoToEnrolledApplicantsSection();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+trainerID+"')]]")).size()==1,"OMG!!! No show of Enrolled Trainer Applicant - "+trainerID+" in Enrolled Applicants Section!!! OR Something went wrong! ");
 	   		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='"+trainerID+"']")).getText().trim(), trainerID);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[contains(text(),'"+name+"')]")).getText().trim(), name);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[contains(text(),'"+email+"')]")).getText().trim(), email);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[contains(text(),'"+mobile+"')]")).getText().trim(), mobile);
 	   		//Sending Batch To SSC For Approval
 	 	    tcVp.clickToSendBatchForApproval();
 	   		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
 	 	    Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Submitted for Approval");
	 	    tcVp.clickOk();
	 	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		plp.clickOnProfileLogo();
 	   		Thread.sleep(2000);
 	   		plp.clickOnLogout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
 	   		//SSC Rejecting Enrolled Applicant
 	   		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
 	   		lp.clickLogin();
 	   		Thread.sleep(2000);
 	   		bvp.clickToClose();
 	   		Thread.sleep(2000);
 	   		elp.performlogin(sscID, sscPassword);
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		SSC_DashboardPage sDp=new SSC_DashboardPage(driver);
 	   		sDp.click_ToAToMTToMA();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		js.executeScript("window.scrollBy(0,200)", "");
 	   		sDp.clickAllBatches();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		SSCAllBatchesPage sAp=new SSCAllBatchesPage(driver);
 	   		sAp.clickToViewAllPublishedBatches();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		sAp.enterBatchIDToSearch(batchID);
 	   		sAp.clickToGetSearchResult();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		sAp.clickToGetBatchActionMenu(batchID);
 	   		sAp.selectApproveApplicantsOption(batchID);
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		SSC_ViewBatchDetailsPage sVp=new SSC_ViewBatchDetailsPage(driver);
 	   		sVp.clickTogoToBatchDetailsSection();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		sVp.clickToGoToEnrolledApplicantsSection();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
 	   		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+trainerID+"']]")).size()==1,"OMG!!! No show of TC Approved Trainer Applicant - "+trainerID+" in Enrolled Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[2]")).getText().trim(), trainerID);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[3]")).getText().trim(), name);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[4]")).getText().trim(), email);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[5]")).getText().trim(), mobile);
 	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+trainerID+"']]/td[6]")).getText().trim(), "Unpaid");
 	   		sVp.clickToGetApplicantActionMenu(trainerID);
   	 		sVp.selectRejectApplicantOption(trainerID);
   	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 		sVp.selectReasonForRejectingApplicant();
   	 		sVp.enterRemarksForRejectingApplicant();
   	 		sVp.clickToRejectApplicant();
 	   		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
   	 		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().trim().contains("Applicant Rejected"));
   	 		sVp.clickOk();
   	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+trainerID+"')]]")).size()==0,"OMG!!! SSC Rejected Applicant - "+trainerID+" should not be displayed in Enrolled Applicants Section OR Something went wrong!");
   	 	 	js.executeScript("window.scrollBy(0,-1000)", "");
   	 	 	sVp.clickToGoToApprovedApplicantsSection();
   	 	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
   	 	 	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+trainerID+"']]")).size()==0,"OMG!!! SSC Rejected Applicant - "+trainerID+" Present in Approved Applicants Section, who has applied for the batch - "+batchID+" OR Something went wrong! ");
   	 	 	plp.clickOnProfileLogo();
   	 	 	Thread.sleep(2000);
   	 	 	plp.clickOnLogout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@routerlink='login']")));
   	 	 	//Applicant Checking Batch Status after SSC Rejection
   	 	 	lp.clickLogin();
   	 	 	Thread.sleep(2000);
   	 	 	bvp.clickToClose();
   	 	 	Thread.sleep(2000);
	   		elp.performlogin(trainerID, applicantPassword);
	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   		tDp.clickToGetApplicantDashboard();
	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   		js.executeScript("window.scrollBy(0,200)", "");
	   		Thread.sleep(2000);
	   		tDp.clickViewBatches();
	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   		TrainerApplicantViewBatchesPage tVp=new TrainerApplicantViewBatchesPage(driver);
 	   		tVp.enterBatchIDTosearch(batchID);
 	   		tVp.clickToGetSearchResult();
 	   		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
	   		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[5]")).getText().trim(), "Rejected");
	   		plp.clickOnProfileLogo();
	   		Thread.sleep(2000);
	   		plp.clickOnLogout();
	   	}
    }
/*    
    @Test(dataProvider="totBatchData", dependsOnMethods="masterAssessorVerifyingSSCApprovedBatchAndApplicantsTC_10")
    public void attendanceUploadByDomainMasterTrainerTC_13(String serialNo,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcName, String tcPassword, String tcTrainingPartnerName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String tcPincode, String mandal, String district, String state, String parlimentaryConstituency, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmtRemarksDate, String dmtRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmtRemarksDate, String pmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String daaRemarksDate, String daaRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String paaRemarksDate, String paaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaRemarks, String pmaRemarksDate, String pmaRemarksTime, String domainJobRoleAttendance, String platformJobRoleAttendance, String domainJobRoleLevel, String platformJobRoleLevel, String tcSPOCName, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
    {
    	if(serialNo.equals("1"))
    	{
    		ReadWriteData.setAttendanceExcelData("./UploadFiles/"+domainJobRoleAttendance, "Sheet1", 0, 2, dTrainingStartDate.replaceAll("-", "/"));
    		ReadWriteData.setAttendanceExcelData("./UploadFiles/"+domainJobRoleAttendance, "Sheet1", 0, 3, dTrainingEndDate.replaceAll("-", "/"));
    		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
    		LoginPage lp=new LoginPage(driver);
    		lp.clickLogin();
    		EnterLoginPage elp=new EnterLoginPage(driver);
    		WebDriverWait wait=new WebDriverWait(driver, 60);
    		TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
			TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
    		elp.performlogin(dmasterTrainerID, dmasterTrainerPassword);
    		tDp.clickToGetTrainerDashboard();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tDp.clickAllBatches();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tVp.clickToGoToAcceptedBatchesSection();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tVp.enterBatchIDToSearch(batchID);
    		tVp.clickToGetSearchFilterResult();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Accepted Section of Master Trainer - "+dmasterTrainerID);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Batch on Going");
    		tVp.clickToGetActionMenuOptions(batchID);
    		tVp.clickToSelectUploadAttendanceOption(batchID);
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tVp.selectDomainJobRole(domainJobRole);
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		//Checking Download Template
    		tVp.clickToDownloadAttendanceTemplate();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tVp.clickToBrowseForAttendanceFile();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        	UploadFile.upload(domainJobRoleAttendance);
        	tVp.clickToUploadChoosedAttendanceFile();
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
            Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Attendance uploaded successfully");
    		tVp.clickOk();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		//Verifying Uploaded Attendance Data for each applicant
    		for(int j=1; j<6; j++)
        	{
        		String applicantName =ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", j, 4);
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantName+"']]/td[2]")).getText().trim(), applicantName);
        		if(j==5)
        		{
        			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantName+"']]/td[3]")).getText().trim(),"Dropout");
        	     	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantName+"']]/td[4]")).getText().trim(),"50.00%");
        	     	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+applicantName+"']]/td[b[text()='P']]")).size()==1);
        	   		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+applicantName+"']]/td[b[text()='A']]")).size()==1);
        	     }
        	     else
        	     {
        	     	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantName+"']]/td[3]")).getText().trim(),"Completed");
        	     	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantName+"']]/td[4]")).getText().trim(),"100.00%");
        	     	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+applicantName+"']]/td[b[text()='P']]")).size()==2);
        	     }
        	}
        	tVp.clickToBrowseForAttendanceSupportFile();
        	Thread.sleep(2000);
        	UploadFile.upload(domainJobRoleAttendance);
        	tVp.clickToUploadChoosedAttendanceSupportFile();
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        	Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleAttendance+"')]]")).isDisplayed());
        	tVp.clickToDeleteUploadedAttendanceSupportDoc();
        	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[contains(text(),'"+domainJobRoleAttendance+"')]]")).size()==0);
        	tVp.clickToBrowseForAttendanceSupportFile();
        	Thread.sleep(2000);
        	UploadFile.upload(domainJobRoleAttendance);
        	tVp.clickToUploadChoosedAttendanceSupportFile();
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'uploaded successfully')]")));
        	JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,-200)", "");
        	Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+domainJobRoleAttendance+"')]]")).isDisplayed());
    		js.executeScript("window.scrollBy(0,-1000)", "");
    		tVp.clickToSubmitBatchAttendanceToSSC();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tVp.clickToFinallySubmitBatchAttendanceToSSC();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
    		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Attendance submitted successfully");
    		tVp.clickOk();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("swal2-title")));
    		//Checking Attendance Submission already done 
    		tVp.clickToSubmitBatchAttendanceToSSC();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tVp.clickToFinallySubmitBatchAttendanceToSSC();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
    		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim(), "Attendance Already Submitted to SSC");
    		PostLoginPage plp=new PostLoginPage(driver);
    		plp.clickOnProfileLogo();
    		Thread.sleep(2000);
    		plp.clickOnLogout();

    	}
    }
    
    @Test(dataProvider="totBatchData", dependsOnMethods="masterAssessorVerifyingSSCApprovedBatchAndApplicantsTC_10")
    public void attendanceUploadByPlatformMasterTrainerTC_14(String serialNo,String batchID, String batchCreatedDate, String sscUsername, String sscPassword, String expectedSector, String subSector, String batchType, String batchCategory, String batchStartDate, String batchEndDate, String domainJobRole, String domainJobRoleCode, String platformJobRole, String platformJobRoleCode, String dTrainingStartDate, String dTrainingEndDate, String dAssessmentStartDate, String dAssessmentEndDate, String pTrainingStartDate, String pTrainingEndDate, String pAssessmentStartDate, String pAssessmentEndDate, String expectedBatchFees, String batchSize, String tcID, String tcName, String tcPassword, String tcTrainingPartnerName, String tcSPOCMobile, String tcSPOCEmail, String tcAddress, String tcLandmark, String tcPincode, String mandal, String district, String state, String parlimentaryConstituency, String tcBatchAcceptanceRemarks, String dmasterTrainerID, String dmasterTrainerName, String dmasterTrainerPassword, String dmtBatchAcceptanceRemarks, String dmtRemarksDate, String dmtRemarksTime, String pmasterTrainerID, String pmasterTrainerName, String pmasterTrainerPassword, String pmtBatchAcceptanceRemarks, String pmtRemarksDate, String pmtRemarksTime, String dassessmentAgencyID, String dassessmentAgencyName, String dassessmentAgencyPassword, String daaBatchAcceptanceRemarks, String daaRemarksDate, String daaRemarksTime, String passessmentAgencyID, String passessmentAgencyName, String passessmentAgencyPassword, String paaBatchAcceptanceRemarks, String paaRemarksDate, String paaRemarksTime, String dmasterAssessorID, String dmasterAssessorName, String dmasterAssessorPassword, String dmaRemarks, String dmaRemarksDate, String dmaRemarksTime, String pmasterAssessorID, String pmasterAssessorName, String pmasterAssessorPassword, String pmaRemarks, String pmaRemarksDate, String pmaRemarksTime, String domainJobRoleAttendance, String platformJobRoleAttendance, String domainJobRoleLevel, String platformJobRoleLevel, String tcSPOCName, String domainJobRoleVersion, String platformJobRoleVersion) throws Exception
    {
    	if(serialNo.equals("1"))
    	{
    		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");   
    		Calendar cal = Calendar.getInstance();    
    		cal.setTime(dateFormat.parse(pTrainingStartDate));
    		ReadWriteData.setAttendanceExcelData("./UploadFiles/"+platformJobRoleAttendance, "Sheet1", 0, 2, pTrainingStartDate.replaceAll("-", "/"));
    		cal.add(Calendar.DATE, 1 );
    		ReadWriteData.setAttendanceExcelData("./UploadFiles/"+platformJobRoleAttendance, "Sheet1", 0, 3, dateFormat.format(cal.getTime()).replaceAll("-", "/"));
    		cal.add(Calendar.DATE, 1);
    		ReadWriteData.setAttendanceExcelData("./UploadFiles/"+platformJobRoleAttendance, "Sheet1", 0, 4, dateFormat.format(cal.getTime()).replaceAll("-", "/"));
    		cal.add(Calendar.DATE, 1);
    		ReadWriteData.setAttendanceExcelData("./UploadFiles/"+platformJobRoleAttendance, "Sheet1", 0, 5, dateFormat.format(cal.getTime()).replaceAll("-", "/"));
    		cal.add(Calendar.DATE, 1);
    		ReadWriteData.setAttendanceExcelData("./UploadFiles/"+platformJobRoleAttendance, "Sheet1", 0, 6, dateFormat.format(cal.getTime()).replaceAll("-", "/"));
    		cal.add(Calendar.DATE, 1);
    		ReadWriteData.setAttendanceExcelData("./UploadFiles/"+platformJobRoleAttendance, "Sheet1", 0, 7, pTrainingEndDate.replaceAll("-", "/"));
    		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
    		LoginPage lp=new LoginPage(driver);
    		lp.clickLogin();
    		EnterLoginPage elp=new EnterLoginPage(driver);
    		WebDriverWait wait=new WebDriverWait(driver, 60);
    		TrainerDashboardPage tDp=new TrainerDashboardPage(driver);
			TrainerViewBatchesPage tVp=new TrainerViewBatchesPage(driver);
    		elp.performlogin(pmasterTrainerID, pmasterTrainerPassword);
    		tDp.clickToGetTrainerDashboard();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tDp.clickAllBatches();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tVp.clickToGoToAcceptedBatchesSection();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tVp.enterBatchIDToSearch(batchID);
    		tVp.clickToGetSearchFilterResult();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+batchID+"']]")).size()==1,"OMG!!! No show of Batch - "+batchID+" in Accepted Section of Master Trainer - "+pmasterTrainerID);
    		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+batchID+"']]/td[8]")).getText().trim(), "Batch on Going");
    		tVp.clickToGetActionMenuOptions(batchID);
    		tVp.clickToSelectUploadAttendanceOption(batchID);
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tVp.selectDomainJobRole(platformJobRole);
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		//Checking Download Template
    		tVp.clickToDownloadAttendanceTemplate();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tVp.clickToBrowseForAttendanceFile();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
        	UploadFile.upload(platformJobRoleAttendance);
        	tVp.clickToUploadChoosedAttendanceFile();
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
            Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Attendance uploaded successfully");
    		tVp.clickOk();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		//Verifying Uploaded Attendance Data for each applicant
    		for(int j=1; j<6; j++)
        	{
        		String applicantName =ReadWriteData.getData("./TestData/Workflow/ToT_BatchApplicants-Workflow.xls", "ToT_BatchApplicants", j, 4);
        		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantName+"']]/td[2]")).getText().trim(), applicantName);
        		if(j==5)
        		{
        			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantName+"']]/td[3]")).getText().trim(),"Dropout");
        	     	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantName+"']]/td[4]")).getText().trim(),"66.67%");
        	     	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+applicantName+"']]/td[b[text()='P']]")).size()==4);
        	     	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+applicantName+"']]/td[b[text()='A']]")).size()==2);
        	     }
        	     else
        	     {
        	     	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantName+"']]/td[3]")).getText().trim(),"Completed");
        	     	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[text()='"+applicantName+"']]/td[4]")).getText().trim(),"100.00%");
        	     	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[text()='"+applicantName+"']]/td[b[text()='P']]")).size()==6);
        	     }
        	}
    		tVp.clickToSubmitBatchAttendanceToSSC();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		tVp.clickToFinallySubmitBatchAttendanceToSSC();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
    		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Attendance submitted successfully");
    		tVp.clickOk();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("swal2-title")));
    		PostLoginPage plp=new PostLoginPage(driver);
    		plp.clickOnProfileLogo();
    		Thread.sleep(2000);
    		plp.clickOnLogout();
    	}
    }*/
}