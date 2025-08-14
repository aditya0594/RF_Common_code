package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Academic_AP_ProspectusEntry extends BaseClass {

	public AL_Academic_AP_ProspectusEntry(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl00_lbLink")
	private WebElement Academic_AddProc_ProspectusEntry;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtStudName")
	private WebElement Student_Name_Inputbox;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSchool-container")
	private WebElement School_dropdown;

	@FindBy(className = "select2-search__field")
	private WebElement Searchfield;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDegree-container")
	private WebElement Degree_dropdown;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlBranch-container")
	private WebElement select_Branch;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtMobile")
	private WebElement MobileNumber_Inputbox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtProspectusno")
	private WebElement ProspectusNumber_Inputbox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTotalAmount")
	private WebElement TotalAmount_inputfield;
	
	@FindBy(xpath = "//span[@class='selection']/span[@aria-labelledby='select2-ctl00_ContentPlaceHolder1_ddlRemark-container']")
	private WebElement Remark_dropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
	private WebElement Submit_Button;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowReport")
	private WebElement Show_Button;

	public AL_Academic_AP_ProspectusEntry click_ProcpectusEntry_Link() {
		Academic_AddProc_ProspectusEntry.click(); 
		System.out.println("Click on Prospectus entry");
		return this;
	}

	public AL_Academic_AP_ProspectusEntry enter_Student_Name() {
		Student_Name_Inputbox.click();
		Student_Name_Inputbox.clear();
		Student_Name_Inputbox.sendKeys("Roshani");
		System.out.println("Student Name -> Roshani");
		return this;
	}

	public AL_Academic_AP_ProspectusEntry select_School() {
		School_dropdown.click();
		Searchfield.sendKeys("Crescent School of Architecture - Chennai",Keys.ENTER);
		System.out.println("School/Institute -> Crescent School of Architecture - Chennai");
		return this;
	}

	public AL_Academic_AP_ProspectusEntry select_Degree() {
		Degree_dropdown.click();
		Searchfield.sendKeys("Bachelor of Architecture", Keys.ENTER);
		System.out.println("Degree -> Bachelor of Architecture");
		return this;
	}

	public AL_Academic_AP_ProspectusEntry select_Branch() {
		select_Branch.click();
		Searchfield.sendKeys("Architecture", Keys.ENTER);
		System.out.println("Programme/Branch -> Architecture");
		return this;
	}

	public AL_Academic_AP_ProspectusEntry enter_Mobile_Number() {
		MobileNumber_Inputbox.click();
		MobileNumber_Inputbox.clear();
		MobileNumber_Inputbox.sendKeys("8149914475");
		System.out.println("Mobile -> 8149914475");
		return this;
	}

	public AL_Academic_AP_ProspectusEntry enter_ProspectusNumber(int pros_no) {
		ProspectusNumber_Inputbox.click();
		ProspectusNumber_Inputbox.clear();
		ProspectusNumber_Inputbox.sendKeys(String.valueOf(pros_no));
		System.out.println("Prospectus No. -> 12");
		return this;
	}

	public AL_Academic_AP_ProspectusEntry enter_TotalAmount() {
		TotalAmount_inputfield.click();
		TotalAmount_inputfield.clear();
		TotalAmount_inputfield.sendKeys("1");
		System.out.println("Total Amount -> 1");
		return this;
	}
	
	public AL_Academic_AP_ProspectusEntry select_Remark() {
		Remark_dropdown.click();
		Searchfield.sendKeys("Cash", Keys.ENTER);
		System.out.println("Remark -> Cash");
		return this;
	}
	
	public AL_Academic_AP_ProspectusEntry click_Submit_Button() {
		Submit_Button.click(); 
		System.out.println("Click on Submit");
		return this;
	}

	public AL_Academic_AP_ProspectusEntry click_Show_Button() {
		Show_Button.click(); 
		System.out.println("Prospectus Receipt");
		return this;
	}


}
