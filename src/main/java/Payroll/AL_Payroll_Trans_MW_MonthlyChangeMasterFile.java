package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import AdminEstablishment.ApproveLeaveReject;
import utility.BaseClass;

public class AL_Payroll_Trans_MW_MonthlyChangeMasterFile extends BaseClass{

	public AL_Payroll_Trans_MW_MonthlyChangeMasterFile(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "PAYROLL")
	private WebElement PAYROLL;

	@FindBy(linkText = "Transactions")
	private WebElement Transactions;

	@FindBy(linkText = "Monthly Work")
	private WebElement MonthlyWork;
	
	@FindBy(linkText = "Monthly Changes In Master File")
	private WebElement MonthlyChangesInMasterFile;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlPayhead")
	private WebElement payhead;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege")
	private WebElement College;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaff")
	private WebElement Staff;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlorderby")
	private WebElement OrderBy;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement ShowButton;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvMonthlyChanges_ctrl0_txtDays")
	private WebElement amount;
	
	
	public AL_Payroll_Trans_MW_MonthlyChangeMasterFile editamount() {
		clearText(amount);
		sendKeys(amount,"00");
		return null;
	}
	
	public AL_Payroll_Trans_MW_MonthlyChangeMasterFile reeditamount() {
		clearText(amount);
		sendKeys(amount,"3200");
		return null;
	}
	//
	
	public AL_Payroll_Trans_MW_MonthlyChangeMasterFile PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}

	public AL_Payroll_Trans_MW_MonthlyChangeMasterFile Transactions() {
		System.out.println("Admin PAYROLL menu selected > Transactions ");
		Actions action = new Actions(driver);
		action.moveToElement(Transactions).build().perform();
		return this;
	}

	public AL_Payroll_Trans_MW_MonthlyChangeMasterFile MonthlyWork() {
		System.out.println(" Transactions > Monthly Work");
		Actions action = new Actions(driver);
		action.moveToElement(MonthlyWork).click().build().perform();
		return this;
	}
	public AL_Payroll_Trans_MW_MonthlyChangeMasterFile MonthlyChangesInMasterFile() {
		System.out.println(" Transactions > Monthly Work");
		Actions action = new Actions(driver);
		action.moveToElement(MonthlyChangesInMasterFile).click().build().perform();
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyChangeMasterFile payhead() {
		System.out.println(" Monthly Changes In MasterFile > Select Pay Head");
		Select c = new Select(payhead);
		c.selectByVisibleText("HRA");
		return this;
	}
	public AL_Payroll_Trans_MW_MonthlyChangeMasterFile College() {
		System.out.println("Monthly Changes In MasterFile > Select College");
		Select c1 = new Select(College);
		c1.selectByVisibleText("Crescent Institute");
		return this;
	}
	public AL_Payroll_Trans_MW_MonthlyChangeMasterFile Staff() {
		System.out.println("Monthly Changes In MasterFile > Select Staff");
		Select c1 = new Select(Staff);
		c1.selectByVisibleText("Teaching Staff");
		return this;
	}
	public AL_Payroll_Trans_MW_MonthlyChangeMasterFile OrderBy() {
		System.out.println("Monthly Changes In MasterFile > Select OrderBy");
		Select c1 = new Select(OrderBy);
		c1.selectByVisibleText("IDNO");
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyChangeMasterFile ShowButton() {
		System.out.println("Click On Show Button ");
	    click(ShowButton);
		return this;
	}
	public AL_Payroll_Trans_MW_MonthlyChangeMasterFile SubmitButton() throws InterruptedException {
		System.out.println("Click on Submit");
		WebElement SubmitButton=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", SubmitButton);
		SubmitButton.click();
		return this;
	}
	
	
	//
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
