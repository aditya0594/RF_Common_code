package Examination;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_SA_Room extends BaseClass{

	public AL_Examination_SA_Room(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Room") private WebElement Room_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement College_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDept") private WebElement Department_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlFloorNo") private WebElement Floor_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBlockNo") private WebElement Block_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAssessment_ctrl0_txtRoomName") private WebElement RoomName_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAssessment_ctrl0_txtRoomCapacity") private WebElement RoomCapacity_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvAssessment_ctrl0_chkStatus") private WebElement Status_Checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement Submit_Button;


	public AL_Examination_SA_Room click_Room() {
		Room_Link.click();
		System.out.println("Click on Room");
		return this;
	}
	public AL_Examination_SA_Room select_College() {
		Select typ_colg = new Select (College_Dropdown);
		typ_colg.selectByVisibleText("Crescent School of Architecture");
		System.out.println("Click on School/Institute Name -> Crescent School of Architecture");
		return this;
	}
	public AL_Examination_SA_Room select_Department() {
		Select typ_Department = new Select (Department_Dropdown);
		typ_Department.selectByVisibleText("Crescent School of Architecture");
		System.out.println("click on Department -> Crescent School of Architecture");
		return this;
	}
	public AL_Examination_SA_Room select_Floor() {
		Select typ_Floor = new Select (Floor_Dropdown);
		typ_Floor.selectByVisibleText("First Floor");
		System.out.println("click on Floor -> First Floor");
		return this;
	}
	public AL_Examination_SA_Room select_Block() {
		Select typ_Block = new Select (Block_Dropdown);
		typ_Block.selectByVisibleText("Block-A");
		System.out.println("click on Block -> Block-A");
		return this;
	}
	public AL_Examination_SA_Room enter_RoomName() {
		RoomName_Inputbox.sendKeys(AL_Examination_SA_Room.getRandomRoomName());
		System.out.println("Click on Room Name ->Ground-Floor");
		return this;
	}
	public AL_Examination_SA_Room enter_RoomCapacity() {
		RoomCapacity_Inputbox.sendKeys("30");
		System.out.println("Click on Room Capacity -> 30");
		return this;
	}
	public AL_Examination_SA_Room check_Status_Checkbox() {
		Status_Checkbox.click();
		System.out.println("Click on Status -> Active OR Not Active");		
		return this;
	}
	public AL_Examination_SA_Room click_SubmitButton() {
		Submit_Button.click();
		System.out.println("Click on Submit");
		return this;
	}
	
	//code for generating random data
	public static String getRandomRoomName() {

		int number;
		Random random = new Random();
		number = random.nextInt(1000);
		String RanName = "Room "+number;
		return RanName;
		}

}
