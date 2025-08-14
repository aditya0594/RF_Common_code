package Administration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Administration_FM_Master_RoleMaster   extends BaseClass {
	
	public AL_Administration_FM_Master_RoleMaster(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//a[@id='ctl00_repLinks_ctl03_lbLink']")
	private WebElement RoleMaster;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvRole_ctrl1_btnEdit")
	private WebElement EditClick;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement SubmitBtn;

	
	
	public AL_Administration_FM_Master_RoleMaster ClickOn_RoleMaster() {
		System.out.println("Click on RoleMaster ");
		RoleMaster.click();
		return this;
	}
	
	
	public AL_Administration_FM_Master_RoleMaster ClickOn_Edit() {
		System.out.println("Click on Edit ");
		EditClick.click();
		return this;
	}
	
	public AL_Administration_FM_Master_RoleMaster Select_SubmitButton() {
		System.out.println("Click on Submit Button");
		SubmitBtn.click();
		return this;
	}


}
