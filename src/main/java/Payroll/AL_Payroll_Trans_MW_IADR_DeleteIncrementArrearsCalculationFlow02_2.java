package Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utility.BaseClass;

public class AL_Payroll_Trans_MW_IADR_DeleteIncrementArrearsCalculationFlow02_2 extends BaseClass
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
	
	public AL_Payroll_Trans_MW_IADR_DeleteIncrementArrearsCalculationFlow02_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Trans_MW_IADR_DeleteIncrementArrearsCalculationFlow02_2 IncrementArrearsDiffReport() throws InterruptedException {
		System.out.println("Click on Increment Arrears Diff Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement arr_diff_repo = driver.findElement(By.id("ctl00_repLinks_ctl21_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",arr_diff_repo);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", arr_diff_repo);
		return this;
	}
	
	public AL_Payroll_Trans_MW_IADR_DeleteIncrementArrearsCalculationFlow02_2 Select_College() {
		System.out.println("Select College Name => Crescent School of Architecture");
		Select select = new Select(college);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Payroll_Trans_MW_IADR_DeleteIncrementArrearsCalculationFlow02_2 Select_Arreas() {
		System.out.println(" Select Arrears => 0.00% ; January 2025 TO January 2028 ; Teaching Staff ");
		Select select = new Select(arreas);
		select.selectByVisibleText("0.00% ; January 2025 TO January 2028 ; Teaching Staff");
		return this;
	}
	
	
	
	public AL_Payroll_Trans_MW_IADR_DeleteIncrementArrearsCalculationFlow02_2 Click_Delete_Btn() {
		System.out.println(" Click on Delete btn");
		click(delete_btn);
		return this;
	}
}
