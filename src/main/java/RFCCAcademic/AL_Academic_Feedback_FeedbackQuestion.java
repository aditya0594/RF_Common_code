package RFCCAcademic;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Academic_Feedback_FeedbackQuestion extends BaseClass{

	public AL_Academic_Feedback_FeedbackQuestion(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	Actions action = new Actions(driver);
	;
	@FindBy(linkText = "Feedback Question")
	private WebElement Feedback_Question_Link;

	@FindBy(xpath = "//span[@aria-labelledby='select2-ctl00_ContentPlaceHolder1_ddlCT-container']")
	private WebElement Feedback_Type_Dropdown;

	@FindBy(className = "select2-search__field")
	private WebElement Searchbox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtQuestion")
	private WebElement Feedback_Question_Textarea;

	@FindBy(xpath = "//span[@aria-labelledby='select2-ctl00_ContentPlaceHolder1_ddlAnsoption-container']")
	private WebElement Ans_Otion_Type_Dropdown;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtseqno")
	private WebElement Sequence_Number_Textbox;

	@FindBy(id = "ctl00_ContentPlaceHolder1_chkActiveStatus")
	private WebElement Active_Status_Checkbox;

	@FindBy(xpath = "//input[@title='Edit Record']")
	private WebElement editbtn;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement Submit_Button;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement updateBtn;
	

	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement answeroption3;


	public AL_Academic_Feedback_FeedbackQuestion click_Feedback_Question() {
		WebElement subMenu = driver.findElement(By.linkText("Feedback Question"));
		System.out.println("Click on Feedback Question from sub menu");
		action.moveToElement(subMenu);
		action.click().build().perform();
		return this;
	}
	public AL_Academic_Feedback_FeedbackQuestion select_Feedback_Type() {
		Feedback_Type_Dropdown.click();
		Searchbox.sendKeys("Practical course Feedback", Keys.ENTER);
		System.out.println("Select Feedback Type - Practical course Feedback");
		return this;
	}
	
//	public AL_Academic_Feedback_FeedbackQuestion enter_Feedback_Question() {
//		 String uniqueTestName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(0));
//		Feedback_Question_Textarea.sendKeys("Which activities in the classroom do you enjoy the most?"+uniqueTestName);
//		System.out.println("Enter Feedback Question");
//		return this;
//	}
//	
//	public AL_Academic_Feedback_FeedbackQuestion Select_Answer_Option_Type() throws InterruptedException {
//		Ans_Otion_Type_Dropdown.click();
//		Thread.sleep(2000);
//		Searchbox.sendKeys("Descriptive", Keys.ENTER);
//		System.out.println("Select Answer option type - Descriptive");
//		return this;
//	}
//	
	
//	public AL_Academic_Feedback_FeedbackQuestion enter_Sequence_Number() throws InterruptedException {
//		 String uniqueTestName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(0));
//		 	Thread.sleep(5000);
//		 	Sequence_Number_Textbox.clear();
//		 	Sequence_Number_Textbox.sendKeys(uniqueTestName);
////		Sequence_Number_Textbox.sendKeys(String.of);
//		System.out.println("Enter Sequence number - 56");
//		return this;
//	}
//	public AL_Academic_Feedback_FeedbackQuestion check_Active_Status_Checkbox() {
//		if(!Active_Status_Checkbox.isSelected()==true)
//		{
//			Active_Status_Checkbox.click();
//			System.out.println("Check on Active Status Checkbox");
//		}
//		return this;
//	}
//	public AL_Academic_Feedback_FeedbackQuestion check_CheckForMandatory_Checkbox() {
//		if(!CheckForMandatory_Checkbox.isSelected() == true )
//		{
//			CheckForMandatory_Checkbox.click();
//			System.out.println("Check on Mandatory Checkbox");
//		}
//
//		return this;
//	}
	
	public AL_Academic_Feedback_FeedbackQuestion click_EditButton() throws InterruptedException {
		System.out.println("click on Edit Button");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",Submit_Button);
		Thread.sleep(2000);
		editbtn.click();
		return this;
	}
	
	public AL_Academic_Feedback_FeedbackQuestion click_Submit_Button() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",updateBtn);
		Thread.sleep(2000);
		updateBtn.click();
		return this;
	}

}
