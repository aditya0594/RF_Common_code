package Stores;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Stores_Trans_DepartmentUserRequisitonFlow04_1 extends BaseClass {

	public AL_Stores_Trans_DepartmentUserRequisitonFlow04_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(linkText = "Department User Requisition") private WebElement departmentUserRequisitionLink;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdbReqFor_0") private WebElement purchaseRadioBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDepartment") private WebElement departmentDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlItemName") private WebElement itemNameDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRequiredQty") private WebElement requiredQtyField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRate") private WebElement rateField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_butSubmit") private WebElement addItemBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_butSubmitReq") private WebElement submitBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_butReport") private WebElement showReportButton;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReportIndentSlipNo") private WebElement reportIndentSlipNo;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportButton;
	@FindBy(xpath = "//label[contains(text(),'Requisition Slip No.')]/following::input[1]") private WebElement requisitionslipno;
	@FindBy(xpath = "//h5[normalize-space()='Enter Item Details']") private WebElement enteritemdetails;

	public AL_Stores_Trans_DepartmentUserRequisitonFlow04_1 click_DepartmentUserRequisition() throws Exception {
		System.out.println("Click on Department User Requisition");
		
		js.executeScript("arguments[0].scrollIntoView();", departmentUserRequisitionLink);
		
		js.executeScript("arguments[0].click();", departmentUserRequisitionLink);
		return this;
	}

	public AL_Stores_Trans_DepartmentUserRequisitonFlow04_1 click_Purchase() {
		System.out.println("Click on Purchase radio button");
		
		js.executeScript("arguments[0].click();", purchaseRadioBtn);
		return this;
	}
	
	public AL_Stores_Trans_DepartmentUserRequisitonFlow04_1 select_Department() throws InterruptedException {
		System.out.println("Select Department => Information Technology");
		
		Select select = new Select(departmentDropdown);
		select.selectByVisibleText("Information Technology");
		return this;
	}
	
	public AL_Stores_Trans_DepartmentUserRequisitonFlow04_1 select_ItemName() {
		System.out.println("Select Item Name => CHAIRS ( CH455 ) [NON CONSUMABLE]");
		js.executeScript("arguments[0].scrollIntoView();",itemNameDropdown);
		Select select = new Select(itemNameDropdown);
		select.selectByVisibleText("CHAIRS ( CH455 ) [NON CONSUMABLE]");
		return this;
	}
	
	public AL_Stores_Trans_DepartmentUserRequisitonFlow04_1 enter_RequiredQty() {
		System.out.println("Enter Required Quantity => 2");
		js.executeScript("arguments[0].scrollIntoView();",requiredQtyField);

		clearText(requiredQtyField);
		sendKeys(requiredQtyField, "2");
//		enteritemdetails.click();		
		return this;
	}
	
	public AL_Stores_Trans_DepartmentUserRequisitonFlow04_1 enter_Rate() throws InterruptedException {
		System.out.println("Enter Rate => 50");
		enteritemdetails.click();
		threadWait1();
		acceptAlert();
		js.executeScript("arguments[0].scrollIntoView();",rateField);

		clearText(rateField);
		sendKeys(rateField, "50");
		return this;
	}
	
	public AL_Stores_Trans_DepartmentUserRequisitonFlow04_1 click_AddItemBtn() {
		System.out.println("Click on Add Item button");
		
		js.executeScript("arguments[0].scrollIntoView();", addItemBtn);
		
		js.executeScript("arguments[0].click();", addItemBtn);
		return this;
	}
	
	public AL_Stores_Trans_DepartmentUserRequisitonFlow04_1 click_SubmitBtn() {
		System.out.println("Click on Submit button");
		
		js.executeScript("arguments[0].scrollIntoView();", submitBtn);
		
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
	

	/**
	 * Method to get the text from Item Sale TR NO. field
	 * @return String - The text in the Item Sale TR NO. field
	 */
	public String getRequisitionSlipNumber() {
		try {
			System.out.println("Getting Requisition Slip No.");
			
			// Get text using JavascriptExecutor
			String trNumber = (String) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].value;", requisitionslipno);
			
			System.out.println("Requisition Slip No.: " + trNumber);
			return trNumber;
		} catch (Exception e) {
			System.out.println("Exception while getting Requisition Slip No.: " + e.getMessage());
			return null;
		}
	}
}
