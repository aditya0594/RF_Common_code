package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Rpt_AnnualReport extends BaseClass {

	public AL_Payroll_Rpt_AnnualReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "PAYROLL")
	private WebElement PAYROLL;
	
	@FindBy(xpath = "(//a[@class='level2 dynamic'][normalize-space()='Reports'])[3]")
	private WebElement Report;
	
	@FindBy(linkText = "Annual Report")
	private WebElement AnnualReport;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate")
	private WebElement FromDate;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate")
	private WebElement ToDate;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoAllEmployee")
	private WebElement AllEmployees;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege1")
	private WebElement SelectCollege;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaffNo")
	private WebElement Staff;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowReport")
	private WebElement ShowButton;
	
	//
	JavascriptExecutor js= (JavascriptExecutor)driver;
	public AL_Payroll_Rpt_AnnualReport PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}
	public AL_Payroll_Rpt_AnnualReport Report() {
		System.out.println("Admin PAYROLL > Click on Report");
		click(Report);
		return this;
	}
	public AL_Payroll_Rpt_AnnualReport AnnualReport() throws InterruptedException {
		System.out.println(" Report > Click On Annual Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",AnnualReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", AnnualReport);
		return this;
	}
	public AL_Payroll_Rpt_AnnualReport FromDate() throws InterruptedException {
		System.out.println(" Select From Date");
		FromDate.clear();
		Thread.sleep(3000);
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFromDate")), "01/04/2021");
		return this;
	}
	public AL_Payroll_Rpt_AnnualReport ToDate() throws InterruptedException {
		System.out.println(" Select To Date");
		ToDate.clear();
		Thread.sleep(3000);
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtToDate")), "31/03/2022");
		return this;
	}
	public AL_Payroll_Rpt_AnnualReport AllEmployees() {
		System.out.println("Click On All Employees");
		click(AllEmployees);
		return this;
	}
	public AL_Payroll_Rpt_AnnualReport SelectCollege() {
		System.out.println("Select College  >  Crescent Institute ");
		Select c1 = new Select(SelectCollege);
		c1.selectByVisibleText("Crescent Institute");
		return this;
		
	}
	public AL_Payroll_Rpt_AnnualReport Staff() {
		System.out.println("Select Scheme/Staff  > Teaching Staff");
		Select c1 = new Select(Staff);
		c1.selectByVisibleText("Teaching Staff");
		return this;
		
	}
	public AL_Payroll_Rpt_AnnualReport ShowButton() {
		System.out.println("Click On Show Report Button");
		click(ShowButton);
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
