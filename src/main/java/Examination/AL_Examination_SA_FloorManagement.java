package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Examination_SA_FloorManagement extends BaseClass{

	public AL_Examination_SA_FloorManagement(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Floor") private WebElement Floor_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ucmaster_btnSubmit") private WebElement submit_Button;
	
	@FindBy(xpath = "//*[@id=\"gvmaster_filter\"]/label/input") private WebElement search_txt;
	@FindBy(xpath = "//*[@id=\"gvmaster\"]/tbody/tr/td[1]/input") private WebElement edit_icon;
	
		
	public AL_Examination_SA_FloorManagement click_Floor() {
		Floor_Link.click();
		System.out.println("Floor submenu is selected");
		return this;
	}
	public AL_Examination_SA_FloorManagement search_floor() {
		sendKeys(search_txt,"First Floor");
		System.out.println("Floor -> First Floor");
		return this;
	}
	public AL_Examination_SA_FloorManagement edit_Floor() {
		click(edit_icon);
		System.out.println("Floor submenu is selected");
		return this;
	}
	
	public AL_Examination_SA_FloorManagement click_SubmitButton() {
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucmaster_btnSubmit"));
		btn_submit.click();
		System.out.println("submit");
		return this;
	}
	
	
	
}
