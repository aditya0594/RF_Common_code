package RFCCAcademic;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_AP_ImportStudentData extends BaseClass
{
	public AL_Academic_AP_ImportStudentData(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[text()='Import Student Data']") private WebElement ImportStudentData;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlAdmBatch") private WebElement admissionBatch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement degree;
	@FindBy(id = "ctl00_ContentPlaceHolder1_FileUpload1") private WebElement choosefile;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnUpload") private WebElement uploadbtn;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_AP_ImportStudentData Click_ImportStudentData() throws InterruptedException {
		System.out.println("Click on Import Student Data");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",ImportStudentData);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", ImportStudentData);
		return this;
	}
	
	public AL_Academic_AP_ImportStudentData Select_AdmissionBatch() throws InterruptedException {
		System.out.println("Select Admission Batch => 2021-22");
		Select select = new Select(admissionBatch);
		select.selectByVisibleText("2024-25");
		return this;
	}
	
	public AL_Academic_AP_ImportStudentData Select_Degree() throws InterruptedException {
		System.out.println("Select Degree ==> Bachelor of Architecture");
		Select select = new Select(degree);
		select.selectByVisibleText("Bachelor of Architecture");
		return this;
	}
	
	public AL_Academic_AP_ImportStudentData Select_ChooseFile() throws InterruptedException {
		System.out.println("Select Choose File and upload excel file");
		Thread.sleep(2000);
        Path relativePath = Paths.get("src\\test\\resources\\Excel\\UploadStudentData_20250123_162720.xlsx");
        String absolutePath = relativePath.toAbsolutePath().toString();
        choosefile.sendKeys(absolutePath);
        Thread.sleep(2000);
        uploadbtn.click();
		return this;
	}
}
