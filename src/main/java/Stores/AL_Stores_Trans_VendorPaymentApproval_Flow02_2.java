package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;
import utility.TestDataSharing;

public class AL_Stores_Trans_VendorPaymentApproval_Flow02_2 extends BaseClass
{

	public AL_Stores_Trans_VendorPaymentApproval_Flow02_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Vendor Payment Approval") private WebElement vendorPaymentApprovalLink;
	@FindBy(xpath = "//input[@class='btn btn-primary']") private WebElement selectButton;
	@FindBy(xpath = "(//input[@class='form-control form-control-sm'])[1]") private WebElement searchbar;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvVendorPay_ctrl0_txtPayNowAmt") private WebElement payNowAmountField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdlApprove_0") private WebElement acceptRadioButton;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnApprove") private WebElement submitButton;

	public AL_Stores_Trans_VendorPaymentApproval_Flow02_2 Click_VendorPaymentApproval() throws Exception {
		System.out.println("Click on Vendor Payment Approval");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", vendorPaymentApprovalLink);

		threadWait1();
		js.executeScript("arguments[0].click();", vendorPaymentApprovalLink);
		
		return this;
	}
	
	public AL_Stores_Trans_VendorPaymentApproval_Flow02_2 Click_SearchBar() throws Exception {
		// Get the VP Number from shared test data
		String vpNumber = TestDataSharing.retrieveData("VendorPaymentNumber");
		
		// Always use the VP Number for searching
		System.out.println("Searching for VP Number: " + vpNumber);
		sendKeys(searchbar, vpNumber);
		
		return this;
	}
	

	public AL_Stores_Trans_VendorPaymentApproval_Flow02_2 Click_SelectButton() throws Exception {
		System.out.println("Click on Select Button");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", selectButton);

		threadWait1();
		js.executeScript("arguments[0].click();", selectButton);
		
		return this;
	}
	
	public AL_Stores_Trans_VendorPaymentApproval_Flow02_2 Enter_PayNowAmount() throws Exception {
		System.out.println("Enter Pay Now Amount ==> 50");
		threadWait1();
		clearText(payNowAmountField);
		sendKeys(payNowAmountField, "50");
		return this;
	}
	
	public AL_Stores_Trans_VendorPaymentApproval_Flow02_2 Click_ApproveRadioButton() throws Exception {
		System.out.println("Click on Accept Radio Button");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", acceptRadioButton);

		threadWait1();
		js.executeScript("arguments[0].click();", acceptRadioButton);
		
		return this;
	}
	
	public AL_Stores_Trans_VendorPaymentApproval_Flow02_2 Click_SubmitButton() throws Exception {
		System.out.println("Click on Submit Button");
		threadWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", submitButton);

		threadWait1();
		js.executeScript("arguments[0].click();", submitButton);
		
		return this;
	}
}
