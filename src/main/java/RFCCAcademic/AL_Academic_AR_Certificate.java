package RFCCAcademic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_AR_Certificate extends BaseClass
{
	public AL_Academic_AR_Certificate(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Certificate") private WebElement certificateLink;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlAdmBatch-container") private WebElement admissionBatchDropdown;
	@FindBy(xpath = "//input[@role='textbox']") private WebElement searchadmissionBatchDropdown;

	
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlDegree-container") private WebElement degreeDropdown;
	@FindBy(xpath = "//input[@role='textbox']") private WebElement searchdegreeDropdown;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlBranch-container") private WebElement programDropdown;
	@FindBy(xpath = "//input[@role='textbox']") private WebElement searchprogramDropdown;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlCert-container") private WebElement certificateNameDropdown;
	@FindBy(xpath = "//input[@role='textbox']") private WebElement searchcertificateNameDropdown;

	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSemester-container") private WebElement semisterdropdown;
	@FindBy(xpath = "//input[@role='textbox']") private WebElement searchsemisterdropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShowData") private WebElement showButton;
	@FindBy(xpath = "//div[@class='table-responsive']//tr/td//input") private WebElement checkBox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnConfirm_BC") private WebElement confirmButton;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	

	public AL_Academic_AR_Certificate Click_Certificate() throws InterruptedException {
		System.out.println("Click on Certificate");
		js.executeScript("arguments[0].scrollIntoView();", certificateLink);

		threadWait1();
		js.executeScript("arguments[0].click();", certificateLink);
		return this;
	}
	

	public AL_Academic_AR_Certificate Select_AdmissionBatch() throws InterruptedException {
		System.out.println("Select Admission Batch ==> 2021-22");
		admissionBatchDropdown.click();
		searchadmissionBatchDropdown.sendKeys("2021-22");
		searchadmissionBatchDropdown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Academic_AR_Certificate Select_Degree() throws InterruptedException {
		System.out.println("Select Degree ==> Bachelor of Architecture");
		degreeDropdown.click();
		searchdegreeDropdown.sendKeys("Bachelor of Architecture");
		searchdegreeDropdown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Academic_AR_Certificate Select_Program() throws InterruptedException {
		System.out.println("Select Program ==> Architecture");
		programDropdown.click();
		searchprogramDropdown.sendKeys("Architecture");
		searchprogramDropdown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Academic_AR_Certificate Select_CertificateName() throws InterruptedException {
		System.out.println("Select Certificate Name ==> Bonafide Certificate");
		certificateNameDropdown.click();
		searchcertificateNameDropdown.sendKeys("Bonafide Certificate");
		searchcertificateNameDropdown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Academic_AR_Certificate Select_Semister() throws InterruptedException {
		System.out.println("Select Semister ==> II");
		semisterdropdown.click();
		searchsemisterdropdown.sendKeys("II");
		searchsemisterdropdown.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Academic_AR_Certificate Click_ShowButton() throws InterruptedException {
		System.out.println("Click on Show Button");
		js.executeScript("arguments[0].scrollIntoView();", showButton);

		threadWait1();
		js.executeScript("arguments[0].click();", showButton);
		return this;
	}
	
	public AL_Academic_AR_Certificate Click_CheckBox() throws InterruptedException {
		System.out.println("Click on Check Box");
		js.executeScript("arguments[0].scrollIntoView();", checkBox);
		js.executeScript("arguments[0].click();", checkBox);
		return this;
	}
	
	public AL_Academic_AR_Certificate Click_ConfirmButton() throws InterruptedException {
		System.out.println("Click on Confirm Button");
		js.executeScript("arguments[0].scrollIntoView();", confirmButton);
		js.executeScript("arguments[0].click();", confirmButton);
		return this;
	}
}
