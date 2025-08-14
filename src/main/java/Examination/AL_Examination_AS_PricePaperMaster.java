package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_AS_PricePaperMaster extends BaseClass{

	public AL_Examination_AS_PricePaperMaster(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement Degree_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtPerUnit") private WebElement Unit_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement Submit_Button;
	

	public AL_Examination_AS_PricePaperMaster select_Degree() {
		Select degree_typ = new Select(Degree_Dropdown);
		degree_typ.selectByVisibleText("Bachelor of Science");
		System.out.println("Click on Degree Dropdown Field");
		System.out.println("Degree is: Bachelor of Science");
		return this;
	}
	public AL_Examination_AS_PricePaperMaster enter_Unit() {
		Unit_Dropdown.sendKeys("20");
		System.out.println("Enter Per Unit Price");
		System.out.println("Per Unit Price is: 20");
		return this;
	}
	public AL_Examination_AS_PricePaperMaster click_SubmitButton() {
		Submit_Button.click();
		System.out.println("Click on Submit button");
		return this;
	}
	

}
