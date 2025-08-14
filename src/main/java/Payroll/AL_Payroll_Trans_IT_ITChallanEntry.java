package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_IT_ITChallanEntry extends BaseClass
{
	public AL_Payroll_Trans_IT_ITChallanEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl06_lbLink") private WebElement ITchallan;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollegeNo") private WebElement collegname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement staff;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtChallanNo") private WebElement chalan;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement savebtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Payroll_Trans_IT_ITChallanEntry Click_ITChallanEntry() throws InterruptedException {
		System.out.println(" Click on IT Challan Entry");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",ITchallan);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", ITchallan);
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITChallanEntry Select_Month() throws InterruptedException {
		System.out.println(" Select Month");
		WebElement calender_icon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalMonYear"));
		click(calender_icon);
		Thread.sleep(2000);
		WebElement month = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceFromDate_today"));
		click(month);
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITChallanEntry Select_ChalanDate() throws InterruptedException {
		System.out.println(" Select Chalan Date");
		WebElement calender_icon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalChDate"));
		click(calender_icon);
		Thread.sleep(2000);
		WebElement month = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceChDate_today"));
		click(month);
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITChallanEntry Select_College() {
		System.out.println("Select College ==> Crescent School of Law");
		Select select = new Select(collegname);
		select.selectByVisibleText("Crescent School of Law");
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITChallanEntry Select_ChalanNo() {
		System.out.println("Select Chalan No ==> 555");
		sendKeys(chalan, "555");
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITChallanEntry Select_TaxDeductionDate() throws InterruptedException {
		System.out.println(" Select Tax Deduction Date");
		js.executeScript("arguments[0].scrollIntoView();",ITchallan);
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalTaxDedDate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceTaxDedDate_title"));
		title.click(); 
		
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITChallanEntry Select_TaxDepositDate() throws InterruptedException {
		System.out.println(" Select Tax Deposit Date");
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgCalDepDate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDepDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDepDate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDepDate_year_1_3"));
		year_select.click(); //year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDepDate_month_2_3"));
		month_select.click();  // month=Jan
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ceDepDate_day_0_2"));
		date_select.click();    // day=1
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITChallanEntry Select_Savebtn() throws InterruptedException {
		System.out.println(" Select Save btn");
		click(savebtn);
		return this;
	}
}
