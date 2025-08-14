package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_CR_OC_ElectiveCoursesIntake extends BaseClass {

	public AL_Academic_CR_OC_ElectiveCoursesIntake(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(linkText = "Offered Courses")
	private WebElement offeredCourse_link;
	
	@FindBy(linkText = "Elective Courses Intake")
	private WebElement electiveCoursesIntake_tab;
	
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSessionIntake-container")
	private WebElement Session;

	@FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_updElectInt\"]/div/div[1]/div[2]/span/div/button/span")
	private WebElement Semester;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowElectIntake")
	private WebElement ShowCourse;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvElectIntakeCapacity_ctrl0_ChkElectIntake")
	private WebElement CheckBoxA;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmitIntake")
	private WebElement SubmitCapacity;

	@FindBy(className = "select2-search__field")
	private WebElement ddlSearchBox;

	
	public AL_Academic_CR_OC_ElectiveCoursesIntake click_offeredCourse() {
		System.out.println("Offered Courses");
		offeredCourse_link.click(); // ctl00_repLinks_ctl09_lbLink
		System.out.println("Course Registration Report page display");
		return this;
	}
	
	public AL_Academic_CR_OC_ElectiveCoursesIntake click_electiveCoursesIntake() {
		System.out.println("Elective Courses Intake");
		click(electiveCoursesIntake_tab); // ctl00_repLinks_ctl09_lbLink
		System.out.println("Course Registration Report page display");
		return this;
	}

	public AL_Academic_CR_OC_ElectiveCoursesIntake Session() {
		System.out.println("2023-2024");
		click(Session);
		sendKeys(ddlSearchBox,"2023-2024");
		ddlSearchBox.sendKeys(Keys.ENTER);
		return this;
	}

	public AL_Academic_CR_OC_ElectiveCoursesIntake Semester() {
		System.out.println("Select semister");
		click(Semester);
		driver.findElement(By.className("checkbox")).click();
		return this;
	}

	public AL_Academic_CR_OC_ElectiveCoursesIntake ShowCourse() {
		System.out.println("Click on Show Course");
		driver.findElement(By.xpath("//input[@class='live-search-box']")).click();
		System.out.println("ShowCourse");
		click(ShowCourse);
		return this;
	}

	public AL_Academic_CR_OC_ElectiveCoursesIntake ElectiveIntakeCourseList() {
		System.out.println("ElectiveIntakeCourseList -> EG001");
		click(CheckBoxA);
		return this;
	}

	public AL_Academic_CR_OC_ElectiveCoursesIntake SubmitCapacity() {
		System.out.println("SubmitCapacity");
		click(SubmitCapacity);
		return this;
	}
}
