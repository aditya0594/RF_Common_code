package RFCCAcademic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Academic_FR_BulkTransportHSU_SingleStudent extends BaseClass
{
	public AL_Academic_FR_BulkTransportHSU_SingleStudent(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl15_lbLink") private WebElement BulkTransportHostelerStatusUpdation;
	@FindBy(xpath = "//a[contains(text(),'HOSTELLER/TRANSPORTATION STATUS UPDATE FOR SINGLE ')]") private WebElement bulktransportforSingle;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSearchPanel") private WebElement searchcriteria;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDropdown") private WebElement branch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearchPanel") private WebElement search;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudentPanel_ctrl0_lnkIdPanel") private WebElement clickStudent;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudlist_ctrl0_ddlTransport1") private WebElement TransportationStatus;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnsubmit1") private WebElement submitbtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_FR_BulkTransportHSU_SingleStudent Click_BulkTransportHostelerStatusUpdation () throws InterruptedException {
		System.out.println("Bulk Transport/Hosteler Status Updation");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",BulkTransportHostelerStatusUpdation);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", BulkTransportHostelerStatusUpdation);
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_SingleStudent Click_BulkTransportHostelerStatusUpdateSingle () throws InterruptedException {
		System.out.println("Bulk Transport/Hosteler Status Updation =>Single Student");
		click(bulktransportforSingle);
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_SingleStudent Select_SearchCriteria () throws InterruptedException {
		System.out.println("Select Search Criteria==> BRANCH");
		Select select = new Select(searchcriteria);
		select.selectByVisibleText("BRANCH");
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_SingleStudent Select_Branch () throws InterruptedException {
		System.out.println("Select Branch ==> Architecture");
		Select select = new Select(branch);
		select.selectByVisibleText("Architecture");
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_SingleStudent Click_Searchbtn () throws InterruptedException {
		System.out.println("Click on Search btn");
		click(search);
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_SingleStudent Click_Student () throws InterruptedException {
		System.out.println("Click on Student => AADARSHKARTHIK. B");
		click(clickStudent);
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_SingleStudent Select_TransportationStatus () throws InterruptedException {
		System.out.println("Select  Transportation Status => NO");
		click(TransportationStatus);
		return this;
	}
	
	public AL_Academic_FR_BulkTransportHSU_SingleStudent Click_SubmitBtn () throws InterruptedException {
		System.out.println("Click on Submit btn");
		click(submitbtn);
		return this;
	}
}
