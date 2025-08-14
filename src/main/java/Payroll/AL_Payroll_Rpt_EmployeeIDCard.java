package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Payroll_Rpt_EmployeeIDCard extends BaseClass {

	public AL_Payroll_Rpt_EmployeeIDCard(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "PAYROLL")
	private WebElement PAYROLL;

	@FindBy(xpath = "(//a[@class='level2 dynamic'][normalize-space()='Reports'])[3]")
	private WebElement Report;

	@FindBy(id = "ctl00_repLinks_ctl11_lbLink")
	private WebElement EmployeeIDCard;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvPayhead_ctrl0_chkID")
	private WebElement EmployeeName;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDt")
	private WebElement ToDate;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlCollege-container")
	private WebElement College;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlIDCardType-container")
	private WebElement IDCardType;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlStaffName-container")
	private WebElement SchemeStaff;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnBothSide")
	private WebElement ShowButton;

	@FindBy(className = "select2-search__field")
	private WebElement ddlSearchBox;

	//
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Payroll_Rpt_EmployeeIDCard PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}

	public AL_Payroll_Rpt_EmployeeIDCard Report() {
		System.out.println("Admin PAYROLL > Click on Report");
		click(Report);
		return this;
	}

	public AL_Payroll_Rpt_EmployeeIDCard EmployeeIDCard() throws Exception {
		System.out.println("Report > Click On Employee ID Card");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",EmployeeIDCard);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", EmployeeIDCard);
		//EmployeeIDCard.click();
		return this;
	}

	public AL_Payroll_Rpt_EmployeeIDCard EmployeeName() throws InterruptedException {
		System.out.println("Employee Name");
		EmployeeName.click();
		return this;
	}

	public AL_Payroll_Rpt_EmployeeIDCard ToDate() throws InterruptedException {
		System.out.println("Select To Date");
		ToDate.sendKeys("31/03/2022");
		System.out.println("Click on Excel");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_BtnExcel")).click();
		return this;
	}

	public AL_Payroll_Rpt_EmployeeIDCard College() {
		System.out.println("Crescent School of Architecture");
		College.click();
		ddlSearchBox.sendKeys("Crescent School of Architecture", Keys.ENTER);
		System.out.println("Crescent School of Architecture");
		return this;
	}

	public AL_Payroll_Rpt_EmployeeIDCard IDCardType() {
		System.out.println("ID Card Type");
		IDCardType.click();
		ddlSearchBox.sendKeys("IDCardTeaching", Keys.ENTER);
		return this;

	}

	public AL_Payroll_Rpt_EmployeeIDCard SchemeStaff() {
		System.out.println("Select Scheme/Staff  > Teaching Staff"); 
		SchemeStaff.click();
		ddlSearchBox.sendKeys("Teaching Staff", Keys.ENTER);
		return this;

	}

	public AL_Payroll_Rpt_EmployeeIDCard ShowButton() {
		System.out.println("Click On Show Report Button");
		click(ShowButton);
		return this;
	}

}
