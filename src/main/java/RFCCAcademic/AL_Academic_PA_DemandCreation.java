package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_PA_DemandCreation extends BaseClass{

	public AL_Academic_PA_DemandCreation(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(id = "ctl00_repLinks_ctl12_lbLink")
	private WebElement Demand_Creation_Link;

	@FindBy(linkText = "Demand Creation")
	private WebElement Demand_Creation;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession")
	private WebElement Session_dropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSchool")
	private WebElement School_dropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlReceiptType")
	private WebElement Receipt_Type;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree")
	private WebElement Degree_dropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranch")
	private WebElement Branch_dropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlForSemester")
	private WebElement Demand_Semester_dropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSelectSemester")
	private WebElement Semester_dropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlPaymentType")
	private WebElement Payment_Type_Dropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowStudents")
	private WebElement Show_Students_Button;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudents_ctrl0_chkSelect")
	private WebElement Sttudent_Checkbox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnCreateDemandForSelStuds")
	private WebElement Create_Demand_For_Sel_Students_Button;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowReport")
	private WebElement Show_Report_Button;

	@FindBy(xpath = "(//span[@id='select2-ctl00_ContentPlaceHolder1_ddlSession-container'])[1]")
	private WebElement searchsession;
	
	@FindBy(xpath = "(//input[@role='textbox'])[1]")
	private WebElement searchsessionDropdown;
	
	
	public AL_Academic_PA_DemandCreation click_Demand_Creation() {

		Demand_Creation.click();
		return this;
	}

	public AL_Academic_PA_DemandCreation select_Session() throws InterruptedException {
		System.out.println("Session -> May 2022");
		click(searchsession);
		Thread.sleep(2000);
		searchsessionDropdown.sendKeys("May 2022");
		searchsessionDropdown.sendKeys(Keys.ENTER);
//		Select session = new Select(Session_dropdown);
//		session.selectByVisibleText("May 2022 (  )");
		
		return this;
	}

	public AL_Academic_PA_DemandCreation select_School() {
		System.out.println("School => Crescent School of Law");
		Select clgdd = new Select(School_dropdown);
		clgdd.selectByVisibleText("Crescent School of Law");
		return this;
	}

	public AL_Academic_PA_DemandCreation select_Receipt_Type() throws InterruptedException {
		System.out.println("Receipt type => Admission Fee");
		Select Receipt = new Select(Receipt_Type);
		Receipt.selectByVisibleText("Admission Fee");
		System.out.println("Select -> Admission Fee");
		return this;
	}

	public AL_Academic_PA_DemandCreation select_Degree() throws InterruptedException {
		System.out.println("Degree => B.A. LL.B. (Hons.)");
		Select Deg = new Select(Degree_dropdown);
		Deg.selectByVisibleText("B.A. LL.B. (Hons.)");
		return this;
	}

	public AL_Academic_PA_DemandCreation select_Branch() throws InterruptedException {
		System.out.println("Branch => B.A. LL.B. (Hons.)");
		Select Progr = new Select(Branch_dropdown);
		Progr.selectByVisibleText("B.A. LL.B. (Hons.)");
		return this;
	}

	public AL_Academic_PA_DemandCreation select_Semester() throws InterruptedException {

		System.out.println("Semister => III");
		Select Semester = new Select(Semester_dropdown);
		Semester.selectByVisibleText("III");
		return this;
	}

	public AL_Academic_PA_DemandCreation select_Demand_Semester() throws InterruptedException {
		System.out.println("Demand Semister => III");
		Select Demand = new Select(Demand_Semester_dropdown);
		Demand.selectByVisibleText("III");
		return this;
	}

	public AL_Academic_PA_DemandCreation select_Payment_Type() throws InterruptedException {
		System.out.println("Payment type => General");
		Select Payment = new Select(Payment_Type_Dropdown);
		Payment.selectByVisibleText("General");
		return this;
	}
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public AL_Academic_PA_DemandCreation click_Show_Button() {
		System.out.println("Click on Show Students Under Selected Criteria");
		Show_Students_Button.click();
		return this;
	}

	public AL_Academic_PA_DemandCreation click_Student_Checkbox() {
		System.out.println("Click on List of Students -> CheckBox 1st");
		js.executeScript("arguments[0].scrollIntoView();",Show_Students_Button);
		js.executeScript("arguments[0].click();",Sttudent_Checkbox);
		return this;
	}

	public AL_Academic_PA_DemandCreation click_Demand_For_Selected_Students() {
		Create_Demand_For_Sel_Students_Button.click();
		System.out.println("Click on Create Demand for Selected Students"); 
		return this;
	}

	public AL_Academic_PA_DemandCreation click_show_Report_Button() {
		System.out.println("Click on show report btn");
		Show_Report_Button.click();
		return this;
	}
	
	
}
