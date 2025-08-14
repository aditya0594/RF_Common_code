package ELearning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.pages.HomePageFaculty;

import utility.BaseClass;

public class FL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6 extends BaseClass{

	public FL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl00_lbLink") private WebElement selectCourse_Link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect") private WebElement course_link;
	@FindBy(xpath = "//button[normalize-space()='OK']") private WebElement ok_button;
	@FindBy(linkText = "Create Syllabus") private WebElement createSyllabus_Link;

	
	public FL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6 click_selectCourse_Link() {
		System.out.println("Click on Select Course from submenu");
		Actions action = new Actions(driver);
		action.moveToElement(selectCourse_Link);
		action.click().build().perform();
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6 select_Session() {
		System.out.println("Select Session -> May 2022 - School of Social Sciences and Humanities");
		Select colg_typ = new Select(session_dropdown);
		colg_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6 click_Course() {
		System.out.println("Select Course");
		click(course_link);
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6 click_ok_Btn() {
		System.out.println("Click OK Button");
		click(ok_button);
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6 click_createSyllabus_Link() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		System.out.println("Create Syllabus submenu selected");
		js.executeScript("arguments[0].scrollIntoView();",createSyllabus_Link);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", createSyllabus_Link);
		return this;
	}
	public FL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6 search_txt() throws InterruptedException {
	//search date to delete syllabus
	
			Thread.sleep(2000);
			System.out.println("Search => COC 3201 - Income Tax Law & Practice - II - [B.Com. - GEN]");
			WebElement searchBox = driver.findElement(By.xpath("(//input[@class='form-control form-control-sm'])[1]"));
			searchBox.sendKeys("COC 3201 - Income Tax Law & Practice - II - [B.Com. - GEN]");
			return this;
	}
	public FL_ELearning_Trans_CreateSyllabus_DeleteFlow02_6 delete_record() throws InterruptedException {
	// Click on delete Icon
			Thread.sleep(2000);
			System.out.println("Click on Delete Icon");
			WebElement deleteIcon = driver.findElement(By.xpath("//input[@title='Delete Record']"));
			deleteIcon.click();
			
			// yes btn
			Thread.sleep(2000);
			System.out.println("Click yes btn");
			WebElement yesbtn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnOkDel"));
			yesbtn.click();
			return this;
	}
}
