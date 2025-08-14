package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class FL_Academic_FR_AttendanceByFaculty extends BaseClass{
	
	public FL_Academic_FR_AttendanceByFaculty(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(id = "ctl00_repLinks_ctl01_lbLink")
	private WebElement AttendanceByFaculty_Link;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoCore")
	private WebElement Core_RadioButton;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlColgSession")
	private WebElement School_Dropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoRegular")
	private WebElement Regular_Radio_Button;
	
	@FindBy(linkText ="5")
	private WebElement date;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSubjectList_ctrl0_lnkbtnCourse")
	private WebElement Subject_Link;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl1_cbRow")
	private WebElement Checkbox;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement Submit_Button;

	public FL_Academic_FR_AttendanceByFaculty Click_AttendanceByFaculty_Link() {
		AttendanceByFaculty_Link.click();
		System.out.println("Attendance By Faculty");
		return this;
	}
	
	public FL_Academic_FR_AttendanceByFaculty Click_Core_RadioButton() {
		Core_RadioButton.click();
		return this;
	}
	
	public FL_Academic_FR_AttendanceByFaculty Select_School() {
		Select session = new Select(School_Dropdown);
		//session.selectByVisibleText("School of Social Sciences and Humanities-May 2022");
		session.selectByVisibleText("Crescent School of Architecture-2023-2024");
		//System.out.println("Session -> School of Social Sciences and Humanities-May 2022");
		System.out.println("Session -> Crescent School of Architecture-2023-2024");
		return this;
	}
	
	public FL_Academic_FR_AttendanceByFaculty Click_Regular_RadioButton() {
		System.out.println("Attendance for -> Regular");
		Regular_Radio_Button.click();	
		return this;
	}
	
	public FL_Academic_FR_AttendanceByFaculty Select_Date() {
		System.out.println("Click on Subject to mark attendance");
		date.click();
		return this;
	}
	
	public FL_Academic_FR_AttendanceByFaculty Click_Subject_Details() {
		System.out.println("click on subject details");
		Subject_Link.click();
		return this;
	}
	
	public FL_Academic_FR_AttendanceByFaculty Click_Checkbox() {
		System.out.println("Click on Checkbox");
		Checkbox.click();
		return this;
	}
	
	public FL_Academic_FR_AttendanceByFaculty Click_Submit_Button() {
		WebElement submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		submit.click();
		return this;
	}
	
}
