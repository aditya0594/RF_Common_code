package Administration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Administration_GR_Master_SubGrievanceType extends BaseClass {
	
	public AL_Administration_GR_Master_SubGrievanceType(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath="//a[text()='Sub Grievance Type']")  
	private WebElement SubGrievanceType;  
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSubGrivType_ctrl0_btnEdit")
	private WebElement EditClick;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlGriv")
	private WebElement GrievanceType;
	 
	@FindBy(id="ctl00_ContentPlaceHolder1_txtSubGriv")
	private WebElement TxtSubGrievanceType;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement SubmitBtn;
	
	
	
	
	public AL_Administration_GR_Master_SubGrievanceType ClickOn_SubGrievanceType() {
		System.out.println("Click on SubGrievanceType ");
		SubGrievanceType.click();
		return this;
	}
	
	public AL_Administration_GR_Master_SubGrievanceType ClickOn_EditClick() {
		System.out.println("Click on Edit Click ");
		EditClick.click();
		return this;
	}
	
	
	
	public AL_Administration_GR_Master_SubGrievanceType ClickOn_Submit() {
		System.out.println("Click on Submit ");
		SubmitBtn.click();
		return this;
	}

}
