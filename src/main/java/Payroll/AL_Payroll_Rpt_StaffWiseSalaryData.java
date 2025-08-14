package Payroll;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;
import utility.ExcelFileValidator;
import utility.ExcelReader;
import utility.SearchExcelFile;
//import utility.SearchStringInXML;

public class AL_Payroll_Rpt_StaffWiseSalaryData extends BaseClass
{
	@FindBy(linkText = "PAYROLL") private WebElement PAYROLL;
	@FindBy(linkText = "Reports") private WebElement Reports;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public AL_Payroll_Rpt_StaffWiseSalaryData(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Rpt_StaffWiseSalaryData PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_StaffWiseSalaryData Reports() {
		System.out.println("Admin PAYROLL menu selected > Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Reports).click().build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_StaffWiseSalaryData StaffWiseSalarydata() throws InterruptedException {
		System.out.println("Click Staff wise Salary data ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement al_data = driver.findElement(By.id("ctl00_repLinks_ctl13_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",al_data);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", al_data);
		return this;
	}
	
	public AL_Payroll_Rpt_StaffWiseSalaryData Select_month() throws InterruptedException {
		System.out.println("Select Month => Aug2022");
		WebElement month=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlMonthYear"));
		Select select = new Select(month);
		select.selectByVisibleText("Aug2022");
		return this;
	}
	
	public AL_Payroll_Rpt_StaffWiseSalaryData Select_college() throws InterruptedException {
		System.out.println("Select college => Crescent School of Architecture");
		Thread.sleep(4000);
		WebElement college_name=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege1"));
		Select select = new Select(college_name);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Rpt_StaffWiseSalaryData Select_Scheme() throws InterruptedException{
		System.out.println("Select Scheme => Admin NTS");
		WebElement scheme = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStaffNo"));
		Select staf= new Select(scheme);
		staf.selectByVisibleText("Admin NTS");
		return this;
	}
	
	public AL_Payroll_Rpt_StaffWiseSalaryData Select_Staff() throws InterruptedException{
		System.out.println("Select Staff => Teaching Staff");
		WebElement staff = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlEmployeeType"));
		Select staf= new Select(staff);
		staf.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Payroll_Rpt_StaffWiseSalaryData Click_showToExportInToExcelFile_btn() {
		System.out.println("Click=> show To Export In To Excel File button");
		WebElement ex_btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShowAbstractInExcelDeptGroup"));
		click(ex_btn);
	return this;
	} 
}
