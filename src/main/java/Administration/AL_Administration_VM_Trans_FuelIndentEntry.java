package Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Administration_VM_Trans_FuelIndentEntry extends BaseClass{

	public AL_Administration_VM_Trans_FuelIndentEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Fuel & Indent Entry") private WebElement fuelAndIndentEntry_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdblistVehicleType_0") private WebElement fuels_radioBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlIssueType") private WebElement issueType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlItem") private WebElement itemName_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlVehicle") private WebElement vehicle_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFuelDate") private WebElement issueDate_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtCoupNo") private WebElement couponNo_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtQty") private WebElement quantity_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRate") private WebElement rate_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTotalAmount") private WebElement totalAmount_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtMeterReading") private WebElement startMeterReading_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtEndReading") private WebElement endMeterReading_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_button;
	

	public AL_Administration_VM_Trans_FuelIndentEntry click_fuelAndIndentEntry_link() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", fuelAndIndentEntry_link);
		Thread.sleep(1000);
		fuelAndIndentEntry_link.click();
		System.out.println("click on Fuel & Indent Entry  Menu");
		return this;
	}
	public AL_Administration_VM_Trans_FuelIndentEntry click_fuel_radioButton() {
		if(!fuels_radioBtn.isSelected() == true)
			fuels_radioBtn.click();
		System.out.println("Fuel Radio Button Selected");
		return this;
	}
	public AL_Administration_VM_Trans_FuelIndentEntry select_issueType() {
		Select typ_issue = new Select(issueType_dropdown);
		typ_issue.selectByVisibleText("Transport");
		System.out.println("Issue-Type ->Transport ");
		return this;
	}
	public AL_Administration_VM_Trans_FuelIndentEntry select_itemName() {
		Select typ_item = new Select(itemName_dropdown);
		typ_item.selectByVisibleText("Petrol");
		System.out.println("Item Name -> Petrol");
		return this;
	}
	public AL_Administration_VM_Trans_FuelIndentEntry select_vehicle() {
		Select typ_vehicle = new Select(vehicle_dropdown);
		typ_vehicle.selectByVisibleText("MH09AH8978:TATA");
		System.out.println("Vehicle -> MH09AH8978:TATA");
		return this;
	}
	public AL_Administration_VM_Trans_FuelIndentEntry select_issueDate() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",issueDate_inputfield, "22/08/2024");
	    System.out.println("Selected Date is: 22/08/2024");	
		return this;
	}
	public AL_Administration_VM_Trans_FuelIndentEntry enter_couponNo() {
		couponNo_inputfield.clear();
		couponNo_inputfield.sendKeys("0010");
		    System.out.println("Coupon NO-> 0010");
		return this;
	}
	public AL_Administration_VM_Trans_FuelIndentEntry enter_quantity() {
		quantity_dropdown.clear();
		quantity_dropdown.sendKeys("127");
		    System.out.println("Quantity-> 127");
		return this;
	}
	public AL_Administration_VM_Trans_FuelIndentEntry enter_rate() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",rate_dropdown, "1009");    
	    System.out.println("Rate-> 1009");
		return this;
	}
	public AL_Administration_VM_Trans_FuelIndentEntry enter_totalAmount() {
		totalAmount_inputfield.clear();
		totalAmount_inputfield.sendKeys("1401");	   
		    System.out.println("Total Amount -> 1401");
		return this;
	}
	public AL_Administration_VM_Trans_FuelIndentEntry enter_startMeterReading() {
		startMeterReading_dropdown.clear();
		startMeterReading_dropdown.sendKeys("98982");	   
	    System.out.println("Start Meter Reading-> 98982");
		return this;
	}
	public AL_Administration_VM_Trans_FuelIndentEntry enter_endMeterReading() {
		endMeterReading_inputfield.clear();
		endMeterReading_inputfield.sendKeys("98999");	    
		    System.out.println("End meter Reading->98999 ");
		return this;
	}
	public AL_Administration_VM_Trans_FuelIndentEntry click_submit_button() {
		click(submit_button);
		return this;
	}
}
