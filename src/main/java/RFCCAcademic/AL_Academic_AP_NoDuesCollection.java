package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Academic_AP_NoDuesCollection extends BaseClass{

	public AL_Academic_AP_NoDuesCollection(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "No Dues Collection") private WebElement NoDuesCollection_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement Degree_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranch") private WebElement Branch_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement Show_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudents_ctl01_txtDue") private WebElement DueAmount_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudents_ctl01_ddlStatus") private WebElement Status_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement Submit_Button;
	

	public AL_Academic_AP_NoDuesCollection Click_NoDueCollection_Link() {
		NoDuesCollection_Link.click();
		System.out.println("Click on No Dues Collection");
		return this;
	}

	public AL_Academic_AP_NoDuesCollection Select_Degree() {
		Select typ_deg = new Select(Degree_Dropdown);
		typ_deg.selectByVisibleText("Bachelor of Architecture");
		System.out.println("Degree -> Bachelor of Architecture");
		return this;
	}

	public AL_Academic_AP_NoDuesCollection Select_Branch() {
		Branch_Dropdown.click();
		Select typ_branch = new Select(Branch_Dropdown);
		typ_branch.selectByVisibleText("Architecture");
		System.out.println("Degree -> Architecture");
		return this;
	}

	public AL_Academic_AP_NoDuesCollection Click_ShowButton() {
		Show_Button.click();
		return this;
	}

	public AL_Academic_AP_NoDuesCollection Enter_DueAmount() {
		DueAmount_Inputbox.sendKeys("10000");
		System.out.println("Click on Due Fee, & Enter 1Rs");
		return this;
	}

	public AL_Academic_AP_NoDuesCollection Select_Status() {
		Select typ_status = new Select(Status_Dropdown);
		typ_status.selectByValue("1");
		System.out.println("Change Status to yes");
		return this;
	}

	public AL_Academic_AP_NoDuesCollection Click_Submit_Button() {
		Submit_Button.click();
		System.out.println("Click on Submit");
		return this;
	}
}
