package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_MW_ArrearsCalculationFlow01_1 extends BaseClass
{
	JavascriptExecutor js= (JavascriptExecutor)driver;

	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlCollegeType") private WebElement staffScheme;
	@FindBy(id ="ctl00_ContentPlaceHolder1_txtCurRate") private WebElement currentRate;
	@FindBy(id ="ctl00_ContentPlaceHolder1_txtGovOrdNo") private WebElement govOrderNum;
	@FindBy(id ="ctl00_ContentPlaceHolder1_txtOffOrdNo") private WebElement offOrderNum;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlPayhead") private WebElement Payhead;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlRule") private WebElement rule;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnCalculate") private WebElement calculate;

	
	public AL_Payroll_Trans_MW_ArrearsCalculationFlow01_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Trans_MW_ArrearsCalculationFlow01_1 ArrearsCalculation() throws InterruptedException {
		System.out.println("Click Arrears Calculation ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement arrea_cal = driver.findElement(By.id("ctl00_repLinks_ctl11_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",arrea_cal);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", arrea_cal);
		return this;
	}
	
	public AL_Payroll_Trans_MW_ArrearsCalculationFlow01_1 Select_College() {
		System.out.println("Select College Name => Crescent School of Architecture");
		Select select = new Select(college);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Trans_MW_ArrearsCalculationFlow01_1 Select_Staff() {
		System.out.println("Select Staff Name =>Teaching Staff");
		Select select = new Select(staffScheme);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Payroll_Trans_MW_ArrearsCalculationFlow01_1 Set_ArrearsFromDate() throws InterruptedException {
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
	
	public AL_Payroll_Trans_MW_ArrearsCalculationFlow01_1 Enter_CurrentRate() {
		System.out.println("Enter Current Rate =>15");
		sendKeys(currentRate, "15");
		return this;
	}
	
	public AL_Payroll_Trans_MW_ArrearsCalculationFlow01_1 Enter_GovOrderNum() {
		System.out.println("Enter Gov Order Num=>1001");
		sendKeys(govOrderNum, "1001");
		return this;
	}
	
	public AL_Payroll_Trans_MW_ArrearsCalculationFlow01_1 Enter_OfficeOrderNum() {
		System.out.println("Enter Office Order Num=>1001");
		sendKeys(offOrderNum, "1005");
		return this;
	}
	
	public AL_Payroll_Trans_MW_ArrearsCalculationFlow01_1 Select_PayHead() {
		System.out.println("Select PayHead => DA");
		Select select = new Select(Payhead);
		select.selectByVisibleText("DA");
		return this;
	}
	
	public AL_Payroll_Trans_MW_ArrearsCalculationFlow01_1 Set_ToDate() throws InterruptedException {
		System.out.println("Set Arrears From Date => 01/01/2028");
		
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
	
	public AL_Payroll_Trans_MW_ArrearsCalculationFlow01_1 Select_Rule() {
		System.out.println("Select Rule => R6");
		Select select = new Select(rule);
		select.selectByVisibleText("R6");
		return this;
	}
	
	public AL_Payroll_Trans_MW_ArrearsCalculationFlow01_1 Click_Calculation() {
		System.out.println("Click on Calculation ");
		click(calculate);
		return this;
	}
}
