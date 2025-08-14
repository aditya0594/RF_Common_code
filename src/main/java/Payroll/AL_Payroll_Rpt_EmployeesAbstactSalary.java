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

public class AL_Payroll_Rpt_EmployeesAbstactSalary extends BaseClass
{
	@FindBy(linkText = "PAYROLL") private WebElement PAYROLL;
	@FindBy(linkText = "Reports") private WebElement Reports;
	@FindBy(linkText = "Employee Abstract Salary") private WebElement Emp_Absta_salary;
	@FindBy(xpath="//input[@class='select2-search__field']") private WebElement month;
	@FindBy(id="ctl00_ContentPlaceHolder1_chkAbstractSummary") private WebElement checkBoxAbs_summary;

	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Payroll_Rpt_EmployeesAbstactSalary(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Rpt_EmployeesAbstactSalary PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_EmployeesAbstactSalary Reports() {
		System.out.println("Admin PAYROLL menu selected > Reports ");
		Actions action = new Actions(driver);
		action.moveToElement(Reports).click().build().perform();
		return this;
	}

	public AL_Payroll_Rpt_EmployeesAbstactSalary Emp_abstact_salary() {
		System.out.println(" Click On > Employee Abstact Salary");
		Actions action = new Actions(driver);
		action.moveToElement(Emp_Absta_salary).click().build().perform();
		return this;
	}
	
	public AL_Payroll_Rpt_EmployeesAbstactSalary month() throws InterruptedException {
		System.out.println("Select Month");
		WebElement month=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlMonthYear']"));
		Select select = new Select(month);
		select.selectByVisibleText("Aug2022");
		return this;
	}
	

	public AL_Payroll_Rpt_EmployeesAbstactSalary college() throws InterruptedException {
		System.out.println("Select college");
		Thread.sleep(4000);
		WebElement college_name=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlCollege1']"));
		Select select = new Select(college_name);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Rpt_EmployeesAbstactSalary Staff() throws InterruptedException{
		System.out.println("Select staff");
		WebElement staff = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStaffNo1"));
		Select staf= new Select(staff);
		staf.selectByVisibleText("Admin NTS");
		return this;
	}
	
	public AL_Payroll_Rpt_EmployeesAbstactSalary Click_SalaryRegisterWithAbst_btn() throws IOException, InterruptedException {
		System.out.println("Click=> Salary Register with Abstract button");
		WebElement repo = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSalaryRegRCPIT"));
		click(repo);
		driver.manage().window().maximize();
		Thread.sleep(2000);	
		return this;
	}
	
	public AL_Payroll_Rpt_EmployeesAbstactSalary Click_SalaryRegisterDepartmentWise_btn() throws IOException, InterruptedException {
		System.out.println("Click=> Salary Register Department Wise btn");
		WebElement repo = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnRegisterWithDept"));
		click(repo);
		driver.manage().window().maximize();
		Thread.sleep(2000);	
		return this;
	}

}
