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

public class AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 extends BaseClass{

	public AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "ACADEMIC")
	private WebElement Academic;

	@FindBy(linkText = "Coordinator Related")
	private WebElement CoOrdinatorRelated;

	@FindBy(linkText = "Course Teacher Allotment")
	private WebElement CourseTeacherAllotment;
	
	@FindBy(linkText = "Cancel Teacher Allotment")
	private WebElement CancelTeacherAllotment;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowCT")
	private WebElement Show;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement Search;

	@FindBy(xpath = "//div[@class='table-responsive']//td//span//input")
	private WebElement CheckBox;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmitCT")
	private WebElement Submit;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	Actions action = new Actions(driver);

	public AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 ClickAcademicTest() {
		System.out.println("Click on Academic menu");
		action.moveToElement(Academic).build().perform();
		return this;
	}

	public AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 ClickCordinatorRelatedTest() {
		System.out.println("Click Coordinator Related submenu");
		action.moveToElement(CoOrdinatorRelated).click().build().perform();
		return this;
	}

	public AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 ClickCourseTeacherAllotmentTest() {
		System.out.println("Click on Course Teacher Allotment");
		CourseTeacherAllotment.click();
		return this;
	}
	
	public AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 ClickCancelTeacherAllotmentTabTest() {
		System.out.println("Click on Cancel Teacher Allotment");
		CancelTeacherAllotment.click();
		return this;
	}

	public AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 SelectCollegeTest() {
		System.out.println("Select College -> CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");

		WebElement colg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSchemeCT"));
		Select typ_clog = new Select(colg);
		typ_clog.selectByVisibleText("CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");

		return this;
	}

	public AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 SelectSessionTest() {
		System.out.println("Select Session -> May 2022");

		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSessionCT"));
		Select typ_sessn = new Select(sessn);
		typ_sessn.selectByVisibleText("May 2022");

		return this;
	}

	public AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 SelectSemesterTest() {
		System.out.println("Select Semester -> III");

		WebElement semester = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlsemesterCT"));
		Select typ_semester = new Select(semester);
		typ_semester.selectByVisibleText("III");

		return this;
	}

	public AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 SelectDepartmentTest() {
		System.out.println("Select Department -> Crescent School of Architecture");

		WebElement dept = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDepartmentCT"));
		Select typ_dept = new Select(dept);
		typ_dept.selectByVisibleText("Crescent School of Architecture");

		return this;
	}
	
	public AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 ClickShowButtonTest() {
		System.out.println("Click on Show Button");
		click(Show);
		return this;
	}
	
	public AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 EnterSearchButtonTest() {
		System.out.println("Enter in Search => ARC 2107 - Allied Design Studio - III and Computer Graphics ");

		Search.clear();
		Search.sendKeys("HEMA PRITHIKKA");
		
		return this;
	}
	
	public AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 ClickCheckBoxButtonTest() {
		System.out.println("Click on Checkbox Button");
		//js.executeScript("arguments[0].scrollIntoView();", CheckBox);
		//CheckBox.sendKeys(Keys.ENTER);
		//action.moveToElement(CheckBox).click().perform();
		//js.executeScript("arguments[0].checked = true;", CheckBox);
		CheckBox.click();
		return this;
	}
	
	public AL_Academic_CR_CancelCourseTeacherAllotmentFlow04_2 ClickSubmitButtonTest() {
		System.out.println("Click on Submit Button");
		click(Submit);
		return this;
	}
	
}
