package Establishment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Payroll.AL_Payroll_Trans_MW_SalaryRemark;
import utility.BaseClass;

public class AL_Establishment_Trans_AssignDefaultShift extends BaseClass{

	public AL_Establishment_Trans_AssignDefaultShift(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	Actions action;

	@FindBy(linkText = "Assign Default Shift")
	private WebElement AssignDefaultShift_Link;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege")
	private WebElement College_dropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStafftype")
	private WebElement StaffType_dropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlShift")
	private WebElement ShiftType_Dropdown;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_chkID")
	private WebElement StudentList_Link;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave")
	private WebElement Save_Button;
	
	public AL_Establishment_Trans_AssignDefaultShift Click_AssignDefaultShift() {
		WebElement link_ADS = driver.findElement(By.linkText("Assign Default Shift"));
		link_ADS.click();
		System.out.println("click on Assign Default Shift");
		return this;
	}
	
	public AL_Establishment_Trans_AssignDefaultShift Select_College() {
		Select typ_colg = new Select(College_dropdown);
		typ_colg.selectByVisibleText("Crescent School of Architecture");
		System.out.println("College Name -> Crescent School of Architecture Selected");
		return this;
	}
	
	public AL_Establishment_Trans_AssignDefaultShift Select_StaffType() {
		Select typ_staff = new Select(StaffType_dropdown);
		typ_staff.selectByVisibleText("Technical NTS");
		System.out.println("Staff Type - > Technical NTS");
		return this;
	}
	
	public AL_Establishment_Trans_AssignDefaultShift Select_ShiftType() {
		Select typ_shift = new Select(ShiftType_Dropdown);
		typ_shift.selectByVisibleText("NIGHT SHIFT");
		System.out.println("select Shift - > NIGHT SHIFT");
		return this;
	}
	
	public AL_Establishment_Trans_AssignDefaultShift Click_Student_Link() {
		StudentList_Link.click();
		System.out.println("Select Atleast One employee -> [2022056] - PRIYA P ");
		return this;
	}
	
	public AL_Establishment_Trans_AssignDefaultShift Click_Submit_Button() {
		Save_Button.click();
		System.out.println("Click on Assign button");
		return this;
	}
	
	
	
	
	
	
	
}
