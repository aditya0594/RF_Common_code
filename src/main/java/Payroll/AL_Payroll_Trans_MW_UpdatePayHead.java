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

public class AL_Payroll_Trans_MW_UpdatePayHead extends BaseClass
{
	public AL_Payroll_Trans_MW_UpdatePayHead(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl06_lbLink") private WebElement UpdatePayHead;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaffNo") private WebElement staff;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlEmpName") private WebElement Employeename;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Payroll_Trans_MW_UpdatePayHead Click_UpdatePayHead() throws InterruptedException {
		System.out.println(" Click on Update Pay Head");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",UpdatePayHead);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", UpdatePayHead);
		return this;
	}
	
	public AL_Payroll_Trans_MW_UpdatePayHead Select_Staff() {
		System.out.println("Select Scheme or Staff > Teaching Staff");
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Payroll_Trans_MW_UpdatePayHead Select_EmployeeName() {
		System.out.println("Select Employee Name ==> SHAZIA  JAMAL [2013104]");
		Select select = new Select(Employeename);
		select.selectByValue("6");
		return this;
	}
	
	public AL_Payroll_Trans_MW_UpdatePayHead Enter_EarningHead_Additional() {
		System.out.println("Enter Earning Head Additional ==> 5000");
		WebElement additional = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEarningHeads_ctrl4_txEarningsAmt"));
		clearText(additional);
		sendKeys(additional, "5000");
		return this;
	}
	
	public AL_Payroll_Trans_MW_UpdatePayHead Enter_EarningHead_TA() {
		System.out.println("Enter Earning Head TA ==> 4000");
		WebElement ta = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEarningHeads_ctrl6_txEarningsAmt"));
		clearText(ta);
		sendKeys(ta, "4000");
		return this;
	}
	
	public AL_Payroll_Trans_MW_UpdatePayHead Enter_DeductionHeads_Bus() {
		System.out.println("Enter Deduction Heads Bus ==> 500");
		WebElement bus = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvDeductionHeads_ctrl1_txDeductionAmt"));
		clearText(bus);
		sendKeys(bus, "500");
		return this;
	}
	
	public AL_Payroll_Trans_MW_UpdatePayHead Enter_DeductionHeads_Rent() {
		System.out.println("Enter Deduction Heads Rent ==> 5000");
		WebElement rent = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvDeductionHeads_ctrl8_txDeductionAmt"));
		clearText(rent);
		sendKeys(rent, "5000");
		return this;
	}
	
	public AL_Payroll_Trans_MW_UpdatePayHead Click_Submit_btn() throws InterruptedException {
		System.out.println("Click Submit btn");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_butSubmit"));
		js.executeScript("arguments[0].scrollIntoView();",submit);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submit);
		click(submit);
		return this;
	}
}
