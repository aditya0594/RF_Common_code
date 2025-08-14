package Examination;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Examination_SA_BlockManagement extends BaseClass{

	public AL_Examination_SA_BlockManagement(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Block") private WebElement Block_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ucmaster_txtColumn0") private WebElement Block_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ucmaster_chkColumn1") private WebElement Checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ucmaster_btnSubmit") private WebElement Submit_Button;
	
	public AL_Examination_SA_BlockManagement click_Block() {
		Block_Link.click();
		System.out.println("Block submenu is selected");
		return this;
	}
	
	public AL_Examination_SA_BlockManagement enter_Block() {
		String block = AL_Examination_SA_BlockManagement.getRandomMobileNumber();
//		Block_Inputbox.sendKeys("Wing-M");
//		System.out.println("Block -> Wing-M");
		Block_Inputbox.sendKeys(block);
		System.out.println("Block ->" +block);
		return this;
	}
	
	public AL_Examination_SA_BlockManagement click_Checkbox() {
		if (!Checkbox.isSelected() == true) {
			Checkbox.click();
		}
		System.out.println("Checkbox-->Checked");
		return this;
	}
	
	public AL_Examination_SA_BlockManagement click_SubmitButton() {
		Submit_Button.click();
		System.out.println("submit");
		return this;
	}
	
	public static String getRandomMobileNumber() {

		int number;
		Random random = new Random();
		number = random.nextInt(1000);
		String RanName = "Wing "+number;
		return RanName;
		}
	
}
