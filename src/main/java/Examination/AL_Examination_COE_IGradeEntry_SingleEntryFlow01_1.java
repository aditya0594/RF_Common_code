package Examination;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1 extends BaseClass{

	public AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "I Grade Entry") private WebElement IGradeEntry_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoSingle") private WebElement SingleIndividualStudentEntry_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSessionSingle") private WebElement Session_Dropdown;
	@FindBy(className = "select2-search__field") private WebElement SearchField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemesterSingle") private WebElement Semester_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRegNo") private WebElement RegNo_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowSingle") private WebElement Show_Button;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']") private WebElement searchbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSubjects_ctrl0_chkSubject") private WebElement chkbox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmitSingle") private WebElement Submit_Button;

	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1 click_IGradeEntry_Link() {
		System.out.println("I Grade Entry submenu selected");
		action.moveToElement(IGradeEntry_Link);
		action.click().build().perform();
		return this;
	}
	public AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1 click_SingleIndividualStudentEntry() {
		SingleIndividualStudentEntry_Button.click();
		return this;
	}
	public AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1 select_Session() {
		Select session = new Select(Session_Dropdown);
		session.selectByVisibleText("May 2022 - School of Computer Information and Mathematical Sciences");
		System.out.println("Session - > May 2022 - School of Computer Information and Mathematical Sciences");
		return this;
	}
	public AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1 Select_Semester() {
		Select semester = new Select(Semester_Dropdown);
		semester.selectByVisibleText("VI");
		System.out.println("Semester -> VI");
		return this;
	}
	public AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1 enter_RegNo() {
		RegNo_Inputbox.sendKeys("190071601123"); // Course Type
		System.out.println("RegistrationNo -> 190071601123");
		return this;
	}
	
	public AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1 click_Show_Button() {
		System.out.println("Click on Show btn");
		Show_Button.click();
		return this;
	}
	
	
	public AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1 Search_Course() throws InterruptedException {
		System.out.println("Search Course => 3211 and click on check box");

		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",searchbox);
		js.executeScript("arguments[0].click();", searchbox);
		sendKeys(searchbox, "3211");
		threadWait1();
		click(chkbox);
		return this;
	}
	
	
	
	public AL_Examination_COE_IGradeEntry_SingleEntryFlow01_1 click_Submit_Button() {
		System.out.println("Click on Submit btn");
		Submit_Button.click();
		return this;
	}
}
