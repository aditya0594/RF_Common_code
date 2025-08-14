package RFCCAcademic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Academic_AP_AdmissionApproval extends BaseClass 
{
	public AL_Academic_AP_AdmissionApproval(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[text()='Admission Approval']") private WebElement AdmissionApproval;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAdmbatch") private WebElement AdmissionBatch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClg") private WebElement SchoolInstitute;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStatus") private WebElement  Status;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showstudentbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement documentstatusreportbtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_AP_AdmissionApproval Click_AdmissionApproval() throws InterruptedException {
		System.out.println("Click on Admission Approval");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",AdmissionApproval);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", AdmissionApproval);
		return this;
	}
	
	public AL_Academic_AP_AdmissionApproval Select_AdmissionBatch() throws InterruptedException {
		System.out.println("Select Admission Batch ==> 2023-24");
		Select select = new Select(AdmissionBatch);
		select.selectByVisibleText("2021-22");
		return this;
	}
	
	public AL_Academic_AP_AdmissionApproval Select_SchoolInstitute() throws InterruptedException {
		System.out.println("Select School/Institute ==> Crescent School of Architecture - Chennai");
		Select select = new Select(SchoolInstitute);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Academic_AP_AdmissionApproval Select_Status() throws InterruptedException {
		System.out.println("Select Status ==> Approved");
		Select select = new Select(Status);
		select.selectByVisibleText("Approved");
		return this;
	}
	
	public AL_Academic_AP_AdmissionApproval Select_Showbtn() throws InterruptedException {
		System.out.println("Click on Show btn");
		click(showstudentbtn);
		return this;
	}
	
	public AL_Academic_AP_AdmissionApproval Verify_Content() throws InterruptedException {
		System.out.println("Verify Student name is display or not");
		WebElement name = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudentDetail_ctrl0_hlkstudentdetail"));
		String ActMsg = name.getText();
		String ExpMsg = "ABIRAMI. R";
		Assert.assertEquals(ActMsg, ExpMsg);
		System.out.println("Actual Message - " + ActMsg+ "\n"+ "Expected Message - " + ExpMsg);
		return this;
	}
	
	public AL_Academic_AP_AdmissionApproval Click_DocumentStatusReport() throws InterruptedException {
		System.out.println("Click on Document Status Report btn");
		click(documentstatusreportbtn);
		return this;
	}
	
}
