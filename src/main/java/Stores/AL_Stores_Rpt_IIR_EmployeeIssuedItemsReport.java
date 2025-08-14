package Stores;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Stores_Rpt_IIR_EmployeeIssuedItemsReport extends BaseClass {

	public AL_Stores_Rpt_IIR_EmployeeIssuedItemsReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "ctl00_repLinks_ctl11_lbLink")
	private WebElement IssueItemReport;

	@FindBy(id = "ctl00_ContentPlaceHolder1_rdbIssuedItem")
	private WebElement EmployeeIssuedItemsReport;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDept-container")
	private WebElement DepartmentSelecttab;

	@FindBy(xpath = "//input[@role='textbox']")
	private WebElement DepartmentSearchtab;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlEmpIdno-container")
	private WebElement EmployeeSelecttab;

	@FindBy(xpath = "//input[@role='textbox']")
	private WebElement EmployeeSearchtab;

	public AL_Stores_Rpt_IIR_EmployeeIssuedItemsReport Select_IssueItemReport() {
		System.out.println("Click IssueItemReport");
		IssueItemReport.click();
		return this;
	}

	public AL_Stores_Rpt_IIR_EmployeeIssuedItemsReport Select_EmployeeIssuedItemsReport() {
		System.out.println("Click EmployeeIssuedItemsReport");
		EmployeeIssuedItemsReport.click();
		return this;
	}

	public AL_Stores_Rpt_IIR_EmployeeIssuedItemsReport Select_Department() {
		System.out.println(" Select Department => Mathematics and Actuarial Science");
		DepartmentSelecttab.click();
		DepartmentSearchtab.sendKeys("Mathematics and Actuarial Science");
		DepartmentSearchtab.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Stores_Rpt_IIR_EmployeeIssuedItemsReport Select_EmployeeName() {
		System.out.println(" Select EmployeeName => Mr. SAIBULLA A - [2006031]");
		EmployeeSelecttab.click();
		EmployeeSearchtab.sendKeys("Mr. SAIBULLA A");
		EmployeeSearchtab.sendKeys(Keys.ENTER);
		return this;
	}

}
