package Administration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Administration_VM_Trans_RoadTax extends BaseClass
{
	public AL_Administration_VM_Trans_RoadTax(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Road Tax") private WebElement roadTaxLink;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddl-container") private WebElement vehicleSelectTab;
	@FindBy(xpath = "//input[@role='textbox']") private WebElement searchTextbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtValid") private WebElement validForField;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlyear-container") private WebElement yearMonthSelectTab;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFrmDt") private WebElement fromDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDt") private WebElement toDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtAmt") private WebElement amountField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtOtherCharges") private WebElement othercharges;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtReceiptNo") private WebElement receiptNumberField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtPdDt") private WebElement paidDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']") private WebElement searchVehicleField;
	@FindBy(xpath = "//input[@title='Delete Record']") private WebElement deleteIcon;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnOkDel") private WebElement yesBtn;
	
	public AL_Administration_VM_Trans_RoadTax Click_RoadTaxLink() throws Exception {
		System.out.println("Click on Road Tax link");
		js.executeScript("arguments[0].scrollIntoView();", roadTaxLink);
		threadWait1();
		js.executeScript("arguments[0].click();", roadTaxLink);
		return this;
	}
	
	public AL_Administration_VM_Trans_RoadTax Select_Vehicle() throws Exception {
		System.out.println("Select Vehicle => AS1421:Tata Bus");
		vehicleSelectTab.click();
		threadWait1();
		searchTextbox.sendKeys("AS1421:Tata Bus");
		searchTextbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Administration_VM_Trans_RoadTax Enter_ValidFor() throws Exception {
		System.out.println("Enter Valid For => 20");
		validForField.clear();
		validForField.sendKeys("20");
		return this;
	}
	
	public AL_Administration_VM_Trans_RoadTax Select_YearMonth() throws Exception {
		System.out.println("Select Year/Month => Year");
		yearMonthSelectTab.click();
		searchTextbox.sendKeys("Year");
		searchTextbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Administration_VM_Trans_RoadTax Enter_FromDate() throws Exception {
		System.out.println("Enter From Date => 01/01/2025");
		fromDateField.clear();
		fromDateField.sendKeys("01/01/2025");
		return this;
	}
	
	public AL_Administration_VM_Trans_RoadTax Enter_ToDate() throws Exception {
		System.out.println("Enter To Date => 01/08/2025");
		toDateField.clear();
		toDateField.sendKeys("01/08/2025");
		return this;
	}
	
	public AL_Administration_VM_Trans_RoadTax Enter_Amount() throws Exception {
		System.out.println("Enter Amount => 500");
		amountField.clear();
		amountField.sendKeys("500");
		return this;
	}
	
	public AL_Administration_VM_Trans_RoadTax Enter_ReceiptNumber() throws Exception {
		// Generate unique receipt number using timestamp
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String receiptNo = "RCP" + now.format(formatter);
		
		System.out.println("Enter Receipt Number => " + receiptNo);
		receiptNumberField.clear();
		receiptNumberField.sendKeys(receiptNo);
		return this;
	}
	
	public AL_Administration_VM_Trans_RoadTax Enter_PaidDate() throws Exception {
		System.out.println("Enter Paid Date => 01/02/2025");
		paidDateField.clear();
		paidDateField.sendKeys("01/02/2025");
		return this;
	}
	
	public AL_Administration_VM_Trans_RoadTax Enter_OtherCharges() throws Exception {
		System.out.println("Enter Other Charges => 50");
		othercharges.clear();
		othercharges.sendKeys("50");
		return this;
	}
	public AL_Administration_VM_Trans_RoadTax Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].scrollIntoView();", submitBtn);
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
	
	public AL_Administration_VM_Trans_RoadTax Search_Vehicle() throws Exception {
		System.out.println("Search Vehicle => 121:Kia");
		threadWait1();
		searchVehicleField.clear();
		searchVehicleField.sendKeys("AS1421:Tata Bus");
		searchVehicleField.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Administration_VM_Trans_RoadTax Click_DeleteIcon() throws Exception {
		System.out.println("Click on Delete Icon");
		threadWait1();
		js.executeScript("arguments[0].click();", deleteIcon);
		return this;
	}
	
	public AL_Administration_VM_Trans_RoadTax Click_YesBtn() throws Exception {
		System.out.println("Click on Yes button to confirm deletion");
		threadWait1();
		js.executeScript("arguments[0].click();", yesBtn);
		return this;
	}
	
	public String Get_AlertText() throws Exception {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void Accept_Alert() throws Exception {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
}
