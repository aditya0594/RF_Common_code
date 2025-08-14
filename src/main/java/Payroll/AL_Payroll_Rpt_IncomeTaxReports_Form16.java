package Payroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Rpt_IncomeTaxReports_Form16 extends BaseClass
{
	public AL_Payroll_Rpt_IncomeTaxReports_Form16(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl09_lbLink") private WebElement IncomTax;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaff") private WebElement staff;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlEmp") private WebElement employee;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowTax") private WebElement showtaxbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnTaxColumns") private WebElement taxcolumnbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnForm16") private WebElement form16btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnForm16partB") private WebElement form16Bbtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Payroll_Rpt_IncomeTaxReports_Form16 Click_IncomeTaxReports() throws InterruptedException {
		System.out.println(" Click on Income Tax Reports");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",IncomTax);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", IncomTax);
		return this;
	}
	
	public AL_Payroll_Rpt_IncomeTaxReports_Form16 Select_College() {
		System.out.println("Select College ==> Crescent School of Law");
		Select select = new Select(collegname);
		select.selectByVisibleText("Crescent School of Law");
		return this;
	}
	
	public AL_Payroll_Rpt_IncomeTaxReports_Form16 Select_Staff() {
		System.out.println("Select Staff ==> Teaching Staff");
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Payroll_Rpt_IncomeTaxReports_Form16 Select_Employee() {
		System.out.println("Select Employee ==> NAZNEEN  M.Y[27]");
		Select select = new Select(employee);
		select.selectByValue("27");
		return this;
	}
	
	public AL_Payroll_Rpt_IncomeTaxReports_Form16 Click_SHowTaxbtn() {
		System.out.println("Click on ShowTax btn");
		click(showtaxbtn);
		return this;
	}
	
	
	public AL_Payroll_Rpt_IncomeTaxReports_Form16 Click_Form16Btn() {
		System.out.println("Click on Form 16 btn");
		click(form16btn);
		return this;
	}
}
