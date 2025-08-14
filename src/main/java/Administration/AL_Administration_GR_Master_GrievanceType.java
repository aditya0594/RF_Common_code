package Administration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Administration_GR_Master_GrievanceType extends BaseClass {

	public AL_Administration_GR_Master_GrievanceType(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "ctl00_repLinks_ctl00_lbLink")
	private WebElement GrievanceType;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvGrievanceType_ctrl1_btnEdit")
	private WebElement EditClick;



	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement SubmitBtn;

	public AL_Administration_GR_Master_GrievanceType ClickOn_GrievanceType() {
		System.out.println("Click on GrievanceType ");
		GrievanceType.click();
		return this;
	}

	public AL_Administration_GR_Master_GrievanceType ClickOn_Edit() {
		System.out.println("Click on Edit ");
		EditClick.click();
		return this;
	}
	
	public AL_Administration_GR_Master_GrievanceType Select_SubmitButton() {
		System.out.println("Click on Submit Button");
		SubmitBtn.click();
		return this;
	}

	

}
