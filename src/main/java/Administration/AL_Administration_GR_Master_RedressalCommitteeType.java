package Administration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Administration_GR_Master_RedressalCommitteeType extends BaseClass {

	public AL_Administration_GR_Master_RedressalCommitteeType(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "ctl00_repLinks_ctl01_lbLink")
	private WebElement RedressalCommitteeType;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvCommittee_ctrl0_btnEdit")
	private WebElement EditClick;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement SubmitBtn;

	public AL_Administration_GR_Master_RedressalCommitteeType ClickOn_RedressalCommitteeType() {
		System.out.println("Click on RedressalCommitteeType ");
		RedressalCommitteeType.click();
		return this;
	}

	public AL_Administration_GR_Master_RedressalCommitteeType ClickOn_Edit() {
		System.out.println("Click on Edit ");
		EditClick.click();
		return this;
	}

	public AL_Administration_GR_Master_RedressalCommitteeType ClickOn_SubmitButton() {
		System.out.println("Click on SubmitButton ");
		SubmitBtn.click();
		return this;
	}

}
