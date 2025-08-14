package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_FR_BulkUpdatePaymentType extends BaseClass
{
	public AL_Academic_FR_BulkUpdatePaymentType(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl14_lbLink") private WebElement BulkUpdatePaymentType;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddladmbatch") private WebElement admissionbatch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDegree") private WebElement degree;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBranch") private WebElement programbranch;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvPaymenttype_ctrl0_ddlPaymentType") private WebElement paymenttype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnUpdate") private WebElement updatebtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_FR_BulkUpdatePaymentType Click_BulkUpdatePaymentType() throws InterruptedException {
		System.out.println("Click on Bulk update payment type");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",BulkUpdatePaymentType);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", BulkUpdatePaymentType);
		return this;
	}
	
	public AL_Academic_FR_BulkUpdatePaymentType Select_AdmissionBatch() throws InterruptedException {
		System.out.println("Select Admission Batch ==> 2024-25");
		Select select = new Select(admissionbatch);
		select.selectByVisibleText("2024-25");
		return this;
	}
	
	public AL_Academic_FR_BulkUpdatePaymentType Select_Degree() throws InterruptedException {
		System.out.println("Select Degree ==> Bachelor of Architecture");
		Select select = new Select(degree);
		select.selectByVisibleText("Bachelor of Architecture");
		return this;
	}
	
	public AL_Academic_FR_BulkUpdatePaymentType Select_ProgramBranch() throws InterruptedException {
		System.out.println("Select Programme/Branch ==> Architecture");
		Select select = new Select(programbranch);
		select.selectByVisibleText("Architecture");
		return this;
	}
	
	public AL_Academic_FR_BulkUpdatePaymentType Click_ShowBtn() throws InterruptedException {
		System.out.println("Click on Show btn");
		click(showbtn);
		return this;
	}
	
	public AL_Academic_FR_BulkUpdatePaymentType Select_PaymentType() throws InterruptedException {
		System.out.println("Select on payment type ==> General");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",paymenttype);

		Select select = new Select(paymenttype);
		select.selectByVisibleText("General");
		return this;
	}
	
	public AL_Academic_FR_BulkUpdatePaymentType Click_Updatebtn() throws InterruptedException {
		System.out.println("Click on Update btn");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",updatebtn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", updatebtn);

		return this;
	}
}
