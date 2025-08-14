package ELearning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class FL_ELearning_Trans_CreateAssignmentFlow03_1 extends BaseClass{

	public FL_ELearning_Trans_CreateAssignmentFlow03_1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "E- LEARNING") private WebElement ELearning;
	@FindBy(linkText = "Transactions") private WebElement Transactions;
	@FindBy(linkText = "Select Course") private WebElement SelectCourse;
	@FindBy(xpath = "//button[normalize-space()='OK']") private WebElement SelectCourseClickOk;
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect") private WebElement Course;
	@FindBy(linkText = "Create Assignment") private WebElement CreateAssignment;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTopic") private WebElement  AssignmentTopic;

	@FindBy(className  = "cke_show_borders") private WebElement Description;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtsubfromdate") private WebElement SubmittionFromDate;
	@FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_txtsubfromtime'])[1]") private WebElement SubmittionFromTime;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtDueDate") private WebElement dueDate;
	@FindBy(xpath = "(//input[@id='ctl00_ContentPlaceHolder1_txtduetime'])[1]") private WebElement dueTime;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtAMarks") private WebElement  AssignmentMarks;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddldoc") private WebElement  AssignmentType;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRdate") private WebElement  remindDate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRtime") private WebElement  remindTime;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_cbHead") private WebElement  checkbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnViewAssignment") private WebElement  AssingmentReport;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement Submit;
	
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Hover_ELearning() {
		System.out.println("Hover to E-Learning");
		action.moveToElement(ELearning).perform();
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Click_Transaction() {
		System.out.println("Click on Transaction");
		action.moveToElement(Transactions).click().perform();
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Select_Course() throws Exception {
		System.out.println("Select Course");
		
		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select typ_sessn = new Select(sessn);
		typ_sessn.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		Thread.sleep(2000);
		Course.click();
		Thread.sleep(2000);
		SelectCourseClickOk.click();	
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Click_CreateAssignment() throws Throwable {
		System.out.println("Click on Create Assignment");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", CreateAssignment);
		Thread.sleep(2000);
		//CreateAssignment.click();
		js.executeScript("arguments[0].click();", CreateAssignment);	
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Enter_AssignmentTopic() throws Throwable {
		System.out.println("Enter Assignment Topic");
/*		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", AssignmentTopic);
*/		Thread.sleep(2000);
		sendKeys(AssignmentTopic, "Automation Test 1");
		return this;
	}
		
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Enter_AssignmenetDescription() throws Throwable {
		System.out.println("Enter Description");
		switchToFrame(2);
		System.out.println("Inside Frame");
		Description.clear();
		Description.sendKeys("Write 10-12 lines on Selenium topic?");	
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("Outside Frame");	
//		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//label[normalize-space()='Description'])[1]")));
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Set_SubmissionFromDate() throws Throwable {
		System.out.println("Set  Submission From Date ==> 01/12/2026");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", SubmittionFromDate);
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]",SubmittionFromDate, "01/12/2026");
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Set_SubmissionFromtime() throws Throwable {
		System.out.println("Set  Submission From Time ==> 11:00:00");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", SubmittionFromTime);
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]",SubmittionFromTime, "11:00:00");
		sendKeys(SubmittionFromTime, "11:00:00");
		Thread.sleep(2000);
		return this;
	}
		
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Set_DueDate() throws Throwable {
		System.out.println("Set Due Date ==> 07/12/2026");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", dueDate);
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]",dueDate, "07/12/2026");
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Set_DueTime() throws Throwable {
		System.out.println("Set Due Time ==> 17:00:00");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", dueTime);
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]",dueTime, "17:00:00");
		sendKeys(dueTime, "17:00:00");
		Thread.sleep(2000);
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Enter_AssignmentMarks() throws Throwable {
		System.out.println("Enter Assignment Marks");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", AssignmentMarks);
		Thread.sleep(2000);
		sendKeys(AssignmentMarks, "30");
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Select_AssignmentType() throws Throwable {
		System.out.println("Select Assignment Type");
		Thread.sleep(2000);
		Select select = new Select(AssignmentType);
		select.selectByVisibleText("Description based");
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Set_RemindDate() throws Throwable {
		System.out.println("Set  Remind Date ==> 09/12/2026");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", remindDate);
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]",remindDate, "06/12/2026");
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Set_RemindTime() throws Throwable {
		System.out.println("Set Remind Time ==> 17:00:00");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", remindTime);
		Thread.sleep(2000);
		js.executeScript("arguments[0].value = arguments[1]",remindTime, "17:00:00");
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Click_CheckBox() throws Throwable {
		System.out.println("Click On Check Box");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", checkbox);	
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", checkbox);
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Click_SubmitButton() throws Throwable {
		System.out.println("Click On Submit Button");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", Submit);	
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", Submit);
		return this;
	}
	
	public FL_ELearning_Trans_CreateAssignmentFlow03_1 Click_AssingmentReport() throws Throwable {
		System.out.println("Click On Submit Button");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", AssingmentReport);	
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", AssingmentReport);
		return this;
	}
	
}
