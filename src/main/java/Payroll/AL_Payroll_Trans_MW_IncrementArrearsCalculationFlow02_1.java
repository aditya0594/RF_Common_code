package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1 extends BaseClass 
{
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlCollegeType") private WebElement staffType;
	@FindBy(id ="ctl00_ContentPlaceHolder1_txtGovOrdNo") private WebElement GovorderNum;
	@FindBy(id ="ctl00_ContentPlaceHolder1_txtOffOrdNo") private WebElement offOrderNum;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnShowEmployee") private WebElement ShowEmployBtn;
	
	@FindBy(id ="ctl00_ContentPlaceHolder1_lvEmployees_cbHead") private WebElement ChkBox;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnCalculate") private WebElement Calculate_btn;
	
	public AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1 IncrementArrearsCalculation() throws InterruptedException {
		System.out.println("Click on Increment Arrears Calculation");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement arr_cal = driver.findElement(By.id("ctl00_repLinks_ctl20_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",arr_cal);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", arr_cal);
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1 Select_College() {
		System.out.println("Select College Name => Crescent School of Architecture");
		Select select = new Select(college);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1 Select_Staff() {
		System.out.println("Select Staff  => Teaching Staff");
		Select select = new Select(staffType);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1 Set_ArrearsFromDate() throws InterruptedException {
		System.out.println("Set Arrears From Date => 01/01/2025");
		
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCPTCalFromDate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_year_1_2"));
		year_select.click(); 
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_month_0_0"));
		month_select.click();
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_day_0_3"));
		date_select.click();

		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1 Enter_GovOrderNum() {
		System.out.println("Enter Gov Order Num=>100");
		clearText(GovorderNum);
		sendKeys(GovorderNum, "100");
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1 Enter_OfficeOrderNum() {
		System.out.println("Enter Office Order Num=>100");
		clearText(offOrderNum);
		sendKeys(offOrderNum, "100");
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1 Set_ToDate() throws InterruptedException {
		System.out.println("Set To Date => 01/01/2028");
		
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCPTCalToDate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceCPTToDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceCPTToDate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceCPTToDate_year_2_1"));
		year_select.click(); 
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceCPTToDate_month_0_0"));
		month_select.click();
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceCPTToDate_day_0_6"));
		date_select.click();

		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1 Click_ShowEmployeeBtn() {
		System.out.println("Click Show Employee Btn");
		click(ShowEmployBtn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1 Click_CheckBox() {
		System.out.println("Click Check Box");
		click(ChkBox);
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsCalculationFlow02_1 Click_CalculateBtn() {
		System.out.println("Click Calculate btn");
		click(Calculate_btn);
		return this;
	}
}
