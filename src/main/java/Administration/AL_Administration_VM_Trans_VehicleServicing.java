package Administration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Administration_VM_Trans_VehicleServicing extends BaseClass
{
	public AL_Administration_VM_Trans_VehicleServicing(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAddNew") private WebElement addNewBtn;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddl-container") private WebElement vehicleSelectTab;
	@FindBy(xpath = "//input[@role='textbox']") private WebElement searchTextbox;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlWorkshp-container") private WebElement workshopSelectTab;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtBillno") private WebElement billNumberField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtItem") private WebElement itemField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtQty") private WebElement quantityField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtItmAmt") private WebElement itemAmountField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAddTo") private WebElement addBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;

	
	public AL_Administration_VM_Trans_VehicleServicing Click_AddNewBtn() throws Exception {
		System.out.println("Click on Add New button");
		js.executeScript("arguments[0].scrollIntoView();", addNewBtn);
		threadWait1();
		js.executeScript("arguments[0].click();", addNewBtn);
		return this;
	}
	
	public AL_Administration_VM_Trans_VehicleServicing Select_Vehicle() throws Exception {
		System.out.println("Select Vehicle => AS1421:Tata Bus");
		vehicleSelectTab.click();
		threadWait1();
		searchTextbox.sendKeys("AS1421:Tata Bus");
		searchTextbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Administration_VM_Trans_VehicleServicing Select_Workshop() throws Exception {
		System.out.println("Select Workshop => CR Cars");
		workshopSelectTab.click();
		threadWait1();
		searchTextbox.sendKeys("CR Cars");
		searchTextbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Administration_VM_Trans_VehicleServicing Enter_BillNumber() throws Exception {
		// Generate random 5 digit number
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String billNo = now.format(formatter);
		
		System.out.println("Enter Bill Number => " + billNo);
		billNumberField.sendKeys(billNo);
		return this;
	}
	
	public AL_Administration_VM_Trans_VehicleServicing Enter_ItemDetails() throws Exception {
		System.out.println("Enter Item => Light");
		js.executeScript("arguments[0].scrollIntoView();", itemField);
		threadWait1();
		itemField.clear();
		itemField.sendKeys("Light");
		return this;
	}
	
	public AL_Administration_VM_Trans_VehicleServicing Enter_Quantity() throws Exception {
		System.out.println("Enter Quantity => 1");
		quantityField.clear();
		quantityField.sendKeys("1");
		return this;
	}
	
	public AL_Administration_VM_Trans_VehicleServicing Enter_ItemAmount() throws Exception {
		System.out.println("Enter Item Amount => 50");
		itemAmountField.clear();
		itemAmountField.sendKeys("50");
		return this;
	}
	
	public AL_Administration_VM_Trans_VehicleServicing Click_AddBtn() throws Exception {
		System.out.println("Click on Add Button");
		js.executeScript("arguments[0].scrollIntoView();", addBtn);
		js.executeScript("arguments[0].click();", addBtn);
		return this;
	}
	
	public AL_Administration_VM_Trans_VehicleServicing Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].scrollIntoView();", submitBtn);
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
}
