package Establishment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Establishment_Trans_TransferAttendanceRecordFlow05_1 extends BaseClass
{
	public AL_Establishment_Trans_TransferAttendanceRecordFlow05_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	
	@FindBy(xpath ="//a[text()='Transfer Attendance Record']") private WebElement TransferAttendanceRecord;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlstafftype") private WebElement staff;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnShow") private WebElement showbtn;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnEdit") private WebElement editbtn;
	@FindBy(xpath ="(//input[@class='form-control form-control-sm'])[1]") private WebElement searchname;
	@FindBy(id ="ctl00_ContentPlaceHolder1_lvEmpList_ctrl15_txtleaveUpdated") private WebElement Lwp;



	public AL_Establishment_Trans_TransferAttendanceRecordFlow05_1 Click_TransferAttendanceRecord() throws Exception {
		System.out.println("Click on Transfer Attendance Record");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",TransferAttendanceRecord);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", TransferAttendanceRecord);
		
		return this;
	}
	
	public AL_Establishment_Trans_TransferAttendanceRecordFlow05_1 Select_College() throws Exception {
		System.out.println("Select College ==> Crescent School of Law");
		Select select = new Select(college);
		select.selectByVisibleText("Crescent School of Law");
		return this;
	}
	
	public AL_Establishment_Trans_TransferAttendanceRecordFlow05_1 Select_StaffType() throws Exception {
		System.out.println("Select Staff Type ==> Teaching Staff");
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Establishment_Trans_TransferAttendanceRecordFlow05_1 Select_FromDate() throws Exception {
		System.out.println("Select From Date => 01/03/2025");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalFromDate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_year_1_2"));
		year_select.click(); //year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_month_0_2"));
		month_select.click();  // month=march
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_day_0_6"));
		date_select.click();    // day=1

		return this;
	}
	
	public AL_Establishment_Trans_TransferAttendanceRecordFlow05_1 Select_ToDate() throws Exception {
		System.out.println("Select To Date => 31/03/2025");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalToDate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_year_1_2"));
		year_select.click(); //year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_month_0_2"));
		month_select.click();  // month=march
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_day_5_1"));
		date_select.click();    // day=31

		return this;
	}
	
	public AL_Establishment_Trans_TransferAttendanceRecordFlow05_1 Click_ShowBtn() throws Exception {
		System.out.println("Click on Show btn");
		click(showbtn);
		return this;
	}
	
	
	public AL_Establishment_Trans_TransferAttendanceRecordFlow05_1 Click_EditBtn() throws Exception {
		System.out.println("Click on Edit btn btn");
		click(editbtn);
		return this;
	}
	
	public AL_Establishment_Trans_TransferAttendanceRecordFlow05_1 Search_Name_EnterLWP() throws Exception {
		System.out.println("Search_Name => NAZNEEN  and Enter LWP=> 1");
		sendKeys(searchname, "NAZNEEN ");
		threadWait1();
		clearText(Lwp);
		sendKeys(Lwp, "1");
		return this;
	}

	
	public AL_Establishment_Trans_TransferAttendanceRecordFlow05_1 Click_Transferbtn() throws Exception {
		System.out.println("Click on Transfer btn");
		WebElement trfbtn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnUpdate"));
		click(trfbtn);
		WebElement yesbtn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnOkDel"));
		click(yesbtn);
		return this;
	}
}
