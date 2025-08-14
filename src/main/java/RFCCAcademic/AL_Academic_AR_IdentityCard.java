package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Academic_AR_IdentityCard extends BaseClass {

	public AL_Academic_AR_IdentityCard(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	Actions action;

	@FindBy(id = "ctl00_repLinks_ctl04_lbLink")
	private WebElement IdentityCard_Link;

	@FindBy(xpath = "//span[@aria-labelledby='select2-ctl00_ContentPlaceHolder1_ddlAdmbatch-container']")
	private WebElement AdmissionBatch_Dropdown;

	@FindBy(className = "select2-search__field")
	private WebElement Searchfield;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlClg-container")
	private WebElement School_Dropdown;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDegree-container")
	private WebElement Degree_Dropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow")
	private WebElement Show_Button;

	@FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_Panel1']/div[1]/h5")
	private WebElement Search_Results;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudentRecords_ctrl0_chkReport")
	private WebElement First_SearchResult_Checkbox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnFrontBackIdentityCard")
	private WebElement FrontBackIdentityCard_Button;
	
	@FindBy(id = "ctl00_repLinks_ctl04_lbLink")
	private WebElement idcardsubmenu;
	
	

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AL_Academic_AR_IdentityCard Click_IdentityCard_Link() {
		IdentityCard_Link.click();
		System.out.println("Click on Identity Card from subMenu");
		return this;
	}

	public AL_Academic_AR_IdentityCard Select_AdmissionBatch() {
		AdmissionBatch_Dropdown.click();
		return this;
	}

	public AL_Academic_AR_IdentityCard Enter_AdmissionBatch() {
		Searchfield.sendKeys("2023-24", Keys.DOWN);
		Searchfield.sendKeys(Keys.ENTER);
		System.out.println("Admission Batch -> 2023-24");
		return this;
	}

	public AL_Academic_AR_IdentityCard Select_School() {
		/*
		 * School_Dropdown.click();
		 * Searchfield.sendKeys("Crescent School of Architecture - Chennai",Keys.ENTER);
		 * System.out.
		 * println("School/Institute -> Crescent School of Architecture - Chennai");
		 */
		WebElement school = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClg"));
		Select typ_school = new Select(school);
		typ_school.selectByVisibleText("Crescent School of Architecture - Chennai");

		System.out.println("School/Institute -> Crescent School of Architecture - Chennai");
		return this;
	}

	public AL_Academic_AR_IdentityCard Select_Degree() {
		Degree_Dropdown.click();
		Searchfield.sendKeys("Bachelor of Architecture", Keys.ENTER);
		System.out.println("Degree -> Bachelor of Architecture");
		return this;
	}

	public AL_Academic_AR_IdentityCard Click_Show_Button() {
		Show_Button.click();
		return this;
	}

	public AL_Academic_AR_IdentityCard Validate_SearchResults() {
		Assert.assertEquals(Search_Results.getText(), "Search Results");
		return this;
	}

	public AL_Academic_AR_IdentityCard Select_First_Search_Result() {
	//
		System.out.println("Select student -> Click on 1st CheckBox -> Nayan Sharma -> RRNO -> 232AT004 ");
		WebElement search_student = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearch_Regno"));
		search_student.sendKeys("232AT004");

		WebElement search_button = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearch"));
		search_button.click();

		System.out.println("Select student -> Click on 1st CheckBox -> Nayan Sharma -> RRNO -> 232AT004 ");
		WebElement checkbox = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudentRecords_ctrl0_chkReport"));
		js.executeScript("arguments[0].scrollIntoView();", checkbox);
		click(checkbox);
		return this;
	}
	public AL_Academic_AR_IdentityCard Click_IdCardSubMenu() {
	click(idcardsubmenu);
	System.out.println("Click on Identity Card from subMenu");
	return this;

	}

	public AL_Academic_AR_IdentityCard Click_FrontBackIdentityCard_Button() {
		System.out.println("Click on Print Front Back ID Card");
		FrontBackIdentityCard_Button.click();
		return this;
	}

}
