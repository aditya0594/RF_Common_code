package Hostel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Hostel_HGP_GatePassDirectFinalApprovalFlow2_3_1 extends BaseClass
{

		public AL_Hostel_HGP_GatePassDirectFinalApprovalFlow2_3_1(WebDriver rdriver) {
			driver = rdriver;
			PageFactory.initElements(rdriver, this);
		}

		@FindBy(linkText = "Gate Pass Direct Final Approval") private WebElement GPdirectfinalaproval;
		@FindBy(xpath = "(//input[@class='form-control form-control-sm'])[1]")private WebElement seachfield;
		@FindBy(xpath = "//div[@class='table-responsive']//tbody//tr//td//input[@type='checkbox']")private WebElement checkbox;

		@FindBy(id = "ctl00_ContentPlaceHolder1_ddlremark")private WebElement status;
		@FindBy(id = "ctl00_ContentPlaceHolder1_txtRemark")private WebElement remark;
		@FindBy(id = "ctl00_ContentPlaceHolder1_btnApprove")private WebElement submitbtn;

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		public AL_Hostel_HGP_GatePassDirectFinalApprovalFlow2_3_1 Click_GatePassDirectFinalApproval() {
			System.out.println("Click on Gate Pass Direct Final Approval");
			click(GPdirectfinalaproval);
			return this;
		}
		
		public String getCurrentDate() {
			DateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy"); // dd-MM-yyyy
			Date date = new Date();
			String date1 = dateFormate.format(date);
			return date1;
		}
		
		public AL_Hostel_HGP_GatePassDirectFinalApprovalFlow2_3_1 Search_DateAndClickCheckbox() throws InterruptedException {
			System.out.println("Search Date And Click Check box");
			js.executeScript("arguments[0].scrollIntoView();",seachfield);
			seachfield.sendKeys(getCurrentDate());
			// click on check box
			Thread.sleep(2000);
			checkbox.click();
			return this;
		}
		
		public AL_Hostel_HGP_GatePassDirectFinalApprovalFlow2_3_1 Select_Status() {
			System.out.println("Select Status > Approve");
			Select select = new Select(status);
			select.selectByVisibleText("Approve");
			return this;
		}
		
		public AL_Hostel_HGP_GatePassDirectFinalApprovalFlow2_3_1 Enter_Remark() {
			System.out.println("Enter_Remark > approved");
			sendKeys(remark, "approved by automation");
			return this;
		}
		
		public AL_Hostel_HGP_GatePassDirectFinalApprovalFlow2_3_1 Click_SubmitBtn() {
			System.out.println("Click_SubmitBtn");
			click(submitbtn);
			return this;
		}
		

}
