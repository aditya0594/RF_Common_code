package RFCCAcademic;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.BaseClass;

public class AL_Academic_AP_DocumentSubmission extends BaseClass
{
	public AL_Academic_AP_DocumentSubmission(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Document Submission") private WebElement DocumentSubmission;
	@FindBy(id = "ctl00_ContentPlaceHolder1_rdoRollNo") private WebElement rollno;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtSearchString") private WebElement enterrollno;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement searchbtn;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_fuPhotoUpload") private WebElement choosefilePhoto;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnPhotoUpload") private WebElement uploadbtn1;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_fuSignUpload") private WebElement choosefilesignature;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSignUpload") private WebElement uploadbtn2;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl0_fuFile") private WebElement choosefile12thMarksheet;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl0_btnSubmit") private WebElement uploadbtnMarksheet;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl1_fuFile") private WebElement choosefilesAdharCard;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl1_btnSubmit") private WebElement uploadbtnAdharCard;


	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_AP_DocumentSubmission Click_DocumentSubmission() throws InterruptedException {
		System.out.println("Click on Document Submission");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",DocumentSubmission);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", DocumentSubmission);
		return this;
	}
	
	public AL_Academic_AP_DocumentSubmission Click_RollNoBtn() throws InterruptedException {
		System.out.println("Click on Roll Number Btn");
		click(rollno);
		return this;
	}
	
	public AL_Academic_AP_DocumentSubmission Enter_RollNumber() throws InterruptedException {
		System.out.println("Click on Enrollment Number");
		sendKeys(enterrollno, "21312337");
		return this;
	}
	
	public AL_Academic_AP_DocumentSubmission Click_SearchBtn() throws InterruptedException {
		System.out.println("Click on Search Btn");
		click(searchbtn);
		return this;
	}
	
	
	public AL_Academic_AP_DocumentSubmission Select_ChooseFileForPhoto() throws InterruptedException {
		System.out.println("Select Choose File For Photo");
		Thread.sleep(2000);
		
		File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\MalePic.jpg");
		js.executeScript("arguments[0].scrollIntoView();",choosefilePhoto);
		Thread.sleep(2000);
		choosefilePhoto.sendKeys(uploadFile1.getAbsolutePath());
        Thread.sleep(2000);
        uploadbtn1.click();
        
        threadWait2();
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Photo Uploaded Successfully!!"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
		return this;
	}
	
	public AL_Academic_AP_DocumentSubmission Select_ChooseFileForSignature() throws InterruptedException {
		System.out.println("Select Choose File For Signature");
		Thread.sleep(2000);
		File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\Signature_B.jpg");
		js.executeScript("arguments[0].scrollIntoView();",choosefilesignature);
		Thread.sleep(2000);
		choosefilesignature.sendKeys(uploadFile1.getAbsolutePath());
        Thread.sleep(2000);
        uploadbtn2.click();  
        
        threadWait2();
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Signature Uploaded Successfully!!"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
		return this;
	}
	
	public AL_Academic_AP_DocumentSubmission Upload_12thMarkSheet() throws InterruptedException {
		System.out.println("Upload 12'th Mark Sheet");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",choosefile12thMarksheet);

		File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\HSC_MARKSHEET.jpg");
        choosefile12thMarksheet.sendKeys(uploadFile1.getAbsolutePath());
        Thread.sleep(5000);
        uploadbtnMarksheet.click();
        
        threadWait2();
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
		return this;
	}
	
	public AL_Academic_AP_DocumentSubmission Upload_AdharCard() throws InterruptedException {
		System.out.println("Upload Adhar Card");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",choosefilesAdharCard);
		File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ADHAR_CARD.jpg");
        choosefilesAdharCard.sendKeys(uploadFile1.getAbsolutePath());
        Thread.sleep(5000);
        uploadbtnAdharCard.click();
        
        threadWait2();
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
		return this;
	}
}
