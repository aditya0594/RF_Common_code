package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_ModifyCourseRegistrationFlow02_1 extends BaseClass{

	public AL_Academic_CR_ModifyCourseRegistrationFlow02_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl04_lbLink") private WebElement modifyCourseReg_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSearch") private WebElement searchcriteria;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSearch") private WebElement searchstring;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearchCriteria") private WebElement searchBtn;
	@FindBy(linkText = "MOHAMED SAMIH. S") private WebElement mohamedSamith;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlParentGroupSingle") private WebElement coursesegment;
	@FindBy(xpath = "//h5[normalize-space()='Current Semester Subjects']") private WebElement currentsemsubject;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvCurrentSubjects_ctrl3_chkRegister") private WebElement chkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitbtn;
	@FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_btnPrintRegSlip'])[1]") private WebElement registrationslip;


	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_CR_ModifyCourseRegistrationFlow02_1 Click_ModifyCourseRegistration() {
		System.out.println("Click on Modify Course Registration");
		click(modifyCourseReg_link);
		return this;
	}
	public AL_Academic_CR_ModifyCourseRegistrationFlow02_1 Select_Session() {
		System.out.println("Select Session - May 2022");
		Select select = new Select(session);
		select.selectByVisibleText("May 2022");
		return this;
	}
	public AL_Academic_CR_ModifyCourseRegistrationFlow02_1 Select_SearchCriteria() {
		System.out.println("Select Search Criteria - RRN NO.");
		Select typ_criteria = new Select(searchcriteria);
		typ_criteria.selectByVisibleText("RRN NO.");
		System.out.println("Select Search Criteria - RRN NO.");
		return this;
	}
	public AL_Academic_CR_ModifyCourseRegistrationFlow02_1 Enter_SearchString() {
		searchstring.sendKeys("200101601017");
		System.out.println("Enter RRN no. => 200101601017");
		return this;
	}
	
	public AL_Academic_CR_ModifyCourseRegistrationFlow02_1 Click_SearchBtn() {
		System.out.println("Click on Search btn");
		searchBtn.click();
		return this;
	}

	public AL_Academic_CR_ModifyCourseRegistrationFlow02_1 Click_Student() {
		System.out.println("Click on Student => mohamed Samith");
		click(mohamedSamith);
		return this;
	}
	
	public AL_Academic_CR_ModifyCourseRegistrationFlow02_1 Select_CousreSegment() throws InterruptedException {
		System.out.println("Select Cousre Segment => Core");
		Select select = new Select(coursesegment);
		select.selectByVisibleText("Core");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",currentsemsubject);

		return this;
	}
	
	
	public AL_Academic_CR_ModifyCourseRegistrationFlow02_1 Click_CheckBox() {
		System.out.println("Click on Check box");
		click(chkbox);
		return this;
	}
	
	public AL_Academic_CR_ModifyCourseRegistrationFlow02_1 Click_SubmitBtn() throws InterruptedException {
		System.out.println("Click on Submit btn");
		js.executeScript("arguments[0].scrollIntoView();",submitbtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submitbtn);
		return this;
	}
	
	public AL_Academic_CR_ModifyCourseRegistrationFlow02_1 Click_RegistrationSlipBtn() {
		System.out.println("Click on Registration Slip btn");
		click(registrationslip);
		return this;
	}
}
