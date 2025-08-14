package Payroll;

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

public class AL_Payroll_Trans_MW_BulkSalaryProcess extends BaseClass
{
	@FindBy(linkText = "PAYROLL") private WebElement PAYROLL;
	@FindBy(linkText = "Transactions") private WebElement Transaction;
	@FindBy(linkText = "Monthly Work") private WebElement MonthlyWork;
//	@FindBy(linkText ="Bulk Salary Process") private WebElement bulkSalaryProcces;
//	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtMonthYear']") private WebElement month_year;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlCollege']") private WebElement college_dropdown;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlStaff']") private WebElement staff_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnshow") private WebElement show_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_LstBulkSalaryProcess_ctrl0_chkidno") private WebElement chechBoxClick;
	@FindBy(id = "ctl00_ContentPlaceHolder1_butSalaryProcess") private WebElement proccesSalaryBtn;


	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Payroll_Trans_MW_BulkSalaryProcess(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Trans_MW_BulkSalaryProcess PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkSalaryProcess Transaction() {
		System.out.println("Hower to transaction");
		Actions action =new Actions(driver);
		action.moveToElement(Transaction).build().perform();
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkSalaryProcess monthlyWork() {
		System.out.println("Click on Monthly work");
		Actions action =new Actions(driver);
		action.moveToElement(MonthlyWork).build().perform();
		click(MonthlyWork);
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkSalaryProcess bulk_salary() throws InterruptedException {
		System.out.println("click on Bulk Salary Procees");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement bulkSalaryProcces = driver.findElement(By.id("ctl00_repLinks_ctl22_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",bulkSalaryProcces);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", bulkSalaryProcces);

		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkSalaryProcess month_year() throws InterruptedException{
		System.out.println("Set Month Year");
		Thread.sleep(2000);
	
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMonthYear")), "02/2022");
		

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPDate")),"05/2024");
		
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkSalaryProcess college() {
		System.out.println("Select College");
		Select select= new Select(college_dropdown);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkSalaryProcess Staff() {
		System.out.println("Select Staff");
		Select select= new Select(staff_dropdown);
		select.selectByVisibleText("Admin NTS");
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkSalaryProcess ShowBtn() {
		System.out.println("Click on Show button");
		click(show_btn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkSalaryProcess checkBoxClick() {
		System.out.println("Click check box");
		click(chechBoxClick);
		return this;
	}
	
	public AL_Payroll_Trans_MW_BulkSalaryProcess ProccesSalaryBtn() throws InterruptedException, IOException {
		System.out.println("Proccess Salary Button");
		click(proccesSalaryBtn);
		return this;
	}
	
}