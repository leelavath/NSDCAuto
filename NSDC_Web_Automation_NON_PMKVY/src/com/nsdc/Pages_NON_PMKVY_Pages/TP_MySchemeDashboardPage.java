package com.nsdc.Pages_NON_PMKVY_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class TP_MySchemeDashboardPage 
{
WebDriver driver;
	
	@FindBy(css=".m-nav__link-icon.la.la-home")
	private WebElement homeIconButton;
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	private WebElement dashboardButton;
	@FindBy(xpath="(//span[@class='m-nav__link-text'])[2]")
	private WebElement mySchemeButton;
	@FindBy(css=".btn.m-btn--pill.btn-primary.tab-color-blue")
	private WebElement addSchemeButton;
	@FindBy(xpath="//a[contains(text(),'Approved')]")
	private WebElement approvedSchemeButton;
	@FindBy(xpath="//a[contains(text(),'Approval in Progress')]")
	private WebElement approvalInProgressButton;
	@FindBy(xpath="//a[contains(text(),'Rejected')]")
	private WebElement rejectedSchemeButton;
	@FindBy(xpath="(//a[contains(text(),'View Scheme Details')])[1]")
	private WebElement viewDetailsButton;
	@FindBy(xpath="//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")
	private WebElement actionButton;
	/////////////////////
	@FindBy(xpath="//tr[td[span[span[text()='NON-PMKVY']]]]//a[i[@class='la la-ellipsis-h']]")
	private WebElement ActionIcon;
	
	@FindBy(xpath="//tr[td[span[span[text()='NON-PMKVY']]]]//a[contains(text(),'Add Program')]")
	private WebElement Add_program;
	
	
	@FindBy(xpath="//tbody[@class='m-datatable__body margin-table ']")
	private WebElement MySchemesListTable;
	
	
	
	public TP_MySchemeDashboardPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnHomeIcon()
	{
		homeIconButton.click();
	}
	
	public void clickOnDashboard()
	{
		dashboardButton.click();
	}
	
	public void clickOnMyScheme()
	{
		mySchemeButton.click();
	}
	
	public void clickOnAddSchemeOrProgram()
	{
		addSchemeButton.click();
	}
	
	public void clickOnApprovedScheme()
	{
		approvedSchemeButton.click();
	}
	
	public void clickOnApprovalInProgress()
	{
		approvalInProgressButton.click();
	}
	
	public void clickOnRejectedScheme()
	{
		rejectedSchemeButton.click();
	}
	
	public void clickOnViewDetails()
	{
		viewDetailsButton.click();
	}
	
	public void clickOnAction()
	{
		actionButton.click();
	}
///////////////////
	public void ClickOnAction()
	{
		ActionIcon.click();
	}
  public void ClickOnAddProgram()
  {
	  Add_program.click();
  }
  
  public void SelectSchemeOfSTT(String mainscheme,String subscheme) throws NumberFormatException, Exception {
  WebElement MySchemesListTable = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']"));
	
	 java.util.List<WebElement> rowstable = MySchemesListTable.findElements(By.tagName("tr"));

	int rows_count = rowstable.size();

	for (int row = 1; row < rows_count; row++) {

String nameofTheScheme = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr["+row+"]//td[2]")).getText();

			String SUBScheme = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr//td[span[span[text()='"+subscheme+"']]]")).getText();
			
			if (nameofTheScheme.equals(mainscheme)&& SUBScheme.equals(subscheme))
			{
				
				
				driver.findElement(By.xpath("//tr[td[span[span[text()='"+subscheme+"']]]]//a[@class='btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill']")).click();
			    driver.findElement(By.xpath("//tr[td[span[span[text()='"+subscheme+"']]]]//a[contains(text(),'Add Program')]")).click();
				
			break;
			}
			
		}
  }
}
	