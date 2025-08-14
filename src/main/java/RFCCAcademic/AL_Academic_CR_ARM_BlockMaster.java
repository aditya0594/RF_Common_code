package RFCCAcademic;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_CR_ARM_BlockMaster extends BaseClass
{
	public AL_Academic_CR_ARM_BlockMaster(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl08_lbLink") private WebElement AcademicRoomMaster;
	@FindBy(linkText = "Block Master") private WebElement blockMaster;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvBlock_ctrl0_btnEditBlock") private WebElement editblockname;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSaveBlock") private WebElement updatebtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_CR_ARM_BlockMaster Click_AcademicRoomMaster() throws InterruptedException {
		System.out.println("Click on Academic Room Master");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",AcademicRoomMaster);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", AcademicRoomMaster);
		return this;
	}
	
	public AL_Academic_CR_ARM_BlockMaster Click_BlockMaster() throws InterruptedException {
		System.out.println("Click on Block Master");
		click(blockMaster);
		return this;
	}
	
	public AL_Academic_CR_ARM_BlockMaster Enter_EditBlockName() throws InterruptedException {
		
		click(editblockname);
		return this;
	}
	
	public AL_Academic_CR_ARM_BlockMaster Click_UpdateBtn() throws InterruptedException {
		System.out.println("Click on Update btn");
		click(updatebtn);
		return this;
	}
}
