package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_COE_BundleCreation3 extends BaseClass{

	public AL_Examination_COE_BundleCreation3(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl06_lbLink") private WebElement BundleCreation_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement College_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement Session_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDate") private WebElement Date_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSlot") private WebElement Slot_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtStudPerBundle") private WebElement NoOfAnsBookPerBundle_Input;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCourse") private WebElement Course_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement Submit_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnDateWiseReport") private WebElement DataWiseBundleList_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement Report_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnStickerReport") private WebElement BundleSlipReport_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAck") private WebElement AcknowledgementReport_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnExcel") private WebElement ExcelReport_Button;
	
	
	public AL_Examination_COE_BundleCreation3 click_BundleCreation_Link() {
		Actions action2 = new Actions(driver);
		action2.moveToElement(BundleCreation_Link);
		action2.click().build().perform();
		System.out.println("Hover on Conduction of Bundle Creation in Navigation Bar");
		return this;
	}
	public AL_Examination_COE_BundleCreation3 select_College() {
		Select clg = new Select(College_Dropdown);
		System.out.println("CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");
		clg.selectByVisibleText("CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");
		return this;
	}
	public AL_Examination_COE_BundleCreation3 select_Session() {
		Select Sess = new Select(Session_Dropdown);
		System.out.println("Session -> May 2022"); 
		Sess.selectByVisibleText("May 2022");
		return this;
	}
	public AL_Examination_COE_BundleCreation3 select_Date() {
		Select ED = new Select(Date_Inputbox);
		System.out.println("ExamDate -> 01/12/2023");
		ED.selectByVisibleText("01/12/2023");
		return this;
	}
	public AL_Examination_COE_BundleCreation3 select_Slot() {
		Select ES = new Select(Slot_Dropdown);
		System.out.println("ExamSlot -> FN");
		ES.selectByVisibleText("FN");
		return this;
	}
	public AL_Examination_COE_BundleCreation3 enter_NoOfAnsBookPerBundle() {
		NoOfAnsBookPerBundle_Input.sendKeys("30");
		return this;
	}
	public AL_Examination_COE_BundleCreation3 select_Course() {
		Select Course = new Select(Course_Dropdown);
		System.out.println("CourseName -> ARC B 1203 - Theory and Design of Structures - I - B.Arch. - II");
		Course.selectByVisibleText("ARC B 1203 - Theory and Design of Structures - I - B.Arch. - II");
		return this;
	}
	public AL_Examination_COE_BundleCreation3 click_Submit_Button() {
		System.out.println("Click on Submit");
		Submit_Button.click();
		return this;
	}
	public AL_Examination_COE_BundleCreation3 click_DataWiseBundleList_Button() {
		System.out.println("Click on Date-Wise BundleReport");
		DataWiseBundleList_Button.click();
		return this;
	}
	public AL_Examination_COE_BundleCreation3 click_Report_Button() {
		System.out.println("Click on Report");
		Report_Button.click();
		return this;
	}
	public AL_Examination_COE_BundleCreation3 click_BundleSlipReport_Button() {
		System.out.println("click on Bundle Slip Report");
		BundleSlipReport_Button.click(); 
		return this;
	}
	public AL_Examination_COE_BundleCreation3 click_AcknowledgementReport_Button() {
		System.out.println("click on Acknowledgement Receipt");
		AcknowledgementReport_Button.click();
		return this;
	}
	public AL_Examination_COE_BundleCreation3 click_ExcelReport_Button() {
		System.out.println("click on Excel Report");
		ExcelReport_Button.click();
		return this;
	}
	
	
}
