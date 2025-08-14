package RFCCAcademic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;
import utility.ExcelUtility;

public class AL_Academic_AM_StudentAttendanceReport extends BaseClass
{
	ExcelUtility excelutilitytest;
	
	
	public AL_Academic_AM_StudentAttendanceReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl16_lbLink") private WebElement StudentAttendanceReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(xpath = "(//span[@class='multiselect-selected-text'])[1]") private WebElement searchCollege;
	@FindBy(xpath = "//input[@value='2']") private WebElement selectCollege;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnExcelCoursewise") private WebElement globleElectiveCourseWisereport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowStudentWise") private WebElement showStudentwiseAttendance;
	


	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	public AL_Academic_AM_StudentAttendanceReport Click_StudentAttendanceReport() throws InterruptedException {
		System.out.println("Click on Student Attendance Report");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",StudentAttendanceReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", StudentAttendanceReport);
		return this;
	}
	
	public AL_Academic_AM_StudentAttendanceReport Select_Session() throws InterruptedException {
		System.out.println("Select Session => May 2022");
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	
	public AL_Academic_AM_StudentAttendanceReport Select_College() throws InterruptedException {
		System.out.println("Select College => Crescent School of Architecture");
		click(searchCollege);
		waitUntilElementIsClickable(selectCollege);
		click(selectCollege);
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblDynamicPageTitle")).click();
		return this;
	}
	
	public AL_Academic_AM_StudentAttendanceReport Select_FromDate() throws InterruptedException {
		System.out.println("Select From Date => 1/01/2021");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_idPopup"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtFromDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtFromDate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtFromDate_year_0_2"));
		year_select.click(); //year = 2021
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtFromDate_month_0_0"));
		month_select.click();  // month=Jan
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtFromDate_day_0_5"));
		date_select.click();    // day=1

		return this;
	}
	
	public AL_Academic_AM_StudentAttendanceReport Select_ToDate() throws InterruptedException {
		System.out.println("Select From Date => 1/12/2025");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_idPopuptodate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceTodate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceTodate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceTodate_year_1_2"));
		year_select.click(); //year = 2021
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceTodate_month_2_3"));
		month_select.click();  // month=Jan
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceTodate_day_0_1"));
		date_select.click();    // day=1

		return this;
	}
	
	public AL_Academic_AM_StudentAttendanceReport Click_GlobleElectiveCourseWiseReportBtn() throws InterruptedException, IOException {
		System.out.println("Click on Globle Elective Course Wise Report btn");
		excelutilitytest = new ExcelUtility(driver);
		click(globleElectiveCourseWisereport);
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("VENKATESAN","CourseWiseAttendanceSummary"); 
		return this;
	}
	
	public AL_Academic_AM_StudentAttendanceReport Click_ShowStudentWiseAttendancebtn() throws InterruptedException, IOException {
		System.out.println("Click on Show Student Wise Attendance btn");
		excelutilitytest = new ExcelUtility(driver);
		click(showStudentwiseAttendance);
		Thread.sleep(3000);
		excelutilitytest.ReadExcel("Rajat","StudentWiseAttendanceSummary"); 
		return this;
	}
}
