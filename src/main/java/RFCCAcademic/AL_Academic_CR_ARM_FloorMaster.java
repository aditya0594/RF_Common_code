package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_CR_ARM_FloorMaster extends BaseClass
{
	public AL_Academic_CR_ARM_FloorMaster(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl08_lbLink") private WebElement AcademicRoomMaster;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvfloor_ctrl0_btnEdit") private WebElement editbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement updatebtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_CR_ARM_FloorMaster Click_AcademicRoomMaster() throws InterruptedException {
		System.out.println("Click on Academic Room Master ==> Floor Master");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",AcademicRoomMaster);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", AcademicRoomMaster);
		return this;
	}
	
	public AL_Academic_CR_ARM_FloorMaster Enter_EditBtn() throws InterruptedException {
		System.out.println("Click on EDit btn");
		click(editbtn);
		return null;
		
	}
	
	public AL_Academic_CR_ARM_FloorMaster Click_UpdateBtn() throws InterruptedException {
		System.out.println("Click on Update btn");
		click(updatebtn);
		return this;
	}
}
