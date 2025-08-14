package RFCCAcademic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FRR_FR_DCRExcelReport extends BaseClass
{
	public AL_Academic_FRR_FR_DCRExcelReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Fees Report") private WebElement feesReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReport") private WebElement reportDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_TextBox1") private WebElement fromDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_TextBox2") private WebElement toDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlColg") private WebElement collegeDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement degreeDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAdTeacher_ctrl0_chkIDNo") private WebElement selectCheckbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement excelReportBtn;

	public AL_Academic_FRR_FR_DCRExcelReport Click_FeesReport() throws Exception {
		System.out.println("Click on Fees Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", feesReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", feesReport);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_DCRExcelReport Select_ReportType() throws Exception {
		System.out.println("Select Report Type ==> DCR Excel Report");
		Thread.sleep(2000);
		Select select = new Select(reportDropdown);
		select.selectByVisibleText("DCR Excel Report");
		return this;
	}
	
	public AL_Academic_FRR_FR_DCRExcelReport Enter_FromDate() throws Exception {
		System.out.println("Enter From Date ==> 01/01/2020");
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]", fromDateField, "01/01/2020");
		return this;
	}
	
	public AL_Academic_FRR_FR_DCRExcelReport Enter_ToDate() throws Exception {
		System.out.println("Enter To Date ==> 01/01/2022");
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]", toDateField, "01/01/2022");
		return this;
	}
	
	public AL_Academic_FRR_FR_DCRExcelReport Select_College() throws Exception {
		System.out.println("Select College ==> Crescent School of Architecture - Chennai");
		Thread.sleep(2000);
		Select select = new Select(collegeDropdown);
		select.selectByVisibleText("Crescent School of Architecture - Chennai");
		return this;
	}
	
	public AL_Academic_FRR_FR_DCRExcelReport Select_Degree() throws Exception {
		System.out.println("Select Degree ==> Bachelor of Architecture");
		Thread.sleep(2000);
		Select select = new Select(degreeDropdown);
		select.selectByVisibleText("Bachelor of Architecture");
		return this;
	}
	
	public AL_Academic_FRR_FR_DCRExcelReport Click_SelectCheckbox() throws Exception {
		System.out.println("Click on Select Checkbox");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", selectCheckbox);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", selectCheckbox);
		return this;
	}
	
	public AL_Academic_FRR_FR_DCRExcelReport Click_ExcelReportButton() throws Exception {
		System.out.println("Click on Excel Report Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", excelReportBtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", excelReportBtn);
		
		return this;
	}
}
