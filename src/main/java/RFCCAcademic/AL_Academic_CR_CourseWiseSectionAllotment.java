package RFCCAcademic;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;
import utility.ExcelFileValidator;
import utility.SearchExcelFile;

public class AL_Academic_CR_CourseWiseSectionAllotment extends BaseClass
{
	public AL_Academic_CR_CourseWiseSectionAllotment(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Course Wise Section allotment") private WebElement CourseWiseSectionAllotment;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlCourse-container") private WebElement courseSelect;
	@FindBy(xpath = "//input[@class='select2-search__field']") private WebElement courseSearch;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showStudentbtn;
	@FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSection-container") private WebElement sectionSelect;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection") private WebElement sectionSearch;

	@FindBy(xpath = "//div[@class='table-responsive']//tbody//input") private WebElement chkbox;
	@FindBy(xpath = "//input[@id='FilterData']") private WebElement searchstu;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submitbtn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportbtn;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_CR_CourseWiseSectionAllotment Click_CourseWiseSectionAllotment() throws InterruptedException {
		System.out.println("Click on Course Wise Section Allotment");
		Thread.sleep(2000);

		js.executeScript("arguments[0].scrollIntoView();",CourseWiseSectionAllotment);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", CourseWiseSectionAllotment);
		return this;
	}
	
	public AL_Academic_CR_CourseWiseSectionAllotment Select_Session() throws InterruptedException {
		System.out.println("Select Session => Mar 2023");
		Select select = new Select(session);
		select.selectByVisibleText("Mar 2023");
		return this;
	}
	
	public AL_Academic_CR_CourseWiseSectionAllotment Select_Course() throws InterruptedException {
		System.out.println("Select Course => CSC 2101 - Data Structures");
		courseSelect.click();
		courseSearch.sendKeys("CSC 2101 - Data Structures");
		courseSearch.sendKeys(Keys.ENTER);
		return this;
	}
	
	public AL_Academic_CR_CourseWiseSectionAllotment Click_ShowStudentBtn() throws InterruptedException {
		System.out.println("Click on Show student btn");
		click(showStudentbtn);
		return this;
	}
	
	public AL_Academic_CR_CourseWiseSectionAllotment Select_Section() throws InterruptedException {
		System.out.println("Select Section => A");
		Select select = new Select(sectionSearch);
		select.selectByVisibleText("A");
		return this;
	}
	
	
	public AL_Academic_CR_CourseWiseSectionAllotment Click_CheckBox() throws InterruptedException {
		System.out.println("Search student -> 'YUVAN'  and click on Check Box");
		sendKeys(searchstu, "YUVAN");
		threadWait1();
		click(chkbox);
		return this;
	}
	
	public AL_Academic_CR_CourseWiseSectionAllotment Click_SubmitBtn() throws InterruptedException {
		System.out.println("Click on Submit Btn");
		click(submitbtn);
		
//		Thread.sleep(2000); 
//		Alert alert =  driver.switchTo().alert();
//		String Expected_Msg = "Are you sure you want to proceed? Attendance has already been recorded for the selected students.";
//		String Actual_Msg = alert.getText();
//		Assert.assertEquals(Actual_Msg , Expected_Msg );
//		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
//		alert.accept();
		return this;
	}
	
	public AL_Academic_CR_CourseWiseSectionAllotment Click_ReportExcel() throws InterruptedException {
		System.out.println("Click on Report(Excel) Btn");
		click(reportbtn);
		return this;
	}
	
}
