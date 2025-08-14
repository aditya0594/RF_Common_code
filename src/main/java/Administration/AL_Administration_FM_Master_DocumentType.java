package Administration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Administration_FM_Master_DocumentType   extends BaseClass {
	
	public AL_Administration_FM_Master_DocumentType(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//a[@id='ctl00_repLinks_ctl02_lbLink']")
	private WebElement DocumentType;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvDocumentType_ctrl0_btnEdit")
	private WebElement EditClick;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement SubmitBtn;
	
	public AL_Administration_FM_Master_DocumentType ClickOn_DocumentType() {
		System.out.println("Click on Document Type ");
		DocumentType.click();
		return this;
	}
	
	public AL_Administration_FM_Master_DocumentType ClickOn_Edit() {
		System.out.println("Click on Edit ");
		EditClick.click();
		return this;
	}
	
	public AL_Administration_FM_Master_DocumentType Select_SubmitButton() {
		System.out.println("Click on Submit Button");
		SubmitBtn.click();
		return this;
	}

	

}
