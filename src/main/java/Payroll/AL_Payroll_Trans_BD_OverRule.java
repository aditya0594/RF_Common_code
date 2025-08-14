package Payroll;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Payroll_Trans_BD_OverRule extends BaseClass
{
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public AL_Payroll_Trans_BD_OverRule(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlEmpName") private WebElement EmpName;
	@FindBy(id ="ctl00_ContentPlaceHolder1_lvEarningHeads_ctrl5_txtEAmount") private WebElement amount;
	@FindBy(id ="ctl00_ContentPlaceHolder1_lvDeductionHeads_ctrl0_txtDAmount") private WebElement BLoan;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlDeptmon") private WebElement dept;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlorderby") private WebElement orderby;
	
	public AL_Payroll_Trans_BD_OverRule OverRule() throws InterruptedException {
		System.out.println("Click on Over Rule ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement overule = driver.findElement(By.id("ctl00_repLinks_ctl05_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",overule);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", overule);
		return this;
	}
	
	public AL_Payroll_Trans_BD_OverRule Select_EmpName() throws InterruptedException {
		System.out.println("Select Emp Name => A R ABDUR RAHMAN RABBANI [2020030]");
		 
		Select select = new Select(EmpName);
		select.selectByVisibleText("A R ABDUR RAHMAN RABBANI [2020030]");
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record already exists,if you want to modify the record then edit the record and click on submit button"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
		return this;
	}
	
	public AL_Payroll_Trans_BD_OverRule Select_FromDate() throws InterruptedException {
		System.out.println("Select From Date => 01/01/2025");
		
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ImaCalFromDate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtFromDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtFromDate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtFromDate_year_1_2"));
		year_select.click(); 
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtFromDate_month_0_0"));
		month_select.click();
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtFromDate_day_0_3"));
		date_select.click();
		return this;
	}
	
	public AL_Payroll_Trans_BD_OverRule Select_ToDate() throws InterruptedException {
		System.out.println("Select To Date => 01/01/2030");
		
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgToDate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtToDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtToDate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtToDate_year_2_3"));
		year_select.click(); //year = 2025
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtToDate_month_0_0"));
		month_select.click();  // month=Jan
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtToDate_day_0_2"));
		date_select.click();    // day=1
		return this;
	}
	
	public AL_Payroll_Trans_BD_OverRule Enter_Amount() {
		System.out.println("Enter Amount");
		clearText(amount);
		sendKeys(amount, "50");
		return this;
	}
	
	public AL_Payroll_Trans_BD_OverRule Enter_BLoanAmount() {
		System.out.println("Enter B Loan amount");
		clearText(BLoan);
		sendKeys(BLoan, "30");
		return this;
	}
	
	public AL_Payroll_Trans_BD_OverRule Remark() throws InterruptedException {
		System.out.println("Click on Remark ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement remark = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtRemark"));
		js.executeScript("arguments[0].scrollIntoView();",remark);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", remark);
		clearText(remark);
		sendKeys(remark, "Automation Test");
		return this;
	}
	
	public AL_Payroll_Trans_BD_OverRule Click_Submit_btn() throws InterruptedException {
		System.out.println("Click on Submit btn ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_butSubmit"));
		js.executeScript("arguments[0].scrollIntoView();",submit);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submit);
		return this;
	}
}
