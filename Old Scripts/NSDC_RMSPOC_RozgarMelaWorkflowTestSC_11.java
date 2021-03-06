package com.nsdc.regressionTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.Employer_JobVacancyCreationPage;
import com.nsdc.pages.Employer_RozgarMelaPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.RozgarMelaDetailSectionsPage;
import com.nsdc.pages.RozgarMela_CandidatePage;
import com.nsdc.pages.RozgarSTSE_DashboardPage;
import com.nsdc.pages.RozgarSTSE_ViewRozgarMelaPage;
import com.nsdc.pages.RozgarSTSE_ViewRozgarMelasPage;
import com.nsdc.pages.NSDC_RozgarMelaSPOC_CreateRozgarMelaPage;
import com.nsdc.pages.NSDC_RozgarMelaSPOC_DashboardPage;
import com.nsdc.pages.NSDC_RozgarMelaSPOC_ViewRozgarMelasPage;
import com.nsdc.testConfig.TestConfiguration;

public class NSDC_RMSPOC_RozgarMelaWorkflowTestSC_11 extends TestConfiguration
{
	@DataProvider
	public Object[][] rozgarMelaData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "RozgarMelas");
	}
	
	@Test(dataProvider="rozgarMelaData")
	public void createRozgarMelaTC_01(String serialNum, String rozgarMelaID, String rmspocID, String rmspocPassword, String rozgarMelaName, String typeOfRozgarMela, String targetAudience, String chiefGuestTitle, String chiefGuestSalutation, String chiefGuestName, String eligibilityCriteria, String startDate, String endDate, String startTime, String endTime, String address, String landmark, String pincode, String state, String district, String tehsil, String village, String parlimentaryConstituency, String geoLocation, String additionalRemarks, String alignTC, String alignSSC, String statusFilterOption, String created_Date, String rescheduledStartDate, String rescheduledEndDate, String rescheduledStartTime, String rescheduledEndTime) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
		BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
        bvp.clickToClose();
        Thread.sleep(2000);
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(rmspocID, rmspocPassword);
		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='toast-container']/div/div"));
		while(ele.size()!=0)
		{
			Assert.assertFalse(driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).getText().trim().contains("Deactiv"),"OMG!!! RozgarSPOC - "+rmspocID+" Account Deactivated. Kindly contact NSDC Admin! ");
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		NSDC_RozgarMelaSPOC_DashboardPage rmDp=new NSDC_RozgarMelaSPOC_DashboardPage(driver);
		rmDp.clickCreateRozgarMelas();
		NSDC_RozgarMelaSPOC_CreateRozgarMelaPage rmCp=new NSDC_RozgarMelaSPOC_CreateRozgarMelaPage(driver);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains("create-rozgar"));
		if(driver.findElements(By.id("name")).size()==0)
		{
			driver.navigate().refresh();
		}
		rmCp.enterRozgarMelaName(rozgarMelaName);
		Assert.assertEquals(driver.findElement(By.id("typeOfMela")).getAttribute("value").trim(), typeOfRozgarMela);
		rmCp.selectTargetAudience(targetAudience);
		rmCp.selectChiefGuestTitle(chiefGuestTitle);
		rmCp.selectChiefGuestSalutation(chiefGuestSalutation);
		rmCp.enterChiefGuestName(chiefGuestName);
		rmCp.selectEligibilityCriteria(eligibilityCriteria);
		rmCp.chooseRozgarMelaStartDate();
		rmCp.clickMelaDailyTimingLabelToCloseMelaDurationPickers();
		rmCp.chooseRozgarMelaEndDate();
		rmCp.clickMelaDailyTimingLabelToCloseMelaDurationPickers();
		rmCp.enterRozgarMelaStartTime(startTime);
		rmCp.clickMelaDailyTimingLabelToCloseMelaDurationPickers();
		rmCp.enterRozgarMelaEndTime(endTime);
		rmCp.clickMelaDailyTimingLabelToCloseMelaDurationPickers();
		rmCp.enterRozgarMelaAddress(address);
		int rowNum=Integer.parseInt(serialNum);
		String startDateHipen=driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "RozgarMelas", rowNum, 11, startDateHipen);
		String endDateHipen=driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value").replaceAll("/", "-");
		ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "RozgarMelas", rowNum, 12, endDateHipen);
		if(!landmark.equalsIgnoreCase("N/A"))
		{
			rmCp.enterLandmark(landmark);
		}
		rmCp.enterPincode(pincode);
		rmCp.selectState(state);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rmCp.selectDistrict(district);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		if(!tehsil.equalsIgnoreCase("N/A"))
		{
			rmCp.selectTehsil(tehsil);
		}
		if(!village.equalsIgnoreCase("N/A"))
		{
			rmCp.selectVillage(village);
		}
		if(!parlimentaryConstituency.equalsIgnoreCase("N/A"))
		{
			rmCp.selectParlimentaryConstituency(parlimentaryConstituency);
		}
		
		if(!additionalRemarks.equalsIgnoreCase("N/A"))
		{
			rmCp.enterAdditionalRemarks(additionalRemarks);
		}
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Next')]")).isEnabled(), "OMG!!! Next Button is disabled, something is wrong!!! ");
		Thread.sleep(2000);
		rmCp.clickToCreateMelaAndAlignTrainingCentre();
		wait.until(ExpectedConditions.urlContains("align-training-centres"));
		Assert.assertTrue(driver.getCurrentUrl().contains("align-training-centres"),"OMG!!! Navigation to Align Training Centre page is unsuccessful OR Something wrong! ");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rmCp.clickToSelectAllTrainingCentres();
		rmCp.clickToAlignSelectedTrainingCentres();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("aligned"));
		rmCp.clickOK();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("swal2-title")));
		js.executeScript("window.scrollBy(0,-1000)", "");
		rmCp.clickSaveAndAlignSSCs();
		wait.until(ExpectedConditions.urlContains("align-ssc"));
		Assert.assertTrue(driver.getCurrentUrl().contains("align-ssc"),"OMG!!! Navigation to Align SSCs page is unsuccessful OR Something wrong! ");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rmCp.clickToSelectAllSSCs();
		rmCp.clickToAlignSelectedSSCs();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		Assert.assertTrue(driver.findElement(By.id("swal2-title")).getText().contains("aligned"));
		rmCp.clickOK();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Save & Create Rozgar Mela')]")));
		js.executeScript("window.scrollBy(0,-1000)", "");
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Save & Create Rozgar Mela')]")).isEnabled(),"OMG!!! Save & Create Rozgar Mela, button should be enabled after selecting SSCs! ");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rmCp.clickToSaveAndCreateRozgarMela();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "RozgarMelas", Integer.parseInt(serialNum), 28, formatter.format(date));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(text(),'You have successfully created a')]/span)[2]")));
		Assert.assertTrue(driver.getCurrentUrl().contains("create-rozgar-mela-success"),"OMG!!! Navigation to Create Rozgar Mela Success page is unsuccessful OR Something wrong! ");
		String createdRozgarMelaID=driver.findElement(By.xpath("(//p[contains(text(),'You have successfully created a')]/span)[2]")).getText().trim().replace('"', ' ').replaceAll(" ", "");
		ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "RozgarMelas", rowNum, 1, createdRozgarMelaID);
		if(serialNum.equals("3"))
		{
			ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "Enroll_Link_Vacancy", 1, 0, createdRozgarMelaID);
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rmCp.clickAnnounceToStakeholders();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Notification has been sent to stakeholders");
		rmCp.clickOK();
		wait.until(ExpectedConditions.urlContains("view-rozgar-melas"));
		Assert.assertTrue(driver.getCurrentUrl().contains("view-rozgar-melas"),"OMG!!! Navigation to View Rozgar Melas page is unsuccessful OR Something wrong! ");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();
	}
	
	@Test(dataProvider="rozgarMelaData", dependsOnMethods="createRozgarMelaTC_01")
	public void cancelRozgarMelaTC_02(String serialNum, String rozgarMelaID, String rmspocID, String rmspocPassword, String rozgarMelaName, String typeOfRozgarMela, String targetAudience, String chiefGuestTitle, String chiefGuestSalutation, String chiefGuestName, String eligibilityCriteria, String startDate, String endDate, String startTime, String endTime, String address, String landmark, String pincode, String state, String district, String tehsil, String village, String parlimentaryConstituency, String geoLocation, String additionalRemarks, String alignTC, String alignSSC, String statusFilterOption, String created_Date, String rescheduledStartDate, String rescheduledEndDate, String rescheduledStartTime, String rescheduledEndTime) throws Exception
	{
		if(serialNum.equals("1"))
		{
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			LoginPage lp=new LoginPage(driver);
			lp.clickLogin();
			Thread.sleep(2000);
		    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
		    bvp.clickToClose();
		    Thread.sleep(2000);
			EnterLoginPage elp=new EnterLoginPage(driver);
			elp.performlogin(rmspocID, rmspocPassword);
			NSDC_RozgarMelaSPOC_DashboardPage rmDp=new NSDC_RozgarMelaSPOC_DashboardPage(driver);
			rmDp.clickViewRozgarMelas();
			WebDriverWait wait=new WebDriverWait(driver, 20);
			NSDC_RozgarMelaSPOC_ViewRozgarMelasPage rVmp=new NSDC_RozgarMelaSPOC_ViewRozgarMelasPage(driver);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			rVmp.enterRozgarMelaIDToSearch(rozgarMelaID);
			rVmp.clickToApplyFilters();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[2]")).getText().trim(), rozgarMelaID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[3]")).getText().trim(), rozgarMelaName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[4]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[5]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[6]")).getText().trim(), startDate+" - "+endDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[7]")).getText().trim(), created_Date);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[8]")).getText().trim(), "To be Conducted");
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			rVmp.clickActionMenu();
			rVmp.clickToChooseCancelMelaOption();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("swal2-title")));
			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Are you sure you want to cancel the Rozgar?");
			rVmp.clickToFinallyCancelRozgarMela();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("swal2-content")));
			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Rozgar Mela Has Been Cancelled !");
			Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "Rozgar Mela has been Cancelled with Mela ID:"+rozgarMelaID);
			rVmp.clickContinueToViewAllMelas();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[8]")).getText().trim(), "Cancelled");
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
		}
	}
	
	@Test(dataProvider="rozgarMelaData", dependsOnMethods="createRozgarMelaTC_01")
	public void closeCandidateEnrollmentForRozgarMelaTC_03(String serialNum, String rozgarMelaID, String rmspocID, String rmspocPassword, String rozgarMelaName, String typeOfRozgarMela, String targetAudience, String chiefGuestTitle, String chiefGuestSalutation, String chiefGuestName, String eligibilityCriteria, String startDate, String endDate, String startTime, String endTime, String address, String landmark, String pincode, String state, String district, String tehsil, String village, String parlimentaryConstituency, String geoLocation, String additionalRemarks, String alignTC, String alignSSC, String statusFilterOption, String created_Date, String rescheduledStartDate, String rescheduledEndDate, String rescheduledStartTime, String rescheduledEndTime) throws Exception
	{
		if(serialNum.equals("2"))
		{
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			LoginPage lp=new LoginPage(driver);
			lp.clickLogin();
			Thread.sleep(2000);
		    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
		    bvp.clickToClose();
		    Thread.sleep(2000);
			EnterLoginPage elp=new EnterLoginPage(driver);
			elp.performlogin(rmspocID, rmspocPassword);
			NSDC_RozgarMelaSPOC_DashboardPage rmDp=new NSDC_RozgarMelaSPOC_DashboardPage(driver);
			rmDp.clickViewRozgarMelas();
			WebDriverWait wait=new WebDriverWait(driver, 20);
			NSDC_RozgarMelaSPOC_ViewRozgarMelasPage rVmp=new NSDC_RozgarMelaSPOC_ViewRozgarMelasPage(driver);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			rVmp.enterRozgarMelaIDToSearch(rozgarMelaID);
			rVmp.clickToApplyFilters();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[2]")).getText().trim(), rozgarMelaID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[3]")).getText().trim(), rozgarMelaName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[4]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[5]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[6]")).getText().trim(), startDate+" - "+endDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[7]")).getText().trim(), created_Date);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[8]")).getText().trim(), "To be Conducted");
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			rVmp.clickActionMenu();
			rVmp.clickToChooseCloseCandidateEnrollmentOption();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("swal2-title")));
			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Candidate Registration Has Been Closed !!");
			Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "Candidate Registration has been closed with Mela ID:"+rozgarMelaID);
			rVmp.clickContinueToViewAllMelas();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			rVmp.enterRozgarMelaIDToSearch(rozgarMelaID);
			rVmp.clickToApplyFilters();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			js.executeScript("window.scrollBy(0,1000)", "");
			Thread.sleep(2000);
			rVmp.clickActionMenu();
			rVmp.clickToChooseCloseCandidateEnrollmentOption();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='toast-message']")));
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().trim(), "Already The Registration Closed For Candidates");
			rVmp.clickActionMenu();
			rVmp.clickToChooseViewDetailsOption();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			RozgarMelaDetailSectionsPage rms=new RozgarMelaDetailSectionsPage(driver);
			rms.clickToGoToParticipatingCandidatesSection();
			Assert.assertTrue(driver.findElements(By.xpath("//button[contains(text(),'Upload Candidate Registration List')]")).size()==0, "OMG!!! Upload Candidate Registration List button is available for - candidtae enrollment blocked mela");
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
		}
	}
	
	@Test(dataProvider="rozgarMelaData", dependsOnMethods="createRozgarMelaTC_01")
	public void rescheduleRozgarMelaTC_04(String serialNum, String rozgarMelaID, String rmspocID, String rmspocPassword, String rozgarMelaName, String typeOfRozgarMela, String targetAudience, String chiefGuestTitle, String chiefGuestSalutation, String chiefGuestName, String eligibilityCriteria, String startDate, String endDate, String startTime, String endTime, String address, String landmark, String pincode, String state, String district, String tehsil, String village, String parlimentaryConstituency, String geoLocation, String additionalRemarks, String alignTC, String alignSSC, String statusFilterOption, String created_Date, String rescheduledStartDate, String rescheduledEndDate, String rescheduledStartTime, String rescheduledEndTime) throws Exception
	{
		if(!serialNum.equals("1") && !serialNum.equals("2"))
		{
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
			LoginPage lp=new LoginPage(driver);
			lp.clickLogin();
			Thread.sleep(2000);
		    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
		    bvp.clickToClose();
		    Thread.sleep(2000);
			EnterLoginPage elp=new EnterLoginPage(driver);
			elp.performlogin(rmspocID, rmspocPassword);
			NSDC_RozgarMelaSPOC_DashboardPage rmDp=new NSDC_RozgarMelaSPOC_DashboardPage(driver);
			rmDp.clickViewRozgarMelas();
			WebDriverWait wait=new WebDriverWait(driver, 20);
			NSDC_RozgarMelaSPOC_ViewRozgarMelasPage rVmp=new NSDC_RozgarMelaSPOC_ViewRozgarMelasPage(driver);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			rVmp.enterRozgarMelaIDToSearch(rozgarMelaID);
			rVmp.clickToApplyFilters();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[2]")).getText().trim(), rozgarMelaID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[3]")).getText().trim(), rozgarMelaName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[4]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[5]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[6]")).getText().trim(), startDate+" - "+endDate);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[7]")).getText().trim(), created_Date);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[8]")).getText().trim(), "To be Conducted");
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
			rVmp.clickActionMenu();
			rVmp.clickToChooseRescheduleMelaOption();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			rVmp.chooseRozgarMelaRescheduleStartDate();
			rVmp.clickMelaDailyTimingLabelToCloseMelaRescheduleDurationPickers();
			rVmp.chooseRozgarMelaRescheduleEndDate();
			rVmp.clickMelaDailyTimingLabelToCloseMelaRescheduleDurationPickers();
			rVmp.enterRozgarMelaRescheduleStartTime(rescheduledStartTime);
			rVmp.clickMelaDailyTimingLabelToCloseMelaRescheduleDurationPickers();
			rVmp.enterRozgarMelaRescheduleEndTime(rescheduledEndTime);
			rVmp.clickMelaDailyTimingLabelToCloseMelaRescheduleDurationPickers();
			int rowNum=Integer.parseInt(serialNum);
			String rescheduledStartDateHipen=driver.findElement(By.xpath("//input[@placeholder='Select Start Date']")).getAttribute("value").replaceAll("/", "-");
			ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "RozgarMelas", rowNum, 29, rescheduledStartDateHipen);
			String rescheduledEndDateHipen=driver.findElement(By.xpath("//input[@placeholder='Select End Date']")).getAttribute("value").replaceAll("/", "-");
			ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "RozgarMelas", rowNum, 30, rescheduledEndDateHipen);
			rVmp.clickToUpdateAndAnnounce();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("swal2-title")));
			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Are you sure you want to re-schedule the Rozgar?");
			rVmp.clickToFinallyUpdateAndAnnounceRescheduledMela();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Continue to View All Melas')]")));
			Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Rozgar Mela Has Been Re-Scheduled !!");
			rVmp.clickContinueToViewAllMelas();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			rVmp.enterRozgarMelaIDToSearch(rozgarMelaID);
			rVmp.clickToApplyFilters();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[2]")).getText().trim(), rozgarMelaID);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[3]")).getText().trim(), rozgarMelaName);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[4]")).getText().trim(), state);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[5]")).getText().trim(), district);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[6]")).getText().trim(), rescheduledStartDateHipen+" - "+rescheduledEndDateHipen);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[7]")).getText().trim(), created_Date);
			Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[8]")).getText().trim(), "To be Conducted");
			rVmp.clickActionMenu();
			rVmp.clickToChooseViewDetailsOption();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
			Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Mela Name')]]//span[2]")).getText().trim(), rozgarMelaName.toUpperCase());
			Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Type of Rozgar Mela')]]//span[2]")).getText().trim(), typeOfRozgarMela.toUpperCase());
			Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Target Audience')]]//span[2]")).getText().trim(), targetAudience.toUpperCase());
			Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Chief Guest Expected')]]//span[2]")).getText().trim(), chiefGuestName.toUpperCase()+" ("+chiefGuestTitle.toUpperCase()+")");
			Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Mela Dates')]]//span[2]")).getText().trim(), rVmp.dateFormat(rescheduledStartDateHipen)+" TO "+rVmp.dateFormat(rescheduledEndDateHipen));
			Assert.assertEquals(driver.findElement(By.xpath("//div[span[contains(text(),'Mela Daily Timings')]]//span[2]")).getText().trim(), rVmp.timeFormat(rescheduledStartTime)+" TO "+rVmp.timeFormat(rescheduledEndTime));
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'Address of Mela')]]//div[2]")).getText().trim(), address.toUpperCase());
			//Presently in case of non-mandatory field data unavailability, "blank space" will be displayed
			if(landmark.equals("N/A"))
			{
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'Nearby Landmark')]]//div[2]")).getText().trim(), "");
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'Nearby Landmark')]]//div[2]")).getText().trim(), landmark.toUpperCase());
			}
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'Pincode')]]//div[2]")).getText().trim(), pincode);
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'State')]]//div[2]")).getText().trim(), state.toUpperCase());
			Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'District')]]//div[2]")).getText().trim(), district.toUpperCase());
			if(tehsil.equals("N/A"))
			{
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'Tehsil')]]//div[2]")).getText().trim(), "");
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'Tehsil')]]//div[2]")).getText().trim(), tehsil.toUpperCase());
			}
			if(parlimentaryConstituency.equals("N/A"))
			{
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'Parliamentary')]]//div[2]")).getText().trim(), "");
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'Parliamentary')]]//div[2]")).getText().trim(), parlimentaryConstituency.toUpperCase());
			}
			if(village.equals("N/A"))
			{
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'Village')]]//div[2]")).getText().trim(), "");
			}
			else
			{
				Assert.assertEquals(driver.findElement(By.xpath("//div[div[contains(text(),'Village')]]//div[2]")).getText().trim(), village.toUpperCase());
			}
			PostLoginPage plp=new PostLoginPage(driver);
			plp.clickOnProfileLogo();
			plp.clickOnLogout();
		}
	}
	
	@DataProvider
	public Object[][] enrolLinkJobVacancyData()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "Enroll_Link_Vacancy");
	}
	@Test(dataProvider="enrolLinkJobVacancyData", dependsOnMethods="rescheduleRozgarMelaTC_04")
	public void candidateEnrollmentByUploadForRozgarMelaTC_05(String rozgarMelaID, String jobID, String rozgarMelaName, String rmspocID, String rmspocPassword, String candidateListFile, String candidateID_SelfEnrollment, String candidatePassword_SelfEnrollment, String rozgarSTSE_ID, String rozgarSTSE_Password, String employerID, String companyName, String employerPassword, String jobTitle, String jobVacancyCount, String jobSector, String eligibilityCriteria, String jobDescription, String selectionProcess, String monthlyCompensation, String otherMonthlyIncentives, String workingHoursPerDay, String daysOffPerMonth, String jobLocationAddress, String jobLocationPinCode, String jobLocationState, String jobLocationDistrict, String jobFairSpocName, String jobFairSpocEmail, String jobFairSpocMobileNumber) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
		BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
		bvp.clickToClose();
		Thread.sleep(2000);
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(rmspocID, rmspocPassword);
		NSDC_RozgarMelaSPOC_DashboardPage rmDp=new NSDC_RozgarMelaSPOC_DashboardPage(driver);
		rmDp.clickViewRozgarMelas();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		NSDC_RozgarMelaSPOC_ViewRozgarMelasPage rVmp=new NSDC_RozgarMelaSPOC_ViewRozgarMelasPage(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rVmp.enterRozgarMelaIDToSearch(rozgarMelaID);
		rVmp.clickToApplyFilters();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]//td[2]")).getText().trim(), rozgarMelaID);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		rVmp.clickActionMenu();	
		rVmp.clickToChooseViewDetailsOption();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		RozgarMelaDetailSectionsPage rms=new RozgarMelaDetailSectionsPage(driver);
		rms.clickToGoToParticipatingCandidatesSection();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rms.clickToGetUploadCandidateRegistrationListWindow();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rms.clickToBrowseCandidateListfile();
		Thread.sleep(2000);
		UploadFile.upload(candidateListFile);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'RozgarMela-Candidate')]")));
		rms.clickToUploadSelectedCandidateListFile();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='toast-message']")).getText().contains("Candidates Registered Successfully"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		plp.clickOnLogout();	
	}
	
	@Test(dataProvider="enrolLinkJobVacancyData", dependsOnMethods="rescheduleRozgarMelaTC_04")
	public void candidateSelfEnrollmentForRozgarMelaTC_06(String rozgarMelaID, String jobID, String rozgarMelaName, String rmspocID, String rmspocPassword, String candidateListFile, String candidateID_SelfEnrollment, String candidatePassword_SelfEnrollment, String rozgarSTSE_ID, String rozgarSTSE_Password, String employerID, String companyName, String employerPassword, String jobTitle, String jobVacancyCount, String jobSector, String eligibilityCriteria, String jobDescription, String selectionProcess, String monthlyCompensation, String otherMonthlyIncentives, String workingHoursPerDay, String daysOffPerMonth, String jobLocationAddress, String jobLocationPinCode, String jobLocationState, String jobLocationDistrict, String jobFairSpocName, String jobFairSpocEmail, String jobFairSpocMobileNumber) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
	    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
	    bvp.clickToClose();
	    Thread.sleep(2000);
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(candidateID_SelfEnrollment, candidatePassword_SelfEnrollment);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		RozgarMela_CandidatePage rcp=new RozgarMela_CandidatePage(driver);
		rcp.clickToViewAllRozgarMelas();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rcp.clickToGetActionMenu(rozgarMelaName);
		rcp.selectAttendThisRozgarMelaOption(rozgarMelaName);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rcp.clickToAttendRozgarMela();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Successfully Registered for Rozgar Mela");
		Assert.assertEquals(driver.findElement(By.id("swal2-content")).getText().trim(), "Your admit card has been sent on your registered email id\nMela ID: "+rozgarMelaID+"\nMela Name : "+rozgarMelaName);
		rcp.clickToDownloadAdmitCard();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Your admit card has been downloaded successfully");
		rcp.clickOK();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-1000)", "");
		rcp.clickToGoToEnrolled_AttendedrozgarMelasection();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertTrue(driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaID+"')]]")).isDisplayed(), "OMG!!! No show enrolled rozgar mela");
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();	
	}
	
	@Test(dataProvider="enrolLinkJobVacancyData", dependsOnMethods={"candidateEnrollmentByUploadForRozgarMelaTC_05", "candidateSelfEnrollmentForRozgarMelaTC_06"})
	public void linkingEmployerForRozgarMelaTC_07(String rozgarMelaID, String jobID, String rozgarMelaName, String rmspocID, String rmspocPassword, String candidateListFile, String candidateID_SelfEnrollment, String candidatePassword_SelfEnrollment, String rozgarSTSE_ID, String rozgarSTSE_Password, String employerID, String companyName, String employerPassword, String jobTitle, String jobVacancyCount, String jobSector, String eligibilityCriteria, String jobDescription, String selectionProcess, String monthlyCompensation, String otherMonthlyIncentives, String workingHoursPerDay, String daysOffPerMonth, String jobLocationAddress, String jobLocationPinCode, String jobLocationState, String jobLocationDistrict, String jobFairSpocName, String jobFairSpocEmail, String jobFairSpocMobileNumber) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
	    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
	    bvp.clickToClose();
	    Thread.sleep(2000);
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(rozgarSTSE_ID, rozgarSTSE_Password);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		RozgarSTSE_DashboardPage rstd=new RozgarSTSE_DashboardPage(driver);
		rstd.clickViewRozgarMelas();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		RozgarSTSE_ViewRozgarMelasPage rvp=new RozgarSTSE_ViewRozgarMelasPage(driver);
		rvp.enterRozgarMelaIDTosearch(rozgarMelaID);
		rvp.clickTogetSearchresult();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rvp.clickToGetActionMenu();
		rvp.clickToChooseViewMelaDetailsOption();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		RozgarSTSE_ViewRozgarMelaPage rsvp=new RozgarSTSE_ViewRozgarMelaPage(driver);
		rsvp.clickToGoToParticipatingEmployersSection();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		rsvp.clickLinkEmployer();
		rsvp.enterEmployerIDToSearch(employerID);
		rsvp.clickSearch();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertTrue(driver.findElement(By.xpath("//tr[td[text()='"+employerID+"']]")).isDisplayed(),"Link Employer : No show of searched employer ID");
		rsvp.clickToSelectEmployerToLink();
		rsvp.clickToAlignSelectedEmployers();
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Selected Employers has been Linked to Rozgar Mela: "+rozgarMelaID);
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();	
	}
	
	@Test(dataProvider="enrolLinkJobVacancyData", dependsOnMethods="linkingEmployerForRozgarMelaTC_07")
	public void jobVacancyCreationForRozgarMelaTC_08(String rozgarMelaID, String jobID, String rozgarMelaName, String rmspocID, String rmspocPassword, String candidateListFile, String candidateID_SelfEnrollment, String candidatePassword_SelfEnrollment, String rozgarSTSE_ID, String rozgarSTSE_Password, String employerID, String companyName, String employerPassword, String jobTitle, String jobVacancyCount, String jobSector, String eligibilityCriteria, String jobDescription, String selectionProcess, String monthlyCompensation, String otherMonthlyIncentives, String workingHoursPerDay, String daysOffPerMonth, String jobLocationAddress, String jobLocationPinCode, String jobLocationState, String jobLocationDistrict, String jobFairSpocName, String jobFairSpocEmail, String jobFairSpocMobileNumber) throws Exception
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
	    BetaVersionOfSmartPage bvp=new BetaVersionOfSmartPage(driver);
	    bvp.clickToClose();
	    Thread.sleep(2000);
		EnterLoginPage elp=new EnterLoginPage(driver);
		elp.performlogin(employerID, employerPassword);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Employer_RozgarMelaPage erp=new Employer_RozgarMelaPage(driver);
		erp.enterRozgarMelaIdTosearch(rozgarMelaID);
		erp.clickToApplySearchFilters();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		erp.clickToGetActionMenuOptions();
		erp.chooseCreateJobVacancyOption();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Employer_JobVacancyCreationPage ejp=new Employer_JobVacancyCreationPage(driver);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#associatedRozgarMela")).getAttribute("value").trim(), rozgarMelaID);	
		Assert.assertEquals(driver.findElement(By.cssSelector("input#companyName")).getAttribute("value").trim(), companyName);	
		ejp.enterJobTitle(jobTitle);
		ejp.enterJobVacancyCount(jobVacancyCount);
		ejp.selectJobSector(jobSector);
		ejp.selectEligibilityCriteria(eligibilityCriteria);
		ejp.enterJobDescription(jobDescription);
		ejp.enterSelectionProcess(selectionProcess);
		ejp.enterMonthlyCompensation(monthlyCompensation);
		ejp.enterOtherMonthlyIncentives(otherMonthlyIncentives);
		ejp.enterWorkingHoursPerDay(workingHoursPerDay);
		ejp.enterDaysOffPerMonth(daysOffPerMonth);
		ejp.enterJobLocationAddress(jobLocationAddress);
		ejp.enterJobLocationPinCode(jobLocationPinCode);
		ejp.selectJobLocationState(jobLocationState);
		ejp.selectJobLocationDistrict(jobLocationDistrict);
		ejp.clickToSubmitAndProceedForJobFairSpoc();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		ejp.enterJobFairSpocName(jobFairSpocName);
		ejp.enterJobFairSpocEmail(jobFairSpocEmail);
		ejp.enterJobFairSpocMobileNumber(jobFairSpocMobileNumber);
		ejp.clickSubmit();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		ejp.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		ejp.clickToGoToOfferedJobVacanciesSection();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		String createdJobID=driver.findElement(By.xpath("//tr[td[contains(text(),'"+employerID+"')]]//td[2]")).getText().trim();
		ReadWriteData.setExcelData("./TestData/Workflow/NSDC_RMSPOC_RozgarMela-Workflow.xls", "Enroll_Link_Vacancy", 1, 1, createdJobID);
		ejp.clickPostAndSubmit();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText().trim(), "Successfully Aligned For  "+rozgarMelaName);
		ejp.clickOk();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("blockUI.blockOverlay")));
		PostLoginPage plp=new PostLoginPage(driver);
		plp.clickOnProfileLogo();
		Thread.sleep(2000);
		plp.clickOnLogout();
	}
}