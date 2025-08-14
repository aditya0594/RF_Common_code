package RFCCAcademic;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Academic_CR_CourseCreation extends BaseClass{

	public AL_Academic_CR_CourseCreation(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Course Creation")private WebElement courseCreation_tab;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDegree-container")private WebElement degree_dropdown;
	@FindBy(className = "select2-search__field")private WebElement searcfield;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDept-container")private WebElement department_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlBranch-container")private WebElement branch_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlScheme-container")private WebElement scheme_dropdown;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSem-container")private WebElement semester_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtCCode")private WebElement courseCode_inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtCourseName")private WebElement courseName;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlTP")private WebElement courseType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlParentDept")private WebElement academicCouncil;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTheory")private WebElement credits_input;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")private WebElement submit_btn;
	


	public AL_Academic_CR_CourseCreation click_courseCreation_Tab() {
		Actions action = new Actions(driver);
		action.moveToElement(courseCreation_tab);
		action.click().build().perform();
		System.out.println("Course Creation page display");
		return this;
	}
	public AL_Academic_CR_CourseCreation select_degree() {
		click(degree_dropdown);
		searcfield.sendKeys("Master of Business Administration",Keys.ENTER);
		System.out.println(" Degree - Master of Business Administration select ");
		return this;
	}
	public AL_Academic_CR_CourseCreation select_department() {
		click(department_dropdown);
		searcfield.sendKeys("Department of Management Studies",Keys.ENTER);
		System.out.println(" Department - Department of Management Studies select  ");
		return this;
	}
	public AL_Academic_CR_CourseCreation select_branch() {
		click(branch_dropdown);
		searcfield.sendKeys("Business Administration", Keys.ENTER);
		System.out.println(" Branch - Business Administration select ");
		return this;
	}
	public AL_Academic_CR_CourseCreation select_scheme() {
		click(scheme_dropdown);
		searcfield.sendKeys("MBA-Business Administration-2018-19-Department of Management Studies (Old Scheme)", Keys.ENTER);
		System.out.println(" Scheme type select ");
		return this;
	}
	public AL_Academic_CR_CourseCreation select_semester() {
		click(semester_dropdown);
		searcfield.sendKeys("IV", Keys.ENTER);
		System.out.println(" Semester - IV select ");
		return this;
	}
	public AL_Academic_CR_CourseCreation enter_courseCode() {
		String generatedName01 = RandomStringUtils.randomNumeric(4);
		String randomName01 = "AutoCode  "+generatedName01;
		courseCode_inputbox.sendKeys(randomName01); 
		System.out.println(" Course-code display ");
		return this;
	}
	public AL_Academic_CR_CourseCreation enter_courseName() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String generatedName = RandomStringUtils.randomNumeric(4);
		String randomName = "AutoCourseName "+generatedName;
		js.executeScript("arguments[0].value=arguments[1];", courseName, randomName);
		return this;
	}
	public AL_Academic_CR_CourseCreation select_courseType() {
		Select typ_course = new Select(courseType_dropdown);
		typ_course.selectByValue("3");
		return this;
	}
	public AL_Academic_CR_CourseCreation select_academicCouncil() {
		Select academic_council = new Select(academicCouncil);
		academic_council.selectByValue("2");
		return this;
	}
	public AL_Academic_CR_CourseCreation enter_credits() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3000)");
		credits_input.sendKeys("5");
		System.out.println(" Credits - select ");
		return this;
	}
	public AL_Academic_CR_CourseCreation click_submit_button() {
		click(submit_btn);
		System.out.println("Click on Submit button ");
		return this;
	}
	
}
