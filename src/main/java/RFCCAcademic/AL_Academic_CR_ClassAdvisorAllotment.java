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

public class AL_Academic_CR_ClassAdvisorAllotment extends BaseClass{

	public AL_Academic_CR_ClassAdvisorAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "ACADEMIC")
	private WebElement Academic;

	@FindBy(linkText = "Coordinator Related")
	private WebElement CoOrdinatorRelated;

	@FindBy(id = "ctl00_repLinks_ctl03_lbLink")
	private WebElement ClassAdvisorAllotment;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowClass")
	private WebElement ShowStudent;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvClassAdv_cbHead")
	private WebElement CheckBox;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReportClass")
	private WebElement ReportExcel;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnClassAdvisor")
	private WebElement AssignAdvisor;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	Actions action = new Actions(driver);

	public AL_Academic_CR_ClassAdvisorAllotment ClickCordinatorRelatedTest() {
		System.out.println("Click Coordinator Related submenu");
		action.moveToElement(CoOrdinatorRelated).click().build().perform();
		return this;
	}

	public AL_Academic_CR_ClassAdvisorAllotment ClickClassAdvisorAllotmentTest() {
		System.out.println("Click on Class Advisor Allotment");
		ClassAdvisorAllotment.click();
		return this;
	}

	public AL_Academic_CR_ClassAdvisorAllotment SelectInstituteTest() {
		System.out.println("Select Institute -> ");

		WebElement institute = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollegeNameClass"));
		Select typ_institute = new Select(institute);
		typ_institute.selectByVisibleText("Crescent School of Architecture - Chennai");

		return this;
	}
	
	public AL_Academic_CR_ClassAdvisorAllotment SelectDepartmentTest() {
		System.out.println("Select Department -> Crescent School of Architecture");

		WebElement dept = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlAssignDept"));
		Select typ_dept = new Select(dept);
		typ_dept.selectByVisibleText("Crescent School of Architecture");

		return this;
	}
	
	public AL_Academic_CR_ClassAdvisorAllotment SelectDegreeTest() {
		System.out.println("Select Degree -> ");

		WebElement degree = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDegreeClass"));
		Select typ_degree = new Select(degree);
		typ_degree.selectByVisibleText("Bachelor of Architecture");

		return this;
	}

	public AL_Academic_CR_ClassAdvisorAllotment SelectProgramTest() {
		System.out.println("Select Program -> ");

		WebElement prog = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlBranchClass"));
		Select typ_prog = new Select(prog);
		typ_prog.selectByVisibleText("Architecture");

		return this;
	}

	public AL_Academic_CR_ClassAdvisorAllotment SelectSemesterTest() {
		System.out.println("Select Semester -> I");

		WebElement semester = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemesterClass"));
		Select typ_semester = new Select(semester);
		typ_semester.selectByVisibleText("I");

		return this;
	}

	public AL_Academic_CR_ClassAdvisorAllotment SelectTeacherDepartmentTest() {
		System.out.println("Select Department -> Crescent School of Architecture");

		WebElement dept = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDeptNameClass"));
		Select typ_dept = new Select(dept);
		typ_dept.selectByVisibleText("Crescent School of Architecture");

		return this;
	}
	
	public AL_Academic_CR_ClassAdvisorAllotment SelectClassAdvisorTest() {
		System.out.println("Select Class Advisor -> HEMA  PRITHIKKA-2019186");

		WebElement advisor = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlAdvisorClass"));
		Select class_advisor = new Select(advisor);
		class_advisor.selectByVisibleText("HEMA PRITHIKKA-2019186");

		return this;
	}
	
	public AL_Academic_CR_ClassAdvisorAllotment ClickShowStudentButtonTest() {
		System.out.println("Click on Show Student Button");
		click(ShowStudent);
		return this;
	}
	
	public AL_Academic_CR_ClassAdvisorAllotment ReportExcelButtonTest() {
		System.out.println("Click on Report Excel Button");
		ReportExcel.click();
		return this;
	}
	
	public AL_Academic_CR_ClassAdvisorAllotment ClickCheckBoxButtonTest() throws Exception {
		System.out.println("Click on Checkbox Button");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", CheckBox);
		Thread.sleep(2000);
		click(CheckBox);
		return this;
	}
	
	public AL_Academic_CR_ClassAdvisorAllotment AssignClassAdvisorButtonTest() {
		System.out.println("Click on Assign Class Advisor Button");
		click(AssignAdvisor);
		return this;
	}
	
}
