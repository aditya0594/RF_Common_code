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

public class FL_ELearning_Trans_MarkEntryForDescriptiveTest extends BaseClass{

	public FL_ELearning_Trans_MarkEntryForDescriptiveTest(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Mark Entry for Descriptive Test") private WebElement markEntryforDescriptiveTest_link;
	@FindBy(xpath = "//div[@id=\"DataTables_Table_0_filter\"]//input") private WebElement searchbox;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvCheckTest_ctrl0_imgbtnCheckTest") private WebElement check_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvStudent_ctrl0_btnStudCheck") private WebElement edit_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvQuestions_ctrl0_btnQuestion") private WebElement editQuestion_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtRemark") private WebElement remark_textarea;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") private WebElement submit_btn;
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")private WebElement Course;
	@FindBy(xpath = "//button[normalize-space()='OK']")private WebElement SelectCourseClickOk;
	
	public FL_ELearning_Trans_MarkEntryForDescriptiveTest click_markEntryforDescriptiveTest_link() {
		System.out.println("Click on Mark Entry for Descriptive Test Link");
		WebElement menuScroll = driver.findElement(By.className("menuscroll"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menuScroll).perform();

		// Use JavaScript to scroll the menu to the target element
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll inside the menu until the element is visible
		js.executeScript(
				"arguments[0].scrollTop = arguments[1].offsetTop;", 
				menuScroll, 
				markEntryforDescriptiveTest_link
				);

		// Optionally, interact with the target element
		click(markEntryforDescriptiveTest_link);
		//attendanceEmailTrigger_link.click();

		return this;
	}
	public FL_ELearning_Trans_MarkEntryForDescriptiveTest SelectCourseTest() throws Exception {
		System.out.println("Select Course");
		
		WebElement sessn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession"));
		Select typ_sessn = new Select(sessn);
		//typ_sessn.selectByVisibleText("DEC 2018 - Crescent School of Architecture");
		typ_sessn.selectByValue("243");
		Thread.sleep(2000);
		Course.click();
		
		Thread.sleep(2000);
		SelectCourseClickOk.click();
		
		return this;
	}
	public FL_ELearning_Trans_MarkEntryForDescriptiveTest enter_search() {
		System.out.println("Enter searchtext");
		searchbox.sendKeys("Testing");
		return this;
	}
	public FL_ELearning_Trans_MarkEntryForDescriptiveTest click_check_btn() {
		System.out.println("Check checkbox");
		check_btn.click();
		return this;
	}
	public FL_ELearning_Trans_MarkEntryForDescriptiveTest click_edit_btn() {
		System.out.println("Click edit button");
		edit_btn.click();
		return this;
	}
	public FL_ELearning_Trans_MarkEntryForDescriptiveTest click_editQuestion_btn() {
		System.out.println("Click edit question button");
		editQuestion_btn.click();
		return this;
	}
	public FL_ELearning_Trans_MarkEntryForDescriptiveTest enter_remark() {
		System.out.println("Enter remark");
		remark_textarea.clear();
		remark_textarea.sendKeys("Marks Entered");
		return this;
	}
	public FL_ELearning_Trans_MarkEntryForDescriptiveTest click_submit_btn() throws InterruptedException {
		System.out.println("Click submit button");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",submit_btn);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submit_btn);
		
		return this;
	}
	
}
