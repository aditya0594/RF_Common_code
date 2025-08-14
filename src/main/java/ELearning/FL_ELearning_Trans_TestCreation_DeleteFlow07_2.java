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

public class FL_ELearning_Trans_TestCreation_DeleteFlow07_2 extends BaseClass
{
	public FL_ELearning_Trans_TestCreation_DeleteFlow07_2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "E- LEARNING")
	private WebElement ELearning;

	@FindBy(linkText = "Transactions")
	private WebElement Transactions;

	@FindBy(linkText = "Select Course")
	private WebElement SelectCourse;

	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement SelectCourseClickOk;

	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")
	private WebElement Course;

	@FindBy(linkText = "Test Creation")
	private WebElement TestCreation;
	
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public FL_ELearning_Trans_TestCreation_DeleteFlow07_2 HoverELearningTest() {
		System.out.println("Hover to E-Learning");
		action.moveToElement(ELearning).perform();
		return this;
	}

	public FL_ELearning_Trans_TestCreation_DeleteFlow07_2 ClickTrnasctionTest() {
		System.out.println("Click on Transaction");
		action.moveToElement(Transactions).click().perform();
		return this;
	}

	public FL_ELearning_Trans_TestCreation_DeleteFlow07_2 SelectCourseTest() throws Exception {
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
	
	public FL_ELearning_Trans_TestCreation_DeleteFlow07_2 TestCreation() throws Throwable {
		System.out.println("Click on TestCreation");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", TestCreation);
		Thread.sleep(2000);
		// CreateAssignment.click();
		js.executeScript("arguments[0].click();", TestCreation);
		return this;
	}
	
	public FL_ELearning_Trans_TestCreation_DeleteFlow07_2 Click_Delete_icon() {
		System.out.println("Click on Delete icon");
		WebElement delete = driver.findElement(By.xpath("//input[@alt='Delete Record']"));
		click(delete);
		
		WebElement yes = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnOkDel"));
		click(yes);
		return this;
	}
}
