package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_MW_AttendanceEntry extends BaseClass {

	public AL_Payroll_Trans_MW_AttendanceEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "PAYROLL")
	private WebElement PAYROLL;

	@FindBy(linkText = "Transactions")
	private WebElement Transactions;

	@FindBy(linkText = "Monthly Work")
	private WebElement MonthlyWork;

	@FindBy(linkText = "Attendance Entry")
	private WebElement AttendaneEntry;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege")
	private WebElement SelectCollege;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaff")
	private WebElement SelectStaff;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement showbtn;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAttendance_ctrl0_txtDays")
	private WebElement Attendance1;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAttendance_ctrl1_txtDays")
	private WebElement Attendance2;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAttendance_ctrl2_txtDays")
	private WebElement Attendance3;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAttendance_ctrl3_txtDays")
	private WebElement Attendance4;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAttendance_ctrl4_txtDays")
	private WebElement Attendance5;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
	private WebElement SubmitButton;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	//
	public AL_Payroll_Trans_MW_AttendanceEntry PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntry Transactions() {
		System.out.println("Admin PAYROLL menu selected > Transactions ");
		Actions action = new Actions(driver);
		action.moveToElement(Transactions).build().perform();
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntry MonthlyWork() {
		System.out.println(" Transactions > Monthly Work");
		Actions action = new Actions(driver);
		action.moveToElement(MonthlyWork).click().build().perform();
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntry AttendaneEntry() throws InterruptedException {
		System.out.println(" Monthly Work > Attendane Entry");
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();",AttendaneEntry);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", AttendaneEntry);
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntry SelectCollege() {
		System.out.println(" Monthly Work > Attendane Entry > Select College");
		Select c = new Select(SelectCollege);
		c.selectByVisibleText("Crescent Institute");
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntry SelectStaff() {
		System.out.println("Select Scheme or Staff > Teaching Staff");
		Select c1 = new Select(SelectStaff);
		c1.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Payroll_Trans_MW_AttendanceEntry Click_ShowBtn() {
		System.out.println("Click on Show btn");
		click(showbtn);
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntry Attendance1() {
		System.out.println("Attendance > 1");
		js.executeScript("arguments[0].scrollIntoView();",showbtn);
		Attendance1.clear();
		Attendance1.sendKeys("1");
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntry Attendance2() {
		System.out.println("Attendance > 1");
		Attendance2.clear();
		Attendance2.sendKeys("1");
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntry Attendance3() {
		System.out.println("Attendance > 1");
		Attendance3.clear();
		Attendance3.sendKeys("1");
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntry Attendance4() {
		System.out.println("Attendance > 1");
		Attendance4.clear();
		Attendance4.sendKeys("1");
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntry Attendance5() {
		System.out.println("Attendance > 1");
		Attendance5.clear();
		Attendance5.sendKeys("1");
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntry SubmitButton() throws InterruptedException {
		System.out.println("Click On Submit Button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", SubmitButton);
		click(SubmitButton);
		return this;
	}

}
