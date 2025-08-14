package Establishment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Establishment_Trans_AttendanceProcessFlow05_2 extends BaseClass
{
	public AL_Establishment_Trans_AttendanceProcessFlow05_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js2 = (JavascriptExecutor) driver;

	@FindBy(xpath ="//a[text()='Attendance Process']") private WebElement attendProcess;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlStafftype") private WebElement staff;
	@FindBy(id ="ctl00_ContentPlaceHolder1_butAttendanceProcess") private WebElement leaveProcessBtn;

//	@FindBy(xpath = "(//a[@id='ctl00_repLinks_ctl17_lbLink'])[1]")
//	private WebElement AttendanceProcess;

	public AL_Establishment_Trans_AttendanceProcessFlow05_2 Click_AttendanceProcess() throws Exception {
		System.out.println("Click on Attendance Process");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",attendProcess);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", attendProcess);
		
		return this;
	}
	
	public AL_Establishment_Trans_AttendanceProcessFlow05_2 Select_College() throws Exception {
		System.out.println("Select College ==> Crescent School of Law");
		Select select = new Select(college);
		select.selectByVisibleText("Crescent School of Law");
		return this;
	}
	
	public AL_Establishment_Trans_AttendanceProcessFlow05_2 Select_StaffType() throws Exception {
		System.out.println("Select Staff Type ==> Teaching Staff");
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Establishment_Trans_AttendanceProcessFlow05_2 Select_MonthYear() throws Exception {
		System.out.println("Select Month and Year");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgMonthYear"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceMonthYear_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceMonthYear_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceMonthYear_year_1_2"));
		year_select.click(); //year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceMonthYear_month_1_0"));
		month_select.click();  // month=may
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceMonthYear_day_1_3"));
		date_select.click();    // day=1

		return this;
	}
	
	public AL_Establishment_Trans_AttendanceProcessFlow05_2 Click_LeaveProcessBtn() throws Exception {
		System.out.println("Click on Leave Process btn");
		click(leaveProcessBtn);
		return this;
	}
}
