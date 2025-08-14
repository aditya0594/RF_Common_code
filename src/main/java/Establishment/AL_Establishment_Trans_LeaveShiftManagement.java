package Establishment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Establishment_Trans_LeaveShiftManagement extends BaseClass
{
	public AL_Establishment_Trans_LeaveShiftManagement(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Leave Shift Management") private WebElement leaveShiftManagement;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate") private WebElement fromDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegeDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlIncharge") private WebElement inchargeDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlshiftbulk") private WebElement shiftBulkDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvIncharge_ctrl0_chkSelect") private WebElement selectCheckbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement saveButton;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportButton;


	public AL_Establishment_Trans_LeaveShiftManagement Click_LeaveShiftManagement() throws Exception {
		System.out.println("Click on Leave Shift Management");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", leaveShiftManagement);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", leaveShiftManagement);
		
		return this;
	}
	
	public AL_Establishment_Trans_LeaveShiftManagement Enter_FromDate() throws Exception {
		System.out.println("Enter From Date ==> 01/03/2025");
		
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.xpath("(//i[@class='fa fa-calendar text-blue'])[1]"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromDate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromDate_year_1_2"));
		year_select.click(); //year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromDate_month_0_2"));
		month_select.click();  // month=march
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromDate_day_0_6"));
		date_select.click();    // day=1

		return this;
	}
	
	public AL_Establishment_Trans_LeaveShiftManagement Select_College() throws Exception {
		System.out.println("Select College ==> Crescent Institute");
		Thread.sleep(2000);
		Select select = new Select(collegeDropdown);
		select.selectByVisibleText("Crescent Institute");
		return this;
	}
	
	public AL_Establishment_Trans_LeaveShiftManagement Select_Incharge() throws Exception {
		System.out.println("Select Incharge ==> MOHAMMED ABUBACKER MR-5");
		Thread.sleep(2000);
		Select select = new Select(inchargeDropdown);
		select.selectByVisibleText("MOHAMMED ABUBACKER MR-5");
		return this;
	}
	
	public AL_Establishment_Trans_LeaveShiftManagement Select_AssignShiftName() throws Exception {
		System.out.println("Select Assign Shift Name ==> General");
		Thread.sleep(2000);
		Select select = new Select(shiftBulkDropdown);
		select.selectByVisibleText("General");
		return this;
	}
	
	public AL_Establishment_Trans_LeaveShiftManagement Click_SelectCheckbox() throws Exception {
		System.out.println("Click on Select Checkbox");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", selectCheckbox);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", selectCheckbox);
		return this;
	}
	
	public AL_Establishment_Trans_LeaveShiftManagement Click_SaveButton() throws Exception {
		System.out.println("Click on Save Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", saveButton);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", saveButton);
		return this;
	}
	
	public AL_Establishment_Trans_LeaveShiftManagement Click_ReportButton() throws Exception {
		System.out.println("Click on Report Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", reportButton);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", reportButton);
		
		return this;
	}
}
