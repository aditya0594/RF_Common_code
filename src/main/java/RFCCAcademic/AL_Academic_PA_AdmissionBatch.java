package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

/**
 * Class for handling Admission Batch functionality in Academic Portal
 * Provides methods to navigate to admission batch page and create a new batch
 */
public class AL_Academic_PA_AdmissionBatch extends BaseClass {
	
	/**
	 * Constructor to initialize the page elements
	 * @param rdriver WebDriver instance
	 */
	public AL_Academic_PA_AdmissionBatch(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Page Elements
	@FindBy(id = "ctl00_repLinks_ctl00_lbLink")
	private WebElement admissionBatchLink;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ucmaster_txtColumn0")
	private WebElement admissionBatchInputField;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ucmaster_btnSubmit")
	private WebElement submitButton;
	
	// JavaScript executor for scrolling and clicking elements
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	/**
	 * Clicks on Admission Batch link in the menu
	 * @return this object instance for method chaining
	 */
	public AL_Academic_PA_AdmissionBatch Click_AdmissionBatch_Link() throws InterruptedException {
		System.out.println("Clicking on Admission Batch link");
		Thread.sleep(1000);
		
		// Scroll to element to ensure visibility
		js.executeScript("arguments[0].scrollIntoView();", admissionBatchLink);
		
		// Click the element using the BaseClass click method
		click(admissionBatchLink);
		System.out.println("Clicked on Admission Batch from subMenu");
		return this;
	}
	
	/**
	 * Enters admission batch information in the input field
	 * @return this object instance for method chaining
	 */
	public AL_Academic_PA_AdmissionBatch Enter_Admission_Batch() throws InterruptedException {
		System.out.println("Entering Admission Batch information");
		Thread.sleep(1000);
		
		// Clear the field before entering data
		clearText(admissionBatchInputField);
		
		// Use the hardcoded value for the batch
		String batchValue = "2022-2023";
		
		// Enter data using BaseClass sendKeys method
		sendKeys(admissionBatchInputField, batchValue);
		System.out.println("Admission Batch entered: " + batchValue);
		return this;
	}
	
	/**
	 * Clicks the Submit button to create the admission batch
	 * @return this object instance for method chaining
	 */
	public AL_Academic_PA_AdmissionBatch Click_Submit_Button() throws InterruptedException {
		System.out.println("Clicking on Submit button");
		Thread.sleep(1000);
		
		// Use BaseClass click method for better stability
		click(submitButton);
		System.out.println("Submit button clicked successfully");
		return this;
	}
}
