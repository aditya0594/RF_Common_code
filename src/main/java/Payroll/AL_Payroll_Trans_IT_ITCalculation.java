package Payroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_IT_ITCalculation extends BaseClass
{
	public AL_Payroll_Trans_IT_ITCalculation(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl03_lbLink") private WebElement ITCalculation;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaff") private WebElement staff;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rblCalculationBy_1") private WebElement perticulerEmp;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCalculationBy") private WebElement employee;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnCalculate") private WebElement calculatebtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Payroll_Trans_IT_ITCalculation Click_ITCalculation() throws InterruptedException {
		System.out.println(" Click on IT Calculation");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",ITCalculation);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", ITCalculation);
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITCalculation Select_College() {
		System.out.println("Select College ==> Crescent School of Law");
		Select select = new Select(collegname);
		select.selectByVisibleText("Crescent School of Law");
		return this;
	}
	
	public AL_Payroll_Trans_IT_ITCalculation Select_Staff() {
		System.out.println("Select Staff ==> Teaching Staff");
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	

	
	public AL_Payroll_Trans_IT_ITCalculation Click_CalculateIncomeTaxbtn() {
		System.out.println("Click on Calculate Income Tax");
		click(calculatebtn);
		return this;
	}
}
