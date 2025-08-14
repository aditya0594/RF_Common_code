package Hostel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Hostel_HGP_ApprovalAuthorityMasterFlow02_1 extends BaseClass
{
	public AL_Hostel_HGP_ApprovalAuthorityMasterFlow02_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl01_lbLink") private WebElement ApprovalAuthorityMaster;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnaddauthority")private WebElement addauthorityapprovalBtn;
	@FindBy(xpath = "(//input[@class='form-control form-control-sm'])[1]")private WebElement SearchBox;
	@FindBy(xpath = "//input[@title='Edit Record']")private WebElement editIcon;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnauthSave")private WebElement submitbtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Hostel_HGP_ApprovalAuthorityMasterFlow02_1 ApprovalAuthorityMaste() {
		System.out.println("Click on Approval Authority Master");
		click(ApprovalAuthorityMaster);
		return this;
	}
	
	public AL_Hostel_HGP_ApprovalAuthorityMasterFlow02_1 Click_AddAuthorityApprovalBtn() {
		System.out.println("Click on Add Authority Appoval btn");
		click(addauthorityapprovalBtn);
		return this;
	}

	public AL_Hostel_HGP_ApprovalAuthorityMasterFlow02_1 Enter_SearchBox() {
		System.out.println("Enter text in Search Box - General");
		js.executeScript("arguments[0].scrollIntoView();",SearchBox);

		sendKeys(SearchBox, "General");
		return this;
	}
	
	public AL_Hostel_HGP_ApprovalAuthorityMasterFlow02_1 Click_EditIcon() {
		System.out.println("Click on Edit Icon");
		click(editIcon);
		return this;
	}
	
	public AL_Hostel_HGP_ApprovalAuthorityMasterFlow02_1 Click_SubmitBtn() {
		System.out.println("Click on Submit Btn");
		click(submitbtn);
		return this;
	}
}
