package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import RFCCAcademic.AL_Academic_AR_IdentityCard;
import utility.BaseClass;

public class AL_Payroll_Trans_MW_SalaryRemark extends BaseClass{

	public AL_Payroll_Trans_MW_SalaryRemark(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	Actions action;

	@FindBy(id = "ctl00_repLinks_ctl13_lbLink")
	private WebElement SalaryRemark_Link;
	
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlMonthYear-container")
	private WebElement MonthAndYear_Dropdown;
	
	@FindBy(className = "select2-search__field")
	private WebElement Searchfield;
	
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlCollege-container")
	private WebElement College_Dropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtMonthRemark")
	private WebElement MonthRemark_Input;
	
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlStaff-container")
	private WebElement SchemeOrStaff_Dropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ShowEmployeesForCommonRemark")
	private WebElement ShowEmpForCommonRemark_Button;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_butSubmit")
	private WebElement Submit_Button;


	public AL_Payroll_Trans_MW_SalaryRemark Click_SalaryRemark_Link() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",SalaryRemark_Link);
		System.out.println("Click on Salary Remark");
		return this;
	}
	
	public AL_Payroll_Trans_MW_SalaryRemark Select_MonthAndYear() {
		MonthAndYear_Dropdown.click();
		System.out.println("Month & Year -> Sep2022");
		Searchfield.sendKeys("Sep2022", Keys.ENTER);
		return this;
	}
	
	public AL_Payroll_Trans_MW_SalaryRemark Select_College() {
		College_Dropdown.click();
		System.out.println("Crescent School of Architecture");
		Searchfield.sendKeys("Crescent School of Architecture",Keys.ENTER);
		return this;
	}
	
	public AL_Payroll_Trans_MW_SalaryRemark Enter_MonthRemark() {
		System.out.println("Month Remark - > Good");
		MonthRemark_Input.sendKeys("Good");
		return this;
	}
	
	public AL_Payroll_Trans_MW_SalaryRemark Select_SchemeOrStaff() {
		SchemeOrStaff_Dropdown.click();
		System.out.println("Scheme/Staff -> Admin NTS");
		Searchfield.sendKeys("Admin NTS", Keys.ENTER);
		return this;
	}
	
	public AL_Payroll_Trans_MW_SalaryRemark Click_ShowEmpForCommonRemark_Button() {
		System.out.println("Click on Button -> Show Employees For Common Remark");
		ShowEmpForCommonRemark_Button.click();
		return this;
	}
	public AL_Payroll_Trans_MW_SalaryRemark Click_Submit_Button() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Submit_Button);
		System.out.println("Click on Submit");
		Submit_Button.click();
		return this;
	}
}
