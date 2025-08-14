package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Academic_CR_FacultyAdvisorAllotment extends BaseClass{
	
	public AL_Academic_CR_FacultyAdvisorAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_repLinks_ctl19_lbLink") private WebElement FacultyAdvisorAllotment_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollegeName") private WebElement College_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement Degree_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester") private WebElement Semester_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranch") private WebElement Branch_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement Show_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvFaculty_ctrl0_cbRow") private WebElement Student1;
	@FindBy(id = "example_filter") private WebElement student1_checkbox;
	@FindBy(xpath = "//h5[text()='Student List']") private WebElement studentlist;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvFaculty_ctrl1_cbRow") private WebElement Student2;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvFaculty_ctrl2_cbRow") private WebElement Student3;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvFaculty_ctrl4_cbRow") private WebElement Student4;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvFaculty_ctrl5_cbRow") private WebElement Student5;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement ScrollShowBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDeptName") private WebElement DeptName_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAdvisor") private WebElement Advisor_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAssignFA0") private WebElement Assign_Button;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public AL_Academic_CR_FacultyAdvisorAllotment click_FacultyAdvisorAllotment() {
		
		js.executeScript("arguments[0].scrollIntoView();", FacultyAdvisorAllotment_Link);
		FacultyAdvisorAllotment_Link.click();
		System.out.println("Click on Faculty Advisor Allotment from sub menu");
		return this;
	}
	
	public AL_Academic_CR_FacultyAdvisorAllotment select_SchoolInstitute() {
		Select clg = new Select (College_Dropdown);
		clg.selectByVisibleText("Crescent School of Business - Chennai");
		System.out.println("Select School/institute -> Crescent School of Business - Chennai");
		return this;
	}
	
	public AL_Academic_CR_FacultyAdvisorAllotment select_Degree() {
		Select degree = new Select (Degree_Dropdown);
		degree.selectByVisibleText("Master of Business Administration");
		System.out.println("Select degree -> Master of Business Administration");
		return this;
	}
	
	public AL_Academic_CR_FacultyAdvisorAllotment select_Branch() {
		Select branch = new Select (Branch_Dropdown);
		branch.selectByVisibleText("Business Administration");
		System.out.println("Select branch -> Business Administration");
		return this;
	}
	
	public AL_Academic_CR_FacultyAdvisorAllotment select_Semester() {
		Select sem = new Select (Semester_Dropdown);
		sem.selectByVisibleText("IV");
		System.out.println("Select semester -> IV");
		return this;
	}
	
	public AL_Academic_CR_FacultyAdvisorAllotment click_ShowStudent() {
		Show_Button.click();
		System.out.println("Click on Show student Button");
		return this;
	}
	
	public AL_Academic_CR_FacultyAdvisorAllotment click_Student1() {
		System.out.println("Click on checkbox of student1");
		//WebElement Scroll1 = driver.findElement(By.id("example_filter")); // ID of last
		js.executeScript("arguments[0].scrollIntoView();", studentlist);
		Student1.click();
		
		return this;
	}
	
	public AL_Academic_CR_FacultyAdvisorAllotment click_Student2() {
		System.out.println("Click on checkbox of student 2 ");
		Student2.click();
		return this;
	}
	
	
//	public AL_Academic_CR_FacultyAdvisorAllotment scrollUp() {
//		WebElement ScrollUp = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")); // ID of last
//		js.executeScript("arguments[0].scrollIntoView();", ScrollUp);
//		return this;
//	}
	
	public AL_Academic_CR_FacultyAdvisorAllotment click_Student3() {
		js.executeScript("window.scrollBy(0,4000)");
		Student3.click();
		System.out.println("Click on checkbox of student3");
		return this;
	}
	
	public AL_Academic_CR_FacultyAdvisorAllotment click_Student4() {
		Student4.click();
			System.out.println("Click on checkbox of student4");
		return this;
	}
	
	public AL_Academic_CR_FacultyAdvisorAllotment click_Student5() {
		Student5.click();
		System.out.println("Click on checkbox of student5");
		return this;
	}
	
	public AL_Academic_CR_FacultyAdvisorAllotment scroll_To_Show_Btn() {
		//WebElement ScrollUp = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")); // ID of last
		js.executeScript("arguments[0].scrollIntoView();", ScrollShowBtn);
		return this;
	}
	
	public AL_Academic_CR_FacultyAdvisorAllotment Select_Department() throws InterruptedException {
		System.out.println("Select Department => Department of Management Studies");
		scroll_To_Show_Btn();
		threadWait1();
		Select dpt = new Select (driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDeptName")));
		dpt.selectByVisibleText("Department of Management Studies");
		Thread.sleep(2000);
		return this;
	}
	
	public AL_Academic_CR_FacultyAdvisorAllotment select_FacultyAdvisor() {
		scroll_To_Show_Btn();
		Select fa = new Select (Advisor_Dropdown);
//		fa.selectByVisibleText(" PRASANNA  S-2021020");
		fa.selectByValue("551");
		System.out.println("Select Faculty Advisor ->  PRASANNA  S-2021020");
		return this;
	}

	public AL_Academic_CR_FacultyAdvisorAllotment click_AssignButton() {
		scroll_To_Show_Btn();
		Assign_Button.click();
		System.out.println("Click on Assign FA button");
		return this;
	}
}
