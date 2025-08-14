package Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Rpt_EmployeePaySlip extends BaseClass {

	
	public AL_Payroll_Rpt_EmployeePaySlip(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "PAYROLL")
	private WebElement PAYROLL;
	
	@FindBy(xpath = "(//a[@class='level2 dynamic'][normalize-space()='Reports'])[3]")
	private WebElement Report;
	
	@FindBy(linkText = "Employee PaySlip")
	private WebElement employeePaySlip;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlMonthYear")
	private WebElement SelectMonthYear;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege1")
	private WebElement SelectCollege;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaffNo1")
	private WebElement SelectStaff;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoAllEmployee")
	private WebElement AllEmployee;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement ShowButton;
	
	
	//
	public AL_Payroll_Rpt_EmployeePaySlip PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}
	public AL_Payroll_Rpt_EmployeePaySlip Report() {
		System.out.println("Admin PAYROLL > Click on Report");
		click(Report);
		return this;
	}
	public AL_Payroll_Rpt_EmployeePaySlip employeePaySlip() {
		System.out.println("Click on Report >  Click On Employee PaySlip");
		click(employeePaySlip);
		return this;
	}
	public AL_Payroll_Rpt_EmployeePaySlip SelectMonthYear() {
		System.out.println("Select Month And Year");
		Select c1 = new Select(SelectMonthYear);
		c1.selectByVisibleText("Aug2022");
		return this;
	}
	public AL_Payroll_Rpt_EmployeePaySlip SelectCollege() {
		System.out.println("Select The College");
		Select c1 = new Select(SelectCollege);
		c1.selectByVisibleText("Crescent Institute");
		return this;
	}
	public AL_Payroll_Rpt_EmployeePaySlip SelectStaff() {
		System.out.println("Select Scheme/Staff");
		Select c1 = new Select(SelectStaff);
		c1.selectByVisibleText("Teaching Staff");
		return this;
	}
	public AL_Payroll_Rpt_EmployeePaySlip AllEmployee() {
		System.out.println("Click on > All Employee");
		click(AllEmployee);
		return this;
	}
	public AL_Payroll_Rpt_EmployeePaySlip ShowButton() {
		System.out.println("Click on >Show Button");
		click(ShowButton);
		return this;
	}
	
	
	//
	
	
}
