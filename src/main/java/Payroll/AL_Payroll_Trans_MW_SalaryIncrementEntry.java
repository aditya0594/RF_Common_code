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

public class AL_Payroll_Trans_MW_SalaryIncrementEntry extends BaseClass {

	public AL_Payroll_Trans_MW_SalaryIncrementEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "PAYROLL")
	private WebElement PAYROLL;

	@FindBy(linkText = "Transactions")
	private WebElement Transactions;

	@FindBy(linkText = "Monthly Work")
	private WebElement MonthlyWork;

	@FindBy(id = "ctl00_repLinks_ctl11_lbLink")
	private WebElement EmployeeIDCard;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvPayhead_ctrl13_chkID")
	private WebElement EmployeeName;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDt")
	private WebElement ToDate;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlCollege-container")
	private WebElement College;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlIncMonth-container")
	private WebElement IncrementMonth;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlStaff-container")
	private WebElement SchemeStaff;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
	private WebElement SubmitButton;

	@FindBy(className = "select2-search__field")
	private WebElement ddlSearchBox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvIncrement_ctrl0_txtInc")
	private WebElement txtbox;

	//
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Payroll_Trans_MW_SalaryIncrementEntry PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntry Transactions() {
		System.out.println("Admin PAYROLL > Click on Transactions");
		Actions action = new Actions(driver);
		action.moveToElement(Transactions).build().perform();
		// click(Transactions);
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntry MonthlyWork() {
		System.out.println("Admin PAYROLL > Click on MonthlyWork");
		Actions action = new Actions(driver);
		action.moveToElement(MonthlyWork).build().perform();
		click(MonthlyWork);
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntry SalaryIncrementEntry() throws Exception {
		System.out.println("Report > Click On Salary Increment Entry");
		Thread.sleep(2000);
		WebElement SalaryIncrementEntry = driver.findElement(By.id("ctl00_repLinks_ctl08_lbLink"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", SalaryIncrementEntry);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		click(SalaryIncrementEntry);
		// SalaryIncrementEntry.click();
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntry EmployeeName() throws InterruptedException {
		System.out.println("EmployeeName");
		EmployeeName.click();
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntry ToDate() throws InterruptedException {
		System.out.println("Select To Date");
		ToDate.sendKeys("31/03/2022");
		System.out.println("Click on Excel");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_BtnExcel")).click();
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntry College() {
		System.out.println("Crescent School of Architecture");
		College.click();
		ddlSearchBox.sendKeys("School of Electrical and Communication Sciences", Keys.ENTER);
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntry noincrement_txt() throws InterruptedException {
		System.out.println("Crescent School of Architecture");
		sendKeys(txtbox,"N");
		
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
       // WebElement dn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudents_ctrl10_chkSelect"));
        js.executeScript("arguments[0].scrollIntoView();", SubmitButton);
		
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntry IncrementMonth() {
		System.out.println("IncrementMonth");
		IncrementMonth.click();
		ddlSearchBox.sendKeys("JAN", Keys.ENTER);
		return this;

	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntry SchemeStaff() {
		System.out.println("Select Scheme/Staff  > Teaching Staff");
		SchemeStaff.click();
		ddlSearchBox.sendKeys("Teaching Staff", Keys.ENTER);
		return this;

	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntry clickSubmitButton() {
		System.out.println("Click On Submit Button");
		click(SubmitButton);
		return this;
	}

}
