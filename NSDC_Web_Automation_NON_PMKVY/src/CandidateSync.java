

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.touch.offset.PointOption;

public class CandidateSync
{
	@SuppressWarnings("rawtypes")
	public static void scrollScreenForMobile(AppiumDriver appDriver) throws Exception 
	{
		Thread.sleep(2000);
		Dimension winsize = appDriver.manage().window().getSize();
		
		int startx = (winsize.width * 0)/100;
		int endx = (winsize.width * 15)/100;
		int starty = (winsize.width * 0)/100;
		int endy = (winsize.width * 80)/100;
		
		TouchAction act = new TouchAction(appDriver);
		act.press(new PointOption().withCoordinates(startx, starty)).waitAction(waitOptions(Duration.ofSeconds(2))).moveTo(point(endx, endy)).release().perform();
		Thread.sleep(3000);
	}
	
	@SuppressWarnings("rawtypes")
	public static void scrollScreenForMobileForDone(AppiumDriver appDriver) throws Exception 
	{
		Thread.sleep(2000);
		Dimension winsize = appDriver.manage().window().getSize();
		
		int startx = (winsize.width * 0)/100;
		int endx = (winsize.width * 25)/100;
		int starty = (winsize.width * 0)/100;
		int endy = (winsize.width * 35)/100;
		
		TouchAction act = new TouchAction(appDriver);
		act.press(new PointOption().withCoordinates(startx, starty)).waitAction(waitOptions(Duration.ofSeconds(2))).moveTo(point(endx, endy)).release().perform();
		Thread.sleep(3000);
	}
	
	
	@SuppressWarnings("rawtypes")
	public static void scrollScreenForMobileUp(AppiumDriver appDriver) throws Exception 
	{
		Thread.sleep(2000);
		Dimension winsize = appDriver.manage().window().getSize();
		
		int startx = (winsize.width * 25)/100;
		int endx = (winsize.width * 0)/100;
		int starty = (winsize.width * 40)/100;
		int endy = (winsize.width * 0)/100;
		
		TouchAction act = new TouchAction(appDriver);
		act.press(new PointOption().withCoordinates(startx, starty)).waitAction(waitOptions(Duration.ofSeconds(2))).moveTo(point(endx, endy)).release().perform();
		Thread.sleep(3000);
	}
	
	@DataProvider
    public Object[][] registrationData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/CandidateSync-Workflow.xls", "CandidateRegisteration");
    }
    
    @SuppressWarnings("rawtypes")
	@Test(dataProvider="registrationData")
    public void canSyncOfflineTC_01(String fullName, String Guardianname, String EmailAddress, String MobileNumber,String gender, String pincode) throws MalformedURLException, Exception

	{
		   DesiredCapabilities cap = new DesiredCapabilities();
	        
		        cap.setCapability("platformName", "Android");
	           cap.setCapability("platformVersion", "8.1.0");
	           cap.setCapability("deviceName", "032872488T062365");
	           cap.setCapability("appPackage", "com.sdms.candidate_offline");
	           cap.setCapability("appActivity", "com.sdms.candidate_offline.MainActivity");
	           cap.setCapability("noReset", "true");

	           AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	          
	           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	           ((AppiumDriver)driver).runAppInBackground(Duration.ofSeconds(2));
	           ((StartsActivity)driver).currentActivity();
	           driver.findElement(By.xpath("//android.widget.Button[@text='Register']")).click();
	           driver.findElement(By.xpath("//android.widget.Image[@text='registrationlogo']")).click();
	           driver.findElementById("com.mediatek.camera:id/rlk_camera_switcher").click();
	           driver.findElementById("com.mediatek.camera:id/shutter_button").click();
	           driver.findElementById("com.mediatek.camera:id/done_button").click();
	           Thread.sleep(4000);
	           driver.findElementById("userName").clear();
	           driver.findElementById("userName").sendKeys(fullName);
	           driver.findElementById("guardianName").clear();
	           driver.findElementById("guardianName").sendKeys(Guardianname);
	           driver.findElementById("email").clear();
	          driver.findElementById("email").sendKeys(EmailAddress);
	           driver.findElementById("mobileNumber").clear();
	           driver.findElementById("mobileNumber").sendKeys(MobileNumber);
	           Thread.sleep(4000);
	           driver.findElementById("gender").click();
	           driver.findElement(By.xpath("//android.view.View[@text='"+gender+"']")).click();
	           driver.findElementById("dob").click();
	           Thread.sleep(2000);
	           CandidateSync.scrollScreenForMobile(driver);
	           ((AppiumDriver)driver).runAppInBackground(Duration.ofSeconds(2));
	           ((StartsActivity)driver).currentActivity();
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'DONE')]")).click();
	           Thread.sleep(6000);
	           CandidateSync.scrollScreenForMobile(driver);
	           driver.findElement(By.xpath("(//android.widget.Spinner)[3]")).click();
	           Thread.sleep(7000);
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[4]")).click();
	           Thread.sleep(5000);
	           driver.findElementById("pincode").clear();
	           driver.findElementById("pincode").sendKeys(pincode);
	           Thread.sleep(3000);
	          CandidateSync.scrollScreenForMobile(driver);
	          CandidateSync.scrollScreenForMobile(driver);
	          Thread.sleep(3000);
	           driver.findElement(By.xpath("(//android.widget.Spinner)[4]")).click();
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[4]")).click();
	           Thread.sleep(6000);
	           CandidateSync.scrollScreenForMobile(driver);
	           CandidateSync.scrollScreenForMobile(driver);
	           driver.findElement(By.xpath("(//android.widget.Spinner)[5]")).click();
	           Thread.sleep(6000);
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[5]")).click();
	           CandidateSync.scrollScreenForMobileForDone(driver);
	           driver.findElementById("program").click();
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[2]")).click();
	           Thread.sleep(4000);
	           driver.findElementById("organation").click();
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[3]")).click();
	           driver.findElementById("cio").click();
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[3]")).click();
	          Thread.sleep(4000);
	           CandidateSync.scrollScreenForMobileForDone(driver);
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[1]")).click();
	           driver.findElement(By.xpath("//android.widget.Button[@text='Submit Details']")).click();
	           Assert.assertEquals(driver.findElement(By.xpath("//android.view.View[@text='User registered successfully.']")).getText().trim(), "User registered successfully.");
	           Thread.sleep(4000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'OKAY')]")).click();
	           Thread.sleep(8000);
	        /*   CandidateSync.scrollScreenForMobileUp(driver);
	         //  Thread.sleep(3000);
	           CandidateSync.scrollScreenForMobileUp(driver);
	         //  Thread.sleep(3000);
	           CandidateSync.scrollScreenForMobileUp(driver);
	           CandidateSync.scrollScreenForMobileUp(driver);
	           //  Thread.sleep(3000);
	             CandidateSync.scrollScreenForMobileUp(driver);
	           //  Thread.sleep(3000);
	             CandidateSync.scrollScreenForMobileUp(driver);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'arrow back')]")).click();
	           Thread.sleep(4000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'View Registered Data')]")).click();
	           Thread.sleep(5000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Sync')]")).click();
	           Thread.sleep(3000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'OKAY')]")).click();*/

	}
	}