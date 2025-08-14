package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FR_BulkTransportHSU_BulkStudent extends BaseClass
{
	public AL_Academic_FR_BulkTransportHSU_BulkStudent(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl15_lbLink") private WebElement BulkTransportHostelerStatusUpdation;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlColg") private WebElement schoolInstitute;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAdmbatch") private WebElement admissionbatch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement degree;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranch") private WebElement programbatch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlYear") private WebElement admissionyear;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSemester") private WebElement semister;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlGender") private WebElement gender;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showStudent;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddtransportstatus") private WebElement transportationstatus;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlhosteller") private WebElement hostellerstatus;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlHosteltypes") private WebElement hostellertype;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudentRecords_chkIdentityCard") private WebElement chkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitbtn;



	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Click_BulkTransportHostelerStatusUpdation () throws InterruptedException {
		System.out.println("Bulk Transport/Hosteler Status Updation =>Bulk Student");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",BulkTransportHostelerStatusUpdation);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", BulkTransportHostelerStatusUpdation);
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Select_SchoolInstitute () throws InterruptedException {
		System.out.println("Select School Institute==> Crescent School of Architecture");
		Select select = new Select(schoolInstitute);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Select_AdmissionBatch () throws InterruptedException {
		System.out.println("Select Admission Batch ==> 2023-24");
		Select select = new Select(admissionbatch);
		select.selectByVisibleText("2023-24");
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Select_Degree () throws InterruptedException {
		System.out.println("Select Degree ==> Bachelor of Architecture");
		Select select = new Select(degree);
		select.selectByVisibleText("Bachelor of Architecture");
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Select_ProgramBatch () throws InterruptedException {
		System.out.println("Select Program Batch ==> Architecture");
		Select select = new Select(programbatch);
		select.selectByVisibleText("Architecture");
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Select_AdmissionYear () throws InterruptedException {
		System.out.println("Select Admission Year ==> Architecture");
		Select select = new Select(admissionyear);
		select.selectByVisibleText("First Year");
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Select_Semister () throws InterruptedException {
		System.out.println("Select Semister ==> First Semester");
		Select select = new Select(semister);
		select.selectByVisibleText("First Semester");
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Select_Gender () throws InterruptedException {
		System.out.println("Select Gender ==> Both");
		Select select = new Select(gender);
		select.selectByVisibleText("Both");
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Click_Showbtn () throws InterruptedException {
		System.out.println("Click on show btn");
		click(showStudent);
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Select_TransportationStatus () throws InterruptedException {
		System.out.println("Select Transportation Status ==> Yes");
		Select select = new Select(transportationstatus);
		select.selectByVisibleText("Yes");
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Select_HostellerStatus () throws InterruptedException {
		System.out.println("Select Hosteller Status ==> Yes");
		Select select = new Select(hostellerstatus);
		select.selectByVisibleText("Yes");
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Select_HostellerType () throws InterruptedException {
		System.out.println("Select Hosteller Type ==> REGULAR");
		Select select = new Select(hostellertype);
		select.selectByValue("1");
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Click_CheckBoxbtn () throws InterruptedException {
		System.out.println("Click on Check box");
		click(chkbox);
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_BulkStudent Click_Submitbtn () throws InterruptedException {
		System.out.println("Click on Submit box");
		click(submitbtn);
		return this;
	}
}
