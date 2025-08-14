package RFCCAcademic;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

/**
 * Class for handling Upload Fitness Certificate functionality in Student Portal
 * Provides methods to navigate to fitness certificate upload page and perform upload operations
 */
public class SL_Academic_SR_UploadFitnessCertificate extends BaseClass {
	
	/**
	 * Constructor to initialize the page elements
	 * @param rdriver WebDriver instance
	 */
	public SL_Academic_SR_UploadFitnessCertificate(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Page Elements
	@FindBy(id = "ctl00_repLinks_ctl02_lbLink")
	private WebElement uploadFitnessCertificateLink;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_FileUpload1")
	private WebElement uploadFitnessCertificateInput;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnsubmit")
	private WebElement uploadButton;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnpreview")
	private WebElement previewButton;
	
	// JavaScript executor for scrolling and clicking elements
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	/**
	 * Clicks on Upload Fitness Certificate link
	 * @return this object instance for method chaining
	 */
	public SL_Academic_SR_UploadFitnessCertificate Click_Upload_Fitness_Certificate_Link() throws InterruptedException {
		System.out.println("Click on Upload Fitness Certificate Link");
		Thread.sleep(2000);
		
		// Scroll to element to ensure visibility
		js.executeScript("arguments[0].scrollIntoView();", uploadFitnessCertificateLink);
		
		// Click the element using the BaseClass click method
		click(uploadFitnessCertificateLink);
		return this;
	}

	/**
	 * Uploads fitness certificate document 
	 * @return this object instance for method chaining
	 */
	public SL_Academic_SR_UploadFitnessCertificate Upload_Fitness_Certificate() throws InterruptedException {
		System.out.println("Uploading Fitness Certificate document");
		// Hardcoded file path as per the pattern
		File uploadFile = new File(".\\src\\test\\resources\\documentsForTesting\\physical-fitness-certificate-model.jpg");
		
		// Verify file exists
		if (!uploadFile.exists()) {
			System.out.println("WARNING: Certificate file not found at: " + uploadFile.getAbsolutePath());
		}
		
		// Upload file
		Thread.sleep(1000);
		sendKeys(uploadFitnessCertificateInput, uploadFile.getAbsolutePath());
		System.out.println("Fitness Certificate file selected");
		return this;
	}
	
	/**
	 * Clicks the Upload button to submit the fitness certificate
	 * @return this object instance for method chaining
	 */
	public SL_Academic_SR_UploadFitnessCertificate Click_Upload_Button() throws InterruptedException {
		System.out.println("Clicking on Upload button");
		Thread.sleep(2000);
		
		// Use BaseClass click method for better stability
		click(uploadButton);
		System.out.println("Upload button clicked successfully");
		return this;
	}
	
	/**
	 * Clicks the Preview button to view the uploaded certificate
	 * @return this object instance for method chaining
	 */
	public SL_Academic_SR_UploadFitnessCertificate Click_Preview_Button() throws InterruptedException {
		System.out.println("Clicking on Preview button");
		Thread.sleep(1000);
		click(previewButton);
		System.out.println("Preview button clicked successfully");
		return this;
	}
}
