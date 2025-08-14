package RFCCAcademic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FB_CFR_GeneralQuestionResponseReport extends BaseClass
{
	public AL_Academic_FB_CFR_GeneralQuestionResponseReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "ACADEMIC") private WebElement Academic;
	@FindBy(linkText = "FeedBack") private WebElement FeedBack;
	@FindBy(linkText = "Common Feedback Report") private WebElement CommonFeedbackReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlreport") private WebElement SelectReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection") private WebElement sections;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlcollege1") private WebElement SelectCollege;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement SelectSession;
	@FindBy(xpath = "//span[@class='multiselect-selected-text']") private WebElement SelectSemester;
	@FindBy(xpath = "//input[@value='multiselect-all']") private WebElement AllSelectSemester;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlFeedbackTyp") private WebElement FeedBackType;
//	@FindBy(xpath ="ctl00_ContentPlaceHolder1_btnReport") private WebElement FacultyFeedbackReport;
	@FindBy(id ="ctl00_ContentPlaceHolder1_btnReport") private WebElement generalquestionresponsereport;
	
	
	
	//

	public AL_Academic_FB_CFR_GeneralQuestionResponseReport ACADEMIC() {
		System.out.println("Admin ACADEMIC menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Academic).build().perform();
		return this;
	}

	public AL_Academic_FB_CFR_GeneralQuestionResponseReport FeedBack() {
		System.out.println("Acdemic Related submenu selected FeedBack");
		Actions action = new Actions(driver);
		action.moveToElement(FeedBack).click().build().perform();
		return this;
	}

	public AL_Academic_FB_CFR_GeneralQuestionResponseReport CommonFeedbackReport() {
		System.out.println(" Click on Common Feedback Report");
		CommonFeedbackReport.click();
		return this;
	}

	public AL_Academic_FB_CFR_GeneralQuestionResponseReport SelectReport() {
		System.out.println("Select Report  > GENERAL QUESTION RESPONSE REPORT");
		Select c = new Select(SelectReport);
		c.selectByVisibleText("GENERAL QUESTION RESPONSE REPORT");
		return this;
	}
	
	public AL_Academic_FB_CFR_GeneralQuestionResponseReport SelectSession() {
		System.out.println("Select Session > Dec 2022");
		Select c3 = new Select(SelectSession);
		c3.selectByVisibleText("Dec 2022");
		return this;
	}
	
	public AL_Academic_FB_CFR_GeneralQuestionResponseReport SelectCollege() {
		System.out.println("Select College and Scheme  > School of Infrastructure");
		Select c2 = new Select(SelectCollege);
		c2.selectByVisibleText("School of Infrastructure");
		return this;
	}
	
	public AL_Academic_FB_CFR_GeneralQuestionResponseReport SelectSemester() {
		System.out.println("Select Semester > All selected");
		click(SelectSemester);
		click(AllSelectSemester);
		return this;
	}
	

	
	public AL_Academic_FB_CFR_GeneralQuestionResponseReport FeedBackType() {
		System.out.println("Select FeedBack Type > Feedback Level I on Course Teacher");
		Select c6 = new Select(FeedBackType);
		c6.selectByVisibleText("Feedback Level I on Course Teacher");
		return this;
	}
	
	public AL_Academic_FB_CFR_GeneralQuestionResponseReport GeneralQuestionResponseReportBtn() {
		System.out.println("Click on General Question Response Report  Btn");
		click(generalquestionresponsereport);
		return this;
	}

}
