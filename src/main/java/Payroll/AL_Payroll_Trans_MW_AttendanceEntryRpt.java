package Payroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_MW_AttendanceEntryRpt extends BaseClass
{
	public AL_Payroll_Trans_MW_AttendanceEntryRpt(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Monthly Work")
	private WebElement MonthlyWork;

	@FindBy(linkText = "Attendance Entry")
	private WebElement AttendaneEntry;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege")
	private WebElement SelectCollege;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaff")
	private WebElement SelectStaff;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnDownlaod")
	private WebElement downloadbtn;

	

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Payroll_Trans_MW_AttendanceEntryRpt MonthlyWork() {
		System.out.println(" Transactions > Monthly Work");
		Actions action = new Actions(driver);
		action.moveToElement(MonthlyWork).click().build().perform();
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntryRpt AttendaneEntry() throws InterruptedException {
		System.out.println(" Monthly Work > Attendane Entry");
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();",AttendaneEntry);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", AttendaneEntry);
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntryRpt SelectCollege() {
		System.out.println(" Monthly Work > Attendane Entry > Select College");
		Select c = new Select(SelectCollege);
		c.selectByVisibleText("Crescent Institute");
		return this;
	}

	public AL_Payroll_Trans_MW_AttendanceEntryRpt SelectStaff() {
		System.out.println("Select Scheme or Staff > Teaching Staff");
		Select c1 = new Select(SelectStaff);
		c1.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Payroll_Trans_MW_AttendanceEntryRpt Click_DownloadBtn() {
		System.out.println("Click on Download Btn");
		click(downloadbtn);
		return this;
	}
	
}
