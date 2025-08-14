package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FB_CFR_HODFeedbackReport extends BaseClass
{
	public AL_Academic_FB_CFR_HODFeedbackReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "ACADEMIC") private WebElement Academic;
	@FindBy(linkText = "FeedBack") private WebElement FeedBack;
	@FindBy(linkText = "Common Feedback Report") private WebElement CommonFeedbackReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlreport") private WebElement SelectReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlformat") private WebElement SelectFormat;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClgname") private WebElement SelectCollege;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement SelectSession;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester") private WebElement SelectSemester;

//	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection")
//	private WebElement SelectSection;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlFeedbackTyp") private WebElement FeedBackType;
//	@FindBy(xpath ="ctl00_ContentPlaceHolder1_btnReport") private WebElement FacultyFeedbackReport;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnReport") private WebElement HODfeedbackreport;
	
	
	
	//

	public AL_Academic_FB_CFR_HODFeedbackReport ACADEMIC() {
		System.out.println("Admin ACADEMIC menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Academic).build().perform();
		return this;
	}

	public AL_Academic_FB_CFR_HODFeedbackReport FeedBack() {
		System.out.println("Acdemic Related submenu selected FeedBack");
		Actions action = new Actions(driver);
		action.moveToElement(FeedBack).click().build().perform();
		return this;
	}

	public AL_Academic_FB_CFR_HODFeedbackReport CommonFeedbackReport() {
		System.out.println(" Click on Common Feedback Report");
		CommonFeedbackReport.click();
		return this;
	}

	public AL_Academic_FB_CFR_HODFeedbackReport SelectReport() {
		System.out.println("Select Report  > HOD FEEDBACK REPORT");
		Select c = new Select(SelectReport);
		c.selectByVisibleText("HOD FEEDBACK REPORT");
		return this;
	}
	
	public AL_Academic_FB_CFR_HODFeedbackReport SelectSession() {
		System.out.println("Select Session > Dec 2022");
		Select c3 = new Select(SelectSession);
		c3.selectByVisibleText("Dec 2022");
		return this;
	}
	
	public AL_Academic_FB_CFR_HODFeedbackReport SelectCollege() {
		System.out.println("Select College and Scheme  > SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		Select c2 = new Select(SelectCollege);
		c2.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		return this;
	}
	
	public AL_Academic_FB_CFR_HODFeedbackReport SelectSemester() {
		System.out.println("Select Semester > VIII");
		Select c4 = new Select(SelectSemester);
		c4.selectByVisibleText("VIII");
		return this;
	}
	
//	public AL_Academic_FB_CFR_HODFeedbackReport SelectFormat() {
//		System.out.println("Select Report  >FORMATE I");
//		Select c1 = new Select(SelectFormat);
//		c1.selectByVisibleText("FORMATE I");
//		return this;
//	}
	
	public AL_Academic_FB_CFR_HODFeedbackReport FeedBackType() {
		System.out.println("Select FeedBack Type > Feedback Level I on Course Teacher");
		Select c6 = new Select(FeedBackType);
		c6.selectByVisibleText("Feedback Level I on Course Teacher");
		return this;
	}
	
	public AL_Academic_FB_CFR_HODFeedbackReport HODFeedBackReportBtn() {
		System.out.println("Click on HOD FeedBack Report Btn");
		click(HODfeedbackreport);
		return this;
	}
}
