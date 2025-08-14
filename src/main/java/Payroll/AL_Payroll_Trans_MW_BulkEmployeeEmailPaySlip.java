package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_MW_BulkEmployeeEmailPaySlip extends BaseClass
{
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public AL_Payroll_Trans_MW_BulkEmployeeEmailPaySlip(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Trans_MW_BulkEmployeeEmailPaySlip BulkEmployeeEmailPaySlip() throws InterruptedException {
		System.out.println("Click on Bulk Employee Email Pay Slip ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement slip = driver.findElement(By.id("ctl00_repLinks_ctl19_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",slip);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", slip);
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkEmployeeEmailPaySlip Select_MonthYear() {
		System.out.println("Select Month and Year => Aug2022");
		WebElement monthyear = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlMonthYear"));
		Select select = new Select(monthyear);
		select.selectByVisibleText("Aug2022");
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkEmployeeEmailPaySlip Select_College() {
		System.out.println("Select College => Crescent Institute");
		WebElement clg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege"));
		Select select = new Select(clg);
		select.selectByVisibleText("Crescent Institute");
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkEmployeeEmailPaySlip Select_SchemeStaff() {
		System.out.println("Select Scheme Staff => Technical NTS");
		WebElement staff = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStaff"));
		Select select = new Select(staff);
		select.selectByVisibleText("Technical NTS");
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkEmployeeEmailPaySlip Select_OrderBy() {
		System.out.println("Select OrderBy => IDNO");
		WebElement orderby = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlorderby"));
		Select select = new Select(orderby);
		select.selectByVisibleText("IDNO");
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkEmployeeEmailPaySlip Click_Show_btn() {
		System.out.println("Click on Show btn ");
		WebElement showbtn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnshow"));
		click(showbtn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkEmployeeEmailPaySlip Click_CheckBox() {
		System.out.println("Click on Check box ");
		WebElement chkbox = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmployeeMonth_ctrl0_chkid"));
		click(chkbox);
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkEmployeeEmailPaySlip Click_SendEmailBtn() {
		System.out.println("Click on Send Email btn ");
		WebElement sendemail = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnsend"));
		click(sendemail);
		return this;
	}
}
