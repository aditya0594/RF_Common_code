package RFCCAcademic;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_CR_ARM_RoomMaster extends BaseClass
{
	public AL_Academic_CR_ARM_RoomMaster(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl08_lbLink") private WebElement AcademicRoomMaster;
	@FindBy(linkText = "Room Master") private WebElement roomMaster;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvroomintake_ctrl0_btneditRoomIntake") private WebElement editroomname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlfloor") private WebElement floorname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtintake") private WebElement roomIntake;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSaveRoom") private WebElement updatebtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_CR_ARM_RoomMaster Click_AcademicRoomMaster() throws InterruptedException {
		System.out.println("Click on Academic Room Master ==> Room Master");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",AcademicRoomMaster);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", AcademicRoomMaster);
		return this;
	}
	
	public AL_Academic_CR_ARM_RoomMaster Click_RoomMaster() throws InterruptedException {
		System.out.println("Click on Room Master");
		click(roomMaster);
		return this;
	}
	
	public AL_Academic_CR_ARM_RoomMaster Enter_EditRoomName() throws InterruptedException {
		
		click(editroomname);
		return this;
	}
	
	public AL_Academic_CR_ARM_RoomMaster Select_FloorName() throws InterruptedException {
		System.out.println("Select Floor Name => Floor-1st");
		Select select = new Select(floorname);
		select.selectByVisibleText("Floor-1st");
		return this;
	}
	
	public AL_Academic_CR_ARM_RoomMaster Enter_RoomIntake() throws InterruptedException {
		clearText(roomIntake);
//		int number;
//		Random random = new Random();
//		number = random.nextInt(10,30);
//		int RanName = number;  // String.valueOf(RanName)
//		System.out.println("Enter Room Intake =>"+ RanName);
//		roomIntake.sendKeys(String.valueOf(RanName));
//		return this;
		int number;
		Random random = new Random();
		number = random.nextInt(30 - 10) + 10; // Generates a number from 10 to 29
		int RanName = number;
		System.out.println("Enter Room Intake =>" + RanName);
		roomIntake.sendKeys(String.valueOf(RanName));
		return this;
	}
	
	public AL_Academic_CR_ARM_RoomMaster Click_UpdateBtn() throws InterruptedException {
		System.out.println("Click on Update btn");
		click(updatebtn);
		return this;
	}
}
