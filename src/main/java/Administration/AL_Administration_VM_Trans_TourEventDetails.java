package Administration;

import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Administration_VM_Trans_TourEventDetails extends BaseClass
{
	public AL_Administration_VM_Trans_TourEventDetails(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Random number generator for male count
	private Random random = new Random();
	
	// Web elements with provided locators
	@FindBy(linkText = "Tour Event Details") private WebElement tourEventDetailsLink;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlVehicle") private WebElement vehicleDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTourEventDate") private WebElement tourEventDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtOUTTime") private WebElement outTimeField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtOUTkm") private WebElement outKmField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDriver") private WebElement driverDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtINTime") private WebElement inTimeField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtINkm") private WebElement inKmField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtMale") private WebElement maleField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtPlace") private WebElement placeField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtPurpose") private WebElement purposeField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	
	/**
	 * Click on Tour Event Details link
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_TourEventDetails Click_TourEventDetailsLink() throws Exception {
		System.out.println("Click on Tour Event Details link");
		js.executeScript("arguments[0].scrollIntoView();", tourEventDetailsLink);
		js.executeScript("arguments[0].click();", tourEventDetailsLink);
		return this;
	}
	
	/**
	 * Select Vehicle
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_TourEventDetails Select_Vehicle() throws Exception {
		System.out.println("Select Vehicle => TN 11 AF 8382:Bharat Benz");
		Select vehicle = new Select(vehicleDropdown);
		vehicle.selectByVisibleText("TN 11 AF 8382:Bharat Benz");
		return this;
	}
	
	/**
	 * Enter Tour Event Date
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_TourEventDetails Enter_TourEventDate() throws Exception {
		// Get current date in dd/MM/yyyy format
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
		String currentDate = sdf.format(new java.util.Date());
		
		System.out.println("Enter Tour Event Date => " + currentDate);
		js.executeScript("arguments[0].value = arguments[1]", tourEventDateField, currentDate);
		return this;
	}
	
	/**
	 * Enter OUT Time
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_TourEventDetails Enter_OUTTime() throws Exception {
		System.out.println("Enter OUT Time => 08:07 AM");
		js.executeScript("arguments[0].value = arguments[1]", outTimeField, "08:07 AM");
		return this;
	}
	
	/**
	 * Enter OUT KM
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_TourEventDetails Enter_OUTkm() throws Exception {
		System.out.println("Enter OUT KM => 120");
		outKmField.clear();
		outKmField.sendKeys("120");
		driver.findElement(By.xpath("//h3[normalize-space()='VEHICLE TOUR/ EVENT DETAILS']")).click();
		acceptAlert();
		return this;
	}
	
	/**
	 * Select Driver
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_TourEventDetails Select_Driver() throws Exception {
		System.out.println("Select Driver => Amisha patel");
		Select driver = new Select(driverDropdown);
		driver.selectByVisibleText("Amisha patel");
		return this;
	}
	
	/**
	 * Enter IN Time
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_TourEventDetails Enter_INTime() throws Exception {
		System.out.println("Enter IN Time => 04:00 PM");
		js.executeScript("arguments[0].value = arguments[1]", inTimeField, "04:00 PM");
		return this;
	}
	
	/**
	 * Enter IN KM
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_TourEventDetails Enter_INkm() throws Exception {
		System.out.println("Enter IN KM => 300");
		inKmField.clear();
		inKmField.sendKeys("300");
		return this;
	}
	
	/**
	 * Enter Male Count (random number between 1-10)
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_TourEventDetails Enter_MaleCount() throws Exception {
		int maleCount = random.nextInt(10) + 1; // Random number between 1-10
		System.out.println("Enter Male Count => " + maleCount);
		maleField.clear();
		maleField.sendKeys(String.valueOf(maleCount));
		return this;
	}
	
	/**
	 * Enter Place
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_TourEventDetails Enter_Place() throws Exception {
		System.out.println("Enter Place => Nagpur");
		placeField.clear();
		placeField.sendKeys("Nagpur");
		return this;
	}
	
	/**
	 * Enter Purpose
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_TourEventDetails Enter_Purpose() throws Exception {
		System.out.println("Enter Purpose => Industrial visit");
		purposeField.clear();
		purposeField.sendKeys("Industrial visit");
		return this;
	}
	
	/**
	 * Click on Submit Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_TourEventDetails Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
	
	/**
	 * Validate alert message
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_TourEventDetails Validate_AlertMessage() throws Exception {
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "Record Save Successfully.";
		String actualMsg = alert.getText();
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("Actual Message - " + actualMsg + "\n" + "Expected Message - " + expectedMsg);
		alert.accept();
		return this;
	}
}
