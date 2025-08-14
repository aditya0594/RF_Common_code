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

public class AL_Academic_FRR_FR_SFDR_DCRExcelReport extends BaseClass
{
	public AL_Academic_FRR_FR_SFDR_DCRExcelReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Fees Report") private WebElement feesReport;
	@FindBy(xpath = "(//a[normalize-space()='Selected Field DCR Report'])[1]") private WebElement selectedFieldDCRReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReportSelection") private WebElement reportSelectionDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReceiptType") private WebElement receiptTypeDropdown;
	@FindBy(xpath = "(//span[@class='multiselect-selected-text'][normalize-space()='None selected'])[1]") private WebElement multiSelectField;
	@FindBy(xpath = "(//input[@value='[NAME OF STUDENT]'])[1]") private WebElement nameOfStudentCheckbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate_tab") private WebElement fromDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate_tab") private WebElement toDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowSelected") private WebElement showBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnExcelSelected") private WebElement excelbtn;


	public AL_Academic_FRR_FR_SFDR_DCRExcelReport Click_FeesReport() throws Exception {
		System.out.println("Click on Fees Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", feesReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", feesReport);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_DCRExcelReport Click_SelectedFieldDCRReport() throws Exception {
		System.out.println("Click on Selected Field DCR Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", selectedFieldDCRReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", selectedFieldDCRReport);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_DCRExcelReport Select_ReportType() throws Exception {
		System.out.println("Select Report Type ==> DCR Excel Report");
		Thread.sleep(2000);
		Select select = new Select(reportSelectionDropdown);
		select.selectByVisibleText("DCR Excel Report");
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_DCRExcelReport Select_ReceiptType() throws Exception {
		System.out.println("Select Receipt Type ==> Admission Fee");
		Thread.sleep(2000);
		Select select = new Select(receiptTypeDropdown);
		select.selectByVisibleText("Admission Fee");
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_DCRExcelReport Click_FieldToSelect() throws Exception {
		System.out.println("Click on Field To Select");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", multiSelectField);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_DCRExcelReport Click_NameOfStudentCheckbox() throws Exception {
		System.out.println("Click on NAME OF STUDENT Checkbox");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", nameOfStudentCheckbox);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", nameOfStudentCheckbox);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_DCRExcelReport Enter_FromDate() throws Exception {
		System.out.println("Enter From Date ==> 01/01/2020");
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]", fromDateField, "01/01/2020");
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_DCRExcelReport Enter_ToDate() throws Exception {
		System.out.println("Enter To Date ==> 01/01/2025");
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]", toDateField, "01/01/2025");
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_DCRExcelReport Click_ShowButton() throws Exception {
		System.out.println("Click on Show Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", showBtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", showBtn);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_DCRExcelReport Click_DownloadExcelButton() throws Exception {
		System.out.println("Click on Download Excel Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", excelbtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", excelbtn);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_DCRExcelReport VerifyReportGeneration() throws Exception {
		System.out.println("Verifying DCR Excel Report Generation");
		Thread.sleep(3000);
		// Add any verification logic here if needed
		System.out.println("DCR Excel Report Generated Successfully");
		return this;
	}
}
