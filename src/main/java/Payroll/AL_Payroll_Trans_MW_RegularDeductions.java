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

public class AL_Payroll_Trans_MW_RegularDeductions extends BaseClass
{
	public AL_Payroll_Trans_MW_RegularDeductions(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl01_lbLink") private WebElement RegularDeductions;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlorderby") private WebElement orderby;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlEmployee") private WebElement Employeename;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd") private WebElement addNewBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlPayhead") private WebElement payHead;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtMonthlyDedAmt") private WebElement monthlyDeductedAmmount;

	
	public AL_Payroll_Trans_MW_RegularDeductions Click_RegularDeductions() {
		System.out.println("Click on Regular Deductions");
		Actions action = new Actions(driver);
		action.moveToElement(RegularDeductions).click().build().perform();
		return this;
	}
	
	public AL_Payroll_Trans_MW_RegularDeductions Select_OrderBy() {
		System.out.println(" Select on Order By ==> Name");
		Select select = new Select(orderby);
		select.selectByVisibleText("Name");
		return this;
	}
	
	public AL_Payroll_Trans_MW_RegularDeductions Select_CollegeName() {
		System.out.println(" Select College Name ==> Crescent School of Architecture");
		Select select = new Select(collegname);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Trans_MW_RegularDeductions Select_EmployeeName() {
		System.out.println(" Select Employee Name ==> AAFREEN  BANU");
		Select select = new Select(Employeename);
		select.selectByValue("776");
		return this;
	}
	
	public AL_Payroll_Trans_MW_RegularDeductions Click_AddNewBtn() {
		System.out.println("Click on Add New Btn");
		click(addNewBtn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_RegularDeductions Select_PayHead() {
		System.out.println(" Select Employee Name ==> BUS RECO ");
		Select select = new Select(payHead);
		select.selectByValue("D2");
		return this;
	}
	
	public AL_Payroll_Trans_MW_RegularDeductions Enter_MonthlyDeductedAmount() {
		System.out.println(" Enter Monthly Deducted Amount ==> 10");
		sendKeys(monthlyDeductedAmmount, "10");
		return this;
	}
	
	public AL_Payroll_Trans_MW_RegularDeductions Select_Bank() {
		System.out.println(" Select Bank Name ==> Kolhapur[Bun Garden Pune]");
		WebElement bank = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBank"));
		Select select = new Select(bank);
		select.selectByValue("3");
		return this;
	}
	
	public AL_Payroll_Trans_MW_RegularDeductions Select_BankPlace() {
		System.out.println(" Select Bank Place ==> Punee");
		WebElement bank_place = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBankPlace"));
		Select select = new Select(bank_place);
		select.selectByValue("2");
		return this;
	}
	
	public AL_Payroll_Trans_MW_RegularDeductions Enter_AccountNumber() throws InterruptedException {
		System.out.println(" Enter Account Number ==> 321654987123");
		WebElement acc_num = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAccNo"));
		sendKeys(acc_num, "321654987123");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		WebElement down=driver.findElement(By.id("ctl00_ContentPlaceHolder1_butSubmit"));
		js.executeScript("arguments[0].scrollIntoView();", down);
		return this;
	}
	
	public AL_Payroll_Trans_MW_RegularDeductions Click_Submit_Btn() {
		System.out.println("Click on Submit Btn");
		WebElement submit_btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_butSubmit"));
		click(submit_btn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_RegularDeductions Click_Save_Btn() throws InterruptedException {
		System.out.println("Click on Save Btn");
//		WebElement save_btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnBulkSave"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		WebElement save_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnBulkSave"));
		js.executeScript("arguments[0].scrollIntoView();", save_btn);
		Thread.sleep(2000);
		click(save_btn);
		return this;
	}
}
