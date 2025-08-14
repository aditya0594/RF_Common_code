package Establishment;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.pages.HomePageAdmin;

import utility.BaseClass;

public class AL_Establishment_Trans_EmployeeServiceBook extends BaseClass{

	public AL_Establishment_Trans_EmployeeServiceBook(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ddlorderby") private WebElement orderBy;
	@FindBy(className = "select2-search__field") private WebElement searchField;
	@FindBy(id = "select2-ctl00_ctl00_ContentPlaceHolder1_ddlEmployee-container") private WebElement employeeName_dropdown;
	@FindBy(linkText = "Personal") private WebElement personal_link;
	@FindBy(linkText = "Document Upload") private WebElement documentUpload_link;
	@FindBy(id = "select2-ctl00_ctl00_ContentPlaceHolder1_sbctp_ddlImageType-container") private WebElement documentType_dropdown;
	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_sbctp_fuUploadImage") private WebElement uploadFile_button;
	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_sbctp_btnUpload") private WebElement upload_btn;
	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_sbctp_btnSubmit") private WebElement submit_button;
	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_sbctp_lvEmpImage_ctrl0_btnDelete") private WebElement delete_button;
	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_sbctp_btnOkDel") private WebElement yesAlert_Button;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public AL_Establishment_Trans_EmployeeServiceBook click_orderBy() {
		System.out.println("Click on Order By -> Name");
//		click(orderBy);
//		searchField.sendKeys("Name", Keys.ENTER);
		
		Select s = new Select(driver.findElement(By.id("ctl00_ctl00_ContentPlaceHolder1_ddlorderby")));
		s.selectByVisibleText("Name");
		return this;
	}
	public AL_Establishment_Trans_EmployeeServiceBook select_employeeName() {
		System.out.println("Employee Name -> 887-Miss samiksha Ashok Dehankar");
		click(employeeName_dropdown);
		searchField.sendKeys("samiksha Ashok Dehankar", Keys.ENTER);
		return this;
	}
	public AL_Establishment_Trans_EmployeeServiceBook click_personal_link() {
		System.out.println("click on Personal -> Document Upload");
		click(personal_link);
		return this;
	}
	public AL_Establishment_Trans_EmployeeServiceBook click_uploadDocument_link() {
		System.out.println("click on Document Upload");
		click(documentUpload_link);
		return this;
	}
	public AL_Establishment_Trans_EmployeeServiceBook select_documentType() {
		System.out.println("click on Document Type");
		click(documentType_dropdown);
		searchField.sendKeys("Demos", Keys.ENTER);
		return this;
	}
	public AL_Establishment_Trans_EmployeeServiceBook upload_photo() {
		System.out.println("File Added added Successfully");
		System.out.println("Upload File");
		String filename = "FemalePic.jpg";
		String path=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"documentsForTesting"+File.separator+filename;
		//FileInputStream file=new FileInputStream(path);
		uploadFile_button.sendKeys(path);
		return this;
	}
	public AL_Establishment_Trans_EmployeeServiceBook click_upload_button() {
		click(upload_btn);
		System.out.println("Click Upload Button");
		return this;
	}
	public AL_Establishment_Trans_EmployeeServiceBook click_submit_button() {
		click(submit_button);
		System.out.println("Click Submit Button");
		return this;
	}
	public AL_Establishment_Trans_EmployeeServiceBook click_delete_btn() {
		js.executeScript("arguments[0].scrollIntoView(true);", delete_button);
		delete_button.sendKeys(Keys.ENTER);
		return this;
	}
	public AL_Establishment_Trans_EmployeeServiceBook click_yesInAlert() {
		click(yesAlert_Button);
		return this;
	}

}
