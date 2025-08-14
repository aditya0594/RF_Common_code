package Payroll;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_BD_SequenceNumberAllotment extends BaseClass
{
	@FindBy(linkText = "PAYROLL") private WebElement PAYROLL;

	@FindBy(linkText = "Transactions") private WebElement Transactions;

	@FindBy(linkText = "Basic Details") private WebElement BasicDetails;

	@FindBy(id = "ctl00_repLinks_ctl01_lbLink") private WebElement sequene_num;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaff") private WebElement staff_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlEmpType") private WebElement employeeType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddldept") private WebElement department_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlorderby") private WebElement orderby_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSeqNum_ctrl0_txtSqeNo") private WebElement sequenceno_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement submit_button;
	
	
	public AL_Payroll_Trans_BD_SequenceNumberAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Trans_BD_SequenceNumberAllotment PAYROLL() {
		System.out.println("Admin PAYROLL menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(PAYROLL).build().perform();
		return this;
	}

	public AL_Payroll_Trans_BD_SequenceNumberAllotment Transactions() {
		System.out.println("Admin PAYROLL menu selected > Transactions ");
		Actions action = new Actions(driver);
		action.moveToElement(Transactions).build().perform();
		return this;
	}
	
	public AL_Payroll_Trans_BD_SequenceNumberAllotment BasicDetails() {
		System.out.println(" Transactions > Monthly Work");
		Actions action = new Actions(driver);
		action.moveToElement(BasicDetails).click().build().perform();
		return this;
	}
	
	public AL_Payroll_Trans_BD_SequenceNumberAllotment Click_SequenceNumberAllotment() throws InterruptedException {
		System.out.println(" Transactions > Monthly Work");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",sequene_num);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", sequene_num);
		return this;
	}
	
	public AL_Payroll_Trans_BD_SequenceNumberAllotment Select_College() {
		System.out.println("Select College => Crescent School of Architecture");
		Select select = new Select(college_dropdown);
		select.selectByVisibleText("Crescent School of Architecture");	
		return this;
	}
	
	public AL_Payroll_Trans_BD_SequenceNumberAllotment Select_SChemeStaff() {
		System.out.println("Select Scheme and Staff => Admin NTS ");
		Select select = new Select(staff_dropdown);
		select.selectByVisibleText("Admin NTS");	
		return this;
	}
	
	public AL_Payroll_Trans_BD_SequenceNumberAllotment Select_EmployeeType() {
		System.out.println("Select Employee Type => Admin NTS ");
		Select select = new Select(employeeType_dropdown);
		select.selectByVisibleText("Admin NTS");	
		return this;
	}
	
	public AL_Payroll_Trans_BD_SequenceNumberAllotment Select_Department() {
		System.out.println("Select Department => dept Library ");
		Select select = new Select(department_dropdown);
		select.selectByVisibleText("dept Library");	
		return this;
	}
	
	public AL_Payroll_Trans_BD_SequenceNumberAllotment Select_OrderBy() {
		System.out.println("Select Order By ");
		Select select = new Select(orderby_dropdown);
		select.selectByVisibleText("IDNO");	
		return this;
	}
	
	public int generateRandomMobileNumber() {
		Random random = new Random();
		int number = random.nextInt(100);
		return number;
	}
	
	public AL_Payroll_Trans_BD_SequenceNumberAllotment Edit_seq_num(){
		System.out.println("Edit Seq Number");
		
		int prop_num = generateRandomMobileNumber();
		clearText(sequenceno_inputfield);
		sequenceno_inputfield.sendKeys(String.valueOf(prop_num));
		return this;
	}
	
	public AL_Payroll_Trans_BD_SequenceNumberAllotment Click_Submit_btn() {
		System.out.println("Select Submit btn ");
		scrollIntoElement(submit_button);
		click(submit_button);
		return this;
	}
}
