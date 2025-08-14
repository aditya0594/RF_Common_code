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

public class AL_Academic_CR_CourseTeacherAllotmentFlow04_1 extends BaseClass {

	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "ACADEMIC")
	private WebElement Academic;

	@FindBy(linkText = "Coordinator Related")
	private WebElement CoOrdinatorRelated;

	@FindBy(linkText = "Course Teacher Allotment")
	private WebElement CourseTeacherAllotment;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnFilter")
	private WebElement Show;

	@FindBy(id = "FilterData")
	private WebElement Search;
	
	@FindBy(xpath = "(//td[contains(text(),'AMIT')])[1]")
	private WebElement FacultyName;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvCourseTeacher_ctrl1_chkAccept")
	private WebElement CheckBox;
	
	@FindBy(xpath = "(//span[@class='multiselect-selected-text'][normalize-space()='None selected'])[4]")
	private WebElement Section;
	
	@FindBy(xpath = "//ul[@class='multiselect-container dropdown-menu show']//input[@placeholder='Search']")
	private WebElement SearchSection;
	
	@FindBy(xpath = "//ul[@class='multiselect-container dropdown-menu show']//input[@value='1']")
	private WebElement SectionCheckboxA;
	
	@FindBy(xpath = "(//h5[normalize-space()='LIST OF FACULTIES'])[1]")
	private WebElement listoffaculties;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
	private WebElement Submit;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	Actions action = new Actions(driver);

	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1 ClickAcademicTest() {
		System.out.println("Click on Academic menu");
		action.moveToElement(Academic).build().perform();
		return this;
	}

	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1 ClickCordinatorRelatedTest() {
		System.out.println("Click Coordinator Related submenu");
		action.moveToElement(CoOrdinatorRelated).click().build().perform();
		return this;
	}

	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1 ClickCourseTeacherAllotmentTest() {
		System.out.println("Click on CourseTeacherAllotment");
		CourseTeacherAllotment.click();
		return this;
	}

	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1 SelectCollegeTest() {
		System.out.println("Select College -> CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");

		WebElement colg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlScheme"));
		Select typ_clog = new Select(colg);
		typ_clog.selectByVisibleText("CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");

		return this;
	}

	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1 SelectSessionTest() {
		System.out.println("Select Session -> May 2022");

		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSessionBulk"));
		Select typ_sessn = new Select(sessn);
		typ_sessn.selectByVisibleText("May 2022");

		return this;
	}

	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1 SelectSemesterTest() {
		System.out.println("Select Semester -> III");

		WebElement semester = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester"));
		Select typ_semester = new Select(semester);
		typ_semester.selectByVisibleText("III");

		return this;
	}

	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1 SelectCourseTest() {
		System.out.println("Select Course -> ARC 2107 - Allied Design Studio - III and Computer Graphics");

		WebElement course = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSubject"));
		Select typ_course = new Select(course);
		typ_course.selectByVisibleText("ARC 2107 - Allied Design Studio - III and Computer Graphics");

		return this;
	}

	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1 SelectDepartmentTest() {
		System.out.println("Select Department -> Crescent School of Architecture");

		WebElement dept = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddldepartment"));
		Select typ_dept = new Select(dept);
		typ_dept.selectByVisibleText("Crescent School of Architecture");

		return this;
	}
	
	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1 ClickShowButtonTest() {
		System.out.println("Click on Show Button");
		click(Show);
		return this;
	}
	
	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1 EnterSearchButtonTest() {
		System.out.println("Enter in Search => 2019186");

		Search.clear();
		Search.sendKeys("2019186");
		
		return this;
	}
	
	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1 SelectSectionTest() throws Throwable {
		System.out.println("Select Section");
		click(Section);
		Thread.sleep(2000);
		SearchSection.clear();
		SearchSection.sendKeys("A");
		
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", SectionCheckboxA);
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", SectionCheckboxA);

		click(listoffaculties);
		return this;
	}
	
	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1 ClickCheckBoxButtonTest() throws Exception {
		System.out.println("Click on Checkbox Button");
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", CheckBox);

		return this;
	}
	
	public AL_Academic_CR_CourseTeacherAllotmentFlow04_1 ClickSubmitButtonTest() throws Throwable {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].scrollIntoView();", Submit);
		
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", Submit);

		return this;
	}
	

}
