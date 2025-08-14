package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_SA_RoomConfiguration extends BaseClass{

	public AL_Examination_SA_RoomConfiguration(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Room Configuration") private WebElement RoomConfiguration_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlRoom") private WebElement Room_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRows") private WebElement Row_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtColumns") private WebElement Column_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtActual") private WebElement ActualCapacity_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnConfigure") private WebElement Configure_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement Save_Button;
	
	
	public AL_Examination_SA_RoomConfiguration click_RoomConfiguration_Link() {
		RoomConfiguration_Link.click();
		System.out.println("Room Configuration submenu is selected");
		return this;
	}
	public AL_Examination_SA_RoomConfiguration Select_Room() {
		Select rmConfig_typ = new Select(Room_Dropdown);
		rmConfig_typ.selectByVisibleText("Crescent-L");
		System.out.println("Room-> Crescent Cret-Law");
		return this;
	}
	public AL_Examination_SA_RoomConfiguration enter_Row() {
		Row_Inputbox.clear();
		Row_Inputbox.sendKeys("3");
		System.out.println("Row->3");
		return this;
	}
	public AL_Examination_SA_RoomConfiguration enter_Column() {
		Column_Inputbox.clear();
		Column_Inputbox.sendKeys("10");
		System.out.println("colum -> 10");
		return this;
	}
	public AL_Examination_SA_RoomConfiguration click_ConfigureButton() {
		Configure_Button.sendKeys(Keys.ENTER);
		System.out.println("click Configure");
		return this;
	}
	public AL_Examination_SA_RoomConfiguration click_SaveButton() {
		Save_Button.sendKeys(Keys.ENTER);
		System.out.println("click->save");
		return this;
	}
	
}
