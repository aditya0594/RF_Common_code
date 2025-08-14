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

public class FL_ELearning_Trans_CA_DeleteAssignmentFlow03_3 extends BaseClass
{
	public FL_ELearning_Trans_CA_DeleteAssignmentFlow03_3(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "E- LEARNING") private WebElement ELearning;
	@FindBy(linkText = "Transactions") private WebElement Transactions;
	@FindBy(linkText = "Select Course") private WebElement SelectCourse;
	@FindBy(xpath = "//button[normalize-space()='OK']") private WebElement SelectCourseClickOk;
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect") private WebElement Course;
	@FindBy(linkText = "Create Assignment") private WebElement CreateAssignment;
	@FindBy(xpath = "//input[@title='Delete Record']") private WebElement deleteIcon;

	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	
	public FL_ELearning_Trans_CA_DeleteAssignmentFlow03_3 Click_Transaction() {
		System.out.println("Click on Transaction");
		action.moveToElement(Transactions).click().perform();
		return this;
	}
	
	public FL_ELearning_Trans_CA_DeleteAssignmentFlow03_3 Select_Course() throws Exception {
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
	
	public FL_ELearning_Trans_CA_DeleteAssignmentFlow03_3 Click_CreateAssignment() throws Throwable {
		System.out.println("Click on Create Assignment");
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", CreateAssignment);
		Thread.sleep(2000);
		//CreateAssignment.click();
		js.executeScript("arguments[0].click();", CreateAssignment);	
		return this;
	}
	
	public FL_ELearning_Trans_CA_DeleteAssignmentFlow03_3 Click_DeleteIcon() throws Throwable {
		System.out.println("Click Delete Icon");
		WebElement down = driver.findElement(By.xpath("(//h5[normalize-space()='Assignment List'])[1]"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", down);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", deleteIcon);
		WebElement yes_btn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnOkDel"));
		click(yes_btn);
		Thread.sleep(2000);
		
		return this;
	}
	
	
}
