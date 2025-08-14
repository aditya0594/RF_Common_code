package Examination;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Examination_Results_ResultProccessing extends BaseClass {

	public AL_Examination_Results_ResultProccessing(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Result Processing") private WebElement ResultProcessing_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClgname") private WebElement College_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement Session_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSem") private WebElement Semester_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStudentType") private WebElement StudentType_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement Show_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_chkheader") private WebElement StudentList_Checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnProcessResult") private WebElement ProcessResult_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_chkheader") private WebElement StudentListAll_Checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnLock") private WebElement Lock_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnUnlock") private WebElement unlockbtn;


	public AL_Examination_Results_ResultProccessing click_ResultProcessing() {
		ResultProcessing_Link.click();
		System.out.println("Click on Result Processing");
		return this;
	}

	public AL_Examination_Results_ResultProccessing select_College() {
		System.out.println("select college & Scheme");
		Select colg_typ = new Select(College_Dropdown);
		colg_typ.selectByVisibleText("SLS - B.Tech.-School of Life Sciences-Biotechnology-2017-18 (Old Scheme)");
		System.out.println("College is: SLS - BTech-School of Life Sciences-Biotechnology-2021-22 (New Scheme)");
		return this;
	}

	public AL_Examination_Results_ResultProccessing select_Session() {
		System.out.println("select Session");
		Select sessn_typ = new Select(Session_Dropdown);
		sessn_typ.selectByVisibleText("May 2022");
		System.out.println("Session is: May 2022");
		return this;
	}

	public AL_Examination_Results_ResultProccessing select_Semester() {
		System.out.println("select Semester");
		Select sem_typ = new Select(Semester_Dropdown);
		sem_typ.selectByVisibleText("IV");
		System.out.println("Semester is: IV");
		return this;
	}

	public AL_Examination_Results_ResultProccessing select_StudentType() {
		System.out.println("select Student Type");
		Select student_typ = new Select(StudentType_Dropdown);
		student_typ.selectByVisibleText("Regular");
		System.out.println("Student Type is: Regular");
		return this;
	}

	public AL_Examination_Results_ResultProccessing click_ShowButton() {
		Show_Button.click();
		System.out.println("Click on Show Button");
		return this;
	}

	public AL_Examination_Results_ResultProccessing Click_UnlockBtn() throws InterruptedException {
		System.out.println("Click on UnLock Btn ");
		unlockbtn.click();
		
		Thread.sleep(10000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Result UnLocked Successfully !!!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		return this;
	}
	
	public AL_Examination_Results_ResultProccessing check_StudentFromList() {
		System.out.println("Check Checkbox");
		StudentList_Checkbox.click();
		return this;
	}

	public AL_Examination_Results_ResultProccessing click_ProcessResult_Button() throws InterruptedException {
		System.out.println("Click on Proccess Result");
		check_StudentFromList();
		Thread.sleep(2000); 
		ProcessResult_Button.click();
		
		Thread.sleep(8000); 
		Alert alert2 =  driver.switchTo().alert();
		String Expected_Msg2 = "Result Processed Successfully!"; 
		String Actual_Msg2 = alert2.getText();
		Assert.assertEquals(Actual_Msg2 , Expected_Msg2 );
		System.out.println("Actual Message - " + Actual_Msg2+ "\n"+ "Expected Message - " + Expected_Msg2);
		alert2.accept();
		return this;
	}

	public AL_Examination_Results_ResultProccessing click_StudentListAll_Checkbox() {
		System.out.println("Check Checkbox");
		StudentListAll_Checkbox.click();
		return this;
	}

	public AL_Examination_Results_ResultProccessing Click_LockBtn() throws InterruptedException {
		System.out.println("Click on Lock btn ");
		Lock_Button.click();
		Thread.sleep(1000);
		acceptAlert();
		Thread.sleep(6000); 
		Alert alert3 =  driver.switchTo().alert();
		String Expected_Msg3 = "Result Locked Successfully !!!!"; 
		String Actual_Msg3 = alert3.getText();
		Assert.assertEquals(Actual_Msg3 , Expected_Msg3 );
		System.out.println("Actual Message - " + Actual_Msg3+ "\n"+ "Expected Message - " + Expected_Msg3);
		alert3.accept();
		return this;
	}

	

	
}
