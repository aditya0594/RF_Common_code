package Administration;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Administration_SRM_Trans_ServiceRegistration extends BaseClass{

	public AL_Administration_SRM_Trans_ServiceRegistration(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	Actions action;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtComplaintDate") private WebElement ServiceRequestDate_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlRMDept") private WebElement Department_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCompNature") private WebElement ServiceRequestType_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtDetails") private WebElement ServiceRequestDetail_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlArea") private WebElement Location_Dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtLocation") private WebElement LocationOfService_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtContactNo") private WebElement ContactNo_Inputbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_FileUpload1") private WebElement FileUpload;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd") private WebElement Add_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") private WebElement Save_Button;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvComplaint_ctrl0_btnDelete") private WebElement Delete_Button;
	

	public AL_Administration_SRM_Trans_ServiceRegistration Select_ServiceRequestDate() {
		js.executeScript("arguments[0].value = arguments[1]",ServiceRequestDate_Dropdown, "22/12/2023");
		System.out.println("Selected Date is:22/12/2023");	
		return this;
	}

	public AL_Administration_SRM_Trans_ServiceRegistration Select_Department() {
		System.out.println("Select service Department");
		Select service_departmnt = new Select(Department_Dropdown);
		service_departmnt.selectByVisibleText("Crescent School of Pharmacy");
		System.out.println("Crescent school of Pharmacy is selected");
		return this;
	}

	public AL_Administration_SRM_Trans_ServiceRegistration Select_ServiceRequestType() {
		System.out.println("Select service Request Type");
		Select ser_RequestType = new Select(ServiceRequestType_Dropdown);
		ser_RequestType.selectByValue("2");
		System.out.println("test is selected");
		return this;
	}

	public AL_Administration_SRM_Trans_ServiceRegistration Enter_ServiceRequestDetails() {
		System.out.println("Enter Service Request Details");
		ServiceRequestDetail_Inputbox.sendKeys("Shortage of Medicine");
		System.out.println("Service request details are:Shortage of Medicine");
		return this;
	}

	public AL_Administration_SRM_Trans_ServiceRegistration Select_Location() {
		System.out.println("Select Location");
		Select typ_loc = new Select(Location_Dropdown);
		typ_loc.selectByVisibleText("Admin block");
		System.out.println("Admin block is selected");
		return this;
	}

	public AL_Administration_SRM_Trans_ServiceRegistration Enter_LocationOfService() {
		System.out.println("Select Location/site of service");
		LocationOfService_Inputbox.sendKeys("Rest Room");
		System.out.println("Rest Room is Entered");
		return this;
	}

	public AL_Administration_SRM_Trans_ServiceRegistration Enter_ContactNo() {
		System.out.println("Enter Contact no");
		ContactNo_Inputbox.sendKeys("7596123658");
		System.out.println("Contact no. is: 7596123658");
		return this;
	}

	public AL_Administration_SRM_Trans_ServiceRegistration Upload_File() {
		System.out.println("Click on Attach File -> File size should not exceed 100 Kb.");
		File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\SampleJPGImage_50kbmb.jpg");
		FileUpload.sendKeys(uploadFile1.getAbsolutePath());
		return this;
	}

	public AL_Administration_SRM_Trans_ServiceRegistration Click_AddButton() {
		System.out.println("Click on Add Button");
		Add_Button.click();
		System.out.println("File selected");
		return this;
	}
	
	public AL_Administration_SRM_Trans_ServiceRegistration Click_SaveButton() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", Save_Button);
		Thread.sleep(2000);
		System.out.println("Click on Submit button");
		Save_Button.click();
		return this;
	}
	
	public AL_Administration_SRM_Trans_ServiceRegistration Click_DeleteButton() throws InterruptedException {
		Delete_Button.click();
		return this;
	}
	


	
}
