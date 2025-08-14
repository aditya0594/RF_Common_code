package Examination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Examination_EU_BulkDuesStatusAllotment extends BaseClass
{
	@FindBy(linkText = "EXAMINATION") private WebElement Examination;
	@FindBy(linkText = "Exam Utility") private WebElement exam_utility;
	@FindBy(linkText = "Bulk Dues Status Allotment") private WebElement bulk_due_status;

	
	public AL_Examination_EU_BulkDuesStatusAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Examination_EU_BulkDuesStatusAllotment EXAMINATION() {
		System.out.println("Admin Examination menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Examination).build().perform();
		return this;
	}
	
	public AL_Examination_EU_BulkDuesStatusAllotment Click_ExamUtility() {
		System.out.println("Click on Exam Utility ");
		Actions action = new Actions(driver);
		action.moveToElement(exam_utility).click().build().perform();
		return this;
	}
	
	public AL_Examination_EU_BulkDuesStatusAllotment Click_BulkDuesStatusAllotment() {
		System.out.println("Click on Bulk Dues Status Allotment ");
		Actions action = new Actions(driver);
		action.moveToElement(bulk_due_status).click().build().perform();
		return this;
	}
	
	public AL_Examination_EU_BulkDuesStatusAllotment Select_Session() {
		System.out.println("Select Session => ");
		WebElement session=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select select = new Select(session);
		select.selectByValue("119");
		return this;
	}
	
	public AL_Examination_EU_BulkDuesStatusAllotment Select_SchoolInstituteName() {
		System.out.println("Select School/Institute Name => ");
		WebElement clickSchool=driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlColg-container"));
		clickSchool.click();
		WebElement searchSchool=driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		searchSchool.sendKeys("Crescent School of Architecture",Keys.ENTER);
		
		return this;
	}
	
	
	public AL_Examination_EU_BulkDuesStatusAllotment Click_ShowStudent_btn() {
		System.out.println("Click Show Student btn");
		WebElement stu_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow"));
		click(stu_btn);
		return this;
	}
	
	public AL_Examination_EU_BulkDuesStatusAllotment Click_CheckBox() {
		System.out.println("Click Check Box");
		WebElement chkbox=driver.findElement(By.xpath("//div[@class='dataTables_wrapper dt-bootstrap4 no-footer']//tbody//tr//td//input"));
		click(chkbox);
		return this;
	}
	
	public AL_Examination_EU_BulkDuesStatusAllotment Click_Submitbtn() {
		System.out.println("Click Submit btn");
		WebElement submitbtn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		click(submitbtn);
		return this;
	}
}
