package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Establishment.AL_Establishment_Rpt_AbsentReport;
import Establishment.AL_Establishment_Trans_ChangeShiftTime;
import utility.BaseClass;

public class AL_Payroll_Rpt_DetailReport extends BaseClass
{
	
	
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public AL_Payroll_Rpt_DetailReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	public AL_Payroll_Rpt_DetailReport DetailReport() throws InterruptedException {
		System.out.println("Click Detail Report ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement detail_sal = driver.findElement(By.id("ctl00_repLinks_ctl08_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",detail_sal);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", detail_sal);
		return this;
	}
	
	public AL_Payroll_Rpt_DetailReport Select_FromDate() throws InterruptedException {
		System.out.println("Select From Date => 04/01/2022");
	
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalFromDate1"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_year_0_3"));
		year_select.click(); //year day = 3
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_month_0_0"));
		month_select.click();
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_day_1_2"));
		date_select.click();
		return this;
	}
	
	public AL_Payroll_Rpt_DetailReport Select_ToDate() throws InterruptedException {
		System.out.println("Select To Date => 04/12/2024");
		
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalToDate1"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_year_1_1"));
		year_select.click(); //year day = 3
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_month_2_3"));
		month_select.click();
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_day_1_3"));
		date_select.click();
		return this;
	}
	
	public AL_Payroll_Rpt_DetailReport select_SchemeStafff_Type() {
		System.out.println("Select Scheme/Staff => Admin NTS");
		WebElement staff = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStaffNo"));
		Select select = new Select(staff);
		select.selectByVisibleText("Admin NTS");
		return this;
	}
	
	public AL_Payroll_Rpt_DetailReport select_Report_Type() {
		System.out.println("Select Report type => Date of Joining");
		WebElement rpt_type = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlReport"));
		Select select = new Select(rpt_type);
		select.selectByVisibleText("Date of Joining");
		return this;
	}
	
	public AL_Payroll_Rpt_DetailReport Click_ShowReport_btn() {
		System.out.println("Click Show Report Button");
		WebElement repo_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShowReport"));
		click(repo_btn);
		return this;
	}
}
