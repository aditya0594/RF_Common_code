package Administration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Administration_FM_Master_DepartmentAuthorityMapping  extends BaseClass {
	
	public AL_Administration_FM_Master_DepartmentAuthorityMapping(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//a[@id='ctl00_repLinks_ctl00_lbLink']")
	private WebElement DepartmentAuthorityMapping;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSection_ctrl1_btnEdit")
	private WebElement EditClick;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement SubmitBtn;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport")
	private WebElement CGRReports;
	
	public AL_Administration_FM_Master_DepartmentAuthorityMapping ClickOn_DepartmentAuthorityMapping() {
		System.out.println("Click on Department Authority Mapping ");
		DepartmentAuthorityMapping.click();
		return this;
	}
	
	public AL_Administration_FM_Master_DepartmentAuthorityMapping ClickOn_Edit() {
		System.out.println("Click on Edit ");
		EditClick.click();
		return this;
	}
	
	public AL_Administration_FM_Master_DepartmentAuthorityMapping Select_SubmitButton() {
		System.out.println("Click on Submit Button");
		SubmitBtn.click();
		return this;
	}
	
	
	public AL_Administration_FM_Master_DepartmentAuthorityMapping ClickOn_CGRReports() {
		System.out.println("Click on Department Authority Mapping Report ");
		CGRReports.click();
		return this;
	}

}
