package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_Results_PublishResult extends BaseClass{

	public AL_Examination_Results_PublishResult(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	Actions action = new Actions(driver);
	
	@FindBy(linkText = "Publish Result") private WebElement PublishResult_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClgname") private WebElement College_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement Session_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSem") private WebElement Semester_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlExamType") private WebElement ExamType_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtDateOfPublish") private WebElement PublishDate_Calender;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement Show_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_chkStudent") private WebElement search_chk_Checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnPublish") private WebElement PublishResult_Button;
	

	public AL_Examination_Results_PublishResult click_PublishResult() {
		System.out.println("Publish Result submenu selected");
		action.moveToElement(PublishResult_Link);
		action.click().build().perform();
		return this;
	}

	public AL_Examination_Results_PublishResult select_College() {
		Select Clg = new Select(College_Dropdown);
		System.out.println("College -> SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		Clg.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		return this;
	}

	public AL_Examination_Results_PublishResult select_Session() {
		Select Sess = new Select(Session_Dropdown);
		System.out.println("Session -> DEC 2021");
		Sess.selectByVisibleText("DEC 2021");
		return this;
	}

	public AL_Examination_Results_PublishResult select_Semester() {
		Select Sem = new Select(Semester_Dropdown);
		System.out.println("Semester -> III");
		Sem.selectByVisibleText("III");
		return this;
	}

	public AL_Examination_Results_PublishResult select_StudentType() {
		Select ST = new Select(ExamType_Dropdown);
		System.out.println("StudentType -> Regular");
		ST.selectByVisibleText("Regular");
		return this;
	}

	public AL_Examination_Results_PublishResult select_PublishDate() throws InterruptedException {
		PublishDate_Calender.click();
		Thread.sleep(2000);
		PublishDate_Calender.sendKeys("31/01/2025");
		System.out.println("Publish Date -> 31/01/2025");
		return this;
	}

	public AL_Examination_Results_PublishResult click_Show_Button() {
		Show_Button.click();
		System.out.println("click on Show Button");
		return this;
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	public AL_Examination_Results_PublishResult Search_CheckBox() {
		System.out.println("Search Student with reg.no => 200011601001");
		WebElement searchTb2 = driver.findElement(By.xpath("//input[@class='form-control form-control-sm']"));
		searchTb2.sendKeys("200011601001");
		
		System.out.println("Click to Check Box");

		js.executeScript("arguments[0].scrollIntoView();",search_chk_Checkbox);

		search_chk_Checkbox.click();
		return this;
	}

	public AL_Examination_Results_PublishResult click_PublishResult_Button() {
		PublishResult_Button.click();
		System.out.println("Click on Publish btn");
		return this;
	}
	
	
	public AL_Examination_Results_PublishResult Click_UncheckBox() throws InterruptedException {
		System.out.println("Click to Uncheck Box ");
		WebElement searchTb2 = driver.findElement(By.xpath("//input[@class='form-control form-control-sm']"));
		searchTb2.sendKeys("200011601001");
		System.out.println("Search Student with reg.no => 200011601001");
		Thread.sleep(5000);;
		
		Thread.sleep(5000); 
		WebElement unchk = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_ctrl0_chkStudent"));
		unchk.click();
		Thread.sleep(5000);
		return this;
	}
	
	public AL_Examination_Results_PublishResult Click_UnPublishResultBtn() throws InterruptedException {
		System.out.println("Click on UnPublish Result btn");
		WebElement unpublishresultbtn = driver.findElement(By.xpath("(//input[@id='ctl00_ContentPlaceHolder1_btnUnpublish'])[1]"));
		unpublishresultbtn.click();
		Thread.sleep(5000);;
		acceptAlert();
		return this;
	}

	
}
