package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utility.BaseClass;

public class AL_Payroll_Trans_MW_MonthlyInstallmentEntry extends BaseClass
{
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlorderby") private WebElement orderby;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlEmployee") private WebElement Employeename;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd") private WebElement addNewBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlPayhead") private WebElement payHead;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtMonthlyDedAmt") private WebElement monthlyDeductedAmmount;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtNoofInstallMent") private WebElement TotalNoInsta;

	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Select_OrderBy() {
		System.out.println(" Select on Order By ==> Name");
		Select select = new Select(orderby);
		select.selectByVisibleText("Name");
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Select_CollegeName() {
		System.out.println(" Select College Name ==> Crescent School of Architecture");
		Select select = new Select(collegname);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Select_EmployeeName() {
		System.out.println(" Select Employee Name ==> AAFREEN  BANU");
		Select select = new Select(Employeename);
		select.selectByValue("776");
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Click_AddNewBtn() {
		System.out.println("Click on Add New Btn");
		click(addNewBtn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Select_PayHead() {
		System.out.println(" Select Employee Name ==> BUS RECO ");
		Select select = new Select(payHead);
		select.selectByValue("D2");
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Enter_MonthlyDeductedAmount() {
		System.out.println(" Enter Monthly Deducted Amount ==> 1200");
		sendKeys(monthlyDeductedAmmount, "1200");
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Enter_TotalNoOfInstallments() {
		System.out.println(" Enter Total No Of Installments==> 12");
		sendKeys(TotalNoInsta, "12");
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Select_Bank() {
		System.out.println(" Select Bank Name ==> Kolhapur[Bun Garden Pune]");
		WebElement bank = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBank"));
		Select select = new Select(bank);
		select.selectByValue("3");
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Select_BankPlace() {
		System.out.println(" Select Bank Place ==> Punee");
		WebElement bank_place = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBankPlace"));
		Select select = new Select(bank_place);
		select.selectByValue("2");
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Enter_AccountNumber() throws InterruptedException {
		System.out.println(" Enter Account Number ==> 321654987123");
		WebElement acc_num = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAccNo"));
		sendKeys(acc_num, "321654987123");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		WebElement down=driver.findElement(By.id("ctl00_ContentPlaceHolder1_butSubmit"));
		js.executeScript("arguments[0].scrollIntoView();", down);
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Set_InstallmentDrawnDate() throws InterruptedException {
		System.out.println("Set  Installment Drawn Date => 06/01/2025");
		WebElement calender_icon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ImgInstallmentDrawnDate"));
		click(calender_icon);
		Thread.sleep(2000);
		WebElement calender_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtInstallmentDrawnDate_title"));
		click(calender_ttl);
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtInstallmentDrawnDate_title"));
		click(year_ttl);
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtInstallmentDrawnDate_year_1_2"));
		click(year_select);
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtInstallmentDrawnDate_month_0_0"));
		click(month_select);
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtInstallmentDrawnDate_day_1_1"));
		click(date_select);
		
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Set_StartDate() throws InterruptedException {
		System.out.println("Set Start Date => 01/01/2025");
		WebElement calender_icon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ImaCalStartDate"));
		click(calender_icon);
		Thread.sleep(2000);
		WebElement calender_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_title"));
		click(calender_ttl);
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_title"));
		click(year_ttl);
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_year_1_2"));
		click(year_select);
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_month_0_0"));
		click(month_select);
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_cetxtStartDate_day_0_3"));
		click(date_select);
		
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Click_Submit_Btn() {
		System.out.println("Click on Submit Btn");
		WebElement submit_btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_butSubmit"));
		click(submit_btn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_MonthlyInstallmentEntry Click_DeleteRecord() throws InterruptedException {
		System.out.println("Click on Delete Record btn");
		WebElement delete_icon = driver.findElement(By.xpath("//input[@alt='Delete Record']"));
		click(delete_icon);
		
		Thread.sleep(2000); 
		WebElement yes = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnOkDel"));
		click(yes);
		return this;
	}
}
