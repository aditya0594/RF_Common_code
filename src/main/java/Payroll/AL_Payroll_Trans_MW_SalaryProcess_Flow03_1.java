package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_MW_SalaryProcess_Flow03_1 extends BaseClass
{
	JavascriptExecutor js = (JavascriptExecutor)driver;

	@FindBy(linkText = "Salary Process")
	private WebElement salaryProcessLink;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtMonthYear")
	private WebElement monthYearField;
	
	@FindBy(xpath = "//span[@class='select2-selection__rendered']")
	private WebElement collegeDropdown;
	
	@FindBy(xpath = "(//input[@role='textbox'])[1]")
	private WebElement collegeSaerch;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaff")
	private WebElement staffDropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_butSalaryProcess")
	private WebElement processSalaryBtn;

	public AL_Payroll_Trans_MW_SalaryProcess_Flow03_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	public AL_Payroll_Trans_MW_SalaryProcess_Flow03_1 Click_SalaryProcess() throws Exception {
		System.out.println("Click Salary Process");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", salaryProcessLink);
		threadWait1();
		js.executeScript("arguments[0].click();", salaryProcessLink);
		return this;
	}
	

	public AL_Payroll_Trans_MW_SalaryProcess_Flow03_1 Select_MonthYear() throws Exception {
		System.out.println("Select Month and Year");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.xpath("(//i[@id='ctl00_ContentPlaceHolder1_ImaCalStartDate'])[1]"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_year_0_3"));
		year_select.click(); //year = 2022
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_month_2_0"));
		month_select.click();  // month=Sep
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_day_1_3"));
		date_select.click();    // day=1

		return this;
	}
	
	
	public AL_Payroll_Trans_MW_SalaryProcess_Flow03_1 Select_College() throws Exception {
		System.out.println("Select College");

//		js.executeScript("arguments[0].scrollIntoView();", collegeDropdown);
//		js.executeScript("arguments[0].click();",collegeDropdown);
		collegeDropdown.click();
		Thread.sleep(2000);
		collegeSaerch.sendKeys("Mechanical");
		collegeSaerch.sendKeys(Keys.ENTER);
		return this;
	}
	

	public AL_Payroll_Trans_MW_SalaryProcess_Flow03_1 Select_Staff() throws Exception {
		System.out.println("Select Staff => Admin NTS");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", staffDropdown);
		Select select = new Select(staffDropdown);
		select.selectByVisibleText("Admin NTS");
		return this;
	}
	

	public AL_Payroll_Trans_MW_SalaryProcess_Flow03_1 Click_ProcessSalaryButton() throws Exception {
		System.out.println("Click on Process Salary button");
		threadWait1();
		js.executeScript("arguments[0].scrollIntoView();", processSalaryBtn);
		threadWait1();
		js.executeScript("arguments[0].click();", processSalaryBtn);
		threadWait1();
		return this;
	}
}
