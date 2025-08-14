package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_Feedback_FeedbackTypeMaster extends BaseClass{
	
	public AL_Academic_Feedback_FeedbackTypeMaster(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl00_lbLink")
	private WebElement Feedback_Type_Master;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFeedbackName")
	private WebElement Feedback_Type_Inputbox;
	
	@FindBy(xpath = "//span[@aria-labelledBy='select2-ctl00_ContentPlaceHolder1_ddlfeedbackmode-container']")
	private WebElement Feedback_Mode_dropdown;
	
	@FindBy(xpath = "//span[@class='multiselect-selected-text']")
	private WebElement UsertypeSelect;
	
	@FindBy(xpath = "//input[@class='form-control multiselect-search']")
	private WebElement searchUserType;
	
	@FindBy(xpath = "//input[@value='15']")
	private WebElement chkboxclick;
	
	@FindBy(className = "select2-search__field")
	private WebElement Search_Inputbox;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
	private WebElement submit_Button;


	public AL_Academic_Feedback_FeedbackTypeMaster click_Feedback_Type_Master() {
		Feedback_Type_Master.click();
		return this;	
	}
	
	public AL_Academic_Feedback_FeedbackTypeMaster enter_Feedback_Type() {
		Feedback_Type_Inputbox.sendKeys("Feedback Testing");
		return this;		
	}
	
	public AL_Academic_Feedback_FeedbackTypeMaster select_Feedback_Mode() {
		Feedback_Mode_dropdown.click();
		Search_Inputbox.sendKeys("Normal/Induction", Keys.ENTER);
		return this;	
	}
	
	public AL_Academic_Feedback_FeedbackTypeMaster select_UserType() throws InterruptedException {
		System.out.println("Select check box");
		UsertypeSelect.click();
		Thread.sleep(2000);
		searchUserType.sendKeys("Admin");
		Thread.sleep(2000);
		chkboxclick.click();
		return this;	
	}
	
	
	public AL_Academic_Feedback_FeedbackTypeMaster click_Submit_Button() {
		//System.out.println("Click on Submit");
		submit_Button.click();
		return this;
	}
	
	
}
