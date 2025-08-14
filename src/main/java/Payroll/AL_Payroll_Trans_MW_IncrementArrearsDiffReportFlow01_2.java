package Payroll;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 extends BaseClass
{
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlCollege") private WebElement college;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlArrears") private WebElement arreas;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnTransfer") private WebElement TranferBtn;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlsuplarrear") private WebElement arreas_supply;
	@FindBy(id ="ctl00_ContentPlaceHolder1_txtSuplOrderNo") private WebElement orderNum;
	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlSuplBillHead") private WebElement SuplBillhead;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnSuplSave") private WebElement saveBtn;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnSuplBack") private WebElement BackBtn;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnReport") private WebElement Report_btn;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnDelete") private WebElement delete_btn;
	
	public AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 IncrementArrearsDiffReport() throws InterruptedException {
		System.out.println("Click on Increment Arrears Diff Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement arr_diff_repo = driver.findElement(By.id("ctl00_repLinks_ctl21_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",arr_diff_repo);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", arr_diff_repo);
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 Select_College() {
		System.out.println("Select College Name => Crescent School of Architecture");
		Select select = new Select(college);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 Select_Arreas() {
		System.out.println(" Select Arrears => 15.00% ; January 2025 TO January 2028 ; Teaching Staff");
		Select select = new Select(arreas);
		select.selectByVisibleText("15.00% ; January 2025 TO January 2028 ; Teaching Staff");
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 Click_TransferBtn() {
		System.out.println(" Click on Transfer btn");
		click(TranferBtn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 Select_Arreas_supply() {
		System.out.println(" Select Arrears SUpply=> 15.00% ; January 2025 TO January 2028 ; Teaching Staff");
		Select select = new Select(arreas_supply);
		select.selectByVisibleText("15.00% ; January 2025 TO January 2028 ; Teaching Staff");
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 Enter_OrderNum() {
		System.out.println("Enter Order Num=>1001");
		sendKeys(orderNum, "1001");
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 Set_SuplDate() throws InterruptedException {
		System.out.println("Set Arrears From Date => 01/12/2026");
		
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Image1"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_year_1_3"));
		year_select.click(); 
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_month_2_3"));
		month_select.click();
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_day_0_2"));
		date_select.click();

		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 Select_SuplBillHead() {
		System.out.println("Select Supl Bill Head => DA");
		Select select = new Select(SuplBillhead);
		select.selectByVisibleText("DA");
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 Click_SaveBtn() throws InterruptedException {
		System.out.println("Click on Save Btn");
		click(saveBtn);
		
		Thread.sleep(3000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Transfer to Supl. Bill Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(1000);
		alert.accept();
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 Click_Back_Btn() {
		System.out.println("Click on Back Btn");
		click(BackBtn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 Click_Report_Btn() {
		System.out.println(" Click on Report btn");
		click(Report_btn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_IncrementArrearsDiffReportFlow01_2 Click_Delete_Btn() {
		System.out.println(" Click on Delete btn");
		click(delete_btn);
		return this;
	}
}
