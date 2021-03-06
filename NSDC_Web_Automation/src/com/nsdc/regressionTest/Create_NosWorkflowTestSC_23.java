package com.nsdc.regressionTest;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.CreateNationalOccupationalStandardpage;
import com.nsdc.pages.Qpnos_createpage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.testConfig.TestConfiguration;

public class Create_NosWorkflowTestSC_23  extends TestConfiguration
{
	@DataProvider
	public Object[][]createNosdata()
 	{
 		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "create_Nos");
 	}
 	@Test(dataProvider="createNosdata")
 	public void addCreateNosdata(String username , String password , String sector, String polutry,String occupation, 
 	String credits, String nsqflevel, String nosname, String nosdescripation, String nosscope , 
 	String nextreviewperiod,
 	String acronmyskeyword,
	String acronmysDescription,String glossaryKeyword,String glossaryDescription,String governmentDoc,
	String rfpDoc,String aboutsector,String labourMarketCity,String stakeholder,String occupationalmapping,
	String functionalAnalysis,String approvalQNos,String qfileQcNs,String qrcPresenation,String qrcSummarySheet,
	String otherDocument)throws Exception
 	{
 		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@role='document' and @style='margin-top: 10.4%;']//button[@class='close']")).click();
		Thread.sleep(3000);
 		
 		LoginPage lp = new LoginPage(driver);
 		lp.clickLogin();
 		Thread.sleep(3000);
 		BetaVersionOfSmartPage bvsp=new BetaVersionOfSmartPage(driver);
 		bvsp.clickToClose();
 		EnterLoginPage ep=new EnterLoginPage(driver);
 		ep.performlogin(username, password);
 		SSC_DashboardPage sscDp=new SSC_DashboardPage(driver);
 		sscDp.clickOn_QP_NOS_ModelCurriculum();
 		Thread.sleep(3000);
 	Qpnos_createpage qp=new Qpnos_createpage (driver);
 	Thread.sleep(3000);
 	qp.createNosclick();
 	CreateNationalOccupationalStandardpage qpNos=new CreateNationalOccupationalStandardpage(driver);
 	Thread.sleep(3000);
 	qpNos.clickSubSector();
 	qpNos.clickSubSectorText();
 	driver.findElement(By.xpath("//div[@class='c-list']")).click();
 	Thread.sleep(3000);
 	qpNos.ClickOnOccupation(occupation);
 	qpNos.selectCredits(credits);
 	qpNos.selectNSQFlevel(nsqflevel);
 	String nosName1="BSNLqdfqaw";
 	qpNos.EnterTheNOsName(nosName1);
  	qpNos.enterNOsDescription(nosdescripation);
 	qpNos.entersetNosScope(nosscope);
 	//qpNos.enterSetNextReviewPeriod(nextreviewperiod);
 	qpNos.clickSaveAndContinouBtton();
	Thread.sleep(3000);
 	//
 	String total_element=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", 1, 0);
 	int totalelements=Integer.parseInt(total_element);
 	for(int i=1;i<=totalelements;i++)	
	{    
		String element=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", i, 1);
	driver.findElement( By.xpath("//input[@formcontrolname='element']")).sendKeys(element);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[i[@class='la la-save green']]")).click();
	String numberofpc=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", 1, 2);
	int totalpc=Integer.parseInt(numberofpc);
	for(int j=1;j<=totalpc;j++)
	{      
        String pcName=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", j, 3);
        driver.findElement(By.xpath("(//textarea[@name='pcDescription'])")).sendKeys(pcName);
	   driver.findElement(By.xpath("//button[contains(text(),'+ Add')]")).click();
        }
	 if(i<=totalelements-1)
		{
		qpNos.clickAddAnotherElement();
		
		}
	}
 	Thread.sleep(3000);
	qpNos.clickSaveAndContinouBtton();
	Thread.sleep(3000);
//	qpNos.clickOnAddKU();
//	Thread.sleep(3000);
	
	qpNos.clickSaveAndContinouBtton();
	Thread.sleep(5000);
//	qpNos.clickOnAddGS();
	qpNos.clickSaveAndContinouBtton();
	Thread.sleep(5000);

	//assessment
	 String assessement=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", 1, 4);
	 String minimumScore=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", 1, 5);
	qpNos.enterGuidelinesAssessment(assessement);
	qpNos.enterTheMinimumScore(minimumScore);
	Thread.sleep(2000);
	 String numberOfbox=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", 1, 6);
	 int n=Integer.parseInt(numberOfbox);
	for(int i=1;i<=n;i++)
	{
		 String theoryMarks=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", i, 7);
		 String practicalMarks=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", i, 8);
		 String projectMarks=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", i, 9);
		 String vivamarks =ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", i, 10);
	     driver.findElement(By.xpath("(//input[@formcontrolname='theory'])["+i+"]")).sendKeys(theoryMarks);
	     driver.findElement(By.xpath("(//input[@formcontrolname='practical'])["+i+"]")).sendKeys(practicalMarks);
	     driver.findElement(By.xpath("(//input[@formcontrolname='ojt'])["+i+"]")).sendKeys(projectMarks);
	     driver.findElement(By.xpath("(//input[@formcontrolname='viva'])["+i+"]")).sendKeys(vivamarks);	
	}
	qpNos.clickTotal();
	qpNos.clickSaveAndContinouBtton();
	Thread.sleep(2000);
	//Acronyms
	qpNos.enterAcronymsKeyword(acronmyskeyword);
	qpNos.enterAcronymsDescription(acronmysDescription);
	driver.findElement(By.xpath("(//button[text()='+ Add'])[1]")).click();
	qpNos.enterGlossaryKeyword(glossaryKeyword);
	qpNos.enterGlossaryDescription(glossaryDescription);
	driver.findElement(By.xpath("(//button[text()='+ Add'])[2]")).click();
	String standalone = driver.findElement(By.xpath("//label[input[@value='standalone']]")).getText();
	//qpNos.clickStandaloneNos();
	if(!standalone.equalsIgnoreCase("Make Available for Qualification Pack "))
	{	
		
		qpNos.clickStandaloneNos();
		Thread.sleep(2000);
		
		List<WebElement> ListOfBrowser = driver.findElements(By.xpath("//input[@id='customFile']"));
		
		int numOFbrowsers=ListOfBrowser.size();
		
		for(int i=0;i<=numOFbrowsers-1;i++)
		{
			ListOfBrowser.get(i).click();
			Thread.sleep(2000);
			UploadFile.upload(governmentDoc);
			Thread.sleep(3000);
			
		}
		WebElement scrollup = driver.findElement(By.xpath("(//input[@id='customFile'])[1]"));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-2500)");
		// js.executeScript("arguments[0].scrollIntoView();", scrollup);
		List<WebElement> listOfUploadButtons = driver.findElements(By.xpath("//button[contains(text(),'Upload')]"));
		
		int numberOfUPloadButtons = listOfUploadButtons.size();
		
		for(int j=0;j<=numberOfUPloadButtons-1;j++)
		{
			Thread.sleep(2000);
			listOfUploadButtons.get(j).click();
			Thread.sleep(5000);
		}
		
		
		qpNos.clickSubmitForReview();
		qpNos.clickContinueToSubmit();
		qpNos.clickOkButton();
	}	
	else
	{
		qpNos.clicksaveAndExitButton();
		Thread.sleep(1000);
		qpNos.clickOkButton();
		Thread.sleep(1000);
		qpNos.clickOkButton();
	}
	PostLoginPage plp=new PostLoginPage(driver);
    Thread.sleep(3000);
   plp.clickOnProfileLogo();
	Thread.sleep(2000);
	plp.clickOnLogout();
 	}
}
//	
//	@Test(dataProvider="createNosdata")
// 	public void viewAllNOssVerification(String username , String password , String sector, String polutry,String occupation, 
// 	String credits, String nsqflevel, String nosname, String nosdescripation, String nosscope , 
// 	String nextreviewperiod,
// 	String acronmyskeyword,
//	String acronmysDescription,String glossaryKeyword,String glossaryDescription,String governmentDoc,
//	String rfpDoc,String aboutsector,String labourMarketCity,String stakeholder,String occupationalmapping,
//	String functionalAnalysis,String approvalQNos,String qfileQcNs,String qrcPresenation,String qrcSummarySheet,
//	String otherDocument)throws Exception
// 	{
// 		LoginPage lp = new LoginPage(driver);
// 		lp.clickLogin();
// 		Thread.sleep(3000);
// 		BetaVersionOfSmartPage bvsp=new BetaVersionOfSmartPage(driver);
// 		bvsp.clickToClose();
// 		EnterLoginPage ep=new EnterLoginPage(driver);
// 		ep.performlogin(username, password);
// 		SSC_DashboardPage sscDp=new SSC_DashboardPage(driver);
// 		sscDp.clickOn_QP_NOS_ModelCurriculum();
// 		Thread.sleep(3000);
// 	Qpnos_createpage qp=new Qpnos_createpage (driver);
// 	Thread.sleep(3000);	
//qp.clickViewALLNoss();
//Thread.sleep(1000);
//driver.findElement(By.xpath("(//a[i[@class='la la-ellipsis-h']])[1]")).click();
//driver.findElement(By.xpath("( //a[contains(text(),'	View Details')])[1]")).click();
////verify
//
//Assert.assertEquals(driver.findElement(By.xpath("//div[@class='cuppa-dropdown']")).getText(), polutry);
//   WebElement listOccupation = driver.findElement(By.xpath("//select[@name='option']"));
//	Select sel=new Select(listOccupation);	
//Assert.assertEquals(sel.getFirstSelectedOption().getText(), occupation);
//             WebElement listCredits = driver.findElement(By.xpath("//select[@name='credits']"));
//             Select s=new Select(listCredits);
//Assert.assertEquals(s.getFirstSelectedOption().getText().trim(),credits);
//
//WebElement listnsqfLevel = driver.findElement(By.xpath("//select[@name='nsqf']"));
//
//Select sl=new Select( listnsqfLevel);
//Assert.assertEquals(sl.getFirstSelectedOption().getText().trim(), nsqflevel );
//Assert.assertEquals(driver.findElement(By.xpath("//textarea[@placeholder='Enter NOS Name']")).getAttribute("value"), nosname );
//Assert.assertEquals(driver.findElement(By.xpath("//textarea[@placeholder='Enter NOS Description']")).getAttribute("value"), nosdescripation );
//Assert.assertEquals(driver.findElement(By.xpath("//textarea[@placeholder='Enter NOS Scope']")).getAttribute("value"), nosscope );
////String version="1.0";
////Assert.assertEquals(driver.findElement(By.xpath("//input[@name='version']")).getAttribute("vlue"), version );
//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Enter Next Review Period in months from the QRC date']")).getAttribute("value"), nextreviewperiod );
//
//CreateNationalOccupationalStandardpage qpNos=new CreateNationalOccupationalStandardpage(driver);
//	Thread.sleep(3000);
//	qpNos.clickElementandperformancecriteria();
//	String element=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", 1, 1);
//	Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'NosS')]")).getText(), element);
//	String pc1=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", 1, 3);
//	Assert.assertEquals(driver.findElement(By.xpath("//tr[2]//td[2]")).getText(), pc1);
//	Thread.sleep(3000);
//	qpNos.clickknowledgeandunderstanding();
//	Thread.sleep(3000);
//	qpNos.clickGenericskill();
//	Thread.sleep(3000);
//	qpNos.clickAssenmentcriteria();
//	Thread.sleep(3000);
//	qpNos.clickAcronymsanddocuments();
//	Thread.sleep(3000);
//	
//	PostLoginPage plp=new PostLoginPage(driver);
//    Thread.sleep(3000);
//   plp.clickOnProfileLogo();
//	Thread.sleep(2000);
//	plp.clickOnLogout();
//
//	
// 	}
 	

//}

	
	
 	
 