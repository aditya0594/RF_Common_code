package Administration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Administration_VM_Trans_CreateBusIncharge extends BaseClass
{
	public AL_Administration_VM_Trans_CreateBusIncharge(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Web elements with provided locators
	@FindBy(linkText = "Create Bus Incharge") private WebElement createBusInchargeLink;
	@FindBy(xpath = "(//input[@class='form-control form-control-sm'])[1]") private WebElement searchVehicleField;
	@FindBy(xpath = "//input[@title='Edit Record']") private WebElement editBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	
	/**
	 * Click on Create Bus Incharge link
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_CreateBusIncharge Click_CreateBusInchargeLink() throws Exception {
		System.out.println("Click on Create Bus Incharge link");
		js.executeScript("arguments[0].scrollIntoView();", createBusInchargeLink);
		js.executeScript("arguments[0].click();", createBusInchargeLink);
		return this;
	}
	
	/**
	 * Search for vehicle name
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_CreateBusIncharge Search_VehicleName() throws Exception {
		System.out.println("Search Vehicle Name => Bharat ABDUR");
		searchVehicleField.clear();
		searchVehicleField.sendKeys("Bharat ABDUR");
		return this;
	}
	
	/**
	 * Click on Edit Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_CreateBusIncharge Click_EditBtn() throws Exception {
		System.out.println("Click on Edit Button");
		js.executeScript("arguments[0].click();", editBtn);
		return this;
	}
	
	/**
	 * Click on Submit Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_CreateBusIncharge Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
}
