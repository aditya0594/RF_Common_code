package Payroll;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_BD_EmployeeBulkUpdate extends BaseClass
{
	@FindBy(linkText = "PAYROLL") private WebElement PAYROLL;

	@FindBy(linkText = "Transactions") private WebElement Transactions;

	@FindBy(linkText = "Basic Details") private WebElement BasicDetails;

	@FindBy(linkText = "Employee Bulk Update") private WebElement EmployeeBulkUpdate;
	
	
	public AL_Payroll_Trans_BD_EmployeeBulkUpdate(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Trans_BD_EmployeeBulkUpdate PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}

	public AL_Payroll_Trans_BD_EmployeeBulkUpdate Transactions() {
		System.out.println("Admin PAYROLL menu selected > Transactions ");
		Actions action = new Actions(driver);
		action.moveToElement(Transactions).build().perform();
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmployeeBulkUpdate BasicDetails() {
		System.out.println(" Click on Basic Details");
		Actions action = new Actions(driver);
		action.moveToElement(BasicDetails).click().build().perform();
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmployeeBulkUpdate Click_EmployeeBulkUpdate() throws InterruptedException {
		System.out.println(" Click on Employee Bulk Update");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",EmployeeBulkUpdate);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", EmployeeBulkUpdate);
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmployeeBulkUpdate Select_FieldStaff() {
		System.out.println("Select Field Staff => AADHAR CARD NUMBER");
		WebElement field_staff = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlPayhead"));
		Select select = new Select(field_staff);
		select.selectByValue("NUNIQUEID");
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmployeeBulkUpdate Select_College() {
		System.out.println("Select College => Crescent School of Architecture");
		WebElement clg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege"));
		Select select = new Select(clg);
		select.selectByVisibleText("Crescent School of Architecture");	
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmployeeBulkUpdate Select_SChemeStaff() {
		System.out.println("Select Scheme and Staff => Teaching Staff ");
		WebElement stf = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStaff"));
		Select select = new Select(stf);
		select.selectByVisibleText("Teaching Staff");	
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmployeeBulkUpdate Click_CheckBox() {
		System.out.println("Select Check Box ");
		WebElement chkBox = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvMonthlyChanges_ctrl0_ChkPayHead"));
		click(chkBox);
		return this;
	}
	
	public StringBuilder generateRandomMobileNumber() {
		Random random = new Random();
		StringBuilder mobNum1 = new StringBuilder();
		for(int i=0; i<11; i++)
		{
			mobNum1.append(random.nextInt(11));
		}
		
		return mobNum1; 
	}
	
	public AL_Payroll_Trans_BD_EmployeeBulkUpdate Enter_AdharCardNumber() {
		System.out.println("Select Adhar Card Number ");
		
		StringBuilder pros_no;	
		pros_no =generateRandomMobileNumber();
		WebElement adhar = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvMonthlyChanges_ctrl0_txtEditField"));
		System.out.println("Adhar card number is = "+String.valueOf(pros_no));
		clearText(adhar);
		adhar.sendKeys(String.valueOf(pros_no));
		
		return this;
	}
	
	public AL_Payroll_Trans_BD_EmployeeBulkUpdate Click_Submit_btn() throws InterruptedException {
		System.out.println(" Click on Submit btn");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement submitbtn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));

		js.executeScript("arguments[0].scrollIntoView();",submitbtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submitbtn);
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		
		return this;
	}
}
