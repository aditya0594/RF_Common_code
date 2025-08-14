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

public class AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent extends BaseClass {

	public AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent(WebDriver rdriver) {
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

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddldepartment-container")
	private WebElement Department;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDt")
	private WebElement ToDate;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlCollege-container")
	private WebElement College;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlIncMonth-container")
	private WebElement IncrementMonth;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlStaff-container")
	private WebElement SchemeStaff;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
	private WebElement ShowButton;

	@FindBy(className = "select2-search__field")
	private WebElement ddlSearchBox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvIncrement_ctrl0_txtInc")
	private WebElement incrementflag;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvIncrement_ctrl0_txtIncPer")
	private WebElement incrementpercent;

	//
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent Transactions() {
		System.out.println("Admin PAYROLL > Click on Transactions");
		Actions action = new Actions(driver);
		action.moveToElement(Transactions).build().perform();
		// click(Transactions);
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent MonthlyWork() {
		System.out.println("Admin PAYROLL > Click on MonthlyWork");
		Actions action = new Actions(driver);
		action.moveToElement(MonthlyWork).build().perform();
		click(MonthlyWork);
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent SalaryIncrementEntryWithPercent() throws Exception {
		System.out.println("Report > Click On SalaryIncrementEntryWithPercent");
		Thread.sleep(2000);
		WebElement SalaryIncrementEntryWithPercent = driver.findElement(By.id("ctl00_repLinks_ctl10_lbLink"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", SalaryIncrementEntryWithPercent);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		click(SalaryIncrementEntryWithPercent);
		// SalaryIncrementEntry.click();
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent Department() throws InterruptedException {
		System.out.println("Department");
		Department.click();
		ddlSearchBox.sendKeys("Information Technology", Keys.ENTER);
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent ToDate() throws InterruptedException {
		System.out.println("Select To Date");
		ToDate.sendKeys("31/03/2022");
		System.out.println("Click on Excel");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_BtnExcel")).click();
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent College() {
		System.out.println("Crescent School of Architecture");
		College.click();
		ddlSearchBox.sendKeys("School of Electrical and Communication Sciences", Keys.ENTER);
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent IncrementMonth() {
		System.out.println("IncrementMonth");
		IncrementMonth.click();
		ddlSearchBox.sendKeys("JAN", Keys.ENTER);
		return this;

	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent SchemeStaff() {
		System.out.println("Select Scheme/Staff  > Teaching Staff");
		SchemeStaff.click();
		ddlSearchBox.sendKeys("Teaching Staff", Keys.ENTER);
		return this;

	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent ShowButton() throws InterruptedException {
		System.out.println("Click On Show Report Button");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", ShowButton);

		click(ShowButton);
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent enter_Incrementflag() {
		System.out.println("Enter Increment Flag");
		clearText(incrementflag);
		sendKeys(incrementflag, "Y");
		return this;
	}

	public AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent enter_Incrementpersent() {
		System.out.println("Enter Increment Percent");
		clearText(incrementpercent);
		sendKeys(incrementpercent, "50");
		return this;
	}

}
