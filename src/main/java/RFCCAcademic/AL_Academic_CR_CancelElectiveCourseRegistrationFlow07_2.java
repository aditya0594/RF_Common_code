package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import RFCCAcademic.AL_Academic_CR_CancelCourseRegistration;
import utility.BaseClass;

public class AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2 extends BaseClass {

	public AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlClgname-container")
	private WebElement CollegeAndScheme;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSession-container")
	private WebElement Session;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSemester-container")
	private WebElement Semester;
	@FindBy(className = "multiselect-selected-text")
	private WebElement Section;

	@FindBy(linkText = "Cancel Course Registration")
	private WebElement Cancelcourse;

	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoSingle")
	private WebElement CancelStudent;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_divSingle\"]/div[1]/div/div[2]/span[1]/span[1]/span")
	private WebElement SelectSession;

	@FindBy(xpath = "//*[@id=\"select2-ctl00_ContentPlaceHolder1_ddlSemesterSingle-container\"]")
	private WebElement SelectSemester;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRegNo")
	private WebElement RRNO;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnShowSingle\"]")
	private WebElement ShowButton;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSubjects_chkAll")
	private WebElement SelectAllChechBox;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnSubmitSingle\"]")
	private WebElement SubmitButton;

	JavascriptExecutor js2 = (JavascriptExecutor) driver;

	public AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2 ACADEMIC() {
		System.out.println("Click on Academic");
		WebElement acad_ele = driver.findElement(By.linkText("ACADEMIC"));
		Actions action = new Actions(driver);
		action.moveToElement(acad_ele).perform();
		return this;
	}

	public AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2 CoordinatorRelated() {
		System.out.println("Click on Coordinator Related");
		WebElement subMenu = driver.findElement(By.linkText("Coordinator Related"));
		Actions action = new Actions(driver);
		action.moveToElement(subMenu).perform();
		subMenu.click();
		return this;
	}

	public AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2 Cancelcourse() throws Exception {
		System.out.println("Click on Cancel Course Registration");
		WebElement optn = driver.findElement(By.id("ctl00_repLinks_ctl18_lbLink"));
		Thread.sleep(2000);
		js2.executeScript("arguments[0].scrollIntoView();", optn);
		Thread.sleep(2000);
		js2.executeScript("arguments[0].click;", optn);
		optn.click();
		return this;
	}

	public AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2 CancelStudent() {
		System.out.println("Click on Cancel Single Student Course Registration");
		click(CancelStudent);
		return this; 
	}

	public AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2 SelectSession() throws InterruptedException {
		System.out.println("Session -> DEC 2021");
		WebElement session = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSessionSingle"));
		Select sessn = new Select(session);
		sessn.selectByVisibleText("May 2022");
		return this;
	}

	public AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2 SelectSemester() {
		System.out.println("Click on SelectSemester Button");
		WebElement semester = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemesterSingle"));
		Select semesterdate = new Select(semester);
		semesterdate.selectByVisibleText("IV");
		return this;
	}

	public AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2 RRNO() {
		System.out.println("Click on RRNO button");
		RRNO.sendKeys("200011602008	");
		return this;
	}

	public AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2 ShowButton() {
		System.out.println("Click on Show Button");
		click(ShowButton);
		return this;
	}

	public AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2 SelectAllChechBox() {
		System.out.println("Click on Select ChechBox");
		click(SelectAllChechBox);
		return this;
	}

	public AL_Academic_CR_CancelElectiveCourseRegistrationFlow07_2 SubmitButton() {
		System.out.println("Click on Submit Button");
		click(SubmitButton);
		return this;
	}
}
