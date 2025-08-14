package Payroll;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Rpt_GrossReports extends BaseClass
{
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public AL_Payroll_Rpt_GrossReports(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	public AL_Payroll_Rpt_GrossReports GrossReports() throws InterruptedException {
		System.out.println("Click Gross Reports ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement gross_rpt = driver.findElement(By.id("ctl00_repLinks_ctl05_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",gross_rpt);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", gross_rpt);
		return this;
	}
	
	public AL_Payroll_Rpt_GrossReports Select_FromDate() throws InterruptedException {
		System.out.println("Select From Date => 04/01/2022");
	
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgFromdt"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_calDate_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_calDate_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_calDate_year_0_3"));
		year_select.click(); //year day = 3
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_calDate_month_0_0"));
		month_select.click();
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_calDate_day_1_2"));
		date_select.click();
		return this;
	}
	
	public AL_Payroll_Rpt_GrossReports Select_ToDate() throws InterruptedException {
		System.out.println("Select To Date => 04/12/2024");
		
		Thread.sleep(2000);
		WebElement MonthYearIcon = driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgTodt"));
		MonthYearIcon.click();
		Thread.sleep(2000);
		WebElement title = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		title.click(); 
		Thread.sleep(2000);
		WebElement year_ttl = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_title"));
		year_ttl.click(); 
		Thread.sleep(2000);
		WebElement year_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_year_1_1"));
		year_select.click(); //year day = 3
		Thread.sleep(2000);
		WebElement month_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_month_2_3"));
		month_select.click();
		Thread.sleep(2000);
		WebElement date_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_day_1_3"));
		date_select.click();
		return this;
	}
	
	public AL_Payroll_Rpt_GrossReports Select_PayHead() {
		System.out.println("Select PayHead => DA");
		WebElement payHead = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlPayHead"));
		Select select = new Select(payHead);
		select.selectByVisibleText("DA");
		return this;
	}
	
	// Gross Excel Report Button
	public AL_Payroll_Rpt_GrossReports Click_GrossExcelReport_btn() {
		System.out.println("Click on Gross Excel Report Button");
		WebElement gross_excel_repo_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnGrossExcelReport"));
		click(gross_excel_repo_btn);
		return this;
	}
	
	// Yearly Head wise Excel Report Button
		public AL_Payroll_Rpt_GrossReports Click_YearlyHeadwiseExcelReport_btn() {
		System.out.println("Click on Yearly Headwise Excel Report Button");
		WebElement yearly_head_rpt=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnYearlyHeadwiseExcelReport"));
		click(yearly_head_rpt);
		return this;
	}
		
		// Employee Yearly Gross Excel Report  Button
		public AL_Payroll_Rpt_GrossReports Click_EmployeeYearlyGrossExcelReport_btn() {
		System.out.println("Click on Employee Yearly Gross Excel Report Button");
		WebElement year_gross_excel_repo_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnEmployeeYrGrossReport"));
		click(year_gross_excel_repo_btn);
		return this;
	}
		
		public AL_Payroll_Rpt_GrossReports Click_DepatmentWiseYearlyGrossSalaryReport_btn() {
			System.out.println("Click on DepatmentWiseYearlyGrossSalaryReport Button");
			WebElement year_gross_excel_repo_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnDepatmentWiseYearlyGrossSalaryReport"));
			click(year_gross_excel_repo_btn);
			return this;
		}
	
public boolean readPDF(String filename,String teststring) throws IOException {
		
	    Path relativePath = Paths.get("C:\\Users\\USER\\Downloads"+filename+".xls");
        String absolutePath = relativePath.toAbsolutePath().toString();

		PDDocument document = PDDocument.load(new File(absolutePath));
		if (!document.isEncrypted()) { 
			PDFTextStripper stripper = new PDFTextStripper(); 
			String text = stripper.getText(document); 
			//System.out.println("Text: " + text);
			//String searchString = teststring; //////// Enrollment No. : 170101601014
			if (text.contains(teststring)) 
			//	System.out.println("Given string is present in the provided pdf: " + teststring);
				return true;
			}
			System.out.println("Given string is not present");  
			fail("Condition check failed.");
			return false;
	}
}
