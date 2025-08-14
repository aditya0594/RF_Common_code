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

public class AL_Payroll_Trans_MW_ChangesInMonthlySalaryFile extends BaseClass
{
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public AL_Payroll_Trans_MW_ChangesInMonthlySalaryFile(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlPayhead") private WebElement payhead;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaff") private WebElement staff;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlorderby") private WebElement orderby;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showbtn;
	
	
	public AL_Payroll_Trans_MW_ChangesInMonthlySalaryFile ChangesInMonthlySalaryFile() throws InterruptedException {
		System.out.println("Click on Changes In Monthly Salary File");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement changeinFile = driver.findElement(By.id("ctl00_repLinks_ctl14_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",changeinFile);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", changeinFile);
		return this;
	}
	
	public AL_Payroll_Trans_MW_ChangesInMonthlySalaryFile Select_MonthYear() throws InterruptedException {
		System.out.println("Select Month and Year ==> 01/09/2022");
		
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ImaCalStartDate"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_year_0_3"));
		year_select.click(); //year day = 3
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_month_2_0"));
		month_select.click();
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_day_0_4"));
		date_select.click();
		
		return this;
	}
	
	public AL_Payroll_Trans_MW_ChangesInMonthlySalaryFile Select_PayHead() {
		System.out.println("Select PayHead => BASIC");
		Select select = new Select(payhead);
		select.selectByValue("BASIC");
		return this;
	}
	
	public AL_Payroll_Trans_MW_ChangesInMonthlySalaryFile Select_College() {
		System.out.println("Select College => Crescent Institute");
		Select select = new Select(college);
		select.selectByVisibleText("Crescent Institute");
		return this;
	}
	
	public AL_Payroll_Trans_MW_ChangesInMonthlySalaryFile Select_StaffScheme() {
		System.out.println("Select Staff Scheme => Crescent Institute");
		Select select = new Select(staff);
		select.selectByVisibleText("Technical NTS");
		return this;
	}
	
	public AL_Payroll_Trans_MW_ChangesInMonthlySalaryFile Select_OrderBy() {
		System.out.println("Select Order By => IDNO");
		Select select = new Select(orderby);
		select.selectByVisibleText("IDNO");
		return this;
	}
	
	public AL_Payroll_Trans_MW_ChangesInMonthlySalaryFile Click_Show_btn() {
		System.out.println("Select Show btn");
		click(showbtn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_ChangesInMonthlySalaryFile Click_Submit_btn() throws InterruptedException {
		System.out.println("Select Submit btn");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement submitbtn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		js.executeScript("arguments[0].scrollIntoView();",submitbtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submitbtn);
		
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Do you want to save changes in BASIC->BASIC"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000); 
		alert.accept();
		return this;
	}
}
