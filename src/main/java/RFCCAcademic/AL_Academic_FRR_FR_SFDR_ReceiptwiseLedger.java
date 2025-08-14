package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger extends BaseClass
{
	public AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Fees Report") private WebElement feesReport;
	@FindBy(xpath = "(//a[normalize-space()='Selected Field DCR Report'])[1]") private WebElement selectedFieldDCRReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReportSelection") private WebElement reportSelectionDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReceiptType") private WebElement receiptTypeDropdown;
	@FindBy(xpath = "(//span[@class='multiselect-selected-text'][normalize-space()='None selected'])[1]") private WebElement multiSelectField;
	@FindBy(xpath = "(//input[@value='multiselect-all'])[1]") private WebElement selectAllCheckbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate_tab") private WebElement fromDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate_tab") private WebElement toDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowSelected") private WebElement showBtn;

	public AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger Click_FeesReport() throws Exception {
		System.out.println("Click on Fees Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", feesReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", feesReport);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger Click_SelectedFieldDCRReport() throws Exception {
		System.out.println("Click on Selected Field DCR Report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", selectedFieldDCRReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", selectedFieldDCRReport);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger Select_ReportType() throws Exception {
		System.out.println("Select Report Type ==> Receipt wise Ledger");
		Thread.sleep(2000);
		Select select = new Select(reportSelectionDropdown);
		select.selectByVisibleText("Receipt wise Ledger");
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger Select_ReceiptType() throws Exception {
		System.out.println("Select Receipt Type ==> Admission Fee");
		Thread.sleep(2000);
		Select select = new Select(receiptTypeDropdown);
		select.selectByVisibleText("Admission Fee");
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger Click_MultiSelectField() throws Exception {
		System.out.println("Click on Multi-Select Field");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", multiSelectField);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", multiSelectField);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger Click_SelectAllCheckbox() throws Exception {
		System.out.println("Click on Select All Checkbox");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", selectAllCheckbox);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", selectAllCheckbox);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger Enter_FromDate() throws Exception {
		System.out.println("Enter From Date ==> 01/01/2020");
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]", fromDateField, "01/01/2020");
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger Enter_ToDate() throws Exception {
		System.out.println("Enter To Date ==> 01/01/2025");
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]", toDateField, "01/01/2025");
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger Click_ShowButton() throws Exception {
		System.out.println("Click on Show Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", showBtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", showBtn);
		
		return this;
	}
	
	public AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger VerifyText() throws Exception {
		System.out.println("Verifying Receipt wise Ledger Report Generation");
		WebElement stud = driver.findElement(By.xpath("(//td[contains(text(),'Admission Fee')])[1]"));
		
		String Expected_Msg = "Admission Fee"; 
		String Actual_Msg = stud.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		
		return this;
	}
}
