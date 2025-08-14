package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_COE_DecodNoGeneration extends BaseClass{

	public AL_Examination_COE_DecodNoGeneration(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl05_lbLink") private WebElement DecodeNoGeneration_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClgScheme") private WebElement College_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement Session_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlsemester") private WebElement Semester_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCourse") private WebElement Course_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlNumType") private WebElement NumberType_Dropdown;
	@FindBy(xpath = "//button[@class='multiselect btn btn-default']") private WebElement SearchStdudenttype;
	@FindBy(xpath = "//input[@value='multiselect-all']") private WebElement SelectStdudenttype;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement Show_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnGenNo") private WebElement GenerateNo_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnStatDecode") private WebElement ShowGenerated_Button;
	@FindBy(id = "CLOSEimg") private WebElement close;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnNotGenDe") private WebElement ShowNotGenerated_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnExcel") private WebElement RolllistExcelReport_Button;
	
	Actions action2 = new Actions(driver);

	public AL_Examination_COE_DecodNoGeneration click_DecodeNoGeneration_Link() {
		action2.moveToElement(DecodeNoGeneration_Link);
		action2.click().build().perform();
		System.out.println("Click Decode No. Generation");
		return this;
	}
	public AL_Examination_COE_DecodNoGeneration select_College() {
		Select clg = new Select(College_Dropdown);
		System.out.println("College -> CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");
		clg.selectByVisibleText("CSA - B. Arch-Architecture-2016-17-Crescent School of Architecture (Old Scheme)");
		return this;
	}
	public AL_Examination_COE_DecodNoGeneration select_Session() {
		Select Sess = new Select(Session_Dropdown);
		System.out.println("Session -> May 2022");
		Sess.selectByVisibleText("May 2022");
		return this;
	}
	public AL_Examination_COE_DecodNoGeneration select_Semester() {
		Select Sem = new Select(Semester_Dropdown);
		System.out.println("Semester -> IV");
		Sem.selectByVisibleText("IV");
		return this;
	}
	public AL_Examination_COE_DecodNoGeneration select_Course() {
		Select crse = new Select(Course_Dropdown);
		System.out.println("Course ->ARC B 2401 - History of Built Environment - III ");
		crse.selectByVisibleText("ARC B 2401 - History of Built Environment - III");
		return this;
	}
	public AL_Examination_COE_DecodNoGeneration select_NumberType() {
		Select No = new Select(NumberType_Dropdown);
		System.out.println("Number Type -> Decode Number");
		No.selectByVisibleText("Decode Number");
		return this;
	}
	
	public AL_Examination_COE_DecodNoGeneration Select_StudentType() {
		System.out.println("Select Student Type -> All");
		SearchStdudenttype.click();
		SelectStdudenttype.click();
		return this;
	}
	
	public AL_Examination_COE_DecodNoGeneration click_Show_Button() {
		System.out.println("click on Show Button");
		Show_Button.click();
		return this;
	}
	public AL_Examination_COE_DecodNoGeneration click_GenerateNo_Button() {
		System.out.println("click on Generate Number");
		GenerateNo_Button.click();
		return this;
	}

	public AL_Examination_COE_DecodNoGeneration click_RolllistExcelReport_Button() {
		RolllistExcelReport_Button.click();
		return this;
	}

}
