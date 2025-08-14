package Administration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Administration_VM_Trans_IncidentRegister extends BaseClass
{
	public AL_Administration_VM_Trans_IncidentRegister(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Web elements with provided locators
	@FindBy(linkText = "Incident Register") private WebElement incidentRegisterLink;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtrouteno") private WebElement routeNoField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtinsdate") private WebElement dateSectionField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ceePdDt_today") private WebElement currentDateBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtincidenttime") private WebElement incidentTimeField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtfollwup") private WebElement followUpField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtNatureinc") private WebElement natureOfIncidentField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtincidentplace") private WebElement incidentPlaceField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtformdate") private WebElement fromDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txttodate") private WebElement toDateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowReport") private WebElement showreportbtn;

	/**
	 * Click on Incident Register link
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_IncidentRegister Click_IncidentRegisterLink() throws Exception {
		System.out.println("Click on Incident Register link");
		js.executeScript("arguments[0].scrollIntoView();", incidentRegisterLink);
		js.executeScript("arguments[0].click();", incidentRegisterLink);
		return this;
	}
	
	/**
	 * Enter Route Number
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_IncidentRegister Enter_RouteNo() throws Exception {
		System.out.println("Enter Route Number => 04");
		routeNoField.clear();
		routeNoField.sendKeys("04");
		return this;
	}

	public AL_Administration_VM_Trans_IncidentRegister Click_CurrentDate() throws Exception {
		// Get current date in dd/MM/yyyy format
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
		String currentDate = sdf.format(new java.util.Date());
		
		System.out.println("Setting Current Date: " + currentDate);
		
		// Set date value directly using JavaScript executor instead of clicking
		js.executeScript("arguments[0].value = arguments[1]", dateSectionField, currentDate);
		return this;
	}
	
	/**
	 * Enter Incident Time
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_IncidentRegister Enter_IncidentTime() throws Exception {
		System.out.println("Enter Incident Time => 07:01 AM");
		js.executeScript("arguments[0].value = arguments[1]", incidentTimeField, "07:01 AM");
		return this;
	}
	
	/**
	 * Enter Follow Up
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_IncidentRegister Enter_FollowUp() throws Exception {
		System.out.println("Enter Follow Up => Jayesh");
		js.executeScript("arguments[0].value = arguments[1]",followUpField, "Jayesh");
	
		return this;
	}
	
	/**
	 * Enter Nature of Incident
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_IncidentRegister Enter_NatureOfIncident() throws Exception {
		System.out.println("Enter Nature of Incident => Tyre puncture");
		js.executeScript("arguments[0].value = arguments[1]",natureOfIncidentField, "Tyre puncture");
		return this;
	}
	
	/**
	 * Enter Incident Place
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_IncidentRegister Enter_IncidentPlace() throws Exception {
		System.out.println("Enter Incident Place => Nagpur");
		js.executeScript("arguments[0].value = arguments[1]",incidentPlaceField, "Nagpur");
		return this;
	}
	
	/**
	 * Click on Submit Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_IncidentRegister Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
	
	/**
	 * Validate alert message
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_IncidentRegister Validate_AlertMessage() throws Exception {
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "Record saved successfully.";
		String actualMsg = alert.getText();
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("Actual Message - " + actualMsg + "\n" + "Expected Message - " + expectedMsg);
		alert.accept();
		return this;
	}
	
	/**
	 * Click on Report Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_IncidentRegister Click_ReportBtn() throws Exception {
		System.out.println("Click on Report Button");
		js.executeScript("arguments[0].click();", reportBtn);
		return this;
	}
	
	/**
	 * Enter From Date for report
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_IncidentRegister Enter_FromDate() throws Exception {
		System.out.println("Enter From Date => 01/01/2023");
		js.executeScript("arguments[0].value = arguments[1]", fromDateField, "01/01/2023");
		return this;
	}
	
	/**
	 * Enter To Date for report
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_IncidentRegister Enter_ToDate() throws Exception {
		System.out.println("Enter To Date => 01/01/2027");
		js.executeScript("arguments[0].value = arguments[1]", toDateField, "01/01/2027");
		return this;
	}
	
	public AL_Administration_VM_Trans_IncidentRegister Click_ShowReportBtn() throws Exception {
		System.out.println("Click on Show Report Button");
		js.executeScript("arguments[0].click();", showreportbtn);
		return this;
	}
}
