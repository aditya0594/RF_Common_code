package Administration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Administration_VM_Trans_BusStructureMapping extends BaseClass
{
	public AL_Administration_VM_Trans_BusStructureMapping(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Web elements with provided locators
	@FindBy(linkText = "Bus Structure Mapping") private WebElement busStructureMappingLink;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlRoute") private WebElement routeContainer;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlbusStructure") private WebElement busStructureDropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSession-container") private WebElement sessionContainer;
	@FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_btnShowBusStr'])[1]") private WebElement showBusBookingBtn;
	@FindBy(xpath = "//div[@class='table-responsive']//tbody//input") private WebElement checkBox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStatus") private WebElement statusContainer;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnPaymentReport") private WebElement paymentReportBtn;
	
	/**
	 * Click on Bus Structure Mapping link
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusStructureMapping Click_BusStructureMappingLink() throws Exception {
		System.out.println("Click on Bus Structure Mapping link");
		js.executeScript("arguments[0].scrollIntoView();", busStructureMappingLink);
		js.executeScript("arguments[0].click();", busStructureMappingLink);
		return this;
	}
	
	/**
	 * Click and select Route
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusStructureMapping Select_Route() throws Exception {
		System.out.println("Click and select Route => Main Office To MIhan");
		Select select= new Select(routeContainer);
		select.selectByVisibleText("Main Office To MIhan");
		return this;
	}
	
	/**
	 * Select Bus Structure (Sitting Capacity)
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusStructureMapping Select_BusStructure() throws Exception {
		System.out.println("Select Bus Structure => 40 Seating Bus");
		Select select = new Select(busStructureDropdown);
		select.selectByVisibleText("40 Seating Bus");
		return this;
	}
	
	/**
	 * Click and select Session
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusStructureMapping Select_Session() throws Exception {
		System.out.println("Click and select Session => 2023-2024");
		Select select= new Select(session);
		select.selectByVisibleText("2023-2024");
		return this;
	}
	
	/**
	 * Click on Show Bus Booking Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusStructureMapping Click_ShowBusBookingBtn() throws Exception {
		System.out.println("Click on Show Bus Booking Button");
		js.executeScript("arguments[0].click();", showBusBookingBtn);
		return this;
	}
	
	/**
	 * Click on Check Box
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusStructureMapping Click_CheckBox() throws Exception {
		System.out.println("Click on Check Box");
		js.executeScript("arguments[0].click();", checkBox);
		return this;
	}
	
	/**
	 * Click and select Status
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusStructureMapping Select_Status() throws Exception {
		System.out.println("Click and select Status => Boys");
		Select select= new Select(statusContainer);
		select.selectByVisibleText("Boys");
		return this;
	}
	
	/**
	 * Click on Submit Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusStructureMapping Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
	
	/**
	 * Click on Payment Report Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_BusStructureMapping Click_PaymentReportBtn() throws Exception {
		System.out.println("Click on Payment Report Button");
		js.executeScript("arguments[0].click();", paymentReportBtn);
		return this;
	}
}
