package Payroll;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_MW_ExcelUploadPayHeads extends BaseClass
{
	JavascriptExecutor js= (JavascriptExecutor)driver;

	@FindBy(id ="ctl00_ContentPlaceHolder1_ddlPayhead") private WebElement payHead;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnUploadExcel") private WebElement uploadbtn;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnDownlaod") private WebElement downloadbtn;

	public AL_Payroll_Trans_MW_ExcelUploadPayHeads(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Trans_MW_ExcelUploadPayHeads ExcelUploadPayHeads() throws InterruptedException {
		System.out.println("Click on Excel Upload Pay Heads ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement excl_uploadPay = driver.findElement(By.id("ctl00_repLinks_ctl04_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",excl_uploadPay);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", excl_uploadPay);
		return this;
	}
	
	public AL_Payroll_Trans_MW_ExcelUploadPayHeads Select_PayHead() {
		System.out.println("Select Pay Head => Crescent School of Architecture");
		Select select = new Select(payHead);
		select.selectByVisibleText("BASIC");
		return this;
	}
	
	public AL_Payroll_Trans_MW_ExcelUploadPayHeads Click_UploadExcelSheet() {
		System.out.println(" Upload Excel Sheet");
		File uploadFile1 = new File(".\\src\\test\\resources\\Excel\\Excel Upload Pay Heads.xlsx");
		WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_flUplaodPayheadExcel"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
		return this;
	}
	
	public AL_Payroll_Trans_MW_ExcelUploadPayHeads Click_Upload_btn() {
		System.out.println("Click on Upload btn");
		click(uploadbtn);
		return this;
	}
	
	public AL_Payroll_Trans_MW_ExcelUploadPayHeads Click_Download_btn() {
		System.out.println("Click on Download btn");
		click(downloadbtn);
		return this;
	}
}
