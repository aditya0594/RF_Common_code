package Administration;

import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Administration_VM_Trans_CollegeVehicleDailyAttendance extends BaseClass
{
	public AL_Administration_VM_Trans_CollegeVehicleDailyAttendance(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Web elements with provided locators
	@FindBy(linkText = "College Vehicle Daily Attendance") private WebElement collegeVehicleDailyAttendanceLink;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlVehicle") private WebElement vehicleDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDriverCond") private WebElement driverCondDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_chkAttendance") private WebElement attendanceCheckbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtStudentCount") private WebElement studentCountField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtStaffCount") private WebElement staffCountField;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd") private WebElement addBtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitBtn;
	@FindBy(xpath = "(//span[@id='select2-ctl00_ContentPlaceHolder1_ddlVehicle-container'])[1]") private WebElement selectVehicle;
	@FindBy(xpath = "(//input[@role='textbox'])[1]") private WebElement SearchBox;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDriverCond-container") private WebElement selectDriver;

	
	// Random number generator for student and staff counts
	private Random random = new Random();
	
	/**
	 * Click on College Vehicle Daily Attendance link
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_CollegeVehicleDailyAttendance Click_CollegeVehicleDailyAttendanceLink() throws Exception {
		System.out.println("Click on College Vehicle Daily Attendance link");
		js.executeScript("arguments[0].scrollIntoView();", collegeVehicleDailyAttendanceLink);
		js.executeScript("arguments[0].click();", collegeVehicleDailyAttendanceLink);
		return this;
	}
	
	/**
	 * Select Vehicle from dropdown
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_CollegeVehicleDailyAttendance Select_Vehicle() throws Exception {
		System.out.println("Select Vehicle => Bharat Benz");
		selectVehicle.click();
		Thread.sleep(2000);
		SearchBox.sendKeys("Bharat Benz");
		SearchBox.sendKeys(Keys.ENTER);
		return this;
	}
	
	/**
	 * Select Driver/Conductor from dropdown
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_CollegeVehicleDailyAttendance Select_DriverConductor() throws Exception {
		System.out.println("Select Driver/Conductor => Amisha patel | 9879879510 | MH 31 5784524");
		selectDriver.click();
		Thread.sleep(2000);
		SearchBox.sendKeys("Amisha patel | 9879879510 | MH 31 5784524");
		SearchBox.sendKeys(Keys.ENTER);
		return this;
	}
	
	/**
	 * Click on Attendance Mark Checkbox
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_CollegeVehicleDailyAttendance Click_AttendanceCheckbox() throws Exception {
		System.out.println("Click on Attendance Mark Checkbox");
		if (!attendanceCheckbox.isSelected()) {
			js.executeScript("arguments[0].click();", attendanceCheckbox);
		}
		return this;
	}
	
	/**
	 * Enter random student count between 5-30
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_CollegeVehicleDailyAttendance Enter_StudentCount() throws Exception {
		int studentCount = random.nextInt(26) + 5; // Random number between 5-30
		System.out.println("Enter Student Count => " + studentCount);
		studentCountField.clear();
		studentCountField.sendKeys(String.valueOf(studentCount));
		return this;
	}
	
	/**
	 * Enter random staff count between 5-10
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_CollegeVehicleDailyAttendance Enter_StaffCount() throws Exception {
		int staffCount = random.nextInt(6) + 5; // Random number between 5-10
		System.out.println("Enter Staff Count => " + staffCount);
		staffCountField.clear();
		staffCountField.sendKeys(String.valueOf(staffCount));
		return this;
	}
	
	/**
	 * Click on Add Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_CollegeVehicleDailyAttendance Click_AddBtn() throws Exception {
		System.out.println("Click on Add Button");
		js.executeScript("arguments[0].click();", addBtn);
		return this;
	}
	
	/**
	 * Click on Submit Button
	 * @return instance of this class
	 * @throws Exception if operation fails
	 */
	public AL_Administration_VM_Trans_CollegeVehicleDailyAttendance Click_SubmitBtn() throws Exception {
		System.out.println("Click on Submit Button");
		js.executeScript("arguments[0].click();", submitBtn);
		return this;
	}
}
