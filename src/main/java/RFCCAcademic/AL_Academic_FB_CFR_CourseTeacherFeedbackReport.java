package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FB_CFR_CourseTeacherFeedbackReport extends BaseClass
{
	public AL_Academic_FB_CFR_CourseTeacherFeedbackReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "ACADEMIC") private WebElement Academic;
	@FindBy(linkText = "FeedBack") private WebElement FeedBack;
	@FindBy(linkText = "Common Feedback Report") private WebElement CommonFeedbackReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlreport") private WebElement SelectReport;
	@FindBy(xpath = "(//span[@class='multiselect-selected-text'])[1]") private WebElement SelectCollegeSession;
	@FindBy(xpath = "(//input[@value='multiselect-all'])[1]") private WebElement selectAllclg;

//	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection")
//	private WebElement SelectSection;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlFeedbackType") private WebElement FeedBackType;
//	@FindBy(xpath ="ctl00_ContentPlaceHolder1_btnReport") private WebElement FacultyFeedbackReport;
	@FindBy(xpath ="(//input[@id='ctl00_ContentPlaceHolder1_btnReport'])[1]") private WebElement courseteacherfeedbackreport;
	
	
	

	public AL_Academic_FB_CFR_CourseTeacherFeedbackReport FeedBack() {
		System.out.println("Acdemic Related submenu selected FeedBack");
		Actions action = new Actions(driver);
		action.moveToElement(FeedBack).click().build().perform();
		return this;
	}

	public AL_Academic_FB_CFR_CourseTeacherFeedbackReport CommonFeedbackReport() {
		System.out.println(" Click on Common Feedback Report");
		CommonFeedbackReport.click();
		return this;
	}

	public AL_Academic_FB_CFR_CourseTeacherFeedbackReport SelectReport() {
		System.out.println("Select Report  > COURSE TEACHER FEEDBACK REPORT");
		Select c = new Select(SelectReport);
		c.selectByVisibleText("COURSE TEACHER FEEDBACK REPORT");
		return this;
	}
	
	public AL_Academic_FB_CFR_CourseTeacherFeedbackReport Select_CollegeSession() {
		System.out.println("Select college and session => All selected");
		click(SelectCollegeSession);
		click(selectAllclg);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblDynamicPageTitle")).click();
		return this;
	}
	
	
	public AL_Academic_FB_CFR_CourseTeacherFeedbackReport FeedBackType() {
		System.out.println("Select FeedBack Type > Feedback Level I on Course Teacher");
		Select c6 = new Select(FeedBackType);
		c6.selectByVisibleText("Feedback Level I on Course Teacher");
		return this;
	}
	
	public AL_Academic_FB_CFR_CourseTeacherFeedbackReport CourseTeacherFeedbackReportBtn() {
		System.out.println("Click on Course Teacher Feedback Report Btn");
		click(courseteacherfeedbackreport);
		return this;
	}
}
