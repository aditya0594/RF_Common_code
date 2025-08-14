package RFCCAcademic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FR_ReceiptType extends BaseClass{

	public AL_Academic_FR_ReceiptType(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl08_lbLink")
	private WebElement Receipt_Type_Link;

	@FindBy(className = "introjs-skipbutton")
	private WebElement skip_Button;

	@FindBy(id = "ctl00_ContentPlaceHolder1_uc_txtTitle")
	private WebElement Receipt_Title;

	@FindBy(id = "ctl00_ContentPlaceHolder1_uc_ddlReceiptCode")
	private WebElement receiptcode_dropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_uc_ddlBelongsTo")
	private WebElement Receipt_BelongsTo_Dropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_uc_txtAccountNo")
	private WebElement account_Number_InputBox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_uc_chkStatus")
	private WebElement TutionAdmissionInstitute_Checkbox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_uc_btnSubmit")
	private WebElement submit_Button;


	public AL_Academic_FR_ReceiptType click_Receipt_Type_Link() {
		Receipt_Type_Link.click();
		return this;
	}


	public AL_Academic_FR_ReceiptType click_Skip_Notice_Button() {
		if (skip_Button != null && skip_Button.isDisplayed()) {
			skip_Button.click();
			System.out.println("Click on Skip Notice / News");
		} else {
			System.out.println("Skip Button is not Prescent");
		}
		return this;
	}


	public AL_Academic_FR_ReceiptType enter_Receipt_Title() {
		System.out.println("Enter Receipt Title -> Other Fees");
		Receipt_Title.sendKeys("Other Fees");
		return this;
	}


	public AL_Academic_FR_ReceiptType select_Receipt_Code() {
		Select receiptCode =new Select(receiptcode_dropdown);
		receiptCode.selectByVisibleText("Is Transport Fee");
		return this;
	}


	public AL_Academic_FR_ReceiptType select_Receipt_BelongsTo() {
		Select receiptBelo=new Select(Receipt_BelongsTo_Dropdown);
		receiptBelo.selectByVisibleText("Hostel");

		return this;
	}


	public AL_Academic_FR_ReceiptType enter_Account_Number() {
		System.out.println("Enter Account no. -> 96457812631");
		account_Number_InputBox.sendKeys("96457812631");
		return this;
	}


	public AL_Academic_FR_ReceiptType select_TutionAdmissionFees_Checkbox() {
		System.out.println("Click on Is tution/admission/fees");
		TutionAdmissionInstitute_Checkbox.click();
		return this;
	}


	public AL_Academic_FR_ReceiptType click_Submit_Button() {
		System.out.println("Click on submit button");
		submit_Button.click();
		return this;
	}


}
