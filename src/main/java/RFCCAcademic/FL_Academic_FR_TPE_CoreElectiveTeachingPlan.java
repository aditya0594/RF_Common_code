package RFCCAcademic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

/**
 * FL_Academic_FR_TPE_CoreElectiveTeachingPlan class handles operations related to Core/Elective Teaching Plan
 */
public class FL_Academic_FR_TPE_CoreElectiveTeachingPlan extends BaseClass {
	
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl00_lbLink")
	private WebElement teachingPlanEntryLink;
	
	@FindBy(partialLinkText = "Core/Elective Teaching Plan")
	private WebElement coreElectiveTeachingPlanTab;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession")
	private WebElement sessionDropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlScheme")
	private WebElement collegeDropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester")
	private WebElement semesterDropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection")
	private WebElement sectionDropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlUnitNo")
	private WebElement unitNoDropdown;
	
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlLectureNo-container")
	private WebElement topicDropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlLectureNo")
	private WebElement topicInputBox;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtLectureTopic")
	private WebElement topicDescriptionInputbox;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSessionReq")
	private WebElement noOfSessionRequiredInput;
	
	@FindBy(xpath = "//td[4][text()='1']/../td[2]/input")
	private WebElement deleteBtn;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement submitButton;
	//
	JavascriptExecutor js = (JavascriptExecutor) driver;

	/**
	 * Clicks on the Teaching Plan Entry link
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan Click_Teaching_Plan_Entry() throws InterruptedException {
		System.out.println("Click on Teaching Plan Entry");
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();", teachingPlanEntryLink);
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", teachingPlanEntryLink);
		return this;
	}
	
	/**
	 * Clicks on the Core/Elective Teaching Plan tab
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan Click_CoreOrElectiveTeaching_Tab() throws InterruptedException {
		System.out.println("Click on Core/Elective Teaching Plan");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();", coreElectiveTeachingPlanTab);
		js.executeScript("arguments[0].click();", coreElectiveTeachingPlanTab);
		
		Thread.sleep(2000);
		// Sometimes needs a second click to fully activate
		js.executeScript("arguments[0].click();", coreElectiveTeachingPlanTab);
		return this;
	}
	
	/**
	 * Selects the Session value
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan Select_Session() throws InterruptedException {
		System.out.println("Select Session ==> May 2022");
		Thread.sleep(1000);
		Select sessionSelect = new Select(sessionDropdown);
		sessionSelect.selectByVisibleText("May 2022");
		return this;
	}
	
	/**
	 * Selects the College value
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan Select_College() throws InterruptedException {
		System.out.println("Select College & Scheme ==> SSSH - B.Com.-General-2017-18-Department of Commerce (Old Scheme)");
		Thread.sleep(1000);
		Select collegeSelect = new Select(collegeDropdown);
		collegeSelect.selectByVisibleText("SSSH - B.Com.-General-2017-18-Department of Commerce (Old Scheme)");
		return this;
	}
	
	/**
	 * Selects the Semester value
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan Select_Semester() throws InterruptedException {
		System.out.println("Select Semester/Course ==> VI - Theory with Tutorial - COC 3201 - Income Tax Law & Practice - II");
		Thread.sleep(1000);
		Select semesterSelect = new Select(semesterDropdown);
		semesterSelect.selectByVisibleText("VI - Theory with Tutorial - COC 3201 - Income Tax Law & Practice - II");
		return this;
	}
	
	/**
	 * Selects the Section value
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan Select_Section() throws InterruptedException {
		System.out.println("Select Section ==> B");
		Thread.sleep(1000);
		Select sectionSelect = new Select(sectionDropdown);
		sectionSelect.selectByVisibleText("B");
		return this;
	}
	
	/**
	 * Selects the Unit Number
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan Select_UnitNo() throws InterruptedException {
		System.out.println("Select Unit No ==> 1");
		Thread.sleep(1000);
		Select unitSelect = new Select(unitNoDropdown);
		unitSelect.selectByVisibleText("1");
		return this;
	}
	
	/**
	 * Selects the Topic Number
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan Select_TopicNo() throws InterruptedException {
		System.out.println("Select Topic No ==> 1");
		Select s = new Select(topicInputBox);
		s.selectByVisibleText("1");
		return this;
	}
	
	/**
	 * Enters the Topic Description
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan Enter_TopicDescription() throws InterruptedException {
		System.out.println("Enter Topic Description ==> Attendance Plan");
		Thread.sleep(1000);
		topicDescriptionInputbox.clear();
		topicDescriptionInputbox.sendKeys("Attendance Plan");
		return this;
	}
	
	/**
	 * Enters the Number of Sessions Required
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan Enter_NoOfSessionRequired() throws InterruptedException {
		System.out.println("Enter No. of Session Required ==> 3");
		Thread.sleep(1000);
		noOfSessionRequiredInput.clear();
		noOfSessionRequiredInput.sendKeys("3");
		return this;
	}
	
	/**
	 * Clicks the Submit button
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan Click_Submit_Button() throws InterruptedException {
		System.out.println("Click on Submit button");
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", submitButton);
		return this;
	}
	
	/**
	 * Handles the alert that appears after submitting
	 * @return this instance for method chaining
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan Handle_Alert() throws InterruptedException {
		System.out.println("Handling alert");
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		/*
		 * String Expected_Msg = ""; //Teaching Plan Saved Successfully!
		 * String Actual_Msg = alert.getText();
		 * Thread.sleep(2000);
		 * Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		 */
		
		String alertText = alert.getText();
		System.out.println("Alert message: " + alertText);
		alert.accept();
		
		return this;
	}
	
	public FL_Academic_FR_TPE_CoreElectiveTeachingPlan Click_Delete_Button() throws InterruptedException {
		System.out.println("Click on Delete button");
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(false);", deleteBtn);
		js.executeScript("arguments[0].click();", deleteBtn);
		
		return this;
	}
}
